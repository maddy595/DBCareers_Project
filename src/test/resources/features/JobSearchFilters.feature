Feature: Search and Validate Job Openings
  Description: 	This feature focuses on searching and validating jobs openings on Deutsche banks career page.

  @Sanity @regression @Test5
  Scenario: Verify job positions when user views all the open positions without applying any filters in Search By section
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    And User clicks Search button without applying any filters
    Then Verify job search results page is displayed
    And Verify job position count matches the one displayed on job search page
    And Verify Number of job results displayed on the page

  @MyDatTable @Sanity @regression @Test6
  Scenario Outline: Verify user is able to search jobs by Division and is able to see relevant results after applying necessary filters in Search By section
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    And User selects "Division" in Search By section
    And User selects division category and other filters
      | Division Category | Country   | City   | Corporate title   | I want to work | What is your availability? |
      | <div_category>    | <country> | <city> | <corporate_title> | <job_type>     | <availability>             |
    And User clicks Search button
    And Verify job count matches with the total jobs on the page
    And Verify job search results page shows jobs from user has searched
    | City   |What is your availability? |
    | <city> | Full-time             |

    Examples: 
      | div_category   | country | city   | corporate_title          | job_type  | availability |
      | Corporate Bank | India   | Mumbai | Assistant Vice President | Permanent | Full time    |
      | Chairman       | India   | Pune       |                          |           |              |

  @MyDatTable2 @Sanity @regression @Test7
  Scenario Outline: Verify user is able to search jobs by Profession and is able to see relevant results after applying necessary filters in Search By section
    Given User is on Deutsche Bank career page
    When User hovers mouse over Professionals link
    And User clicks on Search Roles
    And User selects "Profession" in Search By section
    And User selects division category and other filters
      | Profession Category | Profession   | Country   | City   | Corporate title   | I want to work | What is your availability? |
      | <prof_category>     | <profession> | <country> | <city> | <corporate_title> | <job_type>     | <availability>             |
    And User clicks Search button
    And Verify job count matches with the total jobs on the page
    And Verify job search results page shows jobs from user has searched
    | City   |What is your availability? |
    | <city> | Full-time             |
    Examples: 
      | prof_category | profession  | country | city      | corporate_title | job_type  | availability |
      | Operations    | Operations  | India   | Mumbai    | Associate       | Permanent | Full time    |
      | Technology    | Engineering | Germany | Frankfurt |                 |           |              |
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
