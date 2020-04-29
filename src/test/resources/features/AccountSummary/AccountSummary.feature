@account_summary
Feature: Account Summary
  As user, I want to be able to see Account Summary page title.

  @page_title
  Scenario: Account summary page should have the title Zero - Account summary
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Summary" page
    And user should verify that title is a Zero - Account Summary


