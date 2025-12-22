package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WhatsAppCampaignPage extends Locators {
    Common common;

    public WhatsAppCampaignPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

        public void  goToWhatsAppCampaignPage()
        {
            common.waitUntilElementToBeVisible(CampaignMenu);
            common.click(CampaignMenu);

            common.waitUntilElementToBeVisible(whatsappCampaign);
            common.click(whatsappCampaign);


        }

        public void VerifyWhatsAppCampaignPageHeader()
        {
            common.waitUntilElementToBeVisible(WC_REFRESH);
            common.click(WC_REFRESH);

            common.logPrint("Step:: Verify WhatsApp campaign Header is getting  display ");
            common.assertElementText(WC_PAGEHEADER, "WhatsApp Campaign");

        }
    public void VerifyWhatsAppContactHeaders() {


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_NAME)), "Header not displayed");
        String Hname=common.getText(WCH_NAME);
        common.logPrint("Steps::Header of Name Column is :- "+Hname);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_WhatsAppTem)), "Header not displayed");
        String WhatsCTem=common.getText(WCH_WhatsAppTem);
        common.logPrint("Steps::Header of WhatsApp Template Column is :- "+WhatsCTem);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_WhatsAppCategorName)), "Header not displayed");
        String WhatsCType=common.getText(WCH_WhatsAppCategorName);
        common.logPrint("Steps::Header of WhatsAppCategoryName Column is :- "+WhatsCType);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_ProductName)), "Header not displayed");
        String HProdName=common.getText(WCH_ProductName);
        common.logPrint("Steps::Header of ProductName contact Column is :- "+HProdName);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_ScheduleTime)), "Header not displayed");
        String ScheTime=common.getText(WCH_ScheduleTime);
        common.logPrint("Steps::Header of ScheduleTime  Column is :- "+ScheTime);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_Status)), "Header not displayed");
        String Wch_Stat=common.getText(WCH_Status);
        common.logPrint("Steps::Header of Status at Column is :- "+Wch_Stat);


        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(WCH_Action)), "Header not displayed");
        String HActin=common.getText(WCH_Action);
        common.logPrint("Steps::Header of Action Column is :- "+HActin);


    }
    public void  VerifyListAndGridView()
    {
        common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
        common.click(GRIDVIEWBTNL);
        common.pause(4);

        common.waitUntilElementToBeVisible(LISTVIEWBTNL);
        common.click(LISTVIEWBTNL);
        common.pause(2);


    }

    public void VerifyCreateWhatsAppCampaignPage()
    {
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

        common.waitUntilElementToBeVisible(CWC_View);
        common.click(CWC_View);

    }

    public void VerifyRunCampaignPopup()
    {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.waitUntilElementToBeVisible(CWC_RunCamBTN);
        common.click(CWC_RunCamBTN);

        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_PopupNo);
        common.click(RC_PopupNo);

        common.waitUntilElementToBeVisible(CWC_RunCamBTN);
        common.click(CWC_RunCamBTN);

        common.handleAlert();
        common.waitUntilElementToBeVisible(RC_PopupYes);
        common.click(RC_PopupYes);
    }
    public void verifyViewContactListHeader()
    {
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);
        common.pause(2);

        common.waitUntilElementToBeVisible(CWC_View);
        common.click(CWC_View);



        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(V_Name)), "Header not displayed");
        String vname=common.getText(V_Name);
        common.logPrint("Steps::Header of Name Column is :- "+vname);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VContactG)), "Header not displayed");
        String vContactG=common.getText(VContactG);
        common.logPrint("Steps::Header of ContactGroup Column is :- "+vContactG);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VPhoneNo)), "Header not displayed");
        String PhoneNO=common.getText(VPhoneNo);
        common.logPrint("Steps::Header of Phone number Column is :- "+PhoneNO);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VEmail)), "Header not displayed");
        String Vemail=common.getText(VEmail);
        common.logPrint("Steps::Header of Email Column is :- "+Vemail);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(VDandB)), "Header not displayed");
        String DofB=common.getText(VDandB);
        common.logPrint("Steps::Header of Date of birth Column is :- "+DofB);
    }


public void VerifyFieldValidationsMessageOnCampaignPage(){

    common.waitUntilElementToBeVisible(CREATEB);
    common.click(CREATEB);
    common.pause(2);

    common.waitUntilElementToBeVisible(CWC_RunCamBTN);
    common.click(CWC_RunCamBTN);


    common.handleAlert();
    common.waitUntilElementToBeVisible(RC_PopupYes);
    common.click(RC_PopupYes);

    Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_CampaginName)), "Campaign Name validation message not displayed");
    String Error1=common.getText(Req_CampaginName);
    common.logPrint("Steps::Display the validation message for Campaign Name field: - "+Error1);

    Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_WhatsappTemp)), "WhatsApp Template validation message not displayed");
    String Error2=common.getText(Req_WhatsappTemp);
    common.logPrint("Steps::Display the validation message for WhatsApp field: - "+Error2);

    Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_Category)), "Category validation message not displayed");
    String Error3=common.getText(Req_Category);
    common.logPrint("Steps::Display the validation message for Category field: - "+Error3);

    Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(Req_Product)), "Product Type validation message not displayed");
    String Error4=common.getText(Req_Product);
    common.logPrint("Steps::Display the validation message for Product field: - "+Error4);
    common.pause(4);

}


}