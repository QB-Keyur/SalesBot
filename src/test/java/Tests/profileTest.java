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





}