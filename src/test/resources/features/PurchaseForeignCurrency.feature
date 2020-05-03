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
