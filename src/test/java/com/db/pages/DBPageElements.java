package com.db.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DBPageElements {

	public static WebDriver driver;
	
	public static void setWebDriver(WebDriver dr) {
		driver=dr;
	}
	
	public DBPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='professionals_top']/a")
	WebElement professionalLink;
	
	@FindBy(xpath = "//*[@id='professionals_sub']/li[1]/a")
	WebElement searchLink;
	
	public WebElement getProfessionalLink() {
		return professionalLink;
	}
	
	public WebElement getsearchLink() {
		return searchLink;
	}
	
}
