package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;

public class LoginPageOnly extends BasePage{

    private String loginUserNameBoxXpath = "//input[@id='user']";
    private String loginPasswordBoxXpath = "//input[@id='password']";
    private String loginButton = "//input[@id='submit-form']";


    public void login (){
        driver.findElement(By.xpath(loginUserNameBoxXpath)).clear();
        driver.findElement(By.xpath(loginUserNameBoxXpath)).sendKeys("Joker");
        driver.findElement(By.xpath(loginPasswordBoxXpath)).clear();
        driver.findElement(By.xpath(loginPasswordBoxXpath)).sendKeys("WhySoSerious");
        driver.findElement(By.xpath(loginButton)).click();
    }
}
