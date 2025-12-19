package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class EmailTemplateTest extends BasePage {

    @Test
    public void goToEmailTemplatePage(){
        loginWithAdminUser();
        emailTemplatePage.goToEmailTemplatePage();
    }

    @Test
    public void verifyAllTheUIElements(){
        loginWithAdminUser();
        emailTemplatePage.verifyAllTheUIElements();
    }

    @Test
    public void verifyAllTheCreateUIElements(){
        loginWithAdminUser();
        emailTemplatePage.verifyAllTheCreateUIElements();
    }


}
