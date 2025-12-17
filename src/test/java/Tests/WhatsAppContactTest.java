package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class WhatsAppContactTest extends BasePage {

    @Test
    public void verifyWhatsAppGridPageElement() {
        common.logPrint("Verify WhatsApp grid page elements");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactPage();
        whatsAppContactPage.verifyWhatsAppContactGridHeaders();
    }

    @Test
    public void verifyWhatsAppCreatePageElement() {
        common.logPrint("Verify create whatsapp contact using an POI excel sheet");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        whatsAppContactPage.verifyWhatsAppContactPageUI();
    }

    @Test
    public void verifyValidationMessagesForContactCreationPage() {
        common.logPrint("Verify the validation messages for the contact creation page");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        whatsAppContactPage.verifyValidationMessagesForMandatoryFieldInContactPage();
    }

    @Test
    public void createNewWhatsAppContactWithAllTheDetails() {
        common.logPrint("Verify the whatsapp creation functionality");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
    }

    @Test
    public void verifyValidationMessageForDuplicateMobileNum() {
        common.logPrint("Verify Error message for duplicate mobile number");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();

        whatsAppContactPage.clickOnTheCreateButton();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifyErrorMessageForDuplicateMobileNumber(mobileNumber);
    }

    @Test
    public void verifyExportFunctionality() throws AWTException {
        common.logPrint("Verify Export functionality");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactPage();
        whatsAppContactPage.exportWhatsAppContact();
    }

    @Test
    public void verifyTheElementIsPresentInTheImportModule() throws IOException {
        common.logPrint("Verify create whatsapp contact using an POI excel sheet");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactPage();
        whatsAppContactPage.redirectsToImportPage();
        whatsAppContactPage.verifyAllTheElementsArePresentInTheImportPage();
    }

    @Test
    public void verifyViewPageElementsArePresent() throws IOException {
        common.logPrint("Verify view page all the Elements are displayed");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactPage();
        whatsAppContactPage.verifyElementsOnViewPage();
    }

    @Test
    public void verifyViewFunctionalityIsWorking() throws IOException {
        common.logPrint("Verify View Functionality is working properly");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        String[] whatsAppInfo = whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        String name = whatsAppInfo[0];
        String email = whatsAppInfo[1];
        String dob = whatsAppInfo[2];
        String phoneNumber = whatsAppInfo[3];
        String companyName = whatsAppInfo[4];
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        whatsAppContactPage.searchTheWhatsAppContactUsingMobileNumber(mobileNumber);
        whatsAppContactPage.verifyViewPageValueAndFieldIsDisabled(name, email, dob, phoneNumber, companyName);
    }

    @Test
    public void verifyDeleteFunctionalityIsWorkingFine() {
        common.logPrint("Verify delete functionality is working properly");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        whatsAppContactPage.verifyDeleteFunctionalityIsWorking();
    }

    @Test
    public void verifyEditFunctionalityOnWhatsAppContact(){
        common.logPrint("Verify delete functionality is working properly");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        whatsAppContactPage.verifyEditFunctionalityIsWorkingProperly();
        whatsAppContactPage.verifyUpdateMessageForWhatsAppContactCreation();
    }

    @Test
    public void verifySearchFunctionalityInListView(){
        common.logPrint("Verify search functionality on list view");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        whatsAppContactPage.searchInListView(mobileNumber);
    }

    @Test
    public void verifyViewFunctionalityIsWorkingOnListView() throws IOException {
        common.logPrint("Verify View Functionality is working properly on view page");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        String[] whatsAppInfo = whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        String name = whatsAppInfo[0];
        String email = whatsAppInfo[1];
        String dob = whatsAppInfo[2];
        String phoneNumber = whatsAppInfo[3];
        String companyName = whatsAppInfo[4];
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        common.pause(1);
        whatsAppContactPage.redirectsToWhatsappContactListView();
        common.pause(2);
        whatsAppContactPage.searchTheWhatsAppContactUsingMobileNumber(mobileNumber);
        common.pause(1);
        whatsAppContactPage.verifyViewPageValueAndFieldIsDisabled(name, email, dob, phoneNumber, companyName);
    }

    @Test
    public void verifyDeleteFunctionalityOnListView() {
        common.logPrint("Verify delete functionality is working on List view");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        common.pause(1);
        whatsAppContactPage.redirectsToWhatsappContactListView();
        common.pause(2);
        whatsAppContactPage.searchTheWhatsAppContactUsingMobileNumber(mobileNumber);
        common.pause(1);
        whatsAppContactPage.verifyDeleteFunctionalityIsWorking();
    }

    @Test
    public void verifyMessageWhenSearchValueIsNotInTheGrid(){
        common.logPrint("Verify No rows message is showing when search value is not matched");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactPage();
        whatsAppContactPage.searchTheWhatsAppContactUsingMobileNumber("1231312");
        whatsAppContactPage.verifyNoRowsMessageIsShowing();
    }

    @Test
    public void verifyCreatedContactReflectingOnTheWhatsAppCampaignPage(){
        common.logPrint("Verify created contact reflecting on the whatsapp campaign page");
        loginWithAdminUser();
        whatsAppContactPage.redirectsToWhatsAppContactCreatePage();
        String mobileNumber = common.fakeIndianMobileNumber();
        String[] whatsAppInfo = whatsAppContactPage.createWhatsAppContactCreate(mobileNumber);
        String name = whatsAppInfo[0];
        String email = whatsAppInfo[1];
        whatsAppContactPage.verifySuccessMessageForWhatsAppContactCreation();
        whatsAppContactPage.redirectsToHomePage();
        whatsAppContactPage.redirectsToWhatsAppCampaignPage();
        whatsAppContactPage.verifyTheContactInWhatsAppCampaignPage(name, email);
    }

    @Test
    public void createWhatsAppContactUsingAnPOI() throws IOException {
        common.logPrint("Verify create whatsapp contact using an POI excel sheet");
        loginWithAdminUser();
        whatsAppContactPage.createWhatsAppContact();
    }





}
