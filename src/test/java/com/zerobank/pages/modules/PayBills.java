package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PayBills extends ZeroBase {

    private boolean isInputFieldEmpty;
    private String emptyField;

    /**
     * This method returns empty field name
     * @return
     */
    public String getEmptyField() {
        return emptyField;
    }

    /**
     * This method for data entry
     * @param data input data
     * @param element web element name
     */
    public void enterDataTo(String data, String element){
        if(data.equals("")){
            isInputFieldEmpty=true;
            emptyField=element;
        }
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
    public String getRequiredFieldAlert(){
        return (String)((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", driver.findElement(By.name(emptyField)));
    }
}
