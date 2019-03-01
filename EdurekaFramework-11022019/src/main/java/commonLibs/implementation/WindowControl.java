package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindow;

public class WindowControl implements IWindow {
	WebDriver driver;

	public WindowControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		
		String childWindowHandle;
		
		childWindowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childWindowHandle);

	}

	@Override
	public String getWindowHandle() throws Exception {
		
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		
		return driver.getWindowHandles();
	}

}
