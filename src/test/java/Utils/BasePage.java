package Utils;

import Config.EnvConfig;
import Config.ReadProperties;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.*;


public class BasePage {

    // ================= DRIVER =================
    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static WebDriver getDriver() {
        return driver.get();
    }

    // ================= COMMON OBJECTS =================
    public Common common;
    public static String currentTest; // current running test
    public static ThreadLocal<Integer> steps = new ThreadLocal<Integer>();

    // ================= PAGE OBJECTS =================
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

    protected List<String> stringList = new ArrayList<>();

    // CORE login logic (never call this directly from tests)
    public void loginWithAdminUser(String username, String password) {
        common.waitUntilElementToBeVisible("//input[@name='email']");
        common.type("//input[@name='email']",username);
        common.waitUntilElementToBeVisible("//input[@name='password']");
        common.type("//input[@name='password']",password);
        common.waitUntilElementToBeVisible("//button[@type='submit']");
        common.click("//button[@type='submit']");
        common.assertElementPresent("//div[contains(text(), 'Login successful')]");
        common.logPrint("Login successfully.");
        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);
    }
    // ================= LOGIN METHODS =================
    public void loginWithAdminUser() {
        loginWithAdminUser(
                EnvConfig.getDirectorUser(),
                EnvConfig.getDirectorPass()
        );
    }

    public void loginForForgotPassword() {
        loginWithAdminUser(
                EnvConfig.getForgotUser(),
                EnvConfig.getForgotPass()
        );
    }

    public String forgotEmail = EnvConfig.getForgotUser();

    /**
     * Setup Method
     *
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult testResult) throws Exception {

        System.out.println(
                "THREAD ID = " + Thread.currentThread().getId()
        );

        Reporter.setCurrentTestResult(testResult);
        currentTest = method.getName();

        String browser = ReadProperties.getBrowser();
        boolean headless = ReadProperties.isHeadless();

        // ----------- CHROME -----------
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-dev-shm-usage");    // overcome limited resource problems
            options.addArguments("--no-sandbox");               // Bypass an OS security model
            options.addArguments("--remote-allow-origins=*");
            options.addArguments(
                    "user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (HTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");
            driver.set(new ChromeDriver(options));
        }
        else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("-private");
            options.addArguments("start-maximized");

            if (headless) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");
            }

            driver.set(new EdgeDriver(options)); // Pass options to EdgeDriver

        }
        else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            //  options.addPreference("devtools.toolbox.selectedTool","netmonitor");
            if (headless) {
                options.addArguments("--headless");
            }

            driver.set(new FirefoxDriver(options));
        }

        getDriver().manage().window().maximize();
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
        steps.set(1);
        Common.printCurrentTime("Starting Time");
        getDriver().get(EnvConfig.getWebUrl());
    }

    /**
     * Check that given element is present or not.
     *
     * @param xpath the xpath of element to be checked present or not
     *
     * @return True if the element present, false otherwise
     */

    public boolean existsElement(String xpath) {
        try {
            getDriver().findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * After Method {TearDown}
     */
    @AfterMethod(alwaysRun = true)
//     public void tearDown(ITestResult testResult,String TestCycle, String TestCase) throws Exception {
    public void tearDown(ITestResult testResult) throws Exception {

        String testName = testResult.getName();
        Reporter.setCurrentTestResult(testResult);

        if (testResult.getStatus() == 2) {
            Reporter.log("<font color = 'red'><b><i><u><br>Fail :: " + testResult.getName() + "</u></i></b></font>");
            makeScreenshot(getDriver(), testName);
            Reporter.log("Failed page URL: "+getDriver().getCurrentUrl());
        }
        // MyScreenRecorder.stopRecording();
        if (testResult.getStatus() == 1) {
            Reporter.log("<font color = 'green'><b><i><u><br>Pass :: " + testResult.getName() + "</u></i></b></font>");
//           MyScreenRecorder.deleteFile(testName+".avi");
            testResult.getThrowable();
            // makeScreenshot(driver, testName);
        }
//        for (String logs : stringList) {
//            Reporter.log(logs,true);
//        }
//
        Common.printCurrentTime("Ending Time");
        getDriver().manage().deleteAllCookies();
        getDriver().quit();
        driver.remove();
    }

    public void makeScreenshot(WebDriver driver, String screenshotName) {

        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        try {
            String reportFolder = "target" + File.separator + "test-output" + File.separator + "screenshots";
            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            File destFile = new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile();
            FileUtils.copyFile(screenshot, destFile);
            Reporter.log("<a href='" + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/"
                    + destFile.getName() + "'> <img src='"
                    + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/" + destFile.getName()
                    + "' height='250' width='500'/> </a>");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}