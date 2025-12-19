package Tests;
import Utils.BasePage;
import org.testng.annotations.Test;

public class LeadManagementTest extends BasePage {

    @Test
    public void verifyLeadIsCreatedSuccessfully() {
        loginWithAdminUser();
        lead.VerifyCreateNewLead();
    }


    @Test
    public void VerifycreateLeadSearch() {

        loginWithAdminUser();
        String CLead = lead.VerifyCreateNewLeadandreturnname().toString();
        lead.VerifyCreateLeadAndSearch(CLead);
    }
    @Test
    public void verifyDeletedLeadIsNotShowingInTheGrid()   {
        loginWithAdminUser();
        String DLead = lead.VerifyCreateNewLeadandreturnname().toString();
        lead.verifyDeleteLeadInSearch(DLead);
    }

    @Test
    public void verifyCancelAndBackButtonFunctionalityOnCreateLeadPage() {
        common.logPrint("Verify cancel and back button functionality on lead management page");
        loginWithAdminUser();
        lead.VerifyCancelAmdBackButtonOnCreateLeadPage();
    }

    @Test
    public void verifyLeadManagementHeaderIsShowing() {
        common.logPrint("Verify Lead management header is showing on the page");
        loginWithAdminUser();
        lead.Verify_LeadPageHeader();
    }

    @Test
    public void verifyGridListViewOnLeadManagementPage() {
        common.logPrint("Verify Grid list view on lead management page");
        loginWithAdminUser();
        lead.Verify_Grid_List_view();
    }

    @Test
    public void verifyEditFunctionalityOnLeadManagementPage() {

        common.logPrint("Verify Edit Functionality on Lead Management page");
        loginWithAdminUser();
        lead.VerifyUpdateLead();
    }

    @Test
    public void verifyFieldValidationMessageOnCreateLeadPage() {
        common.logPrint("Verify field validations message on create lead page");
        loginWithAdminUser();
        lead.verifyAllMandatoryFieldValidations();
    }
    @Test
    public void verifyHeaderNamesOfCreatedLead(){
        loginWithAdminUser();
        lead.VerifyHeadesForCreatedLead();
    }

    @Test
    public void verifyLeadView(){
        loginWithAdminUser();
        lead.verifyViewLead();
    }


}

