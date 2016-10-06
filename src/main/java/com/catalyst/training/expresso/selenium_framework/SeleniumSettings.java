package com.catalyst.training.expresso.selenium_framework;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumSettings {

    private WebDriver driver;

    private String CHROME_MAC = "src/test/java/com/catalyst/training/expresso/selenium_drivers/chromedriver";
    private String CHROME_WIN = "src/test/java/com/catalyst/training/expresso/selenium_drivers/chromedriver.exe";
    private String CHROME_LNX = "src/test/java/com/catalyst/training/expresso/selenium_drivers/chromedriverlinux";

    public SeleniumSettings(){
        if (SystemUtils.IS_OS_MAC)
            System.setProperty("webdriver.chrome.driver", CHROME_MAC);
        if (SystemUtils.IS_OS_WINDOWS)
            System.setProperty("webdriver.chrome.driver", CHROME_WIN);
        if (SystemUtils.IS_OS_LINUX)
            System.setProperty("webdriver.chrome.driver", CHROME_LNX);

        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

}
