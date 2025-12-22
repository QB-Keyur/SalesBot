package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class WhatsAppCampaignTest extends BasePage {

    @Test
    public void  verifyWhatsAppcampaignpage()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppCampaignPageHeader();
        WhatsAppCPage.VerifyListAndGridView();
    }
    @Test
    public void VerifyWhatsAppContactlistHeaders()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppContactHeaders();


    }
    @Test
    public void VerifyCreateWhatsAppCampaign()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
//        WhatsAppCPage.VerifyCreateWhatsAppCampaignPage();
        WhatsAppCPage.verifyViewContactListHeader();

    }
    @Test
    public void VerifyRunCampaignPopup(){
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignPopup();

    }
    @Test
    public void verifyFieldvalidation()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyFieldValidationsMessageOnCampaignPage();


    }



}
