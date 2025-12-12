package Tests;

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
        agentConfigurationPage.validateSorting(3, "int", null, SortOrder.DESCENDING);

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




}
