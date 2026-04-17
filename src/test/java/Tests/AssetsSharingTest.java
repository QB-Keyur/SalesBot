package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.swing.*;

public class AssetsSharingTest extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AssetsSharingTest.class);
    public String filePath = "E:\\SalesBot Automation\\29-12\\src\\test\\resources\\filter_icon.PNG";
    public String image = "C:\\Users\\Admin\\Downloads\\spotify\\spotifyImage.jpg";
    public String video = "C:\\Users\\Admin\\Downloads\\spotify\\video.mp4";
    public String doc = "C:\\Users\\Admin\\Downloads\\spotify\\spotify_overview.pdf";

    @Test
    public void goToAssetsSharingPage() {

        common.logPrint("Verifying navigation to the Assets & Sharing page");
        loginWithAdminUser();

        assetsSharingPage.goToAssetsSharingPage();

    }

    @Test
    public void verifyElementsOfMainPage(){
        common.logPrint("Verifying elements of the Assets & Sharing page");
        loginWithAdminUser();

        assetsSharingPage.verifyElementsOfMainPage();
    }

    @Test
    public void verifyElementsOfTheCreatePage(){

        common.logPrint("Verifying elements of the Assets & Sharing Create page");
        loginWithAdminUser();

        assetsSharingPage.verifyElementsOfTheCreatePage();
    }

    @Test
    public void verifyMandatoryFields(){
        loginWithAdminUser();
        assetsSharingPage.verifyMandatoryFields();
    }

    @Test
    public void createAnAssetWithValidData(){
        common.logPrint("Verifying elements of the Assets & Sharing Create page");
        loginWithAdminUser();

        assetsSharingPage.createAnAssetWithValidData(image);
        assetsSharingPage.createAnAssetWithValidData(video);
        assetsSharingPage.createAnAssetWithValidData(doc);
    }

    @Test
    public void updateAnAssetWithValidData(){
        common.logPrint("Verifying updating assets");
        loginWithAdminUser();

        assetsSharingPage.updateAnAssetWithValidData(filePath);

    }

    @Test
    public void verifyCancelButton(){
        loginWithAdminUser();
        assetsSharingPage.verifyCancelButton();
    }

    @Test
    public void viewAnAsset(){
        common.logPrint("Verifying navigation to the Assets & Sharing page");
        loginWithAdminUser();

        assetsSharingPage.viewAnAsset(filePath);
    }

    @Test
    public void deleteAnAssetWithValidData(){
        loginWithAdminUser();

        assetsSharingPage.deleteAnAsset("E:\\SalesBot Automation\\29-12\\src\\test\\resources\\filter_icon.PNG");
    }

    @Test
    public void search(){
        loginWithAdminUser();

        common.logPrint("Verifying searching for assets");
        assetsSharingPage.searchAsset();
    }

    @Test
    public void verifyHorizontalCardView(){
        loginWithAdminUser();

        common.logPrint("Verifying navigation to the Assets & Sharing Page");
        assetsSharingPage.verifyHorizontalCardView();
    }

    @Test
    public void verifyPagination(){
        loginWithAdminUser();
        assetsSharingPage.verifyPagination();
    }

    @Test
    public void verifyCreatedDate(){
        loginWithAdminUser();
        assetsSharingPage.verifyCreatedDate(filePath);
    }

    @Test
    public void validateSorting(){
        loginWithAdminUser();
        assetsSharingPage.goToAssetsSharingPage();
        productPage.validateSorting(2, "", null, SortOrder.ASCENDING,"//div[@class='MuiBox-root css-a7l4db'] | //h6[text()='Assets & Sharing']/following-sibling::div");
    }

}
