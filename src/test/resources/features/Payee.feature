@payee_feature
Feature: Add new payee under pay bills

  Background: User should logs in an navigate to Account Activity - Find Transactions
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Add New Payee" sub-page

  Scenario:    Add	a new	payee
    And creates new payee using following information:
      | Payee Name    | The Law Offices of Hyde Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001        |
      | Account       | Checking                                |
      | Payee Details | XYZ account                             |
    Then user should complete process with "Add" button
    And user should verify that success message "The new payee The Law Offices of Hyde Price & Scharks was successfully created."
