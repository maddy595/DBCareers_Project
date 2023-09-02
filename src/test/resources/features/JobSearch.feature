Feature: Navigation to Job Search
  Description: 	This feature focuses on navigating to job search page via different routes and vlidating links on the page.

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
    And On clicking Search Roles under professionsal tab user is able to view Jobs search page
    And On clicking more button under professionsal section user is able to view Jobs search page
    And On clicking View and Apply button on Your application user is able to view Jobs search page

  @Sanity @regression @Test1
  Scenario: Verify that all the links on Careers page are working
    Given User is on Deutsche Bank career page
    When User clicks on Professionals link
    And User check for any broken links on the page
    Then There should be no broken links on the page
