package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.Year;



public class LeadAndSalesPipelineLeadPage extends Locators {

    private static final DateTimeFormatter LEAD_DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    private final Common common;

    public LeadAndSalesPipelineLeadPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToLeadAndSalesPipelineLeadPage() {
        if (isLeadPipelinePageLoaded()) {
            return;
        }

        clickIfPresent(LEADMANAGMENT);
        clickIfPresent("//span[normalize-space()='Lead & Sales Pipeline']/ancestor::button | //button[normalize-space()='Lead & Sales Pipeline']");
        clickIfPresent(LEAD);

        if (!isLeadPipelinePageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "lead-and-sales-pipeline/lead");
            common.pause(1);
        }

        if (!isLeadPipelinePageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "lead-sales-pipeline/lead");
            common.pause(1);
        }

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_HEADER);
    }

    public void openCreateLeadPage() {
        goToLeadAndSalesPipelineLeadPage();

        if (isCreateLeadPageLoaded()) {
            return;
        }

        common.waitUntilElementToBeClickable(LEAD_PIPELINE_CREATE);
        common.click(LEAD_PIPELINE_CREATE);
        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_HEADER);
    }

    public void verifyLeadPipelinePageElements() {
        goToLeadAndSalesPipelineLeadPage();

        common.assertElementPresent(LEAD_PIPELINE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_COUNT);
        common.assertElementPresent(LEAD_PIPELINE_SEARCH);
        common.assertElementPresent(LEAD_PIPELINE_FILTERS);
        common.assertElementPresent(LEAD_PIPELINE_EXPORT);
        common.assertElementPresent(LEAD_PIPELINE_PIPELINE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE);
        common.assertElementPresent(LEAD_PIPELINE_LIST_TAB);
        common.assertElementPresent(LEAD_PIPELINE_GRID_TAB);
        common.assertElementPresent(LEAD_PIPELINE_SR_NO);
        common.assertElementPresent(LEAD_PIPELINE_LEAD_NAME_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CONTACT_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CONTACT_DETAILS_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_SOURCE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_TYPE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_STATUS_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_ASSIGNEE_FIRST_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_ASSIGNEE_LAST_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CALENDLY_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_MEETING_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_PREFERRED_DATE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_PREFERRED_TIME_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CREATION_TYPE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CREATED_DATE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_ACTIONS_HEADER);
        common.assertElementPresent(PAGINATION_PREVIOUS);
        common.assertElementPresent(PAGINATION_NEXT);
        common.assertElementPresent(PAGINATION_SHOW_DROPDOWN);

        if (hasRows()) {
            LeadPipelineRowData row = getFirstRowData();
            common.assertElementPresent(rowActionButton(row.getLeadName(), 1));
            common.assertElementPresent(rowActionButton(row.getLeadName(), 2));
            common.assertElementPresent(rowActionButton(row.getLeadName(), 3));
        }
    }

    public void verifyCreateLeadPageElements() {
        openCreateLeadPage();

        common.assertElementPresent(LEAD_PIPELINE_CREATE_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_CANCEL);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_SAVE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_BASIC_DETAILS);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_LEAD_NAME);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_CONTACT);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_CUSTOMER);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_LEAD_SOURCE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_LEAD_TYPE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_PREFERRED_DATE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_PREFERRED_TIME);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_ASSIGNEE);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_DESCRIPTION);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_PRODUCT_HEADER);
        common.assertElementPresent(LEAD_PIPELINE_CREATE_SELECT_PRODUCT);
        common.assertElementPresent(PAGINATION_SHOW_DROPDOWN);

        Assert.assertTrue(common.isElementDisabled(LEAD_PIPELINE_CREATE_CUSTOMER), "Customer field should be disabled before contact selection");
        Assert.assertTrue(common.isElementDisabled(LEAD_PIPELINE_CREATE_PREFERRED_TIME), "Preferred Time Slot should be disabled before preferred date selection");
        Assert.assertTrue(common.isElementDisabled(LEAD_PIPELINE_CREATE_ASSIGNEE), "Assignee should be disabled before preferred date/time selection");

        common.click(LEAD_PIPELINE_CREATE_CANCEL);
        common.waitUntilElementToBeVisible(LEAD_PIPELINE_HEADER);
    }

    public LeadDraft createLeadWithMappedContactAndProduct() {
        openCreateLeadPage();

        LeadDraft draft = buildLeadDraft();
        fillLeadForm(draft);
        saveLeadForm();

        searchLeadByName(draft.leadName);
        common.waitUntilElementToBeVisible("//tbody/tr[1]/td[2]");

        common.assertElementPresent("//tbody/tr[1]/td[2]");
        return draft;
    }

    public String createLeadAndReturnName() {
        return createLeadWithMappedContactAndProduct().leadName;
    }

    public String editCreatedLead() {
        String originalLeadName = createLeadAndReturnName();
//        searchLeadByName(originalLeadName);

        common.waitUntilElementToBeVisible("//tbody//tr[1]//button");
        common.click("//tbody//tr[1]//button");

        common.waitUntilElementToBeVisible("//span[contains(text(),'Edit')]");
        common.click("//span[contains(text(),'Edit')]");
//
//        clickRowActionByLeadName(originalLeadName, 2);
//        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_LEAD_NAME);

        String updatedLeadName = originalLeadName + " Edited";
        common.type(LEAD_PIPELINE_CREATE_LEAD_NAME, updatedLeadName);
        common.type(LEAD_PIPELINE_CREATE_DESCRIPTION, "Updated " + common.generateRandomChars(12));

        saveLeadForm();

        searchLeadByName(updatedLeadName);
        assertLeadRowVisible(updatedLeadName);
        return updatedLeadName;
    }

    public void deleteLead() {
        String leadName = createLeadAndReturnName();
        searchLeadByName(leadName);

        common.waitUntilElementToBeVisible("//tbody//tr[1]//button");
        common.click("//tbody//tr[1]//button");

        common.waitUntilElementToBeVisible("//span[contains(text(),'Edit')]");
        common.click("//span[contains(text(),'Delete')]");

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_DELETE_CONFIRM_BUTTON);
        common.assertElementPresent(LEAD_PIPELINE_CANCEL_BUTTON);
        common.assertElementPresent(LEAD_PIPELINE_DELETE_CONFIRM_BUTTON);

        common.click(LEAD_PIPELINE_DELETE_CONFIRM_BUTTON);
        common.pause(2);

        goToLeadAndSalesPipelineLeadPage();
        searchLeadByName(leadName);
        Assert.assertTrue(driver.findElements(By.xpath(rowByLeadName(leadName))).isEmpty(),
                "Lead still present after delete: " + leadName);
    }

    public LeadPipelineRowData getFirstRowData() {
        goToLeadAndSalesPipelineLeadPage();

        if (!hasRows()) {
            return null;
        }

        return new LeadPipelineRowData(
                safeText(LEAD_PIPELINE_LEAD_NAME_CELL),
                safeText(LEAD_PIPELINE_CONTACT_CELL),
                safeText(LEAD_PIPELINE_CONTACT_DETAILS_CELL),
                safeText(LEAD_PIPELINE_SOURCE_CELL),
                safeText(LEAD_PIPELINE_TYPE_CELL),
                safeText(LEAD_PIPELINE_STATUS_CELL),
                safeText(LEAD_PIPELINE_ASSIGNEE_FIRST_CELL),
                safeText(LEAD_PIPELINE_ASSIGNEE_LAST_CELL),
                safeText(LEAD_PIPELINE_CREATED_DATE_CELL)
        );
    }

    public void verifySearchWithFirstRowData(LeadPipelineRowData row) {
        goToLeadAndSalesPipelineLeadPage();

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_SEARCH);
        common.clear(LEAD_PIPELINE_SEARCH);
        common.type(LEAD_PIPELINE_SEARCH, row.getLeadName());
        common.pause(1);

        String result = safeText(LEAD_PIPELINE_LEAD_NAME_CELL);
        Assert.assertTrue(
                result.contains(row.getLeadName()),
                "Search result mismatch. Expected to contain '" + row.getLeadName() + "' but found '" + result + "'"
        );
    }

    public void verifyFiltersWithFirstRowData(LeadPipelineRowData row) {
        goToLeadAndSalesPipelineLeadPage();

        common.refreshPage();
        common.pause(1);
        common.waitUntilElementToBeClickable(LEAD_PIPELINE_FILTERS);
        common.click(LEAD_PIPELINE_FILTERS);

        common.waitUntilElementToBeClickable(PHFILTERSEACRH);
        common.click(PHFILTERSEACRH);
        selectFilterOption("Lead Name");

        common.waitUntilElementToBeClickable(PHFILTEROPERATOR);
        common.click(PHFILTEROPERATOR);
        common.waitUntilElementToBeVisible(FILTEREQUALS);
        common.click(FILTEREQUALS);

        common.waitUntilElementToBeVisible(PHFILTERVAL);
        common.clear(PHFILTERVAL);
        common.type(PHFILTERVAL, row.getLeadName());

        common.waitUntilElementToBeClickable(APPLYFILTER);
        common.click(APPLYFILTER);
        common.pause(1);

        String result = safeText(LEAD_PIPELINE_LEAD_NAME_CELL);
        Assert.assertTrue(
                result.contains(row.getLeadName()),
                "Filter result mismatch. Expected to contain '" + row.getLeadName() + "' but found '" + result + "'"
        );
    }

    public void verifyLeadNameSorting() {
        goToLeadAndSalesPipelineLeadPage();

        clickHeader(LEAD_PIPELINE_LEAD_NAME_HEADER);
        common.pause(1);
        List<String> ascending = collectColumnValues(2);
        Assert.assertFalse(ascending.isEmpty(), "No lead rows available after ascending sort");
        Assert.assertEquals(
                ascending.get(0),
                ascending.stream().min(String.CASE_INSENSITIVE_ORDER).orElse(""),
                "Lead Name ascending sort failed"
        );

        clickHeader(LEAD_PIPELINE_LEAD_NAME_HEADER);
        common.pause(1);
        List<String> descending = collectColumnValues(2);
        Assert.assertFalse(descending.isEmpty(), "No lead rows available after descending sort");
        Assert.assertEquals(
                descending.get(0),
                descending.stream().max(String.CASE_INSENSITIVE_ORDER).orElse(""),
                "Lead Name descending sort failed"
        );
    }

    public void verifyViewFirstRow() {
        goToLeadAndSalesPipelineLeadPage();
        if (!hasRows()) {
            return;
        }

        LeadPipelineRowData row = getFirstRowData();
        String viewButton = rowActionButton(row.getLeadName(), 1);
        common.waitUntilElementToBeVisible(viewButton);
        common.click(viewButton);
        common.pause(1);
    }

    public void verifyEditFirstRow() {
        goToLeadAndSalesPipelineLeadPage();
        if (!hasRows()) {
            return;
        }

        LeadPipelineRowData row = getFirstRowData();
        String editButton = rowActionButton(row.getLeadName(), 2);
        common.waitUntilElementToBeVisible(editButton);
        common.click(editButton);
        common.pause(1);
    }

    public void verifyDeleteFirstRowDialog() {
        goToLeadAndSalesPipelineLeadPage();
        if (!hasRows()) {
            return;
        }

        LeadPipelineRowData row = getFirstRowData();
        String deleteButton = rowActionButton(row.getLeadName(), 3);
        common.waitUntilElementToBeVisible(deleteButton);
        common.click(deleteButton);

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CANCEL_BUTTON);
        common.assertElementPresent(LEAD_PIPELINE_CANCEL_BUTTON);
        common.assertElementPresent(LEAD_PIPELINE_DELETE_CONFIRM_BUTTON);

        common.click(LEAD_PIPELINE_CANCEL_BUTTON);
    }

    private LeadDraft buildLeadDraft() {
        LeadDraft draft = new LeadDraft();
        draft.leadName = "Lead " + common.fakeName();
        draft.description = "Auto generated lead " + common.generateRandomChars(8);
        draft.preferredDate = LocalDate.now().plusDays(1).format(LEAD_DATE_FORMAT);
        return draft;
    }

    private void fillLeadForm(LeadDraft draft) {
        String currentYear = String.valueOf(Year.now().getValue());
        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_LEAD_NAME);
        common.type(LEAD_PIPELINE_CREATE_LEAD_NAME, draft.leadName);

        ContactSelection selection = selectContactWithMappedCustomer();
        draft.contactName = selection.contactName;
        draft.customerName = selection.customerName;

//        selectFirstAutocompleteValue(LEAD_PIPELINE_CREATE_LEAD_SOURCE);
//        draft.leadSource = safeValue(LEAD_PIPELINE_CREATE_LEAD_SOURCE);
//
//        selectFirstAutocompleteValue(LEAD_PIPELINE_CREATE_LEAD_TYPE);
//        draft.leadType = safeValue(LEAD_PIPELINE_CREATE_LEAD_TYPE);

        selectFirstAutocompleteValue(LEAD_PIPELINE_CREATE_LEAD_SOURCE);
        draft.leadSource = safeValue(LEAD_PIPELINE_CREATE_LEAD_SOURCE);

        selectFirstAutocompleteValue(LEAD_PIPELINE_CREATE_LEAD_TYPE);
        draft.leadType = safeValue(LEAD_PIPELINE_CREATE_LEAD_TYPE);

//        setDateField(LEAD_PIPELINE_CREATE_PREFERRED_DATE, draft.preferredDate);
//        waitUntilEnabled(LEAD_PIPELINE_CREATE_PREFERRED_TIME);
//        selectFirstAutocompleteValue(LEAD_PIPELINE_CREATE_PREFERRED_TIME);
//        draft.preferredTimeSlot = safeValue(LEAD_PIPELINE_CREATE_PREFERRED_TIME);

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_PREFERRED_DATE);
        common.click(LEAD_PIPELINE_CREATE_PREFERRED_DATE);

        common.pause(1);
        common.waitUntilElementToBeVisible("//p[text()='" + currentYear + "']/following::button[2]");
        common.click("//p[text()='" + currentYear + "']/following::button[2]");

        int randomDay = Common.generateRandomInteger(1, 28);
        String dayButton = "//button[normalize-space()='" + randomDay + "']";
        common.waitUntilElementToBeVisible(dayButton);
        common.click(dayButton);

        selectPreferredTimeAndAssignee(draft);

        common.type(LEAD_PIPELINE_CREATE_DESCRIPTION, draft.description);

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_SELECT_PRODUCT);
        common.click(LEAD_PIPELINE_CREATE_SELECT_PRODUCT);

        common.waitUntilElementToBeVisible("(//input[@type='checkbox']/parent::span)[2]");
        common.click("(//input[@type='checkbox']/parent::span)[2]");

        common.waitUntilElementToBeVisible("(//span[contains(text(),'Save')])[2]/parent::button");
        common.click("(//span[contains(text(),'Save')])[2]/parent::button");
//
//        common.waitUntilElementToBeVisible("(//span[contains(text(),'Save')])[1]/parent::button");
//        common.click("(//span[contains(text(),'Save')])[1]/parent::button");
//
//        common.waitUntilElementToBeVisible(LEADCREATEDMSG);
//        common.assertElementPresent(LEADCREATEDMSG);

    }

    private void saveLeadForm() {
        common.waitUntilElementToBeClickable(LEAD_PIPELINE_CREATE_SAVE);
        common.click(LEAD_PIPELINE_CREATE_SAVE);
        common.pause(2);
    }

    private void searchLeadByName(String leadName) {

        common.waitUntilElementToBeVisible(LEAD_PIPELINE_SEARCH);
        common.clear(LEAD_PIPELINE_SEARCH);
        common.type(LEAD_PIPELINE_SEARCH, leadName);
        common.pause(1);
    }

    private void assertLeadRowVisible(String leadName) {
        Assert.assertFalse(driver.findElements(By.xpath(rowByLeadName(leadName))).isEmpty(),
                "Lead row not found in the grid: " + leadName);
    }

    private void clickRowActionByLeadName(String leadName, int buttonIndex) {
        String actionButton = rowActionButton(leadName, buttonIndex);
        common.waitUntilElementToBeVisible(actionButton);
        common.click(actionButton);
    }

    private boolean isLeadPipelinePageLoaded() {
        return !driver.findElements(By.xpath(LEAD_PIPELINE_HEADER)).isEmpty();
    }

    private boolean isCreateLeadPageLoaded() {
        return !driver.findElements(By.xpath(LEAD_PIPELINE_CREATE_HEADER)).isEmpty();
    }

    private boolean hasRows() {
        return !driver.findElements(By.xpath(LEAD_PIPELINE_FIRST_ROW)).isEmpty();
    }

    private void clickIfPresent(String xpath) {
        if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
            common.click(xpath);
            common.pause(1);
        }
    }

    private String safeText(String xpath) {
        try {
            return common.getText(xpath).trim();
        } catch (Exception e) {
            return "";
        }
    }

    private String safeValue(String xpath) {
        try {
            String value = common.getValue(xpath);
            return value == null ? "" : value.trim();
        } catch (Exception e) {
            return "";
        }
    }

    private List<String> collectColumnValues(int columnIndex) {
        List<WebElement> rows = driver.findElements(By.xpath(LEAD_PIPELINE_TABLE_ROWS));
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

    private void clickHeader(String headerXpath) {
        common.waitUntilElementToBeVisible(headerXpath);
        common.click(headerXpath);
    }

    private void selectFilterOption(String optionText) {
        String optionXpath = "//li[contains(normalize-space(.),'" + optionText + "')]";
        common.waitUntilElementToBeVisible(optionXpath);
        common.click(optionXpath);
    }

    private String rowByLeadName(String leadName) {
        return "//tbody/tr[td[2][normalize-space()='" + leadName + "']]";
    }

    private String rowActionButton(String leadName, int buttonIndex) {
        return rowByLeadName(leadName) + "//td[last()]//button[" + buttonIndex + "]";
    }

    private void selectFirstAutocompleteValue(String inputLocator) {
        common.waitUntilElementToBeClickable(inputLocator);
        WebElement element = driver.findElement(By.xpath(inputLocator));
        element.click();
        common.pause(1);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
    }

    private void setDateField(String inputLocator, String value) {
        WebElement element = driver.findElement(By.xpath(inputLocator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "const el = arguments[0]; const val = arguments[1];" +
                        "const setter = Object.getOwnPropertyDescriptor(HTMLInputElement.prototype, 'value').set;" +
                        "setter.call(el, val);" +
                        "el.removeAttribute('readonly');" +
                        "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "el.dispatchEvent(new Event('change', { bubbles: true }));",
                element, value
        );
    }

    private void waitUntilEnabled(String inputLocator) {
        for (int i = 0; i < 20; i++) {
            if (!common.isElementDisabled(inputLocator)) {
                return;
            }
            common.pause(1);
        }
        throw new SkipException("Field did not become enabled: " + inputLocator);
    }

    private void selectFirstProductIfAvailable() {
        common.waitUntilElementToBeClickable(LEAD_PIPELINE_CREATE_SELECT_PRODUCT);
        common.click(LEAD_PIPELINE_CREATE_SELECT_PRODUCT);
        common.waitUntilElementToBeVisible(LEAD_PIPELINE_PRODUCT_DRAWER);

        if (!driver.findElements(By.xpath(LEAD_PIPELINE_PRODUCT_DRAWER_NO_ROWS)).isEmpty()) {
            throw new SkipException("No products available in the select product drawer");
        }

        common.waitUntilElementToBeClickable(LEAD_PIPELINE_PRODUCT_DRAWER_FIRST_CHECKBOX);
        common.checkChkBox(LEAD_PIPELINE_PRODUCT_DRAWER_FIRST_CHECKBOX);
        common.waitUntilElementToBeClickable(LEAD_PIPELINE_PRODUCT_DRAWER_SAVE);
        common.click(LEAD_PIPELINE_PRODUCT_DRAWER_SAVE);
        common.pause(1);
    }

    private String safeTextFromProductDrawer() {
        List<WebElement> rows = driver.findElements(By.xpath(LEAD_PIPELINE_PRODUCT_DRAWER + "//tbody/tr[not(.//td[@colspan='5'])]"));
        if (rows.isEmpty()) {
            return "";
        }
        return rows.get(0).findElements(By.xpath("./td[2]")).isEmpty() ? "" : rows.get(0).findElements(By.xpath("./td[2]")).get(0).getText().trim();
    }

    private ContactSelection selectContactWithMappedCustomer() {
        List<String> seeds = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

        for (String seed : seeds) {
            clearAutocomplete(LEAD_PIPELINE_CREATE_CONTACT);
            common.click(LEAD_PIPELINE_CREATE_CONTACT);

            if (!seed.isBlank()) {
                common.type(LEAD_PIPELINE_CREATE_CONTACT, seed);
            }

            common.pause(1);
            List<String> optionTexts = collectAutocompleteOptionTexts();
            for (String optionText : optionTexts) {
                selectAutocompleteOptionByText(optionText);
                common.pause(1);

                String customer = safeValue(LEAD_PIPELINE_CREATE_CUSTOMER);
                String contact = safeValue(LEAD_PIPELINE_CREATE_CONTACT);
                if (!customer.isBlank()) {
                    return new ContactSelection(contact, customer);
                }

                clearAutocomplete(LEAD_PIPELINE_CREATE_CONTACT);
                common.click(LEAD_PIPELINE_CREATE_CONTACT);
                if (!seed.isBlank()) {
                    common.type(LEAD_PIPELINE_CREATE_CONTACT, seed);
                }
                common.pause(1);
            }
        }

        throw new SkipException("No contact with a mapped customer was found");
    }

    private List<String> collectAutocompleteOptionTexts() {
        List<WebElement> options = driver.findElements(By.xpath("//li[@role='option' and normalize-space(.)!='']"));
        List<String> texts = new ArrayList<>();

        for (WebElement option : options) {
            String text = option.getText();
            if (text != null && !text.trim().isEmpty()) {
                texts.add(text.trim());
            }
        }

        return texts;
    }

    private void selectAutocompleteOptionByText(String optionText) {
        String optionXpath = "//li[@role='option' and normalize-space(.)='" + optionText + "']";
        common.waitUntilElementToBeVisible(optionXpath);
        common.click(optionXpath);
    }

    private String selectRandomDropdownOption(String optionsXpath) {
        return selectRandomDropdownOption(optionsXpath, null);
    }

    private String selectRandomDropdownOption(String optionsXpath, Set<String> excludedTexts) {
        List<WebElement> options = driver.findElements(By.xpath(optionsXpath));
        if (options.isEmpty()) {
            throw new SkipException("No options available for dropdown selection: " + optionsXpath);
        }

        List<WebElement> selectableOptions = new ArrayList<>();
        for (WebElement option : options) {
            String optionText = option.getText() == null ? "" : option.getText().trim();
            if (excludedTexts == null || excludedTexts.isEmpty() || !excludedTexts.contains(optionText)) {
                selectableOptions.add(option);
            }
        }

        if (selectableOptions.isEmpty()) {
            selectableOptions.addAll(options);
        }

        int randomIndex = Common.generateRandomInteger(0, selectableOptions.size() - 1);
        WebElement selectedOption = selectableOptions.get(randomIndex);
        String optionText = selectedOption.getText() == null ? "" : selectedOption.getText().trim();
        selectedOption.click();
        return optionText;
    }

    private void selectPreferredTimeAndAssignee(LeadDraft draft) {
        Set<String> triedTimeSlots = new HashSet<>();
        String timeOptionsXpath = "//ul[@role='listbox' and .//li[@role='option']]//li[@role='option']";
        String noOptionsXpath = "//div[contains(normalize-space(),'No options')]";

        for (int attempt = 0; attempt < 12; attempt++) {
            common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_PREFERRED_TIME);
            common.click(LEAD_PIPELINE_CREATE_PREFERRED_TIME);

            String selectedTimeSlot = selectRandomDropdownOption(timeOptionsXpath, triedTimeSlots);
            draft.preferredTimeSlot = selectedTimeSlot;
            triedTimeSlots.add(selectedTimeSlot);

            common.waitUntilElementToBeVisible(LEAD_PIPELINE_CREATE_ASSIGNEE);
            common.click(LEAD_PIPELINE_CREATE_ASSIGNEE);
            common.pause(1);

            if (!driver.findElements(By.xpath(noOptionsXpath)).isEmpty()) {
                continue;
            }

            String assigneeOptionsXpath = "//ul[@role='listbox' and .//li[@role='option']]//li[@role='option']";
            draft.assignee = selectRandomDropdownOption(assigneeOptionsXpath);
            return;
        }

        throw new SkipException("No assignee available for any selected preferred time slot");
    }

    private void clearAutocomplete(String inputLocator) {
        List<WebElement> clearButtons = driver.findElements(By.xpath(LEAD_PIPELINE_CREATE_CONTACT_CLEAR));
        if (!clearButtons.isEmpty()) {
            try {
                clearButtons.get(0).click();
                common.pause(1);
                return;
            } catch (Exception ignored) {
            }
        }

        WebElement input = driver.findElement(By.xpath(inputLocator));
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.DELETE);
    }

    public static class LeadDraft {
        private String leadName;
        private String contactName;
        private String customerName;
        private String leadSource;
        private String leadType;
        private String preferredDate;
        private String preferredTimeSlot;
        private String assignee;
        private String description;
        private String productName;

        public String getLeadName() {
            return leadName;
        }

        public String getContactName() {
            return contactName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getLeadSource() {
            return leadSource;
        }

        public String getLeadType() {
            return leadType;
        }

        public String getPreferredDate() {
            return preferredDate;
        }

        public String getPreferredTimeSlot() {
            return preferredTimeSlot;
        }

        public String getAssignee() {
            return assignee;
        }

        public String getDescription() {
            return description;
        }

        public String getProductName() {
            return productName;
        }
    }

    private static class ContactSelection {
        private final String contactName;
        private final String customerName;

        private ContactSelection(String contactName, String customerName) {
            this.contactName = contactName;
            this.customerName = customerName;
        }
    }

    public static class LeadPipelineRowData {
        private final String leadName;
        private final String contact;
        private final String contactDetails;
        private final String leadSource;
        private final String leadType;
        private final String pipelineStatus;
        private final String assigneeFirstName;
        private final String assigneeLastName;
        private final String createdDate;

        public LeadPipelineRowData(String leadName, String contact, String contactDetails, String leadSource, String leadType, String pipelineStatus, String assigneeFirstName, String assigneeLastName, String createdDate) {
            this.leadName = leadName;
            this.contact = contact;
            this.contactDetails = contactDetails;
            this.leadSource = leadSource;
            this.leadType = leadType;
            this.pipelineStatus = pipelineStatus;
            this.assigneeFirstName = assigneeFirstName;
            this.assigneeLastName = assigneeLastName;
            this.createdDate = createdDate;
        }

        public String getLeadName() {
            return leadName;
        }

        public String getContact() {
            return contact;
        }

        public String getContactDetails() {
            return contactDetails;
        }

        public String getLeadSource() {
            return leadSource;
        }

        public String getLeadType() {
            return leadType;
        }

        public String getPipelineStatus() {
            return pipelineStatus;
        }

        public String getAssigneeFirstName() {
            return assigneeFirstName;
        }

        public String getAssigneeLastName() {
            return assigneeLastName;
        }

        public String getCreatedDate() {
            return createdDate;
        }
    }
}
