package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;

public class SMTPIntegrationPage extends Locators {
    Common common;

    public SMTPIntegrationPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToSMTPIntegrationPage() {
        common.waitUntilElementToBeVisible(INTEGRATIONMENU);
        common.click(INTEGRATIONMENU);

        common.waitUntilElementToBeVisible(INTEGRATIONHEADER);
        common.assertElementPresent(INTEGRATIONHEADER);
        common.logPrint(INTEGRATIONHEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl()+"integration";

        if(curUrl.equals(expectedURL)){
            common.logPrint("Passed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
        else{
            common.logPrint("Failed Current URL is "+curUrl+ " expected URL is "+expectedURL);
        }
    }

    public void verifySMTPIntegrationUIElements() {
        goToSMTPIntegrationPage();

    }


}
