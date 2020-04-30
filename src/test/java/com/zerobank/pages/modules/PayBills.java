package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PayBills extends ZeroBase {

    /**
     * This method for data entry
     * @param data input data
     * @param element web element name
     */
    public void enterDataTo(String data, String element){
        driver.findElement(By.name(element)).sendKeys(data);
    }

    /**
     * This method helps you to click process for sub-module's complete button
     * @param processName should get:
     *                    Pay for Pay Saved Payee module
     *                    Add for Add New Payee module
     *                    Purchase for Purchase Foreign Currency module
     */
    public void completeProcess(String processName){
        driver.findElement(By.cssSelector("input[value='"+processName+"']")).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    /**
     * This method returns process result message
     * @return message as String
     */
    public String getAlert(){
       return driver.findElement(By.id("alert_content")).getText();
    }

    /**
     * This method returns required field message if required field leaved empty
     * @return message as String
     */
    public String getRequiredFieldAller(String field){

        WebElement inputElement = driver.findElement(By.name(field));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String)js.executeScript("return arguments[0].validationMessage;", inputElement);
    }
}
