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

public void VerifyCreateLeadStage()
    {
        common.waitUntilElementToBeVisible(LS_Create);
        common.click(LS_Create);

        String name =common.fakeName();
        common.waitUntilElementToBeVisible(LS_Name);
        common.type(LS_Name,name);

        String label = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label);

        common.waitUntilElementToBeVisible(LS_Order);
        common.type(LS_Order,"1");

        common.waitUntilElementToBeVisible(LS_Save);
        common.click(LS_Save);


    }
    public Map<String, String> VerifyCreateNewLeadForReturn() {

        Map<String, String> expectedData = new HashMap<>();

        String name =common.fakeName();
        common.waitUntilElementToBeVisible(LS_Name);
        common.type(LS_Name,name);
        expectedData.put("Name",name);

        String label = common.fakeLeadLabel();
        common.waitUntilElementToBeVisible(LS_Label);
        common.type(LS_Label,label);
        expectedData.put("Label",label);

        common.waitUntilElementToBeVisible(LS_Order);
        common.type(LS_Order,"1");
        expectedData.put("Order","1");
        return expectedData;


    }

}