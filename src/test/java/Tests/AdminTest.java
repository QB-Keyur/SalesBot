package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class AdminTest extends BasePage {

    //Login page test cases
    @Test
    public void verifyLoginPageIsLoadsSuccessfully(){
        common.logPrint("Verify that the login page loads successfully");
        adminPage.verifyLoginPageIsLoaded();
    }

    @Test
    public void VerifyUserCanLoginWthValidCredentials(){
        common.logPrint("Verify user can log-in with valid credentials");
        loginWithAdminUser();
    }

    @Test
    public void verifyErrorMessageForInvalidCredential(){
        common.logPrint("Verify error message for invalid credentials");
        adminPage.enterInvalidCredential();
        adminPage.verifyErrorMessageIsShowingForInvalidEmailPass();
    }

    @Test
    public void verifyValidationMessageForBlankFields(){
        common.logPrint("Verify validation messages for empty fields");
        adminPage.verifyErrorMessageForBlankFields();
    }

    @Test
    public void verifyRedirectionOfForgotPassword(){
        common.logPrint("Verify Forgot password link navigation");
        adminPage.verifyRedirectionOfForgotPassword();
    }

    @Test
    public void verifyRedirectionOfSignUpPage(){
        common.logPrint("Verify SignUp link navigation");
        adminPage.verifyRedirectionOfSignUpPage();
    }

    @Test
    public void verifyPageLoadTime(){
        common.logPrint("Verify page load time");
        adminPage.verifyLoadTimeOfThePage();
    }

    @Test
    public void verifyWhenLoginWithWhiteSPaceInEMailAndPass(){
        common.logPrint("Verify When Login With White SPace In EMail And Pass");
        adminPage.enterEmailAndPAssWithWhiteSpace();
    }

    //Forgot password test cases
    @Test
    public void verifyForgotPasswordPageIsLoadsSuccessfully(){
        common.logPrint("Verify the forgot password page load timing");
        adminPage.verifyPageLoadTimeOfForgotPassword();
    }

    @Test
    public void verifyOnboardingFlow(){
        common.logPrint("Verify the onboarding flow");

    }





}