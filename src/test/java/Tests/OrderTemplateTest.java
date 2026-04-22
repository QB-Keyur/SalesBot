package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class OrderTemplateTest extends BasePage {

    @Test
    public void goToOrderTemplatePage() {
        common.logPrint("START :: Navigating to Order Template page");
        loginWithAdminUser();
        orderTemplatePage.goToDocumentTemplatePage();
    }

    @Test
    public void verifyPageToolbarElements() {
        common.logPrint("START :: Verifying Order Template page toolbar elements");
        loginWithAdminUser();
        orderTemplatePage.verifyPageToolbarElements();
    }

    @Test
    public void verifyCreatePageUIElements() {
        common.logPrint("START :: Verifying Order Template create page UI elements");
        loginWithAdminUser();
        orderTemplatePage.verifyCreatePageUIElements();
    }

    @Test
    public void verifyMandatoryFields() {
        common.logPrint("START :: Verifying Order Template mandatory fields");
        loginWithAdminUser();
        orderTemplatePage.verifyMandatoryFields();
    }

    @Test
    public void verifyCancelButton() {
        common.logPrint("START :: Verifying Order Template cancel button");
        loginWithAdminUser();
        orderTemplatePage.verifyCancelButton();
    }

    @Test
    public void createOrderTemplate() {
        common.logPrint("START :: Creating Order Template");
        loginWithAdminUser();
        orderTemplatePage.createDocumentTemplate();
    }

    @Test
    public void readOrderTemplate() {
        common.logPrint("START :: Reading Order Template from the grid");
        loginWithAdminUser();
        orderTemplatePage.readDocumentTemplate();
    }

    @Test
    public void updateOrderTemplate() {
        common.logPrint("START :: Updating Order Template");
        loginWithAdminUser();
        orderTemplatePage.updateDocumentTemplate();
    }

    @Test
    public void deleteOrderTemplate() {
        common.logPrint("START :: Deleting Order Template");
        loginWithAdminUser();
        orderTemplatePage.deleteDocumentTemplate();
    }
}
