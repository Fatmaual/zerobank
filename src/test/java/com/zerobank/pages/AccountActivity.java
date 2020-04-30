package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends ZeroBase {


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
     * This method returns available account options in Show Transactions sub-module
     * @return Text of options
     */
    public List<String> getAccountOptions(){
        return BrowserUtils.getTextFromWebElements(new Select(driver.findElement(By.id("aa_accountId"))).getOptions());
    }

    /**
     * This method returns selected account type
     * @return string data
     */
    public String getSelectedOption(){
       return new Select(driver.findElement(By.id("aa_accountId"))).getFirstSelectedOption().getText();
    }

    /**
     * This method used to determine provided account options are available in account drop down
     * @param data provided List of account types
     * @return false if the options doesn't exist. Returns true else.
     */
    public boolean isContainsOptions(List<String> data){
        for (String e : data) {
            if(!getAccountOptions().contains(e)){
                return false;
            }
        }
        return true;
    }

}
