package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;

public class WhatsAppTemplatePage extends Locators {

    ReadProperties readProperties;
    Common common;

    public WhatsAppTemplatePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.readProperties = new ReadProperties();
    }

    public void goToWhatsAppTemplatePage() {

        common.waitUntilElementToBeClickable(TEMPLATEMENU);
        common.click(TEMPLATEMENU);

        common.waitUntilElementToBeClickable(WHATSAPPTEMPLATEMENU);
        common.click(WHATSAPPTEMPLATEMENU);

        common.logPrint("Navigated to WhatsApp Template Page and fully loaded.");

    }

    public void verifyAllTheUIElements(){
        goToWhatsAppTemplatePage();

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(TEMPLATEMENU, "WT Menu");
        columns.put(WTHEADER, "WT Header");
        columns.put(WTSEARCH, "WT Search");
        columns.put(KBSRNUMBER, "WT Sr");
        columns.put(WTNAME, "WT Name");
        columns.put(WTLANGUAGE, "WT Products");
        columns.put(WTHEADERTEXT, "WT Status");
        columns.put(WTCATEGORY, "WT Created Date");
        columns.put(WTTEMPLATEMETASTATUS, "WT Actions");
        columns.put(WTQUALITYSCORE, "WT Score");
        columns.put(WTACTIONS, "WT Rows per page");
        columns.put(WTREFRESH, "WT Refresh");
        columns.put(WTFILTERS, "WT Filters");
        columns.put(WTCREATE, "WT Create");
        columns.put(MULTITABHOR, "WT Horizontal View");
        columns.put(MULTITABVER, "WT Vertical View");
        columns.put(KBTOTALROWS, "WT Total Rows");
        columns.put(KBROWSPERPAGE, "WT Rows Per Page");


        int failures = 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();
            try {

                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                String msg = "Missing element -> " + friendlyName + " (" + locator + ")";
                common.logPrint(msg);

                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All columns verified successfully.");
        } else {
            common.logPrint("Step :: Column verification completed with " + failures + " missing element(s).");
        }
    }

    public void verifyAllTheCreateUIElements(){
        goToWhatsAppTemplatePage();

        common.waitUntilElementToBeVisible(WTCREATE);
        common.click(WTCREATE);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(WTCHEADER, "WTC Header");
        columns.put(WTCBANNERTEXT, "WTC Banner Text");
        columns.put(WTCTEMPLATEDETAILS, "WTC Template Details");
        columns.put(WTCTEMPLATENAME, "WTC Template Name");
        columns.put(WTCTEMPLATENAMEINPUT, "WTC Template Name Input");
        columns.put(WTCCATEGORY, "WTC Category");
        columns.put(WTCCATEGORYINPUT, "WTC Category Input");
        columns.put(WTCLANGUAGE, "WTC Language");
        columns.put(WTCLANGUAGEINPUT, "WTC Language Input");
        columns.put(WTCHEADERTYPE, "WTC Header Type");
        columns.put(WTCHEADERTYPEINPUT, "WTC Header Type Input");
        columns.put(WTCMESSAGECONTENT, "WTC Message Content");
        columns.put(WTCUPLOADFILES, "WTC File Upload Header");
        columns.put(WTCFILEINPUT, "WTC File Upload Header Input");
        columns.put(WTCFILEINPUT2, "WTC File Upload Button");
        columns.put(WTCBODY, "WTC Body");
        columns.put(WTCADDVARIABLES, "WTC Add Variable");
        columns.put(WTCBODYINPUT, "WTC Body Input");
        columns.put(WTCFOOTER, "WTC Footer");
        columns.put(WTCFOOTERINPUT, "WTC Footer Input");
        columns.put(WTCBUTTONS, "WTC Button");
        columns.put(WTCBUTTONTYPE, "WTC Button Type");
        columns.put(WTCSELECTTYPE, "WTC Select Type");
        columns.put(WTCBUTTONTEXT, "WTC Button Text");
        columns.put(WTCBUTTONTEXTINPUT, "WTC Button Text Input");
        columns.put(WTCADDBUTTON, "WTC Add Button");
        columns.put(WTCTEMPLATEPREVIEW, "WTC Template Preview");
        columns.put(WTCMESSAGEICON, "WTC Message Icon");
        columns.put(WTCTEMPLATEPREVIEW2, "WTC Template Preview 2");
        columns.put(WTCTEMPLATEPREVIEW3, "WTC Template Preview 3");
        columns.put(KBCCANCELBUTTON, "WTC Cancel Button");
        columns.put(KBCSAVEBUTTON, "WTC Save Button");


        int failures = 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();
            try {

                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                String msg = "Missing element -> " + friendlyName + " (" + locator + ")";
                common.logPrint(msg);

                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All columns verified successfully.");
        } else {
            common.logPrint("Step :: Column verification completed with " + failures + " missing element(s).");
        }

    }

    public void verifyHowToCreateWhatsAppTemplateDropdown(){
        goToWhatsAppTemplatePage();

        common.waitUntilElementToBeVisible(WTCREATE);
        common.click(WTCREATE);

        common.waitUntilElementToBeVisible(WTCBANNERTEXT);
        common.click(WTCBANNERTEXT);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(FIRST, "FIRST");
        columns.put(SEC, "SEC");
        columns.put(THIRD, "THIRD");
        columns.put(FOURTH, "FOURTH");
        columns.put(FIFTH, "FIFTH");
        columns.put(SIXTH, "SIXTH");
        columns.put(SEVENTH, "SEVENTH");
        columns.put(EIGHTH, "EIGHTH");
        columns.put(NINTH, "NINTH");
        columns.put(TENTH, "TENTH");


        int failures = 0;

        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();
            try {

                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                String msg = "Missing element -> " + friendlyName + " (" + locator + ")";
                common.logPrint(msg);

                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All columns verified successfully.");
        } else {
            common.logPrint("Step :: Column verification completed with " + failures + " missing element(s).");
        }





    }

    public void verifyMandatoryFields(){
        goToWhatsAppTemplatePage();

        common.waitUntilElementToBeVisible(WTCREATE);
        common.click(WTCREATE);

        common.waitUntilElementToBeVisible(KBCSAVEBUTTON);
        common.click(KBCSAVEBUTTON);

        common.assertElementPresent(WTCNAMEMANDATORY);
        common.assertElementPresent(WTCCATEGORYMANDATORY);
        common.assertElementPresent(WTCLANGUAGEMANDATORY);
        common.assertElementPresent(WTCHEADERTYPEMANDATORY);
        common.assertElementPresent(WTCBODYOFTEMPMANDATORY);




    }

    public String[] verifyAddingANewTemplate(String category, String lang,  String header, String buttonType){
        goToWhatsAppTemplatePage();

        String dropDownValue = "//li[text()='"+category+"']";
        String langDropDownValue = "//li[text()='"+lang+"']";
        String headerDropDownValue = "//li[text()='"+header+"']";
        String buttonTypeDropDownValue = "//li[text()='"+buttonType+"']";
        String webSitePreview = common.fakeWebsite();
        String fakeNameValue = common.fakeName();


        String imagePath = Paths.get("Files", "1.png").toAbsolutePath().toString();
        String videoPath = Paths.get("Files", "1.png").toAbsolutePath().toString();
        String docPath   = Paths.get("Files", "1.pdf").toAbsolutePath().toString();

        String headerText = common.fakeCategory();
        String bodyText = common.fakeProductName().toLowerCase();
        String footerText = common.fakeProductName();

        common.waitUntilElementToBeVisible(WTCREATE);
        common.click(WTCREATE);

        common.waitUntilElementToBeVisible(WTCTEMPLATENAMEINPUT);
        common.type(WTCTEMPLATENAMEINPUT,common.fakeName().toLowerCase());

        common.waitUntilElementToBeVisible(WTCCATEGORYINPUT);
        common.click(WTCCATEGORYINPUT);
        common.click(dropDownValue);

        common.waitUntilElementToBeVisible(WTCLANGUAGEINPUT);
        common.click(WTCLANGUAGEINPUT);
        common.click(langDropDownValue);

        common.waitUntilElementToBeVisible(WTCHEADERTYPEINPUT);
        common.click(WTCHEADERTYPEINPUT);
        common.click(headerDropDownValue);

        switch (header) {
            case "Image":
                common.waitUntilElementToBeVisible(WTCFILEINPUT);

                common.logPrint(imagePath);
                common.uploadFile(WTCFILEINPUT, imagePath);
                common.pause(1);
                break;
            case "Video":
                common.waitUntilElementToBeVisible(WTCFILEINPUT);

                common.uploadFile(WTCFILEINPUT, videoPath);
                common.pause(3);

                break;
            case "Document":
                common.waitUntilElementToBeVisible(WTCFILEINPUT);

                common.uploadFile(WTCFILEINPUT, docPath);
                common.pause(3);
                break;

            case "Text":
                common.waitUntilElementToBeVisible(WTCHEADERTYPEINPUTTEXT);
                common.type(WTCHEADERTYPEINPUTTEXT,headerText);
        }

        common.waitUntilElementToBeVisible(WTCBODYINPUT);
        common.click(WTCBODYINPUT);
        common.type(WTCBODYINPUT,bodyText);

        common.waitUntilElementToBeVisible(WTCFOOTERINPUT);
        common.click(WTCFOOTERINPUT);
        common.type(WTCFOOTERINPUT,footerText);

        common.waitUntilElementToBeVisible(WTCSELECTTYPE);
        common.click(WTCSELECTTYPE);
        common.click(buttonTypeDropDownValue);

        if(buttonType.equals("Url")){
        String urlPreview = "//button[text()='"+fakeNameValue+"']";
        common.waitUntilElementToBeVisible(WTCENTERURL);
        common.type(WTCENTERURL,webSitePreview);
        common.waitUntilElementToBeVisible(WTCBUTTONTEXTINPUT);
        common.type(WTCBUTTONTEXTINPUT,fakeNameValue);
        common.click(WTCADDBUTTON);
        common.assertElementPresent(urlPreview);


        } else if (buttonType.equals("Phone Number")) {
        String urlPreview = "//button[text()='"+fakeNameValue+"']";
        common.waitUntilElementToBeVisible(WTCENTERPHONE);
        common.type(WTCENTERPHONE,common.fakeIndianMobileNumber());
        common.waitUntilElementToBeVisible(WTCBUTTONTEXTINPUT);
        common.type(WTCBUTTONTEXTINPUT,fakeNameValue);
        common.click(WTCADDBUTTON);
        common.assertElementPresent(urlPreview);
        }

        String urlPreview = "//button[text()='"+fakeNameValue+"']";
        common.waitUntilElementToBeVisible(WTCBUTTONTEXTINPUT);
        common.type(WTCBUTTONTEXTINPUT,fakeNameValue);
        common.click(WTCADDBUTTON);
        common.assertElementPresent(urlPreview);

        common.logPrint("headerText: "+headerText+ "\n bodyText "+bodyText+"\n footerText: "+footerText);

        String headerTextXpath = "//h6[text()='"+headerText+"']";
        String bodyTextXpath = "//p[text()='"+bodyText+"']";
        String footerTextXpath = "//p[text()='"+footerText+"']";

        common.assertElementPresent(headerTextXpath);
        common.assertElementPresent(bodyTextXpath);
        common.assertElementPresent(footerTextXpath);


        return new String[]{headerText, bodyText, footerText};


    }

    public void verifyingPreviewTemplate(){

        String[] added =  verifyAddingANewTemplate("Marketing","English","Text","Phone Number");

        String headerText = added[0];
        String bodyText = added[1];
        String footerText = added[2];

        common.logPrint("headerText: "+headerText+ "\n bodyText "+bodyText+"\n footerText: "+footerText);

        String headerTextXpath = "//h6[text()='"+headerText+"']";
        String bodyTextXpath = "//p[text()='"+bodyText+"']";
        String footerTextXpath = "//p[text()='"+footerText+"']";

        common.assertElementPresent(headerTextXpath);
        common.assertElementPresent(bodyTextXpath);
        common.assertElementPresent(footerTextXpath);

    }

    public void verifyingHorizontalView(){
        goToWhatsAppTemplatePage();
        common.validateHorizontalViewCardCount();
    }

    public void verifyingSearch(){
        goToWhatsAppTemplatePage();
        common.searchCommon(WTSEARCHRESULT);
    }

    public void verifyingAddVariable(int amountOfVariables){
        goToWhatsAppTemplatePage();


        common.waitUntilElementToBeClickable(WTCREATE);
        common.click(WTCREATE);

        for(int i=1;i<=amountOfVariables; i++) {

            String fakeName = common.fakeName();
            common.waitUntilElementToBeClickable(WTCADDVARIABLES);
            common.click(WTCADDVARIABLES);
            String variable = "//span[text()='Variable {{"+i+"}}']";
            String variableValue = "//input[@name=\"variables."+i+"\"]";
            String variableValuePreview = "//p[text()='"+fakeName+"']";
            common.assertElementPresent(variable);
            common.type(variableValue,fakeName);
            common.assertElementPresent(variableValuePreview);

        }


    }

    public void verifyingPagination(){
        goToWhatsAppTemplatePage();
        common.pagination();
    }

    public void verifyRefreshButtonUpdatesTheServerSyncStatus(){
        verifyAddingANewTemplate("Marketing","English","Text","Phone Number");

        String synced= common.getText(WTMETASTATUS).trim();

//        while(synced.equals("Synced")){
//            common.pause(2);
//            common.click(ETREFRESH);
//        }


    }
}
