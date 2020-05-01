package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends ZeroBase {

    @FindBy(className = "board-header")
    private List<WebElement> accountTypes;


    /**
     * This method returns all account group titles as String List
     * @return  ["Cash Accounts","Investment Accounts","Loan Accounts","Credit Accounts"]
     *
     */
    public List<String> getAccountTypes(){
        return BrowserUtils.getTextFromWebElements(accountTypes);
    }

    /**
     * This methods opens the created accounts links
     * @param accountName Savings
     *                    Brokerage
     *                    Checking
     *                    Credit Card
     *                    Loan
     */
    public void openCreatedAccount(String accountName){
        driver.findElement(By.xpath("//td//a[text()=\""+accountName+"\"]")).click();
    }

}
