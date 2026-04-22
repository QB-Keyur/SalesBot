package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class QuotationTemplateTest extends BasePage {

    @Test
    public void goToQuotationTemplatePage() {
        common.logPrint("START :: Navigating to Quotation Template page");
        loginWithAdminUser();
        quotationTemplatePage.goToDocumentTemplatePage();
    }

    @Test
    public void verifyPageToolbarElements() {
        common.logPrint("START :: Verifying Quotation Template page toolbar elements");
        loginWithAdminUser();
        quotationTemplatePage.verifyPageToolbarElements();
    }

    @Test
    public void verifyCreatePageUIElements() {
        common.logPrint("START :: Verifying Quotation Template create page UI elements");
        loginWithAdminUser();
        quotationTemplatePage.verifyCreatePageUIElements();
    }

    @Test
    public void verifyMandatoryFields() {
        common.logPrint("START :: Verifying Quotation Template mandatory fields");
        loginWithAdminUser();
        quotationTemplatePage.verifyMandatoryFields();
    }

    @Test
    public void verifyCancelButton() {
        common.logPrint("START :: Verifying Quotation Template cancel button");
        loginWithAdminUser();
        quotationTemplatePage.verifyCancelButton();
    }

    @Test
    public void createQuotationTemplate() {
        common.logPrint("START :: Creating Quotation Template");
        loginWithAdminUser();
        quotationTemplatePage.createDocumentTemplate();
    }

    @Test
    public void readQuotationTemplate() {
        common.logPrint("START :: Reading Quotation Template from the grid");
        loginWithAdminUser();
        quotationTemplatePage.readDocumentTemplate();
    }

    @Test
    public void updateQuotationTemplate() {
        common.logPrint("START :: Updating Quotation Template");
        loginWithAdminUser();
        quotationTemplatePage.updateDocumentTemplate();
    }

    @Test
    public void deleteQuotationTemplate() {
        common.logPrint("START :: Deleting Quotation Template");
        loginWithAdminUser();
        quotationTemplatePage.deleteDocumentTemplate();
    }
}
