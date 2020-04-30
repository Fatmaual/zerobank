package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.AccountActivity;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AA_StepDefinitions {

    AccountActivity accountActivity=new AccountActivity();

    @Then("user should navigate to {string} sub-page")
    public void user_should_navigate_to_sub_page(String string) {
        System.out.println("Navigate to "+string);
        accountActivity.navigateToSubPage(string);
    }

    @Then("user should verify that account option is {string}")
    public void user_should_verify_that_account_option_is(String string) {
        System.out.println("Verify default account is "+string);
        Assert.assertEquals(string,accountActivity.getSelectedOption());
    }

    @Then("user should verify that account options:")
    public void user_should_verify_that_account_options(List<String> dataTable) {
        System.out.println("Verify account types: "+dataTable);
        Assert.assertTrue(accountActivity.isContainsOptions(dataTable));
    }

}
