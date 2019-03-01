package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import designPattern.AmazonPOM2Style;
import designPattern.AmazonPageFactoryStyle;

public class DemoAmazonPageFactoryStyle {

	private CommonDriver cmnDriver;

	private AmazonPageFactoryStyle homePage;

	private WebDriver driver;

	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setElementDetectTimeout(10);

		cmnDriver.setPageLoadTimeout(40);

		cmnDriver.navigateToFirstUrl("https://www.amazon.in/");
		
		driver = cmnDriver.getDriver();

		homePage = new AmazonPageFactoryStyle(driver);

	}

	@Test
	public void searchProduct() throws Exception {
		homePage.searchProduct("Apple Watch", "Electronics");
	}

	@AfterClass
	public void closebrowser() throws Exception {
		cmnDriver.closeAllBrowsers();
	}

}
