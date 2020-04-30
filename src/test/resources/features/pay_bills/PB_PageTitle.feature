@pay_bills
Feature: Pay Bills
  As user, I want to be able to see Pay Bills page title.

  @pay_bills_title
  Scenario: Pay Bills page should have the title Zero - Pay Bills
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should verify that title is "Zero - Pay Bills"
