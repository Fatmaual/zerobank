package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.AccountActivity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AA_StepDefinitions {

    AccountActivity accountActivity=new AccountActivity();

    @Then("user should navigate to {string} sub-page")
    public void user_should_navigate_to_sub_page(String string) {
        accountActivity.navigateToSubPage(string);
    }

    @Then("user should verify that account option is {string}")
    public void user_should_verify_that_account_option_is(String string) {
        Assert.assertEquals(string,accountActivity.getSelectedOption());
    }

    @Then("user should verify that account options:")
    public void user_should_verify_that_account_options(List<String> dataTable) {
        Assert.assertTrue(accountActivity.isContainsOptions(dataTable));
    }


    @When("^the user enters date range from \"(.*)\" to \"(.*)\"$")
    public void the_user_enters_date_range_from_to(String from, String to) {
        accountActivity.enterDataTo(from,"fromDate");
        accountActivity.enterDataTo(to,"toDate");
    }

    @Then("^results table should only show transactions dates between \"(.*)\" to \"(.*)\"$")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {
         Assert.assertTrue(accountActivity.isItInTheRange(from,to,accountActivity.getDates()));

    }


}
