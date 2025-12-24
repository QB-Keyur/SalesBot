package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;


public class LeadManagementPage extends Locators {
    Common common;

    public LeadManagementPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public Map<String, String> VerifyCreateNewLead() {

        Map<String, String> expectedData = new HashMap<>();

        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);
        common.pause(2);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        String name1 = common.fakeName();
        common.waitUntilElementToBeVisible(NAME);
        common.type(NAME, name1);
        expectedData.put("Name", name1);

        common.waitUntilElementToBeVisible(LEADNAME);
        String email = common.GenerateEmail();
        common.type(LEADNAME, email);

        common.waitUntilElementToBeVisible(TYPE);
        common.click(TYPE);
        common.downKeyAndEnter();
        String type=common.getText(TYPE);
        expectedData.put("Type", type);


        common.waitUntilElementToBeVisible(CONTACTTYPE);
        common.click(CONTACTTYPE);
        common.downKeyAndEnter();
        String CoType= common.getText(CONTACTTYPE);
        expectedData.put("ContactType", CoType);
        common.pause(3);

        common.waitUntilElementToBeVisible(WHATSAPPCON);
        common.click(WHATSAPPCON);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(DTAETIME);
        common.selectFutureDateTimeThisWeek(DTAETIME);
        String DandT= common.getText(DTAETIME);
        expectedData.put("DateTime", DandT);

        common.waitUntilElementToBeVisible(PRODUCT);
        common.click(PRODUCT);
        common.downKeyAndEnter();
        String Pro= common.getText(PRODUCT);
        expectedData.put("Product", Pro);

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);
        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);

        common.logPrint("Steps:: verify the Lead created Successfully message ");
        common.waitUntilElementToBeVisible(LEADCREATEDMSG);
        common.pause(1);
        String successMSG = common.getText(LEADCREATEDMSG);
        common.logPrint("Steps:: getting message "+ successMSG);
        common.pause(2);
        return expectedData;

    }
    public String VerifyCreateNewLeadandreturnname() {

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

        common.waitUntilElementToBeVisible(LEADCREATEDMSG);
        common.logPrint("Lead created successfully");


        return name1;
    }

    public String  VerifyCreateLeadAndSearch(String nam)
    {
        common.logPrint("Step:: click on Search button"+nam);
        common.waitUntilElementToBeVisible(LEADSEARCH);
        common.type(LEADSEARCH,nam);
        return nam;
    }

    public Map<String, String> getLeadDetailsAfterSave() {
        Map<String, String> actualData = new HashMap<>();
        actualData.put("Type", common.getText(VType));
        actualData.put("ContactType", common.getText(VContactType));
        actualData.put("DateTime", common.getText(VPreDT));
        actualData.put("Product", common.getText(VPoduct));
        return actualData;
    }
    public void verifyViewLead() {
        Map<String, String> expected = VerifyCreateNewLead();
        common.waitUntilElementToBeVisible(LEADVIEW);
        common.click(LEADVIEW);

        Map<String, String> actual = getLeadDetailsAfterSave();
        Assert.assertEquals(actual.get("Type"), expected.get("Type"), "Type mismatch");
        Assert.assertEquals(actual.get("ContactType"), expected.get("ContactType"), "Contact Type mismatch");
        Assert.assertEquals(actual.get("DateTime"), expected.get("DateTime"), "Date & Time mismatch");
        Assert.assertEquals(actual.get("Product"), expected.get("Product"), "Product mismatch");
        common.waitUntilElementToBeVisible(VClose);
        common.click(VClose);
    }

    public void verifyDeleteLeadInSearch(String name1) {
        common.waitUntilElementToBeVisible(DELETEOTIN);
        common.click(DELETEOTIN);
        common.pause(2);

        common.handleAlert();
        common.waitUntilElementToBeVisible(CANCELDELETE);
        common.click(CANCELDELETE);
        common.pause(2);

        common.waitUntilElementToBeVisible(DELETEOTIN);
        common.click(DELETEOTIN);
        common.pause(2);

        common.handleAlert();
        common.waitUntilElementToBeVisible(CONFDELETE);
        common.click(CONFDELETE);

        common.waitUntilElementToBeVisible(LEADDELETED);
        String successMSG = common.getText(LEADDELETED);
        common.logPrint("Steps:: getting message "+successMSG);
        common.pause(3);

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
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
        common.click(GRIDVIEWBTNL);
        common.pause(4);

        common.waitUntilElementToBeVisible(LISTVIEWBTNL);
        common.click(LISTVIEWBTNL);

        common.waitUntilElementToBeVisible(LEADREFRESH);
        common.click(LEADREFRESH);
    }

    public void VerifyUpdateLead() {
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

        common.waitUntilElementToBeVisible(LEADRESET);
        common.click(LEADRESET);


        common.waitUntilElementToBeVisible(LEADNAME);
        String email1 = common.GenerateEmail();
        common.type(LEADNAME, email1);
        common.pause(5);

        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);

        common.waitUntilElementToBeVisible(LEADEDIT);
        common.click(LEADEDIT);

        common.waitUntilElementToBeVisible(LEADPBack);
        common.pause(2);
        common.click(LEADPBack);

        common.waitUntilElementToBeVisible(LEADEDIT);
        common.click(LEADEDIT);

        common.handleAlert();
        common.waitUntilElementToBeVisible(CANCELDELETE);
        common.click(CANCELDELETE);





    }
    public void verifyAllMandatoryFieldValidations() {
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
    public void VerifyHeadesForCreatedLead() {
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_NAME)), "Header not displayed");
        String Hname=common.getText(Header_NAME);
        common.logPrint("Steps::Header of Name Column is :- "+Hname);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_EMAIL)), "Header not displayed");
        String Hemail=common.getText(Header_EMAIL);
        common.logPrint("Steps::Header of Email Column is :- "+Hemail);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_CONTYPE)), "Header not displayed");
        String HConType=common.getText(Header_CONTYPE);
        common.logPrint("Steps::Header of ContactType Column  is:- "+HConType);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_TYPE)), "Header not displayed");
        String HType=common.getText(Header_TYPE);
        common.logPrint("Steps::Header of Type Column is :- "+HType);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_WHATSCONT)), "Header not displayed");
        String HWhatCon=common.getText(Header_WHATSCONT);
        common.logPrint("Steps::Header of whatsapp contact Column is :- "+HWhatCon);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_Product)), "Header not displayed");
        String HProduct=common.getText(Header_Product);
        common.logPrint("Steps::Header of product  Column is :- "+HProduct);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_PreferredDT)), "Header not displayed");
        String HDT=common.getText(Header_PreferredDT);
        common.logPrint("Steps::Header of preferred at Column is :- "+HDT);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_CREATEDAT)), "Header not displayed");
        String HCreateAt=common.getText(Header_CREATEDAT);
        common.logPrint("Steps::Header of CreatedAT Column is :- "+HCreateAt);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Header_Actions)), "Header not displayed");
        String HAction=common.getText(Header_Actions);
        common.logPrint("Steps::Header of Action Column  is :- "+HAction);

    }
}
