package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;

public class LeadStagePage extends Locators {
    Common common;

    public LeadStagePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }
}