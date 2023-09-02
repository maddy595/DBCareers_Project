package com.db.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.db.hooks.DBHooks;

public class HelperMethods {
	
	public WebDriver driver;
	
	 public HelperMethods() {
	    	driver = DBHooks.getDriver();
	    }

	public int extractintFromString(WebElement el) {
		
		String str = el.getText();
		str = str.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(str);
		return number;
	}
	
}
