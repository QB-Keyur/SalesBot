package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage extends Locators {

    Common common;

    public UserManagementPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void clickOnUserManagementMenu(){
        common.waitUntilElementToBeVisible(userManagementMenu);
        common.click(userManagementMenu);
    }

    public void redirectsToUserInvitationPage(){

        clickOnUserManagementMenu();

        common.waitUntilElementToBeVisible(userInvitation);
        common.click(userInvitation);
    }

    public void redirectsToUserPage(){

        clickOnUserManagementMenu();

        common.waitUntilElementToBeVisible(userSubMenu);
        common.click(userSubMenu);
    }

    public void redirectsToRoleAndPermissionPage(){

        clickOnUserManagementMenu();

        common.waitUntilElementToBeVisible(rolePermission);
        common.click(rolePermission);
    }

    public void clickOnUserInvitationMenu(){
        common.waitUntilElementToBeVisible(userInvitation);
        common.click(userInvitation);
    }

    public void verifySuccessfullyMessageForSentInvitation(){

        common.logPrint("Step:: Verify success message");
        common.assertElementPresent(invitationSentSuccessfully);

    }

    public void verifyMenuAndSubMenuAreDisplayedOnThePage(){

        common.logPrint("Step:: Verify user management menu are displayed on the menu list");
        common.assertElementPresent(userManagementMenu);

        common.logPrint("Step:: Verify User Invitation sub-menu are displayed under the User Management");
        common.assertElementPresent(userInvitation);

        common.logPrint("Step:: Verify User sub-menu are displayed under the User Management");
        common.assertElementPresent(userSubMenu);

        common.logPrint("Step:: Verify Role Permission sub-menu are displayed under the User Management");
        common.assertElementPresent(rolePermission);
    }

    public void verifyUserInvitationPageElementsAndHeader(){

        common.logPrint("Step:: Verify header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(userInvitationHeader));
        common.assertElementPresent(userInvitationHeader);

        common.logPrint("Step:: Verify 'Search' input box is displayed");
        common.waitUntilElementToBeVisible(By.xpath(searchInp));
        common.assertElementPresent(searchInp);

        common.logPrint("Step:: Verify 'Refresh' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(refreshBtn));
        common.assertElementPresent(refreshBtn);

        common.logPrint("Step:: Verify 'Filters' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(filterBtn));
        common.assertElementPresent(filterBtn);

        common.logPrint("Step:: Verify 'Create' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(createContact));
        common.assertElementPresent(createContact);

        common.logPrint("Step:: Verify Grid view button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(gridViewBtn));
        common.assertElementPresent(gridViewBtn);

        common.logPrint("Step:: Verify 'List view' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(listViewBtn));
        common.assertElementPresent(listViewBtn);

        common.logPrint("Step:: Verify 'Full Name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(firstNameHeader));
        common.assertElementPresent(firstNameHeader);

        common.logPrint("Step:: Verify 'Last Name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(LastNameHeader));
        common.assertElementPresent(LastNameHeader);

        common.logPrint("Step:: Verify 'Phone Number' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumHeader));
        common.assertElementPresent(phoneNumHeader);

        common.logPrint("Step:: Verify 'Email' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(emailHeader));
        common.assertElementPresent(emailHeader);

        common.logPrint("Step:: Verify 'Status' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(statusHeader));
        common.assertElementPresent(statusHeader);

        common.logPrint("Step:: Verify 'Token Status' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(tokenStatusHeader));
        common.assertElementPresent(tokenStatusHeader);

        common.logPrint("Step:: Verify 'Actions' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(actionsHeader));
        common.assertElementPresent(actionsHeader);

        common.logPrint("Step:: Verify Previous button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToPreviousBtn));
        common.assertElementPresent(GoToPreviousBtn);

        common.logPrint("Step:: Verify Next button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToNextBtn));
        common.assertElementPresent(GoToNextBtn);

    }


    public void verifyUserPageElementsAndHeader(){

        common.logPrint("Step:: Verify header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(userHeader));
        common.assertElementPresent(userHeader);

        common.logPrint("Step:: Verify 'Search' input box is displayed");
        common.waitUntilElementToBeVisible(By.xpath(searchInp));
        common.assertElementPresent(searchInp);

        common.logPrint("Step:: Verify 'Refresh' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(refreshBtn));
        common.assertElementPresent(refreshBtn);

        common.logPrint("Step:: Verify 'Filters' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(filterBtn));
        common.assertElementPresent(filterBtn);

        common.logPrint("Step:: Verify Grid view button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(gridViewBtn));
        common.assertElementPresent(gridViewBtn);

        common.logPrint("Step:: Verify 'List view' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(listViewBtn));
        common.assertElementPresent(listViewBtn);

        common.logPrint("Step:: Verify 'Full Name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(firstNameHeader));
        common.assertElementPresent(firstNameHeader);

        common.logPrint("Step:: Verify 'Last Name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(LastNameHeader));
        common.assertElementPresent(LastNameHeader);

        common.logPrint("Step:: Verify 'Phone Number' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(phoneNumHeader));
        common.assertElementPresent(phoneNumHeader);

        common.logPrint("Step:: Verify 'Status' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(statusHeader));
        common.assertElementPresent(statusHeader);

        common.logPrint("Step:: Verify 'Actions' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(actionsHeader));
        common.assertElementPresent(actionsHeader);

        common.logPrint("Step:: Verify Previous button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToPreviousBtn));
        common.assertElementPresent(GoToPreviousBtn);

        common.logPrint("Step:: Verify Next button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToNextBtn));
        common.assertElementPresent(GoToNextBtn);

        common.logPrint("Step:: Verify View button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(viewButton));
        common.assertElementPresent(viewButton);

        common.logPrint("Step:: Verify edit button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(editButton));
        common.assertElementPresent(editButton);

        common.logPrint("Step:: Verify Next button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(deleteButton));
        common.assertElementPresent(deleteButton);
    }

    public void verifyRoleAndPermissionPageElementsAndHeader() {

        common.logPrint("Step:: Verify header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(rolePermissionHeader));
        common.assertElementPresent(rolePermissionHeader);

        common.logPrint("Step:: Verify 'Search' input box is displayed");
        common.waitUntilElementToBeVisible(By.xpath(searchInp));
        common.assertElementPresent(searchInp);

        common.logPrint("Step:: Verify 'Filters' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(filterBtn));
        common.assertElementPresent(filterBtn);

        common.logPrint("Step:: Verify 'Create' button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(createContact));
        common.assertElementPresent(createContact);

        common.logPrint("Step:: Verify 'Role name' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(roleNameHeader));
        common.assertElementPresent(roleNameHeader);

        common.logPrint("Step:: Verify 'Actions' grid header is displayed");
        common.waitUntilElementToBeVisible(By.xpath(actionHeader));
        common.assertElementPresent(actionHeader);

        common.logPrint("Step:: Verify Previous button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToPreviousBtn));
        common.assertElementPresent(GoToPreviousBtn);

        common.logPrint("Step:: Verify Next button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(GoToNextBtn));
        common.assertElementPresent(GoToNextBtn);

        common.logPrint("Step:: Verify View button is displayed");
        common.waitUntilElementToBeVisible(By.xpath(viewButton));
        common.assertElementPresent(viewButton);
    }

    public void clickOnCreateButton(){
        common.waitUntilElementToBeVisible(By.xpath(createContact));
        common.click(createContact);
    }

    public void roleAndPermissionAddedSuccessfully(){

        common.logPrint("Success message is showing properly on the page");
        common.waitUntilElementToBeVisible(By.xpath(roleAndPermissionAddedSuccessfully));
        common.click(roleAndPermissionAddedSuccessfully);
    }

    public void duplicateRoleNameValidation(){

        common.logPrint("Verify validation message is showing for duplicate role");
        common.waitUntilElementToBeVisible(By.xpath(RoleNameIsAlreadyExist));
        common.click(RoleNameIsAlreadyExist);

    }

    public void createANewRole(String name){

        common.logPrint("Step:: Enter the role name");

        common.waitUntilElementToBeVisible(By.xpath(enterRoleName));
        common.type(enterRoleName,name);

        common.waitUntilElementToBeVisible(By.xpath(saveButton));
        common.click(saveButton);
    }

    public void verifyRoleIsShowingOnTheUserInvitationPage(String roleName){

        common.waitUntilElementToBeVisible(By.xpath(roleDropdown));
        common.click(roleDropdown);

        String nameXpath = "//*[text()='"+roleName+"']";

        common.assertElementPresent(nameXpath);
    }

    public void verifyFieldValidationMessageForUserInvitationPage(){

        common.waitUntilElementToBeVisible(saveButton);
        common.click(saveButton);

        common.logPrint("Step:: Verify error message is displayed for first name");
        common.assertElementPresent(firstNameError);

        common.logPrint("Step:: Verify error message is displayed for last name");
        common.assertElementPresent(lastNameError);

        common.logPrint("Step:: Verify error message is displayed for phone number");
        common.assertElementPresent(phoneError);

        common.logPrint("Step:: Verify error message is displayed for email");
        common.assertElementPresent(emailError);

        common.logPrint("Step:: Verify error message is displayed for role");
        common.assertElementPresent(roleError);
    }

    public void verifyFieldValidationMessageForRoleAndPermissionPage(){

        common.waitUntilElementToBeVisible(saveButton);
        common.click(saveButton);

        common.logPrint("Step:: Verify error message is displayed for Role name");
        common.assertElementPresent(RoleNameError);
    }

    public String[] createUserInvitation(){

        String name = common.fakeName();
        common.waitUntilElementToBeVisible(firstNameInp);
        common.type(firstNameInp, name);

        String lastName = common.fakeName();
        common.waitUntilElementToBeVisible(lastNameInp);
        common.type(lastNameInp, lastName);

        String mobileNum = common.fakeIndianMobileNumber();
        common.waitUntilElementToBeVisible(phoneNumInp);
        common.type(phoneNumInp, mobileNum);

        String email = name+"123@yopmail.com";
        common.waitUntilElementToBeVisible(emailInp);
        common.type(emailInp, email);

        common.logPrint("Step:: Select role from the dropdown");
        common.waitUntilElementToBeVisible(roleDropdown);
        common.click(roleDropdown);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(saveButton);
        common.click(saveButton);

        return new String[] {name, lastName, email, mobileNum};
    }

    public void verifyInvitationLinkIsShowing(String email){

        driver.get("https://yopmail.com/en/");

        common.waitUntilElementToBeVisible(emailInpYopMail);
        common.type(emailInpYopMail, email);

        common.waitUntilElementToBeVisible(enterArrowBtn);
        common.click(enterArrowBtn);

        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);
        common.pause(2);

        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);

        common.waitUntilElementToBeVisible(refreshButtonYopmail);
        common.click(refreshButtonYopmail);
        common.pause(2);

        // Already inside iframe at this point
        common.switchToFrameWithName("ifmail");
        common.logPrint("Step:: Accept invitation button is showing on the mail");
        common.isElementPresent((acceptInvitationButton));
        common.switchToDefaultContent();

        common.logPrint("Invitation is showing on the mail");
    }

}


