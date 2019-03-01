package demo;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.CommonElements;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.ScreenshotControl;

public class DemoCommonDriver {

	public static void main(String[] args) throws Exception{
		
		WebDriver driver;
		
		CommonDriver cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.setElementDetectTimeout(10);
		
		cmnDriver.setPageLoadTimeout(40);
		
		cmnDriver.navigateToFirstUrl("http://demo.guru99.com/v4");
		
		driver = cmnDriver.getDriver();
		
		CommonElements cmnElement = new CommonElements();
		
		FrameControl frameControl = new FrameControl(driver);
		
		AlertControl alertControl = new AlertControl(driver);

		ScreenshotControl screenshot = new ScreenshotControl(driver);
		
		screenshot.captureAndSaveScreenshot("C:/Users/Saurabh Dhingra/git/edurekaFramework-11022019/EdurekaFramework-11022019/screenshots/test.jpeg");
	}

}
