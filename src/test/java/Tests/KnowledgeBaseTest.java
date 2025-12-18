package Tests;

import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class KnowledgeBaseTest extends BasePage {


    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseTest.class);

    @Test
    public void goToKnowledgeBasePage(){
        loginWithAdminUser();
        knowledgeBasePage.goToKnowledgeBasePage();
    }

    @Test
    public void verifyColumnsAndElements(){
        loginWithAdminUser();
        knowledgeBasePage.verifyColumnsAndElements();
}

    @Test
    public void validateSearch(){
        loginWithAdminUser();
        knowledgeBasePage.validateSearch();
    }

    @Test
    public void validateHorizontalView(){
        loginWithAdminUser();
        knowledgeBasePage.validateHorizontalView();
    }

    @Test
    public void validateCreatePageElements(){
        loginWithAdminUser();
        knowledgeBasePage.validateCreatePageElements();
    }

    @Test
    public void validateFileUpload(){
        loginWithAdminUser();
        knowledgeBasePage.validateFileUpload();
    }

    @Test
    public void validateAddingText(){
        loginWithAdminUser();
        knowledgeBasePage.validateAddingText();
    }

    @Test
    public void validateAddingWebsite(){
        loginWithAdminUser();
        knowledgeBasePage.validateAddingWebsite();
    }

    @Test
    public void validateQA(){
        loginWithAdminUser();
        knowledgeBasePage.validateQA();
    }

    @Test
    public void validateAddingAllTheKBTypes(){
        loginWithAdminUser();
        knowledgeBasePage.validateFileUpload();
        knowledgeBasePage.validateAddingText();
        knowledgeBasePage.validateAddingWebsite();
        knowledgeBasePage.validateQA();
    }

    @Test
    public void validateKBShowsUpInTheProduct(){
        loginWithAdminUser();
        knowledgeBasePage.validateKBShowsUpInTheProduct();
    }

    @Test
    public void validateEditingAKB(){
        loginWithAdminUser();
        knowledgeBasePage.validateEditingAKB();
    }

    @Test
    public void validatingMandatoryField(){
        loginWithAdminUser();
        knowledgeBasePage.validatingMandatoryField();
    }

    @Test
    public void validatingMultipleFileUploads(){
        loginWithAdminUser();
        knowledgeBasePage.validatingMultipleFileUploads();

    }

    @Test
    public void validateAddingMultipleTexts(){
        loginWithAdminUser();
        knowledgeBasePage.validateAddingMultipleTexts(3);
    }

    @Test
    public void verifyEditElements(){
        loginWithAdminUser();
        knowledgeBasePage.verifyEditElements();
    }

    @Test
    public void validateDeletingMultipleTexts(){
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleTexts(3);
    }

    @Test
    public void validateDeletingMultipleWebsites(){
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleWebsites(3);
    }

    @Test
    public void validateDeletingMultipleQA(){
        loginWithAdminUser();
        knowledgeBasePage.validateDeletingMultipleQA(3);
    }

    @Test
    public void validatePagination(){
        loginWithAdminUser();
        knowledgeBasePage.validatePagination();
    }

    @Test
    public void validateView(){
        loginWithAdminUser();
        knowledgeBasePage.validateView();
    }

    @Test
    public void validateResetButton(){
        loginWithAdminUser();
        knowledgeBasePage.validateResetButton();
    }

}
