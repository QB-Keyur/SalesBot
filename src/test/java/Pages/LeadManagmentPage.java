package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;


public class LeadManagmentPage extends Locators {
    Common common = new Common(driver);
    String name1 = common.fakeName();

    public LeadManagmentPage(WebDriver driver)
    {
        super(driver);
    }

    public String  VerifyCreateNewLead() {


        common.logPrint("Steps:: click on LeadManagment ");
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.logPrint("Steps:: Click on lead ");
        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.logPrint("Steps:: Click on create lead button ");
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);


        common.logPrint("Step:: Enter Name ");
        common.waitUntilElementToBeVisible(NAME);
        common.type(NAME, name1);

        common.logPrint("Step:: Enter Email ");
        common.waitUntilElementToBeVisible(LEADNAME);
        String email = common.fakeEmail();
        common.type(LEADNAME, email);

        common.logPrint("Step:: Select Type");
        common.waitUntilElementToBeVisible(TYPE);
        common.click(TYPE);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select ContactType");
        common.waitUntilElementToBeVisible(CONTACTTYPE);
        common.click(CONTACTTYPE);
        common.downKeyAndEnter();
        common.pause(3);

        common.logPrint("Step:: Select WhatsAPPContactType");
        common.waitUntilElementToBeVisible(WHATSAPPCON);
        common.click(WHATSAPPCON);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Date ");
        common.waitUntilElementToBeVisible(DTAETIME);
        common.selectFutureDateTimeThisWeek(DTAETIME);

        common.logPrint("Step:: Select Product");
        common.waitUntilElementToBeVisible(PRODUCT);
        common.click(PRODUCT);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on Save button");
        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);
        common.waitUntilElementToBeVisible(SAVE_BTN);
        common.click(SAVE_BTN);

//        common.logPrint("Step:: Click on Refresh");
//        common.waitUntilElementToBeVisible(LEADREFRESH);
//        common.click(LEADREFRESH);


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
    public void verifyDeleteLeadInSearch()
    {
        VerifyCreateNewLead();

        common.logPrint("Step:: click on Search button");
        common.waitUntilElementToBeVisible(LEADSEARCH);
        common.type(LEADSEARCH,name1);

        common.logPrint("Step:: Delete created lead");
        common.waitUntilElementToBeVisible(DELETEOTIN);
       common.click(DELETEOTIN);

//        common.logPrint("Step:: click on cancel button");
//        common.handleAlert();
//        common.waitUntilElementToBeVisible(CANCELDELETE);
//        common.click(CANCELDELETE);

        common.logPrint("Step:: click on Confirm delete button"+name1);
        common.handleAlert();
        common.waitUntilElementToBeVisible(CONFDELETE);
        common.click(CONFDELETE);

        common.logPrint("Step:: click on Search button");
        common.waitUntilElementToBeVisible(LEADSEARCH);
        common.type(LEADSEARCH,name1);

        common.logPrint("Step:: No Rows getting display" );
        common.waitUntilElementToBeVisible(NoRows);
    }
    public void Verify_CancelAmdBackButtonOnCreateLeadPage()
    {
        common.logPrint("Steps:: click on LeadManagment ");
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.logPrint("Steps:: Click on lead ");
        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.logPrint("Steps:: Click on create lead button ");
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        common.logPrint("Step:: click on cancel button");
        common.handleAlert();
        common.waitUntilElementToBeVisible(CANCELDELETE);
        common.click(CANCELDELETE);

        common.logPrint("Steps:: Again Click on create lead button ");
        common.waitUntilElementToBeVisible(CREATEB);
        common.click(CREATEB);

        common.logPrint("Steps:: Click on back button");
        common.waitUntilElementToBeVisible(LEADPBack);
        common.pause(2);
        common.click(LEADPBack);


    }
    public void Verify_LeadPageHeader() {
        common.logPrint("Steps:: click on LeadManagment ");
        common.waitUntilElementToBeVisible(LEADMANAGMENT);
        common.click(LEADMANAGMENT);

        common.logPrint("Steps:: Click on lead ");
        common.waitUntilElementToBeVisible(LEAD);
        common.click(LEAD);

        common.logPrint("Step:: Click on Refresh");
        common.waitUntilElementToBeVisible(LEADREFRESH);
        common.click(LEADREFRESH);

        common.logPrint("Step:: Verify Lead managment  Header is display ");
        common.assertElementText(LEADHEADER, "Lead Management");
    }

        public void Verify_Grid_List_view()
        {


            common.logPrint("Step:: Click on GRIDVIEW_BTNL");
            common.waitUntilElementToBeVisible(GRIDVIEWBTNL);
            common.click(GRIDVIEWBTNL);
            common.pause(4);


            common.logPrint("Step:: Click on LISTVIEW_BTNL");
            common.waitUntilElementToBeVisible(LISTVIEWBTNL);
            common.click(LISTVIEWBTNL);
        }

        public void VerifyEdit()
        {
            common.logPrint("Steps:: click on LeadManagment ");
            common.waitUntilElementToBeVisible(LEADMANAGMENT);
            common.click(LEADMANAGMENT);

            common.logPrint("Steps:: Click on lead ");
            common.waitUntilElementToBeVisible(LEAD);
            common.click(LEAD);




            common.logPrint("Step:: Click on edit");
            common.waitUntilElementToBeVisible(LEADEDIT);
            common.click(LEADEDIT);

            common.logPrint("Step:: Verify Lead update page Header ");
            common.assertElementText(LEADUPDATEHEADER, "Update Lead Management");
            common.logPrint("Steps:: Header getting dispaly on page");


            common.logPrint("Step:: Enter Email ");
            common.waitUntilElementToBeVisible(LEADNAME);
            String email = common.fakeEmail();
            common.type(LEADNAME, email);
            common.pause(5);


            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(SAVE_BTN);
            common.click(SAVE_BTN);
         //   common.waitUntilElementToBeVisible(SAVE_BTN);
         //   common.click(SAVE_BTN);




        }
        public void verifyBackAndCancelButtonOnUpdateLeadPage()
       {


        }









}
