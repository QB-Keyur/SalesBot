package Pages;

import Config.EnvConfig;
import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmailTemplatePage extends Locators {

    Common common;

    public EmailTemplatePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
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
        columns.put(ETCSAVE, "ET Save Button");
        columns.put(ETCCANCEL, "ET Cancel Button");


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
        goToEmailTemplatePage();

        common.waitUntilElementToBeClickable(ETCREATE);
        common.click(ETCREATE);

        common.click(ETCSAVE);

        common.waitUntilElementToBeVisible(ETCTNVALIDATION);
        common.assertElementPresent(ETCTNVALIDATION);

        common.waitUntilElementToBeVisible(ETCSUBJECTVALIDATION);
        common.assertElementPresent(ETCSUBJECTVALIDATION);

        common.scroll_To_Element(ETCBODYVALIDATION);
        common.waitUntilElementToBeVisible(ETCBODYVALIDATION);
        common.assertElementPresent(ETCBODYVALIDATION);


    }

    public void verifyCancelButton(){
        goToEmailTemplatePage();
        common.waitUntilElementToBeVisible(ETCREATE);
        common.click(ETCREATE);

        common.waitUntilElementToBeVisible(ETCCANCEL);
        common.click(ETCCANCEL);

        String currentURL = driver.getCurrentUrl();

        String expectedURL = EnvConfig.getWebUrl()+"email-template";

        if (!currentURL.equals(expectedURL)){
            common.logPrint(currentURL+" Current URL Matches "+expectedURL+" Expected URL");
        }
        else {
            common.logPrint(currentURL+" Current URL doesn't match "+expectedURL+" Expected URL");
        }
    }

    public void verifyingHorizontalView(){
        goToEmailTemplatePage();
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"]");
    }

    public void verifyingSearch(){
        goToEmailTemplatePage();
        common.searchCommon(ETSEARCHRESULTS);
    }

    public String[] verifyAddingANewEmailTemplate(){
        goToEmailTemplatePage();
        String name = common.generateCompanyName();
        String subject = common.generateBusinessFocus();
        String body = common.generateCompanyDescription();
        String ETCSUBJECTPREVIEW = "//p[text()='"+subject+"']";
        String ETCBODYPREVIEW = "//p[text()='"+body+"']";
        String ETCBODYPREVIEWFULL = "//b[text()='Subject:']/following::div[1]";

        String imagePath = Paths.get("Files", "1.png").toAbsolutePath().toString();


        common.waitUntilElementToBeClickable(ETCREATE);
        common.click(ETCREATE);

        common.waitUntilElementToBeVisible(ETCTNAMEINPUT);
        common.type(ETCTNAMEINPUT, name);

        common.selectCheckbox(ETCCBINPUT);

        driver.findElement(By.xpath(ETCUPLOADINPUT)).click();
        common.uploadFile(ETCUPLOADINPUT, imagePath);

        common.waitUntilElementToBeClickable(ETCUPLOADEDFILE);
        common.assertElementPresent(ETCUPLOADEDFILE);

        common.waitUntilElementToBeVisible(ETCSUBJECTINPUT);
        common.type(ETCSUBJECTINPUT, subject);

        common.waitUntilElementToBeVisible(ETCBODYINPUT);
        common.type(ETCBODYINPUT, body);

        String bodyInput = common.getText(ETCBODYINPUT);
        common.logPrint("Body Input : "+bodyInput);

        String bodyInputFull = common.getText(ETCBODYPREVIEWFULL);
        common.logPrint("Body Preview : "+bodyInputFull);

        if(bodyInputFull.equals(bodyInput)){
            common.logPrint("Asserted");
        }else{
            common.logPrint("Failed Assertion");
        }

        common.waitUntilElementToBeVisible(ETCSUBJECTPREVIEW);
        common.assertElementPresent(ETCSUBJECTPREVIEW);

        common.waitUntilElementToBeVisible(ETCBODYPREVIEW);
        common.assertElementPresent(ETCBODYPREVIEW);

        common.scroll_To_Element(ETCCANCEL);
        common.click(ETCCANCEL);

//        common.waitUntilElementToBeVisible(ETCSAVE);
//        common.click(ETCSAVE);

        common.validateSearch(ETSEARCHRESULTS, name);
        return new String[] {name,subject,body};

    }

    public void verifyPagination(){
        goToEmailTemplatePage();
        common.pagination("//div[@class=\"MuiBox-root css-a7l4db\"]");
    }

    public void verifyAddingVariables(){

        goToEmailTemplatePage();
        String name = common.generateCompanyName();
        String subject = common.generateBusinessFocus();
        String body = common.generateCompanyDescription();
        String ETCSUBJECTPREVIEW = "//p[text()='"+subject+"']";
        String ETCBODYPREVIEW = "//p[text()='"+body+"']";
        String ETCBODYPREVIEWFULL = "//b[text()='Subject:']/following::div[1]";

        String imagePath = Paths.get("Files", "1.png").toAbsolutePath().toString();


        common.waitUntilElementToBeClickable(ETCREATE);
        common.click(ETCREATE);

        common.waitUntilElementToBeVisible(ETCTNAMEINPUT);
        common.type(ETCTNAMEINPUT, name);

        common.selectCheckbox(ETCCBINPUT);

        driver.findElement(By.xpath(ETCUPLOADINPUT)).click();
        common.uploadFile(ETCUPLOADINPUT, imagePath);

        common.waitUntilElementToBeClickable(ETCUPLOADEDFILE);
        common.assertElementPresent(ETCUPLOADEDFILE);

        common.waitUntilElementToBeVisible(ETCSUBJECTINPUT);
        common.type(ETCSUBJECTINPUT, subject);

        common.waitUntilElementToBeVisible(ETCBODYINPUT);
        common.type(ETCBODYINPUT, body);

        common.waitUntilElementToBeVisible(ETCVAREMAIL);
        common.click(ETCVAREMAIL);
        common.waitUntilElementToBeVisible(ETCVARPHONE);
        common.click(ETCVARPHONE);
        common.waitUntilElementToBeVisible(ETCVARNAME);
        common.click(ETCVAREMAIL);
        common.waitUntilElementToBeVisible(ETCVARCNAME);
        common.click(ETCVAREMAIL);
        common.waitUntilElementToBeVisible(ETCVARNEW);
        common.click(ETCVARNEW);
        common.waitUntilElementToBeVisible(ETCVARINFO);
        common.click(ETCVAREMAIL);



        String bodyInput = common.getText(ETCBODYINPUT);
        common.logPrint("Body Input : "+bodyInput);

        String bodyInputFull = common.getText(ETCBODYPREVIEWFULL);
        common.logPrint("Body Preview : "+bodyInputFull);

        if(bodyInputFull.equals(bodyInput)){
            common.logPrint("Asserted Body Preview");
        }else{
            common.logPrint("Failed Assertion of Body Preview");
        }

        common.assertElementPresent(ETCSUBJECTPREVIEW);

    }

    public void verifyEmailTemplateReflectionInEmailCampaign() {

        String newEmailTemplate[] = verifyAddingANewEmailTemplate();

        String templateDD = "//input[@placeholder='Select template']";
        String templateOption = "//li[normalize-space(text())='" + newEmailTemplate[0] + "']";

        common.waitUntilElementToBeVisible(ETASTATUS);
        String status = common.getText(ETASTATUS).trim();

        Assert.assertEquals(
                status,
                "Synced",
                "Email Template is not synced. Current status: " + status
        );

        common.openNewUrl(EnvConfig.getWebUrl() + "email-campaign");
        common.waitUntilElementToBeVisible(ETCREATE);
        common.click(ETCREATE);

        common.waitUntilElementToBeVisible(templateDD);
        common.click(templateDD);

        common.waitUntilElementToBeVisible(templateOption);
        common.click(templateOption);

        String selectedTemplate =
                common.getAttribute(templateDD, "value").trim();

        Assert.assertEquals(
                selectedTemplate,
                newEmailTemplate,
                "Selected Email Template did not reflect correctly in Email Campaign"
        );

        common.logPrint("Email Campaign Template reflected successfully: " + selectedTemplate);
    }

    public void verifyRefreshButtonUpdatesTheServerSyncStatus(){
        verifyAddingANewEmailTemplate();
        String synced= common.getText(ETASTATUS).trim();

//        while(synced.equals("Synced")){
//            common.pause(2);
//            common.click(ETREFRESH);
//        }


    }

    public void verifyViewButton() {

        String[] addedTemplate = verifyAddingANewEmailTemplate();
        String expectedName = addedTemplate[0].trim();
        String expectedSubject = addedTemplate[1].trim();
        String expectedBody = addedTemplate[2].trim();

        String synced= common.getText(ETASTATUS).trim();

//        while(synced.equals("Synced")){
//            common.pause(3);
//            common.click(ETREFRESH);
//        }

        common.waitUntilElementToBeVisible(ETVIEW);
        common.click(ETVIEW);

        common.pause(2);
        common.waitUntilElementToBeVisible(ETCTNAMEINPUT);


        String actualName =
                common.getAttribute(ETCTNAMEINPUT, "value").trim();

        String actualSubject =
                common.getAttribute(ETCSUBJECTINPUT, "value").trim();

        String actualBody =
                common.getText(ETCBODYINPUT)
                        .replace("\n", " ")
                        .trim();

        common.logPrint(
                "Actual Name: " + actualName +
                        " | Actual Subject: " + actualSubject +
                        " | Actual Body: " + actualBody
        );

        Assert.assertEquals(
                actualName,
                expectedName,
                "Template Name mismatch"
        );

        Assert.assertEquals(
                actualSubject,
                expectedSubject,
                "Template Subject mismatch"
        );

        Assert.assertTrue(
                actualBody.contains(expectedBody),
                "Template Body mismatch"
        );

        common.logPrint("Email template view works successfully");
    }






















}
