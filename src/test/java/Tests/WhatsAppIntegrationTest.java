package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class WhatsAppIntegrationTest extends BasePage {

    @Test
    public void goToWhatsAppIntegrationPage(){
        loginWithAdminUser();
        whatsAppIntegrationPage.goToWhatsAppIntegrationPage();
    }

    @Test
    public void verifyWhatsAppIntegrationMenu(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyWhatsAppIntegrationMenu();
    }

    @Test
    public void verifyElementsInsideWhatsAppIntegrationMenu(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyElementsInsideWhatsAppIntegrationMenu();
    }

    @Test
    public void verifyMandatoryFieldValidationInWhatsAppIntegration(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyMandatoryFieldValidationInWhatsAppIntegration();
    }

    @Test
    public void verifyIntegrationWithWhiteSpaces(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyIntegrationWithWhiteSpaces();
    }

    @Test
    public void verifyIntegratingWithValidData(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyIntegratingWithValidData(
                "838123732714912",
                "1277026863826538",
                "EAAUyPQsl7sEBP8MR26mSB19HiRgRXjeVkTW3LAes6wtFeZAmkW0NmDyYqzOZAjmZAkMtvIAOGAi9pBQVg0VBn6YQ6TxiNiI6L6JZC4E7bEzRlSuRH4BXwxLI7R6m4WiR7kgRiCZALus95fxH4kkCJXNpCGFSZBZBbJHLQLY3ZAUJ3NtBzr7JiQHoupC3KMQVcYfsKwZDZD",
                "1462612644982465",
                "d48193b283bede22cde7bf9dd10927d8"
        );
    }

    @Test
    public void verifyViewEye(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyViewEye();
    }

    @Test
    public void verifyUsingTheSameNumber(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyUsingTheSameNumber(
                "838123732714912",
                "1277026863826538",
                "EAAUyPQsl7sEBP8MR26mSB19HiRgRXjeVkTW3LAes6wtFeZAmkW0NmDyYqzOZAjmZAkMtvIAOGAi9pBQVg0VBn6YQ6TxiNiI6L6JZC4E7bEzRlSuRH4BXwxLI7R6m4WiR7kgRiCZALus95fxH4kkCJXNpCGFSZBZBbJHLQLY3ZAUJ3NtBzr7JiQHoupC3KMQVcYfsKwZDZD",
                "1462612644982465",
                "d48193b283bede22cde7bf9dd10927d8"
        );
    }

    @Test
    public void verifyElementsInEditScreen(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyElementsInEditScreen();
    }

    @Test
    public void verifyDisconnecting(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyDisconnecting();
    }

    @Test
    public void verifyReconnectingSameAccount(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyReconnectingSameAccount();
    }

    @Test
    public void verifyRefreshButton(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyRefreshButton();
    }

    @Test
    public void verifyItAllowsHavingAConversationAfterConnectingWhatsApp(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyItAllowsHavingAConversationAfterConnectingWhatsApp();
    }

    @Test
    public void verifyAllowsCreatingAWhatsAppTemplateAfterConnecting(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyAllowsCreatingAWhatsAppTemplateAfterConnecting();
    }

    @Test
    public void verifyAfterDisconnectingItDoesntAllowConversationOrTemplate(){
        loginWithAdminUser();
        whatsAppIntegrationPage.verifyAfterDisconnectingItDoesntAllowConversationOrTemplate();
    }


}
