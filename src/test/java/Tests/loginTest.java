package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class loginTest extends BasePage {

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
    public void verifyOnboardingFlow(){
        common.logPrint("Verify the onboarding flow");
    }


}