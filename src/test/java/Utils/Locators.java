package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Locators extends BasePage {
    int DRIVER_WAIT = 5;

    protected WebDriver driver;

    public Locators(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    public static String createdSuccessfully = "//div[contains(text(), 'Created successfully')]|//div[contains(text(), 'Contact created successfully')]";
    public static String passwordChangedSuccessfully = "//div[contains(text(), 'Password changed successfully')]";
    public static String userAccountCreatedSuccessfully = "//div[contains(text(), 'User account created successfully.')]";
    public static String roleAndPermissionAddedSuccessfully = "//div[contains(text(), 'Role and permissions added successfully')]";
    public static String DeletedSuccessfully = "//div[contains(text(), 'Deleted Successfully')] | //div[contains(normalize-space(),'Delete')]";
    public static String RoleNameIsAlreadyExist = "//div[contains(text(), 'Role name already exists')]";
    public static String invitationSentSuccessfully = "//div[contains(text(), 'Invitation Sent Successfully')]";
    public static String UpdatedSuccessfully = "//div[contains(text(), 'Contact updated successfully')]";
    public static String yourAccountIsVerified = "//div[contains(text(), 'Your account is verified.')]";
    public static String passwordHasBeenUpdated = "//div[contains(text(), 'Password has been updated')]";
    public static String invalidOtpValidation = "//div[contains(text(), 'Invalid OTP or OTP is expired! Please Try Again.')]";
    public static String passwordResetLinkSuccess = "//div[contains(text(), 'Password reset link has been sent to your email')]";
    public static String otpSentSuccessfully = "//div[contains(text(),'An OTP is sent to') and contains(text(),'Please Verify your email')]";
    //public static String UpdatedSuccessfully = "//div[contains(text(), 'Updated successfully')]";

    //Locators for the validation messages
    public static String ERRORMESSAGEFORINVALIDEMAIL = "//div[contains(text(), 'Invalid Credentials.')]";
    public static String LOGINSUCCESSMESSAGE = "//div[contains(text(), 'Login successful')]";
    public static String EMAILINP = "//input[@name='email']";
    public static String PASSWORDINP = "//input[@name='password']";
    public static String CONFIRMPASSWORDINP = "//input[@name='confirmpassword']";
    public static String LOGINBTN = "//button[@type='submit']";
    public static String verifyOTPBtn = "//span[contains(text(),'Verify OTP')]/ancestor::button";
    public static String ERROREMAILBLANK = "//span[contains(text(),'Email is required')]";
    public static String ERRORPASSWORDBLANK = "//span[contains(text(),'Password is required')]";
    public static String FORGOTPASSWORD = "//a[contains(text(),'Forgot password?')]";

    public static String SIGNUPLINK = "//span[contains(text(),'Sign Up')]";
    public static String enterPasswordInp = "//input[@name ='password']";
    public static String confirmPasswordInp = "//input[@name ='confirmPassword']";

    //Locators for the Forgot password
    public static String ENTEREMAILINPFORGOT = "//input[@name='email']";
    public static String GETOTPBTN = "//span[contains(text(),'Get OTP')]/ancestor::button";
    public static String BACKTOLOGINBTN = "//span[contains(text(),'Login')]/ancestor::a | //span[contains(text(),'Log In')]/ancestor::a";

    //Locators for the yopmail
    public static String emailInpYopMail = "//input[@placeholder='Enter your inbox here']";
    public static String enterArrowBtn = "//button[@title='Check Inbox @yopmail.com']";
    public static String otpGetYopmail = "(//td[contains(text(),'This code is ')]/ancestor::td//tbody)[2]//td";
    public static String refreshButtonYopmail = "//button[@id='refresh']";
    public static String resetPassword = "//a[contains(text(),'Reset Password')]";
    public static String otpInp1 = "(//input[@type='text'])[1]";
    public static String otpInp2 = "(//input[@type='text'])[2]";
    public static String otpInp3 = "(//input[@type='text'])[3]";
    public static String otpInp4 = "(//input[@type='text'])[4]";
    public static String otpInp5 = "(//input[@type='text'])[5]";
    public static String acceptInvitationButton = "//a[contains(text(),'Accept Invitation')]";

    //Locators for the Onboarding

    //Locators for the Product Page
    public static String PRODUCTMENU = "//*[self::span or self::button][text()='Product / Service']";
    public static String SRNO = "//*[self::span or self::div][text()='#']";
    public static String PRODUCTNAMES = "//*[self::span or self::div][text()='Product Name']";
    public static String CATEGORY = "//*[self::span or self::div][text()='Category']";
    public static String DESCRIPTION = "//*[self::span or self::div][text()='Description']";
    public static String KBARTICLE = "//*[self::span or self::div][text()='KB Article']";
    public static String CREATEDDATE = "//*[self::span or self::div][text()='Created Date']";
    public static String ACTIONS = "//*[self::span or self::div][text()='Actions']| //*[self::span or self::div][text()='Action']";
    public static String SEARCH = "//input[@placeholder='Search...']";
    public static String REFRESH = "//span[text()='Filters']/following::button[1] | //span[contains(@class,'css-1sh91j5')]/parent::button[contains(@class,'css-q8p1uw')]";
    public static String FILTERS = "//button[@type='button']//span[normalize-space(.)='Filters']";
    public static String CREATE = "//button[@type='button']//span[normalize-space(.)='Create']";
    public static String MULTITABHOR = "(//button[@role='tab'])[2]";
    public static String MULTITABVER = "(//button[@role='tab'])[1]";
    public static String TOTAL = "//div[contains(text(),'Total')] | //div[@class=\"MuiBox-root css-a7l4db\"] | //h6[text()='Product']/following-sibling::div";
    public static String ROWSPERPAGE = "//div[@class=\"MuiBox-root css-a7l4db\"] | //p[text()='Rows per page:'] | //h6[text()='Product']/following-sibling::div";
    public static String SEARCHRESULTS = "//div[@aria-rowspan='1']/preceding-sibling::div[@aria-colindex='2' and contains(text(),'+ randomValue +')]";
    public static String PHSEACRH = "//input[@placeholder='Search...']";
    public static String PHFILTERSEACRH = "//input[@placeholder='Select column']";
    public static String PHFILTERVAL = "//input[@placeholder='Enter value']";
    public static String FILTERDROPDOWNVAL = "//li[@data-option-index='0']";
    public static String PHFILTEROPERATOR = "//input[@placeholder='Select operator']";
    public static String CLOSEFILTER = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-xz9haa']";
    public static String PHPRODUCTNAME = "//input[@placeholder='Enter Product Name']";
    public static String PHPRODUCTCATEGORY = "//input[@placeholder='Create or Select Category']|//span[text()='Category']/following::input[1]";
    public static String PHPRODUCTCATEGORYNEW = "//li[starts-with(normalize-space(), 'Create')]";
    public static String PHPRODUCTDESCRIPTION = "//input[@placeholder='Enter Description'] | //textarea[@placeholder='Enter Description']";
    public static String PHPRODUCTKB = "//input[@placeholder='Select KB Article'] | //input[@placeholder='Enter KB Article'] | //span[text()='KB Article']/following::input[1]";
    public static String PHSELECTUNIT = "//input[@placeholder='Select Unit']";
    public static String PHPRICELIST = "//span[normalize-space()='Create Price List']/parent::button";
    public static String PHENTERPRICELISTNAME = "//input[@placeholder='Enter Price List Name']";
    public static String PHSELECTCOUNTRY = "//input[@placeholder='Select country']";
    public static String PHSELECTSTATE = "//input[@placeholder='Select state']";
    public static String PHSELECTCITY = "//input[@placeholder='Select city']";
    public static String PHENTERAMOUNT = "//input[@placeholder='Enter Amount']";
    public static String PHENTERDISCOUNT = "//input[@placeholder='Enter Discount']";
    public static String PHENTERDISCOUNTSTRATEGY = "//input[@placeholder='Enter Discount Strategy']";
    public static String PHSELECTCURRENCY = "//input[@placeholder='Select currency']";
    public static String PHENTEREFFECTIVEFROM = "//input[@placeholder='Enter Effective From']";
    public static String PHENTEREFFECTIVETO = "//input[@placeholder='Enter Effective To']";
    public static String PHPLANLIST = "//span[normalize-space()='Create Plan List']/parent::button";
    public static String PHENTERPLANLISTNAME = "//input[@placeholder='Enter Plan List Name']";
    public static String PHENTERDESCRIPTION = "//textarea[@placeholder='Enter Description']";
    public static String PHSELECTBILLINGCYCLE = "//input[@placeholder='Select Billing Cycle']";
    public static String PHENTERREDIRECTURL = "//input[@placeholder='Enter Redirect URL']";
    public static String PHENTERFEATURES = "//textarea[@placeholder='Enter Features']";

    public static String PHBASEPRICE = "//input[@name='base_price']";
    public static String PHTAX = "//input[@name='tax']";
    public static String PHDISCOUNT = "//input[@name='discount']";
    public static String PHTOTALPRICE = "//input[@name='total_price']";

    public static String PHPRICECANCEL = "(//span[normalize-space()='Cancel']/parent::button)[2]";
    public static String PHPRICESAVE = "(//span[normalize-space()='Save']/parent::button)[2]";

    public static String CLOSEBUTTON = "//button[@aria-label='Close alert'] | //button[@aria-label='Close']";
    public static String SAVEBUTTON = "//button[@type='button']/child::span[contains(text(),'Save')]";
    public static String SUCCESSMESSAGE = "//div[normalize-space(text())='Product created successfully']";
    public static String UPDATEMESSAGE = "//div[normalize-space(text())='Product updated successfully']";
    public static String SEARCHRESULT = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]| //tr[1]/td[2]";
    public static String EDIT = "//button[@aria-label=\"Edit\"]|(//span[@aria-label=\"Edit\"]/child::button)[1]";
    public static String EDITPRODUCTNAME = "//input[@name='name']";
    public static String DELETEPRODUCT = "(//button[@aria-label=\"Delete\"])[1]|(//span[@aria-label=\"Delete\"]/child::button)[1]";
    public static String DELETECONFIRMPRODUCT = "//button[@type='button']/child::span[contains(text(),'Delete')]|//span[contains(text(),'Delete')]/ancestor::button";
    public static String DELETEPRODUCTASSERT = "//div[contains(normalize-space(),'Deleted Successfully')] | //div[contains(@class,'MuiAlert-message') and contains(normalize-space(),'Delete')]";
    public static String VIEWBUTTON = "//button[@aria-label=\"View\"] | (//span[@aria-label=\"View\"]/child::button)[1]";
    public static String VIEWNAME = "//span[contains(text(),'Name')]/following::input[@value='IT Company']";
    public static String VIEWCATEGORY = "//span[contains(text(),'Category')]/following::input[@value='IT Company']";
    public static String VIEWDESC = "//span[contains(text(),'Description')]/following::input[@value='IT Company']";
    public static String VIEWKB = "//span[contains(text(),'KB Article')]/following::input[@value='IT Company']";
    public static String FILTERPRODUCTNAMEDROPDOWN = "//li[contains(text(),'Product Name')]";
    public static String FILTERCATEGORYFROPDOWN = "//li[contains(text(),'Category')]";
    public static String FILTERKBDROPDOWN = "//li[contains(text(),'KB Article')]";
    public static String FILTERCREATEDDATEDROPDOWN = "//li[contains(text(),'Created Date')]";
    public static String FILTEREQUALS = "//li[contains(text(),'Equals')]";
    public static String FILTERNOTEQUALS = "//li[contains(text(),'Not Equals')]";
    public static String FILTERCONTAINS = "//li[contains(text(),'Contains')]";
    public static String FILTERBEGINSWITH = "//li[contains(text(),'Begins With')]";
    public static String FILTERENDSWITH = "//li[contains(text(),'Ends With')]";
    public static String APPLYFILTER = "//button[@type='button']/child::span[contains(text(),'Apply Filter')]";
    public static String FILTERNAMERESULT = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]| //tbody/tr[1]/td[2]";
    public static String FILTERCATEGORYRESULT = "//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"]";
    public static String CLEARFILTER = "(//button[@title='Clear'])[1]";
    public static String PAGINATIONSR = "//div[@data-field=\"srNo\" and contains(text(),'32')]";
    public static String PAGINATIONROWS = "//div[@aria-haspopup=\"listbox\"]";

    //AGENT CONFIGURATION
    public static String AGENTCONFIGURATIONMENU = "//span[text() ='Agent Configuration'] | //span[text()='Agent & Probing']";
    public static String AGENTCONFIGURATIONMODULE = "//button[text()='Agent Configuration']";
    public static String ACHEADER = "//h6[normalize-space()='Agent Configuration']";
    public static String ACSEARCHBAR = "//input[@placeholder=\"Search...\"]";
    public static String ACSELECTALL = "//input[@type=\"checkbox\" and @xpath=\"1\"]";
    public static String ACSRNUMBER = "//span[normalize-space()='#'] | //div[normalize-space()='#']";
    public static String ACNAME = "//span[normalize-space()='Name']| //div[normalize-space()='Name']";
    public static String ACGREETINGS = "//span[normalize-space()='Greeting Message']| //div[normalize-space()='Greeting Message']";
    public static String ACPERSONALITY = "//span[normalize-space()='Personality']| //div[normalize-space()='Personality']";
    public static String ACPERSONA = "//span[normalize-space()='Persona']| //div[normalize-space()='Persona']";
    public static String ACPROMPT = "//span[normalize-space()='Prompt']| //div[normalize-space()='Prompt']";
    public static String ACSTATUS = "//span[normalize-space()='Status']| //div[normalize-space()='Status']";
    public static String ACACTIONS = "//span[normalize-space()='Actions']| //div[normalize-space()='Actions']";
    public static String ACTOTALROWS = "//div[contains(text(),'Total')] | //div[@class=\"MuiBox-root css-a7l4db\"] | //h6/following::div[1]";
    public static String ACROWSPERPAGE = "//p[contains(text(),'Rows per page:')] | //div[@class=\"MuiBox-root css-a7l4db\"] |  //h6/following::div[1]";
    public static String ACROWSPERPAGEDROPDOWN = "//input[@class='MuiSelect-nativeInput css-147e5lo']";
    public static String ACPREVIOUSPAGE = "//button[@title='Go to previous page']";
    public static String ACNEXTPAGE = "//button[@title='Go to next page']";
    public static String ACNAMEINDEX = "//div[@aria-rowspan='1']/preceding-sibling::div[@aria-colindex='3'] | //tbody/tr[1]/td[3]";
    public static String ACINACTIVEGRIDSTATUS = "(//span[text()='Inactive'])[1]";
    public static String ACACTIVEGRIDSTATUS = "//span[@class=\"MuiChip-label MuiChip-labelSmall css-oruufx\" and contains(text(),'Active')][1] " +
            "| (//span[contains(text(),'Status')]/following::span[text()='Active'])[1] " +
            "| (//div[contains(text(),'Status')]/following::span[text()='Active'])[1]";
    public static String ACINACTIVEGRIDSTATUSGRID = "(//span[text()='Inactive'])[1]/preceding::input[@type='checkbox'][1]";
    public static String ACACTIVTEBUTTON = "//button[@type='button']/child::span[contains(text(),'Active')]";
    public static String ACCHEADER = "//h6[normalize-space()='Create Agent Configuration']";
    public static String ACCINFO = "//strong[contains(text(),'The configured time zone')]";
    public static String ACCPERSONA = "//p[normalize-space()='Persona']";
    public static String ACCSELECTPERSONA = "//input[@placeholder=\"Select Persona\"]";
    public static String ACCPROMPT = "//p[normalize-space()='Prompt']";
    public static String ACCPERSONALITY1 = "//p[contains(text(),'personality')]";
    public static String ACCTEXTAREAPROMPT = "//textarea[@placeholder='Enter your agent prompt here... Use {{variable_name}} to insert dynamic values']";
    public static String ACCRULES = "//p[normalize-space()='Rules']";
    public static String ACCRULESDROPDOWN = "//input[@placeholder=\"Enter a new rule...\"]";
    public static String ACCCUSTOMVARIABLE = "//p[normalize-space()='Custom Variables']";
    public static String ACCADDVARIABLE = "//button[@type='button' and .//span[normalize-space()='Add Variable']]";
    public static String ACCAGENT = "//p[normalize-space()='Agent Info']";
    public static String ACCNAME = "//span[normalize-space()='Name']|//span[text()='Name']";
    public static String ACCNAMEINPUT = "//input[@placeholder=\"Enter Name\"]";
    public static String ACCNAME2 = "//span[text() ='{{name}}']";
    public static String ACCCOMPANYNAME = "//span[normalize-space()='Company Name']|//span[text()='Company Name']";
    public static String ACCCOMPANYNAME2 = "//span[text() ='{{company_name}}']";
    public static String ACCCOMPANYNAMEINPUT = "//input[@placeholder=\"Enter Company Name\"]";
    public static String ACCGREETINGS = "//span[normalize-space()='Greeting Message']|//span[text()='Greeting Message']";
    public static String ACCGREETINGINPUT = "//textarea[@name=\"greeting_message\"]";
    public static String ACCTIMEZONE = "//span[normalize-space()='Timezone']|//span[text()='Timezone']";
    public static String ACCTIMEZONEINPUT = "//input[@placeholder=\"Select Timezone\"]";

    // UPDATED: label renamed from "Follow Retry" to "Objection Count Limit"
    public static String ACCFOLLOWRETRY = "//span[normalize-space()='Objection Count Limit']|//span[text()='Objection Count Limit']";
    public static String ACCFOLLOWRETRYINPUT = "//input[@placeholder=\"Enter Objection Count Limit\"]";

    public static String ACCPERSONALITY = "//p[normalize-space()='Personality & Goal']|//p[text()='Personality & Goal']";
    public static String ACCPERSONALITY2 = "//span[normalize-space()='Personality']|//span[text()='Personality']";
    public static String ACCPERSONALITYINPUT = "//input[@name='personality']";

    // UPDATED: casing fix "Goal type" -> "Goal Type"
    public static String ACCGOAL = "//span[normalize-space()='Goal Type']|//span[text()='Goal Type']";
    public static String ACCGOAL1 = "//span[text()='{{goal_type}}']";
    public static String ACCGOALINPUT = "//input[@name=\"goal_type\"]";

    public static String ACCLANG = "//span[normalize-space()='Language']|//span[text()='Language']";
    public static String ACCLANGINPUT = "//input[@placeholder=\"Select Language\"]";
    public static String ACCOBJECTION = "//input[@name=\"follow_retry\"]";
    public static String ACCRESETCOUNTLIMIT = "//input[@name=\"reset_count_limit\"]";
    public static String ACCTHRESHOLD = "//input[@name=\"threshold_score\"]";
    public static String ACCCTA = "//input[@placeholder=\"Select CTA Type\"]";
    public static String ACCCOUNTRY = "//input[@placeholder=\"Select Country\"]";

    public static String ACCALLOWEMOJI = "//p[normalize-space()='Allow Emojis']|//p[text()='Allow Emojis']";
    public static String ACCRADIOYES1 = "//p[normalize-space()='Allow Emojis']/following::label[.//p[normalize-space()='Yes']][1]";
    public static String ACCRADIONO1 = "//p[normalize-space()='Allow Emojis']/following::label[.//p[normalize-space()='No']][1]";
    public static String ACCRADIOYES2 = "//p[normalize-space()='Allow Name Reference']/following::label[.//p[normalize-space()='Yes']][1]";
    public static String ACCRADIONO2 = "//p[normalize-space()='Allow Name Reference']/following::label[.//p[normalize-space()='No']][1]";
    public static String ACCRADIOYES3 = "//p[normalize-space()='Enable Probing']/following::label[.//p[normalize-space()='Yes']][1]";
    public static String ACCRADIONO3 = "//p[normalize-space()='Enable Probing']/following::label[.//p[normalize-space()='No']][1]";

    public static String ACCBUSINESSDETAILS = "//p[normalize-space()='Business Details']|//p[text()='Business Details']";
    public static String ACCCOREUSP = "//span[normalize-space()='Core USP']|//span[text()='Core USP']";
    public static String ACCCOREUSP1 = "//span[text()='{{core_usps}}']";
    public static String ACCCOREUSPINPUT = "//input[@placeholder=\"Your unique selling proposition\"]";
    public static String ACCCOREFEATURES = "//span[normalize-space()='Core Features']|//span[text()='Core Features']";
    public static String ACCCOREFEATURES1 = "//span[text()='{{core_features}}']";
    public static String ACCCOREFEATURESINPUT = "//input[@name=\"core_features\"]";
    public static String ACCCONTACTINFO = "//span[normalize-space()='Contact Info']|//span[text()='Contact Info']";
    public static String ACCCONTACTINFOINPUT = "//input[@name=\"contact_info\"] | //span[text()='Contact Info']/following::textarea[1]";
    public static String ACCCONTACTINFO2 = "//span[text()='{{contact_info}}']";
    public static String ACCCOMPANYDOMAIN = "//span[normalize-space()='Company Domain']|//span[text()='Company Domain']";
    public static String ACCCOMPANYDOMAININPUT = "//input[@name=\"company_domain\"]";

    // UPDATED: casing fix "Business focus" -> "Business Focus"
    public static String ACCBUSINESSFOCUS = "//span[normalize-space()='Business Focus']|//span[text()='Business Focus']";
    public static String ACCBUSINESSFOCUS2 = "//span[text()='{{business_focus}}']";
    public static String ACCBUSINESSFOCUINPUT = "//input[@name='business_focus']";

    // UPDATED: casing fix "Offer description" -> "Offer Description"
    public static String ACCOFFER = "//span[normalize-space()='Offer Description']|//span[text()='Offer Description']";
    public static String ACCOFFER1 = "//span[text()='{{offer_description}}']";
    public static String ACCOFFERINPUT = "//textarea[@name='offer_description']";

    // UPDATED: casing fix "Company description" -> "Company Description"
    public static String ACCCOMPANY = "//span[normalize-space()='Company Description']|//span[text()='Company Description']";
    public static String ACCCOMPANYINPUT = "//textarea[@name=\"company_description\"]";

    public static String ACCCANCELBUTTON = "//button[@type='button' and .//span[normalize-space()='Cancel']]";
    public static String ACCSAVEBUTTON = "//button[@type='button' and .//span[normalize-space()='Save']]";
    public static String ACCBACKBUTTON = "//button[@type='button']/following::h6[text()='Create Agent Configuration']";

    // Validation messages
    public static String ACCVALNAME = "//span[normalize-space()='Name is required']";
    public static String ACCVALCOMPANYNAME = "//span[normalize-space()='Company name is required']";
    public static String ACCVALOBJECTION = "//span[normalize-space()='Objection Count Limit is required']";
    public static String ACCVALTIMEZONE = "//p[normalize-space()='Time zone is required']";
    public static String ACCVALGREETINGS = "//span[normalize-space()='Greeting message is required']";
    public static String ACCVALPERSONALITY = "//span[normalize-space()='Personality is required']";
    public static String ACCVALGOAL = "//span[normalize-space()='Goal Type is required']";
    public static String ACCVALLANG = "//p[normalize-space()='Language is required']";
    public static String ACCVALPROBINGTHRESHOLD = "//span[normalize-space()='Profile Threshold is required']";
    public static String ACCVALCTATYPE = "//p[normalize-space()='CTA Type is required']";
    public static String ACCVALRESETCOUNT = "//span[normalize-space()='Reset Count Limit is required']";
    public static String ACCVALCOREUSP = "//span[normalize-space()='Core USPs is required']";
    public static String ACCVALCOREFEATURE = "//span[normalize-space()='Core features is required']";
    public static String ACCVALCOUNTRY = "//p[normalize-space()='Country is required']";
    public static String ACCVALCONTACT = "//span[normalize-space()='Contact info is required']";
    public static String ACCVALCOMPANYDOMAIN = "//span[normalize-space()='Company domain is required']";
    public static String ACCVALBUSINESS = "//span[normalize-space()='Business focus is required']";
    public static String ACCVALCOMPANYDESC = "//span[normalize-space()='Company description is required']";

    public static String CUSTOMERSUPPORT = "//li[text()='CUSTOMER SUPPORT']";
    public static String HR = "//li[text()='HR']";
    public static String SALES = "//li[text()='SALES']";
    public static String ACSEARCHRESULT = "(//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"])[1] | //tbody/tr[1]/td[3] ";
    public static String ACEDITBUTTON = "(//button[@aria-label=\"Edit\"])[1]|(//button[@type=\"button\"]/parent::span[@aria-label=\"Edit\"])[1]";
    public static String ACRESETBUTTON = "//button[@type='button']/following::span[text()='Reset']";
    public static String ACDELETEBUTTON = "(//button[@aria-label=\"Delete\"])[1]|(//button[@type=\"button\"]/parent::span[@aria-label=\"Delete\"])[1]";
    public static String ACDELETECANCELBUTTON = "//button[@type=\"button\"]/following::span[text()='Cancel']";
    public static String ACACTIVATEBUTTON = "//button[@type=\"button\"]/following::span[text()='Activate']";
    public static String ACINNERDELETE = "//button[@type=\"button\"]/following::span[text()='Delete']";
    public static String ACINACTIVE = "//span[text()='Inactive']";
    public static String ACACTIVE = "//span[text()='Active']";
    public static String ACINACTIVECB = "(//input[@type='checkbox'])[2]";
    public static String ACACTIVEINACTIVE = "//button[@type='button']//span[normalize-space()='Active']";
    public static String ACFILTERNAME = "//li[contains(text(),'Name')]";
    public static String ACEDITHEADER = "//h6[text()='Update Agent Configuration']";
    public static String ACPLAYGROUNDHEADER = "//span[text()='Select Agent']";
    public static String ACPLAYGROUNDSELECTAGENT = "//input[@placeholder=\"Select agent\"] | //input[@placeholder=\"Select Agent\"]";
    public static String ACEDITSUCCESSMESSAGE = "//div[text()='Agent Configuration Updated Successfully'] | //div[text()='Agent configuration updated successfully']";
    public static String DELETESUCCESS = "//div[contains(text(), 'Deleted Successfully')]";
    //Contacts pages locators
    //Grid page
    public static String whatsAppContactHed= "//h6[text()='Contact']";
    public static String searchInp= "//input[@placeholder='Search...']";
    public static String importBtn = "//span[text()='Import']";
    public static String exportBtn = "//span[text()='Export']";
    public static String refreshBtn = "(//div[@class='MuiBox-root css-16ol8ea']//button)[4]";
    public static String filterBtn = "//span[text()='Filters']";
    public static String createContact= "(//span[contains(text(),'Create')])[1]";
    public static String listViewBtn = "(//button[@role='tab'])[2]";
    public static String gridViewBtn = "(//button[@role='tab'])[1]";
    public static String GoToNextBtn = "//button[@aria-label='Go to next page']";
    public static String GoToPreviousBtn = "//button[@aria-label='Go to previous page']";

    //grid page headers
    public static String nameHeader = "//div[@role='presentation']//span[text()='Name']|//th/child::div[text()=\"Name\"]";
    public static String phoneNumHeader = "//div[@role='presentation']//span[text()='Phone Number']|//th/child::div[text()=\"Phone Number\"]";
    public static String DOBHeader = "//div[@role='presentation']//span[text()='Date of Birth']|//th/child::div[text()=\"Date of Birth\"]";
    public static String emailHeader = "//div[@role='presentation']//span[text()='Email']|//th/child::div[text()=\"Email\"]";
    public static String companyHeader = "//div[@role='presentation']//span[text()='Company ']|//th/child::div[text()=\"Company Name\"]";
    public static String contactGroupHeader = "//div[@role='presentation']//span[text()='Contact Group']|//th/child::div[text()=\"Contact Group\"]";
    public static String createdDateHeader = "//div[@role='presentation']//span[text()='Created Date']|//th/child::div[text()=\"Created Date\"]";
    public static String emailSubscriptionHeader = "//div[@role='presentation']//span[text()='Email Subscription']|//th/child::div[text()=\"Email Subscription\"]";
    public static String whatsappSubscriptionHeader = "//div[@role='presentation']//span[text()='Whatsapp Subscription']|//th/child::div[text()=\"Whatsapp Subscription\"]";
    public static String actionsHeader = "//div[@role='presentation']//span[text()='Actions']|//th/child::div[text()=\"Actions\"]";
    public static String actionHeader = "//div[@role='presentation']//span[text()='Action']";

    //Buttons
    public static String saveButton = "//span[contains(text(),'Save')]";
    public static String cancelButton = "//span[contains(text(),'Cancel')]";

    //Inputs Fields
    public static String Contact= "//span[contains(text(),'Contact')]";
    public static String ContactButton= "//button[contains(text(),'Contact')]";
    public static String WhatsAppContact= "//button[contains(text(),'Whatsapp Contact')]";
    public static String nameInp = "//input[@name='name']";
    public static String EmailInp= "//input[@name='email']";
    public static String dateOfBirthInp = "//input[@placeholder='Select Date Of Birth']";
    public static String contactGroup = "//input[@placeholder='Select or Create Contact Group']";
    public static String phoneNumberInp = "//input[@placeholder='Enter phone number']";
    public static String companyNameInp = "//input[@name='company_name']";
    public static String selectCountryDropdown = "//input[@placeholder='Select Country']";
    public static String SelectStateInp = "//input[@placeholder='Select State']";
    public static String SelectCityInp = "//input[@placeholder='Select City']";
    public static String SubscriptionStatus = "//input[@placeholder='Select Whatsapp Subscription Status']";

    //Contacts labels
    public static String nameLabel = "//span[text()='Name']";
    public static String emailLabel = "//span[text()='Email']";
    public static String dateOfBirthLabel = "//span[text()='Date Of Birth']";
    public static String contactGroupLabel = "//span[text()='Contact Group']";
    public static String phoneNumberLabel = "//span[text()='Phone Number']";
    public static String companyNameLabel = "//span[text()='Company Name']";
    public static String countryLabel = "//span[text()='Country']";
    public static String stateLabel = "//span[text()='State']";
    public static String cityLabel = "//span[text()='City']";

    //Contact page creation page validation message for mandatory fields
    public static String nameFieldMsg = "//span[text()='Name is required']|//p[text()='Name is required']";
    public static String contactGroupMsg = "//span[text()='Contact Group is required']|//p[text()='Contact Group is required']";
    public static String phoneNumberMsg = "//div[text()='Phone number is required']|//p[text()='Contact Group is required']";
    public static String companyNameMsg = "//span[text()='Company Name is required']";

    //Import page locators
    public static String bulkUploadHeader= "//h6[text()='Bulk Upload Contacts']";
    public static String downloadSampleTemplate = "//span[text()='Download sample template']";
    public static String bulkUpload = "//input[@id='excel-upload']/following::p";
    public static String QueueDate = "//span[text()='Queue Data']";
    public static String chooseUpload = "//span[text()='Choose Upload']";

    //Grid locators
    public static String viewButton = "//button[@aria-label='View']";
    public static String viewButtonText = "//span[contains(text(),'View')]";
    public static String deleteButton = "//button[@aria-label='Delete']";
    public static String editButton = "//button[@aria-label='Edit']";
    public static String viewHeader = "//h5[text()='Whatsapp Contact']";
    public static String buttonMenuListView = "//div[contains(@class,'shrink-0 MuiBox-root css-0')]/child::button|(//span[text()='subscribed']/following::button)[1]";

    //View page locators
    //label
    public static String nameLblView = "//input[@type='text']/ancestor::div//label//span[text()='Name']";
    public static String emailLblView = "//input[@type='text']/ancestor::div//label//span[text()='Email']";
    public static String dateOfBirthLbel = "//input[@type='text']/ancestor::div//label//span[text()='Date Of Birth']";
    public static String contactGroupViewLbl = "//input[@type='text']/ancestor::div//label//span[text()='Contact Group']";
    public static String phoneNumberViewLbl = "//input[@type='text']/ancestor::div//label//span[text()='Phone Number']";
    public static String companyNameLbl = "//input[@type='text']/ancestor::div//label//span[text()='Company Name']";
    public static String countryViewLbl = "//input[@type='text']/ancestor::div//label//span[text()='Country']";
    public static String stateViewLbl = "//input[@type='text']/ancestor::div//label//span[text()='State']";
    public static String cityViewLbl = "//input[@type='text']/ancestor::div//label//span[text()='City']";
    public static String closeButtonView = "//span[text()='Close']/parent::button";
    public static String closeIconView = "//span[contains(text(),'Cancel')]";
    //Input

    //View page locators
    public static String nameInpView = "//label[.//span[text()='Name']]/following-sibling::div//input";
    public static String emailInpView = "//label[.//span[text()='Email']]/following-sibling::div//input";
    public static String dateOfBirth = "//label[.//span[text()='Date Of Birth']]/following-sibling::div//input";
    public static String contactGroupView = "//label[.//span[text()='Contact Group']]/following-sibling::div//input";
    public static String phoneNumberView = "//label[.//span[text()='Phone Number']]/following-sibling::div//input";
    public static String companyName = "//label[.//span[text()='Company Name']]/following-sibling::div//input";
    public static String countryView = "//label[.//span[text()='Country']]/following-sibling::div//input";
    public static String stateView = "//label[.//span[text()='State']]/following-sibling::div//input";
    public static String cityView= "//label[.//span[text()='City']]/following-sibling::div//input";

    //Delete xpaths
    public static String deletePopupHed = "//h6[text()='Delete Whatsapp Contact']";
    public static String deleteButtonPopup = "//button//span[contains(text(),'Delete')]";
    public static String closeBtnPopupDelete = "(//h6[text()='Delete Whatsapp Contact']/ancestor::div//button)[1]";

    //List view
    public static String listViewGetMobile = "//span[text()='Phone']/ancestor::p";
    public static String NoRowsValidation = "//div[text()='No rows']";

    //WhatsApp campaign

    //Lead Management
    public static String LEADMANAGMENT = "//span[contains(text(),'Lead Management')]";
    public static String LEAD = "//button[normalize-space()='Lead']";
    public static String CREATEB = "//span[normalize-space()='Create']";
    public static String LEADNAME = "//input[@placeholder='Enter customer email']";
    public static String TYPE   = "//input[@placeholder='Select Type']";
    public static String CONTACTTYPE = "//input[@placeholder='Select Contact Type']";
    public static String WHATSAPPCON ="//input[@role='combobox' and @placeholder='Select Whatsapp Contact']";
    public static String PRODUCT = "//input[@placeholder=\"Select product\"]";
    public static String SAVE_BTN = "//span[text()='Save']";
    public static String LEADVIEW ="//button[@aria-label='View']";
    public static String DTAETIME = "//input[@placeholder='Enter Preferred Date and Time']\n";
    public static String DELETEOTIN = "//div[@class='MuiDataGrid-row MuiDataGrid-row--firstVisible']//button[@aria-label='Delete']";
    public static String CANCELDELETE = "//span[normalize-space()='Cancel']";
    public static String LEADPBack = "//h6[text()='Create Lead Management']/preceding-sibling::button";
    public static String CONFDELETE = "//span[normalize-space()='Delete']";
    public static String LEADREFRESH = "//span[contains(@class,'MuiButton-startIcon')]";
    public static String GRIDVIEWBTNL = "(//button[@role='tab'])[2]";
    public static String LISTVIEWBTNL = "(//button[@role='tab'])[1]";
    public static String LEADHEADER = "//h6[normalize-space()='Lead Management']";
    public static String LEADSEARCH = "//input[@placeholder='Search...']";
    public static String LEADEDIT = "//button[@aria-label='Edit']";
    public static String LEADUPDATEHEADER = "//h6[text()='Update Lead Management']";
    public static String NoRows = "//div[text()='No rows']";
    public static String NAME = "//input[@name='name']";
    public static String ErrorOnName = "//span[text()='Name is required']";
    public static String ErrorOnEmail ="//span[text()='Email is required']";
    public static String ErrorOnType ="//span[text()='Type is required']";
    public static String ErrorOnContactType ="//span[text()='Contact Type is required']";
    public static String ErrorOnWhatsAppCOntact ="//span[text()='Whatsapp Contact is Required']";
    public static String ErrorOnPrefrredDT ="//span[text()='Preferred Date and Time is required']";
    public static String ErrorOnProduct ="//span[text()='Please select a product']";
    public static String LEADCREATEDMSG = "//*[contains(text(),'Lead Created successfully')]";
    public static String LEADDELETED = "//div[text()='Deleted Successfully']";
    public static String LEADRESET ="//span[text()='Reset']";
    public static String Header_NAME = "//span[text()='Name']";
    public static String Header_EMAIL = "//span[text()='Email']";
    public static String Header_CONTYPE = "//span[text()='Contact Type']";
    public static String Header_TYPE = "//span[text()='Type']";
    public static String Header_CONTACT = "//div[@role='columnheader']//span[text()='Contact']";
    public static String Header_Product = "//div[@role='columnheader']//span[text()='Product']";
    public static String Header_PreferredDT = "//div[@role='columnheader']//span[text()='Preferred Date / Time']";
    public static String Header_CREATEDAT= "//span[text()='Created At']";
    public static String Header_Actions= "//span[text()='Actions']";
    public static String LeadEditBack = "//h6[text()='Update Lead Management']/preceding-sibling::button";
    //Lead view
    public static String Vname ="//span[text()='Name']/ancestor::label/following-sibling::div//input[@type='text']";
    public static String Vemail = "//span[text()='Email']/ancestor::label/following-sibling::div//input[@type='text']";
    public static String VType = "//span[normalize-space()='Type']/ancestor::label/following-sibling::div//input[@type='text']\n";
    public static String VContactType = "//span[normalize-space()='Contact Type']/ancestor::label/following-sibling::div//input[@type='text']";

    public static String VWhatsAppContact ="//label[.//span[text()='Whatsapp Contact']]/following::input[1]";
    public static String VPoduct = "//label[.//span[text()='Product']]/following::input[1]";
    public static String VContactNo = "//label[.//span[text()='Contact Number']]/following::input[1]";
    public static String VPreDT = "//label[.//span[text()='Preferred Date & Time']]/following::input[1]";
    public static String VCREATEAT ="//label[.//span[text()='Created At']]/following::input[1]";
    public static String VClose ="//span[text()='Close']";


    //Knowledge Base
    public static String KBMENU = "//span[text()='Knowledge Base']";
    public static String KBHEADER = "//h6[text()='Knowledge Base']";
    public static String KBSEARCHBAR = "//input[@placeholder=\"Search...\"]";
    public static String KBSRNUMBER = "//span[normalize-space()='#']|//div[normalize-space()='#']";
    public static String KBNAME = "//span[normalize-space()='Name']|//div[normalize-space()='Name']";
    public static String KBPRODUCTS = "//span[normalize-space()='Products']|//div[normalize-space()='#']";
    public static String KBSTATUS = "//span[normalize-space()='Status']|//div[normalize-space()='#']";
    public static String KBCREATEDDATE = "//span[normalize-space()='Created Date']|//div[normalize-space()='#']";
    public static String KBACTIONS = "//span[normalize-space()='Actions']|//div[normalize-space()='#']";
    public static String KBTOTALROWS = "//div[contains(text(),'Total')]|//h6[text()='Whatsapp Templates']/following::div[1]";
    public static String KBROWSPERPAGE = "//p[contains(text(),'Rows per page:')]";

    public static String KBREFRESHBUTTON = "//button[contains(@class,'css-q8p1uw')]| //span[text()='Filters']/following::button[1]";
    public static String KBFILTERS = "//button[@type='button']/following::span[contains(text(),'Filters')]";
    public static String KBCREATE = "//button[@type='button']/following::span[text()='Create']";
    public static String KBSERACHRESULT = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]";
    public static String KBINPROGRESS = "(//div[@data-colindex='3' and @aria-colindex='4'])[1]//span[normalize-space()='In Progress']";
    public static String KBCOMPLETED = "(//div[@data-colindex='3' and @aria-colindex='4'])[1]//span[normalize-space()='Completed']";
    public static String KBFAILED = "(//div[@data-colindex='3' and @aria-colindex='4'])[1]//span[normalize-space()='Failed']";
    public static String KBEDITBUTTON = "(//button[@aria-label=\"Edit\"])[1]";
    public static String KBEDITHEADER = "//h6[text()='Update Knowledge Base']";
    public static String KBEDITINFO = "//p[contains(text(),'You can delete files only when their status is')]";
    public static String KBCOMPLETEDS = "(//span[text()='Completed'])[1]";
    public static String KBEDITRESET = "//span[text()='Reset']";
    public static String KBVIEW = "//button[@aria-label=\"View\"]";
    public static String KBVIEWINPUTDATE = "(//input[@type='text'])[4]";
    public static String KBVIEWINPUTNAME = "(//input[@type='text'])[2]";

    //KB Create
    public static String KBCHEADER = "//h6[text()='Create Knowledge Base']";
    public static String KBCBACKBUTTON = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-mfslm7\"]";
    public static String KBCNAMELABLE = "//span[text()='Name']";
    public static String KBCNAMEINPUT = "//input[@placeholder=\"Enter Name\"]";
    public static String KBCFILESBUTTON = "//button[@type='button']/following::span[text()='Files']";
    public static String KBCTEXTBUTTON = "//button[@type='button']/following::span[text()='Text']";
    public static String KBCWEBSITEBUTTON = "//button[@type='button']/following::span[text()='Website']";
    public static String KBCQABUTTON = "//button[@type='button']/following::span[text()='Q&A']";
    public static String KBCFILESUPLOAD = "//h6[text()='Upload']";
    public static String KBCFILESUPLOADINPUT = "//div[@class=\"flex flex-col items-center gap-4\"] | //div[@class=\"MuiBox-root css-17qkz0m\"]";
    public static String KBCUPLOADTEXT1 = "//p[text()='Select your file or drag and drop (Max 10 MB)']";
    public static String KBCUPLOADTEXT2 = "//p[text()='Allowed formats: (.docx, .pptx, .pdf, .txt, .jpg, .png, .jpeg, .md)']";
    public static String KBCCANCELBUTTON = "//button[@type='button']/child::span[contains(text(),'Cancel')]";
    public static String KBCSAVEBUTTON = "//button[@type='button']/child::span[contains(text(),'Save')]";
    public static String KBCVALIDATE = "(//div[@data-colindex=\"3\"and @aria-colindex=\"4\"])[1]//span";
    public static String KBUPLOADEDFILE = "\"//p[starts-with(normalize-space(text()),'\" + value + \"')]\";";
    //KB Create Text Mode
    public static String KBCTEXTHEADER = "//h6[text()='Add Text']";
    public static String KBCTEXTTITLELABEL = "//span[text()='Title']";
    public static String KBCTEXTADDLABEL = "(//input[@placeholder=\"Ex: Lorem ipsum\"])[1]";
    public static String KBCTEXTDESCRIPTIONLABEL = "//h6[text()='Description']";
    public static String KBCDESCTOOL = "(//div[@role=\"toolbar\"])[1]";
    public static String KBCDESCINPUT = "(//div[@class=\"ql-container ql-snow\"])[1]";
    public static String KBCDESCINPUT2 = "(//div[@class=\"ql-editor ql-blank\"])[1]";
    public static String KBCDESCINPUT3 = "(//input[@data-link=\"https://quilljs.com\"])[2]";
    public static String KBCADDTEXT = "//button[@type='button']/following::span[text()='Add Text']";
    public static String KBCADDTEXTVALIDATION = "//div[text()='Please fill all the fields']";
    public static String KBCADDTEXTVALIDATIONCLOSE = "//button[@aria-label=\"Close alert\"]";
    public static String KBDELETETEXT = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorError MuiIconButton-sizeSmall css-2cca5\"])[1]";
    public static String KBDELETEADDEDTEXT = "//button[@type=\"button\"]//span[text()='Delete']";
    //KB Website
    public static String KBCWEBHEADER = "//h6[text()='Add Links']";
    public static String KBCWEBINPUT = "//input[@placeholder=\"http://www.example.com/\"]";
    public static String KBCWEBADD = "//button[@type='button']/following::span[text()='Add Link']";
    public static String KBCWEBADDEDDELETE = "//th[text()='Title']/following::button | (//th[text()='Status']/following::td/button)[1]";
    //KB Q&A
    public static String KBCQAHEADER = "//h6[text()='Add Q&A']";
    public static String KBCQATITLE = "(//span[text()='Title'])[2]";
    public static String KBCQATITLEINPUT = "(//input[@placeholder=\"Ex: Lorem ipsum\"])[2]";
    public static String KBCQATITLEQ1 = "//span[text()='Question 1']";
    public static String KBCQATITLEQ1INPUT = "(//input[@placeholder=\"Ex: How do I request a refund?\"])[1]";
    public static String KBCADDBUTTON = "//button[@type='button']/following::span[text()='Add Question']";
    public static String KBCANSWER = "//p[text()='Answer'] | //h6[text()='Answer']";
    public static String KBCANSWERINPUT = "(//div[@class=\"ql-editor ql-blank\"])[2]";
    public static String KBCQAADDBUTTON = "//button[@type='button']//span[text()='Add Q&A']";
    //KB Mandatory Fields
    public static String KBCNAMEVALIDATION = "//span[text()='Name is required']";

    //WhatsApp Template
    public static String TEMPLATEMENU = "//span[text()='Templates']";
    public static String WHATSAPPTEMPLATEMENU = "//button[text()='Whatsapp Template']";
    public static String WTHEADER = "//h6[text()='Whatsapp Template']|//h6[text()='Whatsapp Templates']";
    public static String WTSEARCH = "//input[@placeholder=\"Search...\"]";
    public static String WTREFRESH = "//span[text()='Filters']/following::button[1] | //span[contains(@class,'css-1sh91j5')]/parent::button[contains(@class,'css-q8p1uw')]";
    public static String WTFILTERS = "//button[@type='button']/following::span[contains(text(),'Filters')]";
    public static String WTCREATE = "//button[@type='button']/following::span[text()='Create']";
    public static String WTNAME = "//span[text()=\"Name\"]|//div[normalize-space()='Name']";
    public static String WTLANGUAGE = "//span[text()=\"Language\"]|//div[normalize-space()='Name']";
    public static String WTHEADERTEXT = "//span[text()=\"Header Text\"]|//div[normalize-space()='Name']";
    public static String WTCATEGORY = "//span[text()=\"Category\"]|//div[normalize-space()='Name']";
    public static String WTTEMPLATEMETASTATUS = "//span[text()=\"Template Meta Status\"]|//div[normalize-space()='Name']";
    public static String WTQUALITYSCORE = "//span[text()=\"Quality Score\"]|//div[normalize-space()='Name']";
    public static String WTCREATEDDATE = "//span[text()=\"Created Date\"]|//div[normalize-space()='Created Date']";
    public static String WTACTIONS = "//span[text()=\"Actions\"]|//div[normalize-space()='Actions']";
    //WhatsApp
    public static String WTCHEADER = "//h6[text()='Create Whatsapp Template']";
    public static String WTCVIEWDETAILS = "//button[text()='View Details']";
    public static String WTCBANNERTEXT = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-igfty4\"]";
    public static String WTCTEMPLATEDETAILS = "//p[text()='Template Details']";
    public static String WTCTEMPLATENAME = "//span[text()='Template Name']";
    public static String WTCTEMPLATENAMEINPUT = "//input[@placeholder=\"Enter Template Name\"]";
    public static String WTCCATEGORY = "//span[text()='Category']";
    public static String WTCCATEGORYINPUT = "//input[@placeholder=\"Select Category\"]";
    public static String WTCLANGUAGE = "//span[text()='Language']";
    public static String WTCLANGUAGEINPUT = "//input[@placeholder=\"Select Language\"]";
    public static String WTCHEADERTYPE = "//span[text()='Header Type']";
    public static String WTCHEADERTYPEINPUT = "//input[@placeholder=\"Select Header Type\"]";
    public static String WTCHEADERTYPEINPUTTEXT = "//input[@placeholder=\"Enter Header Text\"]";
    public static String WTCMESSAGECONTENT = "//p[text()='Message Content']";
    public static String WTCUPLOADFILES = "//span[text()='Upload File']";
    public static String WTCFILEINPUT = "//input[@placeholder=\"No file selected\"]|//input[@id=\"file-upload\"]";
    public static String WTCFILEINPUT2 = "//button[@type=\"button\"]/span[text()='Upload']|//div[text()='Select file']/parent::div";
    public static String WTCBODY = "//p[text()='Body ']";
    public static String WTCADDVARIABLES = "//span[@class=\"MuiChip-label MuiChip-labelMedium css-14vsv3w\"]";
    public static String WTCBODYINPUT = "//div[starts-with(@class,'ql-editor')]";
    public static String WTCFOOTER = "//p[text()='Footer (Optional)']|//span[text()='Footer Text']";
    public static String WTCFOOTERINPUT = "//input[@placeholder=\"Footer Text\"]|//input[@name=\"footer_text\"]";
    public static String WTCBUTTONS = "//p[text()='Buttons']";
    public static String WTCBUTTONTYPE = "//span[text()='Button Type']";
    public static String WTCSELECTTYPE = "//input[@placeholder=\"Select Button Type\"]";
    public static String WTCBUTTONTEXT = "//span[text()='Button Text']";
    public static String WTCBUTTONTEXTINPUT = "//input[@placeholder=\"Enter button text\"]";
    public static String WTCADDBUTTON = "//button[@type='button']/following::span[text()='+ Add Button']";
    public static String WTCTEMPLATEPREVIEW = "//p[text()='See how your template will appear']";
    public static String WTCMESSAGEICON = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ba1cez\"]|//div[@class='text-4xl mb-2']";
    public static String WTCTEMPLATEPREVIEW2 = "//p[text()='Start filling the form to see your template preview']";
    public static String WTCTEMPLATEPREVIEW3 = "//p[contains(normalize-space(),'Live Preview')]";
    public static String WTCNAMEMANDATORY = "//span[text()='Name is required']|//span[text()='Template Name is required']";
    public static String WTCCATEGORYMANDATORY = "//span[text()='Category is required']|//p[text()='Category is required']";
    public static String WTCLANGUAGEMANDATORY = "//span[text()='Language is required']|//p[text()='Language is required']";
    public static String WTCHEADERTYPEMANDATORY = "//span[text()='Header Type is required']|//p[text()='Header Type is required']";
    public static String WTCFILEEMANDATORY = "//span[text()='File is required']";
    public static String WTCBODYOFTEMPMANDATORY = "//span[text()='Body of template is required']";
    public static String WTCENTERURL = "//input[@name=\"button_url\"]";
    public static String WTCENTERPHONE = "//input[@placeholder=\"Enter mobile number\"]";
    public static String WTSEARCHRESULT = "(//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"])[1]|//tbody/tr[1]/td[2]";
    public static String WTMETASTATUS = "(//div[@aria-colindex=\"6\" and @aria-rowspan=\"1\"])[1]";

    //How to create WhatsApp Template
    public static String FIRST = "//h2[contains(text(),'WhatsApp Template Creation — Rules & Regulations')]";
    public static String SEC = "//h2[contains(text(),'General Template Rules')]";
    public static String THIRD = "//h2[contains(text(),'HEADER Component')]";
    public static String FOURTH = "//h2[contains(text(),'BODY Component')]";
    public static String FIFTH = "//h2[contains(text(),'FOOTER Component')]";
    public static String SIXTH = "//h2[contains(text(),'BUTTONS Component')]";
    public static String SEVENTH = "//h2[contains(text(),'QUICK_REPLY Buttons')]";
    public static String EIGHTH = "//h2[contains(text(),'URL Buttons')]";
    public static String NINTH = "//h2[contains(text(),'PHONE_NUMBER Buttons')]";
    public static String TENTH = "//h2[contains(text(),' Template Rejection Reasons')]";

    //Email Template
    public static String EMAILTEMPLATEMENU = "//button[text()='Email Template']";
    public static String ETHEADER = "//h6[text()='Email Templates']";
    public static String ETSEARCH = "//input[@placeholder=\"Search...\"]";
    public static String ETSR = "//span[normalize-space()='#']|//div[text()='#']";
    public static String ETNAME = "//span[text()=\"Name\"]|//div[text()='Name']";
    public static String ETSUBJECT = "//span[text()=\"Subject\"]|//div[text()='Subject']";
    public static String ETSERVERSYNCED = "//span[text()=\"Server Synced\"]|//div[text()='Server Synced']";
    public static String ETCREATEDDATE = "//span[text()=\"Created Date\"]|//div[text()='Created Date']";
    public static String ETACTIONS = "//span[text()=\"Actions\"]|//div[text()='Actions']";
    public static String ETREFRESH = "//span[text()='Filters']/following::button[1] | //span[contains(@class,'css-1sh91j5')]/parent::button[contains(@class,'css-q8p1uw')]";
    public static String ETFILTERS = "//button[@type='button']/following::span[contains(text(),'Filters')]";
    public static String ETCREATE = "//button[@type='button']/following::span[text()='Create']";
    public static String ETVIEW = "(//button[@aria-label=\"View\"])[1]|//button/parent::span";
    public static String ETSEARCHRESULTS = "(//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"])|//tbody/tr[1]/td[2]";
    public static String ETASTATUS = "//div[@aria-colindex=\"4\" and @aria-rowspan=\"1\"]//span|//tbody/tr[1]/td[4]";

    //Email Template Create
    public static String ETCREATEHEADER = "//h6[text()='Create Email Template']";
    public static String ETCTD = "//p[text()='Template Details']";
    public static String ETCTNAME = "//span[text()='Template Name']";
    public static String ETCTNAMEINPUT = "//input[@placeholder=\"Enter Template Name\"]";
    public static String ETCCBTEXT = "//p[text()='Can be send from whatsapp']";
    public static String ETCCATEGORY = "//span[text()='Category']";
    public static String ETCCATEGORYINPUT = "//input[@placeholder=\"Select Category\"]";
    public static String ETCCBINPUT = "//input[@type=\"checkbox\"]";
    public static String ETCUPLOAD = "//p[contains(text(),'Select your file')]";
    public static String ETCUPLOADINPUT = "//p[contains(text(),'Select your file or drag and drop')]";
    public static String ETCSAVE = "//button[@type='button']/following::span[text()='Save']";
    public static String ETCCANCEL = "//button[@type='button']/following::span[text()='Cancel']";
    public static String ETCTNVALIDATION = "//span[text()='Template name is required']|//span[text()='Template Name is required']";
    public static String ETCTNCATVALIDATION = "//p[text()='Category is required']";
    public static String ETCSUBJECTVALIDATION = "//span[text()='Subject is required']";
    public static String ETCBODYVALIDATION = "//p[text()='Body is required']";
    public static String ETCUPLOADEDFILE = "//div[@class=\"mt-4 grid grid-cols-2 sm:grid-cols-3 gap-3\"]/child::div";
    public static String ETCUPLOADEDFILEVIEW = "//button[@aria-label=\"View\"]";
    public static String ETCUPLOADEDFILEDELETE = "//button[@aria-label=\"Delete\"]";
    public static String ETCEMAILBODY = "//p[text()='Email Body']";
    public static String ETCVAREMAIL = "//span[text()='{{email}}']";
    public static String ETCVARPHONE = "//span[text()='{{phone_number}}']";
    public static String ETCVARNAME = "//span[text()='{{name}}']";
    public static String ETCVARCNAME = "//span[text()='{{company_name}}']";
    public static String ETCVARNEW = "//span[text()='{{%%%%%}}']";
    public static String ETCVARINFO = "//p[text()='Click any variable to insert it in the subject or body.']";
    public static String ETCSUBJECT = "//span[text()='Subject']";
    public static String ETCSUBJECTINPUT = "//input[@name='subject']";
    public static String ETCBODYTEXT = "//p[contains(text(),'Use variables from the top right panel to personalize your email.')]";
    public static String ETCBODYTOOL = "//div[@role='toolbar']";
    public static String ETCBODYINPUT = "//div[@data-placeholder=\"Start writing your email content...\"]";
    public static String ETCLIVEPREVIEW = "//p[text()='Live Preview']";
    public static String ETCLPSUB = "//b[text()='Subject:']| //div[text()='Subject']";
    public static String ETCLPINFO = "//p[contains(text(),'You are receiving this communication from')] | //div[contains(text(),'You are receiving this communication from')]";
//    public static String ETCREATEHEADER = "//p[contains(text(),'To stop receiving future emails, please click')]";

    //Onboarding module xpath

    //OnBoarding
    public static String monthlyBtn = "//span[contains(text(),'Monthly')]/ancestor::button";
    public static String YearlyBtn = "//span[contains(text(),'Yearly')]/ancestor::button";
    public static String loginBtnPlan = "//span[contains(text(),'Login')]/ancestor::button";
    public static String backToChangePlanBtn = "//span[contains(text(),'Back to Change Plan')]/ancestor::button";
    public static String selectPlanGrowth = "(//h6[contains(text(),'Growth')]/following::button)[1]";
    public static String firstNameInp = "//input[@name='first_name']";
    public static String lastNameInp = "//input[@name='last_name']";
    public static String emailInp = "//input[@name='email']";
    public static String phoneNumInp = "//input[@name='phone_number']";
    public static String nextBtn = "//span[contains(text(),'Next')]/ancestor::button|//button[@type=\"submit\"]";
    public static String businessNameInp = "//input[@name='business_name']";
    public static String selectBusinessStrengthInp = "//input[@placeholder='Select Business Strength']";
    public static String businessType = "//input[@placeholder='Select Business Type']";
    public static String selectCategory = "//input[@placeholder='Select Category']";
    public static String createAccountBtn = "//span[contains(text(),'Create Account')]/ancestor::button";
    public static String addressLineInp = "//input[@placeholder='Enter Address Line']";
    public static String addressAreaInp = "//input[@placeholder='Enter Area']";
    public static String pinCodeInp = "//input[@name='pincode']";
    public static String agreeCheckbox= "//input[@type='checkbox']";
    public static String startFreeTrialBtn = "//span[contains(text(),'Start Trial')]/ancestor::button";
    public static String startFreeTrialBtnLastPage = "//span[contains(text(),'Start Free Plan')]/ancestor::button|//span[text()='Complete Checkout']/parent::button";
    public static String payAsYouGo = "//p[contains(text(),'Pay as you go')]/following::button[1]";
    public static String businessName = "//input[@name=\"business_name\"]";
    public static String industry = "//input[@name=\"industry\"]";
    public static String category = "//input[@name=\"category\"]";
    public static String subCategory = "//input[@name=\"subcategory\"]";
    public static String congratulationMessage = "(//h6[contains(text(),'Congratulations!')])[2]";
    public static String closeIconOnCongratulation = "(//div[contains(@class,'relative flex flex-col items-center justify-center')]//button)[2]";
    public static String getPlanDetail = "(//h4[contains(text(),'')])[2]";
    public static String createPasswordBtn = "//span[text()='Create Password']/parent::button";
    public static String notAcceptedStatusOnGrid = "//div[text()='Not Accepted']";
    public static String activeStatus = "//span[text()='Active']";

    //Profile page xpath
    public static String profileIcon = "(//div[contains(@class,'flex items-center gap-1 sm')]//button)[2]";
    public static String accountHeader = "//span[contains(text(),'Account')]";
    public static String billingAndPlan = "//span[contains(text(),'Billing & Plans')]";
    public static String profileMenuOnProfile = "//p[contains(text(),'Profile')]";
    public static String changePassword = "//p[contains(text(),'Change Password')]";
    public static String plansMenu = "//p[contains(text(),'Plans')]";
    public static String invoiceMenu = "//p[contains(text(),'Invoice')]";
    public static String TransactionMenu = "//p[contains(text(),'Transaction')]";
    public static String UsageMenu = "//p[contains(text(),'Usage')]";
    public static String updateProfileBtn = "//span[contains(text(),'Update Profile')]/ancestor::button";
    public static String personalDetailHead = "//h6[contains(text(),'Personal Details')]";
    public static String firstNameLbl = "//span[contains(text(),'First Name')]";
    public static String emailLabelProfile = "//span[contains(text(),'Email')]";
    public static String lastNameLbl = "//span[contains(text(),'Last Name')]";
    public static String mobileNumberLabel = "//span[contains(text(),'Phone Number')]";
    public static String timezoneLabel = "//span[contains(text(),'Timezone')]";
    public static String businessHeader = "//h6[contains(text(),'Business Information')]";
    public static String categoryHeader = "//span[contains(text(),'Category')]";
    public static String businessNameLabel = "//span[contains(text(),'Business Name')]";
    public static String businessTypeLabel = "//span[contains(text(),'Business Type')]";
    public static String getSelectBusinessStrengthInp = "//span[contains(text(),'Business Strength')]";
    public static String gstNumberLabel = "//span[contains(text(),'GST Number')]";
    public static String addressLabel = "//span[text()='Address Line']";
    public static String billingAddressHed = "//h6[text()='Billing Address']";
    public static String areaLabel = "//span[text()='Area']";
    public static String pincodeLabel = "//span[text()='Pincode']";
    public static String buyCreditsHed = "//h6[text()='Buy Credits']";
    public static String buyCreditsButton = "//span[text()='Buy Credits']/ancestor::button";
    public static String pricePerCreditLbl = "//p[text()='Price per Credit']";
    public static String creditToBuyLbl= "//span[text()='Credits to Buy']";
    public static String totalAmountLbl = "//p[text()='Total Amount']";
    public static String payableAmountLbl = "//p[text()='Payable Amount']";
    public static String cancelButtonPopUp = "//span[text()='Cancel']/ancestor::button";
    public static String buyButtonCreditPopup= "//span[text()='Buy']/ancestor::button";
    public static String upgradeButtonPlan = "//span[text()='Upgrade']/ancestor::button";
    public static String updateProfile = "//span[text()='Update Profile']/ancestor::button";
    //public static String = "";

    //Input field Xpaths
    public static String firstNameInpProfile = "(//div[@class='flex-1 min-w-0']//p)[1]";
    public static String lastNameInpProfile = "//input[@name=\"last_name\"]";
    public static String emailInpProfile = "//input[@name=\"email\"] | (//div[@class='flex-1 min-w-0']//p)[2]";
    public static String phoneNumberInpProfile = "//input[@name=\"phone_number\"]";
    public static String currentPasswordLbl = "//span[contains(text(),'Current Password')]";
    public static String newPasswordLbl = "//span[contains(text(),'New Password')]";
    public static String confirmPasswordLbl = "//span[contains(text(),'Confirm Password')]";
    public static String currentPasswordInp = "//input[@placeholder='Enter Current Password']";
    public static String newPasswordInp = "//input[@placeholder='Enter New Password']";
    public static String confirmPasswordInpProfile = "//input[@placeholder='Enter Confirm Password']";
    public static String savePassword = "//span[contains(text(),'Save Password')]/ancestor::button";

    //WhatsApp campaign  locators
    public static String SearchContact = "//input[@placeholder='Search contacts...']";
    public static String HomeMenu = "//span[text()='Home']";
    public static String CampaignMenu = "//span[text()='Campaign']";
    public static String whatsappCampaign = "//button[text()='Whatsapp Campaign']";
    public static String ECCSEARCHCONTACTSVALUE = "(//div[@data-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
    public static String WC_REFRESH = "//button[contains(@class,'MuiButton-root')] ";
    public static String WC_PAGEHEADER ="//h6[normalize-space()='WhatsApp Campaign']";
    public static String WCH_NAME ="//span[normalize-space()='Name']";
    public static String WCH_WhatsAppTem = "//span[contains(text(),'Whatsapp Template Name')]";
    public static String WCH_WhatsAppCategorName = "//span[normalize-space()='Template Category Name']";
    public static String WCH_ProductName = "//span[normalize-space()='Product Name']";
    public static String WCH_DT= "//span[normalize-space()='Created Date']";
    public static String WCH_Status = "//span[text()='Status']";
    public static String WCH_Action = "//span[text()='Actions']";
    //Create WhatsApp Campaign
    public static String CWC_Back = "//h6[text()='Create WhatsApp Campaign']/preceding-sibling::button";
    public static String CWC_Cancel = "//span[normalize-space()='Cancel']";
    public static String CWC_View = "//span[text()='View']";
    public static String CWC_Header = "//h6[normalize-space()='Create WhatsApp Campaign']";

    public static String V_Name = "//span[text()='Name']";
    public static String VContactG = "//span[text()='Contact Group']";
    public static String VEmail = "//span[text()='Email']";
    public static String VPhoneNo = "//span[text()='Phone Number']";
    public static String VDandB = "//span[text()='Date of Birth']";
    public static String WCViewHeader = "//h6[normalize-space()='View WhatsApp Campaign']";
    public static String SearchTex ="//div[@role='gridcell' and @data-field='name']";
    public static String WC_Search = "//input[@placeholder='Search...']";
    public static String V_RetryRerun = "//button[.//span[normalize-space()='Retry Failed']]";
    public static String  RerunSuccessMSG ="//div[normalize-space()='WhatsApp campaign start for rerun successfully!']";
    public static String V_back = "//h6[normalize-space()='View WhatsApp Campaign']/preceding-sibling::button";


    public static String CWC_Save = "//span[text()='Save']";
    public static String RC_PopupNo="//span[text()='No']";
    public static String RC_RunCamp="//span[text()='Run Campaign']";

    public static String C_Name = "//input[@placeholder='Enter campaign name']";
    public static String C_WhatsAppTem = "//input[@placeholder='Select template']";
    public static String C_Category = "//input[@placeholder='Create or Select Category']";
    public static String C_Product ="//input[@placeholder='Select product']";
    public static String C_ContactGroup = "//input[@placeholder='Select Contact Groups']";
    public static String C_SelectContact = "//input[@type='checkbox']/parent::span/parent::div[@tabindex='0']";
    public static String C_SelectContactcheckbox="(//div[@role='row'])[1]//div[@data-field='select']//span[contains(@class,'MuiCheckbox-root')]";
    public static String C_Contacts ="//p[text()='Contacts']";
    public static String Contact_RequiredMessage="//div[text()='Please select at least one contact or contact group.']";
    public static String Search_ContactonCampaignpage="//input[@placeholder='Search contacts...']";
    public static String SearchedResult_ContactonCampaignpage="//div[@class='MuiDataGrid-row MuiDataGrid-row--firstVisible MuiDataGrid-row--lastVisible']";

    //View WhatsApp Campaign

    public static String  CAMPAIGNVIEW ="//button[@aria-label='View']";
    public static String WProduct = "//label[.//span[text()='Product']]/following::input[1]";
    public static String WCategory = "//label[.//span[text()='Category']]/following::input[1]";
    public static String WTemplate = "//label[.//span[text()='WhatsApp Template']]/following::input[1]";
    public static String WName ="//label[.//span[text()='Campaign Name']]/following::input[1]";
    public static String WPhoneNumber="//*[contains(text(),'+91 77749 74990')]";

    //Field Validations  xpath for whatsappcampagin
    public static String Req_CampaginName="//span[text()='Name is required']";
    public static String Req_WhatsappTemp="//span[text()='WhatsApp template is required']";
    public static String Req_Category="//span[text()='Category is required']";
    public static String Req_Product="//span[text()='Product is required']";


    //Email Campaign
    public static String CAMPAIGNMENU = "//span[text()='Campaign']";
    public static String EMIALCAMPAIGNMENU = "//button[text()='Email Campaign']";
    public static String ECHEADER = "//h6[text()='Email Campaign']";
    public static String ECSEARCHBAR = "//input[@placeholder=\"Search...\"]";
    public static String ECREFRESHBUTTON = "//button[contains(@class,'5wqzvf')] | //button[contains(@class,'css-q8p1uw')]";
    public static String ECREFILTERBUTTON = "//button[contains(@class,'1wkzwh7')] | //button[contains(@class,'css-1yfm8su')]";
    public static String ECCREATEBUTTON = "//button[@type='button']/following::span[text()='Create']";
    public static String ECNAME = "//span[text()=\"Name\"]";
    public static String ECSR = "//span[text()=\"#\"]";
    public static String ECCATEGORY = "//span[text()=\"Category\"]";
    public static String ECPRODUCT = "//span[text()=\"Product\"]";
    public static String ECEMAIL = "//span[text()=\"Integration Email\"]";
    public static String ECCONTACT = "//span[text()=\"Contact\"] | //span[text()=\"Contact\"]/following::span[text()='Contact']";
    public static String ECCONTACTGROUP = "//span[text()=\"Contact Group\"]";
    public static String ECAI = "//span[text()=\"Enable AI\"]";
    public static String ECSTATUS = "//span[text()=\"Status\"]";
    public static String ECACTION = "//span[text()=\"Actions\"]";

    //EMAIL CAMPAIGN CREATE PAGE
    public static String ECCHEADER= "//h6[text()='Create Email Campaign']";
    public static String ECCCAMPAIGNDETAILS= "//p[text()='Campaign Details']";
    public static String ECCCAMPAIGNNAME= "//span[text()='Campaign Name']";
    public static String ECCCAMPAIGNTEMPLATE= "//span[text()='Email Template']";
    public static String ECCCAMPAIGNCATEGORY= "//span[text()='Category']";
    public static String ECCCAMPAIGNPRODUCT= "//span[text()='Product']";
    public static String ECCNAMEINPUT= "//input[@placeholder=\"Enter campaign name\"]";
    public static String ECCTEMPLATEINPUT= "//input[@placeholder=\"Select template\"]";
    public static String ECCCATEGORYINPUT= "//input[@placeholder=\"Create or Select Category\"]";
    public static String ECCPRODUCTINPUT= "//input[@placeholder=\"Select product\"]";
    public static String ECCCAMPAIGNCONTACTGROUP= "//input[@placeholder=\"Select contact groups\"]";
    public static String ECCVIEW= "//button[@type='button']/following::span[text()='View']";
    public static String ECCMESSAGECONTENT= "//p[text()='Message Content']";
    public static String ECCSUBJECT= "//span[text()='Subject']";
    public static String ECCSUBJECTNPUT= "//input[@placeholder=\"Email subject\"]";
    public static String ECCBODY= "//p[text()='Body']";
    public static String ECCBODYTOOLBAR= "//div[@class=\"ql-toolbar ql-snow\"]";
    public static String ECCTEMPLATEBODY= "//div[@data-placeholder=\"Email template body will appear here\"]";
    public static String ECCENABLEAI= "//p[text()='Enable AI']";
    public static String ECCENABLEAIYES= "//div[contains(@class,'css-1fw1vid')] | //div[contains(@class,'css-kg2as0')]";
    public static String ECCENABLEAINO= "//div[contains(@class,'css-yf7rws')] | //div[contains(@class,'css-12xpge1')]";
    public static String ECCCONTACTS= "//p[text()='Contacts']";
    public static String ECCSEARCHCONTACTS= "//input[@placeholder=\"Search contacts...\"]";
    //  public static String ECCSEARCHCONTACTSVALUE = "(//div[@data-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
    public static String ECCCHECKBOX= "(//span[@class=\"css-ysvidx\"])[1]";
    public static String ECCSRNO= "//span[text()='#']";
    public static String ECCNAME= "//span[text()='Name']";
    public static String ECCCONTACTGROUP= "//span[text()='Contact group']";
    public static String ECCPHONE= "//span[text()='Phone Number']";
    public static String ECCEMAIL= "//span[text()='Email']";
    public static String ECCTOTALROWS= "//div[text()='Total Rows: '] | //div[@class='MuiBox-root css-10u381a']";
    public static String ECCROWSPERPAGE= "//p[text()='Rows per page:'] | //p[text()='Show']";
    public static String ECCPREVIOUSPAGE= "//button[@aria-label=\"Go to previous page\"]";
    public static String ECCNEXTPAGE= "//button[@aria-label=\"Go to next page\"]";
    public static String ECCSEARCHRESULT= "(//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
    public static String ECCDROPDOWNLIST= "//ul[@class='MuiAutocomplete-listbox css-1sg36vf']";
    public static String ECCBODYVALUE= "//div[@data-placeholder=\"Email template body will appear here\"]/child::p";
    public static String ECCRUNCAMPAIGN= "//button[@type='button']/following::span[text()='Run Campaign'] | //span[text()=\"Save\"]/parent::button";
    public static String ECCCANCEL= "//button[@type='button']/following::span[text()='Cancel']";
    public static String ECCPOPUPTEXT1= "//h2[text()='Run Campaign']";
    public static String ECCPOPUPTEXT2= "//p[text()='Are you sure you want to run this email campaign? This action will start sending emails to your selected contacts.']";
    public static String ECCPOPUPNO= "//button[@type='button']/following::span[text()='No']";
    public static String ECCPOPUPYES= "//button[@type='button']/following::span[text()='Yes'] | //button[@type='button']/following::span[text()='Run Campaign']";
    public static String ECCNAMEVAL= "//span[text()='Name is required']";
    public static String ECCEMAILVAL= "//span[text()='Email template is required']";
    public static String ECCCATEGORYVAL= "//span[text()='Category is required']";
    public static String ECCPRODUCTVAL= "//span[text()='Product is required']";

    //User management page
    public static String userManagementMenu = "//span[contains(text(),'User Management')]";
    public static String userInvitation = "//button[contains(text(),'User Invitation')]";
    public static String userSubMenu = "//button[text()='Users']";
    public static String rolePermission = "//button[text()='Role Permissions']";
    public static String userInvitationHeader = "//h6[text()='User Invitation']";

    //Role and Permission
    public static String enterRoleName  = "//input[@placeholder='Enter Role Name']";
    public static String roleDropdown   = "//input[@placeholder='Select Role']";
    public static String firstNameError = "//span[text()='First Name is required']";
    public static String lastNameError  = "//span[text()='Last Name is required']";
    public static String phoneError     = "//div[text()='Phone number is required']";
    public static String emailError     = "//span[text()='Email is required']";
    public static String roleError      = "//span[text()='Role is required']";
    public static String RoleNameError  = "//span[text()='Role Name is required']";
    public static String totalRows      = "//td[text()='Total Rows: 22']";

    //grid page headers
    public static String firstNameHeader = "//div[@role='presentation']//span[text()='First Name']";
    public static String LastNameHeader = "//div[@role='presentation']//span[text()='Last Name']";
    public static String statusHeader = "//div[@role='presentation']//span[text()='Status']";
    public static String tokenStatusHeader = "//div[@role='presentation']//span[text()='Token Status']";
    public static String userHeader = "//h6[text()='User']";
    public static String rolePermissionHeader = "//h6[contains(text(),'Role Permissions')]";
    public static String roleNameHeader = "//span[contains(text(),'Role Name')]";

    //Company Management
    public static String COMPANYSIDEBAR= "//span[text()='Company']";
    public static String COMPMGMTBTN= "//button[text()='Company Management']";
    public static String CMGMTHEADER= "//h6[text()='Company Management']";
    public static String CMGMTTOTAL = "//div[@class=\"MuiBox-root css-a7l4db\"] | //h6/following::div[1]";
    public static String CMGMTSEARCH= "//input[@placeholder=\"Search...\"]";
    public static String CMGMTFILTER= "//span[text()='Filters']/parent::button";
    public static String CMGMTREFRESH= "//span[@class=\"MuiButton-loadingWrapper\"]/parent::button";
    public static String CMGMTCREATEBTN= "//span[text()='Create']/parent::button";
    public static String CMGMTSR= "//span[text()='#'] | //div[text()='#']";
    public static String CMGMTNAME= "//span[text()='Name'] | //div[text()='Name']";
    public static String CMGMTDESIGNATION= "//span[text()='Designation'] | //div[text()='Designation']";
    public static String CMGMTEMAIL= "//span[text()='Email'] | //div[text()='Email']";
    public static String CMGMTPHONE= "//span[text()='Phone Number'] | //div[text()='Phone Number']";
    public static String CMGMTCREATEDDATE= "//span[text()='Created Date'] | //div[text()='Created Date']";
    public static String CMGMTACTIONS= "//span[text()='Actions'] | //div[text()='Actions']";
    public static String CMGMTSHOWTEXT= "//p[text()='Show']";
    public static String CMGMTROWSINPUT= "//div[@aria-haspopup=\"listbox\"]";
    public static String CMGMTPREVBTN= "//button[@aria-label=\"Go to previous page\"]";
    public static String CMGMTNEXTBTN= "//button[@aria-label=\"Go to next page\"]";
    public static String CMGMTEDITBTN= "(//button[@aria-label=\"Edit\"])[1] | (//span[@aria-label=\"Edit\"]/button)[1]";
    public static String CMGMTDELETEBTN= "//button[@aria-label=\"Delete\"] | (//span[@aria-label=\"Delete\"]/button)[1]";
    public static String CMGMTVIEWBTN= "//button[@aria-label=\"View\"] | (//span[@aria-label=\"View\"]/child::button)[1]";

    //Company management Create
    public static String CCHEADER = "//h6[text()='Create Company Management']";
    public static String CCBACKBUTTON = "//h6[text()='Create Company Management']/preceding-sibling::button[@type=\"button\"]";
    public static String CCANCELBTN = "//span[text()='Cancel']/parent::button";
    public static String CCSAVEBTN = "//span[text()='Save']/parent::button";
    public static String CCNAMELABEL = "//span[text()='Name']";
    public static String CCDESIGNATIONLABEL = "//span[text()='Designation']";
    public static String CCEMAILLABEL = "//span[text()='Email']";
    public static String CCPHONELABEL = "//span[text()='Phone Number']";
    public static String CCSUCCESS = "//div[text()='Company Management created successfully']";
    public static String CCNAMEINPUT = "//input[@name=\"name\"]";
    public static String CCDESIGNATIONINPUT = "//input[@name=\"designation\"]";
    public static String CCEMAILINPUT = "//input[@name=\"email\"]";
    public static String CCPHONEINPUT = "//input[@name=\"phone_number\"]";
    public static String CCNAMEVAL = "//span[text()='Name is required']";
    public static String CCDESIGNATIONVAL = "//span[text()='Designation is required']";
    public static String CCEMAILVAL = "//span[text()='Email is required']";
    public static String CCPHONEVAL = "//div[text()='Phone number is required']";
    public static String CEDITHEADER = "//h6[text()='Update Company Management']";
    public static String CEDITRESET = "//span[text()='Reset']/parent::button";
    public static String CEDITMSG = "//div[text()='Company Management updated successfully']";
    public static String CDELETEMSG2 = "//h6[text()='Delete Company Management']|//p[text()='Delete Company Management']";
    public static String CDELETEMSG3 = "//p[text()='Are you sure you want to permanently delete this Company Management?']";
    public static String CDELETEMSGCANCEL = "//span[text()='Cancel']/parent::button | //span[text()='Cancel']/ancestor::button";
    public static String CDELETEMSGDELETE = "//span[text()='Delete']/parent::button | //span[text()='Delete']/ancestor::button";
    public static String CVIEWHEADER = "//p[contains(text(),'View ')]";
    public static String CVIENAMEINPUT =  "(//span[text()='Name']/following::input[@type=\"text\"])[1]";
    public static String CVIEWDESIGINPUT = "(//span[text()='Name']/following::input[@type='text'])[2]";
    public static String CVIEWEMAILINPUT = "(//span[text()='Name']/following::input[@type='text'])[3]";
    public static String CVIEWPHONEINPUT = "(//span[text()='Name']/following::input[@type='text'])[4]";
    public static String CVIEWCANCELBUTTON = "//span[text()='Cancel']/parent::button";
    public static String CCREATEDDATEVAL = "//div[@data-rowindex=\"0\"]/child::div[@data-field=\"created_at\"]";

    // Company Portfolio
    public static String COMPANYPORTFOLIO = "//button[text()='Company Portfolio']";
    public static String CPHEADER = "//h6[text()='Company Portfolio']";
    public static String CPSEARCH= "//input[@placeholder=\"Search...\"]";
    public static String CPFILTER= "//span[text()='Filters']/parent::button";
    public static String CPREFRESH= "//span[@class=\"MuiButton-loadingWrapper\"]/parent::button";
    public static String CPCREATEBTN= "//span[text()='Create']/parent::button";
    public static String CPSR= "//span[text()='#']|//div[text()='#']";
    public static String CPDESC= "//span[text()='Description']|//div[text()='Description']";
    public static String CPCREATEDATE= "//span[text()='Created Date']|//div[text()='Created Date']";
    public static String CPACTION= "//span[text()='Actions']|//div[text()='Actions']";
    public static String CPSHOWTEXT= "//p[text()='Show']";
    public static String CPROWSINPUT= "//div[@aria-haspopup=\"listbox\"]";
    public static String CPPREVBTN= "//button[@aria-label=\"Go to previous page\"]";
    public static String CPNEXTBTN= "//button[@aria-label=\"Go to next page\"]";
    public static String CPVIEWBTN= "//button[@aria-label=\"View\"]|//button[@type=\"button\"]/parent::span[@aria-label=\"View\"]";
    public static String CPEDITBTN= "//button[@aria-label=\"Edit\"]|//button[@type=\"button\"]/parent::span[@aria-label=\"Edit\"]";
    public static String CPSEARCHRESULT= "//div[@data-rowindex=\"0\"]/child::div[@data-field=\"name\" ]|//tbody/tr[1]/td[2]";

    //Company Portfolio Create
    public static String CPCHEADER = "//h6[text()='Create Company Portfolio']";
    public static String CPCBACKBUTTON = "//h6[text()='Create Company Portfolio']/preceding-sibling::button[@type=\"button\"]";
    public static String CPCANCELBTN = "//span[text()='Cancel']/parent::button";
    public static String CPCSAVEBTN = "//span[text()='Save']/parent::button";
    public static String CPCNAMELABEL = "//span[text()='Name']";
    public static String CPCDESC = "//span[text()='Description']";
    public static String CPCSUCESS = "//div[text()='Company Portfolio created successfully']";
    public static String CPCEDITMSG = "//div[text()='Company Portfolio updated successfully']";

    public static String CPCNAMEINPUT = "(//span[text()='Name']/following::input[@type=\"text\"])[1]";
    public static String CPCDESCINPUT = "(//span[text()='Name']/following::input[@type=\"text\"])[2]";
//    public static String CPCDESCINPUTVIEW = "//textarea[1]|(//input[@type=\"text\"]/preceding::label)[2]| //textarea[1]|(//input[@type=\"text\"])[3]";
    public static String CPCDESCINPUTVIEW = "//span[text()='Description']/following::input[1]| //input/preceding::span[text()='Description']";

    public static String CPCEDITHEADER = "//h6[text()='Update Company Portfolio']";

    public static String CPDELETE1 = "//h6[text()='Delete Company Portfolio']|//p[text()='Delete Company Portfolio']";
    public static String CPDELETE2 = "//p[text()='Are you sure you want to permanently delete this Company Portfolio?']";
    public static String CPDELETECANCEL = "//span[text()='Cancel']/parent::button|//span[text()='Cancel']/ancestor::button";
    public static String CPDELETEDELETE = "//span[text()='Delete']/parent::button|//span[text()='Delete']/ancestor::button";

    //Working Hours Page
    public static final String WH_MENU =
            "//button[text()='Working Hours']";

    public static final String WH_HEADER =
            "//h6[text()='Business Working Hours']";

    public static final String WH_SAVE_BUTTON =
            "//span[text()='Save']/parent::button";

    public static final String SUCCESSMSG = "//div[text()='Business Hours updated successfully']";
    public static final String NOCHANGESMSG = "//div[text()='No changes detected']";
    public static final String HOLIDAYTEXT = "//li[text()='Holiday']";
    public static final String WORKINGTEXT = "//li[text()='Working']";


    // Column Headers
    public static final String WH_COLUMN_WEEKDAY =
            "//div[text()='Weekday']";

    public static final String WH_COLUMN_TYPE =
            "//div[text()='Type']";

    public static final String WH_COLUMN_START_TIME =
            "//div[text()='Start Time']";

    public static final String WH_COLUMN_END_TIME =
            "//div[text()='End Time']";


    // Weekday Labels
    public static final String WH_MONDAY_LABEL =
            "//div[text()='Monday']";

    public static final String WH_TUESDAY_LABEL =
            "//div[text()='Tuesday']";

    public static final String WH_WEDNESDAY_LABEL =
            "//div[text()='Wednesday']";

    public static final String WH_THURSDAY_LABEL =
            "//div[text()='Thursday']";

    public static final String WH_FRIDAY_LABEL =
            "//div[text()='Friday']";

    public static final String WH_SATURDAY_LABEL =
            "//div[text()='Saturday']";

    public static final String WH_SUNDAY_LABEL =
            "//div[text()='Sunday']";


    // Type Inputs
    public static final String WH_MONDAY_TYPE_INPUT =
            "//div[text()='Monday']/following::input[1]";

    public static final String WH_TUESDAY_TYPE_INPUT =
            "//div[text()='Tuesday']/following::input[1]";

    public static final String WH_WEDNESDAY_TYPE_INPUT =
            "//div[text()='Wednesday']/following::input[1]";

    public static final String WH_THURSDAY_TYPE_INPUT =
            "//div[text()='Thursday']/following::input[1]";

    public static final String WH_FRIDAY_TYPE_INPUT =
            "//div[text()='Friday']/following::input[1]";

    public static final String WH_SATURDAY_TYPE_INPUT =
            "//div[text()='Saturday']/following::input[1]";

    public static final String WH_SUNDAY_TYPE_INPUT =
            "//div[text()='Sunday']/following::input[1]";


    // Start Time Inputs
    public static final String WH_MONDAY_START_TIME_INPUT =
            "//div[text()='Monday']/following::input[2]";

    public static final String WH_TUESDAY_START_TIME_INPUT =
            "//div[text()='Tuesday']/following::input[2]";

    public static final String WH_WEDNESDAY_START_TIME_INPUT =
            "//div[text()='Wednesday']/following::input[2]";

    public static final String WH_THURSDAY_START_TIME_INPUT =
            "//div[text()='Thursday']/following::input[2]";

    public static final String WH_FRIDAY_START_TIME_INPUT =
            "//div[text()='Friday']/following::input[2]";

    public static final String WH_SATURDAY_START_TIME_INPUT =
            "//div[text()='Saturday']/following::input[2]";

    public static final String WH_SUNDAY_START_TIME_INPUT =
            "//div[text()='Sunday']/following::input[2]";


    // End Time Inputs
    public static final String WH_MONDAY_END_TIME_INPUT =
            "//div[text()='Monday']/following::input[3]";

    public static final String WH_TUESDAY_END_TIME_INPUT =
            "//div[text()='Tuesday']/following::input[3]";

    public static final String WH_WEDNESDAY_END_TIME_INPUT =
            "//div[text()='Wednesday']/following::input[3]";

    public static final String WH_THURSDAY_END_TIME_INPUT =
            "//div[text()='Thursday']/following::input[3]";

    public static final String WH_FRIDAY_END_TIME_INPUT =
            "//div[text()='Friday']/following::input[3]";

    public static final String WH_SATURDAY_END_TIME_INPUT =
            "//div[text()='Saturday']/following::input[3]";

    public static final String WH_SUNDAY_END_TIME_INPUT =
            "//div[text()='Sunday']/following::input[3]";

    public static final String WH_CLEAR_MONDAY= "(//div[text()='Monday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_TUESDAY= "(//div[text()='Tuesday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_WEDNESDAY= "(//div[text()='Wednesday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_THURSDAY= "(//div[text()='Thursday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_FRIDAY= "(//div[text()='Friday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_SATURDAY= "(//div[text()='Saturday']/following::button[@title='Clear'])[1]";
    public static final String WH_CLEAR_SUNDAY= "(//div[text()='Sunday']/following::button[@title='Clear'])[1]";

// Integration -> WhatsApp Integration

    public static final String INTEGRATIONMENU = "//span[text()='Integration']";
    public static final String INTEGRATIONHEADER = "//h6[text()='Integration']";
    public static final String WIMENU = "//p[text()='WhatsApp']/parent::div|//p[text()='WhatsApp']/ancestor::div[1]";
    public static final String WIICON = "//p[text()='WhatsApp']/preceding::*[local-name()='svg'][1]";
    public static final String WIDISCONNECTED = "//p[text()='WhatsApp']/preceding::span[text()='Disconnected']";
    public static final String WICONNECTED = "//p[text()='WhatsApp']/preceding::span[text()='Connected']";
    public static final String WIMESSAGE = "//p[text()='WhatsApp']/following-sibling::p[text()='Send automated WhatsApp messages.']";
    public static final String WIMESSAGE2 = "//p[text()='WhatsApp']";
    public static final String WIEXISTS = "//span[text()='This phone id is already connected. Please use a different one.']";
    public static final String WITOKENEXPIREDMSG = "//div[contains(text(),'Authentication failed')]";

    //Inside WhatsApp Integration

    public static final String WIIHEADER = "//h6[text()='WhatsApp Integration']";
    public static final String WIIICON = "//h6[text()='WhatsApp Integration']/preceding-sibling::*[local-name()='svg']";
    public static final String WIIHEADERMESSAGE = "//p[text()='Set up your Whatsapp integration for the first time.']";
    public static final String WIIINTEGRATIONBUTTON = "//button[@id=\"step1-header\"]|//button[@id=\"Integration setup steps-header\"]";
    public static final String WIISTEPS = "//div[@class=\"MuiAccordionDetails-root css-l9xe8y\"]";
    public static final String WIIPHONEID = "//span[text()='Phone Id']";
    public static final String WIIPHONEIDINPUT = "//input[@name=\"phone_id\"]";
    public static final String WIIPHONEIDTOOLTIP = "//*[name()='svg' and @aria-label='Phone ID is the unique identifier for your WhatsApp Business phone number.']";
    public static final String WIIWABAID = "//span[text()='Waba Id']";
    public static final String WIIWABAIDINPUT = "//input[@name=\"waba_id\"]";
    public static final String WIIWABAIDTOOLTIP = "//*[name()='svg' and @aria-label='WABA ID is your WhatsApp Business Account ID, which links your phone number to your business account.']";
    public static final String WIITOKEN = "//span[text()='Token']";
    public static final String WIITOKENINPUT = "//input[@name=\"token\"]";
    public static final String WIITOKENTOOLTIP = "//*[name()='svg' and @aria-label='Token is your WhatsApp Business API token used for authentication. Keep it secure.']";
    public static final String WIIAPPID = "//span[text()='App Id']";
    public static final String WIIAPPIDINPUT = "//input[@name=\"app_id\"]";
    public static final String WIIAPPIDTOOLTIP = "//*[name()='svg' and @aria-label='App ID is found in your Facebook developer account under your WhatsApp app settings.']";
    public static final String WIIAPPSECRET = "//span[text()='App Secret']";
    public static final String WIIAPPSECRETINPUT = "//input[@name=\"app_secret\"]";
    public static final String WIIAPPSECRETTOOLTIP = "//*[name()='svg' and @aria-label='App Secret is found in your Facebook developer account under your WhatsApp app settings. Keep it confidential.']";
    public static final String WIICONNECT = "//button[@type=\"submit\"]";
    // ================= STEP 1 : Create a Meta Developer Account =================
    public static final String STEP1_ALL_LI =
            "//h2[normalize-space()='Step 1: Create a Meta Developer Account']/following-sibling::ol/li";

    public static final String STEP1_LI_GO_TO_META =
            "//h2[normalize-space()='Step 1: Create a Meta Developer Account']/following-sibling::ol/li[starts-with(normalize-space(),'Go to')]";

    public static final String STEP1_LI_LOGIN_FACEBOOK =
            "//h2[normalize-space()='Step 1: Create a Meta Developer Account']/following-sibling::ol/li[normalize-space()='Log in with your Facebook account.']";

    public static final String STEP1_LI_CREATE_DEV_ACCOUNT =
            "//h2[normalize-space()='Step 1: Create a Meta Developer Account']/following-sibling::ol/li[contains(normalize-space(),'developer account')]";


    // ================= STEP 2 : Create a WhatsApp App =================
    public static final String STEP2_ALL_LI =
            "//h2[normalize-space()='Step 2: Create a WhatsApp App']/following-sibling::ol/li";

    public static final String STEP2_LI_GO_TO_DASHBOARD =
            "//h2[normalize-space()='Step 2: Create a WhatsApp App']/following-sibling::ol/li[contains(normalize-space(),'Meta App Dashboard')]";

    public static final String STEP2_LI_SELECT_BUSINESS =
            "//h2[normalize-space()='Step 2: Create a WhatsApp App']/following-sibling::ol/li[contains(normalize-space(),'Business')]";

    public static final String STEP2_LI_ENTER_APP_DETAILS =
            "//h2[normalize-space()='Step 2: Create a WhatsApp App']/following-sibling::ol/li[contains(normalize-space(),'App Name')]";

    public static final String STEP2_LI_CREATE_APP =
            "//h2[normalize-space()='Step 2: Create a WhatsApp App']/following-sibling::ol/li[normalize-space()='Click Create App.']";


    // ================= STEP 3 : Add WhatsApp to Your App =================
    public static final String STEP3_ALL_LI =
            "//h2[normalize-space()='Step 3: Add WhatsApp to Your App']/following-sibling::ol/li";

    public static final String STEP3_LI_ADD_PRODUCTS =
            "//h2[normalize-space()='Step 3: Add WhatsApp to Your App']/following-sibling::ol/li[contains(normalize-space(),'Add Products')]";

    public static final String STEP3_LI_SET_UP_WHATSAPP =
            "//h2[normalize-space()='Step 3: Add WhatsApp to Your App']/following-sibling::ol/li[contains(normalize-space(),'Set Up')]";

    public static final String STEP3_LI_WABA_CREATED =
            "//h2[normalize-space()='Step 3: Add WhatsApp to Your App']/following-sibling::ol/li[contains(normalize-space(),'WABA')]";


    // ================= STEP 4 : Get Your Credentials =================
    public static final String STEP4_PHONE_WABA_ALL_LI =
            "//h3[normalize-space()='1. Phone ID & WABA ID']/following-sibling::ul/li";

    public static final String STEP4_LI_API_SETUP =
            "//h3[normalize-space()='1. Phone ID & WABA ID']/following-sibling::ul/li[contains(normalize-space(),'API Setup')]";

    public static final String STEP4_LI_VERIFY_OTP =
            "//h3[normalize-space()='1. Phone ID & WABA ID']/following-sibling::ul/li[contains(normalize-space(),'OTP')]";

    public static final String STEP4_LI_SEND_TEST_MESSAGE =
            "//h3[normalize-space()='1. Phone ID & WABA ID']/following-sibling::ul/li[contains(normalize-space(),'test message')]";

    public static final String STEP4_LI_COPY_IDS =
            "//h3[normalize-space()='1. Phone ID & WABA ID']/following-sibling::ul/li[contains(normalize-space(),'Phone Number ID')]";

    public static final String STEP4_APP_ALL_LI =
            "//h3[normalize-space()='2. App ID & App Secret']/following-sibling::ul/li";

    public static final String STEP4_LI_BASIC_SETTINGS =
            "//h3[normalize-space()='2. App ID & App Secret']/following-sibling::ul/li[contains(normalize-space(),'Settings')]";

    public static final String STEP4_LI_COPY_APP_IDS =
            "//h3[normalize-space()='2. App ID & App Secret']/following-sibling::ul/li[contains(normalize-space(),'App ID')]";


    // ================= STEP 5 : Complete WhatsApp Setup Flow =================
    public static final String STEP5_ALL_LI =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li";

    public static final String STEP5_LI_BUSINESS_VERIFICATION =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li[contains(normalize-space(),'Business Verification')]";

    public static final String STEP5_LI_MESSAGE_TEMPLATES =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li[contains(normalize-space(),'Message Templates')]";

    public static final String STEP5_LI_ASSIGN_PHONE =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li[contains(normalize-space(),'Assign Phone Numbers')]";

    public static final String STEP5_LI_WEBHOOK =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li[contains(normalize-space(),'Webhook')]";

    public static final String STEP5_LI_LIVE_MODE =
            "//h2[normalize-space()='Step 5: Complete WhatsApp Setup Flow']/following-sibling::ul/li[contains(normalize-space(),'Live Mode')]";


    // ================= STEP 6 : Token (Access Token) =================
    public static final String STEP6_ALL_LI =
            "//h2[normalize-space()='Step 6: Token (Access Token)']/following-sibling::ul/li";

    public static final String STEP6_LI_TEMP_TOKEN =
            "//h2[normalize-space()='Step 6: Token (Access Token)']/following-sibling::ul/li[contains(normalize-space(),'Temporary Token')]";

    public static final String STEP6_LI_PERM_TOKEN =
            "//h2[normalize-space()='Step 6: Token (Access Token)']/following-sibling::ul/li[contains(normalize-space(),'Permanent Token')]";

    public static final String STEP6_PERMISSIONS_ALL_LI =
            "//h2[normalize-space()='Step 6: Token (Access Token)']//li[contains(normalize-space(),'Permanent Token')]/ul/li";

    public static final String STEP6_LI_PERMISSION_MSG =
            "//li[normalize-space()='whatsapp_business_messaging']";

    public static final String STEP6_LI_PERMISSION_MGMT =
            "//li[normalize-space()='whatsapp_business_management']";

    public static final String STEP6_LI_PERMISSION_PROFILE =
            "//li[normalize-space()='public_profile']";


    // ================= STEP 7 : Add Credentials to Integration Form =================
    public static final String STEP7_DESCRIPTION =
            "//h2[normalize-space()='Step 7: Add Credentials to Integration Form']/following-sibling::p";

    public static final String STEP7_CONNECT_TEXT =
            "//h2[normalize-space()='Step 7: Add Credentials to Integration Form']/following-sibling::p[contains(normalize-space(),'Connect')]";

    //WhatsApp Integration Mandatory

    public static String PHONEIDVAL = "//span[text()='Phone Id is required']";
    public static String WABAIDVAL = "//span[text()='Waba Id is required']";
    public static String TOKENVAL = "//span[text()='Token is required']";
    public static String APPIDVAL = "//span[text()='App Id is required']";
    public static String APPSECRETIDVAL = "//span[text()='App Secret is required']";

    //WhatsApp Integration Edit
    public static String WIEDITBTN = "//span[text()='Edit']/parent::button";
    public static String CONNECTEDICON = "//h6[text()='WhatsApp Integration']/following::span[text()='Connected']";
    public static String STATISTICS = "//span[text()='Statistics']";
    public static String WIREFRESH = "//span[text()='Statistics']//following-sibling::*[local-name()='svg']";
    public static String WIREFRESHSUCCESS = "//div[text()='success']";
    public static String WITHROUGHPUT = "//h6[text()='Throughput Level']";
    public static String WICODEV = "//h6[text()='Code verification status']";
    public static String WIMSGV = "//h6[text()='Message Limit Tier']";
    public static String WIACCOUNTV = "//h6[text()='Account Mode']";
    public static String WIQUALITYV = "//h6[text()='Quality Rating']";
    public static String WIDISCONNECTBTN = "//span[text()='Disconnect']/parent::button";
    public static String WICONNECTBTN = "//span[text()='Connect']/parent::button";
    public static String WIDISCONNECTMSG = "//div[text()='Disconnected successfully']";
    public static String WIUPDATEDMSG = "//div[text()='WhatsApp Integration Updated']";

    //Conversation Page
    public static String CONVERSATIONMENU = "//span[text()='Conversations']";
    public static String WACONVERSATIONMENU = "//button[text()='Whatsapp Conversations']";
    public static String WACONVERSATIONHEADER = "//div[text()='WhatsApp Conversation']|//h6[text()='WhatsApp Conversation']";
    public static String WACONVERSATIONINFO = "//p[text()='Select a contact to start chatting']";
    public static String WACONNECTED = "//span[text()='Connected']";
    public static String WADISCONNECTED = "//p[text()='To use this functionality, please connect your WhatsApp integration first.']";


    //LeadStage
    public static final String LeadStageMenu ="//button[text()='Lead Stage']";
    public static final String LS_header = "//h6[text()='Lead Stage']";
    public static final String  LS_Create = "//span[text()='Create']";
    //public static final String  LS_Refresh = " ";
    public static final String  LSH_Name = "//span[text()='Name']";
    public static final String LSH_Label = "//span[text()='Label']";
    public static final String LSH_Order = "//span[text()='Order']";
    public static final String LSH_Actions = "//span[text()='Actions']";
    public static final String LS_Save ="//span[text()='Save']";
    public static final String LS_ErrorOnName = "//span[text()='Name is required']";
    public static final String LS_ErrorOnLabel = "//span[text()='Label is required']";
    public static final String LS_ErrorOnOrder = "//span[text()='Order is required']";
    public static final String LS_Cancel = "//span[text()='Cancel']";
    public static final String LS_Back = "//h6[text()='Create Lead Stage']/preceding-sibling::button";
    public static final String LS_Name = "//input[@placeholder='Enter Name']";
    public static final String LS_Label = "//input[@placeholder='Enter Label']";
    public static final String LS_Order = "//input[@placeholder='Enter Order']";

    //Integration -> SMTP Integration
    public static final String SMTPINTEGRATION = "//p[text()='SMTP']/parent::div";
    public static final String SMTPICON = "//p[text()='SMTP']/preceding::*[local-name()='svg'][1]";
    public static final String SMTPDISCONNECTED = "//p[text()='SMTP']/preceding::span[text()='Disconnected']";
    public static final String SMTPPENDING = "//p[text()='SMTP']/preceding::span[text()='Pending']";
    public static final String SMTPCONNECTED = "//p[text()='SMTP']/preceding::span[text()='Connected'][1]";
    public static final String SMTPMESSAGE = "//p[text()='SMTP']/following-sibling::p[text()='Integrate your email service using SMTP.']";
    public static final String SMTPMESSAGE2 = "//p[text()='SMTP']";

    // Add SMTP Integration

    public static final String SIHEADER = "//h6[text()='SMTP Integration']";
    public static final String SIICON = "//h6[text()='SMTP Integration']/preceding-sibling::*[local-name()='svg']";
    public static final String SIHEADERMESSAGE = "//h6[text()='SMTP Integration']/following::p[text()='Set up your SMTP integration for the first time.']";
    public static final String SENDERNAMEHEADER = "//span[text()='Sender Name']|//span[text()='Integration setup steps']/following::span[3]";
    public static final String PROVIDERTYPEHEADER = "//span[text()='Provider Type']|//h6[text()='Provider Type']";
    public static final String EMAILHEADER = "//span[text()='Email']|//h6[text()='Email']";
    public static final String PASSWORDHEADER = "//span[text()='Password']|//h6[text()='Password']";
    public static final String PORTHEADER = "//span[text()='Port number']|//h6[text()='Port']";
    public static final String TERMS = "//p[contains(text(),'By using')]";
    public static final String TERMSCB = "//span[@class=\"css-ysvidx\"] | //input[@type='checkbox']";
    public static final String CONNECT = "//button[@type=\"submit\"]";

    public static final String SINAMEINPUT = "//input[@name=\"name\"]";
    public static final String SIPROVIDERINPUT = "//input[@placeholder=\"Select Provider Type\"]";
    public static final String SIEMAILINPUT = "//input[@placeholder=\"Enter Email\"]";
    public static final String SIPASSINPUT = "//input[@placeholder=\"Enter password\"]";
    public static final String SIPORTINPUT = "//input[@placeholder=\"Select\"]";
    public static final String SIEDIT = "//span[text()='Edit']/parent::button";

    //SMTP Mandatory

    public static String SENDERNAMEVAL = "//span[text()='Sender Name is required']";
    public static String PROVIDERVAL = "//span[text()='Provider type is required']";
    public static String EMAILVAL = "//span[text()='email is required']";
    public static String PASSWORDVAL = "//span[text()='password is required']";
    public static String PROVIDERREQVAL = "//span[text()='Provider type is required']";
    public static String PASSWORDREQVAL = "//span[text()='Enter a valid email address']";
    public static String INTEGRATIONVALMESSAGE = "//div[contains(text(),'SMTP Integration')]";
    public static String FAILVALMESSAGE = "//div[contains(text(),'Failed')]";

    public static String DISCONNECTBUTTON = "//span[text()='Disconnect']/parent::button";
    public static String DISCONNECTMESSAGE = "//div[contains(text(),'Disconnected successfully')]";

    // ================= STEP 1 =================
    public static final String STEP1_ENABLE_2FA_TITLE =
            "//h6[normalize-space()='1. Enable 2-Factor Authentication (if not already enabled)']";

    // ================= STEP 1 DETAILS =================
    public static final String GOOGLE_ACCOUNT_SETTINGS_TITLE =
            "//h6[normalize-space()='Go to your Google Account settings']";

    public static final String GOOGLE_ACCOUNT_INFO="//p[contains(text(),'Click Security in the left sidebar')]";


    // ================= STEP 2 =================
    public static final String STEP2_GENERATE_APP_PASSWORD_TITLE =
            "//h6[normalize-space()='2. Generate App Password']";
    public static final String PASSINFO = "//p[contains(text(),'Click App passwords ')]";


    // ================= STEP 2 DETAILS =================
    public static final String SECURITY_SECTION_SIGN_IN_TITLE =
            "//h6[normalize-space()='In the same Security section, scroll down to \"Signing in to Google\"']";


    // ================= STEP 3 =================
    public static final String STEP3_CREATE_APP_PASSWORD_TITLE =
            "//h6[normalize-space()='3. Create App Password for Mail']";


    // ================= STEP 3 DETAILS =================
    public static final String SELECT_APP_MAIL_TITLE =
            "//h6[normalize-space()='Under Select app, choose Mail']";

    public static final String MAILINFO = "//p[contains(text(),'Under Select device')]";


    // ================= STEP 4 =================
    public static final String STEP4_COPY_PASSWORD_TITLE =
            "//h6[normalize-space()='4. Copy the Password']";


    // ================= STEP 4 DETAILS =================
    public static final String GOOGLE_16_CHARACTER_PASSWORD_TITLE =
            "//h6[contains(normalize-space(),'16-character password')]";

    public static final String GOOGLEPASSINFO="//p[contains(text(),'Copy this password immediately')]";


    // ================= CONTAINERS =================

    public static final String STEP1_CONTAINER =
            "//div[contains(@class,'MuiBox-root')][.//h6[contains(text(),'Enable 2-Factor Authentication')]]";

    public static final String STEP2_CONTAINER =
            "//div[contains(@class,'MuiBox-root')][.//h6[contains(text(),'Generate App Password')]]";

    public static final String STEP3_CONTAINER =
            "//div[contains(@class,'MuiBox-root')][.//h6[contains(text(),'Create App Password')]]";

    public static final String STEP4_CONTAINER =
            "//div[contains(@class,'MuiBox-root')][.//h6[contains(text(),'Copy the Password')]]";


    //Customer Locators

    public static final String CONTACT_MENU = "//span[text()='Contact']/ancestor::button";
    public static final String CUSTOMER_MENU = "//button[normalize-space()='Customer']";
    public static final String CUSTOMER_HEADER = "//h6[normalize-space()='Customer']";
    public static final String CUSTOMER_TOTAL_COUNT = "//h6/following::div[1]";
    public static final String CUSTOMER_SEARCH_BAR = "//input[@placeholder='Search' or contains(@placeholder,'Search')]";
    public static final String CUSTOMER_FILTER_BUTTON = "//button[.//text()[contains(.,'Filter')]]";
    public static final String CUSTOMER_REFRESH_BUTTON = "//span[text()='Filters']/following::button[1]";
    public static final String SELECT_CONTACT = "//button[.//text()[contains(.,'Select Contacts')]]";
    public static final String CUSTOMER_CREATE_BUTTON = "//button[.//text()[contains(.,'Create')]]";
    public static final String COLUMN_HASH = "//th[normalize-space()='#']";
    public static final String COLUMN_CUSTOMER_NAME = "//th[normalize-space()='Customer Name']";
    public static final String COLUMN_INDUSTRY = "//th[normalize-space()='Industry']";
    public static final String COLUMN_COMPANY_SIZE = "//th[normalize-space()='Company Size']";
    public static final String COLUMN_STATUS = "//th[normalize-space()='Status']";
    public static final String COLUMN_CREATED_DATE = "//th[normalize-space()='Created Date']";
    public static final String COLUMN_ACTIONS = "//th[normalize-space()='Actions']";
    public static final String PAGINATION_SHOW_DROPDOWN = "//p[normalize-space()='Show']";
    public static final String PAGINATION_NEXT = "//button[@aria-label='Go to next page']";
    public static final String PAGINATION_PREVIOUS = "//button[@aria-label='Go to previous page']";

    //Customer Create page locators

    public static final String CC_HEADER = "//h6[text()='Create Customer']";
    public static final String CC_CANCEL = "//span[text()='Cancel']/parent::button";
    public static final String CC_SAVE = "//span[text()='Save']/parent::button";
    public static final String CC_BASIC_DETAILS = "//h2[text()='Basic Details']";
    public static final String CC_NAME = "//input[@name=\"name\"]";
    public static final String CC_SELECT_INDUSTRY = "//input[@placeholder=\"Select Industry\"]";
    public static final String CC_COMPANY_SIZE = "//input[@name=\"company_size\"]";
    public static final String CC_DESC = "//input[@name=\"description\"]";

    public static final String CC_BILLING_NAME = "//input[@name=\"billing_name\"]";
    public static final String CC_BILLING_ADDRESS_LINE_1 = "//input[@name=\"billing_address_line_1\"]";
    public static final String CC_BILLING_ADDRESS_LINE_2 = "//input[@name=\"billing_address_line_2\"]";
    public static final String CC_SELECT_COUNTRY = "//input[@placeholder=\"Select Country\"]|(//label[.//span[text()='Country']]/following::input[@role='combobox'])[1]";
    public static final String CC_SELECT_STATE = "//input[@placeholder=\"Select State\"]|(//label[.//span[text()='State']]/following::input[@role='combobox'])[1]";
    public static final String CC_SELECT_CITY = "//input[@placeholder=\"Select City\"]|(//label[.//span[text()='City']]/following::input[@role='combobox'])[1]";
    public static final String CC_SELECT_CODE = "//input[@placeholder=\"Select code\"]";
    public static final String CC_BILLING_PHONE = "//input[@name=\"billing_phone_number\"]";
    public static final String CC_BILLING_EMAIL = "//input[@name=\"billing_email\"]";
    public static final String CC_SHIPPING = "//span[text()='Shipping Address']/parent::button";

    public static final String INPUT_SHIPPING_NAME        = "//input[@name='shipping_name']";
    public static final String INPUT_SHIPPING_ADDR_LINE1  = "//input[@name='shipping_address_line_1']";
    public static final String INPUT_SHIPPING_ADDR_LINE2  = "//input[@name='shipping_address_line_2']";


    public static final String SHIPPING_SELECT_COUNTRY =
            "(//span[text()='Shipping Address']/following::span[text()='Country']/following::input)[1]";

    public static final String SHIPPING_SELECT_STATE =
            "(//span[text()='Shipping Address']/following::span[text()='State']/following::input)[1]";

    public static final String SHIPPING_SELECT_CITY =
           "(//span[text()='Shipping Address']/following::span[text()='City']/following::input)[1]";


    public static final String INPUT_SHIPPING_PHONE = "//input[@name='shipping_phone_number']";
    public static final String INPUT_SHIPPING_EMAIL = "//input[@name='shipping_email']";

    public static final String CC_CONTACT_HEADER = "//h2[text()='Contacts']";
    public static final String CC_CONTACT_NAME = "//div[text()='Contact Name']";
    public static final String CC_CONTACT_SOURCE = "//div[text()='Contact Source']|(//div[text()='Contact Source'])[2]";
    public static final String CC_CONTACT_ACTION = "//div[text()='Action']";
    public static final String CC_SELECT_CONTACT_BUTTON = "//span[text()='Select Contacts']/parent::button";
    public static final String CC_ALREADY_ADDED_POPUP = "//p[normalize-space()='Contact Already Linked']";

    public static String CUSTOMER_CREATE_TOASTER = "//div[contains(normalize-space(), 'Customer Created Successfully')] | //div[text()='Customer created successfully']";
    public static String CUSTOMER_UPDATE_TOASTER = "//div[contains(normalize-space(), 'Customer updated successfully')] | //div[text()='Customer updated successfully']";
    public static String CUSTOMER_DELETE_MSG = "//p[text()='Delete Customer']";
    public static String CUSTOMER_DELETE_MSG2 = "//p[text()='Are you sure you want to permanently delete this Customer?']";


    //Assets Sharing Page

    public static final String COMAPNY_MENU = "//span[text()='Company']/ancestor::button";
    public static final String ASSETS_SHARING_MENU = "//button[text()='Assets & Sharing']";
    public static final String ASSETS_SHARING_HEADER = "//h6[text()='Assets & Sharing']";
    public static final String ASSETS_COUNT_BADGE = "//h6[normalize-space()='Assets & Sharing']/following-sibling::div";
    public static final String SEARCH_INPUT = "//input[@placeholder='Search...']";
    public static final String FILTER_BUTTON = "//button[.//span[normalize-space()='Filters']]";
    public static final String CREATE_BUTTON = "//button[.//span[normalize-space()='Create']]";

    public static final String LIST_VIEW_TAB = "(//button[@role='tab'])[1]";
    public static final String GRID_VIEW_TAB = "(//button[@role='tab'])[2]";

    public static final String TABLE_HEADER_NAME = "//th[.//div[normalize-space()='Name']]";
    public static final String TABLE_HEADER_DESCRIPTION = "//th[.//div[normalize-space()='Description']]";
    public static final String TABLE_HEADER_STATUS = "//th[.//div[normalize-space()='Status']]";
    public static final String TABLE_HEADER_ACTIONS = "//th[.//div[normalize-space()='Actions']]";

    public static final String TABLE_ROWS = "//tbody/tr";
    public static final String FIRST_ROW = "(//tbody/tr)[1]";

    public static final String ROW_NAME = "//tbody/tr[%s]/td[2]";
    public static final String ROW_DESCRIPTION = "//tbody/tr[%s]/td[3]";
    public static final String ROW_STATUS = "//tbody/tr[%s]/td[4]//span";

    public static final String VIEW_BUTTON = "(//tbody/tr[1]//span[@aria-label='View']/button)";
    public static final String EDIT_BUTTON = "(//tbody/tr[1]//span[@aria-label='Edit']/button)";
    public static final String DELETE_BUTTON = "(//tbody/tr[1]//span[@aria-label='Delete']/button)";

    public static final String SHOW_DROPDOWN = "//div[@role='combobox']";
    public static final String NEXT_PAGE_BUTTON = "//button[@aria-label='Go to next page']";
    public static final String PREVIOUS_PAGE_BUTTON = "//button[@aria-label='Go to previous page']";

    public static final String STATUS_ACTIVE = "//span[normalize-space()='Active']";

    public static final String AS_CREATE_BUTTON = "//span[normalize-space()='Create']/parent::button";

    public static final String AS_CREATE_HEADER = "//h6[normalize-space()='Create Assets & Sharing']";
    public static final String AS_CREATE_BASIC_DETAILSHEADER = "//h2[normalize-space()='Basic Details']";

    public static final String ASC_ASSET_NAME = "//span[text()='Asset Name']";
    public static final String ASC_ASSET_NAME_INPUT = "//input[@placeholder='Enter Asset name']";
    public static final String ASC_ASSET_NAME_INPUT_VAL = "//span[normalize-space()='Asset Name is required']";

    public static final String ASC_DESCRIPTION = "//span[text()='Description']";
    public static final String ASC_DESCRIPTION_INPUT = "//input[@placeholder='Enter Description']";
    public static final String ASC_DESCRIPTION_INPUT_VAL = "//span[normalize-space()='Description is required']";

    public static final String ASC_ADDITIONAL_INFO = "//span[text()='Additional Info']";
    public static final String ASC_ADDITIONAL_INFO_INPUT = "//input[@placeholder='Enter Additional Info']";
    public static final String ASC_ADDITIONAL_INFO_INPUT_VAL = "//span[normalize-space()='Additional Info is required']";

    public static final String ASC_CAN_BE_SENT_FROM_AI_LABEL = "//p[normalize-space()='Can Be Send From AI']";
    public static final String ASC_AI_YES_RADIO = "//input[@type='radio' and @value='true']";
    public static final String ASC_AI_NO_RADIO = "//input[@type='radio' and @value='false']";
    public static final String ASC_AI_YES_TEXT = "//p[normalize-space()='Yes']";
    public static final String ASC_AI_NO_TEXT = "//p[normalize-space()='No']";

    public static final String ASC_UPLOAD_ASSET_LABEL = "//span[text()='Upload Asset']";
    public static final String ASC_UPLOAD_INPUT = "//input[@type='file']/parent::div";
    public static final String ASC_UPLOAD_INPUT_VAL = "//input[@type='file']";
    public static final String ASC_UPLOAD_INPUT_VALIDATION = "//span[normalize-space()='Upload Asset is required']";
    public static final String ASC_SELECT_FILE_BUTTON = "//div[@role='button']//div[normalize-space()='Select file']";

    public static final String ASC_CANCEL_BUTTON = "//button//span[normalize-space()='Cancel']";
    public static final String ASC_SAVE_BUTTON = "//button//span[normalize-space()='Save']";
    public static final String ASC_CREATE_TOASTER =  "//div[contains(normalize-space(), 'Assets & Sharing Created Successfully')] | //div[text()='Assets & Sharing created successfully']";;
    public static final String ASC_UPDATE_TOASTER =  "//div[contains(normalize-space(), 'Assets & Sharing Updated Successfully')] | //div[text()='Assets & Sharing updated successfully']";;

    public static final String ASC_FORM_CONTAINER = "//form";
    public static final String ASC_BASIC_DETAILS_SECTION = "//h2[normalize-space()='Basic Details']/parent::div";
    public static final String ASC_VIEW_ASSET_SHARING = "//p[normalize-space()='View Assets & Sharing']";
    public static final String ASC_VIEW_NAME = "//span[contains(text(),'Name')]";
    public static final String ASC_VIEW_NAME_VALUE = "//span[text()='Name']/following::input[1]";
    public static final String ASC_VIEW_DESCRIPTION = "//span[contains(text(),'Description')]";
    public static final String ASC_VIEW_DESCRIPTION_VALUE = "//span[text()='Description']/following::input[1]";

    /* Recommended stable relative locators */
    public static final String ASC_ASSET_NAME_INPUT_REL = "//span[text()='Asset Name']/ancestor::label/following::input[1]";
    public static final String ASC_DESCRIPTION_INPUT_REL = "//span[text()='Description']/ancestor::label/following::input[1]";
    public static final String ASC_ADDITIONAL_INFO_INPUT_REL = "//span[text()='Additional Info']/ancestor::label/following::input[1]";

}