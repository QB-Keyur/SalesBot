package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;
import javax.swing.*;

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

}}