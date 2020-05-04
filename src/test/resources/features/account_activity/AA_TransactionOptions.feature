@account_activity
Feature: Account Activity
  As user, I want to be able to see account options in Account drop down.

  @account_options
  Scenario: In Account Activity, account drop down should have the "Savings, Checking, Loan, Credit Card, Brokerage"
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Activity" page
    And user should navigate to "Show Transactions" sub-page
    Then user should verify that account options:
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |