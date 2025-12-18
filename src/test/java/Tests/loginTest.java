package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import org.testng.annotations.Test;

public class loginTest extends BasePage {

    ReadProperties properties = new ReadProperties();
    String[] forgotPasswordCred = properties.getCredentialForForgotPassword();
    String emailForgot = forgotPasswordCred[0];

    //Login page test cases
    @Test
    public void verifyLoginPageIsLoadsSuccessfully(){
        common.logPrint("Verify that the login page loads successfully");
        loginPage.verifyLoginPageIsLoaded();
    }

    @Test
    public void VerifyUserCanLoginWthValidCredentials(){
        common.logPrint("Verify user can log-in with valid credentials");
        loginWithAdminUser();
    }

    @Test
    public void verifyErrorMessageForInvalidCredential(){
        common.logPrint("Verify error message for invalid credentials");
        loginPage.enterInvalidCredential();
        loginPage.verifyErrorMessageIsShowingForInvalidEmailPass();
    }

    @Test
    public void verifyValidationMessageForBlankFields(){
        common.logPrint("Verify validation messages for empty fields");
        loginPage.verifyErrorMessageForBlankFields();
    }

    @Test
    public void verifyRedirectionOfForgotPassword(){
        common.logPrint("Verify Forgot password link navigation");
        loginPage.verifyRedirectionOfForgotPassword();
    }

    @Test
    public void verifyRedirectionOfSignUpPage(){
        common.logPrint("Verify SignUp link navigation");
        loginPage.verifyRedirectionOfSignUpPage();
    }

    @Test
    public void verifyPageLoadTime(){
        common.logPrint("Verify page load time");
        loginPage.verifyLoadTimeOfThePage();
    }

    //Forgot password test cases
    @Test
    public void verifyForgotPasswordPageIsLoadsSuccessfully(){
        common.logPrint("Verify the forgot password page load timing");
        loginPage.verifyPageLoadTimeOfForgotPassword();
    }

    @Test
    public void verifyAllTheElementPresentOnThePage(){
        common.logPrint("Verify all the elements are present on the page");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.verifyAllTheElementsArePresentOnThePage();
    }

    @Test
    public void verifyValidationMessageForEmailFieldOnForgotPassword(){
        common.logPrint("Verify validation message for email field");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.clickOnGetOtpBtn();
        loginPage.errorMessageForEmailRequired();
    }

    @Test
    public void verifySuccessMessageIsShowingForOTPSent(){
        common.logPrint("Verify success message is showing for otp sent");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(emailForgot);
    }

    @Test
    public void verifyValidationMessageForInvalidOtp(){
        common.logPrint("Verify validation Message for invalid otp");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(emailForgot);
        common.pause(2);
        loginPage.enterOtpInInputField("12345");
        whatsAppContactPage.verifyErrorMessageForInvalidOtp();
    }

    @Test
    public void verifySuccessMessageForPasswordResetLink(){
        common.logPrint("Verify success message for password reset link");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(emailForgot);
        common.openNewWindow();
        String otp = loginPage.getOtpFromYopmail(emailForgot);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForPasswordResetLink();
    }

    @Test
    public void verifySuccessMessageForPasswordUpdatedSuccessfully(){
        common.logPrint("Verify success message for password update");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(emailForgot);
        common.openNewWindow();
        String otp = loginPage.getOtpFromYopmail(emailForgot);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForPasswordResetLink();
        common.switchToWindowByIndex(2);
        loginPage.clickOnResetPasswordOnYopMail();
        common.switchToWindowByIndex(3);
        loginPage.enterNewPassword();
        whatsAppContactPage.verifySuccessMessageForPasswordUpdated();
    }

    @Test
    public void verifyForgotPasswordFlowIsWorkingFine(){
        common.logPrint("Verify forgot password flow is working fine");
        loginPage.clickOnTheForgotPasswordBtn();
        loginPage.successMessageForOTPSent(emailForgot);
        common.openNewWindow();
        String otp = loginPage.getOtpFromYopmail(emailForgot);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForPasswordResetLink();
        common.switchToWindowByIndex(2);
        loginPage.clickOnResetPasswordOnYopMail();
        common.switchToWindowByIndex(3);
        String updatedPassword = loginPage.enterNewPassword();
        whatsAppContactPage.verifySuccessMessageForPasswordUpdated();
        loginPage.loginWithValidUserNameAndPass(emailForgot, updatedPassword);
        common.logPrint("Forgot password functionality is working fine");
    }

    @Test
    public void onboardingFlowOnSignUpPage(){
        common.logPrint("Verify onboarding flow");
        loginPage.clickOnTheSignUpLink();
        String personalInfo[] = loginPage.addPersonalInformation();
        String email = personalInfo[2];
        common.logPrint("email is: "+email);
        loginPage.addBusinessInformation();
        common.openNewWindow();
        common.switchToWindowByIndex(2);
        common.pause(2);
        String otp = loginPage.getOtpFromYopmail(email);
        common.switchToWindowByIndex(1);
        loginPage.enterOtpInInputField(otp);
        whatsAppContactPage.verifySuccessMessageForYourAccountIsVerified();
        loginPage.completePayment();
        loginPage.verifySuccessMessageForCompleteSignUp();
    }

}