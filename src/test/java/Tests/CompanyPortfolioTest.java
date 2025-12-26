package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

import javax.swing.*;

public class CompanyPortfolioTest extends BasePage {

    @Test
    public void goToCompanyPortfolioPage(){
        common.logPrint("TEST START :: Navigate to Company Portfolio page");
        loginWithAdminUser();
        companyPortfolioPage.goToCompanyPortfolioPage();
        common.logPrint("TEST PASS :: Company Portfolio page loaded successfully");
    }

    @Test
    public void verifyCompanyPortfolioPageElements(){
        common.logPrint("TEST START :: Verify Company Portfolio page UI elements");
        loginWithAdminUser();
        companyPortfolioPage.verifyCompanyPortfolioPageElements();
        common.logPrint("TEST PASS :: All Company Portfolio page elements verified");
    }

    @Test
    public void verifyCompanyPortfolioCreatePageElements(){
        common.logPrint("TEST START :: Verify Company Portfolio create page UI elements");
        loginWithAdminUser();
        companyPortfolioPage.verifyCompanyPortfolioCreatePageElements();
        common.logPrint("TEST PASS :: Company Portfolio create page elements verified");
    }

    @Test
    public void verifyAddingACompanyPortfolio(){
        common.logPrint("TEST START :: Verify adding a new Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.verifyAddingACompanyPortfolio();
        common.logPrint("TEST PASS :: Company Portfolio created successfully");
    }

    @Test
    public void verifyViewingACompanyPortfolio(){
        common.logPrint("TEST START :: Verify viewing an existing Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.verifyViewingACompanyPortfolio();
        common.logPrint("TEST PASS :: Company Portfolio details viewed successfully");
    }

    @Test
    public void verifyEditingACompanyPortfolio(){
        common.logPrint("TEST START :: Verify editing a Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.verifyEditingACompanyPortfolio();
        common.logPrint("TEST PASS :: Company Portfolio updated successfully");
    }

    @Test
    public void validateHorizontalCardView(){
        common.logPrint("TEST START :: Validate horizontal card view for Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.validateHorizontalCardView();
        common.logPrint("TEST PASS :: Horizontal card view validated successfully");
    }

    @Test
    public void validatePagination(){
        common.logPrint("TEST START :: Validate pagination functionality in Company Portfolio grid");
        loginWithAdminUser();
        companyPortfolioPage.validatePagination();
        common.logPrint("TEST PASS :: Pagination validated successfully");
    }

    @Test
    public void verifyDeleteACompanyPortfolio(){
        common.logPrint("TEST START :: Verify deleting a Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.verifyDeletingACompanyPortfolio();
        common.logPrint("TEST PASS :: Company Portfolio deleted successfully");
    }

    @Test
    public void verifyCreatedDate(){
        common.logPrint("TEST START :: Verify Created Date column values in Company Portfolio");
        loginWithAdminUser();
        companyPortfolioPage.verifyCreatedDate();
        common.logPrint("TEST PASS :: Created Date values validated successfully");
    }

    @Test
    public void validateSorting(){
        common.logPrint("TEST START :: Validate sorting on Company Portfolio grid (Column index: 2, Order: DESC)");
        loginWithAdminUser();
        companyPortfolioPage.goToCompanyPortfolioPage();
        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
        common.logPrint("TEST PASS :: Sorting validated successfully for Company Portfolio grid");
    }


}
