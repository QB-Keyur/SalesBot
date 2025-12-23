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
}


