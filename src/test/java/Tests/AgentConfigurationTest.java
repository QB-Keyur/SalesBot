package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import javax.swing.*;

public class AgentConfigurationTest extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AgentConfigurationTest.class);

    @Test
    public void goToAgentConfigurationPage(){
        loginWithAdminUser();
        agentConfigurationPage.goToAgentConfigurationPage();
    }

    @Test
    public void verifyColumns(){
        loginWithAdminUser();
        agentConfigurationPage.verifyColumnsAndElemensts();
    }

    @Test
    public void verifySearch(){
        loginWithAdminUser();
        agentConfigurationPage.verifySearch();
    }

    @Test
    public void verifyRefresh(){
        loginWithAdminUser();
        agentConfigurationPage.verifyRefresh();
    }

    @Test
    public void validateSorting(){
        loginWithAdminUser();
        agentConfigurationPage.goToAgentConfigurationPage();
        agentConfigurationPage.validateSorting(5, "int", null, SortOrder.DESCENDING);
    }

    @Test
    public void verifyActivateButton(){
        loginWithAdminUser();
        agentConfigurationPage.verifyActivateButton();
    }

    @Test
    public void verifyActiveButtonNegative(){
        loginWithAdminUser();
        agentConfigurationPage.verifyActiveButtonNegative();
    }

    @Test
    public void horizontalView(){
        loginWithAdminUser();
        agentConfigurationPage.horizontalView();
    }

    @Test
    public void verifyCreatePageElements(){
        loginWithAdminUser();
        agentConfigurationPage.verifyCreatePageElements();
    }

    @Test
    public void verifyEditPageElements(){
        loginWithAdminUser();
        agentConfigurationPage.verifyEditPageElements();
    }

    @Test
    public void verifyUsingTheResetButton(){
        loginWithAdminUser();
        agentConfigurationPage.verifyUsingTheResetButton();
    }

    @Test
    public void verifyCancelAndBackButton(){
        loginWithAdminUser();
        agentConfigurationPage.verifyCancelAndBackButton();
    }

    @Test
    public void mandatoryFieldVerification(){
        loginWithAdminUser();
        agentConfigurationPage.mandatoryFieldVerification();
    }

    @Test
    public void addANewAgentValidData(){
        loginWithAdminUser();
        agentConfigurationPage.addANewAgentValidData();
    }

    @Test
    public void editingAnAgent(){
        loginWithAdminUser();
        agentConfigurationPage.editingAnAgent();
    }

    @Test
    public void deletingAnAgent(){
        loginWithAdminUser();
        agentConfigurationPage.deletingAnAgent();
    }

    @Test
    public void viewAnAgent(){
        loginWithAdminUser();
        agentConfigurationPage.viewAddedAgent();
    }

    @Test
    public void activeInactive(){
        loginWithAdminUser();
        agentConfigurationPage.activeInactive();
    }

    @Test
    public void horizontalViews(){
        loginWithAdminUser();
        agentConfigurationPage.horizontalViews();
    }

    @Test
    public void pagination(){
        loginWithAdminUser();
        agentConfigurationPage.pagination();
    }

    @Test
    public void filters(){
        loginWithAdminUser();
        agentConfigurationPage.filters();
    }

    @Test
    public void createAndViewReflectionInPlayground(){
        loginWithAdminUser();
        agentConfigurationPage.createAndViewReflectionInPlayground();
    }

}
