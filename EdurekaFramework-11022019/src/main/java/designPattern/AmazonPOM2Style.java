package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;

public class AmazonPOM2Style {

	private WebElement searchBox;

	private WebElement catDropdown;

	private WebElement searchButton;

	private CommonElements cmnElementControl;

	private DropdownControl dropdownControl;
	
	private WebElement result;

	public AmazonPOM2Style(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		catDropdown = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
		result = driver.findElement(By.id("s-result-count"));

		cmnElementControl = new CommonElements();

		dropdownControl = new DropdownControl();

	}

	public void searchProduct(String product, String category) throws Exception{
		cmnElementControl.setText(searchBox, "Apple Watch");

		dropdownControl.selectViaVisibleText(catDropdown, "Electronics");

		cmnElementControl.clickElement(searchButton);
		
		cmnElementControl.getText(result);
	}
}
