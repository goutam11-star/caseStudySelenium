package caseStudySelenium.caseStudySelenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class assignment1 extends additionalSteps implements assignment1Locators {

	int screenshot = 1;

	@BeforeClass
	@Parameters({ "browser", "ChromeDriverPath", "FirefoxDriverPath", "failedScreenshotForAssignment",
			"property1Path" })
	public void openBrowser(String browser, String ChromeDriverPath, String FirefoxDriverPath,
			String failedScreenshotForAssignment, String property1Path) {

		initBrowser(browser, ChromeDriverPath, FirefoxDriverPath);

		initProperty(property1Path);

		File file = new File(failedScreenshotForAssignment + "/Assignment1");

		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	@Parameters({ "url1" })

	public void clickOnEachItem(String url1) {

		driver.get(url1 + "/selectable/");

		List<WebElement> items = driver.findElements(By.xpath(numberOfItemsLoc));

		for (WebElement item : items) {
			item.click();
			System.out.println("ItemsName: " + item.getText());
			assertTrue(driver.findElement(By.xpath(selectedItemLOc)).getText().equalsIgnoreCase(item.getText()));
		}

	}

	@Test(priority = 2)
	@Parameters({ "url1" })
	public void fillTheForm(String url1) {

		driver.get(url1 + "/html-contact-form/");

		driver.findElement(By.xpath(firstnameLoc)).sendKeys(prop.getProperty("firstName"));

		driver.findElement(By.xpath(lastnameLoc)).sendKeys(prop.getProperty("lastName"));

		driver.findElement(By.xpath(countryNameLoc)).sendKeys(prop.getProperty("Country"));

		driver.findElement(By.xpath(subjectTextAreaLoc)).sendKeys(prop.getProperty("Subject"));

		driver.findElement(By.xpath(submitLoc)).click();

		driver.navigate().back();

		ArrayList<WebElement> items = new ArrayList<WebElement>(driver.findElements(By.partialLinkText("Google Link")));

		String[] str = new String[items.size()];

		for (int i = 0; i < items.size(); i++) {
			str[i] = items.get(i).getAttribute("href");
		}

		((JavascriptExecutor) driver).executeScript("window.open()");

		Set<String> winHandles = driver.getWindowHandles();

		for (String wh : winHandles) {
			driver.switchTo().window(wh);

		}

		for (int i = 0; i < items.size(); i++) {
			driver.get(str[i]);
		}

		driver.close();

		winHandles = driver.getWindowHandles();

		for (String wh : winHandles) {
			driver.switchTo().window(wh);

		}

	}

	@Test(priority = 3)
	@Parameters({ "url1" })
	public void dragAndDropTarget(String url1) {

		driver.get(url1 + "/droppable/");

		Actions ac = new Actions(driver);
		ac.dragAndDrop(driver.findElement(By.xpath(draggableLoc)), driver.findElement(By.xpath(droppableLoc))).build()
				.perform();

		assertTrue(driver.findElement(By.xpath(highlightedLoc)).getText().equalsIgnoreCase("Dropped!"));

	}

	@Test(priority = 4)
	@Parameters({ "url1" })
	public void selectDateOfBirthInACalendar(String url1) {

		driver.get(url1 + "/datepicker/");
		driver.findElement(By.xpath(datePickerLoc)).click();

		// Selecting year 100years Timeline
		for (int i = 0; i <= 1200; i++) {

			String year = driver.findElement(By.xpath(yearPickLoc)).getText();

			if (year.equalsIgnoreCase(prop.getProperty("Year"))) {
				break;
			} else {
				driver.findElement(By.xpath(prevNavLoc)).click();
			}

		}

		// Selecting month
		for (int i = 1; i < 12; i++) {
			String month = driver.findElement(By.xpath(monthPickLoc)).getText();

			if (month.equalsIgnoreCase(prop.getProperty("Month"))) {
				break;
			} else {
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}

		}

		// Selecting Day
		WebElement table = driver.findElement(By.xpath(datePickLoc));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < cols.size(); j++) {
				if (cols.get(j).getText().equalsIgnoreCase(prop.getProperty("Date"))) {
					cols.get(j).click();
				}
			}

		}

	}

	@Test(priority = 5)
	@Parameters({ "url1" })
	public void selectAllTheMenuOptionsOneByOne(String url1) {

		driver.get(url1 + "/selectmenu/");

		driver.findElement(By.xpath(String.format(selectMenuLoc, "speed-button"))).click();

		driver.findElement(By.xpath(String.format(selectMenuListLoc, "Slower"))).click();

		driver.findElement(By.xpath(String.format(selectMenuLoc, "files-button"))).click();

		driver.findElement(By.xpath(String.format(selectMenuListLoc, "jQuery.js"))).click();

		driver.findElement(By.xpath(String.format(selectMenuLoc, "number-button"))).click();

		driver.findElement(By.xpath(String.format(selectMenuListLoc, "2"))).click();

		driver.findElement(By.xpath(String.format(selectMenuLoc, "salutation-button"))).click();

		driver.findElement(By.xpath(String.format(selectMenuListLoc, "Mr."))).click();

	}
	
	@Test(priority = 6)
	@Parameters({ "url1" })
	public void selectRentalCarHorizontalBlock(String url1) {
		driver.get(url1+"/controlgroup/");
		
		String str = "horizontal";
		
		driver.findElement(By.xpath(String.format(carTypeLoc, str))).click();

		driver.findElement(By.xpath(String.format(carTypeDropdownListLoc,str, "Compact car"))).click();
		
		driver.findElement(By.xpath(String.format(automaticStatndardOptionLoc, str))).click();
		
		driver.findElement(By.xpath(String.format(insuranceLoc, str))).click();
		
		driver.findElement(By.xpath(String.format(noOfCars, str))).sendKeys("3");
		
		driver.findElement(By.xpath(String.format(bookNowLoc, str))).click();
		
		str = "vertical";
		
		driver.findElement(By.xpath(String.format(carTypeLoc, str))).click();

		driver.findElement(By.xpath(String.format(carTypeDropdownListLoc,str, "Compact car"))).click();
		
		driver.findElement(By.xpath(String.format(automaticStatndardOptionLoc, str))).click();
		
		driver.findElement(By.xpath(String.format(insuranceLoc, str))).click();
		
		driver.findElement(By.xpath(String.format(noOfCars, str))).sendKeys("3");
		
		driver.findElement(By.xpath(String.format(bookNowLoc, str))).click();
		
		
		
		
	}
	

	@AfterMethod
	@Parameters({ "failedScreenshotForAssignment" })
	public void getScreenshotForFailedTestCase(String failedScreenshotForAssignment, ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			// Creating a File object
			File file1 = new File(failedScreenshotForAssignment + "/Assignment1");
			// Creating the directory
			file1.mkdir();

			File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file2,
						new File(failedScreenshotForAssignment + "/Assignment1/Testcase" + screenshot + ".jpg"));
				screenshot++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@AfterClass
	public void tear() {
		 driver.quit();
	}

}
