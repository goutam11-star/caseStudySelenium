package caseStudySelenium.caseStudySelenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class assignment3 extends additionalSteps implements assignment3Locators {

	@BeforeClass
	@Parameters({ "browser", "ChromeDriverPath", "FirefoxDriverPath", "failedScreenshotForAssignment","property3Path" })
	public static void openBrowser(String browser, String ChromeDriverPath, String FirefoxDriverPath,
			String failedScreenshotForAssignment,String property3Path) {

		initBrowser(browser, ChromeDriverPath, FirefoxDriverPath);
		
		initProperty(property3Path);

		File file = new File(failedScreenshotForAssignment + "/Assignment3");

		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Parameters({ "url5" })
	public void makeMyTrip(String url5) {

		driver.get(url5);

		driver.findElement(By.xpath(roundTripLoc)).click();

		driver.findElement(By.xpath(oneWayTripLoc)).click();

		driver.findElement(By.xpath(fromCityLoc)).click();

		driver.findElement(By.xpath(fromTextLoc)).sendKeys(prop.getProperty("from"));

		driver.findElement(By.xpath(String.format(typeaheadSuggestionsLoc, "1"))).click();

		driver.findElement(By.xpath(toTextLoc)).sendKeys(prop.getProperty("To"));

		driver.findElement(By.xpath(String.format(typeaheadSuggestionsLoc, "1"))).click();
		
		String DOD = (prop.getProperty("DOD"));

		String[] splitt = DOD.split(" ");

		String Month = splitt[0];

		String Year = splitt[2];

		String fullMonthWord = shortToFullWord(Month);

		String monthYear = fullMonthWord + " " + Year;
		
		rect(monthYear);
		
		driver.findElement(By.xpath(String.format(datePickupFromCalender, DOD))).click();
		
		driver.findElement(By.xpath(searchButtonLoc)).click();
		
		waitforCertainSeconds(4000);
		
		driver.findElement(By.xpath(String.format(lowestfareLoc, "1"))).click();
		
		driver.findElement(By.xpath(String.format(lowestBookLoc, "1"))).click();
		
		Set<String> winHandles = driver.getWindowHandles();

		for (String wh : winHandles) {
			driver.switchTo().window(wh);

		}
		
		waitforCertainSeconds(4000);
		
		assertTrue(prop.getProperty("from").equalsIgnoreCase(driver.findElement(By.xpath(reviewPagefromPlaceLocator)).getText()));
		
		assertTrue(prop.getProperty("To").equalsIgnoreCase(driver.findElement(By.xpath(reviewPageToPlaceLocator)).getText()));

	}

	@AfterMethod
	@Parameters({ "failedScreenshotForAssignment" })
	public static void getScreenshotForFailedTestCase(String failedScreenshotForAssignment, ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			// Creating a File object
			File file1 = new File(failedScreenshotForAssignment + "/Assignment3");
			// Creating the directory
			file1.mkdir();

			File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file2, new File(failedScreenshotForAssignment + "/Assignment3/sc1.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@AfterClass
	public static void tear() {
		driver.quit();
	}

}
