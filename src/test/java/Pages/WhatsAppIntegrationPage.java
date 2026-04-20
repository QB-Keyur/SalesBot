package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import groovy.transform.Undefined;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WhatsAppIntegrationPage extends Locators {

    Common common;

    public WhatsAppIntegrationPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToWhatsAppIntegrationPage() {
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

    public void verifyWhatsAppIntegrationMenu() {

        goToWhatsAppIntegrationPage();

        common.waitUntilElementToBeVisible(INTEGRATIONHEADER);

        common.assertElementPresent(INTEGRATIONHEADER);
        common.assertElementPresent(WIMENU);
        common.assertElementPresent(WIICON);
        common.assertElementPresent(WIMESSAGE);
        common.assertElementPresent(WIMESSAGE2);

        boolean isDisconnected = common.isElementPresent(WIDISCONNECTED);
        boolean isConnected = common.isElementPresent(WICONNECTED);

        Assert.assertTrue(
                isDisconnected || isConnected,
                "FAILED: WhatsApp Integration should be either CONNECTED or DISCONNECTED"
        );

        if (isConnected) {
            common.logPrint("WhatsApp Integration Status: CONNECTED");
        } else {
            common.logPrint("WhatsApp Integration Status: DISCONNECTED");
        }
    }

    public void verifyElementsInsideWhatsAppIntegrationMenu(){
        goToWhatsAppIntegrationPage();

        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);
        common.pause(1);

        common.assertElementIsNotDisplayedWithMessage(
                STATISTICS,
                "FAILED: As an account was already used, use a new account for this test"
        );

        common.assertElementPresent(WIIHEADER);
        common.assertElementPresent(WIIICON);
        common.assertElementPresent(WIIHEADERMESSAGE);

        common.assertElementPresent(WIIINTEGRATIONBUTTON);
        common.click(WIIINTEGRATIONBUTTON);
        common.waitUntilElementToBeVisible(WIISTEPS);
        common.assertElementPresent(WIISTEPS);
        common.assertElementPresent(STEP1_ALL_LI);
        common.assertElementPresent(STEP1_LI_GO_TO_META);
        common.assertElementPresent(STEP1_LI_LOGIN_FACEBOOK);
        common.assertElementPresent(STEP1_LI_CREATE_DEV_ACCOUNT);

        common.assertElementPresent(STEP2_ALL_LI);
        common.assertElementPresent(STEP2_LI_GO_TO_DASHBOARD);
        common.assertElementPresent(STEP2_LI_SELECT_BUSINESS);
        common.assertElementPresent(STEP2_LI_ENTER_APP_DETAILS);
        common.assertElementPresent(STEP2_LI_CREATE_APP);

        common.scroll_To_Element(STEP3_ALL_LI);

        common.assertElementPresent(STEP3_ALL_LI);
        common.assertElementPresent(STEP3_LI_ADD_PRODUCTS);
        common.assertElementPresent(STEP3_LI_SET_UP_WHATSAPP);
        common.assertElementPresent(STEP3_LI_WABA_CREATED);

        common.scroll_To_Element(STEP4_PHONE_WABA_ALL_LI);
        common.assertElementPresent(STEP4_PHONE_WABA_ALL_LI);
        common.assertElementPresent(STEP4_LI_API_SETUP);
        common.assertElementPresent(STEP4_LI_VERIFY_OTP);
        common.assertElementPresent(STEP4_LI_SEND_TEST_MESSAGE);
        common.assertElementPresent(STEP4_LI_COPY_IDS);
        common.assertElementPresent(STEP4_APP_ALL_LI);
        common.assertElementPresent(STEP4_LI_BASIC_SETTINGS);
        common.assertElementPresent(STEP4_LI_COPY_APP_IDS);

        common.scroll_To_Element(STEP5_ALL_LI);
        common.assertElementPresent(STEP5_ALL_LI);
        common.assertElementPresent(STEP5_LI_BUSINESS_VERIFICATION);
        common.assertElementPresent(STEP5_LI_MESSAGE_TEMPLATES);
        common.assertElementPresent(STEP5_LI_ASSIGN_PHONE);
        common.assertElementPresent(STEP5_LI_WEBHOOK);
        common.assertElementPresent(STEP5_LI_LIVE_MODE);

        common.scroll_To_Element(STEP6_ALL_LI);
        common.assertElementPresent(STEP6_ALL_LI);
        common.assertElementPresent(STEP6_LI_TEMP_TOKEN);
        common.assertElementPresent(STEP6_LI_PERM_TOKEN);
//        common.assertElementPresent(STEP6_PERMISSIONS_ALL_LI);
        common.assertElementPresent(STEP6_LI_PERMISSION_MSG);
        common.assertElementPresent(STEP6_LI_PERMISSION_MGMT);
        common.assertElementPresent(STEP6_LI_PERMISSION_PROFILE);

        common.scroll_To_Element(STEP7_DESCRIPTION);
        common.assertElementPresent(STEP7_DESCRIPTION);
        common.assertElementPresent(STEP7_CONNECT_TEXT);

        common.scroll_To_Element(WIIINTEGRATIONBUTTON);
        common.click(WIIINTEGRATIONBUTTON);

        common.assertElementPresent(WIIPHONEID);
        common.assertElementPresent(WIIPHONEIDINPUT);
        common.assertElementPresent(WIIPHONEIDTOOLTIP);
        common.assertElementPresent(WIIWABAID);
        common.assertElementPresent(WIIWABAIDINPUT);
        common.assertElementPresent(WIIWABAIDTOOLTIP);
        common.assertElementPresent(WIITOKEN);
        common.assertElementPresent(WIITOKENINPUT);
        common.assertElementPresent(WIITOKENTOOLTIP);
        common.assertElementPresent(WIIAPPID);
        common.assertElementPresent(WIIAPPIDINPUT);
        common.assertElementPresent(WIIAPPIDTOOLTIP);
        common.assertElementPresent(WIIAPPSECRET);
        common.assertElementPresent(WIIAPPSECRETINPUT);
        common.assertElementPresent(WIIAPPSECRETTOOLTIP);
        common.assertElementPresent(WIICONNECT);
    }

    public void verifyMandatoryFieldValidationInWhatsAppIntegration(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.pause(1);

        common.assertElementIsNotDisplayedWithMessage(
                STATISTICS,
                "FAILED: As an account was already used, use a new account for this test"
        );

        common.waitUntilElementToBeVisible(WIICONNECT);
        common.scroll_To_Element(WIICONNECT);
        common.click(WIICONNECT);

        int mandatoryFields = common.getMandatoryFieldCount();
        Assert.assertEquals(
                mandatoryFields,
                5,
                "Mandatory field count mismatch. Expected: 5 but found: " + mandatoryFields
        );



        common.waitUntilElementToBeVisible(PHONEIDVAL);

        common.assertElementPresent(PHONEIDVAL);
        common.assertElementPresent(WABAIDVAL);
        common.assertElementPresent(TOKENVAL);
        common.assertElementPresent(APPIDVAL);
        common.assertElementPresent(APPSECRETIDVAL);




    }

    public void verifyIntegrationWithWhiteSpaces(){
        goToWhatsAppIntegrationPage();
        String phoneIDVal = "//span[text()='Phone Id']/following::span[text()='Only digits allowed (max 20 digits)'][1]";
        String wabaIDVal = "//span[text()='Waba Id']/following::span[text()='Only digits allowed (max 20 digits)'][1]";
        String appIDVal = "//span[text()='App Id']/following::span[text()='Only digits allowed (max 20 digits)']";

        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if there's already a WhatsApp is connected");
        common.assertElementIsNotDisplayed(WICONNECTED);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.pause(1);

        common.waitUntilElementToBeVisible(WIEDITBTN);
        common.click(WIEDITBTN);

//        common.assertElementIsNotDisplayedWithMessage(
//                STATISTICS,
//                "FAILED: As an account was already used, use a new account for this test"
//        );

        common.waitUntilElementToBeVisible(WIIPHONEIDINPUT);
        common.ctrlAAndBackspace();
        common.pause(1);


        common.waitUntilElementToBeVisible(WIIWABAIDINPUT);
        common.ctrlAAndBackspace();
        common.pause(1);


        common.waitUntilElementToBeVisible(WIITOKENINPUT);
        common.ctrlAAndBackspace();
        common.type(WIITOKENINPUT,"     ");

        common.waitUntilElementToBeVisible(WIIAPPIDINPUT);
        common.ctrlAAndBackspace();
        common.pause(1);


        common.waitUntilElementToBeVisible(WIIAPPSECRETINPUT);
        common.ctrlAAndBackspace();
        common.type(WIIAPPSECRETINPUT,"     ");

        common.waitUntilElementToBeVisible(WIICONNECT);
        common.click(WIICONNECT);

        common.type(WIIPHONEIDINPUT,"     ");
        common.type(WIIWABAIDINPUT,"     ");
        common.type(WIIAPPIDINPUT,"     ");

        common.assertElementPresent(phoneIDVal);
        common.assertElementPresent(wabaIDVal);
        common.assertElementPresent(appIDVal);

    }

    public void verifyIntegratingWithValidData(String phoneID,
                                               String wabaID,
                                               String token,
                                               String appID,
                                               String appSecret) {

        goToWhatsAppIntegrationPage();

        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if WhatsApp is already connected");
        common.assertElementIsNotDisplayed(WICONNECTED);

        common.logPrint("No existing WhatsApp connection found, continuing execution");

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.pause(1);

        common.assertElementIsNotDisplayedWithMessage(
                STATISTICS,
                "FAILED: As an account was already used, use a new account for this test"
        );

        common.type(WIIPHONEIDINPUT, phoneID);
        common.type(WIIWABAIDINPUT, wabaID);
        common.type(WIITOKENINPUT, token);
        common.type(WIIAPPIDINPUT, appID);
        common.type(WIIAPPSECRETINPUT, appSecret);

        common.waitUntilElementToBeVisible(WIICONNECT);
        common.click(WIICONNECT);

        common.pause(3);

        common.assertElementIsNotDisplayedWithMessage(WIEXISTS, "FAILED: WhatsApp account already connected. Use a different account.");

        common.assertElementIsNotDisplayedWithMessage(WITOKENEXPIREDMSG, "FAILED: WhatsApp token has expired.");

        common.waitUntilElementToBeVisible(WICONNECTED);
        common.logPrint("WhatsApp successfully connected");
    }

    public void verifyViewEye(){
        goToWhatsAppIntegrationPage();

        String tokenHidden = "//input[@placeholder=\"Enter Token\" and @type=\"password\"]";
        String tokenUnhide = "//input[@placeholder=\"Enter Token\" and @type=\"text\"]";
        String viewButton = "//input[@placeholder=\"Enter Token\"]/following::button[@type=\"button\"]";


        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);
        common.pause(2);

        if(common.isElementDisplayed(STATISTICS)) {

            common.waitUntilElementToBeVisible(WIEDITBTN);
            common.scroll_To_Element(WIEDITBTN);
            common.click(WIEDITBTN);

            common.waitUntilElementToBeVisible(WIITOKENINPUT);
            common.type(WIITOKENINPUT, "123213");

            common.waitUntilElementToBeVisible(viewButton);
            common.click(viewButton);

            common.waitUntilElementToBeVisible(tokenUnhide);
            common.assertElementPresent(tokenUnhide);
        }

        else{
            common.waitUntilElementToBeVisible(WIITOKENINPUT);
            common.type(WIITOKENINPUT, "123213");

            common.waitUntilElementToBeVisible(viewButton);
            common.click(viewButton);

            common.waitUntilElementToBeVisible(tokenUnhide);
            common.assertElementPresent(tokenUnhide);
        }
    }

    public void verifyUsingTheSameNumber(String phoneID,
                                         String wabaID,
                                         String token,
                                         String appID,
                                         String appSecret){
        String alreadyUsedPhoneNumber = "//span[text()='This phone id is already connected. Please use a different one.']";

        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if there's already a WhatsApp is connected...");
        common.assertElementIsNotDisplayed(WICONNECTED);

        common.logPrint("No existing WhatsApp connection found, Continuing execution...");
        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.waitUntilElementToBeVisible(WIIPHONEIDINPUT);
        common.type(WIIPHONEIDINPUT,phoneID);
        common.waitUntilElementToBeVisible(WIIWABAIDINPUT);
        common.type(WIIWABAIDINPUT,wabaID);
        common.waitUntilElementToBeVisible(WIITOKENINPUT);
        common.type(WIITOKENINPUT,token);
        common.waitUntilElementToBeVisible(WIIAPPIDINPUT);
        common.type(WIIAPPIDINPUT,appID);
        common.waitUntilElementToBeVisible(WIIAPPSECRETINPUT);
        common.type(WIIAPPSECRETINPUT,appSecret);

        common.waitUntilElementToBeVisible(WIICONNECT);
        common.click(WIICONNECT);

        common.assertElementPresent(alreadyUsedPhoneNumber);
    }

    public void verifyElementsInEditScreen(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WIDISCONNECTED);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.assertElementPresent(CONNECTEDICON);
        common.assertElementPresent(STATISTICS);
        common.assertElementPresent(WIREFRESH);
        common.assertElementPresent(WITHROUGHPUT);
        common.assertElementPresent(WICODEV);
        common.assertElementPresent(WIMSGV);
        common.assertElementPresent(WIACCOUNTV);
        common.assertElementPresent(WIQUALITYV);

        common.waitUntilElementToBeVisible(WIEDITBTN);
        common.scroll_To_Element(WIEDITBTN);
        common.click(WIEDITBTN);

        String givenPhone     = common.getAttribute(WIIPHONEIDINPUT, "value");
        String givenWABA      = common.getAttribute(WIIWABAIDINPUT, "value");
        String givenToken     = common.getAttribute(WIITOKENINPUT, "value");
        String givenAppInput  = common.getAttribute(WIIAPPIDINPUT, "value");
        String givenAppSecret = common.getAttribute(WIIAPPSECRETINPUT, "value");


        common.logPrint("givenPhone: "+givenPhone+ " givenWBA: "+givenWABA+" givenToken: "+givenToken+" givenAppInput: " +givenAppInput+" givenAppSecret: "+givenAppSecret);




    }

    public void verifyDisconnecting(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WIDISCONNECTED);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.waitUntilElementToBeVisible(WIDISCONNECTBTN);
        common.scroll_To_Element(WIDISCONNECTBTN);
        common.click(WIDISCONNECTBTN);

        common.waitUntilElementToBeVisible(WIDISCONNECTMSG);
        common.assertElementPresent(WIDISCONNECTMSG);

        common.refreshPage();
        common.waitUntilElementToBeVisible(WIDISCONNECTED);
        common.assertElementPresent(WIDISCONNECTED);

    }

    public void verifyReconnectingSameAccount(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WICONNECTED);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.waitUntilElementToBeVisible(WIEDITBTN);
        common.scroll_To_Element(WIEDITBTN);
        common.click(WIEDITBTN);

        common.waitUntilElementToBeVisible(WICONNECTBTN);
        common.click(WICONNECTBTN);

        common.pause(1);
        common.assertElementIsNotDisplayedWithMessage(WIEXISTS,"FAILED: As an account was already used, use a new account for this test");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WIUPDATEDMSG)));



        common.waitUntilElementToBeClickable(successMsg);

        common.refreshPage();

        common.waitUntilElementToBeVisible(WICONNECTED);
        common.assertElementPresent(WICONNECTED);

    }

    public void verifyRefreshButton(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WIDISCONNECTED);

        common.waitUntilElementToBeVisible(WIMENU);
        common.click(WIMENU);

        common.waitUntilElementToBeVisible(WIIHEADER);

        common.waitUntilElementToBeVisible(WIREFRESH);
        common.click(WIREFRESH);

        common.waitUntilElementToBeVisible(WIREFRESHSUCCESS);
        common.assertElementPresent(WIREFRESHSUCCESS);


    }

    public void verifyItAllowsHavingAConversationAfterConnectingWhatsApp(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WIDISCONNECTED);

        common.assertElementPresent(WICONNECTED);
        common.waitUntilElementToBeVisible(WIMENU);

        common.assertElementPresent(CONVERSATIONMENU);
        common.click(CONVERSATIONMENU);
        common.assertElementPresent(WACONVERSATIONMENU);
        common.click(WACONVERSATIONMENU);
        common.waitUntilElementToBeVisible(WACONVERSATIONHEADER);
        common.assertElementPresent(WACONVERSATIONHEADER);
        common.assertElementPresent(WACONVERSATIONINFO);
        common.assertElementPresent(WACONNECTED);



    }

    public void verifyAllowsCreatingAWhatsAppTemplateAfterConnecting(){
        goToWhatsAppIntegrationPage();
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);

        common.logPrint("Checking if an account is connected already...");
        common.assertElementIsNotDisplayed(WIDISCONNECTED);

        common.assertElementPresent(WICONNECTED);

        common.waitUntilElementToBeVisible(TEMPLATEMENU);
        common.click(TEMPLATEMENU);

        common.waitUntilElementToBeVisible(WHATSAPPTEMPLATEMENU);
        common.click(WHATSAPPTEMPLATEMENU);

        common.waitUntilElementToBeVisible(WTHEADER);
        common.assertElementPresent(WTHEADER);

        common.logPrint("It does allow creating a new whatsapp template after connecting");
    }

    public void verifyAfterDisconnectingItDoesntAllowConversationOrTemplate(){
        verifyDisconnecting();

        common.assertElementPresent(CONVERSATIONMENU);
        common.click(CONVERSATIONMENU);
        common.assertElementPresent(WACONVERSATIONMENU);
        common.click(WACONVERSATIONMENU);

        common.waitUntilElementToBeVisible(WADISCONNECTED);
        common.assertElementPresent(WADISCONNECTED);

        common.logPrint("It doesn't allow having a conversation after disconnecting\n");
        common.logPrint("Checking the WhatsApp template\n");

        common.waitUntilElementToBeVisible(TEMPLATEMENU);
        common.click(TEMPLATEMENU);

        common.waitUntilElementToBeVisible(WHATSAPPTEMPLATEMENU);
        common.click(WHATSAPPTEMPLATEMENU);

        common.waitUntilElementToBeVisible(WADISCONNECTED);
        common.assertElementPresent(WADISCONNECTED);

    }

}
