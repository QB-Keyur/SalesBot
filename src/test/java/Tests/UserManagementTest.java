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

    @Test
    public void verifyRoleAndPermissionIsCreatedSuccessfully(){
        common.logPrint("Verify Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        String roleName = common.generateRandomChars(5);
        userManagementPage.createANewRole(roleName);
        userManagementPage.roleAndPermissionAddedSuccessfully();
    }

    @Test
    public void verifyCreateRoleIsShowingOnThe(){
        common.logPrint("Verify Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        String roleName = common.generateRandomChars(5);
        userManagementPage.createANewRole(roleName);
        userManagementPage.roleAndPermissionAddedSuccessfully();
        userManagementPage.clickOnUserInvitationMenu();
        userManagementPage.clickOnCreateButton();
        userManagementPage.verifyRoleIsShowingOnTheUserInvitationPage(roleName);
    }

    @Test
    public void verifyFieldValidationMessageForUserInvitationPage(){
        common.logPrint("Verify Error message for User invitation page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToUserInvitationPage();
        userManagementPage.clickOnCreateButton();
        userManagementPage.verifyFieldValidationMessageForUserInvitationPage();
    }

    @Test
    public void verifyFieldValidationMessageForRoleAndPermissionPage(){
        common.logPrint("Verify Error message for Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        userManagementPage.verifyFieldValidationMessageForRoleAndPermissionPage();
    }

    @Test
    public void verifyValidationMessageForSameRoleName(){
        common.logPrint("Verify Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        String roleName = common.generateRandomChars(5);
        userManagementPage.createANewRole(roleName);
        userManagementPage.roleAndPermissionAddedSuccessfully();
        userManagementPage.clickOnCreateButton();
        userManagementPage.createANewRole(roleName);
        userManagementPage.duplicateRoleNameValidation();
    }

    @Test
    public String verifySentInvitationFunctionalityIsWorking(){
        common.logPrint("Verify sent invitation functionality is working");
        loginWithAdminUser();
        userManagementPage.redirectsToUserInvitationPage();
        userManagementPage.clickOnCreateButton();
        String userInfo[] = userManagementPage.createUserInvitation();
        String email = userInfo[2];
        userManagementPage.verifySuccessfullyMessageForSentInvitation();

        return email;
    }

    @Test
    public void verifySentInvitationIsShowingInMail(){
        common.logPrint("Verify Accept Invitation mail is showing in the inbox");
        String email = verifySentInvitationFunctionalityIsWorking();
        common.openNewWindow();
        userManagementPage.verifyInvitationLinkIsShowing(email);
    }

    @Test
    public String verifyLoginWithNewUserAfterInvitationIsAccept(){
        common.logPrint("Verify login with newly added user flow is working");
        String email = verifySentInvitationFunctionalityIsWorking();
        common.openNewWindow();
        userManagementPage.verifyInvitationLinkIsShowing(email);
        userManagementPage.acceptTheInvitation();
        common.switchToWindowByIndex(3);
        String password = userManagementPage.enterPasswordAndConfirmPassword();
        userManagementPage.verifySuccessfullyMessageForUserSuccessfullyCreated();

        return email;
    }

    @Test
    public void verifySentInvitationShowingInTheUserInvitationAndStatusShowingAsNotAccepted(){
        common.logPrint("Verify sent Invitation is showing in the user invitation grid");
        String email = verifySentInvitationFunctionalityIsWorking();
        common.openNewWindow();
        userManagementPage.verifyInvitationLinkIsShowing(email);
        common.switchToWindowByIndex(1);
        userManagementPage.searchInvitationUsingAnEmail(email.toLowerCase());
        common.pause(2);
        userManagementPage.verifyInformationAndStatusAsNotAccepted(email.toLowerCase());
    }

    @Test
    public String verifyAfterAcceptingTheInvitationItShowingInTheUserGridAsActiveStatus(){
        String email = verifyLoginWithNewUserAfterInvitationIsAccept();
        common.switchToWindowByIndex(1);
        userManagementPage.clickOnUserSubmenu();
        userManagementPage.searchInvitationUsingAnEmail(email.toLowerCase());
        common.pause(2);
        userManagementPage.verifyInformationAndStatusAsActiveOnUserGrid(email);

        return email;
    }

    @Test
    public void verifyDetailIsRemoveFromUserInvitationAfterAcceptAndShowingInTheUsersGrid(){
        String email = verifyAfterAcceptingTheInvitationItShowingInTheUserGridAsActiveStatus();
        userManagementPage.clickOnUserInvitationMenu();
        userManagementPage.searchInvitationUsingAnEmail(email.toLowerCase());
        userManagementPage.verifyDetailIsRemovedFromUserInvitationPage();
    }

    @Test
    public void verifyAllTheRolesAreShowingOnTheRoleAndPermissionPage(){
        common.logPrint("Verify all the roles are showing on the page.");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        userManagementPage.verifyAllTheRolesShowingOnTheList();
    }

    @Test
    public void createRolePermissionWithSpecificModuleAccess(){
        common.logPrint("Verify Role permission page elements");
        loginWithAdminUser();
        userManagementPage.redirectsToRoleAndPermissionPage();
        userManagementPage.clickOnCreateButton();
        String roleName = common.generateRandomChars(5);
        userManagementPage.createANewRoleWithSpecificModuleAccess(roleName);
        userManagementPage.roleAndPermissionAddedSuccessfully();
    }


}