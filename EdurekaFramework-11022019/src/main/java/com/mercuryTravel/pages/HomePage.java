package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageInitialization {

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

	public HomePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void loginToUserLogin(String sUserEmailId, String sUserPassword) throws Exception {

		moveToCustomerLogin();

		mouseControl.moveToElementAndClick(userLogin);

		Thread.sleep(2000);
		cmnElement.setText(userEmailId, sUserEmailId);

		cmnElement.setText(userPassword, sUserPassword);

		cmnElement.clickElement(loginButton);
	}
	
	private void moveToCustomerLogin() throws Exception{
		mouseControl.moveToElement(customerLogin);
	}

	public String getWelcomeText() throws Exception {
		return cmnElement.getText(welcomeText);
	}
}
