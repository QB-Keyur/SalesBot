package Tests;

import Pages.PreSalesPage.PreSalesRowData;
import Utils.BasePage;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class PreSalesTest extends BasePage {

    @Test
    public void verifyPreSalesPageElements() {
        common.logPrint("Verify Pre-Sales page elements");
        loginWithAdminUser();
        preSalesPage.verifyPreSalesPageElements();
    }

    @Test
    public void verifySearchOnPreSalesPageIfDataExists() {
        common.logPrint("Verify search on Pre-Sales page using first row data");
        loginWithAdminUser();
        PreSalesRowData row = preSalesPage.getFirstRowData();
        if (row == null || row.getContactName() == null || row.getContactName().trim().isEmpty()) {
            throw new SkipException("No Pre-Sales data available for search validation");
        }
        preSalesPage.verifySearchWithFirstRowData(row);
    }

    @Test
    public void verifyFiltersOnPreSalesPageIfDataExists() {
        common.logPrint("Verify filters on Pre-Sales page using first row data");
        loginWithAdminUser();
        PreSalesRowData row = preSalesPage.getFirstRowData();
        if (row == null || row.getContactName() == null || row.getContactName().trim().isEmpty()) {
            throw new SkipException("No Pre-Sales data available for filter validation");
        }
        preSalesPage.verifyFiltersWithFirstRowData(row);
    }

    @Test
    public void verifySortingOnPreSalesPageIfDataExists() {
        common.logPrint("Verify sorting on Pre-Sales page");
        loginWithAdminUser();
        PreSalesRowData row = preSalesPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Pre-Sales data available for sorting validation");
        }
        preSalesPage.verifyContactNameSorting();
    }

    @Test
    public void verifyViewActionOnPreSalesPageIfDataExists() {
        common.logPrint("Verify view action on Pre-Sales page");
        loginWithAdminUser();
        PreSalesRowData row = preSalesPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Pre-Sales data available for view validation");
        }
        preSalesPage.verifyViewFirstRow();
    }

    @Test
    public void verifyDeleteActionOnPreSalesPageIfDataExists() {
        common.logPrint("Verify delete action on Pre-Sales page");
        loginWithAdminUser();
        PreSalesRowData row = preSalesPage.getFirstRowData();
        if (row == null) {
            throw new SkipException("No Pre-Sales data available for delete validation");
        }
        preSalesPage.verifyDeleteFirstRow();
    }
}
