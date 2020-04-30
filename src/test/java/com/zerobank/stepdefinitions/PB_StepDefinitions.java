package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.PayBills;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PB_StepDefinitions {
    PayBills payBills=new PayBills();

    @Then("user should choose a Payee {string}")
    public void user_should_choose_a_Payee(String string) {
        System.out.println("Choose Payee : "+string);
        payBills.selectFrom("payee",string);
    }

    @Then("user should choose an Account type {string}")
    public void user_should_choose_an_Account_type(String string) {
        System.out.println("Choose Account : "+string);
        payBills.selectFrom("account",string);
    }
    @Then("user should enter an Amount\"{int}\"")
    public void user_should_enter_an_Amount(Integer int1) {
        System.out.println("Enter amount : "+int1);
        payBills.enterDataTo(int1.toString(),"amount");
    }
    @Then("user should enter a Date {string}")
    public void user_should_enter_a_Date(String string) {
        System.out.println("Enter date : "+string);
        payBills.enterDataTo(string,"date");
    }
    @Then("user should enter a Description {string}")
    public void user_should_enter_a_Description(String string) {
        System.out.println("Enter Description : "+string);
        payBills.enterDataTo(string,"description");
    }
    @Then("user should complete process with {string} button")
    public void user_should_complete_process_with_button(String string) {
        System.out.println("Complete process with clicking to "+string);
        payBills.completeProcess(string);
    }
    @Then("user should verify that success message {string}")
    public void user_should_verify_that_success_message(String string) {
        Assert.assertEquals(string,payBills.getAlert());
    }




}
