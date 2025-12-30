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
        loginWithAdminUser();
        smtpIntegrationPage.goToSMTPIntegrationPage();
    }
    @Test
    public void verifySMTPIntegrationUIElements(){
        loginWithAdminUser();
        smtpIntegrationPage.verifySMTPIntegrationUIElements();
    }

    @Test
    public void verifySMTPCreateElements(){
        loginWithAdminUser();
        smtpIntegrationPage.verifySMTPCreateElements();
    }

    @Test
    public void verifySMTPMandatoryFields(){
        loginWithAdminUser();
        smtpIntegrationPage.verifySMTPMandatoryFields();
    }

    @Test
    public void verifyIntegrationWithWhiteSpace(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyIntegrationWithWhiteSpace();
    }

    @Test
    public void verifyIntegratingWithValidData(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyIntegratingWithValidData("Keyur",EnvConfig.getSMTPProvider(), EnvConfig.getSMTPEmail(), EnvConfig.getSMTPPassword(), EnvConfig.getSMTPPort());
    }

    @Test
    public void verifyViewEye(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyViewEye();
    }

    @Test
    public void verifyDoesntAllowHavingConversationWhenNotConnected(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyDoesntAllowHavingConversationWhenNotConnected();
    }

    @Test
    public void verifyDoesntAllowCreatingTemplateWhenNotConnected(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyDoesntAllowCreatingTemplateWhenNotConnected();
    }

    @Test
    public void verifyAllowsHavingConversationAfterConnecting(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyAllowsHavingConversationAfterConnecting();
    }

    @Test
    public void verifyAllowsCreatingTemplateWhenNotConnected(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyAllowsCreatingTemplateAfterConnected();
    }

    @Test
    public void verifyDisconnecting(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyDisconnecting();
    }

    @Test
    public void verifyIntegrationSteps(){
        loginWithAdminUser();
        smtpIntegrationPage.verifyIntegrationSteps();
    }



}
