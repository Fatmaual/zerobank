package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends ZeroBase {



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

    /**
     * This method checks the date range from listed table
     * @return true if it is in the range
     *          false if it is not in the range
     *
     *          List<String> dates has data: {"2012-09-06","2012-09-05","2012-09-01"}
     */
    public boolean isItInTheRange(String from,String to,List<String> dates){
        for (String date: dates) {
            String[] splitedDate=date.split("-");
            String[] splitedFrom=from.split("-");
            String[] splitedTo=to.split("-");
            for(int i=0;i<3;i++){

                if(Integer.parseInt(splitedDate[i])<Integer.parseInt(splitedFrom[i] )|| Integer.parseInt(splitedDate[i])>Integer.parseInt(splitedTo[i])){
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Get all dates as String from filtered transaction table
     * @return
     */
    public List<String> getDates(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("filtered_transactions_for_account"))));
        return BrowserUtils.getTextFromWebElements(driver.findElements(By.xpath("//div[@id=\"filtered_transactions_for_account\"]//tr//td[1]")));
    }

}
