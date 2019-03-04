package com.mercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class HomePageTest extends BaseTest {

	@Test(priority = 0)
	public void verifyTitleOfTheHomepage() throws Exception {

		extentTest = extentReport.createTest("TC - 2001 :: Verify Title of the Home Page");

		String expectedTitle = "Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance 1";

		String actualTitle = cmnDriver.getTitle();

		extentTest.log(Status.INFO, "Comparing expected Title and Actual Title");
		extentTest.log(Status.INFO, "Actual Title :: " + actualTitle);
		extentTest.log(Status.INFO, "Expected Title :: " + expectedTitle);

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1000)
	public void verifyUserLoginWithCorrectCredentials() throws Exception {

		extentTest = extentReport.createTest("TC - 2002 :: Verify login to application with correct credentials");
		String sUserEmailId = "saurabh.d2106@gmail.com";
		String sUserPassword = "Pro@1234";

		homepage.loginToUserLogin(sUserEmailId, sUserPassword);

		String expectedWelcomeText = "Welcome, Saurabh";
		String actualWelcomeText = homepage.getWelcomeText();

		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}

}
