@pay_bills_foreign_currency
Feature: Purchase Foreign Currency

  Background: User should logs in an navigate to Account Activity - Find Transactions
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Purchase Foreign Currency" sub-page

  Scenario: Available	currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China yuan)           |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New	Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario:	Error	message for	not	selecting	currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed


  Scenario:	Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed