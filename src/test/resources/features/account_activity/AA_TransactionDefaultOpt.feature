@account_activity
Feature: Account Activity
  As user, I want to be able to see Savings as default option in Account drop down.

  @default_account_option
  Scenario: In Account Activity, account drop down should have the default Savings option
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Activity" page
    And user should navigate to "Show Transactions" sub-page
    Then user should verify that account option is "Savings"