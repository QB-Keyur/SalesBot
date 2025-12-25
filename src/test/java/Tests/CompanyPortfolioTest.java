package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class CompanyPortfolioTest extends BasePage {

    @Test
    public void goToCompanyPortfolioPage(){
        loginWithAdminUser();
        companyPortfolioPage.goToCompanyPortfolioPage();
    }

    @Test
    public void verifyCompanyPortfolioPageElements(){
        loginWithAdminUser();
        companyPortfolioPage.verifyCompanyPortfolioPageElements();
    }

    @Test
    public void verifyCompanyPortfolioCreatePageElements(){
        loginWithAdminUser();
        companyPortfolioPage.verifyCompanyPortfolioCreatePageElements();
    }

    @Test
    public void verifyAddingACompanyPortfolio(){
        loginWithAdminUser();
        companyPortfolioPage.verifyAddingACompanyPortfolio();
    }

    @Test
    public void verifyViewingACompanyPortfolio(){
        loginWithAdminUser();
        companyPortfolioPage.verifyViewingACompanyPortfolio();
    }

    @Test
    public void verifyEditingACompanyPortfolio(){
        loginWithAdminUser();
        companyPortfolioPage.verifyEditingACompanyPortfolio();
    }

    @Test
    public void validateHorizontalCardView(){
        loginWithAdminUser();
        companyPortfolioPage.validateHorizontalCardView();
    }

    @Test
    public void validatePagination(){
        loginWithAdminUser();
        companyPortfolioPage.validatePagination();
    }

    @Test
    public void verifyDeleteACompanyPortfolio(){
        loginWithAdminUser();
        companyPortfolioPage.verifyDeletingACompanyPortfolio();
    }





}
