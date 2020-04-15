package caseStudySelenium.caseStudySelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class additionalSteps implements assignment1Locators, assignment2Locators, assignment3Locators {

	public static Properties prop;

	public static WebDriver driver;
	File file = null;
	FileInputStream inputStream = null;
	HSSFWorkbook gtmworkbookxls = null;
	XSSFWorkbook gtmworkbookxlsx = null;
	HSSFSheet gtmSheetxls = null;
	XSSFSheet gtmSheetxlsx = null;
	String fileExtension = "";

	public static void initBrowser(String Browservalue, String ChromeDriverPath, String FirefoxDriverPath) {

		if (("firefox").equalsIgnoreCase(Browservalue)) {
			System.setProperty("webdriver.gecko.driver", ChromeDriverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (("chrome").equalsIgnoreCase(Browservalue)) {
			System.setProperty("webdriver.chrome.driver", FirefoxDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public static void initProperty(String path) {

		prop = new Properties();

		try {
			prop.load(new FileInputStream(path));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}
	}

	public void javaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	public String readexcellfile(String filePath, String fileName, String sheetName, int rowNum, int colNum)
			throws Exception {

		file = new File(filePath);

		inputStream = new FileInputStream(file);

		fileExtension = fileName.substring(fileName.indexOf("."));

		String value = null;

		if (fileExtension.equals(".xls")) {

			gtmworkbookxls = new HSSFWorkbook(inputStream);
			gtmSheetxls = gtmworkbookxls.getSheet(sheetName);
			String valu0 = gtmSheetxls.getRow(rowNum).getCell(colNum).getStringCellValue();
			value = valu0;
		} else if (fileExtension.equals(".xlsx")) {
			gtmworkbookxlsx = new XSSFWorkbook(inputStream);
			gtmSheetxlsx = gtmworkbookxlsx.getSheet(sheetName);
			String valu0 = gtmSheetxlsx.getRow(rowNum).getCell(colNum).getStringCellValue();
			value = valu0;
		}
		return value;

	}

	public int getRowCount(String filePath, String fileName, String sheetName) {
		file = new File(filePath);

		int rowCount = 0;

		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		fileExtension = fileName.substring(fileName.indexOf("."));

		if (fileExtension.equals(".xls")) {

			try {
				gtmworkbookxls = new HSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gtmSheetxls = gtmworkbookxls.getSheet(sheetName);
			int index = gtmworkbookxls.getSheetIndex(sheetName);
			if (index == -1)
				rowCount = 0;
			else {
				gtmSheetxls = gtmworkbookxls.getSheetAt(index);
				int number = gtmSheetxls.getLastRowNum() + 1;
				rowCount = number;
			}

		} else if (fileExtension.equals(".xlsx")) {

			try {
				gtmworkbookxlsx = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gtmSheetxlsx = gtmworkbookxlsx.getSheet(sheetName);
			int index = gtmworkbookxlsx.getSheetIndex(sheetName);
			if (index == -1)
				rowCount = 0;
			else {
				gtmSheetxlsx = gtmworkbookxlsx.getSheetAt(index);
				int number = gtmSheetxlsx.getLastRowNum() + 1;
				rowCount = number;
			}

		}
		return rowCount;
	}

	public void rect(String monthYear) {

		String month1 = driver.findElement(By.xpath(String.format(MonthYearLoc, "1"))).getText();
		String month2 = driver.findElement(By.xpath(String.format(MonthYearLoc, "2"))).getText();
		

		for (int i = 0; i < 1; i++) {
			if ((month1.equalsIgnoreCase(monthYear)) || (month2.equalsIgnoreCase(monthYear))) {
				break;
			} else {
				driver.findElement(By.xpath(navMonthsButtonLoc)).click();
				rect(monthYear);
			}
		}

		

	}

	public String shortToFullWord(String month) {

		String fullMonthWord = "";

		switch (month) {

		case "Jan":
			fullMonthWord = "January";
			break;

		case "Feb":
			fullMonthWord = "February";
			break;

		case "Mar":
			fullMonthWord = "March";
			break;

		case "Apr":
			fullMonthWord = "April";
			break;

		case "May":
			fullMonthWord = "May";
			break;

		case "Jun":
			fullMonthWord = "June";
			break;

		case "Jul":
			fullMonthWord = "July";
			break;

		case "Aug":
			fullMonthWord = "August";
			break;

		case "Sep":
			fullMonthWord = "September";
			break;

		case "Oct":
			fullMonthWord = "October";
			break;

		case "Nov":
			fullMonthWord = "November";
			break;

		case "Dec":
			fullMonthWord = "December";
			break;

		}
		return fullMonthWord;
	}
	
	public void waitforCertainSeconds(int milliSeconds) {
		
		
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
