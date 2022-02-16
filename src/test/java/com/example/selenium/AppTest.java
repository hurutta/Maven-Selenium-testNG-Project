package com.example.selenium;

import java.util.concurrent.TimeUnit;

import com.example.selenium.utilities.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class AppTest 
{
    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        driver = BrowserManager.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Properties.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void search()
    {
        WebElement searchBox = driver.findElement(By.id("q"));
        searchBox.sendKeys("casio");
        WebElement searchIcon = driver.findElement(By.className("search-box__button--1oH7"));
        searchIcon.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");


        WebElement minPrice = driver.findElement(By.xpath("//input[@placeholder='Min']"));        
        minPrice.sendKeys("");
        minPrice.sendKeys("500");

        WebElement maxPrice = driver.findElement(By.xpath("//input[@placeholder='Max']"));
        maxPrice.sendKeys("1000");
        
        WebElement priceRange = driver.findElement(By.xpath("//button[@class='ant-btn c3R9mX ant-btn-primary ant-btn-icon-only']"));
        priceRange.click();



        WebElement location = driver.findElement(By.xpath("//div[@class='ant-col-4 ant-col-pull-20 c2cfh3']//div[2]//div[2]//div[1]//div[1]//label[1]//span[1]//input[1]"));
        location.click();
        WebElement dropdown = driver.findElement(By.className("ant-select-arrow"));
        dropdown.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement lowToHigh = driver.findElement(By.xpath("//div[normalize-space()='Price low to high']"));
        lowToHigh.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,-350)", "");
        
    }



    @Test
    public void placeOrder()
    {
        
    }



    @AfterTest
    public void afterMethod()
    {
        driver.quit();
    }

    
}
