package Tests;

import Pages.LeadAndSalesPipelineLeadPage;
import Pages.LeadAndSalesPipelineLeadPage.LeadPipelineRowData;
import Utils.BasePage;
import Utils.Locators;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LeadAndSalesPipelineLeadTest extends BasePage {

    private static String createdLeadName;
    private static String editedLeadName;

    @Test
    public void verifyCreateLeadPageElements() {
        common.logPrint("Verify create lead page elements");
        loginWithAdminUser();
        leadAndSalesPipelineLeadPage.verifyCreateLeadPageElements();
    }

    @Test
    public void createLeadOnLeadPipelinePage() {
        common.logPrint("Create lead on Lead & Sales Pipeline page");
        loginWithAdminUser();
        createdLeadName = leadAndSalesPipelineLeadPage.createLeadAndReturnName();
        org.testng.Assert.assertNotNull(createdLeadName, "Created lead name should not be null");
        org.testng.Assert.assertFalse(createdLeadName.trim().isEmpty(), "Created lead name should not be empty");
    }

    @Test
    public void editCreatedLeadOnLeadPipelinePage() {

        common.logPrint("Edit the created lead on Lead & Sales Pipeline page");
        loginWithAdminUser();
        leadAndSalesPipelineLeadPage.editCreatedLead();
    }

    @Test
    public void deleteCreatedLeadOnLeadPipelinePage() {
        common.logPrint("Delete the created lead on Lead & Sales Pipeline page");
        loginWithAdminUser();
        leadAndSalesPipelineLeadPage.deleteLead();
    }

    @Test
    public void verifyLeadPipelinePageElements() {
        common.logPrint("Verify Lead & Sales Pipeline Lead page elements");
        loginWithAdminUser();
        leadAndSalesPipelineLeadPage.verifyLeadPipelinePageElements();
    }

    @Test
    public void verifySearchOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify search on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null || row.getLeadName() == null || row.getLeadName().trim().isEmpty()) {
            throw new SkipException("No Lead & Sales Pipeline data available for search validation");
        }
        leadAndSalesPipelineLeadPage.verifySearchWithFirstRowData(row);
    }

    @Test
    public void verifyFiltersOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify filters on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null || row.getLeadName() == null || row.getLeadName().trim().isEmpty()) {
            throw new SkipException("No Lead & Sales Pipeline data available for filter validation");
        }
        leadAndSalesPipelineLeadPage.verifyFiltersWithFirstRowData(row);
    }

    @Test
    public void verifySortingOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify sorting on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Lead & Sales Pipeline data available for sorting validation");
        }
        leadAndSalesPipelineLeadPage.verifyLeadNameSorting();
    }

    @Test
    public void verifyViewActionOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify view action on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Lead & Sales Pipeline data available for view validation");
        }
        leadAndSalesPipelineLeadPage.verifyViewFirstRow();
    }

    @Test
    public void verifyEditActionOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify edit action on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Lead & Sales Pipeline data available for edit validation");
        }
        leadAndSalesPipelineLeadPage.verifyEditFirstRow();
    }

    @Test
    public void verifyDeleteActionOnLeadPipelinePageIfDataExists() {
        common.logPrint("Verify delete action on Lead & Sales Pipeline Lead page");
        loginWithAdminUser();
        LeadPipelineRowData row = leadAndSalesPipelineLeadPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Lead & Sales Pipeline data available for delete validation");
        }
        leadAndSalesPipelineLeadPage.verifyDeleteFirstRowDialog();
    }
}
