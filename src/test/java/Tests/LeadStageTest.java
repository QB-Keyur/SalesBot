package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class LeadStageTest extends BasePage {

    @Test
    public  void verifyLeadStagecolumnHeader()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.verifyLeadStagePageHeader();

    }
    @Test
    public void verifyLeadStagePageHeader()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyPageheader();


    }
    @Test
    public void ListAndGridView()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyListandGridVerw();

    }
    @Test
    public void Fieldvalidation()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyFieldvalidation();
    }

    @Test
    public void CancelAndBackButton()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.verifyBackandCancelButton();

    }

    @Test
    public void CreateLead()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyCreateLeadStage();
    }

//    @Test
//    public void viewLead() {
//        loginWithAdminUser();
//        leadStagePage.VerifyonLeadStagePage();
//        leadStagePage.verifyViewLead();
//
//    }
    @Test

    public void Searchlead()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        String lsname = leadStagePage.VerifyCreateLeadStage().toString();
        leadStagePage.VerifySearch(lsname);

    }
    @Test
    public void VerifyEditandSuccessMSG()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyEdit();
    }
    @Test
    public void VerifyUpdatePageElements()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.BackAndCancelbuttonsOnUpdatePage();


    }
    @Test

    public void VerifyDeletePopup()
    {
        loginWithAdminUser();
        leadStagePage.VerifyonLeadStagePage();
        leadStagePage.VerifyDeleteleadStage();
    }







}
