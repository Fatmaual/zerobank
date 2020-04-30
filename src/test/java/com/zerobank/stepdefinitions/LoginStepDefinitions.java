package com.zerobank.stepdefinitions;

import com.zerobank.pages.Login;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    Login login=new Login();

    @Given("user in on the login page")
    public void user_in_on_the_login_page(){
        System.out.println("Open Login Page...");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("users logs in with valid credentials")
    public void users_logs_in_with_valid_credentials() {
        System.out.println("Login with valid credentials...");
        login.login();
    }


    @When("users try to log in with invalid username {string}")
    public void users_try_to_log_in_with_invalid_username(String string) {
        System.out.printf("Login with username: %s",string);
        login.login(string,ConfigurationReader.getProperty("password"));
    }


    @When("users try to log in with invalid password {string}")
    public void users_try_to_log_in_with_invalid_password(String string) {
        System.out.printf("Login with password: %s",string);
        login.login(ConfigurationReader.getProperty("username"),string);
    }

    @When("users try to log in with blank user name")
    public void users_try_to_log_in_with_blank_user_name() {
        System.out.println("Login with blank username...");
        login.login("",ConfigurationReader.getProperty("password"));
    }
    @When("users try to log in with blank password")
    public void users_try_to_log_in_with_blank_password() {
        System.out.println("Login with blank password...");
        login.login(ConfigurationReader.getProperty("username"),"");
    }


    @Then("user should verify that title is {string}")
    public void user_should_verify_that_title_is(String string) {
        System.out.println("Verify title is a Zero - Account Summary");
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals(string,Driver.getDriver().getTitle());
    }

    @Then("user should verify that error message is {string}")
    public void user_should_verify_that_error_message_is(String string) {
        System.out.printf("Verify error message is %s ",string);
        Assert.assertEquals(string,login.getErrorMessage());
    }




}
