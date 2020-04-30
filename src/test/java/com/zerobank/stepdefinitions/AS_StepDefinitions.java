package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.AccountSummary;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AS_StepDefinitions {
    AccountSummary accountSummary=new AccountSummary();

    @Then("user should navigate to {string} page")
    public void user_should_navigate_to_page(String string) {
        System.out.println("Navigate to "+string);
        accountSummary.navigateTo(string);
    }


    @Then("user should verify that these account types:")
    public void user_should_verify_that_these_account_types(List<String> dataTable) {
        System.out.println("Verify account types: "+dataTable);
        Assert.assertEquals(dataTable,accountSummary.getAccountTypes());
    }


    @Then("user should verify following table columns from {string}:")
    public void user_should_verify_following_table_columns_from(String string, List<String> dataTable) {
        System.out.printf("Verify %s table columns: %s",string,dataTable);
        Assert.assertEquals(dataTable,accountSummary.getColumnNames(string));
    }


}
