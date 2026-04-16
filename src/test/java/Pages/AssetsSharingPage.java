package Pages;

import Utils.Common;
import Utils.Locators;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AssetsSharingPage extends Locators {

    public AssetsSharingPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToCompanyPage(){

        common.waitUntilElementToBeClickable(COMAPNY_MENU);
        common.click(COMAPNY_MENU);

    }

    public void goToAssetsSharingPage() {

        goToCompanyPage();

        common.waitUntilElementToBeVisible(ASSETS_SHARING_MENU);
        common.click(ASSETS_SHARING_MENU);

        common.logPrint("Navigated to Assets & Sharing page and fully loaded.");

        common.waitUntilElementToBeVisible(ASSETS_SHARING_HEADER);
        common.logPrint(ASSETS_SHARING_HEADER + " was found");

        common.validateCurrentUrlContains("assets-sharing");

    }

    public void verifyElementsOfMainPage() {

        goToAssetsSharingPage();

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(ASSETS_SHARING_HEADER, "Header");
        columns.put(ASSETS_COUNT_BADGE, "Assets count");

        columns.put(SEARCH_INPUT, "Search bar");

        columns.put(FILTER_BUTTON, "Filters");
        columns.put(CREATE_BUTTON, "Create");

        columns.put(LIST_VIEW_TAB, "Horizontal View");
        columns.put(GRID_VIEW_TAB, "Normal View");

        // Table Headers
        columns.put("//th[.//div[normalize-space()='#']]", "SR Number");
        columns.put(TABLE_HEADER_NAME, "Name");
        columns.put(TABLE_HEADER_DESCRIPTION, "Description");
        columns.put(TABLE_HEADER_STATUS, "Status");
        columns.put(TABLE_HEADER_ACTIONS, "Actions");

        // Table Data
        columns.put(TABLE_ROWS, "Table rows");
        columns.put(FIRST_ROW, "First row");

        // Row Data
        columns.put(String.format(ROW_NAME, 1), "Row 1 Name");
        columns.put(String.format(ROW_DESCRIPTION, 1), "Row 1 Description");
        columns.put(String.format(ROW_STATUS, 1), "Row 1 Status");

        // Row Actions
        columns.put(String.format(VIEW_BUTTON, 1), "View button");
        columns.put(String.format(EDIT_BUTTON, 1), "Edit button");
        columns.put(String.format(DELETE_BUTTON, 1), "Delete button");

        // Status
        columns.put(STATUS_ACTIVE, "Active status");

        // Pagination
        columns.put(SHOW_DROPDOWN, "Rows per page dropdown");
        columns.put(PREVIOUS_PAGE_BUTTON, "Previous page");
        columns.put(NEXT_PAGE_BUTTON, "Next page");

        // Icon fallback
        columns.put(AS_CREATE_BUTTON, "Create button icon");


        // 🔥 Track missing elements
        List<String> missingElements = new ArrayList<>();

        // 🔥 Check if table has rows (avoid false failures)
        boolean hasRows = driver.findElements(By.xpath(TABLE_ROWS)).size() > 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {

            String locator = entry.getKey();
            String friendlyName = entry.getValue();

            // 👉 Skip row-based validations if no data
            if (!hasRows && friendlyName.startsWith("Row 1")) {
                common.logPrint("⚠️ Skipped (No data): " + friendlyName);
                continue;
            }

            boolean isVisible = common.isElementActuallyVisible(locator, 5);

            if (isVisible) {
                common.logPrint("✅ Verified: " + friendlyName);
            } else {
                String msg = friendlyName + " (" + locator + ")";
                missingElements.add(msg);

                common.logPrint("❌ Missing: " + msg);
            }
        }


        // 🔥 FINAL RESULT
        if (missingElements.isEmpty()) {
            common.logPrint("🎉 All elements verified successfully.");
        } else {
            common.logPrint("====== MISSING ELEMENTS ======");

            for (String element : missingElements) {
                common.logPrint("❌ " + element);
            }

            Assert.fail("Missing elements: " + missingElements);
        }
    }

    public void verifyElementsOfTheCreatePage(){

        goToAssetsSharingPage();

        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
        common.click(AS_CREATE_BUTTON);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(AS_CREATE_HEADER, "Header");
        columns.put(AS_CREATE_BASIC_DETAILSHEADER, "Basic Details Header");

// Asset Name
        columns.put(ASC_ASSET_NAME, "Asset Name label");
        columns.put(ASC_ASSET_NAME_INPUT, "Asset Name input");

// Description
        columns.put(ASC_DESCRIPTION, "Description label");
        columns.put(ASC_DESCRIPTION_INPUT, "Description input");

// Additional Info
        columns.put(ASC_ADDITIONAL_INFO, "Additional Info label");
        columns.put(ASC_ADDITIONAL_INFO_INPUT, "Additional Info input");

// AI Section
        columns.put(ASC_CAN_BE_SENT_FROM_AI_LABEL, "Can Be Sent From AI label");
//        columns.put(ASC_AI_YES_RADIO, "AI Yes radio");
//        columns.put(ASC_AI_NO_RADIO, "AI No radio");
        columns.put(ASC_AI_YES_TEXT, "AI Yes text");
        columns.put(ASC_AI_NO_TEXT, "AI No text");

// Upload
        columns.put(ASC_UPLOAD_ASSET_LABEL, "Upload Asset label");
//        columns.put(ASC_UPLOAD_INPUT, "Upload input");
        columns.put(ASC_SELECT_FILE_BUTTON, "Select file button");

// Actions
        columns.put(ASC_CANCEL_BUTTON, "Cancel button");
        columns.put(ASC_SAVE_BUTTON, "Save button");

// Containers (optional but good for validation)
        columns.put(ASC_FORM_CONTAINER, "Form container");
        columns.put(ASC_BASIC_DETAILS_SECTION, "Basic Details section");

        List<String> missingElements = new ArrayList<>();

        boolean hasRows = driver.findElements(By.xpath(TABLE_ROWS)).size() > 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {

            String locator = entry.getKey();
            String friendlyName = entry.getValue();

            if (!hasRows && friendlyName.startsWith("Row 1")) {
                common.logPrint("⚠️ Skipped (No data): " + friendlyName);
                continue;
            }

            boolean isVisible = common.isElementActuallyVisible(locator, 5);

            if (isVisible) {
                common.logPrint("✅ Verified: " + friendlyName);
            } else {
                String msg = friendlyName + " (" + locator + ")";
                missingElements.add(msg);

                common.logPrint("❌ Missing: " + msg);
            }
        }

        if (missingElements.isEmpty()) {
            common.logPrint(" All elements verified successfully.");
        } else {
            common.logPrint("====== MISSING ELEMENTS ======");

            for (String element : missingElements) {
                common.logPrint("❌ " + element);
            }

            Assert.fail("Missing elements: " + missingElements);
        }



    }

    public void verifyMandatoryFields(){
        goToAssetsSharingPage();

        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
        common.click(AS_CREATE_BUTTON);

        int mandatoryFields = common.getMandatoryFieldCount();

        common.logPrint("Expected Mandatory Fields were 4 and actual found: "+mandatoryFields);


        common.waitUntilElementToBeVisible(CCSAVEBTN);
        common.click(CCSAVEBTN);

        common.waitUntilElementToBeVisible(ASC_ASSET_NAME_INPUT_VAL);

        common.assertElementPresent(ASC_ASSET_NAME_INPUT_VAL);
        common.assertElementPresent(ASC_DESCRIPTION_INPUT_VAL);
        common.assertElementPresent(ASC_ADDITIONAL_INFO_INPUT_VAL);
        common.assertElementPresent(ASC_UPLOAD_INPUT_VALIDATION);
    }

    public void verifyCancelButton(){
        goToAssetsSharingPage();

        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
        common.click(AS_CREATE_BUTTON);

        common.waitUntilElementToBeVisible(CCANCELBTN);
        common.click(CCANCELBTN);

        String curURL = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl() + "assets-sharing";

        Assert.assertEquals(expectedURL, curURL, "Mismatch in Company Management URL");
        common.logPrint("Cancel Button verified successfully");

    }

    public String createAnAssetWithValidData(String filePath){

//        goToAssetsSharingPage();
//
//        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
//        common.click(AS_CREATE_BUTTON);

        Faker faker = new Faker();

        // Generate test data
        String assetName = faker.company().name();
        String description = faker.lorem().sentence(5);
        String additionalInfo = faker.lorem().sentence(6);

        // Type into fields
//        String createAssetURL = EnvConfig.getWebUrl() + "assets-sharing/add";
        String AssetSharingURL = EnvConfig.getWebUrl() + "assets-sharing";

        common.openNewUrl(AssetSharingURL);
//        common.openNewUrl(createAssetURL);

        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
        common.click(AS_CREATE_BUTTON);
        common.waitUntilElementToBeVisible(ASC_ASSET_NAME_INPUT);

        common.type(ASC_ASSET_NAME_INPUT, assetName);
        common.type(ASC_DESCRIPTION_INPUT, description);
        common.type(ASC_ADDITIONAL_INFO_INPUT, additionalInfo);

//        // Select AI option (random true/false)
//        if (faker.bool().bool()) {
//            common.click(ASC_AI_YES_RADIO);
//            common.logPrint("Selected AI option: YES");
//        } else {
//            common.click(ASC_AI_NO_RADIO);
//            common.logPrint("Selected AI option: NO");
//        }

        // Upload file (⚠️ update path as per your system)
//        String filePath = System.getProperty("user.dir") + "/src/test/resources/filter_icon.png";

        common.waitUntilElementToBeVisible(ASC_UPLOAD_INPUT);

//        common.click(ASC_UPLOAD_INPUT);
//        common.type(ASC_UPLOAD_INPUT, filePath);

        common.uploadFile(ASC_UPLOAD_INPUT_VAL,filePath);

        common.waitUntilElementToBeVisible(ASC_SAVE_BUTTON);
        common.click(ASC_SAVE_BUTTON);
        common.pause(2);

        common.waitUntilElementToBeVisible(ASC_CREATE_TOASTER);
        common.assertElementPresent(ASC_CREATE_TOASTER);

        common.logPrint("✅ Form filled successfully with Faker data");


        return assetName;

    }

    public void updateAnAssetWithValidData(String filePath){

        Faker faker = new Faker();

        String createdAsset = createAnAssetWithValidData(filePath);

        common.waitUntilElementToBeVisible(SEARCH_INPUT);
        common.type(SEARCH_INPUT, createdAsset);
//        common.searchCommon("//tbody/child::tr[1]/child::td[2]");
        common.validateSearch("//tbody/child::tr[1]/child::td[2]", createdAsset);

        common.waitUntilElementToBeVisible(EDIT_BUTTON);
        common.click(EDIT_BUTTON);

        String assetName = faker.company().name();

        common.type(ASC_ASSET_NAME_INPUT, assetName);

        common.waitUntilElementToBeVisible(ASC_UPLOAD_INPUT);

        common.uploadFile(ASC_UPLOAD_INPUT_VAL,filePath);

        common.waitUntilElementToBeVisible(ASC_SAVE_BUTTON);
        common.click(ASC_SAVE_BUTTON);

        common.waitUntilElementToBeVisible(ASC_UPDATE_TOASTER);
        common.assertElementPresent(ASC_UPDATE_TOASTER);

        common.waitUntilElementToBeVisible(SEARCH_INPUT);
        common.type(SEARCH_INPUT, assetName);
        common.validateSearch("//tbody/child::tr[1]/child::td[2]", assetName);

    }

    public void viewAnAsset(String filePath){

        String createdAsset = createAnAssetWithValidData(filePath);

        common.waitUntilElementToBeVisible(SEARCH_INPUT);
        common.type(SEARCH_INPUT, createdAsset);
//        common.searchCommon("//tbody/child::tr[1]/child::td[2]");
        common.validateSearch("//tbody/child::tr[1]/child::td[2]", createdAsset);

        common.waitUntilElementToBeVisible(VIEW_BUTTON);
        common.click(VIEW_BUTTON);

        common.waitUntilElementToBeVisible(ASC_VIEW_ASSET_SHARING);
        common.assertElementPresent(ASC_VIEW_NAME);
        String view_name = common.getAttribute(ASC_VIEW_NAME_VALUE,"value");


        if(createdAsset.equals(view_name)){
            common.logPrint("Created: "+createdAsset+"\nView: "+view_name);
        }


        common.waitUntilElementToBeVisible(ASC_VIEW_DESCRIPTION);
        common.assertElementPresent(ASC_VIEW_DESCRIPTION);
        common.getAttribute(ASC_VIEW_DESCRIPTION,"value");



    }

    public void deleteAnAsset(String filePath){
        String createdAsset = createAnAssetWithValidData(filePath);
        common.waitUntilElementToBeVisible(SEARCH_INPUT);
        common.type(SEARCH_INPUT, createdAsset);
//        common.searchCommon("//tbody/child::tr[1]/child::td[2]");
        common.validateSearch("//tbody/child::tr[1]/child::td[2]", createdAsset);

        common.waitUntilElementToBeVisible(DELETE_BUTTON);
        common.click(DELETE_BUTTON);

        common.click(CDELETEMSGCANCEL);

        common.waitUntilElementToBeClickable(DELETE_BUTTON);
        common.click(DELETE_BUTTON);

        common.click(CDELETEMSGDELETE);

        common.waitUntilElementToBeVisible(DeletedSuccessfully);
        common.assertElementPresent(DeletedSuccessfully);


    }

    public void verifyCreatedDate(String filePath) {
        createAnAssetWithValidData(filePath);

        common.waitUntilElementToBeVisible("//button[@role=\"tab\"][2]");
        common.click("//button[@role=\"tab\"][2]");

        String dateFromGrid = common.getText("(//span[contains(text(),'Created')])[1]").trim();

        String actualDateText = dateFromGrid.replace("Created:", "").trim();

        DateTimeFormatter uiFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        LocalDate actualDate = LocalDate.parse(actualDateText, uiFormatter);

        LocalDate currentDate = LocalDate.now();

        common.logPrint("Grid Date: " + actualDate + " | Current Date: " + currentDate);

        Assert.assertEquals(actualDate, currentDate, "Created date mismatch");
    }

    public void verifyAddingDuplicateAsset(String filePath){
        String createdAsset = createAnAssetWithValidData(filePath);

        common.waitUntilElementToBeVisible(AS_CREATE_BUTTON);
        common.click(AS_CREATE_BUTTON);

        Faker faker = new Faker();

        String description = faker.lorem().sentence(5);
        String additionalInfo = faker.lorem().sentence(6);

        common.type(ASC_ASSET_NAME_INPUT, createdAsset);
        common.type(ASC_DESCRIPTION_INPUT, description);
        common.type(ASC_ADDITIONAL_INFO_INPUT, additionalInfo);

        common.waitUntilElementToBeVisible(ASC_UPLOAD_INPUT);

        common.uploadFile(ASC_UPLOAD_INPUT_VAL,filePath);

        common.waitUntilElementToBeVisible(ASC_SAVE_BUTTON);
        common.click(ASC_SAVE_BUTTON);

        common.waitUntilElementToBeVisible(ASC_CREATE_TOASTER);
        common.assertElementPresent(ASC_CREATE_TOASTER);

        common.logPrint("✅ Form filled successfully with Faker data");




    }

    public void searchAsset(){
        goToAssetsSharingPage();

        common.waitUntilElementToBeVisible(SEARCH_INPUT);
        common.searchCommon("//tbody/tr[1]/td[2]");
    }

    public void verifyHorizontalCardView(){
        goToAssetsSharingPage();
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"]| //h6[text()='Assets & Sharing']/following-sibling::div");
    }

    public void verifyPagination(){
        goToAssetsSharingPage();
        common.pagination("//div[@class=\"MuiBox-root css-a7l4db\"]| //h6[text()='Assets & Sharing']/following-sibling::div");
    }






}
