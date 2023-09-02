package com.db.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				 glue = "com.db.stepdefinitions",
				 dryRun =true,
				 plugin = {"pretty", "html:target/test-output/report.html"}
				// monochrome=true
				)
public class Runner extends AbstractTestNGCucumberTests{
	
		
}
