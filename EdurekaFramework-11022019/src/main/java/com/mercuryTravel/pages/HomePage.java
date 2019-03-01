package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.MouseControl;

public class HomePage {
	
	@FindBy(linkText = "International Holidays")
	private WebElement internationHolidayLink;

	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidayLink;

	@FindBy(linkText = "Flights")
	private WebElement flightLink;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	// TO DO: Please update other links

	@FindBy(linkText = "Customer Login")
	private WebElement customerLogin;

	@FindBy(linkText = "User Login")
	private WebElement userLogin;

	@FindBy(linkText = "Register")
	private WebElement RegisterLink;

	@FindBy(id = "sign_user_email")
	private WebElement userEmailId;

	@FindBy(id = "sign_user_password")
	private WebElement userPassword;

	@FindBy(xpath = "//div[@id='modalLogin']//form[@class='form-signin']//button")
	private WebElement loginButton;

	@FindBy(partialLinkText = "Welcome,")
	private WebElement welcomeText;
	
	CommonElements cmnElement;
	DropdownControl dropdownControl;
	MouseControl mouseControl;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		cmnElement = new CommonElements();
		dropdownControl = new DropdownControl();
		mouseControl = new MouseControl(driver);
	}
	
	public void loginToUserLogin(String sUserEmailId, String sUserPassword) throws Exception{
		
		mouseControl.moveToElement(customerLogin);
		
		mouseControl.moveToElementAndClick(userLogin);
		
		Thread.sleep(2000);
		cmnElement.setText(userEmailId, sUserEmailId);
		
		cmnElement.setText(userPassword, sUserPassword);
		
		cmnElement.clickElement(loginButton);
	}
	
	public String getWelcomeText() throws Exception{
		return cmnElement.getText(welcomeText);
	}
}
