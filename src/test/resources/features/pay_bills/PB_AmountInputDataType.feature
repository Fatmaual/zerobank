@pay_bills
Feature: Pay Bills
  As user, I should not able to enter alphabetic or special character to amount field.

  @pay_bill_amount_alphabetic_special
  Scenario Outline: Amount field should not accept alphabetical or special characters.
    Given user in the login page
    When users logs in with valid credentials
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Pay Saved Payee" sub-page
    Then user should choose a Payee "<Payee>"
    Then user should choose an Account type "<Account>"
    Then user should enter an Amount "<Amount>"
    Then user should enter a Date "<Date>"
    Then user should enter a Description "<Description>"
    And user should verify that amount field doesn't accept alphabetic or special character

    Examples:
      | Payee             | Account     | Amount  | Date      | Description  |
      | Sprint            | Savings     | test    |2020-05-10| Test payment |
      | Sprint            | Savings     | $$$$$$$$| 2020-05-10| Test payment |
      | Sprint            | Checking    | 1000    |2020-05-10| Test payment |
      | Sprint            | Checking    | 1000| 2020-05-10| Test payment |
      | Sprint            | Loan        | te100st    |2020-05-10| Test payment |
      | Sprint            | Loan        | $$$100$$$$$| 2020-05-10| Test payment |
      | Sprint            | Credit Card | $$aa100    |2020-05-10| Test payment |
      | Sprint            | Credit Card | $$$$$$$$| 2020-05-10| Test payment |
      | Sprint            | Brokerage   | test    |2020-05-10| Test payment |
      | Sprint            | Brokerage   | $$$$$$$$| 2020-05-10| Test payment |
      | Bank of America   | Savings     | test    |2020-05-10| Test payment |
      | Bank of America   | Savings     | $$$$$$$$| 2020-05-10| Test payment |
      | Bank of America   | Checking    | test    |2020-05-10| Test payment |
      | Bank of America   | Checking    | $$$$$$$$| 2020-05-10| Test payment |
      | Bank of America   | Loan        | test    |2020-05-10| Test payment |
      | Bank of America   | Loan        | $$$$$$$$| 2020-05-10| Test payment |
      | Bank of America   | Credit Card | test    |2020-05-10| Test payment |
      | Bank of America   | Credit Card |$$$$$$$$| 2020-05-10| Test payment |
      | Bank of America   | Brokerage   | test    |2020-05-10| Test payment |
      | Bank of America   | Brokerage   | $$$$$$$$| 2020-05-10| Test payment |
      | Apple            | Savings     | test    |2020-05-10| Test payment |
      | Apple            | Savings     | $$$$$$$$| 2020-05-10| Test payment |
      | Apple            | Checking    | test    |2020-05-10| Test payment |
      | Apple            | Checking    | $$$$$$$$| 2020-05-10| Test payment |
      | Apple            | Loan        | test    |2020-05-10| Test payment |
      | Apple            | Loan        | $$$$$$$$| 2020-05-10| Test payment |
      | Apple            | Credit Card | test    |2020-05-10| Test payment |
      | Apple            | Credit Card | $$$$$$$$| 2020-05-10| Test payment |
      | Apple            | Brokerage   | test    |2020-05-10| Test payment |
      | Apple            | Brokerage   | $$$$$$$$| 2020-05-10| Test payment |
      | Wells Fargo   | Savings     | test    |2020-05-10| Test payment |
      | Wells Fargo   | Savings     | $$$$$$$$| 2020-05-10| Test payment |
      | Wells Fargo   | Checking    | test    |2020-05-10| Test payment |
      | Wells Fargo   | Checking    | $$$$$$$$| 2020-05-10| Test payment |
      | Wells Fargo   | Loan        | test    |2020-05-10| Test payment |
      | Wells Fargo   | Loan        | $$$$$$$$| 2020-05-10| Test payment |
      | Wells Fargo   | Credit Card | test    |2020-05-10| Test payment |
      | Wells Fargo   | Credit Card |$$$$$$$$| 2020-05-10| Test payment |
      | Wells Fargo   | Brokerage   | test    |2020-05-10| Test payment |
      | Wells Fargo   | Brokerage   |$$$$$$$$| test-05-10| Test payment |

