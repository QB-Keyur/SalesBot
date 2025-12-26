package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.swing.*;

public class WhatsAppTemplateTest extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(WhatsAppTemplateTest.class);

    @Test
    public void goToWhatsAppTemplatePage(){
        common.logPrint("Verifying navigation to the WhatsApp Template Page");
        loginWithAdminUser();
        whatsAppTemplatePage.goToWhatsAppTemplatePage();
    }

    @Test
    public void verifyAllTheUIElements(){
        common.logPrint("Verifying all UI elements on the WhatsApp Template Page");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyAllTheUIElements();
    }

    @Test
    public void verifyAllTheCreateUIElements(){
        common.logPrint("Verifying all UI elements on the Create WhatsApp Template screen");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyAllTheCreateUIElements();
    }

    @Test
    public void verifyHowToCreateWhatsAppTemplateDropdown(){
        common.logPrint("Verifying 'How to Create WhatsApp Template' dropdown behavior");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyHowToCreateWhatsAppTemplateDropdown();
    }

    @Test
    public void verifyMandatoryFields(){
        common.logPrint("Verifying mandatory field validations while creating a WhatsApp Template");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyMandatoryFields();
    }

    @Test
    public void verifyAddingANewTemplate(){
        common.logPrint("Verifying creation of a new WhatsApp Template with valid data");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyAddingANewTemplate(
                "Marketing","English","Text","Quick Reply");
    }

    @Test
    public void verifyingPreviewTemplate(){
        common.logPrint("Verifying Live Preview of the WhatsApp Template");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyingPreviewTemplate();
    }

    @Test
    public void verifyingHorizontalView(){
        common.logPrint("Verifying Horizontal View of WhatsApp Templates");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyingHorizontalView();
    }

    @Test
    public void verifyingSearch(){
        common.logPrint("Verifying search functionality on WhatsApp Templates");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyingSearch();
    }

    @Test
    public void verifyingAddVariable(){
        common.logPrint("Verifying Add Variable functionality in WhatsApp Template editor");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyingAddVariable(2);
    }

    @Test
    public void verifyingPagination(){
        common.logPrint("Verifying Pagination functionality in WhatsApp Template editor");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyingPagination();
    }

    @Test
    public void verifyRefreshButtonUpdatesTheServerSyncStatus(){
        common.logPrint("Verifying Meta Status Sync functionality in WhatsApp Template editor");
        loginWithAdminUser();
        whatsAppTemplatePage.verifyRefreshButtonUpdatesTheServerSyncStatus();
    }

    @Test
    public void validateSorting(){
        loginWithAdminUser();
        whatsAppTemplatePage.goToWhatsAppTemplatePage();
        productPage.validateSorting(2, "int", null, SortOrder.DESCENDING);
    }

}
