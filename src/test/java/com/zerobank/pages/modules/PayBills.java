package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
        driver.findElement(By.name(element.toLowerCase())).sendKeys(data);
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
            System.out.println("Entered data for Amount --->"+driver.findElement(By.name(elementName)).getAttribute("value"));
            System.out.println("contains alhabet: "+isInputFieldContainsAlphabeticChar(inputElement));
            System.out.println("contains special: "+isInputFieldContainsSpecialChar(inputElement));
            return !(isInputFieldContainsAlphabeticChar(inputElement) || isInputFieldContainsSpecialChar(inputElement));
        }
        else if (elementName.equalsIgnoreCase("date")){
            System.out.println("Entered data for date --->"+driver.findElement(By.name(elementName)).getAttribute("value"));
            System.out.println("contains alhabet: "+isInputFieldContainsAlphabeticChar(inputElement));
            return !(isInputFieldContainsAlphabeticChar(inputElement));
        }
        return false;
    }


}
