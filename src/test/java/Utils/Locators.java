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

    public static String createdSuccessfully = "//div[contains(text(), 'Created successfully')]";
    public static String roleAndPermissionAddedSuccessfully = "//div[contains(text(), 'Role and permissions added successfully')]";
    public static String DeletedSuccessfully = "//div[contains(text(), 'Deleted Successfully')]";
    public static String RoleNameIsAlreadyExist = "//div[contains(text(), 'Role name already exists')]";
    public static String invitationSentSuccessfully = "//div[contains(text(), 'Invitation Sent Successfully')]";
    public static String UpdatedSuccessfully = "//div[contains(text(), 'Updated successfully')]";
    public static String yourAccountIsVerified = "//div[contains(text(), 'Your account is verified.')]";
    public static String passwordHasBeenUpdated = "//div[contains(text(), 'Password has been updated')]";
    public static String invalidOtpValidation = "//div[contains(text(), 'Invalid OTP or OTP is expired! Please Try Again.')]";
    public static String passwordResetLinkSuccess = "//div[contains(text(), 'Password reset link has been sent to your email')]";
    public static String otpSentSuccessfully = "//div[contains(text(), 'An OTP is sent to p******t@yopmail.com. Please Verify your email.')]";
    //public static String UpdatedSuccessfully = "//div[contains(text(), 'Updated successfully')]";

    //Locators for the validation messages
    public static String ERRORMESSAGEFORINVALIDEMAIL = "//div[contains(text(), 'Invalid Credentials.')]";
    public static String LOGINSUCCESSMESSAGE = "//div[contains(text(), 'Login successful')]";
    public static String EMAILINP = "//input[@name='email']";
    public static String PASSWORDINP = "//input[@name='password']";
    public static String LOGINBTN = "//button[@type='submit']";
    public static String verifyOTPBtn = "//span[contains(text(),'Verify OTP')]/ancestor::button";
    public static String ERROREMAILBLANK = "//span[contains(text(),'Email is required')]";
    public static String ERRORPASSWORDBLANK = "//span[contains(text(),'Password is required')]";
    public static String FORGOTPASSWORD = "//a[contains(text(),'Forgot password?')]";

    public static String SIGNUPLINK = "//span[contains(text(),'Sign Up')]";
    public static String enterPasswordInp = "//input[@placeholder='Enter Password']";
    public static String confirmPasswordInp = "//input[@placeholder='Confirm Password']";

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
    public static String PRODUCTMENU = "//span[text() ='Product']";
    public static String SRNO = "//span[text() ='#']";
    public static String PRODUCTNAMES = "//span[text() ='Product Name']";
    public static String CATEGORY = "//span[text() ='Category']";
    public static String DESCRIPTION = "//span[text() ='Description']";
    public static String KBARTICLE = "//span[text() ='KB Article']";
    public static String CREATEDDATE = "//span[text() ='Created Date']";
    public static String ACTIONS = "//span[text() ='Actions']";
    public static String SEARCH = "//input[@placeholder='Search...']";
    public static String REFRESH = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-15wqzvf'] | //span[contains(@class,'css-1sh91j5')]/parent::button[contains(@class,'css-q8p1uw')]";
    public static String FILTERS = "//button[@type='button']//span[normalize-space(.)='Filters']";
    public static String CREATE = "//button[@type='button']//span[normalize-space(.)='Create']";
    public static String MULTITABHOR = "(//button[@role='tab'])[2]";
    public static String MULTITABVER = "(//button[@role='tab'])[1]";
    public static String TOTAL = "//div[contains(text(),'Total')]";
    public static String ROWSPERPAGE = "//p[text()='Rows per page:']";
    public static String SEARCHRESULTS = "//div[@aria-rowspan='1']/preceding-sibling::div[@aria-colindex='2' and contains(text(),'+ randomValue +')]";
    public static String PHSEACRH = "//input[@placeholder='Search...']";
    public static String PHFILTERSEACRH = "//input[@placeholder='Select column']";
    public static String PHFILTERVAL = "//input[@placeholder='Enter value']";
    public static String FILTERDROPDOWNVAL = "//li[@data-option-index='0']";
    public static String PHFILTEROPERATOR = "//input[@placeholder='Select operator']";
    public static String CLOSEFILTER = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-xz9haa']";
    public static String PHPRODUCTNAME = "//input[@placeholder='Enter Product Name']";
    public static String PHPRODUCTCATEGORY = "//input[@placeholder='Create or Select Category']";
    public static String PHPRODUCTCATEGORYNEW = "//li[starts-with(normalize-space(), 'Create')]";
    public static String PHPRODUCTDESCRIPTION = "//input[@placeholder='Enter Description']";
    public static String PHPRODUCTKB = "//input[@placeholder='Select KB Article']";
    public static String CLOSEBUTTON = "//button[@aria-label='Close alert']";
    public static String SAVEBUTTON = "//button[@type='button']/child::span[contains(text(),'Save')]";
    public static String SUCCESSMESSAGE = "//div[normalize-space(text())='Product created successfully']";
    public static String UPDATEMESSAGE = "//div[normalize-space(text())='Product updated successfully']";
    public static String SEARCHRESULT = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]";
    public static String EDIT = "//button[@aria-label=\"Edit\"]";
    public static String EDITPRODUCTNAME = "//input[@name='name']";
    public static String DELETEPRODUCT = "(//button[@aria-label=\"Delete\"])[1]";
    public static String DELETECONFIRMPRODUCT = "//button[@type='button']/child::span[contains(text(),'Delete')]";
    public static String DELETEPRODUCTASSERT = "//div[contains(text(),\"Deleted Successfully\")]";
    public static String VIEWBUTTON = "//button[@aria-label=\"View\"]";
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
    public static String FILTERNAMERESULT = "//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"]";
    public static String FILTERCATEGORYRESULT = "//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"]";
    public static String CLEARFILTER = "(//button[@title='Clear'])[1]";
    public static String PAGINATIONSR = "//div[@data-field=\"srNo\" and contains(text(),'32')]";
    public static String PAGINATIONROWS = "//div[@aria-haspopup=\"listbox\"]";

    //AGENT CONFIGURATION
    public static String AGENTCONFIGURATIONMENU = "//span[text() ='Agent Configuration']";
    public static String ACHEADER = "//h6[normalize-space()='Agent Configuration']";
    public static String ACSEARCHBAR = "//input[@placeholder=\"Search...\"]";
    public static String ACSELECTALL = "//input[@type=\"checkbox\" and @xpath=\"1\"]";
    public static String ACSRNUMBER = "//span[normalize-space()='#']";
    public static String ACNAME = "//span[normalize-space()='Name']";
    public static String ACGREETINGS = "//span[normalize-space()='Greeting Message']";
    public static String ACPERSONALITY = "//span[normalize-space()='Personality']";
    public static String ACPERSONA = "//span[normalize-space()='Persona']";
    public static String ACPROMPT = "//span[normalize-space()='Prompt']";
    public static String ACSTATUS = "//span[normalize-space()='Status']";
    public static String ACACTIONS = "//span[normalize-space()='Actions']";
    public static String ACTOTALROWS = "//div[contains(text(),'Total')]";
    public static String ACROWSPERPAGE = "//p[contains(text(),'Rows per page:')]";
    public static String ACROWSPERPAGEDROPDOWN = "//input[@class='MuiSelect-nativeInput css-147e5lo']";
    public static String ACPREVIOUSPAGE = "//button[@title='Go to previous page']";
    public static String ACNEXTPAGE = "//button[@title='Go to next page']";
    public static String ACNAMEINDEX = "//div[@aria-rowspan='1']/preceding-sibling::div[@aria-colindex='3']";
    public static String ACINACTIVEGRIDSTATUS = "(//span[text()='Inactive'])[1]";
    public static String ACACTIVEGRIDSTATUS = "//span[@class=\"MuiChip-label MuiChip-labelSmall css-oruufx\" and contains(text(),'Active')][1] | (//span[contains(text(),'Status')]/following::span[text()='Active'])[1]";
    public static String ACINACTIVEGRIDSTATUSGRID = "(//span[text()='Inactive'])[1]/preceding::input[@type='checkbox'][1]";
    public static String ACACTIVTEBUTTON = "//button[@type='button']/child::span[contains(text(),'Active')]";
    public static String ACCHEADER = "//h6[normalize-space()='Create Agent Configuration']";
    public static String ACCPERSONA = "//p[normalize-space()='Persona']";
    public static String ACCSELECTPERSONA = "//input[@placeholder=\"Select Persona\"]";
    public static String ACCPROMPT = "//p[text()='Prompt']";
    public static String ACCPERSONALITY1 = "//p[contains(text(),'personality')]";
    public static String ACCTEXTAREAPROMPT = "//textarea[@placeholder='Enter your agent prompt here... Use {{variable_name}} to insert dynamic values']";
    public static String ACCRULES = "//p[text()='Rules']";
    public static String ACCRULESDROPDOWN = "//input[@placeholder=\"Enter a new rule...\"]";
    public static String ACCCUSTOMVARIABLE = "//p[text()='Custom Variables']";
    public static String ACCADDVARIABLE = "//button[@type='button' and .//span[text()='Add Variable']]";
    public static String ACCAGENT = "//p[text()='Agent Info']";
    public static String ACCNAME = "//span[text()='Name']";
    public static String ACCNAMEINPUT = "//input[@placeholder=\"Enter Name\"]";
    public static String ACCNAME2 = "//span[text() ='{{name}}']";
    public static String ACCCOMPANYNAME = "//span[text() ='Company name']";
    public static String ACCCOMPANYNAME2 = "//span[text() ='{{company_name}}']";
    public static String ACCCOMPANYNAMEINPUT = "//input[@placeholder=\"Enter Company Name\"]";
    public static String ACCGREETINGS = "//span[text() ='Greeting Message']";
    public static String ACCGREETINGINPUT = "//textarea[@name=\"greeting_message\"]";
    public static String ACCTIMEZONE = "//span[text()='Timezone']";
    public static String ACCTIMEZONEINPUT = "//input[@placeholder=\"Select Timezone\"]";
    public static String ACCPERSONALITY = "//p[text()='Personality & Goal']";
    public static String ACCPERSONALITY2 = "//span[text()='Personality']";
    public static String ACCPERSONALITYINPUT = "//input[@name='personality']";
    public static String ACCGOAL = "//span[text()='Goal type']";
    public static String ACCGOAL1 = "//span[text()='{{goal_type}}']";
    public static String ACCGOALINPUT = "//input[@name=\"goal_type\"]";
    public static String ACCLANG = "//span[text()='Language']";
    public static String ACCLANGINPUT = "//input[@placeholder=\"Select Language\"]";
    public static String ACCALLOWEMOJI = "//p[text()='Allow Emojis']";
    public static String ACCRADIOYES1 = "(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-k08jj6\"])[1]";
    public static String ACCRADIOYES2 = "(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-k08jj6\"])[3]";
    public static String ACCRADIONO1 = "(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-k08jj6\"])[2]";
    public static String ACCRADIONO2 = "(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-k08jj6\"])[4]";
    public static String ACCBUSINESSDETAILS = "//p[text()='Business Details']";
    public static String ACCCOREUSP = "//span[text()='Core USP']";
    public static String ACCCOREUSP1 = "//span[text()='{{core_usps}}']";
    public static String ACCCOREUSPINPUT = "//input[@placeholder=\"Your unique selling proposition\"]";
    public static String ACCCOREFEATURES = "//span[text()='Core Features']";
    public static String ACCCOREFEATURES1 = "//span[text()='{{core_features}}']";
    public static String ACCCOREFEATURESINPUT = "//input[@name=\"core_features\"]";
    public static String ACCCONTACTINFO = "//span[text()='Contact Info']";
    public static String ACCCONTACTINFOINPUT = "//input[@name=\"contact_info\"]";
    public static String ACCCONTACTINFO2 = "//span[text()='{{contact_info}}']";
    public static String ACCCOMPANYDOMAIN = "//span[text()='Company Domain']";
    public static String ACCCOMPANYDOMAININPUT = "//input[@name=\"company_domain\"]";
    public static String ACCBUSINESSFOCUS = "//span[text()='Business focus']";
    public static String ACCBUSINESSFOCUS2 = "//span[text()='{{business_focus}}']";
    public static String ACCBUSINESSFOCUINPUT = "//input[@name='business_focus']";
    public static String ACCOFFER = "//span[text()='Offer description']";
    public static String ACCOFFER1 = "//span[text()='{{offer_description}}']";
    public static String ACCOFFERINPUT = "//textarea[@name='offer_description']";
    public static String ACCCOMPANY = "//span[text()='Company description']";
    public static String ACCCOMPANYINPUT = "//textarea[@name=\"company_description\"]";
    public static String ACCCANCELBUTTON = "//button[@type='button' and .//span[normalize-space()='Cancel']]";
    public static String ACCSAVEBUTTON = "//button[@type='button' and .//span[normalize-space()='Save']]";
    public static String ACCBACKBUTTON = "//button[@type='button']/following::h6[text()='Create Agent Configuration']";
    public static String ACCVALPERSONA = "//span[text()='Persona is required']";
    public static String ACCVALPROMPT = "//p[text()='Prompt is required']";
    public static String ACCVALNAME = "//span[text()='Name is required']";
    public static String ACCVALCOMAPNYNAME = "//span[text()='Company Name is required']";
    public static String ACCVALREETINGS = "//span[text()='Greeting Message is required']";
    public static String ACCVALPERSONLITY = "//span[text()='Personality is required']";
    public static String ACCVALGOAL = "//span[text()='Goal type is required']";
    public static String ACCVALLANG = "//span[text()='Language is required']";
    public static String ACCVALCOREUSP = "//span[text()='Core USPs is required']";
    public static String ACCVALCOREFEATURE = "//span[text()='Core Features is required']";
    public static String ACCVALCONTACT = "//span[text()='Contact Info is required']";
    public static String ACCVALBUSINES = "//span[text()='Business focus is required']";
    public static String ACCVALOFFER = "//span[text()='Offer description is required']";
    public static String COMPANYDESC = "//span[text()='Company description is required']";
    public static String CUSTOMERSUPPORT = "//li[text()='CUSTOMER SUPPORT']";
    public static String HR = "//li[text()='HR']";
    public static String SALES = "//li[text()='SALES']";
    public static String ACSEARCHRESULT = "(//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"])[1]";
    public static String ACEDITBUTTON = "(//button[@aria-label=\"Edit\"])[1]";
    public static String ACRESETBUTTON = "//button[@type='button']/following::span[text()='Reset']";
    public static String ACDELETEBUTTON = "(//button[@aria-label=\"Delete\"])[1]";
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
    public static String ACPLAYGROUNDSELECTAGENT = "//input[@placeholder=\"Select agent\"]";
//    public static String ACSEARCHRESULT = "(//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"])[1]";
//    public static String ACEDITBUTTON = "(//button[@aria-label=\"Edit\"])[1]";
//    public static String ACDELETEBUTTON = "(//button[@aria-label=\"Delete\"])[1]";
//    public static String ACDELETECANCELBUTTON = "//button[@type=\"button\"]/following::span[text()='Cancel']";
//    public static String ACACTIVATEBUTTON = "//button[@type=\"button\"]/following::span[text()='Activate']";
//    public static String ACINNERDELETE = "//button[@type=\"button\"]/following::span[text()='Delete']";
//    public static String ACINACTIVE = "//span[text()='Inactive']";
//    public static String ACACTIVE = "//span[text()='Active']";
//    public static String ACINACTIVECB = "(//input[@type='checkbox'])[2]";
//    public static String ACACTIVEINACTIVE = "//button[@type='button']//span[normalize-space()='Active']";
//    public static String ACFILTERNAME = "//li[contains(text(),'Name')]";
//
//    public static String createdSuccessfully = "//div[contains(text(), 'Created successfully')]";
//    public static String DeletedSuccessfully = "//div[contains(text(), 'Deleted Successfully')]";
//    public static String UpdatedSuccessfully = "//div[contains(text(), 'Updated successfully')]";
//public static String createdSuccessfully = "//div[contains(text(), 'Created successfully')]";

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
    public static String nameHeader = "//div[@role='presentation']//span[text()='Name']";
    public static String phoneNumHeader = "//div[@role='presentation']//span[text()='Phone Number']";
    public static String DOBHeader = "//div[@role='presentation']//span[text()='Date of Birth']";
    public static String emailHeader = "//div[@role='presentation']//span[text()='Email']";
    public static String companyHeader = "//div[@role='presentation']//span[text()='Company ']";
    public static String contactGroupHeader = "//div[@role='presentation']//span[text()='Contact Group']";
    public static String createdDateHeader = "//div[@role='presentation']//span[text()='Created Date']";
    public static String emailSubscriptionHeader = "//div[@role='presentation']//span[text()='Email Subscription']";
    public static String actionsHeader = "//div[@role='presentation']//span[text()='Actions']";
    public static String actionHeader = "//div[@role='presentation']//span[text()='Action']";

    //Buttons
    public static String saveButton = "//span[contains(text(),'Save')]";
    public static String cancelButton = "//span[contains(text(),'Cancel')]";

    //Inputs Fields
    public static String Contact= "//span[contains(text(),'Contact')]";
    public static String WhatsAppContact= "//button[contains(text(),'Whatsapp Contact')]";
    public static String nameInp = "//input[@name='name']";
    public static String EmailInp= "//input[@name='email']";
    public static String dateOfBirthInp = "//input[@placeholder='Enter Date Of Birth']";
    public static String contactGroup = "//input[@placeholder='Create or Select Contact Group']";
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
    public static String nameFieldMsg = "//span[text()='Name is required']";
    public static String contactGroupMsg = "//span[text()='Please select a contact group']";
    public static String phoneNumberMsg = "//div[text()='Phone number is required']";
    public static String companyNameMsg = "//span[text()='Company Name is required']";
    //Import page locators
    public static String bulkUploadHeader= "//h6[text()='Bulk Upload Whatsapp Contacts']";
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
    public static String buttonMenuListView = "(//h6)[2]/following::button";

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
    public static String LEADPBack ="//div[@class='MuiGrid-root MuiGrid-direction-xs-row MuiGrid-grid-xs-12 MuiGrid-grid-sm-10 MuiGrid-grid-md-6 css-53mvl9']//button[@type='button']";
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
    public static String Header_WHATSCONT = "//span[text()='Whatsapp Contact']";
    public static String Header_Product = "//div[@role='presentation']//span[normalize-space()='Product']";
    public static String Header_PreferredDT = "//span[text()='Preferred Date / Time']";
    public static String Header_CREATEDAT= "//span[text()='Created At']";
    public static String Header_Actions= "//span[text()='Actions']";
    //Lead view
    public static String VType = "//label[.//span[text()='Type']]/following::input[1]";
    public static String VContactType = "//label[.//span[text()='Contact Type']]/following::input[1]";
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
    public static String KBSRNUMBER = "//span[normalize-space()='#']";
    public static String KBNAME = "//span[normalize-space()='Name']";
    public static String KBPRODUCTS = "//span[normalize-space()='Products']";
    public static String KBSTATUS = "//span[normalize-space()='Status']";
    public static String KBCREATEDDATE = "//span[normalize-space()='Created Date']";
    public static String KBACTIONS = "//span[normalize-space()='Actions']";
    public static String KBTOTALROWS = "//div[contains(text(),'Total')]";
    public static String KBROWSPERPAGE = "//p[contains(text(),'Rows per page:')]";
    public static String KBREFRESHBUTTON = "//button[contains(@class,'css-q8p1uw')]";
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
    public static String KBCFILESUPLOADINPUT = "//div[@class=\"flex flex-col items-center gap-4\"]";
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
    public static String KBCWEBADDEDDELETE = "//th[text()='Title']/following::button";
    //KB Q&A
    public static String KBCQAHEADER = "//h6[text()='Add Q&A']";
    public static String KBCQATITLE = "(//span[text()='Title'])[2]";
    public static String KBCQATITLEINPUT = "(//input[@placeholder=\"Ex: Lorem ipsum\"])[2]";
    public static String KBCQATITLEQ1 = "//span[text()='Question 1']";
    public static String KBCQATITLEQ1INPUT = "(//input[@placeholder=\"Ex: How do I request a refund?\"])[1]";
    public static String KBCADDBUTTON = "//button[@type='button']/following::span[text()='Add Question']";
    public static String KBCANSWER = "//p[text()='Answer']";
    public static String KBCANSWERINPUT = "(//div[@class=\"ql-editor ql-blank\"])[2]";
    public static String KBCQAADDBUTTON = "//button[@type='button']//span[text()='Add Q&A']";
    //KB Mandatory Fields
    public static String KBCNAMEVALIDATION = "//span[text()='Name is required']";

    //WhatsApp Template
    public static String TEMPLATEMENU = "//span[text()='Templates']";
    public static String WHATSAPPTEMPLATEMENU = "//button[text()='Whatsapp Template']";
    public static String WTHEADER = "//h6[text()='Whatsapp Template']";
    public static String WTSEARCH = "//input[@placeholder=\"Search...\"]";
    public static String WTREFRESH = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-15wqzvf\"]";
    public static String WTFILTERS = "//button[@type='button']/following::span[contains(text(),'Filters')]";
    public static String WTCREATE = "//button[@type='button']/following::span[text()='Create']";
    public static String WTNAME = "//span[text()=\"Name\"]";
    public static String WTLANGUAGE = "//span[text()=\"Language\"]";
    public static String WTHEADERTEXT = "//span[text()=\"Header Text\"]";
    public static String WTCATEGORY = "//span[text()=\"Category\"]";
    public static String WTTEMPLATEMETASTATUS = "//span[text()=\"Template Meta Status\"]";
    public static String WTQUALITYSCORE = "//span[text()=\"Quality Score\"]";
    public static String WTACTIONS = "//span[text()=\"Actions\"]";
    //WhatsApp
    public static String WTCHEADER = "//h6[text()='Create Whatsapp Template']";
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
    public static String WTCFILEINPUT = "//input[@placeholder=\"No file selected\"]";
    public static String WTCFILEINPUT2 = "//button[@type=\"button\"]/span[text()='Upload']";
    public static String WTCBODY = "//p[text()='Body']";
    public static String WTCADDVARIABLES = "//span[@class=\"MuiChip-label MuiChip-labelMedium css-14vsv3w\"]";
    public static String WTCBODYINPUT = "//div[starts-with(@class,'ql-editor')]";
    public static String WTCFOOTER = "//p[text()='Footer (Optional)']";
    public static String WTCFOOTERINPUT = "//input[@placeholder=\"Enter Footer Text\"]";
    public static String WTCBUTTONS = "//p[text()='Buttons']";
    public static String WTCBUTTONTYPE = "//span[text()='Button Type']";
    public static String WTCSELECTTYPE = "//input[@placeholder=\"Select Type\"]";
    public static String WTCBUTTONTEXT = "//span[text()='Button Text']";
    public static String WTCBUTTONTEXTINPUT = "//input[@placeholder=\"Enter button text\"]";
    public static String WTCADDBUTTON = "//button[@type='button']/following::span[text()='+ Add Button']";
    public static String WTCTEMPLATEPREVIEW = "//p[text()='See how your template will appear']";
    public static String WTCMESSAGEICON = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ba1cez\"]";
    public static String WTCTEMPLATEPREVIEW2 = "//p[text()='Start filling the form to see your template preview']";
    public static String WTCTEMPLATEPREVIEW3 = "//p[contains(normalize-space(),'Live Preview')]";
    public static String WTCNAMEMANDATORY = "//span[text()='Name is required']";
    public static String WTCCATEGORYMANDATORY = "//span[text()='Category is required']";
    public static String WTCLANGUAGEMANDATORY = "//span[text()='Language is required']";
    public static String WTCHEADERTYPEMANDATORY = "//span[text()='Header Type is required']";
    public static String WTCBODYOFTEMPMANDATORY = "//span[text()='Body Of Template is required']";
    public static String WTCENTERURL = "//input[@name=\"button_url\"]";
    public static String WTCENTERPHONE = "//input[@placeholder=\"Enter mobile number\"]";
    public static String WTSEARCHRESULT = "(//div[@aria-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
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
    public static String ETHEADER = "//h6[text()='Email Template']";
    public static String ETSEARCH = "//input[@placeholder=\"Search...\"]";
    public static String ETSR = "//span[normalize-space()='#']";
    public static String ETNAME = "//span[text()=\"Name\"]";
    public static String ETSUBJECT = "//span[text()=\"Subject\"]";
    public static String ETSERVERSYNCED = "//span[text()=\"Server Synced\"]";
    public static String ETCREATEDDATE = "//span[text()=\"Created Date\"]";
    public static String ETACTIONS = "//span[text()=\"Actions\"]";
    public static String ETREFRESH = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-15wqzvf\"]";
    public static String ETFILTERS = "//button[@type='button']/following::span[contains(text(),'Filters')]";
    public static String ETCREATE = "//button[@type='button']/following::span[text()='Create']";
    public static String ETVIEW = "(//button[@aria-label=\"View\"])[1]";
    public static String ETSEARCHRESULTS = "(//div[@aria-colindex=\"3\" and @aria-rowspan=\"1\"])";
    public static String ETASTATUS = "//div[@aria-colindex=\"4\" and @aria-rowspan=\"1\"]//span";

    //Email Template Create
    public static String ETCREATEHEADER = "//h6[text()='Create Email Template']";
    public static String ETCTD = "//p[text()='Template Details']";
    public static String ETCTNAME = "//span[text()='Template Name']";
    public static String ETCTNAMEINPUT = "//input[@placeholder=\"Enter Template Name\"]";
    public static String ETCCBTEXT = "//p[text()='Can be send from whatsapp']";
    public static String ETCCBINPUT = "//input[@type=\"checkbox\"]";
    public static String ETCUPLOAD = "//h6[text()='Upload Attachments']";
    public static String ETCUPLOADINPUT = "//p[contains(text(),'Select your file or drag and drop')]";
    public static String ETCSAVE = "//button[@type='button']/following::span[text()='Save']";
    public static String ETCCANCEL = "//button[@type='button']/following::span[text()='Cancel']";
    public static String ETCTNVALIDATION = "//span[text()='Template name is required']";
    public static String ETCSUBJECTVALIDATION = "//span[text()='Subject is required']";
    public static String ETCBODYVALIDATION = "//p[text()='Body is required']";
    public static String ETCUPLOADEDFILE = "//div[@class=\"mt-4 grid grid-cols-2 sm:grid-cols-3 gap-3\"]/child::div";
    public static String ETCEMAILBODY = "//p[text()='Email Body']";
    public static String ETCVAREMAIL = "//span[text()='{{email}}']";
    public static String ETCVARPHONE = "//span[text()='{{phone_number}}']";
    public static String ETCVARNAME = "//span[text()='{{name}}']";
    public static String ETCVARCNAME = "//span[text()='{{company_name}}']";
    public static String ETCVARNEW = "//span[text()='{{%%%%%}}']";
    public static String ETCVARINFO = "//p[text()='Click any variable to insert it in the subject or body.']";
    public static String ETCSUBJECT = "//span[text()='Subject']";
    public static String ETCSUBJECTINPUT = "//input[@placeholder=\"Enter Subject\"]";
    public static String ETCBODYTEXT = "//p[contains(text(),'Use variables from the top right panel to personalize your email.')]";
    public static String ETCBODYTOOL = "//div[@role='toolbar']";
    public static String ETCBODYINPUT = "//div[@data-placeholder=\"Start writing your email content...\"]";
    public static String ETCLIVEPREVIEW = "//p[text()='Live Preview']";
    public static String ETCLPSUB = "//b[text()='Subject:']";
    public static String ETCLPINFO = "//p[contains(text(),'You are receiving this communication from')]";
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
    public static String nextBtn = "//span[contains(text(),'Next')]/ancestor::button";
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
    public static String startFreeTrialBtnLastPage = "//span[contains(text(),'Start Free Plan')]/ancestor::button";
    public static String congratulationMessage = "//h6[contains(text(),'Congratulations!')]";

    public static String closeIconOnCongratulation = "//div[contains(@class,'relative flex flex-col items-center justify-center')]//button";
    public static String getPlanDetail = "(//h4[contains(text(),'')])[2]";

    //Profile page xpath
    public static String profileIcon = "(//div[contains(@class,'flex items-center gap-1 sm')]//button)[3]";
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

    //Input field Xpaths
    public static String firstNameInpProfile = "(//div[@class='flex-1 min-w-0']//p)[1]";
    public static String lastNameInpProfile = "//input[@name=\"last_name\"]";
    public static String emailInpProfile = "//input[@name=\"email\"]";
    public static String phoneNumberInpProfile = "//input[@name=\"phone_number\"]";

    public static String currentPasswordLbl = "//span[contains(text(),'Current Password')]";
    public static String newPasswordLbl = "//span[contains(text(),'New Password')]";
    public static String confirmPasswordLbl = "//span[contains(text(),'Confirm Password')]";
    public static String currentPasswordInp = "//input[@placeholder='Enter Current Password']";
    public static String newPasswordInp = "//input[@placeholder='Enter New Password']";
    public static String confirmPasswordInpProfile = "//input[@placeholder='Enter Confirm Password']";
    public static String savePassword = "//span[contains(text(),'Save Password')]/ancestor::button";

    //WhatsAppCampaign locators
    public static String SearchContact = "//input[@placeholder='Search contacts...']";
    //public static String = "";
    public static String HomeMenu = "//span[text()='Home']";
    public static String CampaignMenu = "//span[text()='Campaign']";
    public static String whatsappCampaign = "//button[text()='Whatsapp Campaign']";

    public static String WC_REFRESH = "//button[contains(@class,'MuiButton-root')] ";
    public static String WC_PAGEHEADER ="//h6[normalize-space()='WhatsApp Campaign']";
    public static String WCH_NAME ="//span[normalize-space()='Name']";
    public static String WCH_WhatsAppTem = "//span[contains(text(),'Whatsapp Template Name')]";
    public static String WCH_WhatsAppCategorName = "//span[normalize-space()='Template Category Name']";
    public static String WCH_ProductName = "//span[normalize-space()='Product Name']";
    public static String WCH_ScheduleTime= "//span[normalize-space()='Schedule Time']";
    public static String WCH_Status = "//span[text()='Status']";
    public static String WCH_Action = "//span[text()='Actions']";
    //Create WhatsApp Campaign
    public static String CWC_Back = "//div[@class='MuiGrid-root MuiGrid-direction-xs-row MuiGrid-grid-xs-12 MuiGrid-grid-sm-10 MuiGrid-grid-md-6 css-53mvl9']//button[@type='button']";
    public static String CWC_Cancel = "//span[normalize-space()='Cancel']";
    public static String CWC_View = "//span[text()='View']";

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
    public static String ECCONTACT = "//span[text()=\"Contact\"]";
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
    public static String ECCSEARCHCONTACTSVALUE = "(//div[@data-colindex=\"2\" and @aria-rowspan=\"1\"])[1]";
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
    public static String ECCRUNCAMPAIGN= "//button[@type='button']/following::span[text()='Run Campaign']";
    public static String ECCCANCEL= "//button[@type='button']/following::span[text()='Cancel']";
    public static String ECCPOPUPTEXT1= "//h2[text()='Run Campaign']";
    public static String ECCPOPUPTEXT2= "//p[text()='Are you sure you want to run this email campaign? This action will start sending emails to your selected contacts.']";
    public static String ECCPOPUPNO= "//button[@type='button']/following::span[text()='No']";
    public static String ECCPOPUPYES= "//button[@type='button']/following::span[text()='Yes']";
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
    public static String enterRoleName = "//input[@placeholder='Enter Role Name']";
    public static String roleDropdown = "//input[@placeholder='Select Role']";
    public static String firstNameError = "//span[text()='First Name is required']";
    public static String lastNameError = "//span[text()='Last Name is required']";
    public static String phoneError     = "//div[text()='Phone number is required']";
    public static String emailError     = "//span[text()='Email is required']";
    public static String roleError      = "//span[text()='Role is required']";
    public static String RoleNameError      = "//span[text()='Role Name is required']";

    //grid page headers
    public static String firstNameHeader = "//div[@role='presentation']//span[text()='First Name']";
    public static String LastNameHeader = "//div[@role='presentation']//span[text()='Last Name']";
    public static String statusHeader = "//div[@role='presentation']//span[text()='Status']";
    public static String tokenStatusHeader = "//div[@role='presentation']//span[text()='Token Status']";
    public static String userHeader = "//h6[text()='User']";

    public static String rolePermissionHeader = "//h6[contains(text(),'Role Permissions')]";
    public static String roleNameHeader = "//span[contains(text(),'Role Name')]";

    public static String V_Name = "//span[text()='Name']";
    public static String VContactG = "//span[text()='Contact Group']";
    public static String VEmail = "//span[text()='Email']";
    public static String VPhoneNo = "//span[text()='Phone Number']";
    public static String VDandB = "//span[text()='Date of Birth']";

    public static String CWC_RunCamBTN = "//span[text()='Run Campaign']";
    public static String RC_PopupNo="//span[text()='No']";
    public static String RC_PopupYes="//span[text()='Yes']";

    //Field Validations  xpath for whatsappcampagin
    public static String Req_CampaginName="//span[text()='Name is required']";
    public static String Req_WhatsappTemp="//span[text()='WhatsApp template is required']";
    public static String Req_Category="//span[text()='Category is required']";
    public static String Req_Product="//span[text()='Product is required']";


}