@find_transaction
Feature: Find Transactions in Account Activity
  @account_activity_search_data
  Scenario:	Search date range
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Account Activity" page
    Then user should navigate to "Find Transactions" sub-page
    When the user enters date range from "2012-09-01" to "2012-09-06"
    Then user should complete process with "Find" button
    #Then results table should only show transactions dates between “2012-09-01” to “2012-09-06”
