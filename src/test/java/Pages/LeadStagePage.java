package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class LeadStagePage extends Locators {
    Common common;

    public LeadStagePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);

    }

    public void VerifyonLeadStagePage()
    {
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);
        common.pause(2);

        common.waitUntilElementToBeVisible(LeadStageMenu);
        common.click(LeadStageMenu);
        common.pause(2);


    }
    public void verifyLeadStagePageHeader() {
        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LSH_Name)), "Header not displayed");
        String HName = common.getText(LSH_Name);
        common.logPrint("Steps::Header of Name Column is :- " + HName);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LSH_Label)), "Header not displayed");
        String HLabel = common.getText(LSH_Label);
        common.logPrint("Steps::Header of Label  Column is :- " + HLabel);





        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LSH_Order)), "Header not displayed");
        String HOrder = common.getText(LSH_Order);
        common.logPrint("Steps::Header of Order Column is :- " + HOrder);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LSH_Actions)), "Header not displayed");
        String HAction = common.getText(LSH_Actions);
        common.logPrint("Steps::Header of Action Column is :- " + HAction);
    }
    public void VerifyPageheader()
    {
        common.waitUntilElementToBeVisible(LS_header);
        String leadStageHeader = common.getText(LS_header);
        common.logPrint("Step::Header of log textpage:"+leadStageHeader);

    }
    public void VerifyListandGridVerw()
    {
        common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
        common.click(GRIDVIEWBTNL);
        common.pause(4);

        common.waitUntilElementToBeVisible(LISTVIEWBTNL);
        common.click(LISTVIEWBTNL);
        common.pause(4);
    }
    public void VerifyFieldvalidation()
    {
        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        common.waitUntilElementToBeVisible(LS_Save);
        common.click(LS_Save);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LS_ErrorOnName)), "Name validation message not displayed");
        String Error1=common.getText(LS_ErrorOnName);
        common.logPrint("Steps::Display the validation message for name field: - "+Error1);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LS_ErrorOnLabel)), "Email validation message not displayed");
        String Error2=common.getText(LS_ErrorOnLabel);
        common.logPrint("Steps::Display the validation message for Label field: - "+Error2);

        Assert.assertTrue(common.isValidationMessageDisplayed(By.xpath(LS_ErrorOnOrder)), "Type validation message not displayed");
        String Error3=common.getText(LS_ErrorOnOrder);
        common.logPrint("Steps::Display the validation message for Order field: - "+Error3);
    }
    public void verifyBackandCancelButton()
    {
        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        common.waitUntilElementToBeVisible(LS_Cancel);
        common.click(LS_Cancel);

        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        common.waitUntilElementToBeVisible(LS_Back);
        common.click(LS_Back);
    }

    public String  VerifyCreateLeadStage()
    {
        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        String name =common.fakeName();
        common.waitUntilElementToBeVisible(LS_Name);
        common.type(LS_Name,name);

        String label = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label);

        String num = common.fakeOrderNumber2Digit();
        common.waitUntilElementToBeVisible(LS_Order);
        common.type(LS_Order,num);


        common.waitUntilElementToBeVisible(LS_Save);
        common.click(LS_Save);

        return name;


    }
    public Map<String, String> VerifyCreateNewLeadForReturn() {

        Map<String, String> expectedData = new HashMap<>();


        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        String name =common.fakeName();
        common.waitUntilElementToBeVisible(LS_Name);
        common.type(LS_Name,name);
        expectedData.put("Name",name);

        String label = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label);
        expectedData.put("Label",label);

        String num = common.fakeOrderNumber2Digit();
        common.waitUntilElementToBeVisible(LS_Order);
        common.type(LS_Order,num);
        expectedData.put("Order",num);

        common.waitUntilElementToBeVisible(LS_Save);
        common.click(LS_Save);
        return expectedData;


    }
    public Map<String, String> getLeadDetailsAfterSave() {
        Map<String, String> actualData = new HashMap<>();


        common.waitUntilElementToBeVisible(LSV_name);
        actualData.put("Name", common.getAttribute(LSV_name,"value"));
        common.waitUntilElementToBeVisible(LSV_label);
        actualData.put("Label", common.getAttribute(LSV_label,"value"));
        common.waitUntilElementToBeVisible(LSV_OrderNo);
        actualData.put("Order", common.getText(LSV_OrderNo));

        return actualData;

    }
    public void verifyViewLead() {
        Map<String, String> expected = VerifyCreateNewLeadForReturn();

        // common.waitUntilElementToBeVisible(LS_View);
        common.waitUntilElementToBeVisible(LS_View);
        common.click(LS_View);

        Map<String, String> actual = getLeadDetailsAfterSave();
        Assert.assertEquals(actual.get("Name"), expected.get("Name"), "Name mismatch");
        Assert.assertEquals(actual.get("Label"), expected.get("Label"), "Email mismatch");
        Assert.assertEquals(actual.get("Order"), expected.get("Order"), "Type mismatch");
        //  Assert.assertEquals(actual.get("ContactType"), expected.get("ContactType"), "Contact Type mismatch");


        common.logPrint("Lead created and validated successfully");
//        common.waitUntilElementToBeVisible(VClose);
//        common.click(VClose);
    }
    public void VerifySearch(String lname)
    {
        common.waitUntilElementToBeVisible(LS_Search);
        common.type(LS_Search,lname);
    }
    public void VerifyEdit()
    {
        common.waitUntilElementToBeVisible(LS_edit);
        common.click(LS_edit);

        String label = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label);


        common.waitUntilElementToBeVisible(LS_reset);
        common.click(LS_reset);

        String label1 = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label1);

        common.waitUntilElementToBeVisible(LS_Save);
        common.click(LS_Save);


        common.logPrint("Steps:: verify the Lead Stage updated successfully ");
        common.waitUntilElementToBeVisible(LS_UpdateMSG);
        common.pause(1);
        String successMSG = common.getText(LS_UpdateMSG);
        common.logPrint("Steps:: getting message :-"+ successMSG);
        common.pause(2);

    }

    public void BackAndCancelbuttonsOnUpdatePage()
    {
        common.waitUntilElementToBeVisible(LS_edit);
        common.click(LS_edit);

        common.waitUntilElementToBeVisible(LSU_header);
        String leadStageHeader = common.getText(LSU_header);
        common.logPrint("Step::Header of Update lead stage page:"+leadStageHeader);

        common.waitUntilElementToBeVisible(LS_Cancel);
        common.click(LS_Cancel);

        common.waitUntilElementToBeVisible(LS_edit);
        common.click(LS_edit);

        common.waitUntilElementToBeVisible(LSU_Back);
        common.click(LSU_Back);

    }

    public void VerifyDeleteleadStage()
    {
        common.waitUntilElementToBeVisible(LS_Delete);
        common.click(LS_Delete);

        common.handleAlert();
        common.waitUntilElementToBeVisible(LS_DeleteCancel);
        common.click(LS_DeleteCancel);
        common.pause(2);

        common.waitUntilElementToBeVisible(LS_Delete);
        common.click(LS_Delete);


        common.waitUntilElementToBeVisible(LS_ConfirmDelete);
        common.click(LS_ConfirmDelete);




    }


}