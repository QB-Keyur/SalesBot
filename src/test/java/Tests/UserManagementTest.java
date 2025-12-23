package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class UserManagementTest extends BasePage {

    @Test
    public void verifyUserManagementMenuAndSubMenuAreDisplayed(){
        common.logPrint("Verify User management menu and sub-menu are displayed");
        loginWithAdminUser();
        userManagementPage.clickOnUserManagementMenu();
        userManagementPage.verifyMenuAndSubMenuAreDisplayedOnThePage();
    }

    @Test
    public void verifyUserInvitationPageElements(){
        common.logPrint("Verify User Invitation page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToUserInvitationPage();
        userManagementPage.verifyUserInvitationPageElementsAndHeader();
    }

    @Test
    public void verifyUserPageElements(){
        common.logPrint("Verify User page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToUserPage();
        userManagementPage.verifyUserPageElementsAndHeader();
    }

    @Test
    public void verifyRolePermissionPageElements(){
        common.logPrint("Verify Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.verifyRoleAndPermissionPageElementsAndHeader();
    }









}