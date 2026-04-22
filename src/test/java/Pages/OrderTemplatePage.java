package Pages;

import org.openqa.selenium.WebDriver;

public class OrderTemplatePage extends DocumentTemplatePage {

    public OrderTemplatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPagePath() {
        return "order-template";
    }

    @Override
    protected String getListHeaderLocator() {
        return ORDERTEMPLATEHEADER;
    }

    @Override
    protected String getPageDisplayName() {
        return "Order";
    }
}
