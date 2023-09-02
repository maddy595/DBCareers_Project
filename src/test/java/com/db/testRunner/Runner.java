package com.db.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
		///JobSearchFilters.feature",
				 glue = {"com.db.stepdefinitions","com.db.hooks"},
				// dryRun =true,
				 plugin = {"pretty", "html:target/test-output/report.html"}
				 //tags = "@MyDatTable"
				// monochrome=true
				)
public class Runner extends AbstractTestNGCucumberTests{
	
		
}
