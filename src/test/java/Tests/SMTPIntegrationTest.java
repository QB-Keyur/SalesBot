package Tests;

import Config.EnvConfig;
import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SMTPIntegrationTest extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(SMTPIntegrationTest.class);
    @Test
    public void goToSMTPIntegrationPage(){
        common.logPrint("TEST STARTED : Navigate to SMTP Integration page");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.goToSMTPIntegrationPage();
        common.logPrint("Successfully navigated to SMTP Integration page");
    }

    @Test
    public void verifySMTPIntegrationUIElements(){
        common.logPrint("TEST STARTED : Verify SMTP Integration page UI elements");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifySMTPIntegrationUIElements();
        common.logPrint("Verified all SMTP Integration page UI elements");
    }

    @Test
    public void verifySMTPCreateElements(){
        common.logPrint("TEST STARTED : Verify SMTP Create page UI elements");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifySMTPCreateElements();
        common.logPrint("Verified all SMTP Create page UI elements");
    }

    @Test
    public void verifySMTPMandatoryFields(){
        common.logPrint("TEST STARTED : Verify SMTP mandatory field validations");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifySMTPMandatoryFields();
        common.logPrint("Mandatory field validation messages verified successfully");
    }

    @Test
    public void verifyIntegrationWithWhiteSpace(){
        common.logPrint("TEST STARTED : Verify SMTP integration with whitespace input");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyIntegrationWithWhiteSpace();
        common.logPrint("Whitespace validation for SMTP integration verified");
    }

    @Test
    public void verifyViewEye(){
        common.logPrint("TEST STARTED : Verify SMTP password visibility (eye icon)");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyViewEye();
        common.logPrint("SMTP password visibility toggle verified successfully");
    }

    @Test
    public void verifyDoesntAllowHavingConversationWhenNotConnected(){
        common.logPrint("TEST STARTED : Verify conversation is blocked when SMTP is not connected");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyDoesntAllowHavingConversationWhenNotConnected();
        common.logPrint("Conversation correctly blocked when SMTP is disconnected");
    }

    @Test
    public void verifyDoesntAllowCreatingTemplateWhenNotConnected(){
        common.logPrint("TEST STARTED : Verify template creation is blocked when SMTP is not connected");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyDoesntAllowCreatingTemplateWhenNotConnected();
        common.logPrint("Template creation correctly blocked when SMTP is disconnected");
    }

    @Test
    public void verifyIntegratingWithValidData(){
        common.logPrint("TEST STARTED : Verify SMTP integration with valid data");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyIntegratingWithValidData(
                "Keyur",
                EnvConfig.getSMTPProvider(),
                EnvConfig.getSMTPEmail(),
                EnvConfig.getSMTPPassword(),
                EnvConfig.getSMTPPort()
        );

        common.logPrint("SMTP integration completed successfully with valid data");
    }

    @Test
    public void verifyAllowsHavingConversationAfterConnecting(){
        common.logPrint("TEST STARTED : Verify conversation is allowed after SMTP connection");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyAllowsHavingConversationAfterConnecting();
        common.logPrint("Conversation allowed successfully after SMTP connection");
    }

    @Test
    public void verifyAllowsCreatingTemplateWhenNotConnected(){
        common.logPrint("TEST STARTED : Verify template creation is allowed after SMTP connection");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyAllowsCreatingTemplateAfterConnected();
        common.logPrint("Template creation allowed successfully after SMTP connection");
    }

    @Test
    public void verifyDisconnecting(){
        common.logPrint("TEST STARTED : Verify SMTP disconnect functionality");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyDisconnecting();
        common.logPrint("SMTP disconnected successfully and state verified");
    }

    @Test
    public void verifyIntegrationSteps(){
        common.logPrint("TEST STARTED : Verify SMTP integration instruction steps");
        loginWithAdminUser();
        common.logPrint("Logged in as Admin user");

        smtpIntegrationPage.verifyIntegrationSteps();
        common.logPrint("All SMTP integration instruction steps verified successfully");
    }

}
