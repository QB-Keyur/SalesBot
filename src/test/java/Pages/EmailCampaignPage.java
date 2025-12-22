package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmailCampaignPage extends Locators {
    ReadProperties readProperties;
    Common common;

    public EmailCampaignPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
        this.readProperties = new ReadProperties();
    }

    public void goToEmailCampaignPage() {
        String expectedURL = readProperties.getWebUrl() + "email-campaign";

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

    public void verifyEmailCampaignElements(){

        goToEmailCampaignPage();

        common.waitUntilElementToBeVisible(ECSEARCHBAR);

        Map<String, String> columns = new LinkedHashMap<>();


        columns.put(CAMPAIGNMENU, "Campaign Menu");
        columns.put(EMIALCAMPAIGNMENU, "Email Campaign Menu");
        columns.put(ECHEADER, "Email Campaign Header");

        columns.put(ECSEARCHBAR, "Email Campaign Search");
        columns.put(ECREFRESHBUTTON, "Email Campaign Refresh");
        columns.put(ECREFILTERBUTTON, "Email Campaign Filters");
        columns.put(ECCREATEBUTTON, "Email Campaign Create");
        columns.put(MULTITABHOR, "Email Campaign Horizontal View");
        columns.put(MULTITABVER, "Email Campaign Vertical View");

        columns.put(ECSR, "Email Campaign SR No");
        columns.put(ECNAME, "Email Campaign Name");
        columns.put(ECCATEGORY, "Email Campaign Category");
        columns.put(ECPRODUCT, "Email Campaign Product");
        columns.put(ECEMAIL, "Email Campaign Integration Email");
        columns.put(ECCONTACT, "Email Campaign Contact");
        columns.put(ECCONTACTGROUP, "Email Campaign Contact Group");
        columns.put(ECAI, "Email Campaign Enable AI");
        columns.put(ECSTATUS, "Email Campaign Status");
        columns.put(ECACTION, "Email Campaign Actions");


        columns.put(KBTOTALROWS, "Email Campaign Total Rows");
        columns.put(KBROWSPERPAGE, "Email Campaign Rows Per Page");


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
