package com.example.selenium;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager 
{
    public static WebDriver getDriver(String browser)
    {
        WebDriver driver = null;
        if(browser.equals("firefox"))
        {
            //WebDriver driver = new FirefoxDriver();   
        }else
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/home/jawad/Downloads/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
        }else
        {
            Assert.assertTrue(false);
        }

        return driver;
    }
}
