package Pages;

import Config.EnvConfig;
import Config.ReadProperties;
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

    Common common;

    public AgentConfigurationPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToAgentConfigurationPage() {

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
                                common.logPrint(("Failed to parse date '" + v + "' with format " + dateFormat + " — treating as null."));
                                parsed.add(null);
                            }
                        }
                        break;

                    default:
                        parsed.add(v);
                }
            } catch (NumberFormatException nfe) {
                common.logPrint("Failed to parse numeric value '" + v + "' as " + type + ". Error: " + nfe.getMessage() + ". Treating as null.");
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

        //goToProductPage();

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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void verifyActivateButton() {
        goToAgentConfigurationPage();
        common.waitUntilElementToBeVisible(REFRESH);
        WebElement btn = driver.findElement(By.xpath("//span[text()='Active']/parent::button"));

        boolean isDisabled = !btn.isEnabled();
        common.logPrint("Active button is Disabled? : " + isDisabled);
        common.assertElementPresent(ACINACTIVEGRIDSTATUS);
        driver.findElement(By.xpath("(//span[text()='Inactive'])[1]/preceding::input[@type='checkbox'][1]")).click();

        common.assertElementPresent(ACACTIVTEBUTTON);
        if (btn.isEnabled()) {
            common.logPrint("Button was Enabled as Expected ");
        } else {
            common.logPrint("Button didn't get Enabled as Expected");
        }
    }

    public void verifyActiveButtonNegative() {

        goToAgentConfigurationPage();

        common.waitUntilElementToBeVisible(REFRESH);

        WebElement btn = driver.findElement(By.xpath("//span[text()='Active']/parent::button"));
        boolean isDisabled = !btn.isEnabled();
        common.logPrint("Active button is Disabled? : " + isDisabled);

        common.assertElementPresent(ACACTIVEGRIDSTATUS);
        driver.findElement(By.xpath("(//span[text()='Active'])[2]/preceding::input[@type='checkbox'][1]")).click();

        common.assertElementPresent(ACACTIVTEBUTTON);
        if (!btn.isEnabled()) {
            common.logPrint("Button was Disabled as Expected ");
        } else {
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

    public void verifyCreatePageElements() {
        goToAgentConfigurationPage();
        common.waitUntilElementToBeVisible(CREATE);
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

    public void verifyEditPageElements() {
        goToAgentConfigurationPage();
        common.waitUntilElementToBeVisible(ACEDITBUTTON);
        driver.findElement(By.xpath(ACEDITBUTTON)).click();

        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(ACEDITHEADER, "Header");
        columns.put(ACCCANCELBUTTON, "Cancel");
        columns.put(ACRESETBUTTON, "Reset");
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

        String expectedURL = EnvConfig.getWebUrl() + "/agent-configuration";

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

        common.waitUntilElementToBeClickable(CREATE);
        driver.findElement(By.xpath(CREATE)).click();

        common.waitUntilElementToBeClickable(ACCSAVEBUTTON);
        driver.findElement(By.xpath(ACCSAVEBUTTON)).click();

        Map<String, String> validations = new LinkedHashMap<>();
        validations.put(ACCVALPERSONA, "Persona is required");
        validations.put(ACCVALPROMPT, "Prompt is required");
        validations.put(ACCVALNAME, "Name is required");
        validations.put(ACCVALCOMAPNYNAME, "Company Name is required");
        validations.put(ACCVALREETINGS, "Greeting Message is required");
        validations.put(ACCVALPERSONLITY, "Personality is required");
        validations.put(ACCVALGOAL, "Goal type is required");
        validations.put(ACCVALLANG, "Language is required");
        validations.put(ACCVALCOREUSP, "Core USPs is required");
        validations.put(ACCVALCOREFEATURE, "Core Features is required");
        validations.put(ACCVALCONTACT, "Contact Info is required");
        validations.put(ACCVALBUSINES, "Business focus is required");
        validations.put(ACCVALOFFER, "Offer description is required");
        validations.put(COMPANYDESC, "Company description is required");

        List<String> missing = new ArrayList<>();

        final int perValidationTimeoutSec = 5;

        for (Map.Entry<String, String> entry : validations.entrySet()) {
            String xpath = entry.getKey();
            String friendly = entry.getValue();

            boolean visible = isElementVisible(By.xpath(xpath), perValidationTimeoutSec);
            if (visible) {
                String msg = "Validation present: " + friendly + " -> " + xpath;
                try {
                    common.logPrint(msg);
                } catch (Exception ignored) {
                    System.out.println(msg);
                }
            } else {
                String msg = "Validation MISSING: " + friendly + " -> " + xpath;
                try {
                    common.logPrint(msg);
                } catch (Exception ignored) {
                    System.err.println(msg);
                }
                missing.add(friendly);
            }
        }

        if (!missing.isEmpty()) {
            String summary = "Mandatory field validation FAILED. Missing: " + String.join(", ", missing);
            try {
                common.logPrint(summary);
            } catch (Exception ignored) {
                System.err.println(summary);
            }
            Assert.fail(summary);
        } else {
            String summary = "All mandatory field validations are present.";
            try {
                common.logPrint(summary);
            } catch (Exception ignored) {
                System.out.println(summary);
            }
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

    public Map<String, String> addANewAgentValidData() {
        goToAgentConfigurationPage();
        common.waitUntilElementToBeClickable(CREATE);
        driver.findElement(By.xpath(CREATE)).click();

        common.click(ACCSELECTPERSONA);
        common.click(SALES);

        Map<String, String> agent = common.fillAgentForm();


        String agentName = agent.get("name");
        String companyName = agent.get("companyName");
        String greeting = agent.get("greeting");
        String personality = agent.get("personality");
        String goalType = agent.get("goalType");
        String coreUSP = agent.get("coreUSP");
        String coreFeatures = agent.get("coreFeatures");
        String contactInfo = agent.get("contactInfo");
        String companyDomain = agent.get("companyDomain");
        String businessFocus = agent.get("businessFocus");
        String offerDescription = agent.get("offerDescription");
        String companyDescription = agent.get("companyDescription");
        common.logPrint(agentName);

        common.waitUntilElementToBeClickable(ACCTIMEZONEINPUT).click();
        common.type(ACCTIMEZONEINPUT, "5:30");
        common.downKeyAndEnter();

        String english = "//li[text()='English']";
        common.waitUntilElementToBeClickable(ACCLANGINPUT).click();
        common.click(english);

        common.click(SAVEBUTTON);

        System.out.println("Created agent: " + agent);

        String searchXpath = "//input[@placeholder=\"Search...\"]";

        common.waitUntilElementToBeVisible(searchXpath);
        common.type(searchXpath, agentName);
        common.waitUntilElementToBeVisible(ACSEARCHRESULT);
        common.validateSearch(ACSEARCHRESULT, agentName);

        return agent;
    }

    public void editingAnAgent() {
        addANewAgentValidData();

        String existingUser = common.getText(ACSEARCHRESULT);
        common.waitUntilElementToBeVisible(ACEDITBUTTON);
        common.click(ACEDITBUTTON);

        common.assertElementPresent(ACEDITHEADER);


        Map<String, String> agent = common.fillAgentForm();

        common.click(SAVEBUTTON);

        System.out.println("Edited agent From: " + existingUser + " to: " + agent);
        String agentName = agent.get("name");

        String searchXpath = "//input[@placeholder=\"Search...\"]";

        common.waitUntilElementToBeVisible(searchXpath);
        common.type(searchXpath, agentName);
        common.waitUntilElementToBeVisible(ACSEARCHRESULT);
        common.validateSearch(ACSEARCHRESULT, agentName);


    }

    public void verifyUsingTheResetButton() {

        Map<String, String> agent = addANewAgentValidData();

        String agentName = agent.get("name");
        String companyName = agent.get("companyName");
        String greeting = agent.get("greeting");
        String personality = agent.get("personality");
        String goalType = agent.get("goalType");
        String coreUSP = agent.get("coreUSP");
        String coreFeatures = agent.get("coreFeatures");
        String contactInfo = agent.get("contactInfo");
        String companyDomain = agent.get("companyDomain");
        String businessFocus = agent.get("businessFocus");
        String offerDescription = agent.get("offerDescription");
        String companyDescription = agent.get("companyDescription");

        common.waitUntilElementToBeVisible(ACEDITBUTTON);
        common.click(ACEDITBUTTON);

        common.fillAgentForm();

        common.click(ACRESETBUTTON);

        assertInputValue(ACCNAMEINPUT, agentName, "Agent Name");
        assertInputValue(ACCCOMPANYNAMEINPUT, companyName, "Company Name");
        assertInputValue(ACCGREETINGINPUT, greeting, "Greeting");
        assertInputValue(ACCPERSONALITYINPUT, personality, "Personality");
        assertInputValue(ACCGOALINPUT, goalType, "Goal Type");
        assertInputValue(ACCCOREUSPINPUT, coreUSP, "Core USP");
        assertInputValue(ACCCOREFEATURESINPUT, coreFeatures, "Core Features");
        assertInputValue(ACCCONTACTINFOINPUT, contactInfo, "Contact Info");
        assertInputValue(ACCCOMPANYDOMAININPUT, companyDomain, "Company Domain");
        assertInputValue(ACCBUSINESSFOCUINPUT, businessFocus, "Business Focus");
        assertInputValue(ACCOFFERINPUT, offerDescription, "Offer Description");
        assertInputValue(ACCCOMPANYINPUT, companyDescription, "Company Description");
    }

    public void deletingAnAgent() {
        Map<String, String> agent = addANewAgentValidData();
        String existingAgentName = agent.get("name");
        common.waitUntilElementToBeVisible(ACDELETEBUTTON);
        common.click(ACDELETEBUTTON);
        WebElement cancelButton = driver.findElement(By.xpath(ACDELETECANCELBUTTON));
        common.click(ACDELETECANCELBUTTON);
        common.pause2Sec();
        if (!cancelButton.isDisplayed()) {
            common.logPrint("Cancel Button works as expected");
        } else {
            common.logPrint("Cancel button doesn't work");
        }
        common.pause(1);
        common.waitUntilElementToBeVisible(ACDELETEBUTTON);
        common.click(ACDELETEBUTTON);
        common.waitUntilElementToBeVisible(ACINNERDELETE);
        common.click(ACINNERDELETE);

        String searchXpath = "//input[@placeholder=\"Search...\"]";
        common.waitUntilElementToBeVisible(searchXpath);
        common.type(searchXpath, existingAgentName);
        common.waitUntilElementToBeVisible(ACSEARCHRESULT);
        common.validateSearch(ACSEARCHRESULT, existingAgentName);

        common.validateToaster(DeletedSuccessfully);


    }

    public void viewAddedAgent() {

        Map<String, String> agent = addANewAgentValidData();

        common.click(VIEWBUTTON);

        validateInputValue(agent.get("name"));
        validateInputValue(agent.get("greeting"));
        validateInputValue(agent.get("personality"));
        validateInputValue(agent.get("coreUSP"));
        validateInputValue(agent.get("coreFeatures"));
        validateInputValue(agent.get("contactInfo"));
    }

    public void validateInputValue(String expectedValue) {

        String xpath = "//input[@value='" + expectedValue + "']";

        common.waitUntilElementToBeVisible(xpath);
        Assert.assertTrue(
                common.isElementPresent(xpath),
                "Expected value not found in input field: " + expectedValue
        );

        common.logPrint("Validated field value → " + expectedValue);
    }

    public void activeInactive() {
        Map<String, String> agent = addANewAgentValidData();
        String name = agent.get("name");
        String searchXpath = "//input[@placeholder=\"Search...\"]";

        common.waitUntilElementToBeVisible(searchXpath);
        common.type(searchXpath, name);

        common.selectCheckbox(ACINACTIVECB);

        common.waitUntilElementToBeVisible(ACACTIVEINACTIVE);
        common.highlightElement(ACACTIVEINACTIVE);
        common.click(ACACTIVEINACTIVE);

        common.waitUntilElementToBeVisible(ACDELETECANCELBUTTON);
        common.click(ACDELETECANCELBUTTON);

        common.waitUntilElementToBeVisible(ACACTIVEINACTIVE);
        common.highlightElement(ACACTIVEINACTIVE);
        common.click(ACACTIVEINACTIVE);

        common.waitUntilElementToBeVisible(ACACTIVATEBUTTON);
        common.highlightElement(ACACTIVATEBUTTON);
        common.click(ACACTIVATEBUTTON);

        common.waitUntilElementToBeVisible(searchXpath);
        common.type(searchXpath, name);

        common.pause(1);
        WebElement ACACTIVEButton = driver.findElement(By.xpath(ACACTIVE));
        if (ACACTIVEButton.isDisplayed()) {
            common.logPrint(name + " : Agent activated successfully ");
        } else {
            common.logPrint(name + " Agent is not active ");
        }
    }

    public void horizontalViews() {
        goToAgentConfigurationPage();
        common.pause(2);
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"]");

    }

    public void pagination() {
        goToAgentConfigurationPage();
        common.pagination("//div[@class=\"MuiBox-root css-a7l4db\"]");
    }

    public void filters() {

        Map<String, String> agent = addANewAgentValidData();

        String fullName = safeTrim(agent.get("name"));   // e.g. "Smart Home Device"

        // Parse words safely (ensures at least 1 word)
        String[] nameWords = splitWordsSafely(fullName);
        String startsWith = nameWords[0];
        String middleWord = nameWords.length > 1 ? nameWords[1] : nameWords[0];
        String endsWith = nameWords[nameWords.length - 1];

        common.logPrint("Full Name: " + fullName);
        common.logPrint("Starts With: " + startsWith);
        common.logPrint("Middle Word: " + middleWord);
        common.logPrint("Ends With: " + endsWith);

        // 1) EQUALS - PRODUCT NAME
        openFilters();
        selectField(ACFILTERNAME);
        selectOperator(FILTEREQUALS);
        common.type(PHFILTERVAL, fullName);
        String resultEquals = applyAndGetFirstResult(ACSEARCHRESULT);
        common.logPrint("1. EQUALS result: " + resultEquals);
        Assert.assertEquals(resultEquals, fullName, "1. Product EQUALS filter failed");

        // 2) NOT EQUALS - PRODUCT NAME
        openFilters();
        selectField(ACFILTERNAME);
        selectOperator(FILTERNOTEQUALS);
        common.type(PHFILTERVAL, fullName);
        String resultNotEquals = applyAndGetFirstResult(ACSEARCHRESULT);
        common.logPrint("2. NOT EQUALS result: " + resultNotEquals);
        Assert.assertNotEquals(resultNotEquals, fullName, "2. Product NOT EQUALS filter failed");

        // 3) CONTAINS - PRODUCT NAME (middle word)
        openFilters();
        selectField(ACFILTERNAME);
        selectOperator(FILTERCONTAINS);
        common.type(PHFILTERVAL, middleWord);
        String resultContains = applyAndGetFirstResult(ACSEARCHRESULT);
        common.logPrint("3. CONTAINS result: " + resultContains);
        Assert.assertTrue(resultContains.contains(middleWord),
                "3. Product CONTAINS filter failed: expected to contain '" + middleWord + "' but was '" + resultContains + "'");

        // 4) BEGINS WITH - PRODUCT NAME
        openFilters();
        selectField(ACFILTERNAME);
        selectOperator(FILTERBEGINSWITH);
        common.type(PHFILTERVAL, startsWith);
        String resultBegins = applyAndGetFirstResult(ACSEARCHRESULT);
        common.logPrint("4. BEGINS WITH result: " + resultBegins);
        Assert.assertTrue(resultBegins.startsWith(startsWith),
                "4. Product BEGINS WITH filter failed: expected to start with '" + startsWith + "' but was '" + resultBegins + "'");

        // 5) ENDS WITH - PRODUCT NAME
        openFilters();
        selectField(ACFILTERNAME);
        selectOperator(FILTERENDSWITH);
        common.type(PHFILTERVAL, endsWith);
        String resultEnds = applyAndGetFirstResult(ACSEARCHRESULT);
        common.logPrint("5. ENDS WITH result: " + resultEnds);
        Assert.assertTrue(resultEnds.endsWith(endsWith),
                "5. Product ENDS WITH filter failed: expected to end with '" + endsWith + "' but was '" + resultEnds + "'");
    }

    public void createAndViewReflectionInPlayground() {

        String url = EnvConfig.getWebUrl();

        Map<String, String> agent = addANewAgentValidData();
        String name = agent.get("name");
        String playgroundURL = url + "playground";
        common.logPrint("Url: " + playgroundURL);
        driver.get(playgroundURL);


        common.waitUntilElementToBeVisible(ACPLAYGROUNDHEADER);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("playground"), "Expected to navigate to Playground but landed on: " + currentURL);
        common.highlightElement(ACPLAYGROUNDHEADER);
        common.type(ACPLAYGROUNDSELECTAGENT, name);
        common.downKeyAndEnter();

        String validateCommon = common.getAttribute(ACPLAYGROUNDSELECTAGENT, "value");
        common.pause(1);
        common.logPrint("Selected Agent's name: " + validateCommon);

        if (validateCommon.equals(name)) {
            common.logPrint("Selected Agent Matches the newly created agent");
        } else {
            common.logPrint("Selected agent is different than the created one");
        }

    }

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
            return new String[]{""};
        }
        String[] parts = input.split("\\s+");
        return parts.length == 0 ? new String[]{input} : parts;
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }

    public void assertInputValue(String locator, String expected, String fieldName) {
        common.waitUntilElementToBeVisible(locator);
        String actual = driver.findElement(By.xpath(locator))
                .getAttribute("value")
                .trim();

        common.logPrint("Verifying " + fieldName +
                " | Expected: [" + expected + "] | Actual: [" + actual + "]");

        Assert.assertEquals(actual, expected, fieldName + " value mismatch");
    }

}