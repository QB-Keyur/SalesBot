package Utils;

import com.github.javafaker.Faker;
import com.google.gson.*;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


/**
 * Define Common Web driver
 *
 * @author whimstay
 */
public class Common extends Locators {
    private static final Logger log = LoggerFactory.getLogger(Common.class);

//	protected static WebDriver driver;

    public Common(WebDriver driver) {

        super(driver);
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebDriverWait getWait(long time) {
        // Set time in second to wait for elements
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public WebElement waitUntilElementToBeClickable(By by) {

        try {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

        } catch (StaleElementReferenceException e) {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));
        }
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        try {
            getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementToBeClickable(String locator) {
        final int maxAttempts = 3;
        final long pollingMillis = 500; // adjust if you need faster/slower polling
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                WebDriverWait wait = (WebDriverWait) getWait()
                        .pollingEvery(Duration.ofMillis(pollingMillis))
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(NoSuchElementException.class)
                        .ignoring(ElementClickInterceptedException.class);

                // Wait for element to be clickable and return it
                return wait.until(ExpectedConditions.elementToBeClickable(findBy(locator)));

            } catch (StaleElementReferenceException | ElementClickInterceptedException ex) {
                attempts++;
                safeLog("WARN :: Attempt " + attempts + " - transient exception while waiting for clickable: " + ex.getClass().getSimpleName() + " - " + locator);
                // small pause before retry
                safePause(200);
                // loop will retry
            } catch (TimeoutException te) {
                attempts++;
                safeLog("WARN :: Attempt " + attempts + " - timeout waiting for clickable: " + locator);
                if (attempts >= maxAttempts) {
                    // rethrow with helpful message (preserve cause)
                    throw new TimeoutException("Timed out after " + attempts + " attempts waiting for element to be clickable: " + locator, te);
                }
                safePause(300);
            } catch (NoSuchElementException nse) {
                // This is unlikely because we already ignore NoSuchElement in wait, but keep defensive handling
                attempts++;
                safeLog("WARN :: Attempt " + attempts + " - NoSuchElementException for locator: " + locator);
                safePause(300);
            } catch (Exception e) {
                // For any unexpected exceptions, rethrow so callers can handle it
                throw new RuntimeException("Unexpected error while waiting for clickable element: " + locator, e);
            }
        }

        // Should never reach here due to throws above, but keep a defensive fail
        throw new RuntimeException("Unable to locate clickable element after retries: " + locator);
    }

    /* ---------- helper methods used above ---------- */

    private void safeLog(String message) {
        try {
            // If you have a common logger, use it
            common.logPrint(message);
        } catch (Exception ignored) {
            System.out.println(message);
        }
    }

    private void safePause(long millis) {
        try {
            // if common.pause exists use it
            common.pause((int) millis);
        } catch (Exception e) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }


    /**
     * Wait until the app is "ready" — DOM complete + no active XHR/fetch + jQuery finished (if present).
     * This method will not hang: it returns after timeoutSeconds even if not stable, and logs debug info.
     *
     * @param timeoutSeconds maximum seconds to wait before returning
     */
    public void waitForAppReady(int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long end = System.currentTimeMillis() + timeoutSeconds * 1000L;
        final int stableRequired = 3;        // require N consecutive stable polls
        final long pollIntervalMs = 250L;    // poll every 250ms
        int stableCount = 0;

        // 1) Inject instrumentation for XHR and fetch once
        try {
            String inject = "if (window.__webdriver_activeRequests === undefined) {" +
                    "  window.__webdriver_activeRequests = 0;" +
                    "  (function() {" +
                    "    try {" +
                    "      var origOpen = XMLHttpRequest.prototype.open;" +
                    "      var origSend = XMLHttpRequest.prototype.send;" +
                    "      XMLHttpRequest.prototype.open = function() { origOpen.apply(this, arguments); };" +
                    "      XMLHttpRequest.prototype.send = function() {" +
                    "        try { window.__webdriver_activeRequests++; } catch(e) {}" +
                    "        var that = this;" +
                    "        var onreadystatechange = that.onreadystatechange;" +
                    "        that.onreadystatechange = function() {" +
                    "          try { if (that.readyState === 4) { window.__webdriver_activeRequests--; } } catch(e) {}" +
                    "          if (onreadystatechange) { onreadystatechange.apply(that, arguments); }" +
                    "        };" +
                    "        try { origSend.apply(that, arguments); } catch(e) { try { window.__webdriver_activeRequests--; } catch(ignore) {} throw e; }" +
                    "      };" +
                    "    } catch(e) { /* older browsers */ }" +
                    "    try {" +
                    "      if (window.fetch) {" +
                    "        var origFetch = window.fetch;" +
                    "        window.fetch = function() {" +
                    "          try { window.__webdriver_activeRequests++; } catch(e) {}" +
                    "          return origFetch.apply(this, arguments).finally(function() { try { window.__webdriver_activeRequests--; } catch(e) {} });" +
                    "        }" +
                    "      }" +
                    "    } catch(e) { /* ignore */ }" +
                    "  })();" +
                    "}";
            js.executeScript(inject);
        } catch (Exception e) {
            // instrumentation failed — we still continue but won't be able to detect fetch/xhr reliably
            common.logPrint("waitForAppReady: instrumentation injection failed: " + e.getMessage());
        }

        // 2) Poll until stable or timeout
        while (System.currentTimeMillis() < end) {
            try {
                // return object with three fields
                String script =
                        "return {" +
                                " readyState: document.readyState || ''," +
                                " jqueryActive: (window.jQuery ? window.jQuery.active : 0)," +
                                " activeRequests: (window.__webdriver_activeRequests || 0)" +
                                "};";

                @SuppressWarnings("unchecked")
                Map<String, Object> status = (Map<String, Object>) js.executeScript(script);

                String readyState = (status.get("readyState") != null) ? status.get("readyState").toString() : "";
                long jqueryActive = 0;
                long activeRequests = 0;

                try {
                    jqueryActive = status.get("jqueryActive") instanceof Long ?
                            (Long) status.get("jqueryActive") :
                            Long.parseLong(status.get("jqueryActive").toString());
                } catch (Exception ignore) {}

                try {
                    activeRequests = status.get("activeRequests") instanceof Long ?
                            (Long) status.get("activeRequests") :
                            Long.parseLong(status.get("activeRequests").toString());
                } catch (Exception ignore) {}

                boolean docReady = "complete".equalsIgnoreCase(readyState);
                boolean networkIdle = (activeRequests == 0);
                boolean jqueryIdle = (jqueryActive == 0);

                // Debug logging — helpful when timeout occurs
                common.logPrint(String.format("waitForAppReady: readyState=%s, activeRequests=%d, jqueryActive=%d, stableCount=%d",
                        readyState, activeRequests, jqueryActive, stableCount));

                if (docReady && networkIdle && jqueryIdle) {
                    stableCount++;
                    if (stableCount >= stableRequired) {
                        // short buffer to let UI finalise
                        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                        common.logPrint("waitForAppReady: page stable and ready.");
                        return;
                    }
                } else {
                    stableCount = 0; // reset consecutive stability
                }
            } catch (Exception ex) {
                // JS execution can fail intermittently — log and continue polling until timeout
                common.logPrint("waitForAppReady: polling script error: " + ex.getMessage());
                stableCount = 0;
            }

            try {
                Thread.sleep(pollIntervalMs);
            } catch (InterruptedException ignored) {}
        }

        // Timeout reached — don't hang. Log helpful diagnostics.
        common.logPrint("waitForAppReady: TIMEOUT after " + timeoutSeconds + "s. Proceeding anyway.");
        // Optionally: you can take a screenshot here for debugging
    }


    public WebElement waitUntilStringLocator(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(findBy(locator)));
    }

    public WebElement waitUntilStringLocatorAsaElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitUntilInvisible(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return getWait(150).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(findElement(locator)));
    }

    public Boolean waitUntilElementToBeInvisible(WebElement element) {
        return getWait(150).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(element));
    }

    public List<WebElement> waitUntilElementsToBeVisible(By by) {
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public String removeZero (String input){
        input = input.indexOf(".") < 0 ? input : input.replaceAll("0*$", "").replaceAll("\\.$", "");
        return input;
    }

    /**
     * Check alert is present or not and accept it if present.
     *
     * @return Text on alert if present, otherwise null
     */
    public String handleAlert() {
        String strAltert = null;
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            strAltert = alert.getText();
            alert.accept();
            pause(2);
        }
        return strAltert;
    }

    /**
     * Check alert is present or not.
     *
     * @return True if alert present, otherwise false
     */
    public boolean isAlertPresent() {
        pause(1);
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public String current_window;

    public void switchToSecondWindow() {
        try {
            current_window = this.driver.getWindowHandle();
            Set<String> allwindows = this.driver.getWindowHandles();
            int i = 0;
            for (String s : allwindows) {
                i = i + 1;
                if (i == 2) {
                    this.driver.switchTo().window(s);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void  switch_windows(Set<String>  windowHandles, String title){
        // Iterate through the window handles
        for (String windowHandle : windowHandles) {
            // Switch to the window handle
            driver.switchTo().window(windowHandle);

            // Check the window title
            String windowTitle = driver.getTitle();

            // If the window title matches "Plaid flow", break the loop and stay in this window
            if (windowTitle.equals(title)) {
                common.logPrint("Switched to window with title: " + windowTitle);
                break;
            }
        }

    }

    public void switchToTab(int n){

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(n));
    }

    public void waitUntilSpecificTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void mouseOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform(); // Moves the cursor to the element
    }

    public void switchToWindow(int n) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles()); // "windows" instead of "tabs"
        driver.switchTo().window(windows.get(n));
    }
    /**
     * Get past date in MM/dd/yyyy format as per argument.
     *
     * @param days the days to get past date
     * @return Past date in MM/dd/yyyy format before given days from current date
     */
    public String PastDate(int days) throws ParseException {
        Date dateNow = new Date();
        SimpleDateFormat dateFormatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
        String date_to_string = dateFormatyyyyMMdd.format(dateNow);
        String untilDate = date_to_string;// Current Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance(); // Get Calendar Instance
        cal.setTime(dateFormat.parse(untilDate));
        // Past Date
        cal.add(Calendar.DATE, -days);
        String pastdate = dateFormat.format(cal.getTime());
        return pastdate;
    }

    /**
     * Takes screenshot and adds it to TestNG report.
     *
     * @param driver WebDriver instance.
     */
    public void makeScreenshot(WebDriver driver, String screenshotName) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";

        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome" + File.separator;
            String screenshotsFolder = "screenshots";
            File screenshotFolder = new File(reportFolder + screenshotsFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot, new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
        } catch (IOException e) {
            Reporter.log("Failed to capture screenshot: " + e.getMessage());
        }
        Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
    }

    /**
     * Generates link for TestNG report.
     *
     * @param screenshot_name Screenshot name.
     * @param link_text       Link text.
     * @return Formatted link for TestNG report.
     */
    public String getScreenshotLink(String screenshot_name, String link_text) {
        Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
        return "<a href='../target/failsafe-reports/firefox/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
    }

    /**
     * Assertion to check that given element is not being displayed.
     *
     * @param locator the locator of element to be checked
     */
    public void assertElementIsNotDisplayed(String locator) {
        pause(2);
        Assert.assertFalse(isElementDisplayed(locator));
    }
    /**
     * Assertion to check that given element is being displayed.
     *
     * @param element the locator of element to be checked
     */
    public void assertElementIsDisplayed(WebElement element) {
        waitUntilElementToBeClickable(element);
        Assert.assertTrue(isElementDisplayed(String.valueOf(element)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);
    }

    /**
     * Checks that given element is checked or not.
     *
     * @param locator the locator of element to be checked
     * @return true if element checked,otherwise false
     */
    public boolean isChecked(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        return element.isSelected();
    }

    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     *
     * @param locator The locator of element to get its attribute value
     * @return The attribute/property's current value or null if the value is not
     * set.
     */
    public String getValue(String locator) {
        // pause(1);
        WebElement element = waitUntilPresenceOfElementLocated(By.xpath(locator));
        return element.getAttribute("value");
    }

    /**
     * Assertion to check that two values are equal.
     *
     * @param value1 Value-1.
     * @param value2 Value-2.
     */
    public void assertTwoValuesAreEqual(Object value1, Object value2) {
        pause(1);
        Assert.assertEquals(value1, value2);
    }

    /**
     * Assertion to check that two values are not equal.
     *
     * @param value1 Value-1.
     * @param value2 Value-2.
     */
    public void assertTwoValuesAreNotEqual(Object value1, Object value2) {
        pause(2);
        Assert.assertNotEquals(value1, value2);
    }

    /**
     * Checks given element is being displayed or not on page.
     *
     * @param locator the locator of element to be checked present or not
     * @return True if the element displayed, false otherwise
     */
    public boolean isElementDisplayed(String locator) {
        try {
            WebElement element = this.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNotDisplayed(String locator) {
        try {
            WebElement element = this.findElement(locator);
            return !element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Common method to send a POST request and get the response as JsonObject
     */
//    public JsonObject sendPostRequestAndGetJsonResponse(String endpoint, String requestBodyPath) {
//        Response response = JSONFileReader.sendPostRequest(endpoint, requestBodyPath);
//        String responseBody = response.getBody().asString();
//        return new JsonParser().parse(responseBody).getAsJsonObject();
//    }
    /**
     * Common method to assert response status code and execution result status
     */
    public void assertResponseStatusAndExecutionResultStatus(Response response, String expectedStatus) {

        JsonObject executionResult = new JsonParser().parse(response.getBody().asString()).getAsJsonObject().getAsJsonObject("executionResult");
        String status = executionResult.get("status").getAsString();
        Assert.assertEquals(status, expectedStatus, "The status is not '" + expectedStatus + "'");
    }

    public WebElement waitUntilElementToBeVisible(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        // or use By.cssSelector(locator) or By.id(locator), etc.
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public void mouseOverClick(WebElement element) {
        waitUntilElementToBeClickable(element);
        Actions actions = new Actions(driver);
        highlightElement(element);
        actions.moveToElement(element).click().perform();
    }
    /**
     * Scroll page to element for given locator.
     *
     * @param locator the locator of element where to scroll
     *
     */
    public void scroll_To_Element(String locator) {
        WebElement element = waitUntilElementToBeVisible(findBy(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public WebElement waitUntilElementToBeVisible(By by) {

        try {
            return getWait().ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (StaleElementReferenceException e) {
            return getWait().ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }

    }

    public boolean isElementEnabled(String locator) {
        return true;
    }

    public boolean isElementDisabled(String locator) {

        WebElement element = waitUntilElementToBeVisible(By.xpath(locator));
        if (!element.isEnabled()) {
            return true;
        }
        return false;


    }

    /**
     *  Common method to log response details
     */
    public static void logResponseDetails(JsonObject jsonResponse) {
        JsonObject executionResult = jsonResponse.getAsJsonObject("executionResult");

        // Create a new JSON object to store the filtered fields
        JsonObject filteredResult = new JsonObject();
        filteredResult.add("status", executionResult.get("status"));
        filteredResult.add("discreteCriteriaVersion", executionResult.get("discreteCriteriaVersion"));
        filteredResult.add("criteriaStage", executionResult.getAsJsonObject("criteriaStage"));

        JsonArray offers = jsonResponse.getAsJsonArray("offers");
        JsonElement mck3ScoreElement = executionResult.has("mck3Score") ? executionResult.get("mck3Score") : JsonNull.INSTANCE;

        // Initialize Gson object for pretty printing
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        common.logPrint("Step :: <b>Execution Result = " +"</b>" + gson.toJson(filteredResult));
        common.logPrint("Step :: <b>Offer Result = " +"</b>"+ gson.toJson(offers));
        common.logPrint("Step :: <b>MCK3 Score = " +"</b>" + mck3ScoreElement.toString());
        common.logPrint("Step :: <b>Full Response = "  +"</b>"+ jsonResponse);


        // Extract 'criteriaStage' and 'failedCriterias'
        JsonObject executionResult1 = jsonResponse.getAsJsonObject("executionResult");
        JsonObject criteriaStage = executionResult1.getAsJsonObject("criteriaStage");
        JsonArray failedCriterias = criteriaStage.getAsJsonArray("failedCriterias");

        // Convert 'failedCriterias' to a list of strings
        List<String> failedCriteriasList = new ArrayList<>();
        for (JsonElement criteria : failedCriterias) {
            failedCriteriasList.add(criteria.getAsString());
        }
    }

    /**
     * Check that given element is present or not.
     *
     * @param locator the locator of element to be checked present or not
     * @return True if the element present, false otherwise
     */
    public boolean isElementPresent(String locator) {
        try {
            //pause(5);
            waitUntilStringLocator(locator);
            highlightElement(this.findElement(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check that given element is present or not.
     *
     * @param xpath the xpath of element to be checked present or not
     * @return True if the element present, false otherwise
     */
    public boolean existsElementFalse(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            highlightElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * Assertion to check that given element is not present.
     *
     * @param locator the locator of element
     */
    public void assertElementNotPresent(String locator) {
        pause(2);
        Assert.assertFalse(isElementPresent(locator));
    }

    /**
     * Assertion to check that given element is present.
     *
     * @param locator the locator of element
     */
    public void assertElementPresent(String locator) {
        try {
            waitUntilStringLocator(locator);
            highlightElement(locator);

            boolean present = isElementPresent(locator);
            Assert.assertTrue(present, "Element not present: " + locator);

            WebElement element = driver.findElement(By.xpath(locator));

            // Try multiple ways to extract meaningful text/value
            String text =
                    element.getAttribute("value") != null && !element.getAttribute("value").isEmpty()
                            ? element.getAttribute("value")
                            : element.getAttribute("placeholder") != null && !element.getAttribute("placeholder").isEmpty()
                            ? element.getAttribute("placeholder")
                            : element.getText() != null && !element.getText().trim().isEmpty()
                            ? element.getText().trim()
                            : element.getAttribute("innerText") != null
                            ? element.getAttribute("innerText")
                            : "No readable text/value";

            logPrint("Step :: Asserted: " + text);


        } catch (Exception e) {
            logPrint("Assertion FAILED for locator: " + locator + " | Error: " + e.getMessage());
            Assert.fail("Failed to assert element presence: " + locator, e);
        }
    }

    /**
     * Assertion to check that given element is present.
     *
     * @param locator the locator of element
     *
     */
    public void assertElementPresentWithMessage(String locator, String message) {

        Assert.assertTrue(isElementPresent(locator), message);
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of seconds, subject to the precision and accuracy of
     * system timers and schedulers. The thread does not lose ownership of any
     * monitors.
     *
     * @param seconds the time in second to pause execution
     */

    public void pause(int seconds) {

//		driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException interruptedException) {
        }
    }

    public String replaceAll(String input) {

        String fundValue = input.replaceAll("[^0-9.]", "");
        double d = Double.parseDouble(fundValue);
        int rounded_fundValue = (int) d;
        return Integer.toString(rounded_fundValue);

    }

    public String replaceSpecialChar(String input) {
        String fundValue = input.replaceAll("[^0-9.]", "");
        return fundValue;
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of milliseconds, subject to the precision and
     * accuracy of system timers and schedulers. The thread does not lose ownership
     * of any monitors.
     */
    public void pause2Sec() {

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    /**
     * Returns the number of elements in this list. If this list contains more than
     * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
     *
     * @param locator the locator of element to find list to get size
     * @return the number of elements in this list
     */
    public int size(String locator) {
        // pause(2);
        List<WebElement> element = waitUntilElementsToBeVisible(findBy(locator));
        return element.size();
    }

    /**
     * <p>
     * Log the passed string to the HTML reports.
     * </p>
     *
     * <p>
     * Print the passed string and then terminates the line.
     * </p>
     *
     * @param print the message to log and to print
     */
    public void logPrint(String print) {
        if (print.startsWith("Step")) {
            int stepcount = BasePage.steps.get();
            String[] msg = print.split("::");
            Reporter.log("<br>Step " + stepcount + " : " + msg[1].trim(),true);
//            System.out.println("Step " + stepcount + " : " + msg[1].trim());
            BasePage.steps.set(stepcount + 1);
        } else {
            Reporter.log("<br>Message : " + print,true);
//            System.out.println("Message : " + print);

        }
    }

    /**
     * Select the option of given element at random index. This is done by examining
     * the "index" attribute of an element, and not merely by counting.
     *
     * @param locator the locator of element to be selected by random index
     * @return The element's current visible text after selection or null if the
     * value is not set.
     */
    public int selectByRandomIndex(String locator) {
        WebElement element = waitUntilElementToBeClickable(locator);
        highlightElement(element);
        Select dropdown = new Select(element);
        Random random = new Random();
        dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
        handleAlert();
        return 0;
    }

    /**
     * Method to move to an element
     */

    public void moveToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void moveToElementAndClick(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void moveToElementAndClick(String locator){
        Actions actions = new Actions(driver);
        WebElement element = waitUntilElementToBeClickable(locator);
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * Check the checkbox or toggle element.
     *
     * @param locator the locator of checkbox element to be checked
     */
    public void checkChkBox(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        highlightElement(element);
        boolean isCheckBoxChecked = element.isSelected();
        if (!isCheckBoxChecked) {
            try {
                element.click();
            } catch (Exception e) {
                jsClickWithoutWait(element);
            }
        }
    }

    public void scrollToElement(String locator)  {
        WebElement element = waitUntilStringLocator(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Thread.sleep(500);
    }

    public void scroll_To_Element(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
    /**
     * <p>
     * Creates a random character string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of alphabetic characters.
     * </p>
     *
     * @param length the length of random character string to create
     * @return The random character string in lower case
     */
    public  String generateRandomChars(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }
    /**
     * <p>
     * Creates a random character string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of alphabetic characters.
     * </p>
     *
     * @param length the length of random character string to create
     * @return The random character string in lower case
     */
    public  String generateRandomCharsToUpperCase(int length) {
        return RandomStringUtils.randomAlphabetic(length).toUpperCase();
    }
    /**
     * <p>
     * Creates a random number string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of numeric characters.
     * </p>
     *
     * @param length the length of random number string to create
     * @return The random number string
     */
    public  String generateRandomNumberString(int length) {

        return RandomStringUtils.randomNumeric(length);
    }

    public  String generateRandomNumberString(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return String.valueOf(randomNumber);
    }
    /**
     * Waits until findElements(By.xpath(xpath)) returns size > 0 or timeout.
     * Returns empty list if timed out.
     */
    private List<WebElement> waitForElements(String xpath, int timeoutSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            boolean found = localWait.until((ExpectedCondition<Boolean>) drv ->
                    drv.findElements(By.xpath(xpath)).size() > 0
            );
            if (found) {
                return driver.findElements(By.xpath(xpath));
            }
        } catch (TimeoutException te) {
            // timed out -> return empty list
        }
        return new ArrayList<>();
    }

    private WebElement waitForElementVisible(By by, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(d -> {
                        WebElement el = d.findElement(by);
                        return (el.isDisplayed() && el.isEnabled()) ? el : null;
                    });
        } catch (TimeoutException te) {
            return null;
        }
    }

    /**
     * Collects trimmed, non-empty texts from the passed elements.
     * Handles StaleElementReferenceException by ignoring stale elements.
     */
    private List<String> collectTextsFromElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement e : elements) {
            try {
                String t = e.getText().trim();
                if (!t.isEmpty()) {
                    texts.add(t);
                }
            } catch (StaleElementReferenceException sere) {
                // element went stale; ignore it (could re-query if needed)
            } catch (Exception ignore) {
            }
        }
        return texts;
    }

    /**
     * Main verifySearch method with safe collection, random pick and search entry.
     */

    public void searchCommon(String baseXPath) {

        // 1. Click Search button (ignore failures)
        try {
            common.click(SEARCH);
        } catch (Exception ignored) {}

        // 2. Use the provided XPATH
        String xpath = baseXPath;

        List<WebElement> elements = waitForElements(xpath, 8);
        System.out.println("XPath: " + xpath + " -> matched count: " + elements.size());

        List<String> values = collectTextsFromElements(elements);
        System.out.println("Collected values: " + values);

        if (values.isEmpty()) {
            System.err.println("No values collected for xpath: " + xpath +
                    ". Check DOM, iframe/shadow-root, or increase wait time.");
            return;
        }

        // 3. Pick a random value
        Random rand = new Random();
        String randomValue = values.get(rand.nextInt(values.size()));
        System.out.println("Random Value Selected = " + randomValue);

        // 4. Type value into search box
        By searchBy = By.xpath("//input[@placeholder='Search...']");
        WebElement search = waitForElementVisible(searchBy, 8);
        if (search == null) {
            System.err.println("Search input not found or not visible: " + searchBy);
            return;
        }
        search.clear();
        search.sendKeys(randomValue);

        // 5. Build result XPath dynamically based on argument
        String SEARCHRESULT = baseXPath + "[contains(text(),'" + randomValue + "')]";

        System.out.println("Final Search Result XPATH = " + SEARCHRESULT);

        assertElementPresent(SEARCHRESULT);
    }


    public String selectDropdownAndGetSelectedText(By dropdownActivator, By optionLocator) {
        // 1. Click the dropdown to open it
        driver.findElement(dropdownActivator).click();

        // 2. Wait for option to appear (using your wait util)
        waitUntilElementToBeVisible(optionLocator);

        // 3. Capture text of the option BEFORE clicking
        String selectedText = driver.findElement(optionLocator).getText().trim();

        // 4. Click the option
        driver.findElement(optionLocator).click();

        // 5. Return the value that was selected
        return selectedText;
    }

    public void validateSearch(String xpathVal, String searchedTerm){
        WebElement element = driver.findElement(By.xpath(xpathVal));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
        String searched_result = element.getText();
        if(searchedTerm.equals(searched_result)){
            logPrint(searchedTerm + " Equals "+ searched_result);
            logPrint("Search works as expected");
        }
        else{
            logPrint(searchedTerm+ " Not Found, Search Doesn't work as expected");
        }
    }

    public void highlightElement(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
    }
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
    }

    public void highlightElementClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid green'", element);
    }

    public void highlightElements(List<WebElement> elements) {
        int index = 1;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement element : elements) {
            try {
                // Scroll element into view so highlight is visible
                js.executeScript(
                        "arguments[0].scrollIntoView({behavior:'auto', block:'center'});",
                        element
                );
                common.pause(200);

                // Use your highlight method
                highlightElementClick(element);

                System.out.println("Highlighted element " + index + " of " + elements.size());
                try { common.logPrint("Highlighted element " + index + " of " + elements.size()); }
                catch (Exception ignored) {}

                common.pause(200);

            } catch (StaleElementReferenceException se) {
                System.out.println("WARN: Element became stale at index " + index);
            }
            index++;
        }
    }


    public static By findBy(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return By.partialLinkText(locator);
            return By.linkText(locator);
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return By.id(locator);
        } else if (locator.startsWith("//") || locator.startsWith("(//")) {
            return By.xpath(locator);
        } else if (locator.startsWith("#")) {
            return By.cssSelector(locator);
        } else if (locator.startsWith("css=")) {
            locator = locator.substring(4);
            return By.cssSelector(locator);
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return By.name(locator);
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return By.className(locator);
        } else if (locator.equalsIgnoreCase("body")) {
            return By.cssSelector(locator);
        } else {
            return By.id(locator);
        }
    }

    /**
     * Find the first {@link WebElement} using the given method. This method is
     * affected by the 'implicit wait' times in force at the time of execution. The
     * findElement(..) invocation will return a matching row, or try again
     * repeatedly until the configured timeout is reached.
     *
     * @param locator the locator to be used by locating mechanism to find element
     * @return The first matching element on the current page
     * @throws NoSuchElementException If no matching elements are found
     */
    public WebElement findElement(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return driver.findElement(By.partialLinkText(locator));
            return driver.findElement(By.linkText(locator));
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return driver.findElement(By.id(locator));
        } else if (locator.startsWith("//") || locator.startsWith("(//")) {
            return driver.findElement(By.xpath(locator));
        } else if (locator.startsWith("#")) {
            return driver.findElement(By.cssSelector(locator));
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return driver.findElement(By.name(locator));
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return driver.findElement(By.className(locator));
        } else if (locator.equalsIgnoreCase("body")) {
            return driver.findElement(By.cssSelector(locator));
        } else {
            return driver.findElement(By.id(locator));
        }
    }

    /**
     * Find all elements within the current page using the given mechanism. This
     * method is affected by the 'implicit wait' times in force at the time of
     * execution. When implicitly waiting, this method will return as soon as there
     * are more than zero items in the found collection, or will return an empty list
     * if the timeout is reached.
     *
     * @param locator the locator to be used by locating mechanism to find elements
     * @return A list of all matching {@link WebElement}s, or an empty list if
     * nothing matches
     */
    public List<WebElement> findElements(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return driver.findElements(By.partialLinkText(locator));
            return driver.findElements(By.linkText(locator));
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return driver.findElements(By.id(locator));
        } else if (locator.startsWith("//")) {
            return driver.findElements(By.xpath(locator));
        } else if (locator.startsWith("#")) {
            return driver.findElements(By.cssSelector(locator));
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return driver.findElements(By.name(locator));
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return driver.findElements(By.className(locator));
        } else if (locator.equalsIgnoreCase("body")) {
            return driver.findElements(By.cssSelector(locator));
        } else {
            return driver.findElements(By.id(locator));
        }
    }

    /**
     * Refresh the current page
     */
    public void refreshPage() {
        this.driver.navigate().refresh();

    }

    // For complete page load
    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(pageLoadCondition);

    }

    /**
     * If given element is a form entry element, this will reset its value first
     * then simulate typing into an element, which may set its value.
     *
     * @param locator    The locator of element where to send keys
     * @param keysToSend the character sequence to send to the element
     */
    public void type(String locator, String keysToSend) {

        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        scroll_To_Element(element);
        element.clear();
        element.sendKeys(keysToSend);
        //element.sendKeys(Keys.TAB);
    }

    public void typeAndTab(String locator, String keysToSend) {


        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        scroll_To_Element(element);
        element.clear();
        element.sendKeys(keysToSend);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * If given element is a form entry element, this will reset its value first
     * then simulate typing into an element, which may set its value.
     * @param element    the element where to send keys
     * @param keysToSend the character sequence to send to the element
     */
    public void type(WebElement element, String keysToSend) {
        waitUntilElementToBeClickable(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(keysToSend);
    }

    /**
     * Click on a given element. If this causes a new page to load, you should discard
     * all references to a given element and any further operations performed on a given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible, and it must have a height and width greater than 0.
     *
     * @param locator the locator of element to be clicked.
     */
    public void click(String locator) {
        By by = findBy(locator);

        for (int i = 0; i < 3; i++) {
            try {
                WebElement element = waitUntilElementToBeClickable(locator);
                highlightElementClick(element);
                element.click();
                logClickSuccess(element, locator);
                return;

            } catch (Exception e) {
                try {
                    // JS fallback
                    WebElement el = driver.findElement(by);
                    jsClickWithoutWait(el);
                    logClickSuccess(el, locator);
                    return;
                } catch (Exception ignored) {
                    common.pause(200); // retry
                }
            }
        }

        throw new RuntimeException("FAILED :: Unable to click → " + locator);
    }

    private void logClickSuccess(WebElement element, String locator) {
        try {
            String text = element.getText().trim();
            logPrint("Step :: Clicked on: " + (text.isEmpty() ? locator : text));
        } catch (Exception ignored) {
            logPrint("Step :: Clicked on: " + locator);
        }
    }



    public void clickAndClear(String locator) {
        WebElement element = waitUntilElementToBeClickable(locator);
        highlightElementClick(element);
        try {
            element.click();
            element.clear();
        } catch (Exception e) {
            jsClickWithoutWait(element);
        }
    }

    /**
     * Click on given element. If this causes a new page to load, you should discard
     * all references to given element and any further operations performed on given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible, and it must have a height and width greater than 0.
     * @param element the element to be clicked.
     */
    public void click(WebElement element) {
        waitUntilElementToBeClickable(element);
//        scroll_To_Element(element);
        highlightElementClick(element);
        try {
            element.click();
        } catch (Exception e) {
            jsClickWithoutWait(element);
        }
    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param locator the locator of element to be clicked.
     */
    public void jsClick(String locator) {
//        scroll_To_Element(locator);
        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
        js.executeScript("return arguments[0].click();", element);

    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param element the element to be clicked.
     */
    public void jsClick(WebElement element) {
        waitUntilElementToBeClickable(element);
//        scroll_To_Element(element);
        highlightElementClick(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);

    }

    public String removeSpecialCharacters(String input) {

        input = input.substring(0, input.indexOf("."));
        //  input = input.replace(",", "");
        input = input.replaceAll("[^0-9]", "");
        return input;
    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param element the element to be clicked.
     */
    public void jsClickWithoutWait(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);

    }

    /**
     * If given element is a form entry element, this will reset its value.
     *
     * @param locator the locator of element to be cleared
     */
    public void clear(String locator) {
        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        element.clear();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of given element, including
     * sub-elements.
     *
     * @param locator the locator of element from where to get visible text
     * @return The visible text of given element.
     */
    public String getText(String locator) {
//        scroll_To_Element(locator);
        WebElement element = waitUntilStringLocator(locator);
        highlightElement(element);
        return element.getText().trim();
    }

    public String getTextwithouthighlight(String locator) {
        pause(2);
        WebElement element = this.findElement(locator);
//        highlightElement(element);
        return element.getText().trim();
    }
    // Get and return the random integer
    // within Min and Max
    public int getRandomIntergerValue(int Min, int Max) {

        return ThreadLocalRandom.current().nextInt(Min, Max);
    }
    // Get and return the random double
    // within Min and Max
    public double getRandomDoubleValue(double Min, double Max) {
        return ThreadLocalRandom.current().nextDouble(Min, Max);
    }
    /**
     * Get the visible (i.e. not hidden by CSS) text of given element, including
     * sub-elements.
     *
     * @param element the element from where to get visible text
     * @return The visible text of given element.
     */
    public String getText(WebElement element) {
//        scroll_To_Element(element);
        pause(2);
        highlightElement(element);
        return element.getText();
    }

    public static void printCurrentTime(String time)
    {
        // Get the current time in IST
        SimpleDateFormat istFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        istFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        String cstTime = istFormat.format(new Date());
        System.out.println("<br>Script " + time + ":" + cstTime);
        Reporter.log("<br>Script " + time + ":" + cstTime);
        // Check if the script is running on a server
        String serverIndicatorProperty = System.getProperty("server.indicator");
        if (serverIndicatorProperty != null && serverIndicatorProperty.contains("true")) {
            // Get the server time
            SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            serverFormat.setTimeZone(TimeZone.getTimeZone("Server/Time/Zone"));  // Replace with the actual time zone
            cstTime = serverFormat.format(new Date());
            System.out.println("Server Time: " + cstTime);
        }
    }
    public void upload_File_Using_Robot(String file) throws AWTException {

        //String path_win = "C:\\Users\\testc\\OneDrive\\Desktop\\Automation new\\qa-automation\\test_data\\Screenshot_1.png";
        String path_win = System.getProperty("user.dir")+ file;
        StringSelection filepath = new StringSelection(path_win);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, filepath);
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
        robot.delay(1000);
    }

    public static int generateRandomInteger(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }

    public static Year getCurrentYear() {
        Year thisYear = Year.now(Clock.systemUTC());

        // Print the year object
        System.out.println("year " + thisYear);

        return thisYear;
    }

    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     * <p>
     * More exactly, this method will return the value of the property with the
     * given name, if it exists. If it does not, then the value of the attribute
     * with the given name is returned. If neither exists, null is returned.
     * <p>
     * To get tooltip you have to give attribute "title" as argument.
     * <p>
     * The "style" attribute is converted as best can be to a text representation
     * with a trailing semi-colon.
     * <p>
     * The following are deemed to be "boolean" attributes, and will return either
     * "true" or null:
     * <p>
     * async, autofocus, autoplay, checked, compact, complete, controls, declare,
     * defaultchecked, defaultselected, defer, disabled, draggable, ended,
     * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
     * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
     * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
     * selected, truespeed, willvalidate
     * <p>
     * Finally, the following commonly mis-capitalized attribute/property names are
     * evaluated as expected:
     * <ul>
     * <li>If the given name is "class", the "className" property is returned.
     * <li>If the given name is "readonly", the "readOnly" property is returned.
     * </ul>
     *
     * @param locator The locator of element to get its attribute value
     * @return The attribute/property's current value or null if the value is not
     * set.
     */
    public String getAttribute(String locator, String attributeName) {
        WebElement element = waitUntilPresenceOfElementLocated(findBy(locator));
        highlightElement(element);
        return element.getAttribute(attributeName);
    }
    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     * <p>
     * More exactly, this method will return the value of the property with the
     * given name, if it exists. If it does not, then the value of the attribute
     * with the given name is returned. If neither exists, null is returned.
     * <p>
     * The "style" attribute is converted as best can be to a text representation
     * with a trailing semi-colon.
     * <p>
     * The following are deemed to be "boolean" attributes, and will return either
     * "true" or null:
     * <p>
     * async, autofocus, autoplay, checked, compact, complete, controls, declare,
     * defaultchecked, defaultselected, defer, disabled, draggable, ended,
     * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
     * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
     * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
     * selected, truespeed, willvalidate
     * <p>
     * Finally, the following commonly mis-capitalized attribute/property names are
     * evaluated as expected:
     * <ul>
     * <li>If the given name is "class", the "className" property is returned.
     * <li>If the given name is "readonly", the "readOnly" property is returned.
     * </ul>
     *
     * @param element       the element to get its attribute value
     * @param attributeName The name of the attribute
     * @return The attribute/property's current value or null if the value is not
     *         set.
     */
    public String getAttribute(WebElement element, String attributeName) {
        waitUntilStringLocatorAsaElement(element);
        return element.getAttribute(attributeName);
    }

    public long startTime() {
        return System.currentTimeMillis();
    }

    public void endTime(long startTime, String msg) {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        logPrint("Step ::Total Time for loading the " + msg + " in Seconds: "
                + TimeUnit.MILLISECONDS.toSeconds(totalTime));
    }

    public boolean isElementVisible(WebDriver driver, By locator) {
        try {
            // Create WebDriverWait with timeout in seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true; // Element is visible
        } catch (TimeoutException e) {
            return false; // Element is not visible within the timeout
        }
    }

    public void verifyElementIsDisplayed(String element) {

        boolean bool = false;
        try {
            if (findElement(element).isDisplayed()) {
                common.logPrint("Element Is displayed - PASS");
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception e) {
        }
        if (!bool) {
            common.logPrint("Element is displayed - failed");
            Assert.assertTrue(false);
        }
    }

    public void downKeyAndEnter(){
        common.pause(1);
        // Create Actions instance
        Actions actions = new Actions(driver);

        // Press DOWN arrow key, then ENTER
        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                .sendKeys(org.openqa.selenium.Keys.ENTER)
                .build()
                .perform();
    }

    public void selectCheckBox(String checkboxValue){
        WebElement element = driver.findElement(By.xpath(checkboxValue));
        element.click();
    }

    public void twoDownKeyAndEnter(){

        common.pause(1);

        Actions actions = new Actions(driver);

        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                .sendKeys(org.openqa.selenium.Keys.ENTER)
                .build()
                .perform();
    }

    public void pressEnter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void pressSpace(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).build().perform();
    }

    public void dynamicDownKeyPress(int amount){
        Actions actions = new Actions(driver);

        for(int i =0; i< amount; i++) {
            actions.sendKeys(Keys.DOWN).build().perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void safeClick(String locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
                el.click();
                logPrint("Step :: Safe Clicking on the " + el.getText());
                return;
            } catch (StaleElementReferenceException stale) {
                attempts++;
            } catch (ElementClickInterceptedException e) {
                // optional: scroll into view then retry
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        driver.findElement(By.xpath(locator)));
                attempts++;
            }
        }
        // final try to fail with the original exception context
        driver.findElement(By.xpath(locator)).click();
    }

    public String fakeCategory() {
        StringBuilder category = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            if (i > 0) {
                category.append(" ");
            }
            category.append(faker.company().buzzword());
        }
        return category.toString();
    }

    public String fakeName(){
        Faker faker = new Faker();
        String Name = faker.name().firstName();
        return Name;
    }

    public String fakeProductName(){
        String name = faker.commerce().productName();
        return name;

    }

    public void openNewIncognitoBrowser(){
        // Initialize ChromeOptions to configure browser settings
        ChromeOptions options = new ChromeOptions();
        // Add the argument for incognito mode
        options.addArguments("--incognito");
        // Initialize ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);

        //Switch to a new tab
        for (String tab: driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
    }

    public void openNewWindow(){
        ((JavascriptExecutor) driver).executeScript("window.open();");

        //Switch to a new tab
        for (String tab: driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

    }

    public void openNewUrl(String linkUrl){
        driver.get(linkUrl);
    }

    public void switchToFrameWithId(String idString){
        driver.switchTo().frame(idString);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public WebDriver openAndFocusNewIncognitoBrowser() {
        // Setup options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Create a completely new browser session
        WebDriver incognitoDriver = new ChromeDriver(options);

        // Maximize the new window
        incognitoDriver.manage().window().maximize();

        // Optional: Wait for the window to fully load and appear
        try {
            Thread.sleep(1000); // small delay to let OS switch focus
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        common.logPrint("New incognito browser opened, maximized, and focused - PASS");

        return incognitoDriver;
    }

    public void hoverOverTheElement(String element){

        Actions actions = new Actions(driver);

        WebElement menuOption = driver.findElement(By.xpath(element));

        actions.moveToElement(menuOption).click().perform();
    }

    public void hoverAndClickOnElement(String element){

        WebElement element1 = driver.findElement(By.xpath(String.valueOf(element)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).pause(Duration.ofSeconds(2)).click().perform();
    }

    public void scrollPageUsingPixel(){

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

    }

    public static List<String> readColumnDataFromExcel(String sheetName){
        List<String> dataList = new ArrayList<>();
        String filePath = "C:\\Main_Folder\\Automation\\Web_Automation\\src\\test\\resources\\DoctorAttributes.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String value = cell.getStringCellValue().trim();
                    if (!value.isEmpty()) {
                        dataList.add(value);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public WebElement waitForElementWithStaleCheck(By locator, int maxRetries, int waitSeconds){

        int attempts = 0;

        while (attempts < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (StaleElementReferenceException e) {
                common.logPrint("StaleElementReferenceException caught. Retrying... Attempt: " + (attempts + 1));
            } catch (TimeoutException e) {
                common.logPrint("Timeout waiting for element: " + locator);
                break; // No point in retrying if element never appeared
            }
            attempts++;
        }
        throw new RuntimeException("Failed to locate element after " + maxRetries + " retries: " + locator);

    }

    Faker faker = new Faker();

    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); // Correct format for your system

    /**
     * Generates a date string based on the type: "past", "future", "current", "next", or "between"
     * @param type Type of date to generate ("past", "future", "current", "next", "between")
     * @param startDateStr Required for "between" - format "MM/dd/yyyy"
     * @param endDateStr Required for "between" - format "MM/dd/yyyy"
     * @return Formatted date as String (e.g., "05/28/2025")
     */

    public String generateDate(String type, String startDateStr, String endDateStr) {
        Date resultDate = null;

        try {
            switch (type.toLowerCase()) {
                case "past":
                    resultDate = faker.date().past(3650, java.util.concurrent.TimeUnit.DAYS); // up to 10 years back
                    break;

                case "future":
                    resultDate = faker.date().future(3650, java.util.concurrent.TimeUnit.DAYS); // up to 10 years ahead
                    break;

                case "current":
                    resultDate = new Date(); // today's date
                    break;

                case "next":
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE, 1);
                    resultDate = calendar.getTime(); // tomorrow
                    break;

                case "between":
                    if (startDateStr == null || endDateStr == null) {
                        throw new IllegalArgumentException("Start and end dates are required for 'between' type.");
                    }

                    Date startDate = formatter.parse(startDateStr);
                    Date endDate = formatter.parse(endDateStr);

                    if (!startDate.before(endDate)) {
                        throw new IllegalArgumentException("Start date must be before end date.");
                    }

                    long randomMillis = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
                    resultDate = new Date(randomMillis);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid date type: " + type);
            }

            return formatter.format(resultDate);

        } catch (Exception e) {
            logPrint("Exception in generateDate(): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a"); // Example: 03:45 PM

    /**
     * Generates a time string based on the type: "past", "future", "current", or "between"
     * @param type Type of time to generate ("past", "future", "current", "between")
     * @param startTimeStr Start time (e.g., "09:00 AM") for "between"
     * @param endTimeStr End time (e.g., "05:00 PM") for "between"
     * @return Formatted time as String (e.g., "03:45 PM")
     */

    public String generateTime(String type, String startTimeStr, String endTimeStr) {
        try {
            Date resultTime;

            switch (type.toLowerCase()) {
                case "past":
                    resultTime = faker.date().past(1, java.util.concurrent.TimeUnit.DAYS);
                    break;

                case "future":
                    resultTime = faker.date().future(1, java.util.concurrent.TimeUnit.DAYS);
                    break;

                case "current":
                    resultTime = new Date();
                    break;

                case "between":
                    if (startTimeStr == null || endTimeStr == null) {
                        throw new IllegalArgumentException("Start and end times are required for 'between' type.");
                    }

                    // Parse start and end times into today's date
                    SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
                    Calendar startCal = Calendar.getInstance();
                    Calendar endCal = Calendar.getInstance();

                    Date startTime = parser.parse(startTimeStr);
                    Date endTime = parser.parse(endTimeStr);

                    startCal.setTime(startTime);
                    endCal.setTime(endTime);

                    // Normalize to today's date
                    Calendar base = Calendar.getInstance();
                    for (Calendar cal : new Calendar[]{startCal, endCal}) {
                        cal.set(Calendar.YEAR, base.get(Calendar.YEAR));
                        cal.set(Calendar.MONTH, base.get(Calendar.MONTH));
                        cal.set(Calendar.DAY_OF_MONTH, base.get(Calendar.DAY_OF_MONTH));
                    }

                    if (!startCal.before(endCal)) {
                        throw new IllegalArgumentException("Start time must be before end time.");
                    }

                    long randomMillis = ThreadLocalRandom.current().nextLong(
                            startCal.getTimeInMillis(), endCal.getTimeInMillis());
                    resultTime = new Date(randomMillis);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid time type: " + type);
            }

            return timeFormatter.format(resultTime);

        } catch (Exception e) {
            logPrint("Exception in generateTime(): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static String GenerateRandomName() {
        Faker faker = new Faker();
        return faker.name().fullName();  // e.g., "John Doe"
    }

    public String GenerateOneLineText(int count){
        String Name = faker.lorem().sentence(count);

        return Name;
    }

    public String GenerateParagraph(int count){
        String Name = faker.lorem().paragraph(count);

        return Name;
    }

    public String GenerateEmail(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }

    public String GeneratePhoneNUm(){
        Faker faker = new Faker();
        String Mobile = faker.phoneNumber().phoneNumber();
        return Mobile;
    }

    public String generateRandomYear(String fromYear, String toYear) {
        int startYear = Integer.parseInt(fromYear);
        int endYear = Integer.parseInt(toYear);

        // Validate that fromYear is less than or equal to toYear
        if (startYear > endYear) {
            throw new IllegalArgumentException("fromYear should be less than or equal to toYear.");
        }

        int randomYear = ThreadLocalRandom.current().nextInt(startYear, endYear + 1);
        return String.valueOf(randomYear);
    }

    public String generateCurDate(){
        LocalDate todays = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return todays.format(formatter);
    }

    public void tab() {

    }

    public void selectRandomValueFromDropdown(String dropdownXpath, int optionsCount){

        WebElement element = driver.findElement(By.xpath(dropdownXpath));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        element.click();

        common.pause(1);

        //generate random index between 1 and optionCount -1
        Random random = new Random();
        int randomIndex = random.nextInt(optionsCount - 1)+1;

        Actions actions = new Actions(driver);

        for(int i = 0; i< randomIndex; i++){
            actions.sendKeys(Keys.ARROW_DOWN);
        }

        actions.sendKeys(Keys.ENTER).build().perform();

        common.logPrint("Selected random index from dropdown: " + randomIndex);
    }

    public void pressDownKeysByArgument(int downCount){
            common.pause(1);

            Actions actions = new Actions(driver);

            for (int i = 0; i < downCount; i++) {
                actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN);
            }
            actions.sendKeys(org.openqa.selenium.Keys.ENTER)
                    .build()
                    .perform();

    }

    public void selectDateFromDynamicCalendar(By calendarIcon, String dateToSelect) {

        driver.findElement(calendarIcon).click();
        common.pause(1); // give time to render

        try {
            // Re-fetch every time to avoid stale references
            WebElement dateElement = driver.findElement(By.xpath("//td[normalize-space()='" + dateToSelect + "']"));
            dateElement.click();
            common.logPrint("Selected date from calendar: " + dateToSelect);
        } catch (NoSuchElementException e) {
            common.logPrint("Calendar popup didn't render as expected. Retrying...");
            driver.findElement(calendarIcon).click();
            common.pause(1);
            WebElement dateElement = driver.findElement(By.xpath("//td[normalize-space()='" + dateToSelect + "']"));
            dateElement.click();
        }
    }

    public String resetAndCheck(){
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        boolean allFieldsEmpty = true;

        for (WebElement input : inputFields) {
            String inputType = input.getAttribute("type");
            if (inputType.equals("text") || inputType.equals("password") || inputType.equals("email")) {
                String value = input.getAttribute("value");
                if (value != null && !value.trim().isEmpty()) {
                    allFieldsEmpty = false;
                    System.out.println("Input field with ID '" + input.getAttribute("id") + "' is not empty: " + value);
                }
            }
        }

        if (allFieldsEmpty) {
           return System.out.printf("All input fields are empty after reset.").toString();
        } else {
            return System.out.printf("Some input fields are not empty after reset.").toString();
        }

    }

    public void enterDateAndConfirm(String dateInput, String dateValue) {

        WebElement element = driver.findElement(By.xpath(dateInput));

        //element.click();
        element.clear();
        element.sendKeys(dateValue);
        element.sendKeys(Keys.TAB); // or ENTER
        common.logPrint("Date entered manually and confirmed: " + dateValue);
    }

    public static String convertDateFormat(String inputDate){

        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }

    public void textFileReader(String filePath) throws IOException {

        FileReader reader = new FileReader(System.getProperty("user.dir")+filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while((line = bufferedReader.readLine()) !=null){
            common.logPrint(line);
        }
    }

    public void addDate(String sentDateAndMonth, String element){
        common.logPrint("Step :: Adding the daily tour plan date");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        common.pause(1);

        common.waitUntilElementToBeVisible(element);
        common.type(element, sentDateAndMonth);

        actions.sendKeys(Keys.DOWN).perform();
    }

    // add this at top of your common class

    /* ---------------- Generic typing helper ---------------- */
    // Put this at the top of your common class

    /* ---------------------- AGENT INFO ---------------------- */

    // Name
    public String generateAgentName() {
        return faker.name().fullName();
    }

    // Company Name
    public String generateCompanyName() {
        return faker.company().name();
    }

    // Greeting Message
    public String generateGreetingMessage() {
        return "Hi! " + faker.company().catchPhrase();
    }


    /* ---------------------- PERSONALITY & GOAL ---------------------- */

    // Personality
    public String generatePersonality() {
        String[] personalities = {"friendly", "professional", "humorous", "empathetic", "casual", "formal"};
        return personalities[faker.random().nextInt(personalities.length)];
    }

    // Goal type
    public String generateGoalType() {
        String[] goals = {
                "Lead generation", "Customer support", "Product demo",
                "Order tracking", "FAQ assistance"
        };
        return goals[faker.random().nextInt(goals.length)];
    }


    /* ---------------------- BUSINESS DETAILS ---------------------- */

    // Core USP
    public String generateCoreUSP() {
        return faker.company().bs() + " that drives results";
    }

    // Core Features
    public String generateCoreFeatures() {
        return String.join(", ",
                faker.app().name(),
                faker.commerce().productName(),
                faker.company().profession()
        );
    }

    // Contact Info
    public String generateContactInfo() {
        return faker.phoneNumber().cellPhone() + " | " +
                faker.internet().emailAddress() + " | " +
                "www." + faker.internet().domainName();
    }

    // Company Domain
    public String generateCompanyDomain() {
        return faker.internet().domainName();
    }

    // Business focus
    public String generateBusinessFocus() {
        String[] focuses = {"SaaS", "e-commerce", "FinTech", "Healthcare", "Education", "Retail"};
        return focuses[faker.random().nextInt(focuses.length)];
    }

    // Offer description
    public String generateOfferDescription() {
        return faker.company().catchPhrase() + " with " + faker.commerce().material();
    }

    // Company description
    public String generateCompanyDescription() {
        return faker.company().name() + " is " + faker.company().catchPhrase()
                + ". " + faker.lorem().sentence(10);
    }

    public Map<String, String> fillAgentForm() {

        Map<String, String> data = new LinkedHashMap<>();


        data.put("name",               generateAgentName());
        data.put("companyName",        generateCompanyName());
        data.put("greeting",           generateGreetingMessage());
        data.put("personality",        generatePersonality());
        data.put("goalType",           generateGoalType());
        data.put("coreUSP",            generateCoreUSP());
        data.put("coreFeatures",       generateCoreFeatures());
        data.put("contactInfo",        generateContactInfo());
        data.put("companyDomain",      generateCompanyDomain());
        data.put("businessFocus",      generateBusinessFocus());
        data.put("offerDescription",   generateOfferDescription());
        data.put("companyDescription", generateCompanyDescription());

        waitUntilElementToBeClickable(ACCNAMEINPUT);
        type(ACCNAMEINPUT, data.get("name"));

        waitUntilElementToBeClickable(ACCCOMPANYNAMEINPUT);
        type(ACCCOMPANYNAMEINPUT, data.get("companyName"));

        waitUntilElementToBeClickable(ACCGREETINGINPUT);
        type(ACCGREETINGINPUT, data.get("greeting"));

        waitUntilElementToBeClickable(ACCPERSONALITYINPUT);
        type(ACCPERSONALITYINPUT, data.get("personality"));

        waitUntilElementToBeClickable(ACCGOALINPUT);
        type(ACCGOALINPUT, data.get("goalType"));

        waitUntilElementToBeClickable(ACCCOREUSPINPUT);
        type(ACCCOREUSPINPUT, data.get("coreUSP"));

        waitUntilElementToBeClickable(ACCCOREFEATURESINPUT);
        type(ACCCOREFEATURESINPUT, data.get("coreFeatures"));

        waitUntilElementToBeClickable(ACCCONTACTINFOINPUT);
        type(ACCCONTACTINFOINPUT, data.get("contactInfo"));

        waitUntilElementToBeClickable(ACCCOMPANYDOMAININPUT);
        type(ACCCOMPANYDOMAININPUT, data.get("companyDomain"));

        waitUntilElementToBeClickable(ACCBUSINESSFOCUINPUT);
        type(ACCBUSINESSFOCUINPUT, data.get("businessFocus"));

        waitUntilElementToBeClickable(ACCOFFERINPUT);
        type(ACCOFFERINPUT, data.get("offerDescription"));

        waitUntilElementToBeClickable(ACCCOMPANYINPUT);
        type(ACCCOMPANYINPUT, data.get("companyDescription"));

        return data;
    }

    public void validateToaster(String expectedMessage) {

        String toasterXpath = "//div[contains(text(),'" + expectedMessage + "')]";

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement toaster = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterXpath))
            );

            String actualMessage = toaster.getText().trim();
            Assert.assertTrue(
                    actualMessage.contains(expectedMessage),
                    "Expected toaster message not found. Actual: " + actualMessage
            );

            common.logPrint("Step :: Toaster validated successfully → " + actualMessage);

        } catch (TimeoutException e) {
            Assert.fail("Toaster message not displayed: " + expectedMessage);
        }
    }

    public void selectCheckbox(String inputXpath) {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(inputXpath))
        );

        if (!checkbox.isSelected()) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", checkbox);
        }
    }

    public void validateHorizontalViewCardCount() {

        // 1️⃣ Navigate to page
        ;
        common.pause(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2️⃣ Read pagination text (e.g. "1–8 of 8")
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
                )
        );

        String paginationText = text.getText();

        // 3️⃣ Extract total rows
        String totalStr = paginationText.replaceAll(".*of\\s*", "").trim();
        int totalRows;

        try {
            totalRows = Integer.parseInt(totalStr);
        } catch (NumberFormatException nfe) {
            java.util.regex.Matcher m = java.util.regex.Pattern
                    .compile("(\\d+)$")
                    .matcher(paginationText.trim());

            if (m.find()) {
                totalRows = Integer.parseInt(m.group(1));
            } else {
                throw new RuntimeException(
                        "Failed to parse total rows from pagination text: '" + paginationText + "'"
                );
            }
        }

        // 4️⃣ Switch to horizontal view
        common.waitUntilElementToBeVisible(MULTITABHOR);
        common.click(MULTITABHOR);
        common.pause(2);

        // 5️⃣ Scroll till end (handle lazy loading)
        scrollTillPageEnd();

        // 6️⃣ Validate card count
        By cardLocator = By.xpath("//div[contains(@class,'MuiCard-root')]");

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(
                    ExpectedConditions.numberOfElementsToBe(cardLocator, totalRows)
            );
        } catch (Exception ignored) {
        }

        List<WebElement> cardList = driver.findElements(cardLocator);
        int actualCount = cardList.size();

        // 7️⃣ Logging
        String msg1 = "Expected number of cards (pagination): " + totalRows;
        String msg2 = "Actual number of cards displayed:      " + actualCount;

        System.out.println("=======================================");
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("=======================================");

        try {
            common.logPrint(msg1);
            common.logPrint(msg2);
        } catch (Exception ignored) {
        }

        // 8️⃣ Assertion
        Assert.assertEquals(
                actualCount,
                totalRows,
                "Card count does not match pagination total!"
        );
    }

    public void scrollTillPageEnd() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1️⃣ Try normal window scroll first
        long lastHeight = ((Number) js.executeScript(
                "return document.body.scrollHeight")).longValue();

        for (int i = 0; i < 10; i++) {   // safety limit
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            common.pause(1);

            long newHeight = ((Number) js.executeScript(
                    "return document.body.scrollHeight")).longValue();

            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }

        // 2️⃣ Fallback: scroll inside visible scrollable containers
        js.executeScript(
                "document.querySelectorAll('*').forEach(el => {" +
                        "  if (el.scrollHeight > el.clientHeight) {" +
                        "    el.scrollTop = el.scrollHeight;" +
                        "  }" +
                        "});"
        );

        common.pause(1);
    }

    public void pagination() {

        common.pause(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ Read pagination text (e.g. "1–8 of 1,234")
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
                )
        );

        String paginationText = safeTrim(text.getText());
        String totalStrRaw = paginationText.replaceAll(".*of\\s*", "").trim();
        int totalCount = Integer.parseInt(totalStrRaw.replaceAll("[^0-9]", ""));

        common.logPrint("Target SR number: " + totalCount);

        // Locators
        final String NEXTPAGINATION =
                "//button[@title='Go to next page' or contains(@aria-label,'next')]";

        final String PAGINATIONROWS = "//div[@aria-haspopup='listbox']";

        // Row options to test
        int[] rowOptions = {10, 20, 30};

        // 2️⃣ Loop for each rows-per-page option
        for (int rows : rowOptions) {

            common.logPrint("Validating SR with rows-per-page = " + rows);

            // Change rows-per-page (skip for first/default)
            try {
                common.waitUntilElementToBeClickable(PAGINATIONROWS);
                common.click(PAGINATIONROWS);

                common.waitUntilElementToBeClickable("//li[@data-value='" + rows + "']");
                common.click("//li[@data-value='" + rows + "']");

                common.pause(2);
            } catch (Exception ignored) {
                // default row size may already be applied
            }

            boolean found = false;

            // 3️⃣ Pagination loop
            for (int page = 1; page <= 200; page++) {

                common.logPrint("Checking page " + page + " for SR " + totalCount);

                String PAGINATIONSR =
                        "//div[@data-field='srNo' and normalize-space(text())='" + totalCount + "']";

                List<WebElement> matches = driver.findElements(By.xpath(PAGINATIONSR));

                for (WebElement el : matches) {
                    try {
                        if (el.isDisplayed()) {
                            ((JavascriptExecutor) driver)
                                    .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
                            found = true;
                            break;
                        }
                    } catch (StaleElementReferenceException ignored) {
                    }
                }

                if (found) {
                    common.logPrint("Found SR " + totalCount + " with rows-per-page = " + rows);
                    break;
                }

                // Check Next button
                try {
                    WebElement nextBtn = driver.findElement(By.xpath(NEXTPAGINATION));

                    String ariaDisabled = nextBtn.getAttribute("aria-disabled");
                    String disabledAttr = nextBtn.getAttribute("disabled");

                    if ("true".equalsIgnoreCase(ariaDisabled) ||
                            (disabledAttr != null && !disabledAttr.isEmpty())) {
                        break;
                    }

                    safeClick(NEXTPAGINATION);
                    common.pause(1);

                } catch (Exception e) {
                    break;
                }
            }

            Assert.assertTrue(
                    found,
                    "SR " + totalCount + " not found with rows-per-page = " + rows
            );
        }

        common.logPrint("Pagination validation completed successfully");
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }

    public void applyFilterAndValidate(
            String filterDropdown,      // Product Name / Category / KB
            String operatorXpath,        // Equals / Contains / Begins With
            String inputValue,           // value typed in textbox
            String resultXpath,          // result column xpath
            FilterValidationType type    // EQUALS / NOT_EQUALS / CONTAINS / STARTS / ENDS
    ) {

        openFilters();

        selectField(filterDropdown);
        selectOperator(operatorXpath);

        common.waitUntilElementToBeVisible(PHFILTERVAL);
        common.clear(PHFILTERVAL);
        common.type(PHFILTERVAL, inputValue);

        String actualResult = applyAndGetFirstResult(resultXpath);

        common.logPrint(
                "Filter validation → Operator: " + type +
                        " | Input: " + inputValue +
                        " | Result: " + actualResult
        );

        switch (type) {
            case EQUALS:
                Assert.assertEquals(
                        actualResult,
                        inputValue,
                        "EQUALS filter failed"
                );
                break;

            case NOT_EQUALS:
                Assert.assertNotEquals(
                        actualResult,
                        inputValue,
                        "NOT EQUALS filter failed"
                );
                break;

            case CONTAINS:
                Assert.assertTrue(
                        actualResult.contains(inputValue),
                        "CONTAINS filter failed. Expected to contain '" +
                                inputValue + "' but was '" + actualResult + "'"
                );
                break;

            case BEGINS_WITH:
                Assert.assertTrue(
                        actualResult.startsWith(inputValue),
                        "BEGINS WITH filter failed. Expected to start with '" +
                                inputValue + "' but was '" + actualResult + "'"
                );
                break;

            case ENDS_WITH:
                Assert.assertTrue(
                        actualResult.endsWith(inputValue),
                        "ENDS WITH filter failed. Expected to end with '" +
                                inputValue + "' but was '" + actualResult + "'"
                );
                break;

            default:
                throw new IllegalArgumentException("Unsupported filter validation type: " + type);
        }
    }

    public enum FilterValidationType {
        EQUALS,
        NOT_EQUALS,
        CONTAINS,
        BEGINS_WITH,
        ENDS_WITH
    }
    private void openFilters() {
        common.refreshPage();
        common.waitUntilElementToBeClickable(FILTERS);
        safeClick(FILTERS);
        common.waitUntilElementToBeClickable(PHFILTERSEACRH);
        safeClick(PHFILTERSEACRH);
    }

    private void selectField(String fieldDropdownXpath) {
        // Use safe click rather than direct driver click to handle intermittent stale/intercept issues.
        common.waitUntilElementToBeClickable(fieldDropdownXpath);
        safeClick(fieldDropdownXpath);
    }

    private void selectOperator(String operatorXpath) {
        // Click operator dropdown (the control that opens the operator list)
        common.waitUntilElementToBeClickable(PHFILTEROPERATOR);
        safeClick(PHFILTEROPERATOR);

        // small pause to allow list rendering
        common.pause(1);

        // Now click the actual operator option safely
        common.waitUntilElementToBeClickable(operatorXpath);
        safeClick(operatorXpath);
    }

    private String applyAndGetFirstResult(String resultXpath) {
        common.waitUntilElementToBeClickable(APPLYFILTER);
        safeClick(APPLYFILTER);

        // Wait for UI to update
        common.pause(1);

        int attempts = 0;
        int maxAttempts = 3;
        while (attempts < maxAttempts) {
            attempts++;
            try {
                common.waitUntilElementToBeVisible(resultXpath);
                WebElement result = driver.findElement(By.xpath(resultXpath));
                return safeTrim(result.getText());
            } catch (StaleElementReferenceException sere) {
                common.logPrint(String.format("applyAndGetFirstResult: stale element when reading result (attempt %d) for '%s'", attempts, resultXpath));
                common.pause(1);
                // loop will retry
            } catch (NoSuchElementException nse) {
                common.logPrint(String.format("applyAndGetFirstResult: result not found (attempt %d) for '%s'", attempts, resultXpath));
                common.pause(1);
            }
        }

        // If nothing returned, log and return empty string (test assertions will catch it)
        common.logPrint("applyAndGetFirstResult: Unable to read result after retries for xpath: " + resultXpath);
        return "";
    }


}






//    public String fakeName(){
//        Faker faker = new Faker();
//        String Name = faker.name().firstName();
//        return Name;
//    }

    public String fakeIndianMobileNumber() {
        Faker faker = new Faker();
        String number = "9" + faker.number().digits(9);  // Generates 10-digit Indian number
        return number;
    }

    public String fakeDOB_MMDDYYYY() {
        Faker faker = new Faker();

        // Generate a random birthday for someone between 18 and 50 years old
        Date dob = faker.date().birthday(18, 50);

        // Format using MMddyyyy
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        return sdf.format(dob);
    }

    public String fakeCompanyName() {
        Faker faker = new Faker();
        return faker.company().name();
    }


/* ---------------- Usage examples ----------------
   // explicit
   common.fillAgentName("//input[@name='agentName']", "My Agent");

   // using faker and capturing value for assertion
   String generatedName = common.fillAgentName("//input[@name='agentName']");
--------------------------------------------------*/





