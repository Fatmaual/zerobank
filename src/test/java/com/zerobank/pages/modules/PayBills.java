package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
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

    /**
     * This method verifies is alert displayed or not
     * @return true if alert displayed
     */
    public boolean isWarningMessageDisplayed(){
        return driver.switchTo().alert().getText().equals("Please, ensure that you have filled all the required fields with valid values.");
    }

    /**
     * Enter amount for foreign currency purchase
     * @param amount
     */
    public void enterAmount(String amount){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='pc_amount']")));
        driver.findElement(By.xpath("//input[@id='pc_amount']")).click();
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys(amount);
    }


}
