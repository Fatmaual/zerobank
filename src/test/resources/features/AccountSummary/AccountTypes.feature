@account_types
Feature: Account Summary
  As user, I want to be able to see account types on Account Summary page.

  @account_type
  Scenario: Account summary page should have "Cash Accounts, Investment Accounts,Credit Accounts,Loan Accounts"account types
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Summary" page
    And user should verify that these account types:
      | Cash Accounts |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts      |