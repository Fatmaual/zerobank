@login
Feature: Login
  As user, I want to be able to login with username and password

  Background: open login page
    Given user in the login page

    @valid_user
    Scenario: Login with valid credentials and verify that title is Zero - Account Summary
      When users logs in with valid credentials
      Then user should verify that title is "Zero - Account Summary"

    @wrong_user_name
    Scenario: Login with invalid user name credentials and verify that error message is Login and/or password are wrong.
        When users try to log in with invalid username "test"
        Then user should verify that error message is "Login and/or password are wrong."
    @wrong_user_password
    Scenario: Login with invalid password credentials and verify that error message is Login and/or password are wrong.
        When users try to log in with invalid password "test"
        Then user should verify that error message is "Login and/or password are wrong."

    @blank_user_name
    Scenario: Login with blank user name credentials and verify that error message is Login and/or password are wrong.
        When users try to log in with blank user name
        Then user should verify that error message is "Login and/or password are wrong."

    @blank_password
    Scenario: Login with blank password credentials and verify that error message is Login and/or password are wrong.
        When users try to log in with blank password
        Then user should verify that error message is "Login and/or password are wrong."