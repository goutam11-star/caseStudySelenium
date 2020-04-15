package caseStudySelenium.caseStudySelenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

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

public class assignment2 extends additionalSteps implements assignment2Locators {

	@BeforeClass
	@Parameters({ "browser", "ChromeDriverPath", "FirefoxDriverPath", "failedScreenshotForAssignment",
			"property2Path" })
	public static void openBrowser(String browser, String ChromeDriverPath, String FirefoxDriverPath,
			String failedScreenshotForAssignment1, String property2Path) {

		initBrowser(browser, ChromeDriverPath, FirefoxDriverPath);

		initProperty(property2Path);

		File file = new File(failedScreenshotForAssignment1 + "/Assignment2");

		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters({ "url2", "url3", "url4" })
	@Test(priority = 1)
	public void registerInAll3Links(String url2, String url3, String url4) {

		driver.get(url2);

		driver.findElement(By.xpath(String.format(registerLoc, "1"))).click();

		driver.findElement(By.xpath(emailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(String.format(passwordLoc, "1"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(String.format(passwordLoc, "2"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(dateLoc)).click();

		driver.findElement(By.xpath(String.format(dateListLoc, prop.getProperty("Date")))).click();

		driver.findElement(By.xpath(monthLoc)).click();

		driver.findElement(By.xpath(String.format(monthListLoc, prop.getProperty("Month")))).click();

		driver.findElement(By.xpath(yearLoc)).click();

		driver.findElement(By.xpath(String.format(yearListLoc, prop.getProperty("Year")))).click();

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(alreadyExistAccountLoc)).isDisplayed()
				|| driver.findElement(By.xpath(skipStepLoc)).isDisplayed()
				|| driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());

		if (driver.findElements(By.xpath(skipStepLoc)).size() > 0) {

			driver.findElement(By.xpath(skipStepLoc)).click();
		} else {
			driver.get(url3);
		}

		driver.findElement(By.xpath(String.format(registerLoc, "1"))).click();

		driver.findElement(By.xpath(String.format(genderLoc, prop.getProperty("Gender")))).click();

		driver.findElement(By.xpath(firstNameLoc)).sendKeys(prop.getProperty("firstName"));

		driver.findElement(By.xpath(lastNameLoc)).sendKeys(prop.getProperty("Lname"));

		driver.findElement(By.xpath(emailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(String.format(passwordLoc, "1"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(String.format(passwordLoc, "2"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(stateLoc)).sendKeys(prop.getProperty("State"));

		driver.findElement(By.xpath(dateLoc)).click();

		driver.findElement(By.xpath(String.format(dateListLoc, prop.getProperty("Date")))).click();

		driver.findElement(By.xpath(monthLoc)).click();

		driver.findElement(By.xpath(String.format(monthListLoc, prop.getProperty("Month")))).click();

		driver.findElement(By.xpath(yearLoc)).click();

		driver.findElement(By.xpath(String.format(yearListLoc, prop.getProperty("Year")))).click();

		driver.findElement(By.xpath(countryLoc)).click();

		driver.findElement(By.xpath(String.format(countryDropdownLoc, prop.getProperty("country")))).click();

		driver.findElement(By.xpath(postalLoc)).sendKeys(prop.getProperty("PostalCode"));

		driver.findElement(By.xpath(cityLoc)).sendKeys(prop.getProperty("city"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(alreadyExistAccountLoc)).isDisplayed()
				|| driver.findElement(By.xpath(skipStepLoc)).isDisplayed()
				|| driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());

		driver.get(url4);

		driver.findElement(By.xpath(String.format(registerLoc, "1"))).click();

		driver.findElement(By.xpath(String.format(genderLoc, prop.getProperty("Gender")))).click();

		driver.findElement(By.xpath(firstNameLoc)).sendKeys(prop.getProperty("firstName"));

		driver.findElement(By.xpath(lastNameLoc)).sendKeys(prop.getProperty("Lname"));

		driver.findElement(By.xpath(emailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(String.format(passwordLoc, "1"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(String.format(passwordLoc, "2"))).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath(phoneLoc)).sendKeys(prop.getProperty("Phone"));

		driver.findElement(By.xpath(dateLoc)).click();

		driver.findElement(By.xpath(String.format(dateListLoc, prop.getProperty("Date")))).click();

		driver.findElement(By.xpath(monthLoc)).click();

		driver.findElement(By.xpath(String.format(monthListLoc, prop.getProperty("Month")))).click();

		driver.findElement(By.xpath(yearLoc)).click();

		driver.findElement(By.xpath(String.format(yearListLoc, prop.getProperty("Year")))).click();

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(alreadyExistAccountLoc)).isDisplayed()
				|| driver.findElement(By.xpath(skipStepLoc)).isDisplayed()
				|| driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());

	}

	@Parameters({ "url2", "url3", "url4" })
	@Test(priority = 3)
	public void InValidLoginAll3Links(String url2, String url3, String url4) {
		driver.get(url2);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("invalidPassword"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath(forgetPasswordLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(resetLinkMessageLoc)).isDisplayed());

		driver.get(url3);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("invalidPassword"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath(forgetPasswordLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(resetLinkMessageLoc)).isDisplayed());

		driver.get(url4);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("invalidPassword"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath(forgetPasswordLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(resetLinkMessageLoc)).isDisplayed());
	}

	@Parameters({ "url2", "url3", "url4" })
	@Test(priority = 3)
	public void LoginAll3Links(String url2, String url3, String url4) {

		driver.get(url2);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("password"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

		driver.get(url3);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("password"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

		driver.get(url4);
		driver.findElement(By.xpath(loginLoc)).click();

		driver.findElement(By.xpath(loginEmailLoc)).sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(prop.getProperty("password"));

		try {
			javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
		driver.manage().deleteAllCookies();

	}

	@Parameters({ "url2", "readFromExcelPath", "excellFileNAme", "excellSheetName" })
	@Test(priority = 4)
	public void readFromExcel(String url2, String excellPath, String excellFileNAme, String excellSheetName) {
		
		

		String email = null;
		String passWord = null;

		int rowCount = getRowCount(excellPath, excellFileNAme, excellSheetName);
		for (int i = 1; i < rowCount; i++) {
			
			driver.get(url2);
			
			driver.findElement(By.xpath(loginLoc)).click();

			try {
				email = readexcellfile(excellPath, excellFileNAme, excellSheetName, i, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				passWord = readexcellfile(excellPath, excellFileNAme, excellSheetName, i, 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			driver.findElement(By.xpath(loginEmailLoc)).sendKeys(email);

			driver.findElement(By.xpath(loginPasswordLoc)).sendKeys(passWord);
			try {
				javaScriptClick(driver.findElement(By.xpath(registerLoginButtonLoc)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			assertTrue(driver.findElement(By.xpath(yourProfileLoc)).isDisplayed());
			driver.manage().deleteAllCookies();

		}

	}

	@AfterMethod
	@Parameters({ "failedScreenshotForAssignment" })
	public static void getScreenshotForFailedTestCase(String failedScreenshotForAssignment, ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			// Creating a File object
			File file1 = new File(failedScreenshotForAssignment + "/Assignment2");
			// Creating the directory
			file1.mkdir();

			File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file2, new File(failedScreenshotForAssignment + "/Assignment2/sc1.jpg"));
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
