package Pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;

public class ExcelDrivenEdit {

    public static void main(String[] args) throws Exception {

        // 🔹 Setup Driver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://salesbot.cloud/");

        WebElement editBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@placeholder='Enter your mail id']")
                )
        );
        editBtn.sendKeys("loadtesting@yopmail.com");
        WebElement editBtn2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@placeholder='Password']")
                )
        );
        editBtn2.sendKeys("Gopal@0303");

        WebElement editBtn3 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit']")
                )
        );
        editBtn3.click();

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(driver1 ->
                ((JavascriptExecutor) driver1)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        driver.get("https://salesbot.cloud/whatsapp-contact");


        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\testcomp.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i <= lastRow; i++) {

            Row row = sheet.getRow(i);
            if (row == null) continue;

            String searchValue = row.getCell(0).getStringCellValue().trim();
            String companyName = row.getCell(1).getStringCellValue().trim();

            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[@placeholder=\"Search...\"]")
                    )
            );
            searchBox.clear();
            searchBox.sendKeys(searchValue);

            WebElement editBtn4 = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//button[@aria-label=\"Edit\"])[1]")
                    )
            );
            editBtn4.click();

            WebElement companyInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[@placeholder='Enter Company Name']")
                    )
            );
            companyInput.clear();
            companyInput.sendKeys(companyName);

            WebElement saveBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Save']/parent::button")
                    )
            );
            saveBtn.click();

            Thread.sleep(1000);
        }

        workbook.close();
        fis.close();
        driver.quit();

    }
}
