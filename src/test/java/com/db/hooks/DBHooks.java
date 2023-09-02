package com.db.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.db.utils.HelperMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DBHooks {
	public static WebDriver driver;
	public HelperMethods hm;
	
	public static WebDriver getDriver() {
		return driver;
	}

	@Before
    public void setUp(Scenario scenario) {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        	for(String tag : scenario.getSourceTagNames()){
        		System.out.print("Tag: " + tag);
        	}	 
    }
	
	@After
    public void tearDown() {
		driver.quit();
    }

}
