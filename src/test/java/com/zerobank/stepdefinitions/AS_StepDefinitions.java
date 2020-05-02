package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.AccountSummary;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AS_StepDefinitions {
    AccountSummary accountSummary=new AccountSummary();

    @Then("user should navigate to {string} page")
    public void user_should_navigate_to_page(String string) {
        accountSummary.navigateTo(string);
    }


    @Then("user should verify that these account types:")
    public void user_should_verify_that_these_account_types(List<String> dataTable) {
        Assert.assertEquals(dataTable,accountSummary.getAccountTypes());
    }


    @Then("user should verify following table columns from {string}:")
    public void user_should_verify_following_table_columns_from(String string, List<String> dataTable) {
        Assert.assertEquals(dataTable,accountSummary.getColumnNames(string));
    }

    @When("the user clicks on	{string} link on the {string} page")
    public void the_user_clicks_on_link_on_the_page(String string, String string2) {
        accountSummary.navigateTo(string2);
        accountSummary.openCreatedAccount(string);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }


}
