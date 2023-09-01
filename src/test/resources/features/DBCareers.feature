Feature: Search and Validate Job Openings
Description: 	This feature focuses on searching and jobs openings on Deutsche banks career page.

 @smoke @regression
  Scenario: Verify user is able to access Deutsche Bank job search page
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    Then User is able to view Jobs search page

 @Sanity @regression
  Scenario: Verify user is able to access all the links present under Professionals section
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    Then User is able to view Search Roles,FAQ, Professionals and  A notice on Recruitment Scams link
    And Validate that user is able to access all the links.
    
    
     @Sanity @regression @Test1
  Scenario: Verify that user is able to navigate to Job search results page by different routes
    Given User is on Deutsche Bank career page
    When User clicks on Professionals link
    Then User is able to view Jobs search page
    When User clicks on Search Roles
    Then User is able to view Jobs search page
    
    
 @Sanity @regression @Test1
  Scenario: Verify job positions when user views all the open positions without applying any filters in Search By section 
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    And User clicks Search button without applying any filters
    Then Verify job search results page is displayed
    And Verify job position count matches the one displayed on job search page
    And Verify Number of job results displayed on the page
    
    
     @Sanity @regression @Test1
  Scenario: Verify user is able to search jobs by Division and is able to see relevant results after applying necessary filters in Search By section 
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    And User selects Division in Search By section
    And User selects division category and other filters
    And User clicks Search button
    And Verify job count matches with the total jobs on the page
    And Verify job search results page jobs from right city user has searched
    
         #@Sanity @regression @Test1
  #Scenario: Verify user is able to search jobs by Profession and is able to see relevant results after applying necessary filters in Search By section 
    #Given User is on Deutsche Bank career page
    #When User hovers mouse over Professionals link
    #And User clicks on Search Roles
    #And User selects Profession in Search By section
    #And User selects division category and other filters
    #And User clicks Search button
    #Then Verify job search results page is displayed with right jobs that user has searched
    #And Verify job count matches with the total jobs on the page
    #
    #
 #@Sanity @regression @Test1
  #Scenario: Verify user is able to search jobs by providing Role Title in Keyword Search Section and is able to see relevant results 
    #Given User is on Deutsche Bank career page
    #When User hovers mouse over Professionals link
    #And User clicks on Search Roles
    #And User provides a Role title in Keyword Search section
    #And User clicks Search button
    #Then Verify job search results page is displayed with right jobs that user has searched
    #And Verify job count matches with the total jobs on the page
    #
     #@Sanity @regression @Test1
  #Scenario Outline: Verify user is able to search jobs by providing Keyword in Job ID/Keyword search box and is able to see relevant results 
    #Given User is on Deutsche Bank career page
    #When User hovers mouse over Professionals link
    #And User clicks on Search Roles
    #And User provides a Keyword in Keyword Search section
    #And User clicks Search button
    #Then Verify job search results page is displayed with right jobs that user has searched
    #|Examples |
   #| Data |
    #|ENgineer |
    #|Hello |
    #|Bye |
    #
   #@Sanity @regression @Test1
  #Scenario Outline: Verify user is able to search jobs by providing Job ID in Job ID/Keyword search box and is able to see relevant results 
    #Given User is on Deutsche Bank career page
    #When User hovers mouse over Professionals link
    #And User clicks on Search Roles
    #And User provides a JobID in Keyword Search section
    #And User clicks Search button
    #Then Verify job search results page is displayed with right jobs that user has searched
   #| Examples |
   #| JOb iD 1 |
    #|JOb ID 2|
    #|JOb ID 3|
    #
    #
    
 #@Sanity @regression @Test1
  #Scenario: Verify job positions count when user views all the open positions without applying any filters in Search By section 
    #Given User is on Deutsche Bank career page
    #When User hovers mouse over Professionals link
    #And User clicks on Search Roles
    #And User clicks Search button without applying any filters
    #Then Verify job position count matches the one displayed on job search page
    #

 @Sanity @regression @Test1
  Scenario: Verify that all the links on Careers page are working
    Given User is on Deutsche Bank career page
    When User clicks on Professionals link
    And User check for any broken links on the page
    Then There should be no broken links on the page