package Pages;

import org.openqa.selenium.WebDriver;

public class InvoiceTemplatePage extends DocumentTemplatePage {

    public InvoiceTemplatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPagePath() {
        return "invoice-template";
    }

    @Override
    protected String getListHeaderLocator() {
        return INVOICETEMPLATEHEADER;
    }

    @Override
    protected String getPageDisplayName() {
        return "Invoice";
    }
}
