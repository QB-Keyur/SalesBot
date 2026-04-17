package Pages;

import Config.EnvConfig;
import Tests.WhatsAppContactTest;
import Utils.Common;
import Utils.Locators;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import com.github.javafaker.Faker;




public class CustomerPage extends Locators {

    Common common;

    public CustomerPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.whatsAppContactPage = new WhatsAppContactPage(driver);
    }

    public void goToCustomerPage(){

        common.waitUntilElementToBeVisible(CONTACT_MENU);
        common.click(CONTACT_MENU);

        common.waitUntilElementToBeVisible(CUSTOMER_MENU);
        common.click(CUSTOMER_MENU);

        common.waitUntilElementToBeVisible(CUSTOMER_HEADER);
        common.logPrint(CUSTOMER_HEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl()+"customer";

        if(curUrl.equals(expectedURL)){
            common.logPrint("Passed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
        else{
            common.logPrint("Failed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
    }

    public void verifyCustomerPageElements(){
        goToCustomerPage();
        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        Map<String, String> columns = new LinkedHashMap<>();
        columns.put(CUSTOMER_HEADER,        "Customer page header is displayed");
        columns.put(CUSTOMER_TOTAL_COUNT,        "Customer page total count is displayed");

        columns.put(CUSTOMER_SEARCH_BAR,    "Customer search bar is visible and functional");
        columns.put(CUSTOMER_FILTER_BUTTON, "Customer filter button is available");
        columns.put(CUSTOMER_REFRESH_BUTTON,"Customer refresh button is clickable");
        columns.put(CUSTOMER_CREATE_BUTTON, "Customer create button is present");

        columns.put(COLUMN_HASH,            "Customer table serial number (#) column is displayed");
        columns.put(COLUMN_CUSTOMER_NAME,   "Customer name column is displayed");
        columns.put(COLUMN_INDUSTRY,        "Customer industry column is displayed");
        columns.put(COLUMN_COMPANY_SIZE,    "Customer company size column is displayed");
        columns.put(COLUMN_STATUS,          "Customer status column is displayed");
        columns.put(COLUMN_CREATED_DATE,    "Customer created date column is displayed");
        columns.put(COLUMN_ACTIONS,         "Customer actions column is displayed");

        columns.put(PAGINATION_SHOW_DROPDOWN, "Customer table 'Show rows' dropdown is visible");
        columns.put(PAGINATION_PREVIOUS,      "Customer previous page button is available");
        columns.put(PAGINATION_NEXT,          "Customer next page button is available");


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

    public void verifyCreatePageElements() {
        goToCustomerPage();
        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        common.waitUntilElementToBeVisible(CUSTOMER_CREATE_BUTTON);
        common.click(CUSTOMER_CREATE_BUTTON);



        // Header & Actions
        common.assertElementPresent(CC_HEADER);
        common.logPrint("Verified: Create Customer page header is displayed");

        common.assertElementPresent(CC_CANCEL);
        common.logPrint("Verified: Cancel button is visible and clickable");

        common.assertElementPresent(CC_SAVE);
        common.logPrint("Verified: Save button is visible and clickable");

// Basic Details Section
        common.assertElementPresent(CC_BASIC_DETAILS);
        common.logPrint("Verified: Basic Details section is displayed");

        common.assertElementPresent(CC_NAME);
        common.logPrint("Verified: Customer name input field is visible");

        common.assertElementPresent(CC_SELECT_INDUSTRY);
        common.logPrint("Verified: Industry dropdown is visible");

        common.assertElementPresent(CC_COMPANY_SIZE);
        common.logPrint("Verified: Company size input field is visible");

        common.assertElementPresent(CC_DESC);
        common.logPrint("Verified: Description input field is visible");

// Billing Details
        common.assertElementPresent(CC_BILLING_NAME);
        common.logPrint("Verified: Billing name input field is available");

        common.assertElementPresent(CC_BILLING_ADDRESS_LINE_1);
        common.logPrint("Verified: Billing address line 1 field is available");

        common.assertElementPresent(CC_BILLING_ADDRESS_LINE_2);
        common.logPrint("Verified: Billing address line 2 field is available");

// Country → State → City → Code (with actions)
        common.assertElementPresent(CC_SELECT_COUNTRY);
        common.click(CC_SELECT_COUNTRY);
        common.twoDownKeyAndEnter();
        common.logPrint("Verified: Billing country dropdown is selectable");

        common.waitUntilElementToBeClickable(CC_SELECT_STATE);
        common.assertElementPresent(CC_SELECT_STATE);
        common.click(CC_SELECT_STATE);
        common.twoDownKeyAndEnter();
        common.logPrint("Verified: Billing state dropdown is selectable");

        common.waitUntilElementToBeClickable(CC_SELECT_CITY);
        common.assertElementPresent(CC_SELECT_CITY);
        common.click(CC_SELECT_CITY);
        common.twoDownKeyAndEnter();
        common.logPrint("Verified: Billing city dropdown is selectable");

        common.waitUntilElementToBeClickable(CC_SELECT_CODE);
        common.assertElementPresent(CC_SELECT_CODE);
        common.click(CC_SELECT_CODE);
        common.twoDownKeyAndEnter();
        common.logPrint("Verified: Billing postal code is selectable");

// Billing Contact
        common.assertElementPresent(CC_BILLING_PHONE);
        common.logPrint("Verified: Billing phone number input is available");

        common.assertElementPresent(CC_BILLING_EMAIL);
        common.logPrint("Verified: Billing email input field is available");

// Shipping Section
        common.assertElementPresent(CC_SHIPPING);
        common.click(CC_SHIPPING);
        common.logPrint("Verified: Shipping Address tab is selectable");

// Shipping Inputs
        common.assertElementPresent(INPUT_SHIPPING_NAME);
        common.logPrint("Verified: Shipping name input field is available");

        common.assertElementPresent(INPUT_SHIPPING_ADDR_LINE1);
        common.logPrint("Verified: Shipping address line 1 field is available");

        common.assertElementPresent(INPUT_SHIPPING_ADDR_LINE2);
        common.logPrint("Verified: Shipping address line 2 field is available");

//// Shipping Country
//        common.waitUntilElementToBeClickable(CC_SELECT_COUNTRY);
//        common.assertElementPresent(CC_SELECT_COUNTRY);
//        common.click(CC_SELECT_COUNTRY);
//        common.twoDownKeyAndEnter();
//        common.logPrint("Verified: Shipping country dropdown is selectable");
//
//// Shipping State
//        common.waitUntilElementToBeClickable(CC_SELECT_STATE);
//        common.assertElementPresent(CC_SELECT_STATE);
//        common.click(CC_SELECT_STATE);
//        common.twoDownKeyAndEnter();
//        common.logPrint("Verified: Shipping state dropdown is selectable");
//
//// Shipping City
//        common.waitUntilElementToBeClickable(CC_SELECT_CITY);
//        common.assertElementPresent(CC_SELECT_CITY);
//        common.click(CC_SELECT_CITY);
//        common.twoDownKeyAndEnter();
//        common.logPrint("Verified: Shipping city dropdown is selectable");
//
//// Shipping Pincode
//        common.waitUntilElementToBeClickable(CC_SELECT_CODE);
//        common.assertElementPresent(CC_SELECT_CODE);
//        common.click(CC_SELECT_CODE);
//        common.twoDownKeyAndEnter();
//        common.logPrint("Verified: Shipping postal code is selectable");

// Shipping Contact
        common.assertElementPresent(INPUT_SHIPPING_PHONE);
        common.logPrint("Verified: Shipping phone number input is available");

        common.assertElementPresent(INPUT_SHIPPING_EMAIL);
        common.logPrint("Verified: Shipping email input field is available");
// Contacts Section
        common.assertElementPresent(CC_CONTACT_HEADER);
        common.logPrint("Verified: Contacts section header is displayed");

        common.assertElementPresent(CC_CONTACT_NAME);
        common.logPrint("Verified: Contact Name column is displayed");

        common.assertElementPresent(CC_CONTACT_SOURCE);
        common.logPrint("Verified: Contact Source column is displayed");

        common.assertElementPresent(CC_CONTACT_ACTION);
        common.logPrint("Verified: Contact Action column is displayed");

        common.assertElementPresent(CC_SELECT_CONTACT_BUTTON);
        common.logPrint("Verified: Select Contacts button is visible and clickable");

    }

    public void createCustomerWithValidData() {

        goToCustomerPage();
        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        common.waitUntilElementToBeVisible(CUSTOMER_CREATE_BUTTON);
        common.click(CUSTOMER_CREATE_BUTTON);

        Faker faker = new Faker();

        // ===== Test Data =====
        String customerName  = faker.company().name();
        String companySize   = String.valueOf(faker.number().numberBetween(10, 1000));
        String description   = faker.company().industry();

        String billingName   = faker.name().fullName();
        String billingAddr1  = faker.address().streetAddress();
        String billingAddr2  = faker.address().secondaryAddress();
        String billingPhone  = "9" + faker.number().digits(9);
        String billingEmail  = faker.internet().emailAddress();

        String shippingName  = faker.name().fullName();
        String shippingAddr1 = faker.address().streetAddress();
        String shippingAddr2 = faker.address().secondaryAddress();
        String shippingPhone = "9" + faker.number().digits(9);
        String shippingEmail = faker.internet().emailAddress();

        String contactName   = faker.name().fullName();

        // ===== Header =====
        common.assertElementPresent(CC_HEADER);
        common.logPrint("Create Customer page opened");

        common.assertElementPresent(CC_CONTACT_HEADER);

        common.click(CONTACT_MENU);

        common.waitUntilElementToBeClickable(SELECT_CONTACT);
        common.click(SELECT_CONTACT);

        common.waitUntilElementToBeVisible(CUSTOMER_CREATE_BUTTON);
        common.click(CUSTOMER_CREATE_BUTTON);

        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();

        common.assertElementPresent(CC_SELECT_CONTACT_BUTTON);
        common.click(CC_SELECT_CONTACT_BUTTON);

        common.waitUntilElementToBeClickable(CC_CONTACT_SOURCE);

//        common.checkChkBox("(//tbody//span[contains(@class,'MuiCheckbox-root')])[1]");
        int i = 1;

        do {
            String checkboxXpath = "(//tbody//span[contains(@class,'MuiCheckbox-root')])[" + i + "]";
            common.selectCheckBox(checkboxXpath);
            common.pause(1);

            List<WebElement> popupList = driver.findElements(By.xpath(CC_ALREADY_ADDED_POPUP));

            if (!popupList.isEmpty() && popupList.get(0).isDisplayed()) {
                common.logPrint("ALREADY ADDED POPUP for index: " + i);
                common.click("//button[@aria-label='Close modal']");
                i++; // move to next checkbox
            } else {
                common.logPrint("No popup → Checkbox selected successfully at index: " + i);
                break; // EXIT loop immediately
            }

        } while (true);

        common.click("(//span[text()='Save']/parent::button)[2]");

        common.waitUntilElementToBeVisible(CC_SAVE);

        // ===== Basic Details =====
        common.type(CC_NAME, customerName);
        common.logPrint("Entered Customer Name: " + customerName);

        common.click(CC_SELECT_INDUSTRY);
        common.twoDownKeyAndEnter();

        common.type(CC_COMPANY_SIZE, companySize);
        common.type(CC_DESC, description);

        // ===== Billing =====
        common.type(CC_BILLING_NAME, billingName);
        common.type(CC_BILLING_ADDRESS_LINE_1, billingAddr1);
        common.type(CC_BILLING_ADDRESS_LINE_2, billingAddr2);

        // Dropdowns (Billing)
        common.click(CC_SELECT_COUNTRY);
        common.twoDownKeyAndEnter();

        common.waitUntilElementToBeClickable(CC_SELECT_STATE);
        common.click(CC_SELECT_STATE);
        common.twoDownKeyAndEnter();

        common.waitUntilElementToBeClickable(CC_SELECT_CITY);
        common.click(CC_SELECT_CITY);
        common.twoDownKeyAndEnter();

        common.waitUntilElementToBeClickable(CC_SELECT_CODE);
        common.click(CC_SELECT_CODE);
        common.twoDownKeyAndEnter();

        common.type(CC_BILLING_PHONE, billingPhone);
        common.type(CC_BILLING_EMAIL, billingEmail);

        // ===== Shipping =====
        common.click(CC_SHIPPING);

        common.type(INPUT_SHIPPING_NAME, shippingName);
        common.type(INPUT_SHIPPING_ADDR_LINE1, shippingAddr1);
        common.type(INPUT_SHIPPING_ADDR_LINE2, shippingAddr2);

        // Dropdowns (Shipping)
        common.tabTwoDownKeyAndEnter();

        common.tabTwoDownKeyAndEnter();

        common.tabTwoDownKeyAndEnter();

        common.tabTwoDownKeyAndEnter();

        common.type(INPUT_SHIPPING_PHONE, shippingPhone);
        common.type(INPUT_SHIPPING_EMAIL, shippingEmail);

        // ===== Final Action =====
        common.click(CC_SAVE);
        common.logPrint("Clicked Save button - Customer creation attempted");

        common.waitUntilElementToBeClickable(CUSTOMER_CREATE_TOASTER);
        common.assertElementPresent(CUSTOMER_CREATE_TOASTER);

        common.waitUntilElementToBeClickable(PHSEACRH);
        common.click(PHSEACRH);
        common.type(PHSEACRH, customerName);
        common.waitUntilElementToBeVisible(SEARCHRESULT);
        common.validateSearch(SEARCHRESULT, customerName);
    }

    public void editingACustomer() {

        Faker faker = new Faker();

        // ===== Updated Data =====
        String description   = faker.company().industry();

        String billingName   = faker.name().fullName();
        String billingAddr1  = faker.address().streetAddress();
        String billingAddr2  = faker.address().secondaryAddress();
        String billingPhone  = "9" + faker.number().digits(9);
        String billingEmail  = faker.internet().emailAddress();

        String shippingName  = faker.name().fullName();
        String shippingAddr1 = faker.address().streetAddress();
        String shippingAddr2 = faker.address().secondaryAddress();
        String shippingPhone = "9" + faker.number().digits(9);
        String shippingEmail = faker.internet().emailAddress();

        // ===== Step 1: Create Customer =====
        createCustomerWithValidData();

        // ===== Step 2: Open Edit =====
        common.waitUntilElementToBeClickable(EDIT);
        common.click(EDIT);

        common.waitUntilElementToBeVisible(CC_NAME);

        // ===== Step 3: Update Basic Details =====
        common.type(CC_DESC, description);

        // ===== Billing =====
        common.type(CC_BILLING_NAME, billingName);
        common.type(CC_BILLING_ADDRESS_LINE_1, billingAddr1);
        common.type(CC_BILLING_ADDRESS_LINE_2, billingAddr2);

        // Dropdowns (Billing)
        common.click(CC_SELECT_COUNTRY);
        common.twoDownKeyAndEnter();

        common.click(CC_SELECT_STATE);
        common.twoDownKeyAndEnter();

        common.click(CC_SELECT_CITY);
        common.twoDownKeyAndEnter();

        common.click(CC_SELECT_CODE);
        common.twoDownKeyAndEnter();

        common.type(CC_BILLING_PHONE, billingPhone);

        // 🔥 Email fix (no duplication)
        common.click(CC_BILLING_EMAIL);
        common.ctrlAAndBackspace();
        common.type(CC_BILLING_EMAIL, billingEmail);

        // ===== Shipping =====
        common.click(CC_SHIPPING);

        common.type(INPUT_SHIPPING_NAME, shippingName);
        common.type(INPUT_SHIPPING_ADDR_LINE1, shippingAddr1);
        common.type(INPUT_SHIPPING_ADDR_LINE2, shippingAddr2);

        // Dropdowns (Shipping)
        common.tabTwoDownKeyAndEnter();
        common.tabTwoDownKeyAndEnter();
        common.tabTwoDownKeyAndEnter();
        common.tabTwoDownKeyAndEnter();

        common.type(INPUT_SHIPPING_PHONE, shippingPhone);

        // 🔥 Email fix
        common.click(INPUT_SHIPPING_EMAIL);
        common.ctrlAAndBackspace();
        common.type(INPUT_SHIPPING_EMAIL, shippingEmail);

        // ===== Contacts (UPDATED - includes create contact) =====
        common.assertElementPresent(CC_CONTACT_HEADER);
        common.click(CONTACT_MENU);

        common.assertElementPresent(CC_SELECT_CONTACT_BUTTON);
        common.click(CC_SELECT_CONTACT_BUTTON);
//
        common.waitUntilElementToBeClickable(CC_CONTACT_SOURCE);
//
//        // 🔥 Create new WhatsApp Contact (same as create flow)
//        common.waitUntilElementToBeVisible(CUSTOMER_CREATE_BUTTON);
//        common.click(CUSTOMER_CREATE_BUTTON);
//
//        String mobileNumber = common.fakeIndianMobileNumber();
//        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
//        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();

        int i = 2;

        while (true) {
            common.pause(1);
            String checkboxXpath = "(//tbody//span[contains(@class,'MuiCheckbox-root')])[" + i + "]";
            common.selectCheckBox(checkboxXpath);
            common.pause(1);

            List<WebElement> popupList = driver.findElements(By.xpath(CC_ALREADY_ADDED_POPUP));

            if (!popupList.isEmpty() && popupList.get(0).isDisplayed()) {
                common.logPrint("ALREADY ADDED POPUP for index: " + i);
                common.click("//button[@aria-label='Close modal']");
                i++;
            } else {
                common.logPrint("No popup → Checkbox selected successfully at index: " + i);
                break;
            }
        }

        common.click("(//span[text()='Save']/parent::button)[2]");

        // ===== Final Save =====
        common.waitUntilElementToBeVisible(CC_SAVE);
        common.click(CC_SAVE);

        common.logPrint("Customer edit attempted");

        common.waitUntilElementToBeClickable(CUSTOMER_UPDATE_TOASTER);
        common.assertElementPresent(CUSTOMER_UPDATE_TOASTER);
    }

    public void deleteACustomer(){
        createCustomerWithValidData();
        common.waitUntilElementToBeVisible(CMGMTDELETEBTN);
        common.click(CMGMTDELETEBTN);

        common.waitUntilElementToBeVisible(CUSTOMER_DELETE_MSG);
        common.assertElementPresent(CUSTOMER_DELETE_MSG);
        common.waitUntilElementToBeVisible(CUSTOMER_DELETE_MSG2);
        common.assertElementPresent(CUSTOMER_DELETE_MSG2);
        common.assertElementPresent(CDELETEMSGCANCEL);
        common.assertElementPresent(CDELETEMSGDELETE);

        common.click(CDELETEMSGCANCEL);

        common.waitUntilElementToBeClickable(CDELETEMSGDELETE);
        common.click(CMGMTDELETEBTN);

        common.click(CDELETEMSGDELETE);

        common.waitUntilElementToBeVisible(DeletedSuccessfully);
        common.assertElementPresent(DeletedSuccessfully);


    }

    public void horizontalView() {
        goToCustomerPage();
        common.pause(2);
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"] | //h6[contains(text(),\"Customer\")]/following-sibling::div");
    }

    public void pagination(){
        goToCustomerPage();
        common.pagination("//div[@class=\"MuiBox-root css-a7l4db\"]| //h6[contains(text(),\"Customer\")]/following-sibling::div");
    }















    }


