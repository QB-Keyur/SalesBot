package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;

public class loginPage extends Locators {

    Common common;

    public loginPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void clickOnLoginButton(){

        common.waitUntilElementToBeVisible(LOGINBTN);
        common.click(LOGINBTN);
    }

    public void verifyLoginPageIsLoaded(){

        common.logPrint("Step:: Verify Email and Password fields are displayed.");
        common.assertElementPresent(EMAILINP);
        common.assertElementPresent(PASSWORDINP);

        common.logPrint("Login page is successfully loaded.");
    }

    public void enterInvalidCredential(){

        common.waitUntilElementToBeVisible(EMAILINP);
        common.type(EMAILINP,"username@yopmail.com");

        common.waitUntilElementToBeVisible(PASSWORDINP);
        common.type(PASSWORDINP,"password");

        clickOnLoginButton();
    }

    public void loginWithValidUserNameAndPass(String email, String pas){

        Common common = new Common(getDriver());

        common.logPrint("Login with valid username and pass");

        common.waitUntilElementToBeVisible("//input[@name='email']");
        common.type("//input[@name='email']",email);

        common.waitUntilElementToBeVisible("//input[@name='password']");
        common.type("//input[@name='password']",pas);

        common.waitUntilElementToBeVisible("//button[@type='submit']");
        common.click("//button[@type='submit']");

        common.assertElementPresent("//div[contains(text(), 'Login successful')]");

        common.logPrint("Login successfully.");
        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);
    }

    public void verifyErrorMessageIsShowingForInvalidEmailPass(){
        common.logPrint("Step:: Verify validation message is showing for the invalid email or pass");
        common.assertElementPresent(ERRORMESSAGEFORINVALIDEMAIL);

        common.logPrint("Error message is showing for the invalid email or pass");
    }

    public void verifyErrorMessageForBlankFields(){

        clickOnLoginButton();

        common.logPrint("Step:: Verify message for the email fields");
        common.assertElementPresent(ERROREMAILBLANK);

        common.logPrint("Step:: Verify message for the password fields");
        common.assertElementPresent(ERRORPASSWORDBLANK);

        common.logPrint("Error message is showing for the blank fields");
    }

    public void clickOnTheForgotPasswordBtn(){

        common.waitUntilElementToBeVisible(FORGOTPASSWORD);
        common.click(FORGOTPASSWORD);

    }

    public void clickOnTheSignUpLink(){

        common.waitUntilElementToBeVisible(SIGNUPLINK);
        common.click(SIGNUPLINK);

    }

    public void clickOnGetOtpBtn(){

        common.waitUntilElementToBeVisible(GETOTPBTN);
        common.click(GETOTPBTN);

    }

    public void verifyRedirectionOfForgotPassword(){

        clickOnTheForgotPasswordBtn();

        common.logPrint("Step:: Verify forgot password page is showing using a current url.");
        String getUrl = driver.getCurrentUrl();
        common.logPrint("Redirected URL is: "+ getUrl);
        common.assertTwoValuesAreEqual("https://salesbot.cloud/forgot-password", getUrl);

        common.logPrint("User is successfully redirects to the forgot password page.");
    }

    public void verifyRedirectionOfSignUpPage(){

        clickOnTheSignUpLink();

        common.logPrint("Step:: Verify Sign-up link is showing.");
        String getUrl = driver.getCurrentUrl();
        common.logPrint("Current URL link is: "+ getUrl);

        common.assertTwoValuesAreEqual("https://salesbot.cloud/pricing", getUrl);

        common.logPrint("User is successfully redirects to the Sign-up page.");
    }

    public void verifyLoadTimeOfThePage(){

        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://salesbot.cloud/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long loadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");

        common.logPrint("Load time is: "+ loadTime + "ms");

        Assert.assertTrue(loadTime<= 3000, "Page load time is more then 3 sec");

    }

    public void enterEmailAndPAssWithWhiteSpace(){

        common.waitUntilElementToBeVisible(EMAILINP);
        common.type(EMAILINP,"     ");

        common.waitUntilElementToBeVisible(PASSWORDINP);
        common.type(PASSWORDINP,"     ");

        clickOnLoginButton();
    }

    public void verifyPageLoadTimeOfForgotPassword(){

        clickOnTheForgotPasswordBtn();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long loadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");

        common.logPrint("Load time: "+loadTime);

        Assert.assertTrue(loadTime<=3000, "Page load time is executed in 3 seconds");
    }

    //Forgot password scenarios
    public void verifyAllTheElementsArePresentOnThePage(){

        common.logPrint("Step:: Verify enter email input is displays");
        common.waitUntilElementToBeVisible(By.xpath(ENTEREMAILINPFORGOT));
        common.assertElementPresent(ENTEREMAILINPFORGOT);

        common.logPrint("Step:: Verify Get Otp button is displays");
        common.waitUntilElementToBeVisible(By.xpath(GETOTPBTN));
        common.assertElementPresent(GETOTPBTN);

        common.logPrint("Step:: Verify Back to Login page link is displays");
        common.waitUntilElementToBeVisible(By.xpath(BACKTOLOGINBTN));
        common.assertElementPresent(BACKTOLOGINBTN);
    }

    public void errorMessageForEmailRequired(){
        common.logPrint("Verify message is showing on the email field");
        common.assertElementPresent(ErrorOnEmail);
    }

    public void successMessageForOTPSent(String emailForgot){

        common.waitUntilElementToBeVisible(ENTEREMAILINPFORGOT);
        common.type(ENTEREMAILINPFORGOT, emailForgot);

        common.waitUntilElementToBeVisible(ENTEREMAILINPFORGOT);
        common.click(GETOTPBTN);

        common.logPrint("Step:: Verify success message is showing for the OTP sent successfully");
        common.assertElementPresent(otpSentSuccessfully);

        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);
    }

    public String getOtpFromYopmail(String email){

        driver.get("https://yopmail.com/en/");

        common.waitUntilElementToBeVisible(emailInpYopMail);
        common.type(emailInpYopMail, email);

        common.waitUntilElementToBeVisible(enterArrowBtn);
        common.click(enterArrowBtn);

        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);
        common.pause(1);
        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);

        common.switchToFrameWithName("ifmail");
        common.logPrint("Step:: Get OTP from the mail");
        common.waitUntilElementToBeVisible(otpGetYopmail);
        String otp = common.getText(otpGetYopmail);

        common.switchToDefaultContent();

        return otp;
    }

    public void enterOtpInInputField(String otp){

        String digits[] = otp.split("");

        common.waitUntilElementToBeVisible(otpInp1);
        common.type(otpInp1, digits[0]);

        common.waitUntilElementToBeVisible(otpInp2);
        common.type(otpInp2, digits[1]);

        common.waitUntilElementToBeVisible(otpInp3);
        common.type(otpInp3, digits[2]);

        common.waitUntilElementToBeVisible(otpInp4);
        common.type(otpInp4, digits[3]);

        common.waitUntilElementToBeVisible(otpInp5);
        common.type(otpInp5, digits[4]);

        common.waitUntilElementToBeVisible(otpInp1);
        common.click(LOGINBTN);
    }

    public void clickOnResetPasswordOnYopMail(){

        common.pause(2);
        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);

        common.click(refreshButtonYopmail);

        common.switchToFrameWithName("ifmail");

        common.waitUntilElementToBeVisible(resetPassword);
        common.click(resetPassword);
    }

    public String enterNewPassword(){

        String newPass ="A"+ common.generateRandomChars(4)+"@12345";

        common.logPrint("New password is: "+ newPass);

        common.waitUntilElementToBeVisible(enterPasswordInp);
        common.type(enterPasswordInp, newPass);

        common.waitUntilElementToBeVisible(confirmPasswordInp);
        common.type(confirmPasswordInp, newPass);

        common.waitUntilElementToBeVisible(LOGINBTN);
        common.click(LOGINBTN);

        return newPass;
    }

    public String[] addPersonalInformation(){

        common.waitUntilElementToBeVisible(startFreeTrialBtn);
        common.click(startFreeTrialBtn);

        String name = common.fakeName();
        common.waitUntilElementToBeVisible(firstNameInp);
        common.type(firstNameInp, name);

        String lastName = common.fakeName();
        common.waitUntilElementToBeVisible(lastNameInp);
        common.type(lastNameInp, lastName);

        String email = name+"123@yopmail.com";
        common.waitUntilElementToBeVisible(emailInp);
        common.type(emailInp, email);

        String mobileNum = common.fakeIndianMobileNumber();
        common.waitUntilElementToBeVisible(phoneNumInp);
        common.type(phoneNumInp, mobileNum);

        String password = "Admin@1234";
        common.waitUntilElementToBeVisible(enterPasswordInp);
        common.type(enterPasswordInp, password);

        common.waitUntilElementToBeVisible(confirmPasswordInp);
        common.type(confirmPasswordInp, password);

        common.waitUntilElementToBeVisible(nextBtn);
        common.click(nextBtn);

        return new String[] {name, lastName, email, mobileNum, password};

    }

    public void addBusinessInformation(){

        String companyName = common.generateRandomChars(10).toLowerCase();
        common.waitUntilElementToBeVisible(businessNameInp);
        common.type(businessNameInp, companyName);

        common.logPrint("Step:: Select business strength");
        common.waitUntilElementToBeVisible(selectBusinessStrengthInp);
        common.click(selectBusinessStrengthInp);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select business type");
        common.waitUntilElementToBeVisible(businessType);
        common.click(businessType);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select business category");
        common.waitUntilElementToBeVisible(selectCategory);
        common.click(selectCategory);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(createAccountBtn);
        common.click(createAccountBtn);
    }

    public void completePayment(){

        String address = common.generateRandomChars(8);
        common.waitUntilElementToBeVisible(addressLineInp);
        common.type(addressLineInp, address);

        String area = common.generateRandomChars(8);
        common.waitUntilElementToBeVisible(addressAreaInp);
        common.type(addressAreaInp, area);

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

        String pincode = "362220";
        common.waitUntilElementToBeVisible(pinCodeInp);
        common.type(pinCodeInp, pincode);

        WebElement element = driver.findElement(By.xpath(agreeCheckbox));
        element.click();
//        common.waitUntilElementToBeVisible(agreeCheckbox);
//        common.click(agreeCheckbox);

        common.waitUntilElementToBeVisible(startFreeTrialBtnLastPage);
        common.click(startFreeTrialBtnLastPage);

    }

    public void verifySuccessMessageForCompleteSignUp(){

        common.logPrint("Steps:: Verify success message is showing");
        common.assertElementPresent(congratulationMessage);

    }
}


