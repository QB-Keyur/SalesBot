package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class CompanyPortfolioPage extends Locators {

    Common common;

    public CompanyPortfolioPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToCompanyPortfolioPage(){

        common.waitUntilElementToBeVisible(COMPANYSIDEBAR);
        common.click(COMPANYSIDEBAR);

        common.waitUntilElementToBeVisible(COMPANYPORTFOLIO);
        common.click(COMPANYPORTFOLIO);

        common.waitUntilElementToBeVisible(CPHEADER);
        common.logPrint(CPHEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl()+"company-portfolio";

        if(curUrl.equals(expectedURL)){
            common.logPrint("Passed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
        else{
            common.logPrint("Failed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
    }

    public void verifyCompanyPortfolioPageElements(){
        goToCompanyPortfolioPage();

        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(CPHEADER,     "Company Portfolio Page Header");

        columns.put(CPSEARCH,     "Company Portfolio Search Bar");
        columns.put(CPFILTER,     "Company Portfolio Filter Button");
        columns.put(CPREFRESH,    "Company Portfolio Refresh Button");
        columns.put(CPCREATEBTN,  "Company Portfolio Create Button");

        columns.put(CPSR,         "Company Portfolio Serial Number Column");
        columns.put(CPDESC,       "Company Portfolio Description Column");
        columns.put(CPCREATEDATE, "Company Portfolio Created Date Column");
        columns.put(CPACTION,     "Company Portfolio Actions Column");

        columns.put(CPSHOWTEXT,   "Company Portfolio Show Rows Text");
        columns.put(CPROWSINPUT,  "Company Portfolio Rows Per Page Input");
        columns.put(CPPREVBTN,    "Company Portfolio Previous Page Button");
        columns.put(CPNEXTBTN,    "Company Portfolio Next Page Button");



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

    public void verifyCompanyPortfolioCreatePageElements(){
        goToCompanyPortfolioPage();

        common.waitUntilElementToBeVisible(ECSEARCHBAR);
        common.waitUntilElementToBeVisible(CPCREATEBTN);
        common.click(CPCREATEBTN);

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(CPCHEADER,      "Create Company Portfolio Page Header");
        columns.put(CPCBACKBUTTON, "Create Company Portfolio Back Button");

        columns.put(CPCANCELBTN,    "Create Company Portfolio Cancel Button");
        columns.put(CPCSAVEBTN,     "Create Company Portfolio Save Button");

        columns.put(CPCNAMELABEL,   "Create Company Portfolio Name Label");
        columns.put(CPCDESC,        "Create Company Portfolio Description Label");
        columns.put(CPCNAMEINPUT,        "Create Company Portfolio Name Input");
        columns.put(CPCDESCINPUT,        "Create Company Portfolio Description Input");



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

    public String[] verifyAddingACompanyPortfolio(){
        goToCompanyPortfolioPage();

        String name = common.fakeProductName();
        String desc = common.generateCompanyDescription();

        common.waitUntilElementToBeVisible(CPCREATEBTN);
        common.click(CPCREATEBTN);

        common.waitUntilElementToBeVisible(CPCNAMEINPUT);
        common.type(CPCNAMEINPUT,name);

        common.waitUntilElementToBeVisible(CPCDESCINPUT);
        common.type(CPCDESCINPUT, desc);

        common.waitUntilElementToBeVisible(CPCSAVEBTN);
        common.click(CPCSAVEBTN);

        common.waitUntilElementToBeVisible(CPCSUCESS);
        common.assertElementPresent(CPCSUCESS);

        common.waitUntilElementToBeVisible(CPSEARCH);
        common.type(CPSEARCH,name);

        common.validateSearch(CPSEARCHRESULT,name);

        return new String[]{name,desc};
    }

    public void verifyViewingACompanyPortfolio(){
        String[] addedPortfolio = verifyAddingACompanyPortfolio();

        String givenName = addedPortfolio[0];
        String givenDesc = addedPortfolio[1];

        common.waitUntilElementToBeVisible(CPVIEWBTN);
        common.click(CPVIEWBTN);


        common.waitUntilElementToBeVisible(CVIEWHEADER);
        common.pause(1);
        String actualName        = common.getAttribute(CPCNAMEINPUT, "value");
        String actualDesc = common.getText(CPCDESCINPUTVIEW);

        Assert.assertEquals(givenName, actualName,
                "Mismatch in Company Portfolio Name");
        Assert.assertEquals(givenDesc, actualDesc,
                "Mismatch in Company Portfolio Designation");

        common.logPrint("View Company Portfolio details verified successfully");




    }

    public String[] verifyEditingACompanyPortfolio() {

        String[] addedManagement = verifyAddingACompanyPortfolio();

        String expectedName = addedManagement[0].toLowerCase();
        String expectedDesc = addedManagement[1].toLowerCase();

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.waitUntilElementToBeVisible(CPCEDITHEADER);

        common.pause(2);
        String oldName        = common.getAttribute(CPCNAMEINPUT, "value").toLowerCase();
        String oldDesignation = common.getAttribute(CPCDESCINPUT, "value").toLowerCase();

        Assert.assertEquals(oldName, expectedName, "Pre-edit name mismatch");
        Assert.assertEquals(oldDesignation, expectedDesc, "Pre-edit designation mismatch");

        Faker faker = new Faker(new Locale("en", "IN"));

        String newName = faker.commerce().productName().toLowerCase();
        String newDesc  = common.generateCompanyDescription();

        common.waitUntilElementToBeClickable(CPCNAMEINPUT);
        common.type(CPCNAMEINPUT,newName);

        common.waitUntilElementToBeClickable(CPCDESCINPUT);
        common.type(CPCDESCINPUT,newDesc);

        common.click(CCSAVEBTN);

        common.assertElementPresent(CPCEDITMSG);
        common.waitUntilElementToBeVisible(CPHEADER);

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.waitUntilElementToBeVisible(CPCEDITHEADER);

        common.pause(2);
        String updatedName        = common.getAttribute(CCNAMEINPUT, "value").toLowerCase();
        String updatedDesignation = common.getAttribute(CPCDESCINPUT, "value").toLowerCase();

        Assert.assertNotEquals(updatedName, expectedName, "Name did not change after edit");
        Assert.assertNotEquals(updatedDesignation, newDesc, "Desc did not change after edit");

        common.logPrint("Company Management edit verified successfully");

        return new String[]{
                newName,
                newDesc,
        };
    }

    public void verifyDeletingACompanyPortfolio(){
        verifyAddingACompanyPortfolio();

        common.waitUntilElementToBeClickable(CMGMTDELETEBTN);
        common.click(CMGMTDELETEBTN);

        common.assertElementPresent(CPDELETE1);
        common.assertElementPresent(CPDELETE2);
        common.assertElementPresent(CPDELETECANCEL);
        common.assertElementPresent(CPDELETEDELETE);

        common.click(CDELETEMSGCANCEL);

        common.waitUntilElementToBeClickable(CDELETEMSGDELETE);
        common.click(CMGMTDELETEBTN);

        common.click(CDELETEMSGDELETE);

        common.assertElementPresent(DeletedSuccessfully);
    }

    public void validateHorizontalCardView(){
        goToCompanyPortfolioPage();
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"]");
    }

    public void validatePagination(){
        goToCompanyPortfolioPage();
        common.pagination("//div[@class=\"MuiBox-root css-a7l4db\"]");
    }




}