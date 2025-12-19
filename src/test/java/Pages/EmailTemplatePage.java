package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmailTemplatePage extends Locators {
    ReadProperties readProperties;
    Common common;

    public EmailTemplatePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.readProperties = new ReadProperties();
    }

    public void goToEmailTemplatePage(){

        common.waitUntilElementToBeClickable(TEMPLATEMENU);
        common.click(TEMPLATEMENU);

        common.waitUntilElementToBeClickable(EMAILTEMPLATEMENU);
        common.click(EMAILTEMPLATEMENU);

        common.logPrint("Navigated to Email Template Page and fully loaded.");

    }

    public void verifyAllTheUIElements(){
        goToEmailTemplatePage();

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(TEMPLATEMENU, "ET Menu");
        columns.put(ETHEADER, "ET Header");
        columns.put(ETSEARCH, "ET Search");
        columns.put(ETSR, "ET Sr");
        columns.put(ETNAME, "ET Name");
        columns.put(ETSUBJECT, "ET Subject");
        columns.put(ETSERVERSYNCED, "ET Status");
        columns.put(ETCREATEDDATE, "eT Created Date");
        columns.put(ETACTIONS, "eT Actions");
        columns.put(ETREFRESH, "ET Refresh");
        columns.put(ETFILTERS, "ET Filters");
        columns.put(ETCREATE, "ET Created");
        columns.put(MULTITABHOR, "ET Horizontal View");
        columns.put(MULTITABVER, "ET Vertical View");
        columns.put(KBTOTALROWS, "ET Total Rows");
        columns.put(KBROWSPERPAGE, "ET Rows Per Page");


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
        goToEmailTemplatePage();

        common.waitUntilElementToBeClickable(ETCREATE);
        common.click(ETCREATE);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(ETCREATEHEADER, "ET Email Body Label");
        columns.put(ETCTD, "ET Template Details");
        columns.put(ETCTNAME, "ET Template Name");
        columns.put(ETCTNAMEINPUT, "ET Name Input");
        columns.put(ETCCBTEXT, "ET Name info");
//        columns.put(ETCCBINPUT, "ET Checkbox");
        columns.put(ETCUPLOAD, "ET Upload");
        columns.put(ETCUPLOADINPUT, "ET Upload input");
        columns.put(ETCEMAILBODY, "ET Email Body Label");
        columns.put(ETCVAREMAIL, "ET Variable Email");
        columns.put(ETCVARPHONE, "ET Variable Phone Number");
        columns.put(ETCVARNAME, "ET Variable Name");
        columns.put(ETCVARCNAME, "ET Variable Company Name");
        columns.put(ETCVARNEW, "ET Variable Custom");
        columns.put(ETCVARINFO, "ET Variable Info Text");
        columns.put(ETCSUBJECT, "ET Subject Label");
        columns.put(ETCSUBJECTINPUT, "ET Subject Input Field");
        columns.put(ETCBODYTEXT, "ET Body Helper Text");
        columns.put(ETCBODYTOOL, "ET Body Toolbar");
        columns.put(ETCBODYINPUT, "ET Body Input Area");
        columns.put(ETCLIVEPREVIEW, "ET Live Preview Header");
        columns.put(ETCLPSUB, "ET Live Preview Subject");
        columns.put(ETCLPINFO, "ET Live Preview Footer Info");


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









}
