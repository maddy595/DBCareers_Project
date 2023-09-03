package com.db.testRunner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.db.stepdefinitions.DBCareerDefinitions;
import com.db.utils.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/jobSearchFilters.feature",
				 glue = {"com.db.stepdefinitions"},
						// "com.db.hooks"},
				 plugin = {"pretty", "html:target/test-output/report.html"},
				 tags = "@sanity"
				// ,dryRun=true
				 //monochrome=true
				)
public class SanityRunner extends AbstractTestNGCucumberTests{
	
	@Parameters("browserType")
	@BeforeTest
	public static void defineBrowser( String browser) throws IOException {
			ConfigReader.initializePropertyFile();
			ConfigReader.prop.setProperty("BrowserType",browser );
	}
	
	@AfterMethod
	public static void QuitBrowser() throws IOException {
			//ConfigReader.initializePropertyFile();
			DBCareerDefinitions.driver.quit();
	}
	
}
