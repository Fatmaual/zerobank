package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ZeroBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);


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
        List<WebElement> tabs=driver.findElements(By.xpath("//ul[@class=\"nav nav-tabs\"]//a"));
        for (WebElement tab:tabs) {
            if(tab.getText().equalsIgnoreCase(module)){
                tab.click();
                break;
            }
        }
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

}
