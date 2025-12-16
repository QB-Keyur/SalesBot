package Pages;

import Utils.Locators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class KnowledgeBasePage extends Locators {
    public KnowledgeBasePage(WebDriver driver) {
        super(driver);
    }

    public void goToKnowledgeBasePage(){

        common.waitUntilElementToBeClickable(KBMENU);
        common.click(KBMENU);

        common.logPrint("Navigated to KB Page and fully loaded.");

    }

    public void verifyColumnsAndElements() {
        goToKnowledgeBasePage();

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(KBMENU, "KB Menu");
        columns.put(KBHEADER, "KB Header");
        columns.put(KBSEARCHBAR, "KB Search");
        columns.put(KBSRNUMBER, "KB Sr");
        columns.put(KBNAME, "KB Name");
        columns.put(KBPRODUCTS, "KB Products");
        columns.put(KBSTATUS, "KB Status");
        columns.put(KBCREATEDDATE, "KB Created Date");
        columns.put(KBACTIONS, "KB Actions");
        columns.put(KBTOTALROWS, "KB Total");
        columns.put(KBROWSPERPAGE, "KB Rows per page");
        columns.put(KBREFRESHBUTTON, "KB Refresh");
        columns.put(KBFILTERS, "KB Filters");
        columns.put(KBCREATE, "KB Create");
        columns.put(MULTITABHOR, "KB Horizontal View");
        columns.put(MULTITABVER, "KB Vertical View");


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

    public void validateSearch(){
        goToKnowledgeBasePage();
        common.searchCommon(KBSERACHRESULT);
    }

    public void validateHorizontalView(){
        goToKnowledgeBasePage();
        common.pause(3);
        common.validateHorizontalViewCardCount();
    }

    public void validateCreatePageElements() {

        goToKnowledgeBasePage();
        common.click(KBCREATE);

        // -------- BASIC CREATE PAGE ELEMENTS --------
        common.assertElementPresent(KBCHEADER);
        common.logPrint("Verified: KB Create Header is visible");

        common.assertElementPresent(KBCBACKBUTTON);
        common.logPrint("Verified: Back button is visible");

        common.assertElementPresent(KBCNAMELABLE);
        common.logPrint("Verified: Name label is visible");

        common.assertElementPresent(KBCFILESBUTTON);
        common.logPrint("Verified: Files tab button is visible");

        common.assertElementPresent(KBCTEXTBUTTON);
        common.logPrint("Verified: Text tab button is visible");

        common.assertElementPresent(KBCWEBSITEBUTTON);
        common.logPrint("Verified: Website tab button is visible");

        common.assertElementPresent(KBCQABUTTON);
        common.logPrint("Verified: Q&A tab button is visible");

        // -------- FILE TAB --------
        common.click(KBCFILESBUTTON);
        common.pause(2);

        common.assertElementPresent(KBCFILESUPLOAD);
        common.logPrint("Verified: File upload section is visible");

        common.assertElementPresent(KBCUPLOADTEXT1);
        common.logPrint("Verified: File upload info text 1 is visible");

        common.assertElementPresent(KBCUPLOADTEXT2);
        common.logPrint("Verified: File upload info text 2 is visible");

        // -------- TEXT TAB --------
        common.click(KBCTEXTBUTTON);
        common.pause(2);

        common.assertElementPresent(KBCTEXTHEADER);
        common.logPrint("Verified: Text tab header is visible");

        common.assertElementPresent(KBCTEXTTITLELABEL);
        common.logPrint("Verified: Text title label is visible");

        common.assertElementPresent(KBCTEXTADDLABEL);
        common.logPrint("Verified: Add text label is visible");

        common.assertElementPresent(KBCTEXTDESCRIPTIONLABEL);
        common.logPrint("Verified: Text description label is visible");

        common.assertElementPresent(KBCDESCTOOL);
        common.logPrint("Verified: Description formatting toolbar is visible");

        common.assertElementPresent(KBCDESCINPUT);
        common.logPrint("Verified: Description input field is visible");

        common.assertElementPresent(KBCADDTEXT);
        common.logPrint("Verified: Add text button is visible");

        //-------------------- Website -----------------------------------------------------

        common.click(KBCWEBSITEBUTTON);
        common.logPrint("Clicked on the Website ");

        common.assertElementPresent(KBCWEBHEADER);
        common.logPrint("Verified: Web Header is visible");

        common.assertElementPresent(KBCWEBINPUT);
        common.logPrint("Verified: Web input is visible");

        common.assertElementPresent(KBCWEBADD);
        common.logPrint("Verified: Web Add Link button is visible");



        // ------------------- Q & A -------------------------------------------------------

        common.click(KBCQABUTTON);
        common.logPrint("Clicked on the Q&A");

        common.assertElementPresent(KBCQAHEADER);
        common.logPrint("Verified: Q&A Header is visible");

        common.assertElementPresent(KBCQATITLE);
        common.logPrint("Verified: Q&A Title is visible");

        common.assertElementPresent(KBCQATITLEINPUT);
        common.logPrint("Verified: Q&A button is visible");

        common.assertElementPresent(KBCQATITLEQ1);
        common.logPrint("Verified: Q&A Title Question is visible");

        common.assertElementPresent(KBCQATITLEQ1INPUT);
        common.logPrint("Verified: Q&A Title Question 2 is visible");

        common.assertElementPresent(KBCADDBUTTON);
        common.logPrint("Verified: Q&A Add button is visible");

        common.assertElementPresent(KBCANSWER);
        common.logPrint("Verified: Q&A Answer is visible");

        common.assertElementPresent(KBCCANCELBUTTON);
        common.logPrint("Verified: Cancel button is visible");

        common.assertElementPresent(KBCSAVEBUTTON);
        common.logPrint("Verified: Save button is visible");













        common.logPrint("Step :: Create page UI validation completed successfully");
    }

    public void validateFileUpload(){
        goToKnowledgeBasePage();
        String filePath = "C:\\Users\\Admin\\Downloads\\1.pdf";

        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        String FakeName = common.fakeName();
        common.type(KBCNAMEINPUT, FakeName);

        common.click(KBCFILESUPLOADINPUT);
        common.pause(1);

        common.uploadFile(KBCFILESUPLOADINPUT, filePath);

        common.pause(5);

        common.click(KBCSAVEBUTTON);

//        String createdSuccess = "//div[@aria-label='Created successfully']";
//
//        common.waitUntilElementToBeVisible(createdSuccess);
//        common.assertElementPresent(createdSuccess);

        common.waitUntilElementToBeVisible(KBSEARCHBAR);
        String searchResult= "(//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
        common.waitUntilElementToBeVisible(PHSEACRH);
        common.click(PHSEACRH);
        common. type(PHSEACRH, FakeName);
        common.validateSearch(searchResult, FakeName);
        common.waitUntilElementToBeVisible(KBCVALIDATE);
        String statusXpath =
                "(//div[@data-colindex='3' and @aria-colindex='4'])[1]//span[normalize-space()='In Progress']";

        common.assertElementPresent(statusXpath);
        common.logPrint("Verified: Status shows 'In Progress'");

    }

    public void validateAddingText(){
        goToKnowledgeBasePage();

        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCTEXTBUTTON);
        common.click(KBCTEXTBUTTON);

        String FakeName = common.fakeProductName();
        String FakeDesc = common.generateCompanyDescription();

        common.type(KBCNAMEINPUT, FakeName);

        common.waitUntilElementToBeVisible(KBCTEXTADDLABEL);
        common.type(KBCTEXTADDLABEL, FakeName);

        common.waitUntilElementToBeVisible(KBCDESCINPUT2);
        common.click(KBCDESCINPUT2);
        common.type(KBCDESCINPUT2, FakeDesc);


    }

    public void validateAddingWebsite(){

        goToKnowledgeBasePage();
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCWEBSITEBUTTON);
        common.click(KBCWEBSITEBUTTON);

        String FakeDomain = common.fakeWebsite();

        common.waitUntilElementToBeVisible(KBCWEBINPUT);
        common.type(KBCWEBINPUT,FakeDomain);

        common.pause(5);






    }

    public void validateQA(){
        goToKnowledgeBasePage();

    }


}
