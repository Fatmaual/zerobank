package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.PayBills;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PB_StepDefinitions {
    PayBills payBills=new PayBills();


    @Then("user should choose a Payee {string}")
    public void user_should_choose_a_Payee(String string) {
        payBills.selectFrom("payee",string);
    }

    @Then("user should choose an Account type {string}")
    public void user_should_choose_an_Account_type(String string) {
        payBills.selectFrom("account",string);
    }
    @Then("user should enter an Amount {string}")
    public void user_should_enter_an_Amount(String string) {
        payBills.enterDataTo(string,"amount");
    }
    @Then("user should enter a Date {string}")
    public void user_should_enter_a_Date(String string) {
        payBills.enterDataTo(string,"date");
    }
    @Then("user should enter a Description {string}")
    public void user_should_enter_a_Description(String string) {
        payBills.enterDataTo(string,"description");
    }
    @Then("user should complete process with {string} button")
    public void user_should_complete_process_with_button(String string) {
        payBills.completeProcess(string);
    }

    @Then("user should verify that success message {string}")
    public void user_should_verify_that_success_message(String string) {
        Assert.assertEquals(string,payBills.getAlert());
    }

    @Then("user should verify that required field message {string}")
    public void user_should_verify_that_required_field_message(String string) {
        Assert.assertEquals(string,payBills.getRequiredFieldAlert());
    }

    @Then("user should verify that amount field doesn't accept alphabetic or special character")
    public void user_should_verify_that_amount_field_doesn_t_accept_alphabetic_or_special_character() {
        Assert.assertTrue(payBills.isEntryCorrect("amount"));
    }

    @Then("user should verify that date field doesn't accept alphabetic character")
    public void user_should_verify_that_date_field_doesn_t_accept_alphabetic_character() {
        Assert.assertTrue(payBills.isEntryCorrect("date"));
    }

    @Then("creates new payee using following information:")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBills.enterDataTo(dataTable.get("Payee Name"),"name");
        payBills.enterDataTo(dataTable.get("Payee Address"),"address");
        payBills.enterDataTo(dataTable.get("Account"),"account");
        payBills.enterDataTo(dataTable.get("Payee Details"),"details");
    }


}
