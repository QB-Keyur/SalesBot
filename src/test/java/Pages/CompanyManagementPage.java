package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class CompanyManagementPage extends Locators {

    Common common;

    public CompanyManagementPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToCompanyManagementPage() {
        common.waitUntilElementToBeVisible(COMPANYSIDEBAR);
        common.click(COMPANYSIDEBAR);

        common.waitUntilElementToBeVisible(COMPMGMTBTN);
        common.click(COMPMGMTBTN);

        common.waitUntilElementToBeVisible(CMGMTHEADER);
        common.logPrint(CMGMTHEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl()+"company-management";

        if(curUrl.equals(expectedURL)){
            common.logPrint("Passed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
        else{
            common.logPrint("Failed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
    }

    public void verifyCompanyManagementElements(){
        goToCompanyManagementPage();

        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        Map<String, String> columns = new LinkedHashMap<>();


        columns.put(COMPANYSIDEBAR,   "Company Sidebar Menu");
        columns.put(COMPMGMTBTN,      "Company Management Menu Button");
        columns.put(CMGMTHEADER,      "Company Management Page Header");
        columns.put(CMGMTTOTAL,       "Company Management Total Records");

        columns.put(CMGMTSEARCH,      "Company Management Search Bar");
        columns.put(CMGMTFILTER,      "Company Management Filter Button");
        columns.put(CMGMTREFRESH,     "Company Management Refresh Button");
        columns.put(CMGMTCREATEBTN,   "Company Management Create Button");
        columns.put(MULTITABHOR, "Email Campaign Horizontal View");
        columns.put(MULTITABVER, "Email Campaign Vertical View");

        columns.put(CMGMTSR,          "Company Management Serial Number Column");
        columns.put(CMGMTNAME,        "Company Management Name Column");
        columns.put(CMGMTDESIGNATION, "Company Management Designation Column");
        columns.put(CMGMTEMAIL,       "Company Management Email Column");
        columns.put(CMGMTPHONE,       "Company Management Phone Number Column");
        columns.put(CMGMTCREATEDDATE, "Company Management Created Date Column");
        columns.put(CMGMTACTIONS,     "Company Management Actions Column");

        columns.put(CMGMTSHOWTEXT,    "Company Management Show Rows Text");
        columns.put(CMGMTROWSINPUT,   "Company Management Rows Per Page Input");
        columns.put(CMGMTPREVBTN,     "Company Management Previous Page Button");
        columns.put(CMGMTNEXTBTN,     "Company Management Next Page Button");



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

    public void verifyCompanyManagementCreatePageElements(){
        goToCompanyManagementPage();

        common.waitUntilElementToBeVisible(CMGMTCREATEBTN);
        common.click(CMGMTCREATEBTN);

        Map<String, String> columns = new LinkedHashMap<>();


        columns.put(CCHEADER,            "Create Company Management Page Header");
        columns.put(CCBACKBUTTON,        "Create Company Management Back Button");
        columns.put(CCANCELBTN,          "Create Company Management Cancel Button");
        columns.put(CCSAVEBTN,            "Create Company Management Save Button");

        columns.put(CCNAMELABEL,         "Create Company Management Name Label");
        columns.put(CCDESIGNATIONLABEL,  "Create Company Management Designation Label");
        columns.put(CCEMAILLABEL,        "Create Company Management Email Label");
        columns.put(CCPHONELABEL,        "Create Company Management Phone Number Label");

        columns.put(CCNAMEINPUT,         "Create Company Management Name Input Field");
        columns.put(CCDESIGNATIONINPUT,  "Create Company Management Designation Input Field");
        columns.put(CCEMAILINPUT,        "Create Company Management Email Input Field");
        columns.put(CCPHONEINPUT,        "Create Company Management Phone Number Input Field");



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

    public void verifyCompanyManagementEditPageElements(){
        goToCompanyManagementPage();

        common.waitUntilElementToBeVisible(CMGMTEDITBTN);
        common.assertElementPresent(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);
        common.waitUntilElementToBeVisible(CEDITHEADER);

        int mandatory = common.getMandatoryFieldCount();
        common.logPrint("Mandatory Fields found: " +mandatory);

        common.assertElementPresent(CEDITHEADER);
        common.assertElementPresent(CEDITRESET);
        common.assertElementPresent(CCNAMELABEL);
        common.assertElementPresent(CCDESIGNATIONLABEL);
        common.assertElementPresent(CCEMAILLABEL);
        common.assertElementPresent(CCPHONELABEL);
        common.assertElementPresent(CCANCELBTN);
        common.assertElementPresent(CCSAVEBTN);

        common.logPrint("All the elements in Edit verified successfully.");


    }

    public void verifyCompanyManagementViewElements(){
        verifyAddingAValidCompanyManagement();

        common.waitUntilElementToBeVisible(CMGMTVIEWBTN);
        common.click(CMGMTVIEWBTN);

        common.assertElementPresent(CVIEWHEADER);
        common.assertElementPresent("(//span[text()='Name'])[2]");
        common.assertElementPresent(CVIENAMEINPUT);
        common.assertElementPresent("(//span[text()='Designation'])[2]");
        common.assertElementPresent(CVIEWDESIGINPUT);
        common.assertElementPresent("(//span[text()='Email'])[2]");
        common.assertElementPresent(CVIEWEMAILINPUT);
        common.assertElementPresent("(//span[text()='Phone Number'])[2]");
        common.assertElementPresent(CVIEWPHONEINPUT);
        common.assertElementPresent(CVIEWCANCELBUTTON);

        common.logPrint("All view elemnts asserted successfully.");

    }

    public void verifyMandatoryFields(){
        goToCompanyManagementPage();

        common.waitUntilElementToBeVisible(CMGMTCREATEBTN);
        common.click(CMGMTCREATEBTN);

        int mandatoryFields = common.getMandatoryFieldCount();

        common.logPrint("Expected Mandatory Fields were 4 and actual found: "+mandatoryFields);


        common.waitUntilElementToBeVisible(CCSAVEBTN);
        common.click(CCSAVEBTN);

        common.assertElementPresent(CCNAMEVAL);
        common.assertElementPresent(CCDESIGNATIONVAL);
        common.assertElementPresent(CCEMAILVAL);
        common.assertElementPresent(CCPHONEVAL);
    }

    public void verifyAddingABlankCompanyManagement(){
        verifyMandatoryFields();
        common.click(CCSAVEBTN);

        String curURL = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl() + "company-management/add";

        if (curURL.equals(expectedURL)) {
            common.logPrint("Current URL: " +curURL+ " matches expected URL: " +expectedURL);
        }
        else{
            common.logPrint("Current URL: " +curURL+ " doesn't matche expected URL: " +expectedURL);
        }
    }

    public String[] verifyAddingAValidCompanyManagement(){
        goToCompanyManagementPage();
        Faker faker = new Faker(new Locale("en", "IN"));

        String firstName = faker.name().firstName();
        String lastName  = faker.name().lastName();

        String fakeFullName = (firstName + " " + lastName).toLowerCase();
        String  fakeDesignation = faker.job().title();
        String fakeEmail =  (firstName + "." + lastName + "@companytest.com").toLowerCase();;
        String fakePhoneNumber = common.fakeIndianMobileNumber();

        String searchResult = "//div[@data-rowindex='0']/child::div[@data-field='name']";

        common.waitUntilElementToBeVisible(CMGMTCREATEBTN);
        common.click(CMGMTCREATEBTN);

        common.waitUntilElementToBeVisible(CCNAMEINPUT);
        common.type(CCNAMEINPUT, fakeFullName);

        common.waitUntilElementToBeVisible(CCDESIGNATIONINPUT);
        common.type(CCDESIGNATIONINPUT, fakeDesignation);

        common.waitUntilElementToBeVisible(CCEMAILINPUT);
        common.type(CCEMAILINPUT, fakeEmail);

        common.waitUntilElementToBeVisible(CCPHONEINPUT);
        common.type(CCPHONEINPUT, fakePhoneNumber);

        common.click(CCSAVEBTN);

        common.assertElementPresent(CCSUCCESS);

        common.waitUntilElementToBeVisible(CMGMTHEADER);

        common.pause(1);

        common.type(CMGMTSEARCH, fakeFullName);

        common.waitUntilElementToBeVisible(searchResult);
        common.validateSearch(searchResult,fakeFullName);


        return new String[]{fakeFullName,fakeDesignation,fakeEmail,fakePhoneNumber};

    }

    public void verifyViewingCompanyManagement() {

        String[] addedManagement = verifyAddingAValidCompanyManagement();

        String expectedName        = addedManagement[0];
        String expectedDesignation = addedManagement[1];
        String expectedEmail       = addedManagement[2];
        String expectedPhone       = addedManagement[3];

        common.waitUntilElementToBeClickable(CMGMTVIEWBTN);
        common.click(CMGMTVIEWBTN);

        common.waitUntilElementToBeVisible(CVIEWHEADER);
        common.pause(1);
        String actualName        = common.getAttribute(CVIENAMEINPUT, "value");
        String actualDesignation = common.getAttribute(CVIEWDESIGINPUT, "value");
        String actualEmail       = common.getAttribute(CVIEWEMAILINPUT, "value");
        String actualPhone       = common.getAttribute(CVIEWPHONEINPUT, "value").replaceAll("\\D", "")
                .replaceFirst("^91", "");;

        Assert.assertEquals(actualName, expectedName,
                "Mismatch in Company Management Name");
        Assert.assertEquals(actualDesignation, expectedDesignation,
                "Mismatch in Company Management Designation");
        Assert.assertEquals(actualEmail, expectedEmail,
                "Mismatch in Company Management Email");
        Assert.assertEquals(actualPhone, expectedPhone,
                "Mismatch in Company Management Phone Number");

        common.logPrint("View Company Management details verified successfully");
    }

    public void verifyCancelButtonInsideView(){
        verifyViewingCompanyManagement();
        common.waitUntilElementToBeVisible(CVIEWCANCELBUTTON);
        common.scroll_To_Element(CVIEWCANCELBUTTON);
        common.click(CVIEWCANCELBUTTON);

        String curURL = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl() + "company-management";

        Assert.assertEquals(expectedURL, curURL, "Mismatch in Company Management URL");
        common.logPrint("Cancel Button verified successfully");
    }

    public String[] verifyEditingACompanyManagement() {

        String[] addedManagement = verifyAddingAValidCompanyManagement();

        String expectedName        = addedManagement[0].toLowerCase();
        String expectedDesignation = addedManagement[1].toLowerCase();
        String expectedEmail       = addedManagement[2].toLowerCase();
        String expectedPhone       = addedManagement[3].toLowerCase();

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.waitUntilElementToBeVisible(CEDITHEADER);

        common.pause(2);
        String oldName        = common.getAttribute(CCNAMEINPUT, "value").toLowerCase();
        String oldDesignation = common.getAttribute(CCDESIGNATIONINPUT, "value").toLowerCase();
        String oldEmail       = common.getAttribute(CCEMAILINPUT, "value").toLowerCase();
        String oldPhone       = common.getAttribute(CCPHONEINPUT, "value").replaceAll("\\D", "")
                .replaceFirst("^91", "");;

        Assert.assertEquals(oldName, expectedName, "Pre-edit name mismatch");
        Assert.assertEquals(oldDesignation, expectedDesignation, "Pre-edit designation mismatch");
        Assert.assertEquals(oldEmail, expectedEmail, "Pre-edit email mismatch");
        Assert.assertEquals(oldPhone, expectedPhone, "Pre-edit phone mismatch");

        Faker faker = new Faker(new Locale("en", "IN"));

        String firstName = faker.name().firstName().toLowerCase();
        String lastName  = faker.name().lastName().toLowerCase();

        String fakeFullName    = (firstName + " " + lastName);
        String fakeDesignation = faker.job().title().toLowerCase();
        String fakeEmail       = (firstName + "." + lastName + "@companytest.com").toLowerCase();
        String fakePhoneNumber = common.fakeIndianMobileNumber();

        common.type(CCNAMEINPUT, fakeFullName);
        common.type(CCDESIGNATIONINPUT, fakeDesignation);
        common.type(CCEMAILINPUT, fakeEmail);

        common.clearElement(CCPHONEINPUT);
        common.type(CCPHONEINPUT,"+91" + fakePhoneNumber);

        common.click(CCSAVEBTN);

        common.assertElementPresent(CEDITMSG);
        common.waitUntilElementToBeVisible(CMGMTHEADER);

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.waitUntilElementToBeVisible(CEDITHEADER);

        common.pause(2);
        String updatedName        = common.getAttribute(CCNAMEINPUT, "value").toLowerCase();
        String updatedDesignation = common.getAttribute(CCDESIGNATIONINPUT, "value").toLowerCase();
        String updatedEmail       = common.getAttribute(CCEMAILINPUT, "value").toLowerCase();
        String updatedPhone       = common.getAttribute(CCPHONEINPUT, "value").replaceAll("\\D", "")
                .replaceFirst("^91", "");;

        Assert.assertNotEquals(updatedName, expectedName, "Name did not change after edit");
        Assert.assertNotEquals(updatedDesignation, expectedDesignation, "Designation did not change after edit");
        Assert.assertNotEquals(updatedEmail, expectedEmail, "Email did not change after edit");
        Assert.assertNotEquals(updatedPhone, expectedPhone, "Phone did not change after edit");

        common.logPrint("Company Management edit verified successfully");

        return new String[]{
                fakeFullName,
                fakeDesignation,
                fakeEmail,
                fakePhoneNumber
        };
    }

    public void verifyCancelButtonInsideEdit(){
        verifyAddingAValidCompanyManagement();

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.waitUntilElementToBeVisible(CCANCELBTN);
        common.click(CCANCELBTN);

        String curURL = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl() + "company-management";

        Assert.assertEquals(expectedURL, curURL, "Mismatch in Company Management URL");
        common.logPrint("Cancel Button verified successfully");

    }

    public void verifyAddingADuplicateCompanyManagement(){

        String[] addedManagement = verifyAddingAValidCompanyManagement();

        String expectedName        = addedManagement[0].toLowerCase();
        String expectedDesignation = addedManagement[1].toLowerCase();
        String expectedEmail       = addedManagement[2].toLowerCase();
        String expectedPhone       = addedManagement[3].toLowerCase();

        common.waitUntilElementToBeVisible(CMGMTCREATEBTN);
        common.click(CMGMTCREATEBTN);

        common.type(CCNAMEINPUT, expectedName);
        common.type(CCDESIGNATIONINPUT, expectedDesignation);
        common.type(CCEMAILINPUT, expectedEmail);

        common.clearElement(CCPHONEINPUT);
        common.type(CCPHONEINPUT," " + expectedPhone);

        common.click(CCSAVEBTN);

        common.assertElementIsNotDisplayed(CMGMTCREATEBTN);


    }

    public void verifyResetButtonInEdit(){

        String[] addedManagement = verifyAddingAValidCompanyManagement();

        String expectedName        = addedManagement[0].toLowerCase();
        String expectedDesignation = addedManagement[1].toLowerCase();
        String expectedEmail       = addedManagement[2].toLowerCase();
        String expectedPhone       = addedManagement[3].toLowerCase();
        Faker faker = new Faker(new Locale("en", "IN"));

        String firstName = faker.name().firstName().toLowerCase();
        String lastName  = faker.name().lastName().toLowerCase();

        String fakeFullName    = (firstName + " " + lastName);
        String fakeDesignation = faker.job().title().toLowerCase();
        String fakeEmail       = (firstName + "." + lastName + "@companytest.com").toLowerCase();
        String fakePhoneNumber = common.fakeIndianMobileNumber();

        common.waitUntilElementToBeClickable(CMGMTEDITBTN);
        common.click(CMGMTEDITBTN);

        common.type(CCNAMEINPUT, fakeFullName);
        common.type(CCDESIGNATIONINPUT, fakeDesignation);
        common.type(CCEMAILINPUT, fakeEmail);

        common.clearElement(CCPHONEINPUT);
        common.type(CCPHONEINPUT,"+91" + fakePhoneNumber);

        common.click(CEDITRESET);

        String updatedName        = common.getAttribute(CCNAMEINPUT, "value").toLowerCase();
        String updatedDesignation = common.getAttribute(CCDESIGNATIONINPUT, "value").toLowerCase();
        String updatedEmail       = common.getAttribute(CCEMAILINPUT, "value").toLowerCase();
        String updatedPhone       = common.getAttribute(CCPHONEINPUT, "value").replaceAll("\\D", "")
                .replaceFirst("^91", "");;

        Assert.assertEquals(updatedName, expectedName, "Name reset to default");
        Assert.assertEquals(updatedDesignation, expectedDesignation, "Designation reset to default");
        Assert.assertEquals(updatedEmail, expectedEmail, "Email reset to default");
        Assert.assertEquals(updatedPhone, expectedPhone, "Phone reset to default");

        common.logPrint("Company Management edit verified successfully");






    }

    public void verifyDeleteButtonFunctionality(){
        verifyAddingAValidCompanyManagement();

        common.waitUntilElementToBeVisible(CMGMTDELETEBTN);
        common.click(CMGMTDELETEBTN);

        common.assertElementPresent(CDELETEMSG2);
        common.assertElementPresent(CDELETEMSG3);
        common.assertElementPresent(CDELETEMSGCANCEL);
        common.assertElementPresent(CDELETEMSGDELETE);

        common.click(CDELETEMSGCANCEL);

        common.waitUntilElementToBeClickable(CDELETEMSGDELETE);
        common.click(CMGMTDELETEBTN);

        common.click(CDELETEMSGDELETE);

        common.assertElementPresent(DeletedSuccessfully);
    }

    public void verifyHorizontalCardView(){
        goToCompanyManagementPage();
        common.validateHorizontalViewCardCount("//div[@class=\"MuiBox-root css-a7l4db\"]");
}

    public void verifyPagination(){
        goToCompanyManagementPage();

        common.pagination("//div[@class='MuiBox-root css-a7l4db']");
    }

    public void verifyCreatedDate(){
        verifyAddingAValidCompanyManagement();
        String dateFromGrid = common.getText(CCREATEDDATEVAL).trim();

        String actualDate = dateFromGrid.split(" ")[0];

        String currentDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        common.logPrint("Grid Date: " + actualDate + " | Current Date: " + currentDate);

        Assert.assertEquals(actualDate, currentDate, "Created date mismatch");

    }

}
