package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IMouseAction {
	
	public void dragAndDrop(WebElement element1, WebElement element2) throws Exception;

	public void moveToElement(WebElement element) throws Exception;

	public void rightClick(WebElement element) throws Exception;

	public void doubleClick(WebElement element) throws Exception;

	public void moveToElementAndClick(WebElement element) throws Exception;


}
