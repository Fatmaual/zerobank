package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
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
        LocalDate fromDate=LocalDate.parse(from);
        LocalDate toDate=LocalDate.parse(to);
        for (String date: dates) {
            LocalDate scrappedDate=LocalDate.parse(date);
            if(!(fromDate.isBefore(scrappedDate)||fromDate.isEqual(scrappedDate))){
                System.out.println(fromDate+" is not before or equal "+scrappedDate);
                return false;
            }
            else if(!(toDate.isAfter(scrappedDate)||toDate.isEqual(scrappedDate))){
                System.out.println(fromDate+" is not before or equal "+scrappedDate);
                return false;
            }

        }
        return true;
    }

    /**
     * Get all dates as String from filtered transaction table
     * @return Listed transaction dates as List<String>
     */
    public List<String> getDates(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("filtered_transactions_for_account"))));
        return BrowserUtils.getTextFromWebElements(driver.findElements(By.xpath("//div[@id=\"filtered_transactions_for_account\"]//td[1]")));
    }

    /**
     * This method help you to check whether they are sorted or not
     *
     * @param dates List<String> dates has data: {"2012-09-06","2012-09-05","2012-09-01"}
     * @return true if it is ordered as most recet date to old date exp: {"2012-09-06","2012-09-05","2012-09-01"}
     *         false if it is not ordered as the most recet date to old date exp: {"2012-09-01","2012-09-05","2012-09-09"}
     */
    public boolean isItSortedRecentToOld(List<String> dates){
        LocalDate tmpDate=LocalDate.parse(dates.get(0));
        for (int i=0;i<dates.size();i++) {
            LocalDate scrappedDate=LocalDate.parse(dates.get(i));
            if(!(tmpDate.isEqual(scrappedDate)||tmpDate.isAfter(scrappedDate))){
                return false;
            }
            tmpDate=scrappedDate;
        }
        return true;
    }

}
