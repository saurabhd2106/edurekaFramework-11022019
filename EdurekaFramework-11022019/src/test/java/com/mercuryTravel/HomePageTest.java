package com.mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;

public class HomePageTest {

	CommonDriver cmnDriver;
	HomePage homepage;
	WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setPageLoadTimeout(40);

		cmnDriver.setElementDetectTimeout(10);

		cmnDriver.navigateToFirstUrl("https://www.mercurytravels.co.in/");
		
		driver = cmnDriver.getDriver();
		
		homepage = new HomePage(driver);
	}

	@Test(priority=0)
	public void verifyTitleOfTheHomepage() throws Exception {
		String expectedTitle = "Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance";

		String actualTitle = cmnDriver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=1000)
	public void verifyUserLoginWithCorrectCredentials() throws Exception{
		
		String sUserEmailId = "saurabh.d2106@gmail.com";
		String sUserPassword = "Pro@1234";
		
		homepage.loginToUserLogin(sUserEmailId, sUserPassword);
		
		String expectedWelcomeText = "Welcome, Saurabh";
		String actualWelcomeText = homepage.getWelcomeText();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
	
	@AfterClass
	public void cleanUp() {

	}

}
