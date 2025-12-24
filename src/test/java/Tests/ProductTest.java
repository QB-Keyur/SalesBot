package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

import javax.swing.*;


public class ProductTest extends BasePage {

    @Test
    public void goToProductPage() {
        loginWithAdminUser();
        productPage.goToProductPage();
    }

    @Test
    public void verifyColumns() {
        loginWithAdminUser();
        productPage.verifyColumns();
    }

    @Test
    public void verifyElements() {
        loginWithAdminUser();
        productPage.verifyElements();
    }

    @Test
    public void verifySearch() {
        loginWithAdminUser();
        productPage.verifySearch();
    }

    @Test
    public void verifyRefresh() {
        loginWithAdminUser();
        productPage.verifyRefresh();
    }

    @Test
    public void validateSorting() {
        loginWithAdminUser();
        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
    }

    @Test
    public void validatePlaceHolders() {
        loginWithAdminUser();
        productPage.validatePlaceHolders();
    }

    @Test
    public void verifyAddingANewProductWithValidData() {
        loginWithAdminUser();
        productPage.verifyAddingANewProductWithValidData();
    }

    @Test
    public void editingAProduct(){
        loginWithAdminUser();
        productPage.editingAProduct();
    }

    @Test
    public void deletingAProduct() {
        loginWithAdminUser();
        productPage.deletingAProduct();
    }

    @Test
    public void viewProduct(){
        loginWithAdminUser();
        productPage.viewProduct();
    }

    @Test
    public void horizontalView(){
        loginWithAdminUser();
        productPage.horizontalView();
    }

    @Test
    public void filters(){
        loginWithAdminUser();
        productPage.filters();
    }

    @Test
    public void pagination(){
        loginWithAdminUser();
        productPage.pagination();
    }

}
