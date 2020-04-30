package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends ZeroBase{

    @FindBy(className = "board-header")
    private List<WebElement> accountTypes;


    public List<String> getAccountTypes(){
        return BrowserUtils.getTextFromWebElements(accountTypes);
    }

}
