package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();
            byte[] image=takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("\nTest clean up");
        Driver.closeDriver();
    }
}
