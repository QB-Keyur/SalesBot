package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class WhatsAppCampaignPage extends Locators {
    Common common;

    public WhatsAppCampaignPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToWhatsAppCampaignPage() {
        common.waitUntilElementToBeVisible(CampaignMenu);
        common.click(CampaignMenu);

        common.waitUntilElementToBeVisible(whatsappCampaign);
        common.click(whatsappCampaign);


    }

    public void VerifyWhatsAppCampaignPageHeader() {
//        common.waitUntilElementToBeVisible(WC_REFRESH);
//        common.click(WC_REFRESH);

        common.logPrint("Step:: Verify WhatsApp campaign Header is getting  display ");
        common.assertElementText(WC_PAGEHEADER, "WhatsApp Campaign");

    }

    public void VerifyWhatsAppContactHeaders() {


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_NAME)), "Header not displayed");
        String Hname = common.getText(WCH_NAME);
        common.logPrint("Steps::Header of Name Column is :- " + Hname);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_WhatsAppTem)), "Header not displayed");
        String WhatsCTem = common.getText(WCH_WhatsAppTem);
        common.logPrint("Steps::Header of WhatsApp Template Column is :- " + WhatsCTem);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_WhatsAppCategorName)), "Header not displayed");
        String WhatsCType = common.getText(WCH_WhatsAppCategorName);
        common.logPrint("Steps::Header of WhatsAppCategoryName Column is :- " + WhatsCType);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_ProductName)), "Header not displayed");
        String HProdName = common.getText(WCH_ProductName);
        common.logPrint("Steps::Header of ProductName contact Column is :- " + HProdName);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_Status)), "Header not displayed");
        String Wch_Stat = common.getText(WCH_Status);
        common.logPrint("Steps::Header of Status at Column is :- " + Wch_Stat);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_DT)), "Header not displayed");
        String ScheTime = common.getText(WCH_DT);
        common.logPrint("Steps::Header of Created date  Column is :- " + ScheTime);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_Action)), "Header not displayed");
        String HActin = common.getText(WCH_Action);
        common.logPrint("Steps::Header of Action Column is :- " + HActin);


    }

    public void VerifyListAndGridView() {
        common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
        common.click(GRIDVIEWBTNL);
        common.pause(4);

        common.waitUntilElementToBeVisible(LISTVIEWBTNL);
        common.click(LISTVIEWBTNL);
        common.pause(2);


    }

    public void VerifyCreateWhatsAppCampaignPageAllElements() {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);


        common.waitUntilElementToBeVisible(CWC_Cancel);
        common.click(CWC_Cancel);
        common.pause(2);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.waitUntilElementToBeVisible(CWC_Back);
        common.click(CWC_Back);

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

//        common.waitUntilElementToBeVisible(CWC_View);
//        common.click(CWC_View);

        common.logPrint("Step:: Verify Create WhatsApp Campaign Header is display ");
        common.assertElementText(CWC_Header, "Create WhatsApp Campaign");



    }

    public void VerifyRunCampaignPopup() {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.waitUntilElementToBeVisible(CWC_Save);
        common.click(CWC_Save);

        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_PopupNo);
        common.click(RC_PopupNo);

//        common.waitUntilElementToBeVisible(CWC_Save);
//        common.click(CWC_Save);
//
//        common.handleAlert();
//        common.waitUntilElementToBeVisible(RC_PopupYes);
//        common.click(RC_PopupYes);
    }

//    public void verifyViewContactListHeader() {
//        common.waitUntilElementToBeVisible(CREATEB);
//        common.click(CREATEB);
//        common.pause(2);
//
//        common.waitUntilElementToBeVisible(CWC_View);
//        common.click(CWC_View);
//        common.pause(2);
//
//        common.waitUntilElementToBeVisible(V_Name);
//
//        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(V_Name)), "Header not displayed");
//        String vname = common.getText(V_Name);
//        common.logPrint("Steps::Header of Name Column is :- " + vname);
//        common.pause(2);
//
//
//        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VContactG)), "Header not displayed");
//        String vContactG = common.getText(VContactG);
//        common.logPrint("Steps::Header of ContactGroup Column is :- " + vContactG);
//
//        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VPhoneNo)), "Header not displayed");
//        String PhoneNO = common.getText(VPhoneNo);
//        common.logPrint("Steps::Header of Phone number Column is :- " + PhoneNO);
//
//        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VEmail)), "Header not displayed");
//        String Vemail = common.getText(VEmail);
//        common.logPrint("Steps::Header of Email Column is :- " + Vemail);
//
//        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VDandB)), "Header not displayed");
//        String DofB = common.getText(VDandB);
//        common.logPrint("Steps::Header of Date of birth Column is :- " + DofB);
//    }


    public void VerifyFieldValidationsMessageOnCampaignPage() {

        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.waitUntilElementToBeVisible(CWC_Save);
        common.click(CWC_Save);


        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_RunCamp);
        common.click(RC_RunCamp);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_CampaginName)), "Campaign Name validation message not displayed");
        String Error1 = common.getText(Req_CampaginName);
        common.logPrint("Steps::Display the validation message for Campaign Name field: - " + Error1);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_WhatsappTemp)), "WhatsApp Template validation message not displayed");
        String Error2 = common.getText(Req_WhatsappTemp);
        common.logPrint("Steps::Display the validation message for WhatsApp field: - " + Error2);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_Category)), "Category validation message not displayed");
        String Error3 = common.getText(Req_Category);
        common.logPrint("Steps::Display the validation message for Category field: - " + Error3);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_Product)), "Product Type validation message not displayed");
        String Error4 = common.getText(Req_Product);
        common.logPrint("Steps::Display the validation message for Product field: - " + Error4);
        common.pause(4);

    }

    public void VerifyContactListHeaderOnCreateCampaignPage() {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.scroll_To_Element(V_Name);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(V_Name)), "Header not displayed");
        String vname = common.getText(V_Name);
        common.logPrint("Steps::Header of Name Column is :- " + vname);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VContactG)), "Header not displayed");
        String vContactG = common.getText(VContactG);
        common.logPrint("Steps::Header of ContactGroup Column is :- " + vContactG);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VPhoneNo)), "Header not displayed");
        String PhoneNO = common.getText(VPhoneNo);
        common.logPrint("Steps::Header of Phone number Column is :- " + PhoneNO);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VEmail)), "Header not displayed");
        String Vemail = common.getText(VEmail);
        common.logPrint("Steps::Header of Email Column is :- " + Vemail);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VDandB)), "Header not displayed");
        String DofB = common.getText(VDandB);
        common.logPrint("Steps::Header of Date of birth Column is :- " + DofB);


    }

    public void VerifyCreateWhatsAppCampaignPage() {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        String CampName = common.fakeCampaignName();
        common.waitUntilElementToBeVisible(C_Name);
        common.type(C_Name, CampName);
        common.pause(2);


        common.waitUntilElementToBeVisible(C_WhatsAppTem);
        common.click(C_WhatsAppTem);
        common.downKeyAndEnter();
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Category);
        common.click(C_Category);
        common.downKeyAndEnter();
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Product);
        common.click(C_Product);
        common.downKeyAndEnter();

//        common.waitUntilElementToBeVisible(C_ContactGroup);
//        common.click(C_ContactGroup);
//        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(C_Contacts);
        common.scroll_To_Element(C_Contacts);
        common.waitUntilElementToBeVisible(C_SelectContact);
        common.jsClick(C_SelectContact);


    }

    public void VerifyRunCampaignWithoutSelectingContact() {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        String CampName = common.fakeCampaignName();
        common.waitUntilElementToBeVisible(C_Name);
        common.type(C_Name, CampName);
        common.pause(2);


        common.waitUntilElementToBeVisible(C_WhatsAppTem);
        common.click(C_WhatsAppTem);
        common.downKeyAndEnter();
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Category);
        common.click(C_Category);
        common.downKeyAndEnter();
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Product);
        common.click(C_Product);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(CWC_Save);
        common.click(CWC_Save);

        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_RunCamp);
        common.click(RC_RunCamp);

        common.waitUntilElementToBeVisible(Contact_RequiredMessage);
        String contactRequired = common.getText(Contact_RequiredMessage);
        common.logPrint("Steps:: getting message " + contactRequired);
        common.pause(2);

    }

    public Map<String, String> VerifyRunCampaignWithSelectingContact() {

        Map<String, String> expectedCampaigndata = new HashMap<>();


        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        String CampName = common.fakeCampaignName();
        common.waitUntilElementToBeVisible(C_Name);
        common.type(C_Name, CampName);
        expectedCampaigndata.put("Name", CampName);
        common.pause(2);


        common.waitUntilElementToBeVisible(C_WhatsAppTem);
        common.click(C_WhatsAppTem);
        common.downKeyAndEnter();

        String template = common.getText(C_WhatsAppTem);
        expectedCampaigndata.put("Template", template);
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Category);
        common.click(C_Category);
        common.downKeyAndEnter();
        String category = common.getText(C_Category);
        expectedCampaigndata.put("Category", category);
        common.pause(2);


        common.waitUntilElementToBeVisible(C_Product);
        common.click(C_Product);
        common.downKeyAndEnter();
        String product=common.getText(C_Product);
        expectedCampaigndata.put("Product", product);

        common.scroll_To_Element(C_Contacts);
        common.waitUntilElementToBeClickable(Search_ContactonCampaignpage);
        common.type(Search_ContactonCampaignpage, "7774974990");
        common.waitUntilElementToBeVisible(SearchedResult_ContactonCampaignpage);

        common.waitUntilElementToBeClickable(C_SelectContactcheckbox);
        common.click(C_SelectContactcheckbox);

        String phoneNumber = "+91 77749 74990";
        expectedCampaigndata.put("PhoneNumber", phoneNumber);


        common.waitUntilElementToBeVisible(CWC_Save);
        common.click(CWC_Save);

        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_RunCamp);
        common.click(RC_RunCamp);

        return expectedCampaigndata;
    }
    public Map<String, String> getCampignDetailsAfterSave() {
        Map<String, String> actualData = new HashMap<>();
        actualData.put("Name", common.getAttribute(WName,"value"));
        actualData.put("Template", common.getText(WTemplate));
        actualData.put("Category", common.getText(WCategory));
        actualData.put("Product", common.getText(WProduct));
        common.scroll_To_Element(C_Contacts);
        common.waitUntilElementToBeVisible(WPhoneNumber);
        actualData.put("PhoneNumber", common.getText(WPhoneNumber));

        return actualData;
    }
    public void verifyViewCampaign() {
        Map<String, String> expected = VerifyRunCampaignWithSelectingContact();
        common.waitUntilElementToBeVisible(CAMPAIGNVIEW);
        common.click(CAMPAIGNVIEW);

        Map<String, String> actual = getCampignDetailsAfterSave();
        Assert.assertEquals(actual.get("Name"), expected.get("Name"), "Name mismatch");
        Assert.assertEquals(actual.get("Template"), expected.get("Template"), "Template Type mismatch");
        Assert.assertEquals(actual.get("Category"), expected.get("Category"), "Category mismatch");
        Assert.assertEquals(actual.get("Product"), expected.get("Product"), "Product mismatch");
        Assert.assertEquals(actual.get("PhoneNumber"),expected.get("PhoneNumber"), "PhoneNumber mismatch");

        common.logPrint("Campaign created and validated successfully with selected contact");
    }

    public void VerifyViewWhatsAppCampaignHader() {

        common.waitUntilElementToBeVisible(CAMPAIGNVIEW);
        common.click(CAMPAIGNVIEW);
        common.pause(2);


        common.logPrint("Step:: Verify View WhatsApp Campaign Header is display ");
        common.assertElementText(WCViewHeader, "View WhatsApp Campaign");

    }
    public void VerifyWhatsAppCampaignSearch()
    {
      common.logPrint("Step:: Search Available campaign name");
      String WCname =common.getText(SearchTex);
      common.type(WC_Search,WCname);
      common.pause(2);
      common.logPrint("Step:: Search working as expected");

    }
    public void VerifyViewpageElements()
    {
        common.waitUntilElementToBeVisible(CAMPAIGNVIEW);
        common.click(CAMPAIGNVIEW);
        common.pause(2);

        common.waitUntilElementToBeVisible(V_RetryRerun);
        common.click(V_RetryRerun);

        common.logPrint("Steps:: verify Rerun Success message ");
        common.waitUntilElementToBeVisible(RerunSuccessMSG);
        common.pause(1);
        String successMSG = common.getText(RerunSuccessMSG);
        common.logPrint("Steps:: getting message :- "+ successMSG);
        common.pause(2);

        common.waitUntilElementToBeVisible(V_back);
        common.click(V_back);





    }


}