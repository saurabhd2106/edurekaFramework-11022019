package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPOM1Style {
	
	public WebElement searchBox;
	
	public WebElement catDropdown;
	
	public WebElement searchButton;
	

	public AmazonPOM1Style(WebDriver driver) {
		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		catDropdown = driver.findElement(By.id("searchDropdownBox"));
		
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
	}
}
