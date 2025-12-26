package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.swing.*;

public class CompanyManagementTest extends BasePage {


    private static final Logger log = LoggerFactory.getLogger(CompanyManagementTest.class);
    @Test
    public void goToCompanyManagementPage(){
        common.logPrint("Navigating to Company Management page");
        loginWithAdminUser();
        companyManagementPage.goToCompanyManagementPage();
    }

    @Test
    public void verifyAddingAValidCompanyManagement(){
        common.logPrint("Verifying adding a valid Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyAddingAValidCompanyManagement();
    }

    @Test
    public void verifyCompanyManagementElements(){
        common.logPrint("Verifying Company Management page UI elements");
        loginWithAdminUser();
        companyManagementPage.verifyCompanyManagementElements();
    }

    @Test
    public void verifyCompanyManagementCreatePageElements(){
        common.logPrint("Verifying Company Management create page UI elements");
        loginWithAdminUser();
        companyManagementPage.verifyCompanyManagementCreatePageElements();
    }

    @Test
    public void verifyCompanyManagementEditPageElements(){
        common.logPrint("Verifying Company Management edit page UI elements");
        loginWithAdminUser();
        companyManagementPage.verifyCompanyManagementEditPageElements();
    }

    @Test
    public void verifyCompanyManagementViewElements(){
        common.logPrint("Verifying Company Management view page UI elements");
        loginWithAdminUser();
        companyManagementPage.verifyCompanyManagementViewElements();
    }

    @Test
    public void verifyMandatoryFields(){
        common.logPrint("Verifying mandatory fields in Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyMandatoryFields();
    }

    @Test
    public void verifyAddingABlankCompanyManagement(){
        common.logPrint("Verifying adding Company Management with blank fields");
        loginWithAdminUser();
        companyManagementPage.verifyAddingABlankCompanyManagement();
    }



    @Test
    public void verifyViewingCompanyManagement(){
        common.logPrint("Verifying viewing Company Management details");
        loginWithAdminUser();
        companyManagementPage.verifyViewingCompanyManagement();
    }

    @Test
    public void verifyCancelButtonInsideView(){
        common.logPrint("Verifying cancel button inside Company Management view page");
        loginWithAdminUser();
        companyManagementPage.verifyCancelButtonInsideView();
    }

    @Test
    public void verifyEditingACompanyManagement(){
        common.logPrint("Verifying editing Company Management details");
        loginWithAdminUser();
        companyManagementPage.verifyEditingACompanyManagement();
    }

    @Test
    public void verifyCancelButtonInsideEdit(){
        common.logPrint("Verifying cancel button inside Company Management edit page");
        loginWithAdminUser();
        companyManagementPage.verifyCancelButtonInsideEdit();
    }

    @Test
    public void verifyAddingADuplicateCompanyManagement(){
        common.logPrint("Verifying adding duplicate Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyAddingADuplicateCompanyManagement();
    }

    @Test
    public void verifyResetButtonInEdit(){
        common.logPrint("Verifying reset button in Company Management edit page");
        loginWithAdminUser();
        companyManagementPage.verifyResetButtonInEdit();
    }

    @Test
    public void verifyDeleteButtonFunctionality(){
        common.logPrint("Verifying delete button functionality in Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyDeleteButtonFunctionality();
    }

    @Test
    public void verifyHorizontalCardView(){
        common.logPrint("Verifying horizontal card view in Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyHorizontalCardView();
    }

    @Test
    public void verifyPagination(){
        common.logPrint("Verifying pagination in Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyPagination();
    }

    @Test
    public void verifyCurrentDate(){
        common.logPrint("Verifying created date is current date in Company Management");
        loginWithAdminUser();
        companyManagementPage.verifyCreatedDate();
    }

    @Test
    public void validateSorting(){
        loginWithAdminUser();
        companyManagementPage.goToCompanyManagementPage();
        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
    }






















}
