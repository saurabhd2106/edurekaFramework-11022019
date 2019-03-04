package com.mercuryTravel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercuryTravel.pages.HolidayPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;

public class BaseTest {

	CommonDriver cmnDriver;
	HomePage homepage;
	HolidayPage holidayPage;

	WebDriver driver;
	private ScreenshotControl screenshotControl;
	
	public static long executionStartTime;
	private String currentWorkingDirectory;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	static {
		executionStartTime = System.currentTimeMillis();
	}

	@BeforeSuite(alwaysRun = true)
	public void preSetup() {

		initializeCurrentWorkingDirectory();

		initializeHtmlReport();

	}

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {

		extentTest = extentReport.createTest("Setup :: All initialization is done here");

		invokeBrowser();

		getDriverInstance();

		initializeScreenshotInstance();

		pageInitialization();

	}

	private void initializeScreenshotInstance() throws Exception {
		screenshotControl = new ScreenshotControl(driver);

	}

	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception {
		String testMethodName = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case pass : " + testMethodName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case failed : " + testMethodName);

			String screenshotFileName = String.format("%s/screenshots/%s%d.jpeg", currentWorkingDirectory,
					testMethodName, executionStartTime);
			screenshotControl.captureAndSaveScreenshot(screenshotFileName);
			
			extentTest.addScreenCaptureFromPath(screenshotFileName);

		} else {
			extentTest.log(Status.SKIP, "Test case skipped");
		}
	}

	@AfterClass(alwaysRun = true)
	public void cleanUp() throws Exception {

		cmnDriver.closeAllBrowsers();

	}

	@AfterSuite
	public void postCleanUp() {
		extentReport.flush();
	}

	private void pageInitialization() {
		homepage = new HomePage(driver);
		holidayPage = new HolidayPage(driver);
	}

	private void getDriverInstance() {
		driver = cmnDriver.getDriver();

	}

	private void invokeBrowser() throws Exception {
		String browserType = "chrome";
		extentTest.log(Status.INFO, "Initialized Browser :: " + browserType);
		cmnDriver = new CommonDriver(browserType);

		int pageLoadTimeout = 40;
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		extentTest.log(Status.INFO, "Page Load Timeout :: " + pageLoadTimeout);

		int elementDetectionTimeout = 10;
		cmnDriver.setElementDetectTimeout(elementDetectionTimeout);
		extentTest.log(Status.INFO, "Implict Wait :: " + elementDetectionTimeout);

		String baseUrl = "https://www.mercurytravels.co.in/";
		cmnDriver.navigateToFirstUrl(baseUrl);

		extentTest.log(Status.INFO, "Navigating to Base Url :: " + baseUrl);
	}

	private void initializeCurrentWorkingDirectory() {

		currentWorkingDirectory = System.getProperty("user.dir");

	}

	private void initializeHtmlReport() {
		
		String htmlReportName = String.format("%s/reports/mercuryTravelTestReport%d.html", currentWorkingDirectory, executionStartTime);
		htmlReporter = new ExtentHtmlReporter(htmlReportName);

		extentReport = new ExtentReports();

		extentReport.attachReporter(htmlReporter);
	}
}
