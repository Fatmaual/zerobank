package com.zerobank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool=new ThreadLocal<>();

    private Driver(){

    }

    public synchronized static WebDriver getDriver(){
        if(driverPool.get()==null){
            String browser=ConfigurationReader.getProperty("browser").toLowerCase();
            String os = System.getProperty("os.name").toLowerCase();

            if(os.contains("windows")&&browser.equalsIgnoreCase("safari")  ||  os.contains("mac")&&browser.equalsIgnoreCase("edg")){
                driverPool= null;
                throw  new RuntimeException("==> Incompatible browser choosen for "+os.toUpperCase()+"!! <==");
            }
            switch (browser){
                case "chrome":{
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                }
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                }
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                }
                case "safari":{
                    driverPool.set(new SafariDriver());
                    break;
                }
                case "chromeheadless":{
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;

                }
                default:{
                    throw new RuntimeException("Wrong browser name!!");
                }
            }

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}


