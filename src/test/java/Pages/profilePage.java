package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;

public class profilePage extends Locators {

    Common common;

    public profilePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void redirectsToProfilePage(){
        common.waitUntilElementToBeVisible(profileIcon);
        common.click(profileIcon);
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

        common.logPrint("Step:: Verify 'Address' label is displayed");
        common.assertElementPresent(addressLabel);
        common.logPrint("'Address' label is displayed");
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








}


