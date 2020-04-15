package caseStudySelenium.caseStudySelenium;

public interface assignment3Locators {

	public static String oneWayTripLoc = "//li[@data-cy='oneWayTrip']";

	public static String roundTripLoc = "//li[@data-cy='roundTrip']";

	public static String fromCityLoc = "//input[@data-cy='fromCity']";
	
	public static String toCityLoc = "//input[@data-cy='toCity']";

	public static String typeaheadSuggestionsLoc = "(//li[contains(@class,'react-autosuggest__suggestion--first')])[%s]";

	public static String fromTextLoc = "//input[@placeholder='From']";

	public static String toTextLoc = "//input[@placeholder='To']";
	
	public static String MonthYearLoc = "(//div[@class='DayPicker-Caption']//div)[%s]"; 
	
	public static String datePickupFromCalender = "//div[contains(@aria-label,'%s')]";
	
	public static String navMonthsButtonLoc = "//span[@aria-label='Next Month']";
	
	public static String searchButtonLoc = "//a[contains(@class,'Search')]";

	public static String lowestfareLoc = "(//button[contains(@class,'ViewFareBtn')])[%s]";

	public static String lowestBookLoc = "(//button[contains(@class,'btn fli')])[%s]";

	public static String reviewPageToPlaceLocator = "//p[@class='arrival-city']//span[@class='LatoBold']";
	
	public static String reviewPagefromPlaceLocator = "//p[@class='dept-city']//span[@class='LatoBold']";
	
	
	

}
