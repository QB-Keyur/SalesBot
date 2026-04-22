package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class DocumentTemplatePage extends Locators {

    protected final Common common;

    protected DocumentTemplatePage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    protected abstract String getPagePath();

    protected abstract String getListHeaderLocator();

    protected abstract String getPageDisplayName();

    private String buildUniqueName(String prefix) {
        String cleanPrefix = prefix.replaceAll("[^A-Za-z]", "");
        return cleanPrefix + " " + common.generateRandomChars(8);
    }

    private void fillTemplateForm(String templateName) {
        String filePath = Paths.get("TestData", "1.png").toAbsolutePath().toString();

        common.waitUntilElementToBeVisible(DTTEMPLATENAMEINPUT);
        common.click(DTTEMPLATENAMEINPUT);
        common.ctrlAAndBackspace();
        common.type(DTTEMPLATENAMEINPUT, templateName);

        common.waitUntilElementToBeVisible(DTUPLOADHEADERLOGOINPUT);
        common.click(DTUPLOADHEADERLOGOINPUT);
        common.pause(2);
        common.uploadFile(DTUPLOADHEADERLOGOINPUT, filePath);

        common.waitUntilElementToBeVisible(DTFROMBODYTEXTAREA);
        common.click(DTFROMBODYTEXTAREA);
        common.type(DTFROMBODYTEXTAREA, "From body for " + templateName);

        common.waitUntilElementToBeVisible(DTTOBODYTEXTAREA);
        common.click(DTTOBODYTEXTAREA);
        common.type(DTTOBODYTEXTAREA, "To body for " + templateName);

        common.waitUntilElementToBeVisible(DTTERMSANDCONDITIONSINPUT);
        common.click(DTTERMSANDCONDITIONSINPUT);
        common.type(DTTERMSANDCONDITIONSINPUT, "Terms and conditions for " + templateName);

        common.waitUntilElementToBeVisible(DTFOOTERINPUT);
        common.click(DTFOOTERINPUT);
        common.ctrlAAndBackspace();
        common.type(DTFOOTERINPUT, "Footer for " + templateName);

        common.waitUntilElementToBeVisible(DTSIGNATUREUPLOADINPUT);
        common.click(DTSIGNATUREUPLOADINPUT);
        common.pause(2);
        common.uploadFile(DTSIGNATUREUPLOADINPUT, filePath);
    }

    private String searchRowXpath(String templateName) {
        return "//tbody//td[contains(text(),'" + templateName + "')]";
    }

    private void openCreateForm() {
        common.waitUntilElementToBeVisible(DTCREATE);
        common.click(DTCREATE);
    }

    private void saveTemplate() {
        common.waitUntilElementToBeVisible(DTSAVEBUTTON);
        common.click(DTSAVEBUTTON);
    }

    private void openRowActionMenu() {
        common.waitUntilElementToBeVisible(DTROWACTIONBUTTON);
        common.click(DTROWACTIONBUTTON);
    }

    private void searchAndAssertTemplate(String templateName) {
        common.waitUntilElementToBeVisible(DTSEARCH);
        common.click(DTSEARCH);
        common.ctrlAAndBackspace();
        common.type(DTSEARCH, templateName);
        common.pause(1);

        String rowXpath = searchRowXpath(templateName);
        common.waitUntilElementToBeVisible(rowXpath);
        common.assertElementPresent(rowXpath);
    }

    public void goToDocumentTemplatePage() {
        common.openNewUrl(EnvConfig.getWebUrl() + getPagePath());
        common.waitUntilElementToBeVisible(getListHeaderLocator());
        common.logPrint("Navigated to " + getPageDisplayName() + " Template page.");
    }

    public void verifyPageToolbarElements() {
        goToDocumentTemplatePage();

        Map<String, String> locators = new LinkedHashMap<>();
        locators.put(getListHeaderLocator(), getPageDisplayName() + " Header");
        locators.put(DTSEARCH, getPageDisplayName() + " Search");
        locators.put(DTFILTERS, getPageDisplayName() + " Filters");
        locators.put(DTCREATE, getPageDisplayName() + " Create Button");

        for (Map.Entry<String, String> entry : locators.entrySet()) {
            common.assertElementPresent(entry.getKey());
            common.logPrint("Step :: Verified presence of " + entry.getValue());
        }
    }

    public void verifyCreatePageUIElements() {
        goToDocumentTemplatePage();

        openCreateForm();

        Map<String, String> locators = new LinkedHashMap<>();
        locators.put(DTCREATEHEADER, getPageDisplayName() + " Create Header");
        locators.put(DTTEMPLATEDETAILS, "Template Details");
        locators.put(DTTEMPLATENAME, "Template Name Label");
        locators.put(DTTEMPLATENAMEINPUT, "Template Name Input");
        locators.put(DTUPLOADHEADERLOGO, "Upload Header Logo Label");
        locators.put(DTUPLOADHEADERLOGOINPUT, "Upload Header Logo Input");
        locators.put(DTUPLOADHEADERLOGOBUTTON, "Upload Header Logo Button");
        locators.put(DTDEFAULTTEMPLATE, "Is Default Template Label");
        locators.put(DTDEFAULTTEMPLATETOGGLE, "Default Template Toggle");
        locators.put(DTFROMSECTION, "From Section");
        locators.put(DTFROMBODYTEXTAREA, "From Body Textarea");
        locators.put(DTFROMADDCVARIABLE, "From Add Variable");
        locators.put(DTTOSECTION, "To Section");
        locators.put(DTTOBODYTEXTAREA, "To Body Textarea");
        locators.put(DTTOADDCVARIABLE, "To Add Variable");
        locators.put(DTTERMSANDCONDITIONS, "Terms & Conditions");
        locators.put(DTTERMSANDCONDITIONSINPUT, "Terms & Conditions Input");
        locators.put(DTFOOTERCONTENT, "Footer Content");
        locators.put(DTFOOTERINPUT, "Footer Input");
        locators.put(DTSIGNATUREUPLOAD, "Signature Upload Label");
        locators.put(DTSIGNATUREUPLOADINPUT, "Signature Upload Input");
        locators.put(DTLIVEPREVIEW, "Live Preview");
        locators.put(DTCANCELBUTTON, "Cancel Button");
        locators.put(DTSAVEBUTTON, "Save Button");

        for (Map.Entry<String, String> entry : locators.entrySet()) {
            common.assertElementPresent(entry.getKey());
            common.logPrint("Step :: Verified presence of " + entry.getValue());
        }
    }

    public void verifyMandatoryFields() {
        goToDocumentTemplatePage();

        openCreateForm();
        saveTemplate();

        common.pause(1);
        common.assertElementPresent(DTTEMPLATENAMEVALIDATION);
        common.assertElementPresent(DTUPLOADHEADERLOGOVALIDATION);
        common.assertElementPresent(DTFROMBODYVALIDATION);
        common.assertElementPresent(DTTOBODYVALIDATION);
    }

    public void verifyCancelButton() {
        goToDocumentTemplatePage();

        openCreateForm();

        common.waitUntilElementToBeVisible(DTCANCELBUTTON);
        common.click(DTCANCELBUTTON);

        common.waitUntilElementToBeVisible(getListHeaderLocator());
        common.assertElementPresent(getListHeaderLocator());
    }

    public String createDocumentTemplate() {
        goToDocumentTemplatePage();

        String templateName = buildUniqueName(getPageDisplayName());

        openCreateForm();
        fillTemplateForm(templateName);
        saveTemplate();

        common.waitUntilElementToBeVisible(DTCREATEDSUCCESS);
        common.assertElementPresent(DTCREATEDSUCCESS);
        searchAndAssertTemplate(templateName);

        return templateName;
    }

    public String readDocumentTemplate() {
        String templateName = createDocumentTemplate();
        openRowActionMenu();
        common.waitUntilElementToBeVisible(DTVIEWMENUITEM);
        common.assertElementPresent(DTVIEWMENUITEM);
        common.click(DTVIEWMENUITEM);
        searchAndAssertTemplate(templateName);
        return templateName;
    }

    public String updateDocumentTemplate() {
        String templateName = createDocumentTemplate();
        String updatedTemplateName = templateName + " " + common.generateRandomChars(4);

        searchAndAssertTemplate(templateName);
        openRowActionMenu();
        common.waitUntilElementToBeVisible(DTEDITMENUITEM);
        common.click(DTEDITMENUITEM);

        fillTemplateForm(updatedTemplateName);
        saveTemplate();

        common.waitUntilElementToBeVisible(DTUPDATEDSUCCESS);
        common.assertElementPresent(DTUPDATEDSUCCESS);
        searchAndAssertTemplate(updatedTemplateName);
        Assert.assertTrue(existsElement(searchRowXpath(templateName)), "Old template name should not remain after update");

        return updatedTemplateName;
    }

    public String deleteDocumentTemplate() {
        String templateName = createDocumentTemplate();

        searchAndAssertTemplate(templateName);
        openRowActionMenu();
        common.waitUntilElementToBeVisible(DTDELETEMENUITEM);
        common.click(DTDELETEMENUITEM);

        common.waitUntilElementToBeVisible(DTDELETECANCELBUTTON);
        common.click(DTDELETECANCELBUTTON);

        openRowActionMenu();
        common.waitUntilElementToBeVisible(DTDELETEMENUITEM);
        common.click(DTDELETEMENUITEM);
        common.waitUntilElementToBeVisible(DTDELETECONFIRMBUTTON);
        common.click(DTDELETECONFIRMBUTTON);

        common.waitUntilElementToBeVisible(DTDELETEDSUCCESS);
        common.assertElementPresent(DTDELETEDSUCCESS);
        Assert.assertFalse(existsElement(searchRowXpath(templateName)), "Deleted template should not remain in the grid");

        return templateName;
    }
}
