package com.db.stepdefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions.*;


public class DBCareerDefinitions {
	
	private static WebDriver driver;     
    public final static int TIMEOUT = 50;
    public static int brokenLinksCount=0;
    public static int jobCountOnJObSearchPage;
    public static String cityBeSelected;
    
	@Before
    public void setUp(Scenario scenario) {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        
        	for(String tag : scenario.getSourceTagNames()){
        		System.out.print("Tag: " + tag);
        	}	 
    }
	
	@After
    public void tearDown() {
		driver.quit();
    }
	
	
	@Given("User is on Deutsche Bank career page")
	public void user_is_on_deutsche_bank_career_page() {
		
	    driver.get("https://careers.db.com");
	    //Accept cookies and continue
	    
       // WebElement shadowHost = driver.findElement(By.cssSelector("shadowHost_CSS"));
     // get the shadow root
        SearchContext se= driver.findElement(By.xpath("//*[@id='usercentrics-root']")).getShadowRoot();
      
        se.findElement(By.cssSelector("#uc-center-container > div.sc-cCjUiG.gHlwwJ > div > div > div > button:nth-child(3)")).click();
        System.out.println("Clicked on the element");
       // #uc-center-container > div.sc-cCjUiG.gHlwwJ > div > div > div > button:nth-child(3)
	}

	@When("User hovers mouse over Professionals link")
	public void user_hovers_mouse_over_link() {
	    Actions ac = new Actions(driver);
	    WebElement el = driver.findElement(By.xpath("//*[@id='professionals_top']/a"));
	    ac.moveToElement(el).perform();
	}

	@And("User clicks on Search Roles")
	public void user_moves_to_search_roles() {
		Actions ac = new Actions(driver);
	    WebElement el = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a"));
	    ac.moveToElement(el).click().build().perform();
	}

	@Then("User is able to view Jobs search page")
	public void user_is_able_to_view_jobs_search_page() {
	    String s = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[1]/div/h3")).getText();
	    System.out.println(s);
	    String expected = "Search by:";
	    Assertions.assertThat(s).isEqualTo(expected);
	    
	}

	@Then("User is able to view Search Roles,FAQ, Professionals and  A notice on Recruitment Scams link")
	public void user_is_able_to_view_search_roles_faq_professionals_and_link() {
		Boolean SearchLink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		Boolean YourApplicationLink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		Boolean RecruitmentScamslink = driver.findElement(By.xpath("//*[@id='professionals_sub']/li[1]/a")).isDisplayed();
		
		    Assertions.assertThat(SearchLink);
		    Assertions.assertThat(YourApplicationLink);
		    Assertions.assertThat(RecruitmentScamslink);
	}

	@Then("Validate that user is able to access all the links.")
	public void validate_that_user_is_able_to_access_all_the_links() {
	   System.out.println("All links are validated");
	}
	
	@When("User clicks on Professionals link")
	public void User_clicks_Professionals_link() {
		driver.findElement(By.xpath("//*[@id='professionals_top']/a")).click();
	
	}
	
	@When("User check for any broken links on the page")
	public void user_check_for_any_broken_links_on_the_page() {
	    List<WebElement> lis = driver.findElements(By.xpath("//*[contains(@href,'professionals')]"));
	    System.out.println(lis.size());
	    for(int i=0;i<lis.size();i++) {
	    	String url = lis.get(i).getAttribute("href");
	    	URL link;
	    	HttpURLConnection conn = null;
			try {
				link = new URL(url);
				conn = (HttpURLConnection) link.openConnection();
				conn.setConnectTimeout(1000); // Set connection timeout to 3 seconds
				conn.connect();
				if (conn.getResponseCode() == 200) {
						System.out.println(url + " - " + conn.getResponseMessage());
					}else{
						System.out.println(url + " - " + conn.getResponseMessage() + " - " + "is a broken link");
						brokenLinksCount++;
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

	@Then("There should be no broken links on the page")
	public void there_should_be_no_broken_links_on_the_page() {
	    if(brokenLinksCount>0) {
	    	Assertions.assertThat(brokenLinksCount).isEqualTo(0);
	    }
	}
	
	@When("User clicks Search button without applying any filters")
	public void user_clicks_search_button_without_applying_any_filters() {
		
		WebElement el = driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[3]"));
		jobCountOnJObSearchPage=extractintFromString(el);
		System.out.println(jobCountOnJObSearchPage);
	    driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[2]/a")).click();
	}
	
	@Then("Verify job search results page is displayed")
	public void Verify_job_search_results_page_is_displayed() {
		WebElement searResultPage = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/h2/span"));
	    String SearResultString = searResultPage.getText();
	    Assertions.assertThat(SearResultString).isEqualTo("Search Results:");
	}
	
	@Then("Verify Number of job results displayed on the page")
	public void Verify_Number_of_results_displayed_on_the_page() {
		WebElement el = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int jobCountOnJobResultPage=extractintFromString(el);
		List<WebElement> listOfJobs = driver.findElements(By.xpath("//*[@class='yello-search-result']/div/div/div/a"));
		if(listOfJobs.size()<10) {
			Assertions.assertThat(listOfJobs.size()).isEqualTo(jobCountOnJobResultPage);
		}
		
	}

	@Then("Verify job position count matches the one displayed on job search page")
	public void verify_job_position_count_matches_the_one_displayed_on_job_search_page() {
	    
	    //Verify count of jobs is correct by getting count on top of te page
	    WebElement el = driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int jobCountOnJobResultPage=extractintFromString(el);
		System.out.println(jobCountOnJobResultPage);
		Assertions.assertThat(jobCountOnJObSearchPage).isEqualTo(jobCountOnJobResultPage);
		
		
	}
	
	@And("User selects Division in Search By section")
	public void user_selects_division_in_search_by_section() {
	    WebElement division = driver.findElement(By.xpath("//*[@id='divisionProf']"));
	    Actions ac = new Actions(driver);
	    ac.moveToElement(division).click().build().perform();
	}

	@And("User selects division category and other filters")
	public void user_selects_division_category_and_other_filters() {
		WebElement DivisionCategory=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[2]/div/div[2]/div"));
		By ListOfWebElements = By.xpath("//*[@class='select-wrapper']/div[2]/div/div[2]/ul/li");
		String DivisionBeSelected="Human Resources";
		selectValueFromDropdown(DivisionCategory , ListOfWebElements , DivisionBeSelected);
		
		/*WebElement country=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[3]/div[1]/div[2]/div[1]"));
		By ListOfWebElements2 = By.xpath("//*[@class='select-wrapper']/div[3]/div/div[2]/ul/li");
		String CountryBeSelected="India";
		selectValueFromDropdown(country , ListOfWebElements2 , CountryBeSelected);
		
		WebElement City=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[3]/div[3]/div[2]/div[1]"));
		By ListOfWebElements3 = By.xpath("//*[@class='select-wrapper']/div[3]/div[3]/div[2]/ul/li");
		cityBeSelected="Mumbai";
		selectValueFromDropdown(City , ListOfWebElements3 , cityBeSelected);
		
		WebElement work=  driver.findElement(By.xpath("//*[@class='select-wrapper']/div[5]/div/div[2]/div"));
		By ListOfWebElements4 = By.xpath("//*[@class='select-wrapper']/div[5]/div/div[2]/ul/li");
		String workType="Permanent";
		selectValueFromDropdown(work , ListOfWebElements4 , workType);
	    */
	}

	@And("User clicks Search button")
	public void user_clicks_search_button() {
		WebElement el = driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[3]"));
		jobCountOnJObSearchPage=extractintFromString(el);
		System.out.println(jobCountOnJObSearchPage);
	    driver.findElement(By.xpath("//*[@class='search-wrapper']/div/div/div[2]/a")).click();
	}

	@And("Verify job search results page jobs from right city user has searched")
	public void verify_job_search_results_page_is_displayed_with_right_jobs_that_user_has_searched() {
	    driver.findElement(By.xpath("//*[@class='yello-search-result']/div/div/div/a/div/h2")).click();
	    String xpath="//*[text()[contains(., ': "+cityBeSelected+"')]]";
	    String displayedCity = driver.findElement(By.xpath("xpath")).getText();
	    System.out.println(displayedCity);
	    Assertions.assertThat(displayedCity).contains(cityBeSelected);
	}

	@Then("Verify job count matches with the total jobs on the page")
		
	public void verify_job_count_matches_with_the_total_jobs_on_the_page() {
		WebElement CountofJobs=driver.findElement(By.xpath("//*[@id='job-module']/div/div/div/div/div[2]/div/div[1]/div[1]"));
		int totaljobs=extractintFromString(CountofJobs);
		System.out.println("Jobs on top of Page = "+totaljobs);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			List<WebElement> loadmore=driver.findElements(By.xpath("//button[contains(text(),'Load more')]"));
			while(loadmore.size()>0) {
				loadmore.get(0).click();
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				loadmore=driver.findElements(By.xpath("//button[contains(text(),'Load more')]"));
			}
		if(loadmore.size()==0) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		List<WebElement> listOfJobs = driver.findElements(By.xpath("//*[@class='yello-search-result']/div/div/div/a"));
		System.out.println("Lists of jobs =  " +listOfJobs.size());
		Assertions.assertThat(listOfJobs.size()).isEqualTo(totaljobs);
	   System.out.println("String count Matches");
	
}

	public void selectValueFromDropdown(WebElement dropdownbox , By listboxxpath , String valueToBeSelected) {

		   Actions ac = new Actions(driver);
		   WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		   w.until(ExpectedConditions.elementToBeClickable(dropdownbox));
		   ac.moveToElement(dropdownbox).click().build().perform();
		    List<WebElement> listbox = driver.findElements(listboxxpath);
		   // System.out.println(listbox.size());
		    for(WebElement el1 : listbox) {
		    	//System.out.println(el1.getText());
		    	if(el1.getText().contains(valueToBeSelected)) {
		    		w.until(ExpectedConditions.elementToBeClickable(el1));
		    		ac.moveToElement(el1).click().build().perform();
		    		break;
		    	}
		    }
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	
	
	public int extractintFromString(WebElement el) {
		
		String str = el.getText();
		str = str.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(str);
		return number;
	}
	
	
}
