package Pages;

import Config.EnvConfig;
import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmailCampaignPage extends Locators {

    Common common;

    public EmailCampaignPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToEmailCampaignPage() {
        String expectedURL = EnvConfig.getWebUrl() + "email-campaign";

        common.waitUntilElementToBeVisible(CAMPAIGNMENU);
        common.click(CAMPAIGNMENU);

        common.waitUntilElementToBeVisible(EMIALCAMPAIGNMENU);
        common.click(EMIALCAMPAIGNMENU);

        common.assertElementPresent(ECHEADER);

        String currentURL = driver.getCurrentUrl();

        if(expectedURL.equals(currentURL)){
            common.logPrint("Email Campaign Page Successfully Loaded Expected: " + expectedURL+" Actual: " + currentURL);
        }
        else {
            common.logPrint("Email Campaign Page Failed: " + expectedURL+" Actual: " + currentURL);
        }



    }

    public void verifyEmailCampaignElements() {

        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        Map<String, String> columns = new LinkedHashMap<>();


        columns.put(CAMPAIGNMENU, "Campaign Menu");
        columns.put(EMIALCAMPAIGNMENU, "Email Campaign Menu");
        columns.put(ECHEADER, "Email Campaign Header");

        columns.put(ECSEARCHBAR, "Email Campaign Search");
        columns.put(REFRESH, "Email Campaign Refresh");
        columns.put(FILTERS, "Email Campaign Filters");
        columns.put(ECCREATEBUTTON, "Email Campaign Create");
        columns.put(MULTITABHOR, "Email Campaign Horizontal View");
        columns.put(MULTITABVER, "Email Campaign Vertical View");

        columns.put(ECSR, "Email Campaign SR No");
        columns.put(ECNAME, "Email Campaign Name");
        columns.put(ECCATEGORY, "Email Campaign Category");
        columns.put(ECPRODUCT, "Email Campaign Product");
        columns.put(ECEMAIL, "Email Campaign Integration Email");
        columns.put(ECCONTACT, "Email Campaign Contact");
//        columns.put(ECCONTACTGROUP, "Email Campaign Contact Group");
        columns.put(ECAI, "Email Campaign Enable AI");
        columns.put(ECSTATUS, "Email Campaign Status");
        columns.put(ECACTION, "Email Campaign Actions");


//        columns.put(KBTOTALROWS, "Email Campaign Total Rows");
//        columns.put(KBROWSPERPAGE, "Email Campaign Rows Per Page");


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

    public void verifyEmailCampaignCreatePageElements() {
        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        Map<String, String> columns = new LinkedHashMap<>();


        columns.put(ECCHEADER, "Create Email Campaign Header");
        columns.put(ECCCAMPAIGNDETAILS, "Create Email Campaign Details Section");

        columns.put(ECCCAMPAIGNNAME, "Create Email Campaign Name");
        columns.put(ECCCAMPAIGNTEMPLATE, "Create Email Campaign Template");
        columns.put(ECCCAMPAIGNCATEGORY, "Create Email Campaign Category");
        columns.put(ECCCAMPAIGNPRODUCT, "Create Email Campaign Product");
        columns.put(ECCCAMPAIGNCONTACTGROUP, "Create Email Campaign Contact Group");
        columns.put(ECCNAMEINPUT, "Create Email Campaign Name Input");
        columns.put(ECCTEMPLATEINPUT, "Create Email Campaign Template Input");
        columns.put(ECCCATEGORYINPUT, "Create Email Campaign Category Input");
        columns.put(ECCPRODUCTINPUT, "Create Email Campaign Product Input");

//        columns.put(ECCVIEW, "Create Email Campaign View Button");

        common.scroll_To_Element(ECCMESSAGECONTENT);
        columns.put(ECCMESSAGECONTENT, "Create Email Campaign Message Content");
        columns.put(ECCSUBJECT, "Create Email Campaign Subject Label");
        columns.put(ECCSUBJECTNPUT, "Create Email Campaign Subject Input");

        columns.put(ECCBODY, "Create Email Campaign Body Label");
        columns.put(ECCBODYTOOLBAR, "Create Email Campaign Body Toolbar");
        columns.put(ECCTEMPLATEBODY, "Create Email Campaign Template Body");

        columns.put(ECCENABLEAI, "Create Email Campaign Enable AI");
        columns.put(ECCENABLEAIYES, "Create Email Campaign Enable AI Yes");
        columns.put(ECCENABLEAINO, "Create Email Campaign Enable AI No");

        common.scroll_To_Element(ECCCONTACTS);
        columns.put(ECCCONTACTS, "Create Email Campaign Contacts Section");
        columns.put(ECCSEARCHCONTACTS, "Create Email Campaign Search Contacts");
        columns.put(ECCCHECKBOX, "Create Email Campaign Contact Checkbox");

        columns.put(ECCSRNO, "Create Email Campaign Contact SR No");
        columns.put(ECCNAME, "Create Email Campaign Contact Name");
        columns.put(ECCCONTACTGROUP, "Create Email Campaign Contact Group Column");
        columns.put(ECCPHONE, "Create Email Campaign Contact Phone");
        columns.put(ECCEMAIL, "Create Email Campaign Contact Email");

        common.scroll_To_Element(ECCTOTALROWS);
        columns.put(ECCTOTALROWS, "Create Email Campaign Total Rows");
        columns.put(ECCROWSPERPAGE, "Create Email Campaign Rows Per Page");
        columns.put(ECCPREVIOUSPAGE, "Create Email Campaign Previous Page");
        columns.put(ECCNEXTPAGE, "Create Email Campaign Next Page");



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

    public void verifySearch() {
        goToEmailCampaignPage();
        common.waitUntilElementToBeVisible("//tbody/tr[1]/td[2]");
        common.searchCommon("//tbody/tr[1]/td[2]");
    }

    public void verifyHorizontalView() {

        goToEmailCampaignPage();
        common.validateHorizontalViewCardCount("//h6[text()='Email Campaign']/following::div[1]");

    }

    public void verifyPagination() {
        goToEmailCampaignPage();
        common.pagination("//h6[text()='Email Campaign']/following::div[1]");
    }

    public void verifyPaginationInsideCreate() {
        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.scroll_To_Element(ECCROWSPERPAGE);
        common.pagination("//p[text()='Contacts']/div");
//        common.waitUntilElementToBeVisible("//div[@class=\"MuiBox-root css-10u381a\"]");
//        common.paginationForLargePageSizes("//div[@class=\"MuiBox-root css-10u381a\"]");
    }

    public void verifyPaginationInsideViewContact() {

        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.waitUntilElementToBeVisible(ECCVIEW);
        common.click(ECCVIEW);
        common.paginationInsideActiveModal();
    }

    public void verifyRunningANewEmailCampaign() {
        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.waitUntilElementToBeVisible(ECCNAMEINPUT);
        common.click(ECCNAMEINPUT);
        common.type(ECCNAMEINPUT, "Name");

        common.waitUntilElementToBeVisible(ECCTEMPLATEINPUT);
        common.click(ECCTEMPLATEINPUT);
        common.twoDownKeyAndEnter();
//        common.selectRandomDropDownValue(ECCDROPDOWNLIST);

        common.waitUntilElementToBeVisible(ECCCATEGORYINPUT);
        common.click(ECCCATEGORYINPUT);
        common.twoDownKeyAndEnter();
//        common.selectRandomDropDownValue(ECCDROPDOWNLIST);

        common.waitUntilElementToBeVisible(ECCPRODUCTINPUT);
        common.click(ECCPRODUCTINPUT);
        common.twoDownKeyAndEnter();
//        common.selectRandomDropDownValue(ECCDROPDOWNLIST);

        common.waitUntilElementToBeVisible(ECCCAMPAIGNCONTACTGROUP);
        common.click(ECCCAMPAIGNCONTACTGROUP);
        common.twoDownKeyAndEnter();
//        common.selectRandomDropDownValue(ECCCAMPAIGNCONTACTGROUP);

        String selectedTemplateSubject = common.getAttribute(ECCSUBJECTNPUT,"value");
        if (selectedTemplateSubject != null) {
            common.logPrint("Selected Template Subject: " + selectedTemplateSubject);
        }

        if(common.isElementDisplayed(ECCBODYVALUE)){
            common.logPrint("Selected Template Body is Displayed");
        }

        common.scroll_To_Element(ECCENABLEAI);
        common.click(ECCENABLEAIYES);

        common.scroll_To_Element(ECCROWSPERPAGE);

        common.selectRandomRowCheckbox();

    }

    public void verifySearchInsideCreate() {

        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.scroll_To_Element(ECCSEARCHCONTACTS);
        common.waitUntilElementToBeVisible(ECCSEARCHCONTACTS);

        By ROW_LOCATOR = By.xpath("(//tbody)[2]/tr");

        common.waitUntilElementToBeVisible(ROW_LOCATOR);
        common.pause(3);

        List<WebElement> rows = driver.findElements(ROW_LOCATOR);

        if (rows.isEmpty()) {
            throw new RuntimeException("No contact rows found in Create Email Campaign grid");
        } else {
            common.logPrint("Rows count: " + rows.size());
        }

        int randomIndex = new Random().nextInt(rows.size());

        common.logPrint("Random Index: " + randomIndex);

        // ✅ Get row element
        WebElement randomRow = rows.get(randomIndex);

        // ✅ Get 3rd column text
        WebElement cell = randomRow.findElement(By.xpath("./td[3]"));
        String rowText = cell.getText().trim();

        common.logPrint("Row Text: " + rowText);

        // ✅ Now type actual value
        common.type(ECCSEARCHCONTACTS, rowText);

        common.pause(1);

        common.waitUntilElementToBeVisible(ECCSEARCHCONTACTSVALUE);

        common.validateSearch(ECCSEARCHCONTACTSVALUE, rowText);
    }

    public void verifyRunningABlankCampaign() {
        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.waitUntilElementToBeVisible(ECCRUNCAMPAIGN);
        common.click(ECCRUNCAMPAIGN);

        common.assertElementPresent(ECCPOPUPTEXT1);
        common.assertElementPresent(ECCPOPUPTEXT2);
        common.assertElementPresent(ECCPOPUPNO);
        common.assertElementPresent(ECCPOPUPYES);

        common.click(ECCPOPUPNO);

        if(common.isElementDisplayed(ECCRUNCAMPAIGN)){
            common.logPrint("No button from pop-up works");
        }

        common.waitUntilElementToBeVisible(ECCRUNCAMPAIGN);
        common.click(ECCRUNCAMPAIGN);

        common.click(ECCPOPUPYES);

        common.waitUntilElementToBeVisible(ECCNAMEVAL);
        common.assertElementPresent(ECCNAMEVAL);
        common.assertElementPresent(ECCEMAILVAL);
        common.assertElementPresent(ECCCATEGORYVAL);
        common.assertElementPresent(ECCPRODUCTVAL);

    }

    public void verifyCancelButton() {

        goToEmailCampaignPage();

        String expectedURL = EnvConfig.getWebUrl() + "email-campaign";

        common.waitUntilElementToBeClickable(ECCREATEBUTTON);
        common.click(ECCREATEBUTTON);

        common.waitUntilElementToBeClickable(ECCCANCEL);
        common.click(ECCCANCEL);

        common.pause2Sec();

        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(
                currentURL,
                expectedURL,
                "Cancel button did NOT navigate back to Email Campaign page"
        );

        common.logPrint(
                "Email Campaign Page Successfully loaded after Cancel. URL: " + currentURL
        );
    }

    public void viewEmailCampaign() {
        goToEmailCampaignPage();

        String firstRow = "//div[@data-rowindex=\"0\"]|//tbody/tr[1]";
        String firstRowView = "(//button[@aria-label=\"View\"])[1]| //tr[1]//button";

        common.pause(10);
        common.waitUntilElementToBeVisible(firstRow);
         String name =common.getText( "//div[@data-rowindex=\"0\"]/child::div[@data-field=\"name\"] |//tr[1]/td[2]");

        String catName = common.getText("//div[@data-rowindex=\"0\"]/child::div[@data-field=\"category__name\"] |//tr[1]/td[3]");

        String desc = common.getText("//div[@data-rowindex=\"0\"]/child::div[@data-field=\"product__name\"] | //tr[1]/td[4]");

        common.waitUntilElementToBeVisible(firstRow);
        if(!common.isElementDisplayed(firstRow)){
        common.logPrint("No Data Found: ");
        }
        common.click(firstRowView);
        common.scroll_To_Element("//p[text()='Campaign Details']");
        common.pause(10);
        common.waitUntilElementToBeVisible("//span[text()='Campaign Name']/following::input[1]");

        String nameInput = common.getAttribute("//span[text()='Name']/following::input[1]|//span[text()='Campaign Name']/following::input[1]","value");
        String catNameInput = common.getAttribute("//span[text()='Name']/following::input[2]|//span[text()='Campaign Name']/following::input[3]","value");
        String descInput = common.getAttribute("//span[text()='Name']/following::input[4]|//span[text()='Campaign Name']/following::input[4]","value");



        common.logPrint("Grid values -> Name: " + name + ", Category: " + catName + ", Product: " + desc);
        common.logPrint("View values -> Name: " + nameInput + ", Category: " + catNameInput + ", Product: " + descInput);

        if (nameInput.equals(name) && catNameInput.equals(catName) && descInput.equals(desc)) {
            common.logPrint("Email Campaign Page successfully loaded after View. Name, Category, and Product values match.");
        } else {
            common.logPrint("Email Campaign Page view validation failed. Expected Name: " + name + ", Actual Name: " + nameInput
                    + " | Expected Category: " + catName + ", Actual Category: " + catNameInput
                    + " | Expected Product: " + desc + ", Actual Product: " + descInput);
        }
        



    }

    public void verifyFilters() {

        goToEmailCampaignPage();

        String emailCampaignName = "//div[@data-rowindex=\"0\"]/child::div[@data-field=\"name\"]|//tbody/tr[1]/td[2]";
        String  emailCampaignIntegration = "//div[@data-rowindex=\"0\"]/child::div[@data-field=\"integration_email\"]|//tbody/tr[1]/td[5]";

        common.waitUntilElementToBeVisible(emailCampaignName);
        String emailCampaignNameValue = common.getText(emailCampaignName);

        common.waitUntilElementToBeVisible(emailCampaignIntegration);
        String emailCampaignIntegrationValue = common.getText(emailCampaignIntegration);

        common.filters("Name", emailCampaignNameValue);
        common.filters("Integration Email", emailCampaignIntegrationValue);

    }

}

