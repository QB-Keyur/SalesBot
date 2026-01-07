package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import org.testng.annotations.Test;

public class profileTest extends BasePage {

    //Profile page test cases
    @Test
    public void verifyAllTheMenuAndElementsAreShowingProperly(){
        common.logPrint("Verify all the elements and menu are showing on the profile page");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifySettingPageHeaderMenuAndSubmenu();
    }

    @Test
    public void verifyAllTheLabelIsShowingOnProfileMenu(){
        common.logPrint("Verify profile page labels");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifyProfilePageLabels();
    }

    @Test
    public void verifyAllTheLabelAndInputsOnChangePassword(){
        common.logPrint("Verify change password page label, input field and button");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifyChangePasswordPageLabelsAndFields();
    }

    @Test
    public void verifyPlanIsShowingProperlyOnProfilePage(){
        loginPage.clickOnTheSignUpLink();
        String personalInfo[] = loginPage.addPersonalInformation();
        String email = personalInfo[2];
        common.logPrint("email is: "+email);
        loginPage.addBusinessInformation();
        common.openNewWindow();
        common.switchToWindowByIndex(2);
        common.pause(3);
        String otp = loginPage.getOtpFromYopmail(email);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForYourAccountIsVerified();
        loginPage.completePayment();
        loginPage.verifySuccessMessageForCompleteSignUp();
        profilePage.clickOnTheCloseIconBtnOnCongratulationPopUp();
        profilePage.redirectsToProfilePage();
        profilePage.verifyPlanIsShowingProperlyOnProfilePage();
    }

    @Test
    public void verifyProfileDetailsAreShowingProperly(){
        loginPage.clickOnTheSignUpLink();
        String personalInfo[] = loginPage.addPersonalInformation();
        String name = personalInfo[0];
        String lastName = personalInfo[1];
        String email = personalInfo[2];
        String mobileNum = personalInfo[3];
        common.logPrint("email is: "+email);
        loginPage.addBusinessInformation();
        common.openNewWindow();
        common.switchToWindowByIndex(2);
        common.pause(3);
        String otp = loginPage.getOtpFromYopmail(email);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForYourAccountIsVerified();
        loginPage.completePayment();
        loginPage.verifySuccessMessageForCompleteSignUp();
        profilePage.clickOnTheCloseIconBtnOnCongratulationPopUp();
        profilePage.redirectsToProfilePage();
        profilePage.verifyProfilePageDetails(name, lastName, email, mobileNum);
    }

    @Test
    public void verifyChangePasswordFunctionalityInProfile(){
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(forgotEmail);
        common.openNewWindow();
        String otp = loginPage.getOtpFromYopmail(forgotEmail);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForPasswordResetLink();
        common.switchToWindowByIndex(2);
        loginPage.clickOnResetPasswordOnYopMail();
        common.switchToWindowByIndex(3);
        String updatedPassword = loginPage.enterNewPassword();
        whatsAppContactPage.verifySuccessMessageForPasswordUpdated();
        loginPage.loginWithValidUserNameAndPass(forgotEmail, updatedPassword);
        profilePage.redirectsToProfilePage();
        profilePage.clickOnTheChangePasswordMenu();
        profilePage.enterCurrentAndNewPass(updatedPassword);
        profilePage.verifySuccessMessageForPasswordUpdate();
    }

    @Test
    public void verifyBuyCreditsPopUpIsDisplayed(){
        common.logPrint("Verify Buy Credits pop-up is displayed when clicking on the Buy credits button");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.clickOnThePlansMenu();
        profilePage.verifyPopUpIsDisplayed();
    }

    @Test
    public void verifyWhenClickOnUpgradeButtonIsRedirectsToPricingPage(){
        common.logPrint("Verify upgrade button redirection");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.clickOnThePlansMenu();
        profilePage.clickOnTheUpgradeButton();
        profilePage.verifyTheLinkPricingPageIsDisplayed();
    }

    @Test
    public void verifySaveAndCancelButtonOnProfileUpdate(){
        common.logPrint("Verify save and cancel button on the profile update page");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.clickOnUpdateProfileButton();
        profilePage.verifyCancelAndSaveButtonIsDisplayed();
    }



}