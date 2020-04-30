@pay_bills
Feature: Pay Bills
  As user, I want to be able to see successful Pay operation message.

  @pay_bill_success_message
  Scenario Outline: Successful Pay operation should give "The payment was successfully submitted." message.
    Given user in on the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Pay Saved Payee" sub-page
    Then user should choose a Payee "<Payee>"
    Then user should choose an Account type "<Account>"
    Then user should enter an Amount "<Amount>"
    Then user should enter a Date "<Date>"
    And user should enter a Description "<Description>"
    Then user should complete process with "Pay" button
    And user should verify that success message "The payment was successfully submitted."

    Examples:
    | Payee             | Account     | Amount  | Date      | Description  |
    | Sprint            | Savings     | 1000    | 2020-05-10| Test payment |
    | Sprint            | Checking    | 1000    | 2020-05-10| Test payment |
    | Sprint            | Loan        | 1000    | 2020-05-10| Test payment |
    | Sprint            | Credit Card | 1000    | 2020-05-10| Test payment |
    | Sprint            | Brokerage   | 1000    | 2020-05-10| Test payment |
    | Bank of America   | Savings     | 1000    | 2020-05-10| Test payment |
    | Bank of America   | Checking    | 1000    | 2020-05-10| Test payment |
    | Bank of America   | Loan        | 1000    | 2020-05-10| Test payment |
    | Bank of America   | Credit Card | 1000    | 2020-05-10| Test payment |
    | Bank of America   | Brokerage   | 1000    | 2020-05-10| Test payment |
    | Apple             | Savings     | 1000    | 2020-05-10| Test payment |
    | Apple             | Checking    | 1000    | 2020-05-10| Test payment |
    | Apple             | Loan        | 1000    | 2020-05-10| Test payment |
    | Apple             | Credit Card | 1000    | 2020-05-10| Test payment |
    | Apple             | Brokerage   | 1000    | 2020-05-10| Test payment |
    | Wells Fargo       | Savings     | 1000    | 2020-05-10| Test payment |
    | Wells Fargo       | Checking    | 1000    | 2020-05-10| Test payment |
    | Wells Fargo       | Loan        | 1000    | 2020-05-10| Test payment |
    | Wells Fargo       | Credit Card | 1000    | 2020-05-10| Test payment |
    | Wells Fargo       | Brokerage   | 1000    | 2020-05-10| Test payment |