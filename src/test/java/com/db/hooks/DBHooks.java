package com.db.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Parameters;

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
		
		launchBrowser("Chrome");
		
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
	
	
	public static void launchBrowser(String browser) {
		//String browser="Chrome";
		if(browser.equals("Chrome")) {
			//System.out.println(System.);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(options);
		}else if (browser.equals("Edge")) {
			EdgeOptions options1 = new EdgeOptions();
			options1.addArguments("--remote-allow-origins=*");
	        driver = new EdgeDriver(options1);
		}
	}

}
