package Tests;

import Pages.LeadAndSalesPipelineOpportunityPage.OpportunityRowData;
import Utils.BasePage;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LeadAndSalesPipelineOpportunityTest extends BasePage {

    @Test
    public void verifyOpportunityPageElements() {
        common.logPrint("Verify Lead & Sales Pipeline Opportunity page elements");
        loginWithAdminUser();
        leadAndSalesPipelineOpportunityPage.verifyOpportunityPageElements();
    }

    @Test
    public void verifyCreateOpportunityPageElements() {
        common.logPrint("Verify create Opportunity page elements");
        loginWithAdminUser();
        leadAndSalesPipelineOpportunityPage.verifyCreateOpportunityPageElements();
    }

    @Test
    public void createOpportunityOnLeadAndSalesPipelinePage() {
        common.logPrint("Create opportunity on Lead & Sales Pipeline page");
        loginWithAdminUser();
        String createdOpportunityName = leadAndSalesPipelineOpportunityPage.createOpportunityAndReturnName();
        org.testng.Assert.assertNotNull(createdOpportunityName, "Created opportunity name should not be null");
        org.testng.Assert.assertFalse(createdOpportunityName.trim().isEmpty(), "Created opportunity name should not be empty");
    }

    @Test
    public void editCreatedOpportunityOnLeadAndSalesPipelinePage() {
        common.logPrint("Edit the created opportunity on Lead & Sales Pipeline page");
        loginWithAdminUser();
        leadAndSalesPipelineOpportunityPage.updateCreatedOpportunity();
    }

    @Test
    public void deleteCreatedOpportunityOnLeadAndSalesPipelinePage() {
        common.logPrint("Delete the created opportunity on Lead & Sales Pipeline page");
        loginWithAdminUser();
        leadAndSalesPipelineOpportunityPage.deleteCreatedOpportunity();
    }

    @Test
    public void verifySearchOnOpportunityPageIfDataExists() {
        common.logPrint("Verify search on Lead & Sales Pipeline Opportunity page");
        loginWithAdminUser();
        OpportunityRowData row = leadAndSalesPipelineOpportunityPage.getFirstRowData();
        if (row == null || row.getOpportunityName() == null || row.getOpportunityName().trim().isEmpty()) {
            throw new SkipException("No Opportunity data available for search validation");
        }
        leadAndSalesPipelineOpportunityPage.verifySearchOnOpportunityPageIfDataExists();
    }

    @Test
    public void verifySortingOnOpportunityPageIfDataExists() {
        common.logPrint("Verify sorting on Lead & Sales Pipeline Opportunity page");
        loginWithAdminUser();
        OpportunityRowData row = leadAndSalesPipelineOpportunityPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Opportunity data available for sorting validation");
        }
        leadAndSalesPipelineOpportunityPage.verifySortingOnOpportunityPageIfDataExists();
    }

    @Test
    public void verifyPaginationOnOpportunityPageIfDataExists() {
        common.logPrint("Verify pagination on Lead & Sales Pipeline Opportunity page");
        loginWithAdminUser();
        leadAndSalesPipelineOpportunityPage.verifyPaginationOnOpportunityPageIfDataExists();
    }
}
