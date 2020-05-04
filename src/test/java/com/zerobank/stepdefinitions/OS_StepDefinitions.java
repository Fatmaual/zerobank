package com.zerobank.stepdefinitions;

import com.zerobank.pages.modules.OnlineStatement;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OS_StepDefinitions {
    OnlineStatement onlineStatement=new OnlineStatement();

    @When("the user selects the Recent Statements Year {string}")
    public void the_user_selects_the_Recent_Statements_Year(String string) {
        onlineStatement.navigateToStatement(string);
    }

    @Then("{string} statements {string} should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(String string, String string2) {
        Assert.assertTrue(onlineStatement.isDisplayed(string,string2));
    }

    @When("the user clicks on on statement {string}")
    public void the_user_clicks_on_on_statement(String string) {
        onlineStatement.navigateToStatement(string);
        BrowserUtils.wait(10);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(onlineStatement.isDownloaded(string));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(onlineStatement.isDownloadedType("pdf"));
    }
}
