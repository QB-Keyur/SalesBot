package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import org.testng.annotations.Test;

public class profileTest extends BasePage {

    //Profile page test cases
    @Test
    public void verifyAllTheMenuAndElementsAreShowingProperly(){
        common.logPrint("Verify all the elements and menu are showing on the profile page");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifySettingPageHeaderMenuAndSubmenu();
    }

    @Test
    public void verifyAllTheLabelIsShowingOnProfileMenu(){
        common.logPrint("Verify profile page labels");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifyProfilePageLabels();
    }

    @Test
    public void verifyAllTheLabelAndInputsOnChangePassword(){
        common.logPrint("Verify change password page label, input field and button");
        loginWithAdminUser();
        profilePage.redirectsToProfilePage();
        profilePage.verifyChangePasswordPageLabelsAndFields();
    }





}