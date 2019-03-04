package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.MouseControl;

public class BasePageInitialization {
	
	CommonElements cmnElement;
	DropdownControl dropdownControl;
	MouseControl mouseControl;
	
	public BasePageInitialization(WebDriver driver) {
		cmnElement = new CommonElements();
		dropdownControl = new DropdownControl();
		mouseControl = new MouseControl(driver);
	}

}
