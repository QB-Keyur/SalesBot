package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AgentConfigurationPage extends Locators {

    private final WebDriver driver;
    private final Common common;
    private final WebDriverWait wait;
    private static final Logger LOGGER = Logger.getLogger(AgentConfigurationPage.class.getName());

    public AgentConfigurationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.common = new Common(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToAgentConfigurationPage(){

        common.waitUntilElementToBeClickable(AGENTCONFIGURATIONMENU);
        common.click(AGENTCONFIGURATIONMENU);

        common.logPrint("Navigated to Agent Configuration Page and fully loaded.");

    }

    public void verifyColumnsAndElemensts() {
        goToAgentConfigurationPage();

        // LinkedHashMap preserves order so logs are easier to read
        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(ACHEADER, "Header");
        columns.put(ACSEARCHBAR, "Search bar");
        columns.put(REFRESH, "Refresh");
        columns.put(FILTERS, "Filters");
        columns.put(CREATE, "Create");
        columns.put(MULTITABHOR, "Horizontal View");
        columns.put(MULTITABVER, "Normal View");
//        columns.put(ACSELECTALL, "Select All checkbox");
        columns.put(ACSRNUMBER, "SR Number");
        columns.put(ACNAME, "Name");
        columns.put(ACGREETINGS, "Greetings");
        columns.put(ACPERSONALITY, "Personality");
        columns.put(ACPERSONA, "Persona");
        columns.put(ACPROMPT, "Prompt");
        columns.put(ACSTATUS, "Status");
        columns.put(ACACTIONS, "Actions");
        columns.put(ACTOTALROWS, "Total rows");
        columns.put(ACROWSPERPAGE, "Rows per page");
//        columns.put(ACROWSPERPAGEDROPDOWN, "Rows per page - dropdown");
//        columns.put(ACPREVIOUSPAGE, "Previous page");
//        columns.put(ACNEXTPAGE, "Next page");

        int failures = 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();
            try {

                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                String msg = "Missing element -> " + friendlyName + " (" + locator + ")";
                common.logPrint(msg);

                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All columns verified successfully.");
        } else {
            common.logPrint("Step :: Column verification completed with " + failures + " missing element(s).");
        }
    }

    public void verifySearch() {
        goToAgentConfigurationPage();
        common.searchCommon(ACNAMEINDEX);
    }

    public void verifyRefresh() {
        goToAgentConfigurationPage();
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

            WebElement headerEl = wait.until(ExpectedConditions.elementToBeClickable(header));
            headerEl.click();

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

    public void verifyActivateButton(){
        goToAgentConfigurationPage();
        WebElement btn = driver.findElement(By.xpath("//span[text()='Active']/parent::button"));

        boolean isDisabled = !btn.isEnabled();
        common.logPrint("Active button is Disabled? : " + isDisabled);
        common.assertElementPresent(ACINACTIVEGRIDSTATUS);
        driver.findElement(By.xpath("(//span[text()='Inactive'])[1]/preceding::input[@type='checkbox'][1]")).click();

        common.assertElementPresent(ACACTIVTEBUTTON);
        if(btn.isEnabled()){
            common.logPrint("Button was Enabled as Expected ");
        }
        else{
            common.logPrint("Button didn't get Enabled as Expected");
        }
    }

    public void verifyActiveButtonNegative(){

        goToAgentConfigurationPage();

        WebElement btn = driver.findElement(By.xpath("//span[text()='Active']/parent::button"));
        boolean isDisabled = !btn.isEnabled();
        common.logPrint("Active button is Disabled? : " + isDisabled);

        common.assertElementPresent(ACACTIVEGRIDSTATUS);
        driver.findElement(By.xpath("(//span[text()='Active'])[2]/preceding::input[@type='checkbox'][1]")).click();

        common.assertElementPresent(ACACTIVTEBUTTON);
        if(!btn.isEnabled()){
            common.logPrint("Button was Disabled as Expected ");
        }
        else{
            common.logPrint("Button didn't stay Disabled as Expected");
        }
    }

    public void horizontalView() {

        goToAgentConfigurationPage();
        common.pause(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use contains(@class, 'MuiTablePagination-displayedRows') to avoid fragile generated suffix
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]")
        ));

        String paginationText = text.getText(); // example: "1–8 of 8"

        // Extract the last number robustly. First try simple "of" approach, fallback to regex extracting last number.
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

        // Switch to horizontal view and wait for UI to render
        common.waitUntilElementToBeVisible(MULTITABHOR);
        common.click(MULTITABHOR);
        common.pause(2); // small pause to let layout update

        By cardLocator = By.xpath("//div[contains(@class,'MuiCard-root')]");

        // Wait up to a short duration for the expected number of cards to appear (helps with async loading)
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.numberOfElementsToBe(cardLocator, totalRows));
        } catch (Exception ignored) {
            // ignore - we'll still fetch current number and assert (this avoids hard failure if wait timed out)
        }

        List<WebElement> cardList = driver.findElements(cardLocator);
        int actualCount = cardList.size();
       // common.highlightElements(cardList);

        // ALWAYS print Expected vs Actual
        String msg1 = "Expected number of cards (pagination): " + totalRows;
        String msg2 = "Actual number of cards displayed:      " + actualCount;
        System.out.println("=======================================");
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("=======================================");

        // If your Common has a logger helper, log there too
        try {
            common.logPrint(msg1);
            common.logPrint(msg2);
        } catch (Exception ignored) {
            // ignore if common.logPrint isn't present / fails
        }

        // Final assertion
        Assert.assertEquals(actualCount, totalRows, "Card count does not match pagination total!");
    }

    public void verifyCreatePageElements(){
        goToAgentConfigurationPage();
        driver.findElement(By.xpath(CREATE)).click();

        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(ACCHEADER, "Header");
        columns.put(ACCCANCELBUTTON, "Cancel");
        columns.put(ACCSAVEBUTTON, "Save");
        columns.put(ACCPERSONA, "Persona");
        columns.put(ACCSELECTPERSONA, "Select Persona");
        columns.put(ACCPROMPT, "Prompt");
        columns.put(ACCPERSONALITY1, "personality");
        columns.put(ACCTEXTAREAPROMPT, "ACCTEXTAREAPROMPT");
        columns.put(ACCRULES, "Rules");
        columns.put(ACCRULESDROPDOWN, "Enter a new rule");
        columns.put(ACCCUSTOMVARIABLE, "Custom Variables");
        columns.put(ACCADDVARIABLE, "Add Variable");
        columns.put(ACCAGENT, "Agent Info");
        columns.put(ACCNAME, "Name");
        columns.put(ACCNAMEINPUT, "Enter Name");
        columns.put(ACCNAME2, "ACCNAME2");
        columns.put(ACCCOMPANYNAME, "Company name");
        columns.put(ACCCOMPANYNAME2, "{{company_name}}");
        columns.put(ACCCOMPANYNAMEINPUT, "Enter Company Name");
        columns.put(ACCGREETINGS, "Greeting Message");
        columns.put(ACCGREETINGINPUT, "greeting_message");
        columns.put(ACCTIMEZONE, "Timezone");
        columns.put(ACCTIMEZONEINPUT, "Select Timezone");
        columns.put(ACCPERSONALITY, "Personality & Goal");
        columns.put(ACCPERSONALITY2, "Personality");
        columns.put(ACCPERSONALITYINPUT, "personality");
        columns.put(ACCGOAL, "Goal type");
        columns.put(ACCGOAL1, "{{goal_type}}");
        columns.put(ACCGOALINPUT, "goal_type");
        columns.put(ACCLANG, "Language");
        columns.put(ACCLANGINPUT, "Select Language");
        columns.put(ACCALLOWEMOJI, "Allow Emojis");
        columns.put(ACCRADIOYES1, "ACCRADIOYES1");
        columns.put(ACCRADIOYES2, "ACCRADIOYES2");
        columns.put(ACCRADIONO1, "ACCRADIONO1");
        columns.put(ACCRADIONO2, "ACCRADIONO2");
        columns.put(ACCBUSINESSDETAILS, "Business Details");
        columns.put(ACCCOREUSP, "Core USP");
        columns.put(ACCCOREUSP1, "{{core_usps}}");
        columns.put(ACCCOREUSPINPUT, "Your unique selling proposition");
        columns.put(ACCCOREFEATURES, "Core Features");
        columns.put(ACCCOREFEATURES1, "{{core_features}}");
        columns.put(ACCCOREFEATURESINPUT, "core_features");
        columns.put(ACCCONTACTINFO, "Contact Info");
        columns.put(ACCCONTACTINFO2, "{{contact_info}}");
        columns.put(ACCCONTACTINFOINPUT, "contact_info");
        columns.put(ACCCOMPANYDOMAIN, "Company Domain");
        columns.put(ACCCOMPANYDOMAININPUT, "company_domain");
        columns.put(ACCBUSINESSFOCUS, "Business focus");
        columns.put(ACCBUSINESSFOCUINPUT, "business_focus");
        columns.put(ACCBUSINESSFOCUS2, "{{business_focus}}");
        columns.put(ACCOFFER, "Offer description");
        columns.put(ACCOFFER1, "{{offer_description}}");
        columns.put(ACCOFFERINPUT, "offer_description");
        columns.put(ACCCOMPANY, "Company description");
        columns.put(ACCCOMPANYINPUT, "company_description");


        int failures = 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();
            try {

                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                String msg = "Missing element -> " + friendlyName + " (" + locator + ")";
                common.logPrint(msg);

                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All columns verified successfully.");
        } else {
            common.logPrint("Step :: Column verification completed with " + failures + " missing element(s).");
        }

    }

    public void verifyCancelAndBackButton() {

        goToAgentConfigurationPage();
        common.waitUntilElementToBeClickable(CREATE);
        driver.findElement(By.xpath(CREATE)).click();

        String expectedURL = "https://salesbot.cloud/agent-configuration";

        clickAndVerifyNavigation(ACCCANCELBUTTON, expectedURL, "Cancel Button");

        clickAndVerifyNavigation(ACCBACKBUTTON, expectedURL, "Back Button");
    }

    private void clickAndVerifyNavigation(String buttonXPath, String expectedURL, String buttonName) {
        try {
            common.waitUntilElementToBeClickable(buttonXPath);
            driver.findElement(By.xpath(buttonXPath)).click();
            common.pause(1);

            String currentURL = driver.getCurrentUrl();

            if (currentURL.equals(expectedURL)) {
                common.logPrint(buttonName + ": Navigation successful → " + currentURL);
            } else {
                common.logPrint(buttonName + ": Navigation FAILED → Current: " + currentURL
                        + ", Expected: " + expectedURL);
            }
        } catch (Exception e) {
            common.logPrint("ERROR :: Failed to click " + buttonName + " - " + e.getMessage());
        }
    }

    public void mandatoryFieldVerification() {
        goToAgentConfigurationPage();

        // Open create modal/page
        common.waitUntilElementToBeClickable(CREATE);
        driver.findElement(By.xpath(CREATE)).click();

        // Click save to trigger validation messages
        common.waitUntilElementToBeClickable(ACCSAVEBUTTON);
        driver.findElement(By.xpath(ACCSAVEBUTTON)).click();

        // Map of xpath -> friendly name (so logs are readable)
        Map<String, String> validations = new LinkedHashMap<>();
        validations.put(ACCVALPERSONA,      "Persona is required");
        validations.put(ACCVALPROMPT,       "Prompt is required");
        validations.put(ACCVALNAME,         "Name is required");
        validations.put(ACCVALCOMAPNYNAME,  "Company Name is required");
        validations.put(ACCVALREETINGS,     "Greeting Message is required");
        validations.put(ACCVALPERSONLITY,   "Personality is required");
        validations.put(ACCVALGOAL,         "Goal type is required");
        validations.put(ACCVALLANG,         "Language is required");
        validations.put(ACCVALCOREUSP,      "Core USPs is required");
        validations.put(ACCVALCOREFEATURE,  "Core Features is required");
        validations.put(ACCVALCONTACT,      "Contact Info is required");
        validations.put(ACCVALBUSINES,      "Business focus is required");
        validations.put(ACCVALOFFER,        "Offer description is required");
        validations.put(COMPANYDESC,        "Company description is required");

        List<String> missing = new ArrayList<>();

        // Wait/visibility timeout for each validation message (seconds)
        final int perValidationTimeoutSec = 5;

        for (Map.Entry<String, String> entry : validations.entrySet()) {
            String xpath = entry.getKey();
            String friendly = entry.getValue();

            boolean visible = isElementVisible(By.xpath(xpath), perValidationTimeoutSec);
            if (visible) {
                String msg = "Validation present: " + friendly + " -> " + xpath;
                try { common.logPrint(msg); } catch (Exception ignored) { System.out.println(msg); }
            } else {
                String msg = "Validation MISSING: " + friendly + " -> " + xpath;
                try { common.logPrint(msg); } catch (Exception ignored) { System.err.println(msg); }
                missing.add(friendly);
            }
        }

        // Final assertion: fail test if any validation message missing
        if (!missing.isEmpty()) {
            String summary = "Mandatory field validation FAILED. Missing: " + String.join(", ", missing);
            try { common.logPrint(summary); } catch (Exception ignored) { System.err.println(summary); }
            Assert.fail(summary);
        } else {
            String summary = "All mandatory field validations are present.";
            try { common.logPrint(summary); } catch (Exception ignored) { System.out.println(summary); }
        }
    }

    private boolean isElementVisible(By by, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addANewAgentValidData() {
        goToAgentConfigurationPage();
        common.waitUntilElementToBeClickable(CREATE);
        driver.findElement(By.xpath(CREATE)).click();

        common.click(ACCSELECTPERSONA);
        common.click(SALES);

        Map<String, String> agent = common.fillAgentForm();

        common.waitUntilElementToBeClickable(ACCTIMEZONEINPUT).click();
        common.type(ACCTIMEZONEINPUT,"5:30");
        common.downKeyAndEnter();

        String english = "//li[text()='English']";
        common.waitUntilElementToBeClickable(ACCLANGINPUT).click();
        common.click(english);

        System.out.println("Created agent: " + agent);


    }


}






