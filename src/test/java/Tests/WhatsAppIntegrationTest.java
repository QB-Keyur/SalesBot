package Tests;

import Config.EnvConfig;
import Utils.BasePage;
import org.testng.annotations.Test;

public class WhatsAppIntegrationTest extends BasePage {

    @Test
    public void goToWhatsAppIntegrationPage(){
        common.logPrint("START :: Verify navigation to WhatsApp Integration page");

        loginWithAdminUser();
        common.logPrint("ACTION :: Logged in as Admin user");

        whatsAppIntegrationPage.goToWhatsAppIntegrationPage();
        common.logPrint("SUCCESS :: WhatsApp Integration page loaded successfully");
    }

    @Test
    public void verifyWhatsAppIntegrationMenu(){
        common.logPrint("START :: Verify WhatsApp Integration menu visibility");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyWhatsAppIntegrationMenu();

        common.logPrint("SUCCESS :: WhatsApp Integration menu and status indicators verified");
    }

    @Test
    public void verifyElementsInsideWhatsAppIntegrationMenu(){
        common.logPrint("START :: Verify UI elements inside WhatsApp Integration menu");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyElementsInsideWhatsAppIntegrationMenu();

        common.logPrint("SUCCESS :: All expected UI elements inside WhatsApp Integration menu are present");
    }

    @Test
    public void verifyMandatoryFieldValidationInWhatsAppIntegration(){
        common.logPrint("START :: Verify mandatory field validation for WhatsApp Integration");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyMandatoryFieldValidationInWhatsAppIntegration();

        common.logPrint("SUCCESS :: Mandatory field validation messages displayed as expected");
    }

    @Test
    public void verifyIntegrationWithWhiteSpaces(){
        common.logPrint("START :: Verify WhatsApp integration with whitespace-only input");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyIntegrationWithWhiteSpaces();

        common.logPrint("SUCCESS :: Whitespace input correctly rejected during integration");
    }

    @Test
    public void verifyIntegratingWithValidData(){
        common.logPrint("START :: Verify WhatsApp integration using valid credentials");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyIntegratingWithValidData(EnvConfig.getPhoneId(),
                EnvConfig.getWabaId(),
                EnvConfig.getToken(),
                EnvConfig.getAppId(),
                EnvConfig.getAppSecret()
        );

        common.logPrint("SUCCESS :: WhatsApp account integrated successfully with valid data");
    }

    @Test
    public void verifyViewEye(){
        common.logPrint("START :: Verify view (eye) icon functionality in WhatsApp Integration");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyViewEye();

        common.logPrint("SUCCESS :: View (eye) icon reveals integration details correctly");
    }

    @Test
    public void verifyUsingTheSameNumber(){
        common.logPrint("START :: Verify validation when using an already integrated WhatsApp number");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyUsingTheSameNumber(           EnvConfig.getPhoneId(),
                EnvConfig.getWabaId(),
                EnvConfig.getToken(),
                EnvConfig.getAppId(),
                EnvConfig.getAppSecret()
        );

        common.logPrint("SUCCESS :: System correctly restricts duplicate WhatsApp number integration");
    }

    @Test
    public void verifyElementsInEditScreen(){
        common.logPrint("START :: Verify UI elements on WhatsApp Integration edit screen");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyElementsInEditScreen();

        common.logPrint("SUCCESS :: All expected elements are visible on the edit screen");
    }

    @Test
    public void verifyDisconnecting(){
        common.logPrint("START :: Verify disconnecting an existing WhatsApp integration");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyDisconnecting();

        common.logPrint("SUCCESS :: WhatsApp account disconnected successfully");
    }

    @Test
    public void verifyReconnectingSameAccount() {
        common.logPrint("START :: Verify reconnecting the same WhatsApp account");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyReconnectingSameAccount();

        common.logPrint("SUCCESS :: Same WhatsApp account reconnected without issues");
    }

    @Test
    public void verifyRefreshButton(){
        common.logPrint("START :: Verify refresh button functionality on WhatsApp Integration page");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyRefreshButton();

        common.logPrint("SUCCESS :: Refresh button updates WhatsApp Integration status correctly");
    }

    @Test
    public void verifyItAllowsHavingAConversationAfterConnectingWhatsApp(){
        common.logPrint("START :: Verify conversation is allowed after WhatsApp connection");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyItAllowsHavingAConversationAfterConnectingWhatsApp();

        common.logPrint("SUCCESS :: Conversation functionality enabled after WhatsApp connection");
    }

    @Test
    public void verifyAllowsCreatingAWhatsAppTemplateAfterConnecting(){
        common.logPrint("START :: Verify WhatsApp template creation after successful integration");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyAllowsCreatingAWhatsAppTemplateAfterConnecting();

        common.logPrint("SUCCESS :: WhatsApp template creation allowed after integration");
    }

    @Test
    public void verifyAfterDisconnectingItDoesntAllowConversationOrTemplate() {
        common.logPrint("START :: Verify restrictions after disconnecting WhatsApp integration");

        loginWithAdminUser();
        whatsAppIntegrationPage.verifyAfterDisconnectingItDoesntAllowConversationOrTemplate();

        common.logPrint("SUCCESS :: Conversation and template creation correctly blocked after disconnection");
    }


}
