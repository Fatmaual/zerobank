@pay_bills
Feature: Pay Bills
  As user, I should not able to enter alphabetic character to date field.

  @pay_bill_date_alphabetic
  Scenario Outline: Date field should not accept alphabetical characters.
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Pay Saved Payee" sub-page
    Then user should choose a Payee "<Payee>"
    Then user should choose an Account type "<Account>"
    Then user should enter an Amount "<Amount>"
    Then user should enter a Date "<Date>"
    Then user should enter a Description "<Description>"
    And user should verify that date field doesn't accept alphabetic character

    Examples:
      | Payee             | Account     | Amount  | Date      | Description  |
      | Sprint            | Savings     | 1000    |aaaaaa| Test payment |
      | Sprint            | Savings     | 1000| 202aa0-05-10| Test payment |
      | Sprint            | Checking    | 1000    |2020-0a5-10| Test payment |
      | Sprint            | Checking    | 1000| 2020-a05-10| Test payment |
      | Sprint            | Loan        | 1000    |2a020-05-10| Test payment |
      | Sprint            | Loan        | 1000| 2020-05-1a0| Test payment |
      | Sprint            | Credit Card | 1000    |20a20-05-10| Test payment |
      | Sprint            | Credit Card | 1000| 2020-05-10| Test payment |
      | Sprint            | Brokerage   | 1000    |2020-05-10| Test payment |
      | Sprint            | Brokerage   | 1000| 2020-05-10| Test payment |
      | Bank of America   | Savings     | 1000    |2020-05-10| Test payment |
      | Bank of America   | Savings     | 1000| 2020-05-10| Test payment |
      | Bank of America   | Checking    | 1000    |2020-05-10| Test payment |
      | Bank of America   | Checking    | 1000| 2020-05-10| Test payment |
      | Bank of America   | Loan        | 1000    |2020-05-10| Test payment |
      | Bank of America   | Loan        | 1000| 2020-05-10| Test payment |
      | Bank of America   | Credit Card | 1000    |2020-05-10| Test payment |
      | Bank of America   | Credit Card |1000| 2020-05-10| Test payment |
      | Bank of America   | Brokerage   | 1000    |2020-05-10| Test payment |
      | Bank of America   | Brokerage   | 1000| 2020-05-10| Test payment |
      | Apple            | Savings     | 1000    |2020-05-10| Test payment |
      | Apple            | Savings     | 1000| 2020-05-10| Test payment |
      | Apple            | Checking    | 1000    |2020-05-10| Test payment |
      | Apple            | Checking    | 1000| 2020-05-10| Test payment |
      | Apple            | Loan        | 1000    |2020-05-10| Test payment |
      | Apple            | Loan        | 1000| 2020-05-10| Test payment |
      | Apple            | Credit Card | 1000    |2020-05-10| Test payment |
      | Apple            | Credit Card | 1000| 2020-05-10| Test payment |
      | Apple            | Brokerage   | 1000    |2020-05-10| Test payment |
      | Apple            | Brokerage   | 1000| 2020-05-10| Test payment |
      | Wells Fargo   | Savings     | 1000    |2020-05-10| Test payment |
      | Wells Fargo   | Savings     | 1000| 2020-05-10| Test payment |
      | Wells Fargo   | Checking    | 1000    |2020-05-10| Test payment |
      | Wells Fargo   | Checking    | 1000| 2020-05-10| Test payment |
      | Wells Fargo   | Loan        | 1000    |2020-05-10| Test payment |
      | Wells Fargo   | Loan        | 1000| 2020-05-10| Test payment |
      | Wells Fargo   | Credit Card | 1000    |2020-05-10| Test payment |
      | Wells Fargo   | Credit Card |1000| 2020-05-10| Test payment |
      | Wells Fargo   | Brokerage   | 1000    |2020-05-10| Test payment |
      | Wells Fargo   | Brokerage   |1000| test-05-10| Test payment |

