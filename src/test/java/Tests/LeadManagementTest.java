package Tests;
import Utils.BasePage;
import org.testng.annotations.Test;

public class LeadManagementTest extends BasePage {

    @Test
    public void VerifyLeadManagement() {
        common.logPrint("Step:: click on lead managment");
        loginWithAdminUser();
        lead.VerifyCreateNewLead();
    }

    @Test
    public void verifySearchDeletedLead() {
        loginWithAdminUser();
        String name = lead.VerifyCreateNewLead();
        lead.verifyDeleteLeadInSearch(name);
    }

    @Test
    public void Verify_Cancel_BACK() {

        loginWithAdminUser();
        lead.Verify_CancelAmdBackButtonOnCreateLeadPage();
    }

    @Test
    public void Verify_Header() {
        loginWithAdminUser();
        lead.Verify_LeadPageHeader();
    }

    @Test
    public void Verify_GridList() {
        loginWithAdminUser();
        lead.Verify_Grid_List_view();
    }

    @Test
    public void Edit() {
        common.logPrint("Verify edit Functinality");
        loginWithAdminUser();
        lead.VerifyEdit();
    }

    @Test
    public void VerifyFieldvalidation() {
        loginWithAdminUser();
        lead.verifyAllMandatoryValidations();
    }

}

