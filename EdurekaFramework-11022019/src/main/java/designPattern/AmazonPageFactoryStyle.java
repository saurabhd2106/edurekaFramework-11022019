package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;

public class AmazonPageFactoryStyle {

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id = "searchDropdownBox")
	private WebElement catDropdown;

	@CacheLookup
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchButton;

	@FindBy(id = "s-result-count")
	private WebElement result;

	private CommonElements cmnElementControl;

	private DropdownControl dropdownControl;

	public AmazonPageFactoryStyle(WebDriver driver) {

		PageFactory.initElements(driver, this);
		cmnElementControl = new CommonElements();

		dropdownControl = new DropdownControl();
	}

	public void searchProduct(String product, String category) throws Exception {
		cmnElementControl.setText(searchBox, "Apple Watch");

		dropdownControl.selectViaVisibleText(catDropdown, "Electronics");

		cmnElementControl.clickElement(searchButton);

		cmnElementControl.getText(result);
	}
}
