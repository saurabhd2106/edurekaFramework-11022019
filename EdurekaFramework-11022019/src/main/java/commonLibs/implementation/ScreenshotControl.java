package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot{
	
	private TakesScreenshot camera;
	public ScreenshotControl(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}

	@Override
	public String captureAndSaveScreenshot(String fileName) throws Exception {
		
		fileName = fileName.trim();
		
		File imgFile, tmpFile;
		
		imgFile = new File(fileName);
		
		if(imgFile.exists()){
			throw new Exception("File already exists");
		}
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
		return imgFile.getAbsolutePath();
	}

}
