@account_summary
Feature: Account Summary
  As user, I want to be able to see Credit Accounts table on Account Summary page.

  @account_type_columns
  Scenario: Credit Accounts table should have "Account, Credit Card, Balance" tables
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Summary" page
    And user should verify following table columns from "Credit Accounts":
    |Account|
    |Credit Card|
    |Balance|