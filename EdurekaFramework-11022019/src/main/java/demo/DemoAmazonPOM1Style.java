package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;
import designPattern.AmazonPOM1Style;

public class DemoAmazonPOM1Style {
	
	private CommonDriver cmnDriver;
	
	private CommonElements cmnElementControl;
	
	private DropdownControl dropdownControl;
	
	private AmazonPOM1Style homePage;
	
	private WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		 cmnDriver = new CommonDriver("chrome");
		 
		 cmnDriver.setElementDetectTimeout(10);
		 
		 cmnDriver.setPageLoadTimeout(40);
		 
		 cmnDriver.navigateToFirstUrl("https://www.amazon.in/");
		 
		 cmnElementControl = new CommonElements();
		 
		 dropdownControl= new DropdownControl();
		 
		 homePage = new AmazonPOM1Style(driver);
		 
	}
	
	@Test
	public void searchProduct() throws Exception{
		cmnElementControl.setText(homePage.searchBox, "Apple Watch");
		
		dropdownControl.selectViaVisibleText(homePage.catDropdown, "Electronics");
		
		cmnElementControl.clickElement(homePage.searchButton);
	}
	
	@AfterClass
	public void closebrowser() throws Exception{
		cmnDriver.closeAllBrowsers();
	}

}
