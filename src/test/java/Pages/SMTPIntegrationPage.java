package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SMTPIntegrationPage extends Locators {
    Common common;

    public SMTPIntegrationPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToSMTPIntegrationPage() {
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);
        common.click(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(INTEGRATIONHEADER);
        common.assertElementPresent(INTEGRATIONHEADER);
        common.logPrint(INTEGRATIONHEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl()+"integration";

        if(curUrl.equals(expectedURL)){
            common.logPrint("Passed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
        else{
            common.logPrint("Failed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
    }

    public void verifySMTPIntegrationUIElements() {
        goToSMTPIntegrationPage();

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);

        common.assertElementPresent(SMTPINTEGRATION);
        common.assertElementPresent(SMTPICON);
        common.assertElementPresent(SMTPMESSAGE);
        common.assertElementPresent(SMTPMESSAGE2);

        boolean isConnected = common.isElementPresent(SMTPCONNECTED);
        boolean isDisconnected = common.isElementPresent(SMTPDISCONNECTED);

        Assert.assertTrue(
                isConnected || isDisconnected,
                "FAILED: Neither SMTP Connected nor Disconnected status is visible"
        );

        common.logPrint("SMTP status displayed: " +
                (isConnected ? "CONNECTED" : "DISCONNECTED"));
    }

    public void verifySMTPCreateElements(){
        goToSMTPIntegrationPage();

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.assertElementPresent(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(SIHEADER);

        common.assertElementPresent(SIHEADER);
        common.assertElementPresent(SIICON);
        if(common.isElementDisplayed(SIHEADERMESSAGE)){
        common.assertElementPresent(SIHEADERMESSAGE);
        common.assertElementPresent(SENDERNAMEHEADER);
        common.assertElementPresent(PROVIDERTYPEHEADER);
        common.assertElementPresent(EMAILHEADER);
        common.assertElementPresent(PASSWORDHEADER);
        common.assertElementPresent(PORTHEADER);
        common.assertElementPresent(TERMS);
        common.isElementEnabled(TERMSCB);
        common.assertElementPresent(CONNECT);}
        else{
            common.assertElementPresent(SENDERNAMEHEADER);
            common.assertElementPresent(PROVIDERTYPEHEADER);
            common.assertElementPresent(EMAILHEADER);
            common.assertElementPresent(PASSWORDHEADER);
            common.assertElementPresent(PORTHEADER);
//            common.assertElementPresent(TERMS);
//            common.isElementEnabled(TERMSCB);
            common.assertElementPresent(SIEDIT);
        }
    }

    public void verifySMTPMandatoryFields(){
        goToSMTPIntegrationPage();

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.assertElementPresent(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(SIHEADER);

        common.assertElementPresent(SIHEADER);
        common.selectCheckbox(TERMSCB);

        common.waitUntilElementToBeVisible(CONNECT);
        common.click(CONNECT);

        common.waitUntilElementToBeVisible(SENDERNAMEVAL);
        common.assertElementPresent(SENDERNAMEVAL);
        common.assertElementPresent(PROVIDERVAL);
        common.assertElementPresent(EMAILVAL);
        common.assertElementPresent(PASSWORDVAL);

    }

    public void verifyIntegrationWithWhiteSpace(){
        goToSMTPIntegrationPage();

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.assertElementPresent(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(SIHEADER);

        common.assertElementPresent(SIHEADER);

        common.waitUntilElementToBeVisible(SINAMEINPUT);
        common.type(SINAMEINPUT,"  ");

        common.waitUntilElementToBeVisible(SIPROVIDERINPUT);
        common.type(SIPROVIDERINPUT,"  ");

        common.waitUntilElementToBeVisible(SIEMAILINPUT);
        common.type(SIEMAILINPUT,"  ");

        common.waitUntilElementToBeVisible(SIPASSINPUT);
        common.type(SIPASSINPUT,"  ");

        common.waitUntilElementToBeVisible(SIPORTINPUT);
        common.type(SIPORTINPUT,"  ");

        common.selectCheckbox(TERMSCB);

        common.waitUntilElementToBeVisible(CONNECT);
        common.click(CONNECT);

        common.assertElementPresent(PROVIDERREQVAL);
        common.assertElementPresent(PASSWORDREQVAL);




    }

    public void verifyIntegratingWithValidData(String name, String provider, String email, String password, String port){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.assertElementPresent(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(SIHEADER);

        common.assertElementPresent(SIHEADER);
        common.pause(3);

        if(common.isElementDisplayed(SIEDIT)){
            common.logPrint("Already connected before");
            common.click(SIEDIT);

            common.waitUntilElementToBeVisible(SINAMEINPUT);
            common.type(SINAMEINPUT,name);

            common.waitUntilElementToBeVisible(SIPROVIDERINPUT);
            common.pause(2);
            String providerVal = "//li[contains(text(),'"+provider+"')]";
            common.logPrint("Provider: "+provider+ " ProviderVal: "+providerVal);
            common.pause(2);
            driver.findElement(By.xpath(SIPROVIDERINPUT)).sendKeys(providerVal);
            common.waitUntilElementToBeVisible(providerVal);
            common.click(providerVal);

            common.waitUntilElementToBeVisible(SIEMAILINPUT);
            common.clear(SIEMAILINPUT);
            common.type(SIEMAILINPUT,email);

            common.waitUntilElementToBeVisible(SIPASSINPUT);
            common.clear(SIPASSINPUT);
            common.type(SIPASSINPUT,password);

            common.waitUntilElementToBeVisible(SIPORTINPUT);
            common.clear(SIPORTINPUT);
            common.type(SIPORTINPUT,port);
            String portVal = "//li[contains(text(),'"+port+"')]";
            common.waitUntilElementToBeVisible(portVal);
            common.click(portVal);

            common.selectCheckbox(TERMSCB);

            common.waitUntilElementToBeVisible(CONNECT);
            common.click(CONNECT);

            boolean integrationMsg = common.isElementPresent(INTEGRATIONVALMESSAGE);
            boolean failMsg = common.isElementPresent(FAILVALMESSAGE);


            Assert.assertTrue(
                    integrationMsg || failMsg,
                    "Neither Integration validation message nor Failure validation message is displayed"
            );


        }

        common.waitUntilElementToBeVisible(SINAMEINPUT);
        common.type(SINAMEINPUT,name);

        common.waitUntilElementToBeVisible(SIPROVIDERINPUT);
        common.logPrint("Provider: "+provider);
        common.clear(SIPROVIDERINPUT);
        common.type(SIPROVIDERINPUT,provider);
        String providerVal = "//li[contains(text(),'"+provider+"')]";
        common.waitUntilElementToBeVisible(providerVal);
        common.click(providerVal);


        common.waitUntilElementToBeVisible(SIEMAILINPUT);
        common.type(SIEMAILINPUT,email);

        common.waitUntilElementToBeVisible(SIPASSINPUT);
        common.type(SIPASSINPUT,password);

        common.waitUntilElementToBeVisible(SIPORTINPUT);
        common.type(SIPORTINPUT,port);
        String portVal = "//li[contains(text(),'"+port+"')]";
        common.waitUntilElementToBeVisible(portVal);
        common.click(portVal);

        common.selectCheckbox(TERMSCB);

        common.waitUntilElementToBeVisible(CONNECT);
        common.click(CONNECT);

        boolean integrationMsg = common.isElementPresent(INTEGRATIONVALMESSAGE);
        boolean failMsg = common.isElementPresent(FAILVALMESSAGE);


        Assert.assertTrue(
                integrationMsg || failMsg,
                "Neither Integration validation message nor Failure validation message is displayed"
        );




    }

    public void verifyViewEye(){
        goToSMTPIntegrationPage();

        String tokenHidden = "//input[@placeholder=\"Enter password\" and @type=\"password\"]";
        String tokenUnhide = "//input[@placeholder=\"Enter password\" and @type=\"text\"]";
        String viewButton = "//input[@placeholder=\"Enter password\"]/following::button[@type=\"button\"]";

        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(SIHEADER);
        common.pause(2);

        if(common.isElementDisplayed(SIEDIT)){

            common.click(SIEDIT);

            common.waitUntilElementToBeVisible(SIPASSINPUT);
            common.type(SIPASSINPUT,"123213");

            common.waitUntilElementToBeVisible(viewButton);
            common.click(viewButton);

            common.waitUntilElementToBeVisible(tokenUnhide);
            common.assertElementPresent(tokenUnhide);

        }
        else {
            common.logPrint("Edit button not found");
            common.waitUntilElementToBeVisible(SIPASSINPUT);
            common.type(SIPASSINPUT, "123213");

            common.waitUntilElementToBeVisible(viewButton);
            common.click(viewButton);

            common.waitUntilElementToBeVisible(tokenUnhide);
            common.assertElementPresent(tokenUnhide);
        }

    }

    public void verifyDoesntAllowHavingConversationWhenNotConnected(){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(SMTPCONNECTED);

        if(common.isElementDisplayed(SMTPDISCONNECTED)|common.isElementDisplayed(SMTPPENDING)){
            common.assertElementPresent(CONVERSATIONMENU);
            common.click(CONVERSATIONMENU);

            common.assertElementPresent("//button[text()='Email Conversation']");
            common.click("//button[text()='Email Conversation']");

            common.assertElementPresent("//p[text()='To use this functionality, please connect your SMTP integration first.']");
        }



    }

    public void verifyDoesntAllowCreatingTemplateWhenNotConnected(){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(SMTPCONNECTED);

        if(common.isElementDisplayed(SMTPDISCONNECTED)|common.isElementDisplayed(SMTPPENDING)){
            common.assertElementPresent(TEMPLATEMENU);
            common.click(TEMPLATEMENU);

            common.assertElementPresent("//button[text()='Email Template']");
            common.click("//button[text()='Email Template']");

            common.assertElementPresent("//p[text()='To use this functionality, please connect your SMTP integration first.']");
        }



    }

    public void verifyAllowsHavingConversationAfterConnecting(){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementPresent(SMTPCONNECTED);

        common.assertElementPresent(CONVERSATIONMENU);
        common.click(CONVERSATIONMENU);

        common.assertElementPresent("//button[text()='Email Conversation']");
        common.click("//button[text()='Email Conversation']");

        common.assertElementPresent("//span[text()='Connected']");
        common.logPrint("SMTP Connected Successfully");






    }

    public void verifyAllowsCreatingTemplateAfterConnected(){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementPresent(SMTPCONNECTED);

        common.assertElementPresent(TEMPLATEMENU);
        common.click(TEMPLATEMENU);

        common.assertElementPresent("//button[text()='Email Template']");
        common.click("//button[text()='Email Template']");

        common.waitUntilElementToBeVisible(CREATE);
        common.assertElementPresent(CREATE);

    }

    public void verifyDisconnecting(){
        goToSMTPIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementPresent(SMTPCONNECTED);

        common.assertElementPresent(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.waitUntilElementToBeVisible(DISCONNECTBUTTON);
        common.scroll_To_Element(DISCONNECTBUTTON);
        common.click(DISCONNECTBUTTON);

        common.waitUntilElementToBeVisible(DISCONNECTMESSAGE);
        common.assertElementPresent(DISCONNECTMESSAGE);


    }

    public void verifyIntegrationSteps(){
        goToSMTPIntegrationPage();

        common.waitUntilElementToBeVisible(SMTPINTEGRATION);
        common.click(SMTPINTEGRATION);

        common.pause(2);

        if(!common.isElementPresent(WIIINTEGRATIONBUTTON)){
            String provider = "Gmail";
            common.waitUntilElementToBeVisible(SIPROVIDERINPUT);
            common.logPrint("Provider: "+provider);
            common.clear(SIPROVIDERINPUT);
            common.type(SIPROVIDERINPUT,provider);
            String providerVal = "//li[contains(text(),'"+provider+"')]";
            common.waitUntilElementToBeVisible(providerVal);
            common.click(providerVal);
        }

        common.waitUntilElementToBeVisible(WIIINTEGRATIONBUTTON);
        common.click(WIIINTEGRATIONBUTTON);

        common.assertElementPresent(STEP1_ENABLE_2FA_TITLE);

        common.assertElementPresent(GOOGLE_ACCOUNT_SETTINGS_TITLE);
        common.assertElementPresent(GOOGLE_ACCOUNT_INFO);

        common.assertElementPresent(STEP2_GENERATE_APP_PASSWORD_TITLE);
        common.assertElementPresent(PASSINFO);

        common.assertElementPresent(SECURITY_SECTION_SIGN_IN_TITLE);

        common.assertElementPresent(STEP3_CREATE_APP_PASSWORD_TITLE);

        common.assertElementPresent(SELECT_APP_MAIL_TITLE);
        common.assertElementPresent(MAILINFO);

        common.assertElementPresent(STEP4_COPY_PASSWORD_TITLE);

        common.assertElementPresent(GOOGLE_16_CHARACTER_PASSWORD_TITLE);
        common.assertElementPresent(GOOGLEPASSINFO);

        common.assertElementPresent(STEP1_CONTAINER);
        common.assertElementPresent(STEP2_CONTAINER);
        common.assertElementPresent(STEP3_CONTAINER);
        common.assertElementPresent(STEP4_CONTAINER);
    }
}
