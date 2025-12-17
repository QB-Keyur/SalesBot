package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class OtherPage extends Locators {

    Common common;

    public OtherPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

}