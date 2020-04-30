package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.PayBills;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PB_StepDefinitions {
    PayBills payBills=new PayBills();

    private boolean isInputFieldEmpty;
    private String emptyField;


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
    @Then("user should enter an Amount {string}")
    public void user_should_enter_an_Amount(String string) {
        System.out.println("Enter amount : "+string);
        if(string.equals("")){
            isInputFieldEmpty=true;
            emptyField="amount";
        }
        payBills.enterDataTo(string,"amount");
    }
    @Then("user should enter a Date {string}")
    public void user_should_enter_a_Date(String string) {
        System.out.println("Enter date : "+string);
        if(string.equals("")){
            isInputFieldEmpty=true;
            emptyField="date";
        }
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

    @Then("user should verify that required field message {string}")
    public void user_should_verify_that_required_field_message(String string) {

        System.out.println("empty field is -> "+emptyField);
        if(isInputFieldEmpty){
            Assert.assertEquals(string,payBills.getRequiredFieldAller(emptyField));
        }
    }




}
