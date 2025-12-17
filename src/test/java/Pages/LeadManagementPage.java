package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LeadManagementPage extends Locators {

    Common common;

    public LeadManagementPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public String VerifyCreateNewLead() {

        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        String name1 = common.fakeName();
        common.waitUntilElementToBeVisible(NAME);
        common.type(NAME, name1);

        common.waitUntilElementToBeVisible(LEADNAME);
        String email = common.GenerateEmail();
        common.type(LEADNAME, email);

        common.waitUntilElementToBeVisible(TYPE);
        common.click(TYPE);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(CONTACTTYPE);
        common.click(CONTACTTYPE);
        common.downKeyAndEnter();
        common.pause(3);

        common.waitUntilElementToBeVisible(WHATSAPPCON);
        common.click(WHATSAPPCON);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(DTAETIME);
        common.selectFutureDateTimeThisWeek(DTAETIME);

        common.waitUntilElementToBeVisible(PRODUCT);
        common.click(PRODUCT);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);
        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);
//        common.pause(2);

        common.logPrint("Steps:: verify the Lead created Successfully message ");
        common.waitUntilElementToBeVisible(LEADCREATEDMSG);
        String successMSG = common.getText(LEADCREATEDMSG);
        common.logPrint("Steps:: getting message "+ successMSG);

//        common.logPrint("Step:: click on Confirm delete button"+name1);
//        common.handleAlert();
//        common.waitUntilElementToBeVisible(CONFDELETE);
//        common.click(CONFDELETE);
//
//        common.logPrint("Step:: click on Search button"+name1);
//        common.waitUntilElementToBeVisible(LEADSEARCH);
//        common.type(LEADSEARCH,name1);

        return name1;

    }
    public void verifyDeleteLeadInSearch(String name1) {

        VerifyCreateNewLead();

        common.waitUntilElementToBeVisible(LEADSEARCH);
        common.type(LEADSEARCH,name1);

        common.waitUntilElementToBeVisible(DELETEOTIN);
        common.click(DELETEOTIN);

//        common.logPrint("Step:: click on cancel button");
//        common.handleAlert();
//        common.waitUntilElementToBeVisible(CANCELDELETE);
//        common.click(CANCELDELETE);

        common.handleAlert();
        common.waitUntilElementToBeVisible(CONFDELETE);
        common.click(CONFDELETE);

        common.waitUntilElementToBeVisible(LEADCREATEDMSG);
        String successMSG = common.getText(LEADCREATEDMSG);
        common.logPrint("Steps:: getting message "+successMSG);

        common.waitUntilElementToBeVisible(LEADSEARCH);
        common.type(LEADSEARCH,name1);

        common.logPrint("Searched lead is not displayed in the grid");
        common.waitUntilElementToBeVisible(NoRows);
    }
    public void VerifyCancelAmdBackButtonOnCreateLeadPage() {
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        common.handleAlert();
        common.waitUntilElementToBeVisible(CANCELDELETE);
        common.click(CANCELDELETE);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        common.waitUntilElementToBeVisible(LEADPBack);
        common.pause(2);
        common.click(LEADPBack);

    }
    public void Verify_LeadPageHeader() {
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(LEADREFRESH);
        common.click(LEADREFRESH);

        common.logPrint("Step:: Verify Lead management Header is display ");
        common.assertElementText(LEADHEADER, "Lead Management");
    }

    public void Verify_Grid_List_view() {
        common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
        common.click(GRIDVIEWBTNL);
        common.pause(4);

        common.waitUntilElementToBeVisible(LISTVIEWBTNL);
        common.click(LISTVIEWBTNL);

        common.waitUntilElementToBeVisible(LEADREFRESH);
        common.click(LEADREFRESH);
    }

    public void VerifyEdit() {
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(LEADEDIT);
        common.click(LEADEDIT);

        common.assertElementText(LEADUPDATEHEADER, "Update Lead Management");
        common.logPrint("Steps:: Header getting displayed on page");

        common.waitUntilElementToBeVisible(LEADNAME);
        String email = common.GenerateEmail();
        common.type(LEADNAME, email);
        common.pause(5);

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);
        //   common.waitUntilElementToBeVisible(SAVE_BTN);
        //   common.click(SAVE_BTN);
    }

    public void verifyAllMandatoryValidations() {


        common.logPrint("Steps:: verify field validation on create lead page");

        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnName)), "Name validation message not displayed");
        String Error1=common.getText(ErrorOnName);
        common.logPrint("Steps::Display the validation message for name field: - "+Error1);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnEmail)), "Email validation message not displayed");
        String Error2=common.getText(ErrorOnEmail);
        common.logPrint("Steps::Display the validation message for Email field: - "+Error2);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnType)), "Type validation message not displayed");
        String Error3=common.getText(ErrorOnType);
        common.logPrint("Steps::Display the validation message for Type field: - "+Error3);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnContactType)), "Contact Type validation message not displayed");
        String Error4=common.getText(ErrorOnContactType);
        common.logPrint("Steps::Display the validation message for COntactType field: - "+Error4);

        common.pause(4);

        common.waitUntilElementToBeVisible(CONTACTTYPE);
        common.click(CONTACTTYPE);
        common.downKeyAndEnter();
        common.pause(3);

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnWhatsAppCOntact)), "Date & Time validation message not displayed");
        String Error5=common.getText(ErrorOnWhatsAppCOntact);
        common.logPrint("Steps::Display the validation message for WhatsAppCOntact field"+Error5);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnPrefrredDT)), "Product validation message not displayed");
        String Error6=common.getText(ErrorOnPrefrredDT);
        common.logPrint("Steps::Display the validation message for PrefrredDT Field"+Error6);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(ErrorOnProduct)), "Product validation message not displayed");
        String Error7=common.getText(ErrorOnProduct);
        common.logPrint("Steps::Display the validation message for Product Field"+Error7);

    }
}
