package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ZeroBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    protected boolean isInputFieldEmpty;
    protected String emptyField;


    public ZeroBase(){
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for module navigation. Provide tab module to navigate
     * @param module like:
     *               Account Summary
     *               Account Activity
     *               Transfer Funds
     *               Pay Bills
     *               My Money Map
     *               Online Statements
     */
    public void navigateTo(String module){
        driver.findElement(By.xpath("//ul[@class=\"nav nav-tabs\"]//a[text()='"+module+"']")).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    /**
     * This method navigates between sub modules
     * @param module should get sub-module name:
     *              "Show Transactions"
     *              "Find Transactions"
     */
    public void navigateToSubPage(String module){
        driver.findElement(By.linkText(module)).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    /**
     * Helps you to find columns names
     * @param from should get header name
     * @return list of column names
     */
    public List<String> getColumnNames(String from){
        List<WebElement> columns=driver.findElements(By.xpath("(//h2[text()='"+from+"']//following-sibling::div//tr)[1]//th"));
        return BrowserUtils.getTextFromWebElements(columns);
    }


    /**
     * Helps you to select from designated drop down
     * @param selectElementName accepts Element ID
     */
    public void selectFrom(String selectElementName, String optionText){
        new Select(driver.findElement(By.name(selectElementName))).selectByVisibleText(optionText);
    }


    /**
     * This method checks that input has alphabetic characters or not
     * @param element input WebElement
     * @return true if any alphabetic character entered
     *         false if only alphabetic character not entered
     *
     */
    public boolean isInputFieldContainsAlphabeticChar(WebElement element){
        String data=element.getAttribute("value");
        return !data.equals("")&& data!=null && data.matches(".*[a-zA-Z].*");
    }

    /**
     * This method checks that input has special character or not
     * @param element input WebElement
     * @return  true if any special character entered
     *          false if any special character not entered
     *
     */
    public  boolean isInputFieldContainsSpecialChar(WebElement element){
        String data=element.getAttribute("value");
        return !data.equals("")&& data!=null && data.matches(".*[^a-zA-Z0-9 ].*");
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
        if(element.equals("account")){
            driver.findElement(By.xpath("//input[@name='account']")).sendKeys(data);
        }else{
            driver.findElement(By.name(element)).clear();
            driver.findElement(By.name(element)).sendKeys(data);
        }

    }

    /**
     * This method used to determine provided options are available in a drop down
     *
     * @param data provided List of data
     * @return false if the options doesn't exist. Returns true else.
     */
    public boolean isContainsOptions(List<String> data, String id) {
        for (String e : data) {
            if (!getOptions(id).contains(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method returns available options in a drop-down menu
     * @param id drop-down element ID
     * @return Text of options
     */
    public List<String> getOptions(String id) {
        return BrowserUtils.getTextFromWebElements(new Select(driver.findElement(By.id(id))).getOptions());
    }

    /**
     * This method returns selected account type
     *
     * @return string data
     */
    public String getSelectedOption(String id) {
        return new Select(driver.findElement(By.id(id))).getFirstSelectedOption().getText();
    }



}
