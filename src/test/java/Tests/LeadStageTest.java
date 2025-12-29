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




}
