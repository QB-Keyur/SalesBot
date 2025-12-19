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

public class KnowledgeBasePage extends Locators {

    ReadProperties readProperties;
    Common common;

    public KnowledgeBasePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.readProperties = new ReadProperties();
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

    public void verifyEditElements(){
        goToKnowledgeBasePage();
        common.waitUntilElementToBeVisible(KBEDITBUTTON);
        common.click(KBEDITBUTTON);

        common.assertElementPresent(KBEDITHEADER);
        common.assertElementPresent(KBEDITINFO);
        common.assertElementPresent(KBCOMPLETEDS);
        common.assertElementPresent(KBEDITRESET);



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

    public String validateFileUpload(){
        goToKnowledgeBasePage();
        String filePath = "C:\\Users\\Admin\\Downloads\\1.pdf";

        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        String FakeName = common.fakeProductName();
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
        common.waitUntilElementToBeVisible(KBINPROGRESS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
        WebElement Completed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(KBCOMPLETED)));
        String CompletedValue = Completed.getText();
        if(CompletedValue.equals("Completed")){
            common.logPrint(CompletedValue);}
        return FakeName;

    }

    public String validateAddingText(){
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

        common.click(KBCADDTEXT);

        common.click(KBCSAVEBUTTON);

        waitForKBStatusAndEdit();
        return FakeName;

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
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCQABUTTON);
        common.click(KBCQABUTTON);

        common.waitUntilElementToBeVisible(KBCQATITLEINPUT);
        common.type(KBCQATITLEINPUT,"Test");

        common.waitUntilElementToBeVisible(KBCQATITLEQ1INPUT);
        common.type(KBCQATITLEQ1INPUT,"Question Test");

        common.waitUntilElementToBeVisible(KBCANSWERINPUT);
        common.type(KBCANSWERINPUT, "Answer Test");

        common.waitUntilElementToBeVisible(KBCQAADDBUTTON);
        common.click(KBCQAADDBUTTON);

        common.pause(5);


    }

    public void validateKBShowsUpInTheProduct(){
        String CreatedKB = validateFileUpload();
        String url = readProperties.getWebUrl();
        common.openNewUrl(url+ "product");
        common.waitUntilElementToBeVisible(CREATE);
        common.click(CREATE);

        common.waitUntilElementToBeVisible(PHPRODUCTKB);
        common.type(PHPRODUCTKB, CreatedKB);
        common.pause(3);
        String dropdownValue = "//li[normalize-space(text())='" + CreatedKB + "']";
        common.click(dropdownValue);
        common.pause(3);
        String SelectedText = common.getText("//div[@class='MuiButtonBase-root MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-deletable MuiChip-deletableColorDefault MuiChip-filledDefault MuiAutocomplete-tag MuiAutocomplete-tagSizeMedium css-1e4x4j6']");

        if(CreatedKB.equals(SelectedText)){
            common.logPrint("Created KB "+CreatedKB+" matches the "+SelectedText+" Selected KB");
        }else{
            common.logPrint("Created KB "+CreatedKB+" doesn't match the "+SelectedText+" Selected KB");
        }


    }

    public void validateEditingAKB(){
        validateFileUpload();



        }

    public void validatingMandatoryField(){
        goToKnowledgeBasePage();
        common.waitUntilElementToBeVisible(CREATE);
        common.click(CREATE);

        common.click(KBCSAVEBUTTON);
        common.assertElementPresent(KBCNAMEVALIDATION);

        common.click(KBCTEXTBUTTON);
        common.click(KBCADDTEXT);
        common.pause(1);
        common.assertElementPresent(KBCADDTEXTVALIDATION);
        common.click(KBCADDTEXTVALIDATIONCLOSE);

        common.click(KBCWEBSITEBUTTON);
        WebElement addLinkBtn = driver.findElement(
                By.xpath("//button[.//span[normalize-space()='Add Link']]")
        );

        String disabled = addLinkBtn.getAttribute("disabled");
        Assert.assertNotNull(disabled, "Add Link button is expected to be disabled");


        common.click(KBCQABUTTON);
        common.click(KBCQAADDBUTTON);
        common.assertElementPresent(KBCADDTEXTVALIDATION);
        common.click(KBCADDTEXTVALIDATIONCLOSE);





    }

    public String validatingMultipleFileUploads() {

        goToKnowledgeBasePage();

        String[] filePaths = {
                "C:\\Users\\Admin\\Downloads\\1.pdf",
                "C:\\Users\\Admin\\Downloads\\2.pdf",
                "C:\\Users\\Admin\\Downloads\\3.pdf"
        };

        // Create KB
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        String fakeName = common.fakeProductName();
        common.type(KBCNAMEINPUT, fakeName);

        // Upload files


        for (String filePath : filePaths) {
            common.click(KBCFILESUPLOADINPUT);
            common.pause(1);
            common.uploadFile(KBCFILESUPLOADINPUT, filePath);
        }

        common.pause(5);
        common.click(KBCSAVEBUTTON);

        // Search & validate created record
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(KBSEARCHBAR)));
        common.click(search);
        common.type(search, fakeName);

        String searchResult = "(//div[@aria-colindex='2' and @aria-rowspan='1'])[1]";
        common.validateSearch(searchResult, fakeName);

        // Validate status
        String statusXpath =
                "(//div[@data-colindex='3' and @aria-colindex='4'])[1]//span[normalize-space()='In Progress']";
        common.assertElementPresent(statusXpath);
        common.logPrint("Verified: Status shows 'In Progress'");

        // Wait until Completed

        WebElement completed =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(KBCOMPLETED)));

        Assert.assertEquals(completed.getText(), "Completed");

        // Click Edit
        common.click("//button[@aria-label='Edit']");

        // 🔥 FINAL VALIDATION: 1_, 2_, 3_ exist in UI
        for (String filePath : filePaths) {

            String fileName = Paths.get(filePath).getFileName().toString(); // 1.pdf
            String baseName = fileName.substring(0, fileName.lastIndexOf('.')); // 1
            String derivedValue = baseName + "_"; // 1_

            String dynamicXpath =
                    "//p[starts-with(normalize-space(text()),'" + derivedValue + "')]";

            common.logPrint("Validating presence of: " + derivedValue);
            common.waitUntilElementToBeVisible(dynamicXpath);
            common.assertElementPresent(dynamicXpath);
        }

        return fakeName;
    }

    public void validateAddingMultipleTexts(int numberOfTexts) {

        goToKnowledgeBasePage();
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCTEXTBUTTON);
        common.click(KBCTEXTBUTTON);

        String fakeName = common.fakeProductName();
        common.type(KBCNAMEINPUT, fakeName);

        for (int i = 1; i <= numberOfTexts; i++) {

            String fakeLabel = common.fakeProductName();
            String fakeDesc = common.generateCompanyDescription();

            common.waitUntilElementToBeVisible(KBCTEXTADDLABEL);
            common.type(KBCTEXTADDLABEL, fakeLabel);

            common.waitUntilElementToBeVisible(KBCDESCINPUT2);
            common.click(KBCDESCINPUT2);
            common.type(KBCDESCINPUT2, fakeDesc);

            common.click(KBCADDTEXT);
        }

        common.click(KBCSAVEBUTTON);

        common.waitUntilElementToBeVisible(KBSEARCHBAR);
        common.click(PHSEACRH);
        common.type(PHSEACRH, fakeName);

        String searchResult = "(//div[@aria-colindex='2' and @aria-rowspan='1'])[1]";
        common.validateSearch(searchResult, fakeName);

        common.waitUntilElementToBeVisible(KBCVALIDATE);

        // ✅ CENTRALIZED STATUS HANDLING
        waitForKBStatusAndEdit();
        common.click(KBEDITBUTTON);

        common.click(KBCTEXTBUTTON);

        List<WebElement> rows = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        Assert.assertEquals(rows.size(), numberOfTexts,
                "Mismatch in number of added texts");
    }

    public void validateDeletingMultipleTexts(int numberOfTexts) {

        goToKnowledgeBasePage();
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCTEXTBUTTON);
        common.click(KBCTEXTBUTTON);

        String fakeName = common.fakeProductName();
        common.type(KBCNAMEINPUT, fakeName);

        for (int i = 1; i <= numberOfTexts; i++) {

            String fakeLabel = common.fakeProductName();
            String fakeDesc = common.generateCompanyDescription();

            common.waitUntilElementToBeVisible(KBCTEXTADDLABEL);
            common.type(KBCTEXTADDLABEL, fakeLabel);

            common.waitUntilElementToBeVisible(KBCDESCINPUT2);
            common.click(KBCDESCINPUT2);
            common.type(KBCDESCINPUT2, fakeDesc);

            common.click(KBCADDTEXT);
        }

        common.click(KBCSAVEBUTTON);

        common.waitUntilElementToBeVisible(KBSEARCHBAR);
        common.click(PHSEACRH);
        common.type(PHSEACRH, fakeName);

        String searchResult = "(//div[@aria-colindex='2' and @aria-rowspan='1'])[1]";
        common.validateSearch(searchResult, fakeName);

        common.waitUntilElementToBeVisible(KBCVALIDATE);

        // ✅ CENTRALIZED STATUS HANDLING
        waitForKBStatusAndEdit();
        common.click(KBEDITBUTTON);

        common.click(KBCTEXTBUTTON);

        List<WebElement> rows = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        Assert.assertEquals(rows.size(), numberOfTexts,
                "Mismatch before deleting texts");

        for (int i = 1; i <= numberOfTexts; i++) {
            common.pause(1);
            common.click(KBDELETETEXT);
            common.pause(1);
            common.click(KBDELETEADDEDTEXT);
        }

        List<WebElement> rowsPostDelete = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        int rowsPostDeleteValue = rowsPostDelete.size()-1;

        Assert.assertEquals(rowsPostDeleteValue, 0,
                "Texts were not deleted successfully");
    }

    public void validateDeletingMultipleWebsites(int numberOfWebsites) {

        goToKnowledgeBasePage();
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCWEBSITEBUTTON);
        common.click(KBCWEBSITEBUTTON);

        String fakeName = common.fakeProductName();
        common.type(KBCNAMEINPUT, fakeName);

        for (int i = 1; i <= numberOfWebsites; i++) {

            String fakeDomain = common.fakeWebsite();
            common.type(KBCWEBINPUT, fakeDomain);

            common.waitUntilElementToBeVisible(KBCWEBADD);
            common.click(KBCWEBADD);
        }

        common.click(KBCSAVEBUTTON);

        common.waitUntilElementToBeVisible(KBSEARCHBAR);
        common.click(PHSEACRH);
        common.type(PHSEACRH, fakeName);

        String searchResult = "(//div[@aria-colindex='2' and @aria-rowspan='1'])[1]";
        common.validateSearch(searchResult, fakeName);

        common.waitUntilElementToBeVisible(KBCVALIDATE);


        waitForKBStatusAndEdit();
        common.click(KBEDITBUTTON);

        common.click(KBCWEBSITEBUTTON);

        List<WebElement> rows = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        Assert.assertEquals(rows.size(), numberOfWebsites,
                "Mismatch before deleting websites");

        for (int i = 1; i <= numberOfWebsites; i++) {
            common.pause(1);
            common.click(KBCWEBADDEDDELETE);
            common.pause(1);
            common.click(KBDELETEADDEDTEXT);
        }

        List<WebElement> rowsPostDelete = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        int rowsPostDeleteValue = rowsPostDelete.size()-1;

        Assert.assertEquals(rowsPostDeleteValue, 0,
                "Texts were not deleted successfully");
    }

    public void validateDeletingMultipleQA(int numberOfWebsites) {

        goToKnowledgeBasePage();
        common.waitUntilElementToBeClickable(KBCREATE);
        common.click(KBCREATE);

        common.waitUntilElementToBeVisible(KBCQABUTTON);
        common.click(KBCQABUTTON);

        String fakeName = common.fakeProductName();
        common.type(KBCNAMEINPUT, fakeName);

        for (int i = 1; i <= numberOfWebsites; i++) {

            common.waitUntilElementToBeVisible(KBCQATITLEINPUT);
            common.type(KBCQATITLEINPUT,"Test "+i);

            common.waitUntilElementToBeVisible(KBCQATITLEQ1INPUT);
            common.type(KBCQATITLEQ1INPUT,"Question Test "+i);

            common.waitUntilElementToBeVisible(KBCANSWERINPUT);
            common.type(KBCANSWERINPUT, "Answer Test "+i);

            common.waitUntilElementToBeVisible(KBCQAADDBUTTON);
            common.click(KBCQAADDBUTTON);


        }

        common.click(KBCSAVEBUTTON);

        common.waitUntilElementToBeVisible(KBSEARCHBAR);
        common.click(PHSEACRH);
        common.type(PHSEACRH, fakeName);

        String searchResult = "(//div[@aria-colindex='2' and @aria-rowspan='1'])[1]";
        common.validateSearch(searchResult, fakeName);

        common.waitUntilElementToBeVisible(KBCVALIDATE);


        waitForKBStatusAndEdit();
        common.click(KBEDITBUTTON);

        common.click(KBCQABUTTON);

        List<WebElement> rows = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        Assert.assertEquals(rows.size(), numberOfWebsites,
                "Mismatch before deleting websites");

        for (int i = 1; i <= numberOfWebsites; i++) {
            common.pause(1);
            common.click(KBCWEBADDEDDELETE);
            common.pause(1);
            common.click(KBDELETEADDEDTEXT);
        }

        List<WebElement> rowsPostDelete = driver.findElements(
                By.xpath("//tbody[contains(@class,'MuiTableBody-root')]//tr"));

        int rowsPostDeleteValue = rowsPostDelete.size()-1;

        Assert.assertEquals(rowsPostDeleteValue, 0,
                "Texts were not deleted successfully");
    }

    public void validatePagination() {
        goToKnowledgeBasePage();
        common.pagination();
    }

    public void validateView(){
        validateAddingText();
        String Name = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]";
        String Date = "//div[@aria-colindex=\"5\" and @aria-rowspan=\"1\"]";

       String EnteredName =  common.getText(Name);
       String EnteredDate =  common.getText(Date);

       common.waitUntilElementToBeVisible(KBVIEW);
       common.click(KBVIEW);

       String ViewName = common.getAttribute(KBVIEWINPUTNAME,"value");
       String ViewDate = common.getAttribute(KBVIEWINPUTDATE,"value");

       if(ViewName.equals(EnteredName) && ViewDate.equals(EnteredDate)){
           common.logPrint("Expected Name: "+EnteredName+ " Expected Date: "+EnteredDate+ "\n ViewName " +ViewName+ " ViewDate " +ViewDate );
           common.logPrint("View works as Expected");
       }
       else{
           common.logPrint("Expected Name "+EnteredName+ " Expected Date "+EnteredDate+ "\n ViewName " +ViewName+ " ViewDate " +ViewDate );
           common.logPrint("View doesn't work as Expected");
       }







    }

    public void validateResetButton(){
        goToKnowledgeBasePage();
        String expectedValue = validateAddingText();

        common.click(KBEDITBUTTON);

        common.click(KBCTEXTBUTTON);

        common.type(KBCNAMEINPUT, "TestResetName");

        common.click(KBEDITRESET);

       String afterReset =  common.getAttribute(KBCNAMEINPUT,"value");
       if(afterReset.equals(expectedValue)){
           common.logPrint("After reset: "+ afterReset+" it went back to "+expectedValue);
       }
       else{
           common.logPrint("After reset: "+ afterReset+" didn't work "+expectedValue);
       }



    }

    public void waitForKBStatusAndEdit() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));

        By inProgress = By.xpath(KBINPROGRESS);
        By completed = By.xpath(KBCOMPLETED);
        By failed = By.xpath(KBFAILED);

        // Wait until ANY status appears
        wait.until(d ->
                !d.findElements(inProgress).isEmpty() ||
                        !d.findElements(completed).isEmpty() ||
                        !d.findElements(failed).isEmpty()
        );

        // FAILED
        if (!driver.findElements(failed).isEmpty()) {
            common.logPrint("KB Upload failed");
            return;
        }

        // COMPLETED immediately
        if (!driver.findElements(completed).isEmpty()) {
            common.logPrint("Status is Completed");
            return;
        }

        // IN PROGRESS → wait for completion
        common.logPrint("Status is In Progress, waiting...");

        wait.until(d ->
                !d.findElements(completed).isEmpty() ||
                        !d.findElements(failed).isEmpty()
        );

        if (!driver.findElements(failed).isEmpty()) {
            common.logPrint("KB Upload failed");
            return;
        }

        common.logPrint("Status changed to Completed");

    }



    }
