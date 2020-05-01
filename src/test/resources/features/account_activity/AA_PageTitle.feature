@account_activity
Feature: Account Activity
  As user, I want to be able to see Account Activity page title.

  @account_activity_page_title
  Scenario: Account Activity page should have the title Zero - Account Activity
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Activity" page
    And user should verify that title is "Zero - Account Activity"


