package Pages;

import Utils.Common;
import Utils.Locators;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class WhatsAppContactPage extends Locators {

    Common common;

    public WhatsAppContactPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString();
            }
        }

        workbook.close();
        return data;
    }

    public void redirectsToHomePage() {

        common.logPrint("Step:: Click on the Home");
        common.waitUntilElementToBeVisible(HomeMenu);
        common.click(HomeMenu);

       common.pause(1);

    }

    public void redirectsToWhatsAppCampaignPage() {

        common.logPrint("Step:: Click on the campaign menu");
        common.waitUntilElementToBeVisible(CampaignMenu);
        common.click(CampaignMenu);

        common.logPrint("Step:: Click on the whatsapp contact");
        common.waitUntilElementToBeVisible(whatsappCampaign);
        common.click(whatsappCampaign);

        common.pause(1);

    }


    public void redirectsToWhatsAppContactPage() {

        common.waitUntilElementToBeVisible(Contact);
        common.click(Contact);

        common.waitUntilElementToBeVisible(WhatsAppContact);
        common.click(WhatsAppContact);

        common.pause(2);
    }

    public void redirectsToImportPage() {

        common.waitUntilElementToBeVisible(importBtn);
        common.click(importBtn);

        common.pause(2);

    }

    public void redirectsToWhatsappContactListView() {

        common.waitUntilElementToBeVisible(listViewBtn);
        common.click(listViewBtn);

    }

    public void redirectsToWhatsAppContactCreatePage() {

        redirectsToWhatsAppContactPage();

        common.waitUntilElementToBeVisible(createContact);
        common.click(createContact);

    }

    public void verifyWhatsAppContactPageUI() {

        common.logPrint("Step:: Verify 'Save' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(saveButton));
        common.assertElementPresent(saveButton);

        common.logPrint("Step:: Verify 'Cancel' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(cancelButton));
        common.assertElementPresent(cancelButton);

        // =================== Labels ===================
        common.logPrint("Step:: Verify 'Name' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameLabel));
        common.assertElementPresent(nameLabel);

        common.logPrint("Step:: Verify 'Email' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailLabel));
        common.assertElementPresent(emailLabel);

        common.logPrint("Step:: Verify 'Date Of Birth' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(dateOfBirthLabel));
        common.assertElementPresent(dateOfBirthLabel);

        common.logPrint("Step:: Verify 'Contact Group' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroupLabel));
        common.assertElementPresent(contactGroupLabel);

        common.logPrint("Step:: Verify 'Phone Number' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumberLabel));
        common.assertElementPresent(phoneNumberLabel);

        common.logPrint("Step:: Verify 'Company Name' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(companyNameLabel));
        common.assertElementPresent(companyNameLabel);

        common.logPrint("Step:: Verify 'Country' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(countryLabel));
        common.assertElementPresent(countryLabel);

        common.logPrint("Step:: Verify 'State' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(stateLabel));
        common.assertElementPresent(stateLabel);

        common.logPrint("Step:: Verify 'City' label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(cityLabel));
        common.assertElementPresent(cityLabel);

        // =================== Input Fields ===================
        common.logPrint("Step:: Verify 'Name' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameInp));
        common.assertElementPresent(nameInp);

        common.logPrint("Step:: Verify 'Email' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameInp));
        common.assertElementPresent(nameInp);

        common.logPrint("Step:: Verify 'Date Of Birth' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(dateOfBirthInp));
        common.assertElementPresent(dateOfBirthInp);

        common.logPrint("Step:: Verify 'Contact Group' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroup));
        common.assertElementPresent(contactGroup);

        common.logPrint("Step:: Verify 'Phone Number' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumberInp));
        common.assertElementPresent(phoneNumberInp);

        common.logPrint("Step:: Verify 'Company Name' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(companyNameInp));
        common.assertElementPresent(companyNameInp);

        common.logPrint("Step:: Verify 'Country' input dropdown is displayed");
        common.waitUntilElementToBeVisible(By.xpath(selectCountryDropdown));
        common.assertElementPresent(selectCountryDropdown);

        common.logPrint("Step:: Verify 'State' input dropdown is displayed");
        common.waitUntilElementToBeVisible(By.xpath(SelectStateInp));
        common.assertElementPresent(SelectStateInp);

        common.logPrint("Step:: Verify 'City' input dropdown is displayed");
        common.waitUntilElementToBeVisible(By.xpath(SelectCityInp));
        common.assertElementPresent(SelectCityInp);

    }

    public void verifyValidationMessagesForMandatoryFieldInContactPage(){

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(saveButton));
        common.click(saveButton);

        common.logPrint("Step:: Verify 'Name is required' message is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameFieldMsg));
        common.assertElementPresent(nameFieldMsg);

        common.logPrint("Step:: Verify 'Please select a contact group' message is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroupMsg));
        common.assertElementPresent(contactGroupMsg);

        common.logPrint("Step:: Verify 'Phone number is required' message is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumberMsg));
        common.assertElementPresent(phoneNumberMsg);

    }

    public void verifyWhatsAppContactGridHeaders() {

        common.logPrint("Step:: Verify 'WhatsApp contact' heading is displayed");
        common.waitUntilElementToBeVisible(By.xpath(whatsAppContactHed));
        common.assertElementPresent(whatsAppContactHed);

        common.logPrint("Step:: Verify 'Search' input box is displayed");
        common.waitUntilElementToBeVisible(By.xpath(searchInp));
        common.assertElementPresent(searchInp);

        common.logPrint("Step:: Verify 'Import' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(importBtn));
        common.assertElementPresent(importBtn);

        common.logPrint("Step:: Verify 'Export' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(exportBtn));
        common.assertElementPresent(exportBtn);

        common.logPrint("Step:: Verify 'Refresh' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(refreshBtn));
        common.assertElementPresent(refreshBtn);

        common.logPrint("Step:: Verify 'Filters' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(filterBtn));
        common.assertElementPresent(filterBtn);

        common.logPrint("Step:: Verify 'Create contact' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(createContact));
        common.assertElementPresent(createContact);

        common.logPrint("Step:: Verify Grid view button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(gridViewBtn));
        common.assertElementPresent(gridViewBtn);

        common.logPrint("Step:: Verify 'List view' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(listViewBtn));
        common.assertElementPresent(listViewBtn);

        common.logPrint("Step:: Verify 'Name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameHeader));
        common.assertElementPresent(nameHeader);

        common.logPrint("Step:: Verify 'Phone Number' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumHeader));
        common.assertElementPresent(phoneNumHeader);

        common.logPrint("Step:: Verify 'Date of Birth' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(DOBHeader));
        common.assertElementPresent(DOBHeader);

        common.logPrint("Step:: Verify 'Email' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailHeader));
        common.assertElementPresent(emailHeader);

        common.logPrint("Step:: Verify 'Company' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(companyHeader));
        common.assertElementPresent(companyHeader);

        common.logPrint("Step:: Verify 'Contact Group' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroupHeader));
        common.assertElementPresent(contactGroupHeader);

        common.logPrint("Step:: Verify 'Created Date' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(createdDateHeader));
        common.assertElementPresent(createdDateHeader);

        common.logPrint("Step:: Verify 'Email Subscription' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailSubscriptionHeader));
        common.assertElementPresent(emailSubscriptionHeader);

        common.logPrint("Step:: Verify 'Actions' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(actionHeader));
        common.assertElementPresent(actionHeader);

        common.logPrint("Step:: Verify Previous button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToPreviousBtn));
        common.assertElementPresent(GoToPreviousBtn);

        common.logPrint("Step:: Verify Next button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToNextBtn));
        common.assertElementPresent(GoToNextBtn);
    }

    public String[] createWhatsAppContactCreate(String phoneNumber){

        common.waitUntilElementToBeVisible(nameInp);
        String name = common.fakeName();
        common.type(nameInp, name);

        common.waitUntilElementToBeVisible(EmailInp);
        String email = name+"123@yopmail.com";
        common.type(EmailInp, email.toLowerCase());

        String dob = common.fakeDOB_MMDDYYYY();
        common.waitUntilElementToBeVisible(dateOfBirthInp);
        common.type(dateOfBirthInp, dob);

        common.waitUntilElementToBeVisible(contactGroup);
        common.click(contactGroup);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(phoneNumberInp);
        common.type(phoneNumberInp, phoneNumber);

        common.waitUntilElementToBeVisible(companyNameInp);
        String companyName = common.fakeCompanyName();
        common.type(companyNameInp, companyName);

        common.waitUntilElementToBeVisible(SubscriptionStatus);
        common.click(SubscriptionStatus);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(selectCountryDropdown);
        common.click(selectCountryDropdown);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(SelectStateInp);
        common.click(SelectStateInp);
        common.type(SelectStateInp, "gujarat");
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(SelectCityInp);
        common.click(SelectCityInp);
        common.type(SelectCityInp, "Ahmedabad");
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(saveButton);
        common.click(saveButton);

        return new String[] {name, email, dob, phoneNumber, companyName};

    }

    public void verifyNoRowsMessageIsShowing(){

        common.logPrint("Step:: Verify No rows message is showing");
        common.assertElementPresent(NoRowsValidation);

    }

    public void verifySuccessMessageForWhatsAppContactCreation(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(createdSuccessfully);

    }

    public void verifyUpdateMessageForWhatsAppContactCreation(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(UpdatedSuccessfully);

    }

    public void verifySuccessMessageForYourAccountIsVerified(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(yourAccountIsVerified);

    }

    public void verifyErrorMessageForInvalidOtp(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(invalidOtpValidation);

        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);

    }

    public void verifySuccessMessageForPasswordResetLink(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(passwordResetLinkSuccess);

        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);

    }

    public void verifySuccessMessageForPasswordUpdated(){

        common.logPrint("Step:: Verify success message is showing");
        common.assertElementPresent(passwordHasBeenUpdated);

        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);

    }


    public void verifyDeleteSuccessfullyMessageForWhatsAppContactCreation(){

        common.logPrint("Step:: Verify Delete message is showing");
        common.assertElementPresent(DeletedSuccessfully);

    }

    public void verifyErrorMessageForDuplicateMobileNumber(String mobileNum){

        common.logPrint("Step:: Verify error message for duplicate mobile number");

        String validation = "//div[text()=\"Contact with phone number '91"+ mobileNum +"' already exists in this business.\"]";

        common.assertElementPresent(validation);

        common.logPrint("Duplicate validation message is showing on the mobile number field ");
    }

    public void exportWhatsAppContact() throws AWTException {

        common.waitUntilElementToBeVisible(exportBtn);
        common.click(exportBtn);

        common.pause(2);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void verifyAllTheElementsArePresentInTheImportPage(){

        common.logPrint("Step:: Verify 'Bulk Upload Whatsapp Contacts' heading is displayed");
        common.waitUntilElementToBeVisible(By.xpath(bulkUploadHeader));
        common.assertElementPresent(bulkUploadHeader);

        common.logPrint("Step:: Verify 'Download sample template' link is displayed");
        common.waitUntilElementToBeVisible(By.xpath(downloadSampleTemplate));
        common.assertElementPresent(downloadSampleTemplate);

        common.logPrint("Step:: Verify 'Bulk Upload' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(bulkUpload));
        common.assertElementPresent(bulkUpload);

        common.logPrint("Step:: Verify 'Queue Data' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(QueueDate));
        common.assertElementPresent(QueueDate);
    }

    public void clickOnTheCreateButton(){

        common.waitUntilElementToBeVisible(createContact);
        common.click(createContact);

    }

    public void clickOnTheEditBtn(){

        common.waitUntilElementToBeVisible(editButton);
        common.click(editButton);
    }

    public void clickOnTheDeleteBtn(){
        common.waitUntilElementToBeVisible(deleteButton);
        common.click(deleteButton);
    }

    public void clickOnTheButtonMenuListView(){
        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementToBeVisible(buttonMenuListView);
        common.click(buttonMenuListView);

    }

    public void clickOnTheViewButtonTextXpath(){
        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementToBeVisible(viewButtonText);
        common.click(viewButtonText);

    }

    public void clickOnTheViewIcon(){
        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementToBeVisible(viewButton);
        common.click(viewButton);

    }

    public void searchTheWhatsAppContactUsingMobileNumber(String mobileNum){

        common.logPrint("Step:: Search contact using a mobile number");
        common.waitUntilElementToBeVisible(By.xpath(searchInp));
        common.type(searchInp, mobileNum);

    }

    public void verifyElementsOnViewPage(){



        common.logPrint("Step:: Verify 'Name' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameLblView));
        common.assertElementPresent(nameLblView);

        common.logPrint("Step:: Verify 'Email' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailLblView));
        common.assertElementPresent(emailLblView);

        common.logPrint("Step:: Verify 'Date of Birth' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(dateOfBirthLbel));
        common.assertElementPresent(dateOfBirthLbel);

        common.logPrint("Step:: Verify 'Contact Group' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroupViewLbl));
        common.assertElementPresent(contactGroupViewLbl);

        common.logPrint("Step:: Verify 'Phone Number' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumberViewLbl));
        common.assertElementPresent(phoneNumberViewLbl);

        common.logPrint("Step:: Verify 'Company Name' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(companyNameLbl));
        common.assertElementPresent(companyNameLbl);

        common.logPrint("Step:: Verify 'Country' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(countryViewLbl));
        common.assertElementPresent(countryViewLbl);

        common.logPrint("Step:: Verify 'State' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(stateViewLbl));
        common.assertElementPresent(stateViewLbl);

        common.logPrint("Step:: Verify 'City' Label field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(cityViewLbl));
        common.assertElementPresent(cityViewLbl);

        common.logPrint("Step:: Verify 'Close Icon' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(cancelButton));
        common.assertElementPresent(cancelButton);

        common.logPrint("Step:: Verify 'Name' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(nameInpView));
        common.assertElementPresent(nameInpView);

        common.logPrint("Step:: Verify 'Email' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailInpView));
        common.assertElementPresent(emailInpView);

        //Input fields steps
        common.logPrint("Step:: Verify 'Date of Birth' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(dateOfBirth));
        common.assertElementPresent(dateOfBirth);

        common.logPrint("Step:: Verify 'Contact Group' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(contactGroupView));
        common.assertElementPresent(contactGroupView);

        common.logPrint("Step:: Verify 'Phone Number' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumberView));
        common.assertElementPresent(phoneNumberView);

        common.logPrint("Step:: Verify 'Company Name' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(companyName));
        common.assertElementPresent(companyName);

        common.logPrint("Step:: Verify 'Country' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(countryView));
        common.assertElementPresent(countryView);

        common.logPrint("Step:: Verify 'State' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(stateView));
        common.assertElementPresent(stateView);

        common.logPrint("Step:: Verify 'City' input field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(cityView));
        common.assertElementPresent(cityView);

    }


    public void createWhatsAppContact() throws IOException {

        redirectsToWhatsAppContactCreatePage();

        String filePath = "C:/Users/Admin/Downloads/WhatsAppContactCreat.xlsx";
        Object[][] contacts = readExcel(filePath, "Sheet1");

        for (int i = 0; i < contacts.length; i++) {

            String name = contacts[i][0].toString();
            String Email = contacts[i][1].toString();
            String DOB = contacts[i][2].toString();
            String Group = contacts[i][3].toString();
            String PhoneNumber = contacts[i][4].toString();

            common.logPrint("Step:: Enter the name");
            common.waitUntilElementToBeVisible(nameInp);
            common.type(nameInp, name);

            common.logPrint("Step:: Select group");
            common.waitUntilElementToBeVisible(contactGroup);
            common.click(contactGroup);

            Actions actions = new Actions(driver);

            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER)
                    .build()
                    .perform();

            common.logPrint("Step:: Enter the email");
            common.waitUntilElementToBeVisible(EmailInp);
            common.type(EmailInp, Email);

            common.logPrint("Step:: Enter the mobile number");
            common.waitUntilElementToBeVisible(phoneNumberInp);
            common.type(phoneNumberInp, PhoneNumber);

            common.logPrint("Step:: Enter the name");
            common.waitUntilElementToBeVisible(nameInp);
            common.click(saveButton);

            // Small wait
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public void verifyViewPageValueAndFieldIsDisabled(String name, String email, String dob, String phoneNumber, String comName ){

        common.logPrint("Step:: Verify the name is showing properly and its disabled");
        WebElement element = common.waitUntilElementToBeVisible(nameInpView);
        boolean isDisabled = !element.isEnabled();
        Assert.assertTrue(isDisabled);
        String getName = common.getText(nameInpView);
        common.assertTwoValuesAreNotEqual(getName, name);
        common.logPrint("Field is disabled - "+ isDisabled);

        common.logPrint("Step:: Verify the Email is showing properly and it's disabled");
        WebElement emailEl = common.waitUntilElementToBeVisible(By.xpath(emailInpView));
        boolean isEmailDisabled = !emailEl.isEnabled();
        Assert.assertTrue(isEmailDisabled);
        String getEmail = common.getText(emailInpView);
        common.assertTwoValuesAreNotEqual(getEmail, email);
        common.logPrint("Email field is disabled - " + isEmailDisabled);

        common.logPrint("Step:: Verify the Date of Birth is showing properly and it's disabled");
        WebElement dobEl = common.waitUntilElementToBeVisible(By.xpath(dateOfBirth));
        boolean isDOBDisabled = !dobEl.isEnabled();
        Assert.assertTrue(isDOBDisabled);
        String getDOB = common.getText(dateOfBirth);
        common.assertTwoValuesAreNotEqual(getDOB, dob);
        common.logPrint("Date of Birth field is disabled - " + isDOBDisabled);

        common.logPrint("Step:: Verify the Phone Number is showing properly and it's disabled");
        WebElement phoneEl = common.waitUntilElementToBeVisible(By.xpath(phoneNumberView));
        boolean isPhoneDisabled = !phoneEl.isEnabled();
        Assert.assertTrue(isPhoneDisabled);
        String getPhone = common.getText(phoneNumberView);
        common.assertTwoValuesAreNotEqual(getPhone, phoneNumber);
        common.logPrint("Phone Number field is disabled - " + isPhoneDisabled);


        common.logPrint("Step:: Verify the Company Name is showing properly and it's disabled");
        WebElement companyEl = common.waitUntilElementToBeVisible(By.xpath(companyName));
        boolean isCompanyDisabled = !companyEl.isEnabled();
        Assert.assertTrue(isCompanyDisabled);
        String getCompany = common.getText(companyName);
        common.assertTwoValuesAreNotEqual(getCompany, comName);
        common.logPrint("Company Name field is disabled - " + isCompanyDisabled);
    }

    public void verifyDeleteFunctionalityIsWorking(){

//        common.waitUntilElementToBeVisible(buttonMenuListView);
//        common.click(buttonMenuListView);

        clickOnTheDeleteBtn();

        common.logPrint("Step:: Again click on the delete button on pop-up");
        common.waitUntilElementToBeVisible(deleteButtonPopup);
        common.click(deleteButtonPopup);

        verifyDeleteSuccessfullyMessageForWhatsAppContactCreation();

        common.logPrint("Delete functionality is working.");
    }

    public void verifyEditFunctionalityIsWorkingProperly(){

        clickOnTheEditBtn();

        common.logPrint("Step:: Update the name of the contact");
        WebElement element = common.waitUntilElementToBeVisible(nameInp);
        element.clear();
        common.pause(1);
        String updatedName = "updatedName" + common.fakeName();
        common.type(nameInp, updatedName);

        common.waitUntilElementToBeVisible(saveButton);
        common.click(saveButton);

    }

    public void searchInListView(String mobNum){

        common.waitUntilElementToBeVisible(listViewBtn);
        common.click(listViewBtn);

        searchTheWhatsAppContactUsingMobileNumber(mobNum);

        common.pause(2);

        common.waitUntilElementToBeVisible(listViewGetMobile);

        String getMobile = common.getText(listViewGetMobile);
        common.logPrint("Raw mobile text: " + getMobile);

        // Remove all non-numeric characters
        String phone = getMobile.replaceAll("[^0-9]", "");

        // Remove country code 91 if present
        if (phone.startsWith("91")) {
            phone = phone.substring(2);
        }

        common.logPrint("Formatted mobile number: " + phone);

        common.assertTwoValuesAreEqual(phone, mobNum);
        common.logPrint("Both values are matched and working fine.");
    }

    public void verifyTheContactInWhatsAppCampaignPage(String name, String email){

        common.logPrint("Step:: Click on the create button");
        common.waitUntilElementToBeVisible(createContact);
        common.click(createContact);

        common.logPrint("Step:: Search the value");
        common.waitUntilElementToBeVisible(SearchContact);
        common.type(SearchContact, name);

        //div[@aria-rowspan='1' and text()='Clifton']

        common.logPrint("Step:: Contact name is displayed on the list");
        String nameGet = "//div[@aria-rowspan='1' and text()='"+name+"']";
        common.assertElementPresent(nameGet);

        common.logPrint("Step:: Contact email is displayed on the list");
        String emailGet = "//div[@aria-rowspan='1' and text()='"+email.toLowerCase()+"']";
        common.assertElementPresent(emailGet);

        common.logPrint("Contact is showing on the whatsapp campaign page");
    }









}
