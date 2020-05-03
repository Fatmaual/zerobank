package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayBills extends ZeroBase {



    /**
     * This method returns empty field name
     * @return
     */
    public String getEmptyField() {
        return emptyField;
    }


    /**
     * This method helps you to click process for sub-module's complete button
     * @param processName should get:
     *                    Pay for Pay Saved Payee module
     *                    Add for Add New Payee module
     *                    Purchase for Purchase Foreign Currency module
     */
    public void completeProcess(String processName){
        By element;
        if(processName.equalsIgnoreCase("Pay")||processName.equalsIgnoreCase("Add")||processName.equalsIgnoreCase("Purchase")){
            element=By.cssSelector("input[value='"+processName+"']");

        }else{
            element=By.xpath("//button[text()='"+processName+"']");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).click();
        BrowserUtils.wait(2);
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


    /**
     * This method checks entry type and returns if it is
     * @param elementName input field name
     * @return true if entry type correct
     *         false if entry type wrong
     *
     */
    public boolean isEntryCorrect(String elementName){
        WebElement inputElement=driver.findElement(By.name(elementName.toLowerCase()));
        if(elementName.equalsIgnoreCase("amount")){
            return !(isInputFieldContainsAlphabeticChar(inputElement) || isInputFieldContainsSpecialChar(inputElement));
        }
        else if (elementName.equalsIgnoreCase("date")){
            return !(isInputFieldContainsAlphabeticChar(inputElement));
        }
        return false;
    }


}
