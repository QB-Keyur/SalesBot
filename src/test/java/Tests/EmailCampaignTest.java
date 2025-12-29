package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.swing.*;

public class EmailCampaignTest extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(EmailCampaignTest.class);

    @Test
    public void goToEmailCampaignPage() {
        common.logPrint("Navigating to Email Campaign page");
        loginWithAdminUser();
        emailCampaignPage.goToEmailCampaignPage();
    }

    @Test
    public void verifyEmailCampaignElements() {
        common.logPrint("Verifying Email Campaign page UI elements");
        loginWithAdminUser();
        emailCampaignPage.verifyEmailCampaignElements();
    }

    @Test
    public void verifyEmailCampaignCreatePageElements() {
        common.logPrint("Verifying Create Email Campaign page UI elements");
        loginWithAdminUser();
        emailCampaignPage.verifyEmailCampaignCreatePageElements();
    }

    @Test
    public void verifySearch() {
        common.logPrint("Verifying search functionality in Email Campaign listing");
        loginWithAdminUser();
        emailCampaignPage.verifySearch();
    }

    @Test
    public void verifyHorizontalView() {
        common.logPrint("Verifying horizontal view cards in Email Campaign");
        loginWithAdminUser();
        emailCampaignPage.verifyHorizontalView();
    }

    @Test
    public void verifyPagination() {
        common.logPrint("Verifying pagination in Email Campaign listing");
        loginWithAdminUser();
        emailCampaignPage.verifyPagination();
    }

    @Test
    public void verifyRunningANewEmailCampaign() {
        common.logPrint("Verifying running a new Email Campaign with valid data");
        loginWithAdminUser();
        emailCampaignPage.verifyRunningANewEmailCampaign();
    }

    @Test
    public void verifySearchInsideCreate() {
        common.logPrint("Verifying search functionality inside Create Email Campaign");
        loginWithAdminUser();
        emailCampaignPage.verifySearchInsideCreate();
    }

    @Test
    public void verifyPaginationInsideCreate() {
        common.logPrint("Verifying pagination inside Create Email Campaign flow");
        loginWithAdminUser();
        emailCampaignPage.verifyPaginationInsideCreate();
    }

    @Test
    public void verifyRunningABlankCampaign() {
        common.logPrint("Verifying validation when running a blank Email Campaign");
        loginWithAdminUser();
        emailCampaignPage.verifyRunningABlankCampaign();
    }

    @Test
    public void verifyPaginationInsideViewContact() {
        common.logPrint("Verifying pagination inside View Contacts modal");
        loginWithAdminUser();
        emailCampaignPage.verifyPaginationInsideViewContact();
    }

    @Test
    public void verifyCancelButton() {
        common.logPrint("Verifying Cancel button behavior in Email Campaign");
        loginWithAdminUser();
        emailCampaignPage.verifyCancelButton();
    }

    @Test
    public void viewEmailCampaign() {
        common.logPrint("Verifying Email Campaign view");
        loginWithAdminUser();
        emailCampaignPage.viewEmailCampaign();
    }

    @Test
    public void validateSorting(){
        loginWithAdminUser();
        emailCampaignPage.goToEmailCampaignPage();
        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
    }
}
