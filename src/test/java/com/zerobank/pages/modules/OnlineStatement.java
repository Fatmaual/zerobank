package com.zerobank.pages.modules;

import com.zerobank.pages.ZeroBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class OnlineStatement extends ZeroBase {

    private String fileName;

    /**
     * This method navigates to Statement year
     *
     * @param linkText
     */
    public void navigateToStatement(String linkText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * This method finds statements amount searched year and verified with count
     *
     * @param year  statement year
     * @param count amount of statement from example table
     * @return true if count and displayed statement amount same
     * false if count and displayed statement amount not same
     */
    public boolean isDisplayed(String year, String count) {
        return driver.findElements(By.xpath("//div[@id='os_" + year + "']//a")).size() == Integer.parseInt(count);
    }

    /**
     * This methods verifies download process.
     * @param fileName searched file
     * @return true if file exist in local directory
     *          false if file doesn't exist in local directory
     */
    public boolean isDownloaded(String fileName) {
        this.fileName=fileName;
        String file=findFile(this.fileName);
        return file != null;
    }

    /**
     * This method verifies downloaded file type
     * @param format searched format
     * @return true if file name contains searched format type
     *          false if file name doesn't contain searched format type
     */
    public boolean isDownloadedType(String format){
        String file=findFile(fileName);
        return file.contains(format);
    }

    /**
     * Search local download directory and return searched file full name if exist
     * @param fileName searched file name. Full or partial.
     * @return full file name as string. (including file type)
     *         if file doesn't exist return null
     */
    public String findFile(String fileName){
        try {
            File folder = new File("/Users/ofsanlialp/Downloads/");
            File[] files=folder.listFiles();
            assert files != null;
            for (File file : files) {
                if(file.getName().contains(fileName)){
                    return file.getName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
