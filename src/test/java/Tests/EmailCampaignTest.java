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

    @Test
    public void verifyEmailCampaignCreatePageElements(){
        loginWithAdminUser();
        emailCampaignPage.verifyEmailCampaignCreatePageElements();
    }

    @Test
    public void verifySearch(){
        loginWithAdminUser();
        emailCampaignPage.verifySearch();
    }

    @Test
    public void verifyHorizontalView(){
        loginWithAdminUser();
        emailCampaignPage.verifyHorizontalView();
    }

    @Test
    public void verifyPagination(){
        loginWithAdminUser();
        emailCampaignPage.verifyPagination();
    }

    @Test
    public void verifyRunningANewEmailCampaign(){
        loginWithAdminUser();
        emailCampaignPage.verifyRunningANewEmailCampaign();
    }


}
