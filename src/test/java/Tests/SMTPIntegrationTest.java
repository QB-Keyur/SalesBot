package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class SMTPIntegrationTest extends BasePage {

    @Test
    public void SMTPIntegrationTest(){
        loginWithAdminUser();
        smtpIntegrationPage.goToSMTPIntegrationPage();
    }


}
