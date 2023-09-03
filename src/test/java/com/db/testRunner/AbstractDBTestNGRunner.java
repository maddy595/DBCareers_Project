package com.db.testRunner;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.db.service.InitServiceHelper;
import com.db.stepdefinitions.DBCareerDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class AbstractDBTestNGRunner extends AbstractTestNGCucumberTests{
	
 InitServiceHelper initServiceHelper=null;
	
	@Parameters("browserType")
	@BeforeTest
	public void defineBrowser(@Optional String browser) throws IOException {
		System.out.println("I am in Before Test#######################################################");
		initServiceHelper = new InitServiceHelper();
		initServiceHelper.setUp(browser);
	}
	
	@AfterMethod
	public void QuitBrowser() throws IOException {
			//DBCareerDefinitions.driver.quit();
		initServiceHelper.tearDown();
		System.out.println("I am in After Method #######################################################");
	}

}
