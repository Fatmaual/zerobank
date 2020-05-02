package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
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
     * @param int1 year
     * @param int2 month
     * @param int3 day
     * @param int4 year
     * @param int5 month
     * @param int6 day
     * @return true if it is in the range
     *          false if it is not in the range
     *
     *          List<String> dates has data: {"2012-09-06","2012-09-05","2012-09-01"}
     */
    public boolean isItInTheRange(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6,List<String> dates){

        for (String date: dates) {
            String[] splitedDate=date.split("-");
            System.out.println("Scrapped data: "+date);
            System.out.println("From: "+int1+"-"+int2+"-"+int3+"  To: "+int4+"-"+int5+"-"+int6);
            if(Integer.parseInt(splitedDate[0])<int1 || Integer.parseInt(splitedDate[0])>int4){
                System.out.println("year "+int1+" < "+splitedDate[0]+" > "+int4);
                return false;
            }
            else if(Integer.parseInt(splitedDate[1])<int2 || Integer.parseInt(splitedDate[1])>int5){
                System.out.println("Month "+int2+" < "+splitedDate[1]+" > "+int5);
                return false;
            }
            else if(Integer.parseInt(splitedDate[2])<int3 || Integer.parseInt(splitedDate[2])>int6){
                System.out.println("Day "+int3+" < "+splitedDate[2]+" > "+int6);
                return false;
            }
        }
        return true;
    }

    /**
     * Get all dates as String from filtered transaction table
     * @return
     */
    public List<String> getDates(){
        return BrowserUtils.getTextFromWebElements(driver.findElements(By.xpath("//div[@id=\"filtered_transactions_for_account\"]//tr//td[1]")));
    }

}
