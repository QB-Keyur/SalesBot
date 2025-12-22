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
        productPage.verifySearch();
    }

    @Test
    public void verifyRefresh() {
        productPage.verifyRefresh();
    }

    @Test
    public void validateSorting() {

        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
    }

    @Test
    public void validatePlaceHolders() {
        productPage.validatePlaceHolders();
    }

    @Test
    public void verifyAddingANewProductWithValidData() {
        productPage.verifyAddingANewProductWithValidData();
    }

    @Test
    public void editingAProduct(){
        productPage.editingAProduct();
    }

    @Test
    public void deletingAProduct() {
        productPage.deletingAProduct();
    }

    @Test
    public void viewProduct(){
        productPage.viewProduct();
    }

    @Test
    public void horizontalView(){
        productPage.horizontalView();
    }

    @Test
    public void filters(){
        productPage.filters();
    }

    @Test
    public void pagination(){
        productPage.pagination();
    }


}
