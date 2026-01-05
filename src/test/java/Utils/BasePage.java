package Utils;

import Config.EnvConfig;
import Config.ReadProperties;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    /* ================= DRIVER ================= */
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    /* ================= COMMON ================= */
    public Common common;
    public static String currentTest;
    public static ThreadLocal<Integer> steps = new ThreadLocal<>();

    /* ================= PAGE OBJECTS ================= */
    public loginPage loginPage;
    public OtherPage otherPage;
    public ProductPage productPage;
    public AgentConfigurationPage agentConfigurationPage;
    public WhatsAppContactPage whatsAppContactPage;
    public LeadManagementPage lead;
    public KnowledgeBasePage knowledgeBasePage;
    public WhatsAppTemplatePage whatsAppTemplatePage;
    public profilePage profilePage;
    public WhatsAppCampaignPage WhatsAppCPage;
    public EmailTemplatePage emailTemplatePage;
    public EmailCampaignPage emailCampaignPage;
    public UserManagementPage userManagementPage;
    public CompanyManagementPage companyManagementPage;
    public CompanyPortfolioPage companyPortfolioPage;
    public WorkingHoursPage workingHoursPage;
    public LeadStagePage leadStagePage;
    public WhatsAppIntegrationPage whatsAppIntegrationPage;
    public SMTPIntegrationPage smtpIntegrationPage;

    protected List<String> stringList = new ArrayList<>();

    /* ================= LOGIN ================= */
    public void loginWithAdminUser(String username, String password) {
        common.waitUntilElementToBeVisible("//input[@name='email']");
        common.type("//input[@name='email']", username);
        common.waitUntilElementToBeVisible("//input[@name='password']");
        common.type("//input[@name='password']", password);
        common.click("//button[@type='submit']");
        common.assertElementPresent("//div[contains(text(), 'Login successful')]");
        common.logPrint("Login successfully.");
        common.click("//button[@aria-label='Close alert']");
    }

    public void loginWithAdminUser() {
        loginWithAdminUser(
                EnvConfig.getDirectorUser(),
                EnvConfig.getDirectorPass()
        );
    }

    /* ================= SETUP ================= */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult testResult) {

        Reporter.setCurrentTestResult(testResult);
        currentTest = method.getName();

        String browser = ReadProperties.getBrowser();
        boolean headless = ReadProperties.isHeadless();

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
            }

            options.addArguments(
                    "--incognito",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",
                    "--disable-gpu",
                    "--disable-extensions",
                    "--remote-allow-origins=*"
            );

            driver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();

            if (headless) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
            }

            driver.set(new EdgeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();

            if (headless) {
                options.addArguments("--headless");
            }

            driver.set(new FirefoxDriver(options));
        }

        getDriver().manage().window().maximize();

        /* Initialize helpers */
        common = new Common(getDriver());
        loginPage = new loginPage(getDriver());
        otherPage = new OtherPage(getDriver());
        productPage = new ProductPage(getDriver());
        whatsAppContactPage = new WhatsAppContactPage(getDriver());
        agentConfigurationPage = new AgentConfigurationPage(getDriver());
        lead = new LeadManagementPage(getDriver());
        knowledgeBasePage = new KnowledgeBasePage(getDriver());
        whatsAppTemplatePage = new WhatsAppTemplatePage(getDriver());
        profilePage = new profilePage(getDriver());
        WhatsAppCPage = new WhatsAppCampaignPage(getDriver());
        emailTemplatePage = new EmailTemplatePage(getDriver());
        emailCampaignPage = new EmailCampaignPage(getDriver());
        userManagementPage = new UserManagementPage(getDriver());
        companyManagementPage = new CompanyManagementPage(getDriver());
        companyPortfolioPage = new CompanyPortfolioPage(getDriver());
        workingHoursPage = new WorkingHoursPage(getDriver());
        leadStagePage = new LeadStagePage(getDriver());
        whatsAppIntegrationPage = new WhatsAppIntegrationPage(getDriver());
        smtpIntegrationPage = new SMTPIntegrationPage(getDriver());

        steps.set(1);
        Common.printCurrentTime("Starting Time");

        getDriver().get(EnvConfig.getWebUrl());
    }

    /* ================= TEARDOWN ================= */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {

        String testName = testResult.getName();
        Reporter.setCurrentTestResult(testResult);

        try {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                Reporter.log("<font color='red'><b>FAIL :: " + testName + "</b></font>");
                makeScreenshot(getDriver(), testName);
                Reporter.log("URL: " + getDriver().getCurrentUrl());
            }
            else if (testResult.getStatus() == ITestResult.SUCCESS) {
                Reporter.log("<font color='green'><b>PASS :: " + testName + "</b></font>");
            }
        }
        catch (Exception ignored) {}

        finally {
            Common.printCurrentTime("Ending Time");

            try {
                WebDriver drv = getDriver();
                if (drv != null) {
                    drv.quit();   // ONLY quit
                }
            }
            catch (Exception e) {
                System.out.println("⚠️ Driver quit timeout ignored");
            }
            finally {
                driver.remove(); // 🔥 MUST
            }
        }
    }

    /* ================= SCREENSHOT ================= */
    public void makeScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String screenshotDir = System.getProperty("user.dir")
                    + File.separator + "target"
                    + File.separator + "surefire-reports"
                    + File.separator + "screenshots";

            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();

            File dest = new File(screenshotDir + File.separator + screenshotName + ".png");
            FileUtils.copyFile(src, dest);

            String relativePath = "./screenshots/" + screenshotName + ".png";

            Reporter.log("<br><b>Screenshot:</b><br>");
            Reporter.log(
                    "<a href='" + relativePath + "' target='_blank'>" +
                            "<img src='" + relativePath + "' height='250' width='450'/>" +
                            "</a>"
            );
        }
        catch (Exception e) {
            Reporter.log("Screenshot failed: " + e.getMessage());
        }
    }
}
