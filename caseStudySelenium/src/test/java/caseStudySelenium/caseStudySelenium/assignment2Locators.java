package caseStudySelenium.caseStudySelenium;

public interface assignment2Locators {
	
	public static String registerLoc = "(//a[@class='event_profile_register'])[%s]";
	
	public static String loginLoc = "//a[@class='event_profile_login']";
	
	public static String emailLoc = "//input[@data-key='emailAddress']";
	
	public static String passwordLoc = "(//input[@type='password'])[%s]";
	
	public static String confirmPasswordLoc = "(//input[@type='password'])[%s]";
	
	public static String firstNameLoc = "//input[@data-key='firstName']";
	
	public static String lastNameLoc = "//input[@data-key='lastName']";
	
	public static String stateLoc = "//input[@data-key='addressStreet1']";
	
	public static String postalLoc = "//input[@data-key='addressPostalCode']";
	
	public static String cityLoc = "//input[@data-key='addressCity']";
	
	public static String phoneLoc = "//input[@data-key='phone']";
	
	public static String countryLoc = "//select[@data-key='addressCountry']";
	
	public static String dateLoc = "//select[@data-key='birthdate[dateselect_day]']";
	
	public static String monthLoc = "//select[@data-key='birthdate[dateselect_month]']";
	
	public static String yearLoc = "//select[@data-key='birthdate[dateselect_year]']";
	
	public static String dateListLoc = "//select[@data-key='birthdate[dateselect_day]']//option[@value='%s']";
	
	public static String monthListLoc = "//select[@data-key='birthdate[dateselect_month]']//option[@value='%s']";
	
	public static String yearListLoc = "//select[@data-key='birthdate[dateselect_year]']//option[@value='%s']";
	
	public static String countryDropdownLoc = "//select[@data-key='addressCountry']//option[@value='%s']";
	
	public static String registerLoginButtonLoc = "//input[@type='submit']";
	
	public static String genderLoc = "//img[contains(@id,'img%s')]";
	
	public static String alreadyExistAccountLoc = "//span[@class='pc_error-message pc_error-message2']";
	
	public static String skipStepLoc = "//a[@title='Skip This Step']";
	
	public static String yourProfileLoc = "//h1[contains(@id,'phdesktopbody')]";
	
	public static String loginEmailLoc = "//input[@data-key='signInEmailAddress']";
	
	public static String loginPasswordLoc = "//input[@data-key='currentPassword']";
	
	public static String forgetPasswordLoc = "//a[@class='forgotpwd']";
	
	public static String resetLinkMessageLoc = "//div[@class='pc_left-panel']";
	
	
	
	
	
	
	

}
