package Pages;

import Utils.Common;
import Utils.Locators;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.*;
import org.testng.Assert;

import org.testng.Assert;

import javax.swing.*;

public class ProductPage extends Locators {

    Common common;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    private static final Logger LOGGER = Logger.getLogger(ProductPage.class.getName());


    public void goToProductPage() {
        loginWithAdminUser();

        common.waitUntilElementToBeClickable(PRODUCTMENU);
        common.click(PRODUCTMENU);

        common.logPrint("Navigated to Product Page and fully loaded.");
    }

    public void verifyColumns() {
        goToProductPage();

        common.assertElementPresent(SRNO);
        common.assertElementPresent(PRODUCTNAMES);
        common.assertElementPresent(CATEGORY);
        common.assertElementPresent(DESCRIPTION);
        common.assertElementPresent(KBARTICLE);
        common.assertElementPresent(CREATEDDATE);
        common.assertElementPresent(ACTIONS);
    }

    public void verifyElements() {
        goToProductPage();

        common.assertElementPresent(SEARCH);
        common.assertElementPresent(REFRESH);
        common.assertElementPresent(FILTERS);
        common.assertElementPresent(CREATE);
        common.assertElementPresent(MULTITABHOR);
        common.assertElementPresent(MULTITABVER);
        common.assertElementPresent(TOTAL);
        common.assertElementPresent(ROWSPERPAGE);
    }

    public void verifySearch() {
        goToProductPage();
        common.searchCommon("//div[@aria-rowspan='1']/preceding-sibling::div[@aria-colindex='2']");
    }

    public void verifyRefresh() {
        goToProductPage();
        common.click(REFRESH);
    }

    private List<Comparable> parseValues(List<String> values, String type, String dateFormat) {
        List<Comparable> parsed = new ArrayList<>();
        SimpleDateFormat sdf = null;
        if ("date".equalsIgnoreCase(type) && dateFormat != null) {
            sdf = new SimpleDateFormat(dateFormat);
            sdf.setLenient(false);
        }

        for (String raw : values) {
            String v = raw == null ? "" : raw.trim();

            if (v.isEmpty() || v.equals("-") || v.equals("—") || v.equals("N/A") || v.equalsIgnoreCase("null")) {
                parsed.add(null);
                continue;
            }

            try {
                switch (type.toLowerCase()) {
                    case "int":
                    case "integer":
                        String intClean = v.replaceAll("[^0-9\\-]", "");
                        if (intClean.isEmpty() || intClean.equals("-")) {
                            parsed.add(null);
                        } else {
                            parsed.add(Integer.valueOf(intClean));
                        }
                        break;

                    case "double":
                    case "decimal":
                        String dblClean = v.replaceAll("[^0-9.\\-]", "");
                        if (dblClean.isEmpty() || dblClean.equals(".") || dblClean.equals("-") || dblClean.equals("-.")) {
                            parsed.add(null);
                        } else {
                            parsed.add(Double.valueOf(dblClean));
                        }
                        break;

                    case "date":
                        if (sdf == null) {
                            parsed.add(v);
                        } else {
                            try {
                                parsed.add(sdf.parse(v));
                            } catch (ParseException pe) {
                                LOGGER.warning("Failed to parse date '" + v + "' with format " + dateFormat + " — treating as null.");
                                parsed.add(null);
                            }
                        }
                        break;

                    default:
                        parsed.add(v);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.warning("Failed to parse numeric value '" + v + "' as " + type + ". Error: " + nfe.getMessage() + ". Treating as null.");
                parsed.add(null);
            }
        }
        return parsed;
    }

    private void waitForTableUpdate() {
        try {
            Thread.sleep(600);
        } catch (Exception ignored) {
        }
    }

    public void validateSorting(int columnIndex, String type, String dateFormat, SortOrder order) {
//        goToProductPage();
//
        By header = By.xpath("//div[@aria-colindex=" + columnIndex + "]");
        By cellLocator = By.xpath("//div[@aria-colindex=" + columnIndex + "]");

        List<WebElement> beforeCells = driver.findElements(cellLocator);
        List<String> beforeTextValues = beforeCells.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
        List<Comparable> beforeParsed = parseValues(beforeTextValues, type, dateFormat);

        System.out.println("\n=============================");
        System.out.println("BEFORE SORTING (Column " + columnIndex + "): " + beforeParsed);
        System.out.println("=============================\n");

        int clicksNeeded = 1;
        String orderName = (order == null) ? "" : order.name().toLowerCase();

        if (orderName.contains("asc")) clicksNeeded = 1;
        else if (orderName.contains("desc")) clicksNeeded = 2;
        else if (orderName.contains("uns") || orderName.contains("none")) clicksNeeded = 3;

        for (int i = 0; i < clicksNeeded; i++) {
            String beforeFirst = "";
            try {
                WebElement firstCell = driver.findElement(By.xpath("(//div[@aria-colindex=" + columnIndex + "])[1]"));
                beforeFirst = firstCell.getText().trim();
            } catch (Exception ignored) {
            }

//            WebElement headerEl = wait.until(ExpectedConditions.elementToBeClickable(header));
//            headerEl.click();

            try {
                WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                final String bf = beforeFirst;
                shortWait.until(d -> {
                    try {
                        WebElement first = d.findElement(By.xpath("(//div[@aria-colindex=" + columnIndex + "])[1]"));
                        String now = first.getText().trim();
                        return !now.equals(bf);
                    } catch (Exception e) {
                        return false;
                    }
                });
            } catch (Exception ignored) {
            }

            waitForTableUpdate();
        }

        List<WebElement> afterCells = driver.findElements(cellLocator);
        List<String> afterTextValues = afterCells.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
        List<Comparable> afterParsed = parseValues(afterTextValues, type, dateFormat);

        System.out.println("\n=============================");
        System.out.println("AFTER SORTING (" + order + ") (Column " + columnIndex + "): " + afterParsed);
        System.out.println("=============================\n");

        Comparator<Comparable> comparator = (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return 1;
            if (b == null) return -1;
            return a.compareTo(b);
        };

        List<Comparable> expectedAsc = new ArrayList<>(afterParsed);
        expectedAsc.sort(comparator);

        List<Comparable> expectedDesc = new ArrayList<>(afterParsed);
        expectedDesc.sort(comparator.reversed());

        boolean isAsc = expectedAsc.equals(afterParsed);
        boolean isDesc = expectedDesc.equals(afterParsed);

        if (orderName.contains("asc")) {
            Assert.assertTrue(isAsc, "Expected ASC but actual was: " + afterParsed);
        } else if (orderName.contains("desc")) {
            Assert.assertTrue(isDesc, "Expected DESC but actual was: " + afterParsed);
        } else if (orderName.contains("uns") || orderName.contains("none")) {
            Assert.assertFalse(isAsc || isDesc, "Expected UNSORT but column is sorted. Actual: " + afterParsed);
        } else {
            Assert.assertTrue(isAsc, "Fallback: Expected ASC but actual was: " + afterParsed);
        }
    }

    public void validatePlaceHolders() {
        goToProductPage();

        common.assertElementPresent(PHSEACRH);
        common.click(FILTERS);
        common.assertElementPresent(PHFILTERSEACRH);
        common.click(PHFILTERSEACRH);
        common.waitUntilElementToBeVisible(FILTERDROPDOWNVAL);
        common.click(FILTERDROPDOWNVAL);
        common.assertElementPresent(PHFILTEROPERATOR);
        common.click(PHFILTEROPERATOR);
        common.waitUntilElementToBeVisible(PHFILTEROPERATOR);
        common.click(FILTERDROPDOWNVAL);
        common.assertElementPresent(PHFILTERVAL);
        common.click(CLOSEFILTER);
        common.click(CREATE);
        common.assertElementPresent(PHPRODUCTNAME);
        common.assertElementPresent(PHPRODUCTCATEGORY);
        common.assertElementPresent(PHPRODUCTDESCRIPTION);
        common.assertElementPresent(PHPRODUCTKB);
    }

    public Product verifyAddingANewProductWithValidData() {
        goToProductPage();

        String productName = common.fakeProductName();

        // Open create modal
        common.click(CREATE);

        // Name
        common.click(PHPRODUCTNAME);
        common.type(PHPRODUCTNAME, productName);

        // Category - using common helper that returns visible selected text.
        // NOTE: Common.selectDropdownAndGetSelectedText(By activator, By option, By selectedValueLocator)
        String category = common.fakeCategory();
        common.click(PHPRODUCTCATEGORY);
        common.type(PHPRODUCTCATEGORY, category);
        common.pause(1);
        driver.findElement(By.xpath(PHPRODUCTCATEGORYNEW)).click();

        // Description
        common.waitUntilElementToBeVisible(PHPRODUCTDESCRIPTION);
        common.click(PHPRODUCTDESCRIPTION);
        String description = productName; // keeping same as before, change if needed
        common.type(PHPRODUCTDESCRIPTION, description);

        // KB
        String kb = common.selectDropdownAndGetSelectedText(
                By.xpath(PHPRODUCTKB),
                By.xpath(FILTERDROPDOWNVAL)
        );

        // Save and verify
        common.click(SAVEBUTTON);
        common.assertElementPresent(SUCCESSMESSAGE);
        common.click(CLOSEBUTTON);

        // Verify via search (keeps your original validation)
        common.click(PHSEACRH);
        common.type(PHSEACRH, productName);
        common.validateSearch(SEARCHRESULT, productName);

        return new Product(productName, category, description, kb);
    }

    public void editingAProduct() {
        Product created = verifyAddingANewProductWithValidData();

        // open edit - assuming EDIT locator works for first row result after search
        driver.findElement(By.xpath(EDIT)).click();

        // update to a new product name
        String newName = common.fakeProductName();
        common.click(PHPRODUCTNAME);
        common.type(PHPRODUCTNAME, newName);

        // update category
        String newCategory = common.selectDropdownAndGetSelectedText(
                By.xpath(PHPRODUCTCATEGORY),
                By.xpath(FILTERDROPDOWNVAL)
        );

        // update description
        common.waitUntilElementToBeVisible(PHPRODUCTDESCRIPTION);
        common.click(PHPRODUCTDESCRIPTION);
        String newDescription = newName;
        common.type(PHPRODUCTDESCRIPTION, newDescription);

        // update KB
        String newKb = common.selectDropdownAndGetSelectedText(
                By.xpath(PHPRODUCTKB),
                By.xpath(FILTERDROPDOWNVAL)
        );

        // save and verify
        common.click(SAVEBUTTON);
        common.assertElementPresent(SUCCESSMESSAGE);
        common.click(CLOSEBUTTON);

        // search using updated name and validate
        common.click(PHSEACRH);
        common.type(PHSEACRH, newName);
        common.validateSearch(SEARCHRESULT, newName);
    }

    public void deletingAProduct() {
        Product created = verifyAddingANewProductWithValidData();
        common.logPrint(created.getCategory() + " " + created.getName() + " " + created.getKb() + " " + created.getDescription() + " ");

        // Click delete for the product row found (assumes DELETEPRODUCT locator targets the row for current search)
        driver.findElement(By.xpath(DELETEPRODUCT)).click();

        common.click(DELETECONFIRMPRODUCT);
        common.assertElementPresent(DELETEPRODUCTASSERT);
    }

    public void viewProduct() {
        Product created = verifyAddingANewProductWithValidData();

        String givenName = created.getName();
        String givenCategory = created.getCategory();
        String givenDisc = created.getDescription();
        String givenKB = created.getKb();

        driver.findElement(By.xpath(VIEWBUTTON)).click();
        common.logPrint("Step :: Clicking on the view button");

        WebElement viewNameValue = driver.findElement(
                By.xpath("//span[contains(text(),'Name')]/following::input[@value='" + givenName + "']")
        );

        WebElement viewCategoryValue = driver.findElement(
                By.xpath("//span[contains(text(),'Category')]/following::input[@value='" + givenCategory + "']")
        );

        WebElement viewDescriptionValue = driver.findElement(
                By.xpath("//span[contains(text(),'Description')]/following::input[@value='" + givenDisc + "']")
        );

        WebElement viewKBValue = driver.findElement(
                By.xpath("//span[contains(text(),'KB')]/following::input[@value='" + givenKB + "']")
        );

        // Compare extracted UI values with expected values
        Assert.assertEquals(viewNameValue.getAttribute("value"), givenName);
        Assert.assertEquals(viewCategoryValue.getAttribute("value"), givenCategory);
        Assert.assertEquals(viewDescriptionValue.getAttribute("value"), givenDisc);
        Assert.assertEquals(viewKBValue.getAttribute("value"), givenKB);
        common.logPrint("Step :: View Asserted Successfully");
    }

    public void horizontalView() {
        goToProductPage();
        common.pause(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
        ));

        String paginationText = text.getText(); // example: "1–8 of 8"


        String totalStr = paginationText.replaceAll(".*of\\s*", "").trim();
        int totalRows;
        try {
            totalRows = Integer.parseInt(totalStr);
        } catch (NumberFormatException nfe) {
            // fallback: extract last number via regex
            java.util.regex.Matcher m = java.util.regex.Pattern.compile("(\\d+)$").matcher(paginationText.trim());
            if (m.find()) {
                totalRows = Integer.parseInt(m.group(1));
            } else {
                throw new RuntimeException("Failed to parse total rows from pagination text: '" + paginationText + "'");
            }
        }

        common.waitUntilElementToBeVisible(MULTITABHOR);
        common.click(MULTITABHOR);
        common.pause(2); // small pause to let layout update

        By cardLocator = By.xpath("//div[contains(@class,'MuiCard-root')]");

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.numberOfElementsToBe(cardLocator, totalRows));
        } catch (Exception ignored) {

        }

        List<WebElement> cardList = driver.findElements(cardLocator);
        int actualCount = cardList.size();

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
        Assert.assertEquals(actualCount, totalRows, "Card count does not match pagination total!");
    }

    public void pagination() {
        goToProductPage();
        common.pause(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the pagination text (example "1–8 of 8" or "1–8 of 1,234")
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
        ));

        String paginationText = safeTrim(text.getText());
        common.logPrint("Before trim: " + paginationText);

        String totalStrRaw = paginationText.replaceAll(".*of\\s*", "").trim(); // "1,234" or "8"
        String totalDigitsOnly = totalStrRaw.replaceAll("[^0-9]", "");         // "1234" or "8"
        if (totalDigitsOnly.isEmpty()) {
            throw new RuntimeException("Unable to parse total count from pagination text: '" + paginationText + "'");
        }
        int totalCount = Integer.parseInt(totalDigitsOnly);
        common.logPrint("Total Number of Records parsed: " + totalCount + " (raw: '" + totalStrRaw + "')");

        final String NEXTPAGINATION = "//button[@title='Go to next page' or contains(@aria-label,'next')]" ;

        final String PAGINATIONSR = "//div[@data-field='srNo' and normalize-space(text()) = '" + totalCount + "']";

        final int MAX_PAGES = 200;
        boolean found = false;
        int page = 1;

        for (; page <= MAX_PAGES; page++) {
            common.logPrint("pagination: checking page " + page + " for SR row = " + totalCount);

            try {
                // Short wait to see if the target SR cell is present/visible on this page
                List<WebElement> candidates = driver.findElements(By.xpath(PAGINATIONSR));
                if (!candidates.isEmpty()) {
                    // Found — take the first visible one
                    for (WebElement c : candidates) {
                        try {
                            if (c.isDisplayed()) {
                                common.logPrint("pagination: found target SR row on page " + page);
                                found = true;
                                break;
                            }
                        } catch (StaleElementReferenceException sere) {
                            // If stale, ignore and continue scanning; next loop will re-evaluate
                        }
                    }
                    if (found) break;
                }

                // Not found — check if Next button is disabled (no further pages)
                try {
                    WebElement nextBtn = common.waitUntilElementToBeClickable(NEXTPAGINATION);
                    // If the button is present but has aria-disabled='true' or disabled attribute, stop
                    String ariaDisabled = nextBtn.getAttribute("aria-disabled");
                    String disabledAttr = nextBtn.getAttribute("disabled");
                    boolean isDisabled = "true".equalsIgnoreCase(ariaDisabled) || (disabledAttr != null && !disabledAttr.isEmpty());

                    if (isDisabled) {
                        common.logPrint("pagination: Next button is disabled on page " + page + " — reached last page.");
                        break;
                    }

                    // Click next safely (use your safeClick or common.click with retry)
                    safeClick(NEXTPAGINATION);

                    // Wait a bit for the next page to load — prefer explicit wait for page table or spinner invisibility
                    common.pause(1);
                    // Optionally wait until the displayed rows text updates (detect change) - simple approach:
                    String finalPaginationText = paginationText;
                    wait.until(webDriver -> {
                        String newText = safeTrim(webDriver.findElement(By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")).getText());
                        return !newText.equals(finalPaginationText); // changed => new page loaded
                    });

                    // Update paginationText to new page's text
                    try {
                        WebElement newTextEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
                        ));
                        paginationText = safeTrim(newTextEl.getText());
                    } catch (Exception ignore) {
                        // ignore; we'll continue loop and try to find the SR
                    }

                } catch (TimeoutException te) {
                    common.logPrint("pagination: Next button not clickable or not found on page " + page + " — stopping. " + te.getMessage());
                    break;
                }
            } catch (Exception ex) {
                common.logPrint("pagination: unexpected exception on page " + page + " -> " + ex.getMessage());
                // small pause and retry
                common.pause(1);
            }
        }

        Assert.assertTrue(found, "Pagination: expected srNo '" + totalCount + "' to be present in the grid but it was not found after checking " + (page - 1) + " pages.");

        if (found) {
            WebElement target = driver.findElement(By.xpath(PAGINATIONSR));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", target);
            common.logPrint("pagination: success — target srNo '" + totalCount + "' is visible.");
            common.refreshPage();
        }

        String PAGINATIONROWS = "//div[@aria-haspopup=\"listbox\"]";

        driver.findElement(By.xpath(PAGINATIONROWS)).click();
    }

    public void filters() {
        Product created = verifyAddingANewProductWithValidData();
        String createdCategory = safeTrim(created.getCategory());
        String fullName = safeTrim(created.getName());   // e.g. "Smart Home Device"

        // Parse words safely (ensures at least 1 word)
        String[] nameWords = splitWordsSafely(fullName);
        String startsWith = nameWords[0];
        String middleWord = nameWords.length > 1 ? nameWords[1] : nameWords[0];
        String endsWith = nameWords[nameWords.length - 1];

        common.logPrint("Full Name: " + fullName);
        common.logPrint("Starts With: " + startsWith);
        common.logPrint("Middle Word: " + middleWord);
        common.logPrint("Ends With: " + endsWith);

        String[] categoryWords = splitWordsSafely(createdCategory);
        String catStartsWith = categoryWords[0];
        String catMiddleWord = categoryWords.length > 1 ? categoryWords[1] : categoryWords[0];
        String catLastWord = categoryWords[categoryWords.length - 1];

        common.logPrint("Category Name: " + createdCategory);
        common.logPrint("Category Starts With: " + catStartsWith);
        common.logPrint("Category Middle Word: " + catMiddleWord);
        common.logPrint("Category Ends With: " + catLastWord);

        // 1) EQUALS - PRODUCT NAME
        openFilters();
        selectField(FILTERPRODUCTNAMEDROPDOWN);
        selectOperator(FILTEREQUALS);
        common.type(PHFILTERVAL, fullName);
        String resultEquals = applyAndGetFirstResult(FILTERNAMERESULT);
        common.logPrint("1. EQUALS result: " + resultEquals);
        Assert.assertEquals(resultEquals, fullName, "1. Product EQUALS filter failed");

        // 2) NOT EQUALS - PRODUCT NAME
        openFilters();
        selectField(FILTERPRODUCTNAMEDROPDOWN);
        selectOperator(FILTERNOTEQUALS);
        common.type(PHFILTERVAL, fullName);
        String resultNotEquals = applyAndGetFirstResult(FILTERNAMERESULT);
        common.logPrint("2. NOT EQUALS result: " + resultNotEquals);
        Assert.assertNotEquals(resultNotEquals, fullName, "2. Product NOT EQUALS filter failed");

        // 3) CONTAINS - PRODUCT NAME (middle word)
        openFilters();
        selectField(FILTERPRODUCTNAMEDROPDOWN);
        selectOperator(FILTERCONTAINS);
        common.type(PHFILTERVAL, middleWord);
        String resultContains = applyAndGetFirstResult(FILTERNAMERESULT);
        common.logPrint("3. CONTAINS result: " + resultContains);
        Assert.assertTrue(resultContains.contains(middleWord),
                "3. Product CONTAINS filter failed: expected to contain '" + middleWord + "' but was '" + resultContains + "'");

        // 4) BEGINS WITH - PRODUCT NAME
        openFilters();
        selectField(FILTERPRODUCTNAMEDROPDOWN);
        selectOperator(FILTERBEGINSWITH);
        common.type(PHFILTERVAL, startsWith);
        String resultBegins = applyAndGetFirstResult(FILTERNAMERESULT);
        common.logPrint("4. BEGINS WITH result: " + resultBegins);
        Assert.assertTrue(resultBegins.startsWith(startsWith),
                "4. Product BEGINS WITH filter failed: expected to start with '" + startsWith + "' but was '" + resultBegins + "'");

        // 5) ENDS WITH - PRODUCT NAME
        openFilters();
        selectField(FILTERPRODUCTNAMEDROPDOWN);
        selectOperator(FILTERENDSWITH);
        common.type(PHFILTERVAL, endsWith);
        String resultEnds = applyAndGetFirstResult(FILTERNAMERESULT);
        common.logPrint("5. ENDS WITH result: " + resultEnds);
        Assert.assertTrue(resultEnds.endsWith(endsWith),
                "5. Product ENDS WITH filter failed: expected to end with '" + endsWith + "' but was '" + resultEnds + "'");

        // 6) CATEGORY EQUALS
        openFilters();
        selectField(FILTERCATEGORYFROPDOWN);
        selectOperator(FILTEREQUALS);
        common.type(PHFILTERVAL, createdCategory);
        String catEqual = applyAndGetFirstResult(FILTERCATEGORYRESULT);
        common.logPrint("6. Category EQUALS result: " + catEqual);
        Assert.assertEquals(catEqual, createdCategory, "6. Category EQUALS filter failed");

        // 7) CATEGORY NOT EQUALS
        openFilters();
        selectField(FILTERCATEGORYFROPDOWN);
        selectOperator(FILTERNOTEQUALS);
        common.type(PHFILTERVAL, createdCategory);
        String catNotEqualText = applyAndGetFirstResult(FILTERCATEGORYRESULT);
        common.logPrint("7. Category NOT EQUALS result: " + catNotEqualText);
        Assert.assertNotEquals(catNotEqualText, createdCategory, "7. Category NOT EQUALS filter failed");

        // 8) CATEGORY CONTAINS
        openFilters();
        selectField(FILTERCATEGORYFROPDOWN);
        selectOperator(FILTERCONTAINS);
        common.type(PHFILTERVAL, catMiddleWord);
        String catContainsText = applyAndGetFirstResult(FILTERCATEGORYRESULT);
        common.logPrint("8. Category CONTAINS result: " + catContainsText);
        Assert.assertTrue(catContainsText.contains(catMiddleWord),
                "8. Category CONTAINS filter failed: expected to contain '" + catMiddleWord + "' but was '" + catContainsText + "'");

        // 9) CATEGORY BEGINS WITH
        openFilters();
        selectField(FILTERCATEGORYFROPDOWN);
        selectOperator(FILTERBEGINSWITH);
        common.type(PHFILTERVAL, catStartsWith);
        String catBeginsWithText = applyAndGetFirstResult(FILTERCATEGORYRESULT);
        common.logPrint("9. Category BEGINS WITH result: " + catBeginsWithText);
        Assert.assertTrue(catBeginsWithText.startsWith(catStartsWith),
                "9. Category BEGINS WITH filter failed: expected to start with '" + catStartsWith + "' but was '" + catBeginsWithText + "'");

        // 10) CATEGORY ENDS WITH
        openFilters();
        selectField(FILTERCATEGORYFROPDOWN);
        selectOperator(FILTERENDSWITH);
        common.type(PHFILTERVAL, catLastWord);
        String catEndsWithText = applyAndGetFirstResult(FILTERCATEGORYRESULT);
        common.logPrint("10. Category ENDS WITH result: " + catEndsWithText);
        Assert.assertTrue(catEndsWithText.endsWith(catLastWord),
                "10. Category ENDS WITH filter failed: expected to end with '" + catLastWord + "' but was '" + catEndsWithText + "'");
    }

    /**
     * Click an element by xpath with retries. Uses your common.waitUntilElementToBeClickable(xpath)
     * to locate the element before clicking. Retries on StaleElementReferenceException,
     * ElementClickInterceptedException and general WebDriverException.
     */
    private void safeClick(String xpath) {
        int attempts = 0;
        int maxAttempts = 3;
        while (attempts < maxAttempts) {
            attempts++;
            try {
                // Use your stable wait helper to get the clickable element
                WebElement el = common.waitUntilElementToBeClickable(xpath);
                // Try normal click first
                el.click();
                // success
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                common.logPrint(String.format("safeClick: attempt %d for '%s' failed with %s - retrying",
                        attempts, xpath, e.getClass().getSimpleName()));
                common.pause(1); // short pause before retry
                // loop will retry and re-find
            } catch (WebDriverException wde) {
                // some other driver related issue (e.g. overlay). Try clicking via JS as fallback on last attempt.
                common.logPrint(String.format("safeClick: WebDriverException on attempt %d for '%s': %s",
                        attempts, xpath, wde.getMessage()));
                common.pause(1);
                if (attempts == maxAttempts) {
                    // final fallback — attempt JS click then rethrow if still failing
                    try {
                        WebElement el = driver.findElement(By.xpath(xpath));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                        return;
                    } catch (Exception jsEx) {
                        common.logPrint("safeClick: JS click also failed: " + jsEx.getMessage());
                        throw wde;
                    }
                }
            } catch (Exception e) {
                // unexpected - log and rethrow after a small pause
                common.logPrint("safeClick: unexpected error while clicking '" + xpath + "': " + e.getMessage());
                common.pause(1);
                throw e;
            }
        }

        // If we exit loop without returning, throw a descriptive error
        throw new RuntimeException("safeClick: Unable to click element after " + maxAttempts + " attempts: " + xpath);
    }

    /**
     * Selects the field dropdown safely.
     */
    private void selectField(String fieldDropdownXpath) {
        // Use safe click rather than direct driver click to handle intermittent stale/intercept issues.
        common.waitUntilElementToBeClickable(fieldDropdownXpath);
        safeClick(fieldDropdownXpath);
    }

    /**
     * Select operator (Equals/Contains/StartsWith/EndsWith) safely.
     */
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

    /**
     * Click apply and return the first result's text. Handles StaleElementReferenceException
     * by retrying a couple of times to read text.
     */
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

    private void openFilters() {
        common.refreshPage();
        common.waitUntilElementToBeClickable(FILTERS);
        safeClick(FILTERS);
        common.waitUntilElementToBeClickable(PHFILTERSEACRH);
        safeClick(PHFILTERSEACRH);
    }

    private String[] splitWordsSafely(String input) {
        input = safeTrim(input);
        if (input.isEmpty()) {
            return new String[] { "" };
        }
        String[] parts = input.split("\\s+");
        return parts.length == 0 ? new String[] { input } : parts;
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }

    public static class Product {
        private final String name;
        private final String category;
        private final String description;
        private final String kb;

        public Product(String name, String category, String description, String kb) {
            this.name = name;
            this.category = category;
            this.description = description;
            this.kb = kb;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public String getDescription() {
            return description;
        }

        public String getKb() {
            return kb;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', category='" + category + "', description='" + description + "', kb='" + kb + "'}";
        }
    }

}
