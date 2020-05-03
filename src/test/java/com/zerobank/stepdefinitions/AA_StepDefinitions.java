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
         Assert.assertTrue(accountActivity.isItInTheRange(from,to,new AccountActivity().getDataFromTable("Date")));
    }

    @Then("the results	should be sorted by	most recent	date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(accountActivity.isItSortedRecentToOld(new AccountActivity().getDataFromTable("Date")));
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        Assert.assertFalse(accountActivity.isDateListed(string,new AccountActivity().getDataFromTable("Date")));
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(accountActivity.isDataListed(string,new AccountActivity().getDataFromTable("Description")));
    }

    @Then("the results table should not show description containing {string}")
    public void the_results_table_should_not_show_description_containing(String string) {
        Assert.assertFalse(accountActivity.isDataListed(string,new AccountActivity().getDataFromTable("Description")));
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
       Assert.assertTrue(accountActivity.isDataListed(new AccountActivity().getDataFromTable(string)));
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
       accountActivity.selectFrom("type",string);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        Assert.assertFalse(accountActivity.isDataListed(new AccountActivity().getDataFromTable(string)));
    }








}
