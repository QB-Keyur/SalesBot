package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class WhatsAppCampaignTest extends BasePage {

    @Test //Xpath updated
    public void  verifyWhatsAppCampaignPage() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppCampaignPageHeader();
        WhatsAppCPage.VerifyListAndGridView();
    }

    @Test //xpath updated
    public void VerifyWhatsAppContactListHeaders() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppContactHeaders();
    }

    @Test //xpath Updated
    public void VerifyRunCampaignPopup(){
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignPopup();

    }
    @Test //xpath Updated
    public void verifyFieldvalidation()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyFieldValidationsMessageOnCampaignPage();



    }
    @Test //xpath Updated

    public void VerifyContactHeader()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyContactListHeaderOnCreateCampaignPage();

    }
    @Test //xpath Updated

    public void VerifyCreateWhatsAppCampaign()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
//        WhatsAppCPage.VerifyCreateWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignWithoutSelectingContact();
    }


    @Test //xpath updated
    public void VerifyRunCampaignWithSelectingContactTest(){
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignWithSelectingContact();
    }


    @Test // xpath Updated
    public void validateViewRunCampaignWithSelectedContact() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.verifyViewCampaign();
    }

    @Test //xpath Updated
    public void verifyElementsOnnCreateCamapignPage()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyCreateWhatsAppCampaignPageAllElements();
    }

    @Test //xpath Updated
    public void VerifyViewCampaignPageHeaderName()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyViewWhatsAppCampaignHader();


    }

    @Test //xpath Updated
    public void VerifyViewCampaignSearch()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppCampaignSearch();
    }
    @Test
     public void VerifySearch()
    {
            loginWithAdminUser();
            WhatsAppCPage.goToWhatsAppCampaignPage();
            WhatsAppCPage.VerifyWhatsAppCampaignSearch();

    }
    @Test
    public void VerifyViewElements()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyViewpageElements();

    }

}
