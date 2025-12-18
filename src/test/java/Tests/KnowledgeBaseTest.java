package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class KnowledgeBaseTest extends BasePage {


    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseTest.class);

    @Test
    public void goToKnowledgeBasePage(){
        common.logPrint("Verifying navigation to the Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.goToKnowledgeBasePage();
    }

    @Test
    public void verifyColumnsAndElements(){
        common.logPrint("Verifying columns and UI elements on the Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.verifyColumnsAndElements();
    }

    @Test
    public void validateSearch(){
        common.logPrint("Verifying search functionality on the Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.validateSearch();
    }

    @Test
    public void validateHorizontalView(){
        common.logPrint("Verifying horizontal view layout on the Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.validateHorizontalView();
    }

    @Test
    public void validateCreatePageElements(){
        common.logPrint("Verifying all UI elements on the Create Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.validateCreatePageElements();
    }

    @Test
    public void validateFileUpload(){
        common.logPrint("Verifying file upload functionality in Knowledge Base creation");
        loginWithAdminUser();
        knowledgeBasePage.validateFileUpload();
    }

    @Test
    public void validateAddingText(){
        common.logPrint("Verifying adding text content to Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateAddingText();
    }

    @Test
    public void validateAddingWebsite(){
        common.logPrint("Verifying adding website content to Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateAddingWebsite();
    }

    @Test
    public void validateQA(){
        common.logPrint("Verifying adding Q&A content to Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateQA();
    }

    @Test
    public void validateAddingAllTheKBTypes(){
        common.logPrint("Verifying adding all Knowledge Base content types");
        loginWithAdminUser();
        knowledgeBasePage.validateFileUpload();
        knowledgeBasePage.validateAddingText();
        knowledgeBasePage.validateAddingWebsite();
        knowledgeBasePage.validateQA();
    }

    @Test
    public void validateKBShowsUpInTheProduct(){
        common.logPrint("Verifying Knowledge Base content is visible in the Product");
        loginWithAdminUser();
        knowledgeBasePage.validateKBShowsUpInTheProduct();
    }

    @Test
    public void validateEditingAKB(){
        common.logPrint("Verifying editing functionality of Knowledge Base content");
        loginWithAdminUser();
        knowledgeBasePage.validateEditingAKB();
    }

    @Test
    public void validatingMandatoryField(){
        common.logPrint("Verifying mandatory field validations in Knowledge Base creation");
        loginWithAdminUser();
        knowledgeBasePage.validatingMandatoryField();
    }

    @Test
    public void validatingMultipleFileUploads(){
        common.logPrint("Verifying multiple file upload functionality in Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validatingMultipleFileUploads();
    }

    @Test
    public void validateAddingMultipleTexts(){
        common.logPrint("Verifying adding multiple text entries to Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateAddingMultipleTexts(3);
    }

    @Test
    public void verifyEditElements(){
        common.logPrint("Verifying UI elements on the Edit Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.verifyEditElements();
    }

    @Test
    public void validateDeletingMultipleTexts(){
        common.logPrint("Verifying deletion of multiple text entries from Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleTexts(3);
    }

    @Test
    public void validateDeletingMultipleWebsites(){
        common.logPrint("Verifying deletion of multiple website entries from Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleWebsites(3);
    }

    @Test
    public void validateDeletingMultipleQA(){
        common.logPrint("Verifying deletion of multiple Q&A entries from Knowledge Base");
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleQA(3);
    }

    @Test
    public void validatePagination(){
        common.logPrint("Verifying pagination functionality on the Knowledge Base page");
        loginWithAdminUser();
        knowledgeBasePage.validatePagination();
    }

    @Test
    public void validateView(){
        common.logPrint("Verifying viewing Knowledge Base content details");
        loginWithAdminUser();
        knowledgeBasePage.validateView();
    }

    @Test
    public void validateResetButton(){
        common.logPrint("Verifying Reset button functionality on Knowledge Base forms");
        loginWithAdminUser();
        knowledgeBasePage.validateResetButton();
    }

}
