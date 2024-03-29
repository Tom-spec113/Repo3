package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataReader;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.UtilityMethods;

public class BaseClass {

	protected static WebDriver driver;
	protected static ConfigDataReader cdr;
	protected static ExcelDataProvider edp;

	protected ExtentSparkReporter reporter;
	protected ExtentReports er;
	protected ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {

		Reporter.log("Before Suite method execution started", true);

		driver = null;
		cdr = new ConfigDataReader();
		edp = new ExcelDataProvider();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport "
				+ UtilityMethods.getCurrentDateTime() + ".html");
		// reporter.config().setTheme(Theme.DARK);
		er = new ExtentReports();
		er.attachReporter(reporter);

		Reporter.log("Before Suite method execution Ended", true);

	}

	@BeforeClass
	@Parameters({ "browser", "Url" })
	public void setUpClass(String browser, String Url) {

		Reporter.log("Before Class method execution started", true);

		driver = BrowserFactory.startApplication(driver, browser, Url);

		// driver = BrowserFactory.startApplication(driver,
		// cdr.getConfigParam("Browser"), cdr.getConfigParam("Url"));

		Reporter.log("Before Class method execution ended", true);
	}

	@AfterClass
	public void tearDownClass() {
		
		Reporter.log("After Class method execution started", true);

		BrowserFactory.quitBrowser(driver);
		
		Reporter.log("After Class method execution ended", true);

	}

	@AfterMethod
	public void tearDownAfterMethodFailure(ITestResult itr) {
		
		Reporter.log("After Method method execution started", true);

		String sp = UtilityMethods.captureScreenshot(driver, driver.getTitle());

		if (itr.getStatus() == ITestResult.FAILURE) {

			logger.fail(itr.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(sp).build());
		} else if (itr.getStatus() == ITestResult.SUCCESS) {

			logger.pass(itr.getName() + " is passed.", MediaEntityBuilder.createScreenCaptureFromPath(sp).build());
		}

		er.flush();
		
		Reporter.log("After Method method execution ended", true);

	}

}
