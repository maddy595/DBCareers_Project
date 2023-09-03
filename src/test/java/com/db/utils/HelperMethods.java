package com.db.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.db.service.BrowserInitImpl;
import com.db.stepdefinitions.DBCareerDefinitions;

import io.cucumber.java.Scenario;

public class HelperMethods {
	 static BrowserInitImpl browserInitImpl = new BrowserInitImpl();
	public static WebDriver driver= browserInitImpl.getDriver();

	public static int extractintFromString(WebElement el) {
		
		String str = el.getText();
		str = str.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(str);
		return number;
	}
	
	public static void getScreenshot(Scenario scenario) {
		TakesScreenshot tks = (TakesScreenshot)driver;
		byte[] output = tks.getScreenshotAs(OutputType.BYTES);
		scenario.attach(output, "image/png", "screenshot");
		
	}
	
	public static void movetoElement(WebElement element) {
		driver= browserInitImpl.getDriver();
		Actions ac = new Actions(driver);
	    ac.moveToElement(element).build().perform();
	}
	
	public static void clickElementUsingActionsClass(WebElement element) {
		driver= browserInitImpl.getDriver();
		Actions ac = new Actions(driver);
	    ac.moveToElement(element).click().build().perform();
	}
	
}
