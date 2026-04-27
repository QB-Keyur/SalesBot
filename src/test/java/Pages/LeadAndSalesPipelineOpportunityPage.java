package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeadAndSalesPipelineOpportunityPage extends Locators {

    private static final DateTimeFormatter CLOSE_DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private final Common common;

    public LeadAndSalesPipelineOpportunityPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToOpportunityPage() {
        if (isOpportunityPageLoaded()) {
            return;
        }

        clickIfPresent(LEADMANAGMENT);
        clickIfPresent("//span[normalize-space()='Lead & Sales Pipeline']/ancestor::button | //button[normalize-space()='Lead & Sales Pipeline']");
        clickIfPresent("//span[normalize-space()='Opportunity']/ancestor::button | //button[normalize-space()='Opportunity']");

        if (!isOpportunityPageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "lead-and-sales-pipeline/opportunity");
            common.pause(1);
        }

        if (!isOpportunityPageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "lead-sales-pipeline/opportunity");
            common.pause(1);
        }

        common.waitUntilElementToBeVisible(OPPORTUNITY_HEADER);
    }

    public void openCreateOpportunityPage() {
        goToOpportunityPage();

        if (isCreateOpportunityPageLoaded()) {
            return;
        }

        common.waitUntilElementToBeClickable(OPPORTUNITY_CREATE);
        common.click(OPPORTUNITY_CREATE);
        common.waitUntilElementToBeVisible(OPPORTUNITY_CREATE_HEADER);
    }

    public void verifyOpportunityPageElements() {
        goToOpportunityPage();

        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(OPPORTUNITY_HEADER, "Opportunity page header is displayed");
        columns.put(OPPORTUNITY_SEARCH, "Opportunity search bar is visible");
        columns.put(OPPORTUNITY_FILTERS, "Opportunity filter button is available");
        columns.put(OPPORTUNITY_CREATE, "Opportunity create button is present");
        columns.put(OPPORTUNITY_LIST_TAB, "Opportunity list tab is present");
        columns.put(OPPORTUNITY_SR_NO, "Opportunity Sr No. column is displayed");
        columns.put(OPPORTUNITY_NAME_HEADER, "Opportunity name column is displayed");
        columns.put(OPPORTUNITY_CUSTOMER_NAME_HEADER, "Customer name column is displayed");
        columns.put(OPPORTUNITY_ESTIMATED_BUDGET_HEADER, "Estimated budget column is displayed");
        columns.put(OPPORTUNITY_EXPECTED_CLOSE_DATE_HEADER, "Expected close date column is displayed");
        columns.put(OPPORTUNITY_STATUS_HEADER, "Status column is displayed");
        columns.put(OPPORTUNITY_CREATED_DATE_HEADER, "Created date column is displayed");
        columns.put(OPPORTUNITY_ACTIONS_HEADER, "Actions column is displayed");
        columns.put(PAGINATION_SHOW_DROPDOWN, "Opportunity show rows dropdown is visible");
        columns.put(PAGINATION_PREVIOUS, "Opportunity previous page button is available");
        columns.put(PAGINATION_NEXT, "Opportunity next page button is available");

        int failures = 0;
        for (Map.Entry<String, String> entry : columns.entrySet()) {
            try {
                common.assertElementPresent(entry.getKey());
                common.logPrint("Step :: Verified presence of: " + entry.getValue());
            } catch (Exception e) {
                failures++;
                common.logPrint("Missing element -> " + entry.getValue() + " (" + entry.getKey() + ")");
                common.logPrint("DEBUG :: " + e);
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All Opportunity list page elements verified successfully.");
        } else {
            common.logPrint("Step :: Opportunity list page verification completed with " + failures + " missing element(s).");
        }

        if (hasRows()) {
            OpportunityRowData row = getFirstRowData();
            common.assertElementPresent(rowActionButton(1));
            common.assertElementPresent(rowActionButton(2));
            common.assertElementPresent(rowActionButton(3));
            Assert.assertNotNull(row, "Opportunity row should not be null when rows exist");
        }
    }

    public void     verifyCreateOpportunityPageElements() {
        openCreateOpportunityPage();

        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(OPPORTUNITY_CREATE_HEADER, "Create Opportunity page header is displayed");
        columns.put(OPPORTUNITY_CREATE_CANCEL, "Create Opportunity cancel button is visible");
        columns.put(OPPORTUNITY_CREATE_SAVE, "Create Opportunity save button is visible");
        columns.put(OPPORTUNITY_CREATE_BASIC_DETAILS, "Basic Details section is displayed");
        columns.put(OPPORTUNITY_CREATE_NAME, "Opportunity name field is visible");
        columns.put(OPPORTUNITY_CREATE_CONTACT, "Contact field is visible");
        columns.put(OPPORTUNITY_CREATE_CUSTOMER, "Customer field is visible");
        columns.put(OPPORTUNITY_CREATE_ESTIMATED_BUDGET, "Estimated budget field is visible");
        columns.put(OPPORTUNITY_CREATE_CONVERSION_PROBABILITY, "Conversion probability field is visible");
        columns.put(OPPORTUNITY_CREATE_EXPECTED_CLOSE_DATE, "Expected close date field is visible");
        columns.put(OPPORTUNITY_CREATE_ASSIGNEE, "Assignee field is visible");
        columns.put(OPPORTUNITY_CREATE_REQUIREMENT, "Requirement field is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_SECTION, "Product section is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_SEARCH, "Product search field is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_ADD, "Add button is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE, "Product table is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_NAME, "Product table name column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_QTY, "Product table qty column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_UNIT, "Product table unit column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_PRICE, "Product table price column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_TAX, "Product table tax column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_DISCOUNT, "Product table discount column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_TOTAL, "Product table total column is visible");
        columns.put(OPPORTUNITY_CREATE_PRODUCT_TABLE_ACTION, "Product table action column is visible");
        columns.put(OPPORTUNITY_CREATE_ORDER_SUMMARY, "Order summary section is visible");
        columns.put(OPPORTUNITY_CREATE_ORDER_SUBTOTAL, "Order subtotal is visible");
        columns.put(OPPORTUNITY_CREATE_ORDER_DISCOUNT, "Order discount is visible");
        columns.put(OPPORTUNITY_CREATE_ORDER_TAX, "Order tax is visible");
        columns.put(OPPORTUNITY_CREATE_ORDER_TOTAL, "Order grand total is visible");

        int failures = 0;
        for (Map.Entry<String, String> entry : columns.entrySet()) {
            try {
                common.assertElementPresent(entry.getKey());
                common.logPrint("Step :: Verified presence of: " + entry.getValue());
            } catch (Exception e) {
                failures++;
                common.logPrint("Missing element -> " + entry.getValue() + " (" + entry.getKey() + ")");
                common.logPrint("DEBUG :: " + e);
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All Opportunity create page elements verified successfully.");
        } else {
            common.logPrint("Step :: Opportunity create page verification completed with " + failures + " missing element(s).");
        }

        common.click(OPPORTUNITY_CREATE_CANCEL);
        common.waitUntilElementToBeVisible(OPPORTUNITY_HEADER);
    }

    public String createOpportunityAndReturnName() {
        openCreateOpportunityPage();

        String opportunityName = "Opportunity " + common.generateRandomChars(8);
        fillOpportunityForm(opportunityName);
        saveOpportunityForm();

        common.waitUntilElementToBeVisible(OPPORTUNITY_COUNT);

        common.pause(5);
        searchOpportunityByName(opportunityName);
        assertOpportunityRowVisible(opportunityName);
        return opportunityName;
    }

    public String updateCreatedOpportunity() {
        String originalName = createOpportunityAndReturnName();
        searchOpportunityByName(originalName);
        clickRowActionByOpportunityName(originalName, 2);

        String updatedName = originalName + " Updated";
        common.waitUntilElementToBeVisible(OPPORTUNITY_CREATE_NAME);
        common.clear(OPPORTUNITY_CREATE_NAME);
        common.type(OPPORTUNITY_CREATE_NAME, updatedName);
        common.clear(OPPORTUNITY_CREATE_REQUIREMENT);
        common.type(OPPORTUNITY_CREATE_REQUIREMENT, "Updated requirement " + common.generateRandomChars(6));
        common.clear(OPPORTUNITY_CREATE_ESTIMATED_BUDGET);
        common.type(OPPORTUNITY_CREATE_ESTIMATED_BUDGET, String.valueOf(Common.generateRandomInteger(1000, 9999)));

        saveOpportunityForm();
        searchOpportunityByName(updatedName);
        assertOpportunityRowVisible(updatedName);
        Assert.assertTrue(driver.findElements(By.xpath(rowByOpportunityName(originalName))).isEmpty(),
                "Old opportunity row should not remain after update");
        return updatedName;
    }

    public String deleteCreatedOpportunity() {
        String opportunityName = createOpportunityAndReturnName();
        searchOpportunityByName(opportunityName);
        clickRowActionByOpportunityName(opportunityName, 3);

        common.waitUntilElementToBeVisible(OPPORTUNITY_DELETE_CONFIRM_BUTTON);
        common.assertElementPresent(OPPORTUNITY_CANCEL_BUTTON);
        common.assertElementPresent(OPPORTUNITY_DELETE_CONFIRM_BUTTON);

        common.click(OPPORTUNITY_DELETE_CONFIRM_BUTTON);
        common.pause(2);

        searchOpportunityByName(opportunityName);
        Assert.assertTrue(driver.findElements(By.xpath(rowByOpportunityName(opportunityName))).isEmpty(),
                "Opportunity row still present after delete: " + opportunityName);
        return opportunityName;
    }

    public void verifySearchOnOpportunityPageIfDataExists() {
        goToOpportunityPage();

        OpportunityRowData row = getFirstRowData();
        if (row == null || row.getOpportunityName().isBlank()) {
            throw new SkipException("No Opportunity data available for search validation");
        }

        searchOpportunityByName(row.getOpportunityName());
        assertOpportunityRowVisible(row.getOpportunityName());
    }

    public void verifySortingOnOpportunityPageIfDataExists() {
        goToOpportunityPage();

        if (!hasRows()) {
            throw new SkipException("No Opportunity data available for sorting validation");
        }

        clickHeader(OPPORTUNITY_NAME_HEADER);
        common.pause(1);
        List<String> ascending = collectColumnValues(2);
        Assert.assertFalse(ascending.isEmpty(), "No opportunity rows available after ascending sort");
        Assert.assertEquals(
                ascending.get(0),
                ascending.stream().min(String.CASE_INSENSITIVE_ORDER).orElse(""),
                "Opportunity Name ascending sort failed"
        );

        clickHeader(OPPORTUNITY_NAME_HEADER);
        common.pause(1);
        List<String> descending = collectColumnValues(2);
        Assert.assertFalse(descending.isEmpty(), "No opportunity rows available after descending sort");
        Assert.assertEquals(
                descending.get(0),
                descending.stream().max(String.CASE_INSENSITIVE_ORDER).orElse(""),
                "Opportunity Name descending sort failed"
        );
    }

    public void verifyPaginationOnOpportunityPageIfDataExists() {
        goToOpportunityPage();

        common.assertElementPresent(PAGINATION_SHOW_DROPDOWN);
        common.assertElementPresent(PAGINATION_PREVIOUS);
        common.assertElementPresent(PAGINATION_NEXT);

        if (!common.isElementDisabled(PAGINATION_NEXT)) {
            common.click(PAGINATION_NEXT);
            common.pause(1);
            common.click(PAGINATION_PREVIOUS);
        }
    }

    private boolean isOpportunityPageLoaded() {
        return !driver.findElements(By.xpath(OPPORTUNITY_HEADER)).isEmpty();
    }

    private boolean isCreateOpportunityPageLoaded() {
        return !driver.findElements(By.xpath(OPPORTUNITY_CREATE_HEADER)).isEmpty();
    }

    private void clickIfPresent(String xpath) {
        if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
            common.click(xpath);
            common.pause(1);
        }
    }

    private boolean hasRows() {
        return !driver.findElements(By.xpath(OPPORTUNITY_FIRST_ROW)).isEmpty();
    }

    public OpportunityRowData getFirstRowData() {
        if (!hasRows()) {
            return null;
        }

        return new OpportunityRowData(
                safeText(OPPORTUNITY_NAME_CELL),
                safeText(OPPORTUNITY_CUSTOMER_NAME_CELL),
                safeText(OPPORTUNITY_ESTIMATED_BUDGET_CELL),
                safeText(OPPORTUNITY_EXPECTED_CLOSE_DATE_CELL),
                safeText(OPPORTUNITY_STATUS_CELL),
                safeText(OPPORTUNITY_CREATED_DATE_CELL)
        );
    }

    private String safeText(String xpath) {
        try {
            return common.getText(xpath).trim();
        } catch (Exception e) {
            return "";
        }
    }

    private String rowByIndex(int buttonIndex) {
        return "(//tbody/tr)[1]/td[last()]//button[" + buttonIndex + "]";
    }

    private String rowByOpportunityName(String opportunityName) {
        return "//tbody/tr[td[2][normalize-space()='" + opportunityName + "']]";
    }

    private String rowActionButton(int buttonIndex) {
        return rowByIndex(buttonIndex);
    }

    private void searchOpportunityByName(String opportunityName) {
        common.waitUntilElementToBeVisible(OPPORTUNITY_SEARCH);
        common.clear(OPPORTUNITY_SEARCH);
        common.type(OPPORTUNITY_SEARCH, opportunityName);
        common.pause(1);
    }

    private void assertOpportunityRowVisible(String opportunityName) {
        Assert.assertFalse(driver.findElements(By.xpath(rowByOpportunityName(opportunityName))).isEmpty(),
                "Opportunity row not found in the grid: " + opportunityName);
    }

    private void clickRowActionByOpportunityName(String opportunityName, int buttonIndex) {
        String actionButton = rowByOpportunityName(opportunityName) + "//td[last()]//button[" + buttonIndex + "]";
        common.waitUntilElementToBeVisible(actionButton);
        common.click(actionButton);
    }

    private void fillOpportunityForm(String opportunityName) {
        common.waitUntilElementToBeVisible(OPPORTUNITY_CREATE_NAME);
        common.type(OPPORTUNITY_CREATE_NAME, opportunityName);

        common.waitUntilElementToBeVisible(OPPORTUNITY_CREATE_CONTACT);
        selectAutocompleteValue(OPPORTUNITY_CREATE_CONTACT, "A");
        common.pause(1);

        common.waitUntilElementToBeVisible(OPPORTUNITY_CREATE_CUSTOMER);
        Assert.assertTrue(common.isElementDisabled(OPPORTUNITY_CREATE_CUSTOMER),
                "Customer field should remain disabled and auto-filled after contact selection");

        common.type(OPPORTUNITY_CREATE_ESTIMATED_BUDGET, String.valueOf(Common.generateRandomInteger(1000, 9999)));
        common.type(OPPORTUNITY_CREATE_CONVERSION_PROBABILITY, String.valueOf(Common.generateRandomInteger(10, 90)));

        setDateInput(OPPORTUNITY_CREATE_EXPECTED_CLOSE_DATE, LocalDate.now().plusDays(7).format(CLOSE_DATE_FORMAT));

        selectAutocompleteValue(OPPORTUNITY_CREATE_ASSIGNEE, "A");
        common.type(OPPORTUNITY_CREATE_REQUIREMENT, "Requirement " + common.generateRandomChars(8));

        selectAutocompleteValue(OPPORTUNITY_SELECT_PRODUCT, "A");



        if (!common.isElementDisabled(OPPORTUNITY_CREATE_PRODUCT_ADD)) {
            common.click(OPPORTUNITY_CREATE_PRODUCT_ADD);
        }
    }

    private void saveOpportunityForm() {
        common.waitUntilElementToBeClickable(OPPORTUNITY_CREATE_SAVE);
        common.click(OPPORTUNITY_CREATE_SAVE);
        common.waitUntilElementToBeVisible(OPPORTUNITY_HEADER);
        common.pause(2);
    }

    private void clickHeader(String headerXpath) {
        common.waitUntilElementToBeVisible(headerXpath);
        common.click(headerXpath);
    }

    private List<String> collectColumnValues(int columnIndex) {
        List<WebElement> rows = driver.findElements(By.xpath(OPPORTUNITY_TABLE_ROWS));
        List<String> values = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td[" + columnIndex + "]"));
            if (!cells.isEmpty()) {
                String value = cells.get(0).getText();
                values.add(value == null ? "" : value.trim());
            }
        }

        return values;
    }

//    private void selectAutocompleteValue(String inputLocator, String seed) {
//        common.waitUntilElementToBeClickable(inputLocator);
//        WebElement element = driver.findElement(By.xpath(inputLocator));
//        element.click();
//        if (seed != null && !seed.isBlank()) {
//            element.sendKeys(seed);
//        }
//        common.pause(1);
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ENTER);
//    }

    private void selectAutocompleteValue(String inputLocator, String seed) {

        common.waitUntilElementToBeClickable(inputLocator);
        WebElement element = driver.findElement(By.xpath(inputLocator));

        char start = (seed != null && !seed.isBlank()) ? seed.toUpperCase().charAt(0) : 'A';

        for (char ch = start; ch <= 'Z'; ch++) {

            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE); // safer clear
            element.sendKeys(String.valueOf(ch));

            // wait for dropdown options (better than pause)
            List<WebElement> options = waitForOptions();

            if (options.isEmpty()) {
                continue;
            }

            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.ENTER);

            common.pause(2); // small wait for mapping

            if (isCustomerMapped(OPPORTUNITY_CREATE_CUSTOMER)) {
                System.out.println("✅ Selected valid contact using: " + ch);
                return;
            } else {
                // reset field properly
                element.click();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            }
        }

        throw new RuntimeException("❌ No valid contact found from A-Z");
    }

    private boolean isCustomerMapped(String customerLocator) {
        try {
            WebElement customer = driver.findElement(By.xpath(customerLocator));
            String value = customer.getAttribute("value");

            if (value != null && !value.trim().isEmpty()) {
                common.logPrint("✅ Customer Selected: " + value);
                return true;
            } else {
                common.logPrint("❌ Customer NOT Selected");
                return false;
            }

        } catch (Exception e) {
            common.logPrint("❌ Customer field not found");
            return false;
        }
    }
    private List<WebElement> waitForOptions() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            return wait.until(driver -> {
                List<WebElement> opts = driver.findElements(By.xpath("//ul[@role=\"listbox\"]"));
                return opts.size() > 0 ? opts : null;
            });
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    private void setDateInput(String inputLocator, String value) {
        WebElement element = driver.findElement(By.xpath(inputLocator));
        ((JavascriptExecutor) driver).executeScript(
                "const el = arguments[0]; const val = arguments[1];" +
                        "const setter = Object.getOwnPropertyDescriptor(HTMLInputElement.prototype, 'value').set;" +
                        "setter.call(el, val);" +
                        "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "el.dispatchEvent(new Event('change', { bubbles: true }));",
                element, value
        );
    }

    public static class OpportunityRowData {
        private final String opportunityName;
        private final String customerName;
        private final String estimatedBudget;
        private final String expectedCloseDate;
        private final String status;
        private final String createdDate;

        public OpportunityRowData(String opportunityName, String customerName, String estimatedBudget, String expectedCloseDate, String status, String createdDate) {
            this.opportunityName = opportunityName;
            this.customerName = customerName;
            this.estimatedBudget = estimatedBudget;
            this.expectedCloseDate = expectedCloseDate;
            this.status = status;
            this.createdDate = createdDate;
        }

        public String getOpportunityName() {
            return opportunityName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getEstimatedBudget() {
            return estimatedBudget;
        }

        public String getExpectedCloseDate() {
            return expectedCloseDate;
        }

        public String getStatus() {
            return status;
        }

        public String getCreatedDate() {
            return createdDate;
        }
    }
}
