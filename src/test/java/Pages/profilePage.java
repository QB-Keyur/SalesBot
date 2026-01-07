package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class profilePage extends Locators {

    Common common;

    public String url = EnvConfig.getWebUrl();

    public profilePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void redirectsToProfilePage(){
        common.waitUntilElementToBeVisible(profileIcon);
        common.click(profileIcon);
    }

    public void clickOnUpdateProfileButton(){
        common.waitUntilElementToBeVisible(updateProfile);
        common.click(updateProfile);
    }

    public void clickOnTheUpgradeButton(){
        common.waitUntilElementToBeVisible(upgradeButtonPlan);
        common.click(upgradeButtonPlan);
    }

    public void clickOnTheChangePasswordMenu(){
        common.waitUntilElementToBeVisible(changePassword);
        common.click(changePassword);
    }


    public void clickOnThePlansMenu(){
        common.waitUntilElementToBeVisible(plansMenu);
        common.click(plansMenu);
    }

    public void verifySuccessMessageForPasswordUpdate(){

        common.logPrint("Steps:: Verify success message is showing password is updated");
        common.assertElementPresent(passwordChangedSuccessfully);

    }

    public void verifySettingPageHeaderMenuAndSubmenu(){

        common.logPrint("Step:: Verify 'Account' header is displayed");
        common.assertElementPresent(accountHeader);
        common.logPrint("'Account' header is displayed");

        common.logPrint("Step:: Verify 'Billing & Plan' header is displayed");
        common.assertElementPresent(billingAndPlan);
        common.logPrint("'Billing & Plan' header is displayed");

        common.logPrint("Step:: Verify 'Profile' menu is displayed");
        common.assertElementPresent(profileMenuOnProfile);
        common.logPrint("'Profile' menu is displayed");

        common.logPrint("Step:: Verify 'Change Password' menu is displayed");
        common.assertElementPresent(changePassword);
        common.logPrint("'Change Password' menu is displayed");

        common.logPrint("Step:: Verify 'Plans' menu is displayed");
        common.assertElementPresent(plansMenu);
        common.logPrint("'Plans' menu is displayed");

        common.logPrint("Step:: Verify 'Invoice' menu is displayed");
        common.assertElementPresent(invoiceMenu);
        common.logPrint("'Invoice' menu is displayed");

        common.logPrint("Step:: Verify 'Transaction' menu is displayed");
        common.assertElementPresent(TransactionMenu);
        common.logPrint("'Transaction' menu is displayed");

        common.logPrint("Step:: Verify 'Usage' menu is displayed");
        common.assertElementPresent(UsageMenu);
        common.logPrint("'Usage' menu is displayed");

        common.logPrint("Step:: Verify 'update profile' button is displayed");
        common.assertElementPresent(updateProfileBtn);
        common.logPrint("'Update profile' button is displayed");

    }

    public void verifyProfilePageLabels() {

        common.waitUntilElementToBeVisible(profileMenuOnProfile);
        common.click(profileMenuOnProfile);

        // ================== PERSONAL DETAILS ==================
        common.logPrint("Step:: Verify 'Personal Details' header is displayed");
        common.assertElementPresent(personalDetailHead);
        common.logPrint("'Personal Details' header is displayed");

        common.logPrint("Step:: Verify 'First Name' label is displayed");
        common.assertElementPresent(firstNameLbl);
        common.logPrint("'First Name' label is displayed");

        common.logPrint("Step:: Verify 'Last Name' label is displayed");
        common.assertElementPresent(lastNameLbl);
        common.logPrint("'Last Name' label is displayed");

        common.logPrint("Step:: Verify 'Email' label is displayed");
        common.assertElementPresent(emailLabelProfile);
        common.logPrint("'Email' label is displayed");

        common.logPrint("Step:: Verify 'Mobile No' label is displayed");
        common.assertElementPresent(mobileNumberLabel);
        common.logPrint("'Mobile No' label is displayed");

        common.logPrint("Step:: Verify 'TimeZone' label is displayed");
        common.assertElementPresent(timezoneLabel);
        common.logPrint("'TimeZone' label is displayed");

        // ================== Billing Address ==================

        common.logPrint("Step:: Verify 'Billing Address' header is displayed");
        common.assertElementPresent(billingAddressHed);
        common.logPrint("'Billing Address' label is displayed");

        common.logPrint("Step:: Verify 'Address' label is displayed");
        common.assertElementPresent(addressLabel);
        common.logPrint("'Address' label is displayed");

        common.logPrint("Step:: Verify 'Area' label is displayed");
        common.assertElementPresent(areaLabel);
        common.logPrint("'Area' label is displayed");

        common.logPrint("Step:: Verify 'Country' label is displayed");
        common.assertElementPresent(countryLabel);
        common.logPrint("'Country' label is displayed");

        common.logPrint("Step:: Verify 'State' label is displayed");
        common.assertElementPresent(stateLabel);
        common.logPrint("'State' label is displayed");

        common.logPrint("Step:: Verify 'City' label is displayed");
        common.assertElementPresent(cityLabel);
        common.logPrint("'City' label is displayed");

        common.logPrint("Step:: Verify 'Pincode' label is displayed");
        common.assertElementPresent(pincodeLabel);
        common.logPrint("'Pincode' label is displayed");

        // ================== BUSINESS INFORMATION ==================
        common.logPrint("Step:: Verify 'Business Information' header is displayed");
        common.assertElementPresent(businessHeader);
        common.logPrint("'Business Information' header is displayed");

        common.logPrint("Step:: Verify 'Category' label is displayed");
        common.assertElementPresent(categoryHeader);
        common.logPrint("'Category' label is displayed");

        common.logPrint("Step:: Verify 'Business Name' label is displayed");
        common.assertElementPresent(businessNameLabel);
        common.logPrint("'Business Name' label is displayed");

        common.logPrint("Step:: Verify 'Business Type' label is displayed");
        common.assertElementPresent(businessTypeLabel);
        common.logPrint("'Business Type' label is displayed");

        common.logPrint("Step:: Verify 'Business Strength' label is displayed");
        common.assertElementPresent(getSelectBusinessStrengthInp);
        common.logPrint("'Business Strength' label is displayed");

        common.logPrint("Step:: Verify 'GST Number' label is displayed");
        common.assertElementPresent(gstNumberLabel);
        common.logPrint("'GST Number' label is displayed");

    }

    public void verifyChangePasswordPageLabelsAndFields() {

        common.waitUntilElementToBeVisible(changePassword);
        common.click(changePassword);

        // ================== CHANGE PASSWORD LABELS ==================
        common.logPrint("Step:: Verify 'Current Password' label is displayed");
        common.assertElementPresent(currentPasswordLbl);
        common.logPrint("'Current Password' label is displayed");

        common.logPrint("Step:: Verify 'New Password' label is displayed");
        common.assertElementPresent(newPasswordLbl);
        common.logPrint("'New Password' label is displayed");

        common.logPrint("Step:: Verify 'Confirm Password' label is displayed");
        common.assertElementPresent(confirmPasswordLbl);
        common.logPrint("'Confirm Password' label is displayed");

        // ================== CHANGE PASSWORD INPUT FIELDS ==================
        common.logPrint("Step:: Verify 'Current Password' input field is displayed");
        common.assertElementPresent(currentPasswordInp);
        common.logPrint("'Current Password' input field is displayed");

        common.logPrint("Step:: Verify 'New Password' input field is displayed");
        common.assertElementPresent(newPasswordInp);
        common.logPrint("'New Password' input field is displayed");

        common.logPrint("Step:: Verify 'Confirm Password' input field is displayed");
        common.assertElementPresent(confirmPasswordInpProfile);
        common.logPrint("'Confirm Password' input field is displayed");

        // ================== CHANGE PASSWORD BUTTON ==================
        common.logPrint("Step:: Verify 'Change Password' button is displayed");
        common.assertElementPresent(savePassword);
        common.logPrint("'Change Password' button is displayed");
    }

    public void clickOnTheCloseIconBtnOnCongratulationPopUp(){

        common.waitUntilElementToBeVisible(closeIconOnCongratulation);
        common.click(closeIconOnCongratulation);

    }

    public void verifyPlanIsShowingProperlyOnProfilePage(){

        common.waitUntilElementToBeVisible(plansMenu);
        common.click(plansMenu);

        common.waitUntilElementToBeVisible(getPlanDetail);
        String planName = common.getText(getPlanDetail);

        common.assertTwoValuesAreEqual(planName, "Trial");

    }

    public void verifyProfilePageDetails(String name, String lastName, String email, String mobileNum){

        common.logPrint("Step:: Get values from the profile page and compare");

        common.pause(2);
        common.waitUntilElementToBeVisible(firstNameInpProfile);
        String getName = common.getText(firstNameInpProfile);
        common.logPrint("First name is: "+getName);
        common.assertTwoValuesAreEqual(getName, name);

//        common.waitUntilElementToBeVisible(lastNameInpProfile);
//        String getLastName = common.getText(lastNameInpProfile);
//        common.logPrint("Last name is: "+getLastName);
//        common.assertTwoValuesAreEqual(getLastName, lastName);

        common.waitUntilElementToBeVisible(emailInpProfile);
        String getEmail = common.getText(emailInpProfile);
        common.logPrint("Email is: "+getEmail);
        common.assertTwoValuesAreEqual(getEmail.toLowerCase(), email.toLowerCase());
//
//        common.waitUntilElementToBeVisible(phoneNumberInpProfile);
//        String getMobileNum = common.getText(phoneNumberInpProfile);
//        common.logPrint("Mobile number is: "+getMobileNum);
//        common.assertTwoValuesAreEqual(getMobileNum, mobileNum);
    }

    public void enterCurrentAndNewPass(String currentPass){

        common.waitUntilElementToBeVisible(emailInpProfile);
        common.type(currentPasswordInp, currentPass);

        String newPass ="A"+ common.generateRandomChars(4)+"@12345";

        common.logPrint("New password is: "+ newPass);

        common.waitUntilElementToBeVisible(newPasswordInp);
        common.type(newPasswordInp, newPass);

        common.waitUntilElementToBeVisible(confirmPasswordInpProfile);
        common.type(confirmPasswordInpProfile, newPass);

        common.waitUntilElementToBeVisible(savePassword);
        common.click(savePassword);
    }

    public void verifyPopUpIsDisplayed(){

        common.logPrint("Step:: Verify 'Buy Credits' header is displayed");
        common.assertElementPresent(buyCreditsHed);
        common.logPrint("'Buy Credits' header is displayed");

        common.logPrint("Step:: Verify 'Buy Credits' button is displayed");
        common.assertElementPresent(buyCreditsButton);
        common.logPrint("'Buy Credits' button is displayed");

        common.logPrint("Step:: Verify 'Price per Credit' label is displayed");
        common.assertElementPresent(pricePerCreditLbl);
        common.logPrint("'Price per Credit' label is displayed");

        common.logPrint("Step:: Verify 'Credits to Buy' label is displayed");
        common.assertElementPresent(creditToBuyLbl);
        common.logPrint("'Credits to Buy' label is displayed");

        common.logPrint("Step:: Verify 'Total Amount' label is displayed");
        common.assertElementPresent(totalAmountLbl);
        common.logPrint("'Total Amount' label is displayed");

        common.logPrint("Step:: Verify 'Payable Amount' label is displayed");
        common.assertElementPresent(payableAmountLbl);
        common.logPrint("'Payable Amount' label is displayed");

        common.logPrint("Step:: Verify 'Cancel' button is displayed on popup");
        common.assertElementPresent(cancelButtonPopUp);
        common.logPrint("'Cancel' button is displayed on popup");

        common.logPrint("Step:: Verify 'Buy' button is displayed on credit popup");
        common.assertElementPresent(buyButtonCreditPopup);
        common.logPrint("'Buy' button is displayed on credit popup");
    }

    public void verifyTheLinkPricingPageIsDisplayed(){

        common.logPrint("Step:: Verify pricing link is showing");

        common.logPrint("Step:: Get current link");
        String currentLink = driver.getCurrentUrl();

        common.assertTwoValuesAreEqual(currentLink, url+"/setting/pricing");

        common.logPrint("Redirection is working fine");
    }

    public void verifyCancelAndSaveButtonIsDisplayed(){

        common.logPrint("Step:: Verify 'Cancel' button is displayed");
        common.assertElementPresent(cancelButtonPopUp);
        common.logPrint("'Cancel' button is displayed");

        common.logPrint("Step:: Verify 'Save' button is displayed");
        common.assertElementPresent(saveButton);
        common.logPrint("'Save' button is displayed");
    }




}


