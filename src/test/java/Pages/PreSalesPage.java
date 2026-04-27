package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PreSalesPage extends Locators {

    private final Common common;

    public PreSalesPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToPreSalesPage() {
        if (isPreSalesPageLoaded()) {
            return;
        }

        clickIfPresent(SALES);
        clickIfPresent(PRE_SALES_MENU);

        if (!isPreSalesPageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "pre-sales");
            common.pause(1);
        }

        if (!isPreSalesPageLoaded()) {
            common.openNewUrl(EnvConfig.getWebUrl() + "presales");
            common.pause(1);
        }

        common.waitUntilElementToBeVisible(PRE_SALES_HEADER);
    }

    public void verifyPreSalesPageElements() {
        goToPreSalesPage();

        common.assertElementPresent(PRE_SALES_HEADER);
        common.assertElementPresent(PRE_SALES_COUNT);
        common.assertElementPresent(PRE_SALES_SEARCH);
        common.assertElementPresent(PRE_SALES_FILTERS);
        common.assertElementPresent(PRE_SALES_EXPORT);
        common.assertElementPresent(PRE_SALES_LIST_TAB);
        common.assertElementPresent(PRE_SALES_GRID_TAB);
        common.assertElementPresent(PRE_SALES_SR_NO);
        common.assertElementPresent(PRE_SALES_CONTACT_NAME_HEADER);
        common.assertElementPresent(PRE_SALES_EMAIL_HEADER);
        common.assertElementPresent(PRE_SALES_PHONE_HEADER);
        common.assertElementPresent(PRE_SALES_SOURCE_HEADER);
        common.assertElementPresent(PRE_SALES_THRESHOLD_SCORE_HEADER);
        common.assertElementPresent(PRE_SALES_PROBING_SCORE_HEADER);
        common.assertElementPresent(PRE_SALES_CREATED_DATE_HEADER);
        common.assertElementPresent(PRE_SALES_ACTIONS_HEADER);
        common.assertElementPresent(PAGINATION_PREVIOUS);
        common.assertElementPresent(PAGINATION_NEXT);
        common.assertElementPresent(PAGINATION_SHOW_DROPDOWN);
    }

    public PreSalesRowData getFirstRowData() {
        goToPreSalesPage();

        if (driver.findElements(By.xpath(PRE_SALES_FIRST_ROW)).isEmpty()) {
            return null;
        }

        return new PreSalesRowData(
                safeText(PRE_SALES_FIRST_CONTACT_NAME),
                safeText(PRE_SALES_FIRST_EMAIL),
                safeText(PRE_SALES_FIRST_PHONE),
                safeText(PRE_SALES_FIRST_SOURCE),
                safeText(PRE_SALES_FIRST_THRESHOLD_SCORE),
                safeText(PRE_SALES_FIRST_PROBING_SCORE),
                safeText(PRE_SALES_FIRST_CREATED_DATE)
        );
    }

    public void verifySearchWithFirstRowData(PreSalesRowData row) {
        goToPreSalesPage();

        common.waitUntilElementToBeVisible(PRE_SALES_SEARCH);
        common.clear(PRE_SALES_SEARCH);
        common.type(PRE_SALES_SEARCH, row.getContactName());
        common.pause(1);

        common.validateSearch(PRE_SALES_FIRST_CONTACT_NAME, row.getContactName());
    }

    public void verifyFiltersWithFirstRowData(PreSalesRowData row) {
        goToPreSalesPage();

        common.refreshPage();
        common.pause(1);
        common.waitUntilElementToBeClickable(PRE_SALES_FILTERS);
        common.click(PRE_SALES_FILTERS);

        common.waitUntilElementToBeClickable(PHFILTERSEACRH);
        common.click(PHFILTERSEACRH);

        selectFilterOption("Contact Name");

        common.waitUntilElementToBeClickable(PHFILTEROPERATOR);
        common.click(PHFILTEROPERATOR);
        common.waitUntilElementToBeVisible(FILTEREQUALS);
        common.click(FILTEREQUALS);

        common.waitUntilElementToBeVisible(PHFILTERVAL);
        common.clear(PHFILTERVAL);
        common.type(PHFILTERVAL, row.getContactName());

        common.waitUntilElementToBeClickable(APPLYFILTER);
        common.click(APPLYFILTER);
        common.pause(1);

        common.waitUntilElementToBeVisible(PRE_SALES_FIRST_CONTACT_NAME);
        common.validateSearch(PRE_SALES_FIRST_CONTACT_NAME, row.getContactName());
    }

    public void verifyContactNameSorting() {
        goToPreSalesPage();

        List<String> initialValues = collectColumnValues(PRE_SALES_CONTACT_NAME_CELL);
        Assert.assertFalse(initialValues.isEmpty(), "No rows available for sorting validation");

        clickHeader(PRE_SALES_CONTACT_NAME_HEADER);
        common.pause(1);
        List<String> ascendingValues = collectColumnValues(PRE_SALES_CONTACT_NAME_CELL);
        Assert.assertEquals(ascendingValues, sortedCopy(initialValues, true), "Contact Name ascending sort failed");

        clickHeader(PRE_SALES_CONTACT_NAME_HEADER);
        common.pause(1);
        List<String> descendingValues = collectColumnValues(PRE_SALES_CONTACT_NAME_CELL);
        Assert.assertEquals(descendingValues, sortedCopy(initialValues, false), "Contact Name descending sort failed");
    }

    public void verifyViewFirstRow() {
        goToPreSalesPage();

        if (driver.findElements(By.xpath(PRE_SALES_FIRST_ROW)).isEmpty()) {
            return;
        }

        common.waitUntilElementToBeVisible(PRE_SALES_VIEW_BUTTON);
        common.click(PRE_SALES_VIEW_BUTTON);
        common.pause(1);
    }

    public void verifyDeleteFirstRow() {
        goToPreSalesPage();

        PreSalesRowData row = getFirstRowData();
        if (row == null) {
            return;
        }

        common.waitUntilElementToBeVisible(PRE_SALES_DELETE_BUTTON);
        common.click(PRE_SALES_DELETE_BUTTON);

        common.waitUntilElementToBeVisible(PRE_SALES_DELETE_CONFIRM_BUTTON);
        common.click(PRE_SALES_DELETE_CONFIRM_BUTTON);

        common.waitUntilElementToBeVisible(DeletedSuccessfully);
        common.assertElementPresent(DeletedSuccessfully);

        common.clear(PRE_SALES_SEARCH);
        common.type(PRE_SALES_SEARCH, row.getContactName());
        common.pause(1);
        common.assertElementPresent(NoRows);
    }

    private void clickIfPresent(String xpath) {
        if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
            common.click(xpath);
            common.pause(1);
        }
    }

    private boolean isPreSalesPageLoaded() {
        return !driver.findElements(By.xpath(PRE_SALES_HEADER)).isEmpty();
    }

    private String safeText(String xpath) {
        try {
            return common.getText(xpath).trim();
        } catch (Exception e) {
            return "";
        }
    }

    private List<String> collectColumnValues(String xpath) {
        List<WebElement> cells = driver.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();

        for (WebElement cell : cells) {
            String value = cell.getText();
            if (value != null) {
                value = value.trim();
            }
            values.add(value == null ? "" : value);
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

    private List<String> sortedCopy(List<String> values, boolean ascending) {
        List<String> sorted = new ArrayList<>(values);
        Comparator<String> comparator = Comparator
                .comparing((String value) -> value == null ? "" : value.trim(), String.CASE_INSENSITIVE_ORDER)
                .thenComparing(value -> value == null ? "" : value.trim());

        if (ascending) {
            sorted.sort(comparator);
        } else {
            sorted.sort(comparator.reversed());
        }

        return sorted;
    }

    public static class PreSalesRowData {
        private final String contactName;
        private final String email;
        private final String phone;
        private final String source;
        private final String thresholdScore;
        private final String probingScore;
        private final String createdDate;

        public PreSalesRowData(String contactName, String email, String phone, String source, String thresholdScore, String probingScore, String createdDate) {
            this.contactName = contactName;
            this.email = email;
            this.phone = phone;
            this.source = source;
            this.thresholdScore = thresholdScore;
            this.probingScore = probingScore;
            this.createdDate = createdDate;
        }

        public String getContactName() {
            return contactName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getSource() {
            return source;
        }

        public String getThresholdScore() {
            return thresholdScore;
        }

        public String getProbingScore() {
            return probingScore;
        }

        public String getCreatedDate() {
            return createdDate;
        }
    }
}
