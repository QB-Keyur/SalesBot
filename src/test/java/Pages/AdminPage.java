package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.ConfigFileReader;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class AdminPage extends Locators {

    Common common = new Common(driver);

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton(){
        common.logPrint("Step:: Click on the login button");
        common.waitUntilElementToBeVisible(LOGINBTN);
        common.click(LOGINBTN);
    }

    public void verifyLoginPageIsLoaded(){
        common.logPrint("Step:: Verify Email and Password fields");
        common.assertElementPresent(EMAILINP);
        common.assertElementPresent(PASSWORDINP);

        common.logPrint("Login page is successfully loaded.");
    }

    public void enterInvalidCredential(){
        common.waitUntilElementToBeVisible(EMAILINP);
        common.type(EMAILINP,"username@yopmail.com");

        common.logPrint("Step:: Enter the password ");
        common.waitUntilElementToBeVisible(PASSWORDINP);
        common.type(PASSWORDINP,"password");

        clickOnLoginButton();
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

        common.logPrint("Step:: Click on the forgot password ");
        common.waitUntilElementToBeVisible(FORGOTPASSWORD);
        common.click(FORGOTPASSWORD);

    }

    public void clickOnTheSignUpLink(){

        common.logPrint("Step:: Click on the Sign-up link");
        common.waitUntilElementToBeVisible(SIGNUPLINK);
        common.click(SIGNUPLINK);

    }

    public void verifyRedirectionOfForgotPassword(){

        clickOnTheForgotPasswordBtn();

        common.logPrint("Step:: Verify forgot password page is showing using an link");
        String getUrl = driver.getCurrentUrl();
        common.logPrint("Current URL: "+ getUrl);

        common.assertTwoValuesAreEqual("https://salesbot.cloud/forgot-password", getUrl);

        common.logPrint("User is successfully redirects to the forgot password page");
    }

    public void verifyRedirectionOfSignUpPage(){

        clickOnTheSignUpLink();

        common.logPrint("Step:: Verify Sign-up link is showing");
        String getUrl = driver.getCurrentUrl();
        common.logPrint("Current URL: "+ getUrl);

        common.assertTwoValuesAreEqual("https://salesbot.cloud/pricing", getUrl);

        common.logPrint("User is successfully redirects to the Sign-up page");
    }

    public void verifyLoadTimeOfThePage(){

        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://salesbot.cloud/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long loadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");

        common.logPrint("Load time is: "+ loadTime);

        Assert.assertTrue(loadTime<= 3000, "Page load time is executed in 3 seconds");

    }

    public void enterEmailAndPAssWithWhiteSpace(){

        common.waitUntilElementToBeVisible(EMAILINP);
        common.type(EMAILINP,"     ");

        common.logPrint("Step:: Enter the password ");
        common.waitUntilElementToBeVisible(PASSWORDINP);
        common.type(PASSWORDINP,"     ");

        clickOnLoginButton();
    }

    public void verifyPageLoadTimeOfForgotPassword(){

        clickOnTheForgotPasswordBtn();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long loadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");

        common.logPrint("Load time: "+loadTime);

        Assert.assertTrue(loadTime<-3000, "Page load time is executed in 3 seconds");
    }

}


