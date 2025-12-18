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
        common.logPrint("Verifying navigation to the Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.goToAgentConfigurationPage();
    }

    @Test
    public void verifyColumns(){
        common.logPrint("Verifying columns and UI elements on the Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.verifyColumnsAndElemensts();
    }

    @Test
    public void verifySearch(){
        common.logPrint("Verifying search functionality on the Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.verifySearch();
    }

    @Test
    public void verifyRefresh(){
        common.logPrint("Verifying refresh functionality on the Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.verifyRefresh();
    }

    @Test
    public void validateSorting(){
        common.logPrint("Verifying sorting functionality on the Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.goToAgentConfigurationPage();
        agentConfigurationPage.validateSorting(5, "int", null, SortOrder.DESCENDING);
    }

    @Test
    public void verifyActivateButton(){
        common.logPrint("Verifying activation of an agent using the Activate button");
        loginWithAdminUser();
        agentConfigurationPage.verifyActivateButton();
    }

    @Test
    public void verifyActiveButtonNegative(){
        common.logPrint("Verifying negative scenario for Activate button on Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.verifyActiveButtonNegative();
    }

    @Test
    public void horizontalView(){
        common.logPrint("Verifying horizontal view layout in Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.horizontalView();
    }

    @Test
    public void verifyCreatePageElements(){
        common.logPrint("Verifying all UI elements on the Create Agent page");
        loginWithAdminUser();
        agentConfigurationPage.verifyCreatePageElements();
    }

    @Test
    public void verifyEditPageElements(){
        common.logPrint("Verifying all UI elements on the Edit Agent page");
        loginWithAdminUser();
        agentConfigurationPage.verifyEditPageElements();
    }

    @Test
    public void verifyUsingTheResetButton(){
        common.logPrint("Verifying Reset button functionality on the Agent form");
        loginWithAdminUser();
        agentConfigurationPage.verifyUsingTheResetButton();
    }

    @Test
    public void verifyCancelAndBackButton(){
        common.logPrint("Verifying Cancel and Back button functionality on Agent pages");
        loginWithAdminUser();
        agentConfigurationPage.verifyCancelAndBackButton();
    }

    @Test
    public void mandatoryFieldVerification(){
        common.logPrint("Verifying mandatory field validations while creating or editing an agent");
        loginWithAdminUser();
        agentConfigurationPage.mandatoryFieldVerification();
    }

    @Test
    public void addANewAgentValidData(){
        common.logPrint("Verifying creation of a new agent with valid data");
        loginWithAdminUser();
        agentConfigurationPage.addANewAgentValidData();
    }

    @Test
    public void editingAnAgent(){
        common.logPrint("Verifying editing functionality for an existing agent");
        loginWithAdminUser();
        agentConfigurationPage.editingAnAgent();
    }

    @Test
    public void deletingAnAgent(){
        common.logPrint("Verifying deletion of an agent from Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.deletingAnAgent();
    }

    @Test
    public void viewAnAgent(){
        common.logPrint("Verifying viewing details of an agent");
        loginWithAdminUser();
        agentConfigurationPage.viewAddedAgent();
    }

    @Test
    public void activeInactive(){
        common.logPrint("Verifying activate and deactivate functionality for an agent");
        loginWithAdminUser();
        agentConfigurationPage.activeInactive();
    }

    @Test
    public void horizontalViews(){
        common.logPrint("Verifying alternate horizontal views in Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.horizontalViews();
    }

    @Test
    public void pagination(){
        common.logPrint("Verifying pagination functionality on Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.pagination();
    }

    @Test
    public void filters(){
        common.logPrint("Verifying filter functionality on Agent Configuration page");
        loginWithAdminUser();
        agentConfigurationPage.filters();
    }

    @Test
    public void createAndViewReflectionInPlayground(){
        common.logPrint("Verifying creation and viewing of agent reflection in Playground");
        loginWithAdminUser();
        agentConfigurationPage.createAndViewReflectionInPlayground();
    }


}
