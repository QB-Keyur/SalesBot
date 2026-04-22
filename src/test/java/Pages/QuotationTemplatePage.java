package Pages;

import org.openqa.selenium.WebDriver;

public class QuotationTemplatePage extends DocumentTemplatePage {

    public QuotationTemplatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPagePath() {
        return "quotation-template";
    }

    @Override
    protected String getListHeaderLocator() {
        return QUOTATIONTEMPLATEHEADER;
    }

    @Override
    protected String getPageDisplayName() {
        return "Quotation";
    }
}
