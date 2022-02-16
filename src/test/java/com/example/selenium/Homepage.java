package com.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Homepage 
{
    WebDriver driver;

    public Homepage(WebDriver driver)
    {
        this.driver = driver;
    }
    
    @FindBy(how = How.XPATH, using = "") WebElement q;
}
