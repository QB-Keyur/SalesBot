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






























}
