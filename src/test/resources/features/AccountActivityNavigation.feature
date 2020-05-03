@account_activity_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background: Login with valid credentials
    Given user in the login page
    When users logs in with valid credentials

  Scenario:	Savings	account	redirect
    When the user clicks on	"Savings" link on the "Account Summary" page
    Then the "Account Activity" page should be displayed
    And user should verify that account option is "Savings"

  Scenario:	Savings	account	redirect
    When the user clicks on	"Brokerage" link on the "Account Summary" page
    Then the "Account Activity" page should be displayed
    And user should verify that account option is "Brokerage"

  Scenario:	Savings	account	redirect
    When the user clicks on	"Checking" link on the "Account Summary" page
    Then the "Account Activity" page should be displayed
    And user should verify that account option is "Checking"

  Scenario:	Savings	account	redirect
    When the user clicks on	"Credit Card" link on the "Account Summary" page
    Then the "Account Activity" page should be displayed
    And user should verify that account option is "Credit Card"

  Scenario:	Savings	account	redirect
    When the user clicks on	"Loan" link on the "Account Summary" page
    Then the "Account Activity" page should be displayed
    And user should verify that account option is "Loan"

