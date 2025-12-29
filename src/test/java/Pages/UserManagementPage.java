package Pages;

import Utils.Common;
import Utils.Locators;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void clickOnUserSubmenu(){

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

    public void verifySuccessfullyMessageForUserSuccessfullyCreated(){

        common.logPrint("Step:: Verify success message for account created successfully");
        common.assertElementPresent(userAccountCreatedSuccessfully);

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

    public void createANewRoleWithSpecificModuleAccess(String name){

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

    public void acceptTheInvitation(){

        common.switchToFrameWithName("ifmail");
        common.logPrint("Step:: Click on the accept invitation button on mail");
        common.waitUntilElementToBeClickable(acceptInvitationButton);
        common.click(acceptInvitationButton);
        common.switchToDefaultContent();

    }

    public String enterPasswordAndConfirmPassword(){

        String password = "Admin@0303";

        common.waitUntilElementToBeVisible(PASSWORDINP);
        common.type(PASSWORDINP, password);

        common.waitUntilElementToBeVisible(CONFIRMPASSWORDINP);
        common.type(CONFIRMPASSWORDINP, password);

        common.waitUntilElementToBeVisible(createPasswordBtn);
        common.click(createPasswordBtn);

        return password;
    }

    public void searchInvitationUsingAnEmail(String email){

        common.waitUntilElementToBeVisible(SEARCH);
        common.type(SEARCH, email);
    }

    public void verifyInformationAndStatusAsNotAccepted(String email){

        String emailXpath = "//div[@title=\""+email.toLowerCase()+"\"]";

        common.logPrint("Step:: Email is showing properly");
        common.assertElementPresent(emailXpath);

        common.logPrint("Step:: Status is showing as Not Accepted");
        common.assertElementPresent(notAcceptedStatusOnGrid);

        common.logPrint("Status is showing as not accepted");

    }

    public void verifyInformationAndStatusAsActiveOnUserGrid(String email){

        String emailXpath = "//div[@title=\""+email.toLowerCase()+"\"]";

        common.logPrint("Step:: Email is showing properly");
        common.assertElementPresent(emailXpath);

        common.logPrint("Step:: Status is showing as Active");
        common.assertElementPresent(activeStatus);

        common.logPrint("Status is showing as Active");
    }

    public void verifyDetailIsRemovedFromUserInvitationPage(){

        common.logPrint("Step:: No data rows validation message is showing");
        common.assertElementPresent(NoRowsValidation);

        common.logPrint("User is removed from the User invitation after request is accepted and showing on the User module");

    }

    public List<String> readExcelData(String filePath, String sheetName){

        List<String> excelData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // first column
                if (cell != null) {
                    excelData.add(cell.getStringCellValue().trim());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Excel read failed: " + e.getMessage());
        }
        return excelData;
    }

    public void verifyAllTheRolesShowingOnTheList() {

        String rolesXpath = "//td[contains(@class,'MuiTableCell-root MuiTableCell-body MuiTableCell-alignLef')]";

        //Wait for elements
        common.waitUntilElementToBeVisible(rolesXpath);

        //Get UI elements
        List<WebElement> uiElements = driver.findElements(By.xpath(rolesXpath));
        Assert.assertEquals(uiElements.size(), 22, "UI element count mismatch");

        //Get UI texts
        List<String> uiTexts = new ArrayList<>();
        for (WebElement element : uiElements) {
            uiTexts.add(element.getText().trim());
        }

        //Read Excel data
        String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
        List<String> excelTexts = readExcelData(excelPath, "RolesList");
        Assert.assertEquals(excelTexts.size(), 22, "Excel rows count mismatch");

        //Compare UI vs Excel
        for (int i = 0; i < uiTexts.size(); i++) {

            common.logPrint(
                    "Comparing Row " + (i + 1) +
                            " | UI: " + uiTexts.get(i) +
                            " | Excel: " + excelTexts.get(i)
            );

            Assert.assertEquals(
                    uiTexts.get(i),
                    excelTexts.get(i),
                    "Mismatch at row " + (i + 1)
            );
        }

        common.assertElementPresent(totalRows);

        common.logPrint("All 22 roles matched successfully with Excel data!");
    }
}


