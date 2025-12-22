package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class EmailCampaignTest extends BasePage {


    @Test
    public void goToEmailCampaignPage(){
        loginWithAdminUser();
        emailCampaignPage.goToEmailCampaignPage();
    }

    @Test
    public void verifyEmailCampaignElements(){
        loginWithAdminUser();
        emailCampaignPage.verifyEmailCampaignElements();
    }
}
