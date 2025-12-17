package Tests;
import Utils.BasePage;
import org.testng.annotations.Test;

public class LeadManagementTest extends BasePage {

    @Test
    public void verifyLeadIsCreatedSuccessfully() {
        common.logPrint("Verify lead is created successfully");
        loginWithAdminUser();
        lead.VerifyCreateNewLead();
    }

    @Test
    public void verifyDeletedLeadIsNotShowingInTheGrid() {
        common.logPrint("Verify deleted lead is not displayed in the grid");
        loginWithAdminUser();
        String name = lead.VerifyCreateNewLead();
        lead.verifyDeleteLeadInSearch(name);
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
        lead.VerifyEdit();
    }

    @Test
    public void verifyFieldValidationMessageOnCreateLeadPage() {
        common.logPrint("Verify field validations message on create lead page");
        loginWithAdminUser();
        lead.verifyAllMandatoryValidations();
    }

}

