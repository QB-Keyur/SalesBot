package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;
import javax.swing.*;
import Tests.WhatsAppContactTest;

public class CustomerTest extends BasePage {

    @Test
    public void goToCustomerPage(){
        common.logPrint("TEST START :: Navigate to Customer page");
        loginWithAdminUser();
        customerPage.goToCustomerPage();
        common.logPrint("TEST PASS :: Customer page loaded successfully");
    }

    @Test
    public void verifyCustomerPageElements(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();
        customerPage.verifyCustomerPageElements();
        common.logPrint("TEST PASS :: Customer page elements verified successfully");
    }

    @Test
    public void verifyCreatePageElements(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();
        customerPage.verifyCreatePageElements();
        common.logPrint("TEST PASS :: Customer page elements verified successfully");
    }

    @Test
    public void createCustomerWithValidData(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();

        customerPage.createCustomerWithValidData();
        common.logPrint("TEST PASS :: Customer created successfully");
    }

    @Test
    public void editingACustomer(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();

        customerPage.editingACustomer();
        common.logPrint("TEST PASS: Customer Edited Successfully");
    }

    @Test
    public void deletingACustomer(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();

        customerPage.deleteACustomer();
        common.logPrint("TEST PASS: Customer Edited Successfully");

    }

    @Test
    public void horizontalView(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();

        customerPage.horizontalView();
        common.logPrint("TEST PASS: Data shows as expected in Horizontal view");
    }

    @Test
    public void pagination(){
        common.logPrint("TEST START :: Navigating to the Customer Page");
        loginWithAdminUser();

        customerPage.pagination();
        common.logPrint("TEST PASS: Pagination works as Expected");
    }

    @Test
    public void validateSorting(){
        common.logPrint("TEST START :: Validate sorting on Company Portfolio grid (Column index: 2, Order: DESC)");
        loginWithAdminUser();
        customerPage.goToCustomerPage();
        productPage.validateSorting(2, "", null, SortOrder.ASCENDING,"//div[@class=\"MuiBox-root css-a7l4db\"]|//h6[text()='Customer']/following::div[1]");
        common.logPrint("TEST PASS :: Sorting validated successfully for Company Portfolio grid");
    }

}