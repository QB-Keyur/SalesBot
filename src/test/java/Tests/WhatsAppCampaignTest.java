package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class WhatsAppCampaignTest extends BasePage {

    @Test
    public void  verifyWhatsAppCampaignPage() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppCampaignPageHeader();
        WhatsAppCPage.VerifyListAndGridView();
    }

    @Test
    public void VerifyWhatsAppContactListHeaders() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyWhatsAppContactHeaders();
    }
    @Test
    public void VerifyCreateWhatsAppCampaignView() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
     // WhatsAppCPage.VerifyCreateWhatsAppCampaignPage();
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
    @Test

    public void VerifyContactHeader()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyContactListHeaderOnCreateCampaignPage();

    }
    @Test

    public void VerifyCreateWhatsAppCampaign()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
//        WhatsAppCPage.VerifyCreateWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignWithoutSelectingContact();
    }


    @Test
    public void VerifyRunCampaignWithSelectingContactTest(){
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyRunCampaignWithSelectingContact();
    }


    @Test
    public void validateRunCampaignWithSelectedContact() {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.verifyViewCampaign();
    }

    @Test
    public void verifyElementsOnnCreateCamapignPage()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyCreateWhatsAppCampaignPageAllElements();
    }

    @Test
    public void VerifyViewCampaignPageHeaderName()
    {
        loginWithAdminUser();
        WhatsAppCPage.goToWhatsAppCampaignPage();
        WhatsAppCPage.VerifyViewWhatsAppCampaignHader();
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
