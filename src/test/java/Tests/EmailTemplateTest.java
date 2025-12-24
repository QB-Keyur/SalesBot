package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class EmailTemplateTest extends BasePage {

    @Test
    public void goToEmailTemplatePage() {
        common.logPrint("START :: Navigating to Email Template page");
        loginWithAdminUser();
        emailTemplatePage.goToEmailTemplatePage();
    }

    @Test
    public void verifyAllTheUIElements() {
        common.logPrint("START :: Verifying Email Template list page UI elements");
        loginWithAdminUser();
        emailTemplatePage.verifyAllTheUIElements();
    }

    @Test
    public void verifyAllTheCreateUIElements() {
        common.logPrint("START :: Verifying Email Template create page UI elements");
        loginWithAdminUser();
        emailTemplatePage.verifyAllTheCreateUIElements();
    }

    @Test
    public void verifyMandatoryFields() {
        common.logPrint("START :: Verifying mandatory field validations on Email Template create page");
        loginWithAdminUser();
        emailTemplatePage.verifyMandatoryFields();
    }

    @Test
    public void verifyCancelButton() {
        common.logPrint("START :: Verifying Cancel button behavior on Email Template create page");
        loginWithAdminUser();
        emailTemplatePage.verifyCancelButton();
    }

    @Test
    public void verifyAddingANewEmailTemplate() {
        common.logPrint("START :: Verifying creation of a new Email Template");
        loginWithAdminUser();
        emailTemplatePage.verifyAddingANewEmailTemplate();
    }

    @Test
    public void verifyingHorizontalView() {
        common.logPrint("START :: Verifying Email Template horizontal view");
        loginWithAdminUser();
        emailTemplatePage.verifyingHorizontalView();
    }

    @Test
    public void verifyingSearch() {
        common.logPrint("START :: Verifying search functionality on Email Template page");
        loginWithAdminUser();
        emailTemplatePage.verifyingSearch();
    }

    @Test
    public void verifyPagination() {
        common.logPrint("START :: Verifying pagination on Email Template page");
        loginWithAdminUser();
        emailTemplatePage.verifyPagination();
    }

    @Test
    public void verifyAddingVariables() {
        common.logPrint("START :: Verifying variable insertion in Email Template body");
        loginWithAdminUser();
        emailTemplatePage.verifyAddingVariables();
    }

    @Test
    public void verifyEmailTemplateReflectionInEmailCampaign() {
        common.logPrint("START :: Verifying Email Template reflection in Email Campaign module");
        loginWithAdminUser();
        emailTemplatePage.verifyEmailTemplateReflectionInEmailCampaign();
    }

    @Test
    public void verifyRefreshButtonUpdatesTheServerSyncStatus() {
        common.logPrint("START :: Verifying Refresh button updates server sync status");
        loginWithAdminUser();
        emailTemplatePage.verifyRefreshButtonUpdatesTheServerSyncStatus();
    }

    @Test
    public void verifyViewButton() {
        common.logPrint("START :: Verifying View button displays correct Email Template details");
        loginWithAdminUser();
        emailTemplatePage.verifyViewButton();
    }

}
