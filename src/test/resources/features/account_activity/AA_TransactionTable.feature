@account_activity
Feature: Account Activity
  As user, I want to be able to see Transaction table columns.

  @transaction_columns
  Scenario: Account Activity - Transactions module should have columns
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Activity" page
    And user should navigate to "Show Transactions" sub-page
    Then user should verify following table columns from "Show Transactions":
      |Date       |
      |Description|
      |Deposit    |
      |Withdrawal|