package Utils;

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

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];

    String url = readProperties.getWebUrl();

    static Properties configProperties = null;
    protected static WebDriver driver;
    public static Common common;
    public static String currentTest; // current running test
    public static ThreadLocal<Integer> steps = new ThreadLocal<Integer>();
    private ThreadLocal<WebDriver> threadLocal = new ThreadLocal();
    public AdminPage adminPage;
    public OtherPage otherPage;
    public ProductPage productPage;
    public AgentConfigurationPage agentConfigurationPage;
    public WhatsAppContactPage whatsAppContactPage;

    protected List<String> stringList = new ArrayList<>();

    public void loginWithAdminUser(){

        common.logPrint("Step:: Enter email id");
        common.waitUntilElementToBeVisible("//input[@name='email']");
        common.type("//input[@name='email']",username);

        common.logPrint("Step:: Enter the password ");
        common.waitUntilElementToBeVisible("//input[@name='password']");
        common.type("//input[@name='password']",password);

        common.logPrint("Step:: Click on the Login button");
        common.waitUntilElementToBeVisible("//button[@type='submit']");
        common.click("//button[@type='submit']");

        common.assertElementPresent("//div[contains(text(), 'Login successful')]");

        common.logPrint("Login successfully.");
        String CLOSEBUTTON = "//button[@aria-label='Close alert']";
        common.click(CLOSEBUTTON);

    }

    /**
     * Setup Method
     *
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult testResult) throws Exception {
        Reporter.setCurrentTestResult(testResult);

        currentTest = method.getName();

        String browser = getPropertyValue("browser");
        String headless = getPropertyValue("headless");
        String driverPathChrome = getPropertyValue("driverPathChrome");
        String driverPathChromeMac = getPropertyValue("driverPathChromeMac");
        String driverPathFirefox = getPropertyValue("driverFirefox");
        String driverPathEdge = getPropertyValue("drivePathEdge");

        /*
         * Browser = Chrome
         */
        if (browser.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", driverPathChromeMac);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (headless.equals("true")) {
                //Run browser in headless mode
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");            // open Browser in maximized mode
            options.addArguments("--incognito");
            options.addArguments("--disable-dev-shm-usage");    // overcome limited resource problems
            options.addArguments("--no-sandbox");               // Bypass an OS security model
            options.addArguments("--remote-allow-origins=*");
            options.addArguments(
                    "user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (HTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {

            //System.setProperty("webdriver.edge.driver", driverPathEdge);
            WebDriverManager.edgedriver().setup();
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("-private");
            options.addArguments("start-maximized");

            if (headless.equals("true")) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");
            }

            driver = new EdgeDriver(options); // Pass options to EdgeDriver

        }
        else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
              options.addArguments("-private");
            //  options.addPreference("devtools.toolbox.selectedTool","netmonitor");
            if (headless.equals("true")) {
                options.addArguments("--headless");
            }

            driver = new FirefoxDriver(options);
        }

        threadLocal.set(driver);
        driver = threadLocal.get();
        driver.manage().window().maximize();
        common = new Common(driver);
        adminPage = new AdminPage(driver);
        otherPage = new OtherPage(driver);
        productPage = new ProductPage(driver);
        whatsAppContactPage = new WhatsAppContactPage(driver);
        agentConfigurationPage = new AgentConfigurationPage(driver);
        steps.set(1);
        Common.printCurrentTime("Starting Time");
        driver.get(url);
    }
    protected Properties getConfigProperties() {
        if (configProperties == null) {
            configProperties = this.loadProperties(Paths.get("src/test/java/Config").toAbsolutePath().normalize() + "//config.properties");
        }
        return configProperties;
    }

    protected String getPropertyValue(String value) {
        Properties properties = getConfigProperties();
        return properties.getProperty(value);
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
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * Load Properties
     * @return properties
     */
    private Properties loadProperties(String filePath) {
        File file = new File(filePath);
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
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
            makeScreenshot(driver, testName);
            Reporter.log("Failed page URL: "+driver.getCurrentUrl());
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

        Common.printCurrentTime("Ending Time");
        driver.manage().deleteAllCookies();
        driver.quit();
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
