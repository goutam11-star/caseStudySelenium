package caseStudySelenium.caseStudySelenium;

public interface assignment1Locators {

	public static String numberOfItemsLoc = "//li[@class='ui-widget-content ui-selectee']";
	
	public static String selectedItemLOc = "//li[@class='ui-widget-content ui-selectee ui-selected']";
	
	public static String firstnameLoc = "//input[@class='firstname']";
	
	public static String lastnameLoc = "//input[@id='lname']";
	
	public static String countryNameLoc = "//input[@name='country']";
	
	public static String subjectTextAreaLoc = "//textarea[@name='subject']";
	
	public static String submitLoc = "//input[@type='submit']";
	
	public static String draggableLoc = "//div[@id='draggable']";
	
	public static String droppableLoc = "//div[@id='droppable']";
	
	public static String highlightedLoc = "//div[@id='droppable']//p";
	
	public static String datePickerLoc = "//input[@id='datepicker']";
	
	public static String prevNavLoc = "//span[text()='Prev']";
	
	public static String yearPickLoc = "//span[@class='ui-datepicker-year']";
	
	public static String monthPickLoc = "//span[@class='ui-datepicker-month']";
	
	public static String datePickLoc = "//table[@class='ui-datepicker-calendar']";
	
	public static String selectMenuLoc = "//span[@id='%s']";
	
	public static String selectMenuListLoc = "//li[@class='ui-menu-item']//div[text()='%s']";
	
	public static String carTypeLoc = "//div[contains(@class,'ui-controlgroup-%s')]//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']";
	
	public static String carTypeDropdownListLoc = "//div[contains(@class,'ui-controlgroup-%s')]//span[@class='ui-selectmenu-text'][text()='%s']";
	
	public static String automaticStatndardOptionLoc = "//div[contains(@class,'ui-controlgroup-%s')]//label[contains(@for,'transmission-standard')]";
	
	public static String insuranceLoc = "//div[contains(@class,'ui-controlgroup-%s')]//label[contains(@for,'insurance')]";
	
	public static String noOfCars = "//div[contains(@class,'ui-controlgroup-%s')]//input[contains(@id,'spinner')]";
	
	public static String bookNowLoc = "//div[contains(@class,'ui-controlgroup-%s')]//button"; 
	
	
	
	
}
