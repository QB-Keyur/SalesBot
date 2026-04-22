package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class InvoiceTemplateTest extends BasePage {

    @Test
    public void goToInvoiceTemplatePage() {
        common.logPrint("START :: Navigating to Invoice Template page");
        loginWithAdminUser();
        invoiceTemplatePage.goToDocumentTemplatePage();
    }

    @Test
    public void verifyPageToolbarElements() {
        common.logPrint("START :: Verifying Invoice Template page toolbar elements");
        loginWithAdminUser();
        invoiceTemplatePage.verifyPageToolbarElements();
    }

    @Test
    public void verifyCreatePageUIElements() {
        common.logPrint("START :: Verifying Invoice Template create page UI elements");
        loginWithAdminUser();
        invoiceTemplatePage.verifyCreatePageUIElements();
    }

    @Test
    public void verifyMandatoryFields() {
        common.logPrint("START :: Verifying Invoice Template mandatory fields");
        loginWithAdminUser();
        invoiceTemplatePage.verifyMandatoryFields();
    }

    @Test
    public void verifyCancelButton() {
        common.logPrint("START :: Verifying Invoice Template cancel button");
        loginWithAdminUser();
        invoiceTemplatePage.verifyCancelButton();
    }

    @Test
    public void createInvoiceTemplate() {
        common.logPrint("START :: Creating Invoice Template");
        loginWithAdminUser();
        invoiceTemplatePage.createDocumentTemplate();
    }

    @Test
    public void readInvoiceTemplate() {
        common.logPrint("START :: Reading Invoice Template from the grid");
        loginWithAdminUser();
        invoiceTemplatePage.readDocumentTemplate();
    }

    @Test
    public void updateInvoiceTemplate() {
        common.logPrint("START :: Updating Invoice Template");
        loginWithAdminUser();
        invoiceTemplatePage.updateDocumentTemplate();
    }

    @Test
    public void deleteInvoiceTemplate() {
        common.logPrint("START :: Deleting Invoice Template");
        loginWithAdminUser();
        invoiceTemplatePage.deleteDocumentTemplate();
    }
}
