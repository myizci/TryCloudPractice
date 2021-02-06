package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private String loginUserNameBoxXpath = "//input[@id='user']";
    private String loginPasswordBoxXpath = "//input[@id='password']";
    private String loginButton = "//input[@id='submit-form']";

public  void login (){
    driver.findElement(By.xpath(loginUserNameBoxXpath)).clear(); // this is optional
    driver.findElement(By.xpath(loginUserNameBoxXpath)).sendKeys(ConfigurationReader.getProperty("user1"));
    driver.findElement(By.xpath(loginPasswordBoxXpath)).clear();
    driver.findElement(By.xpath(loginPasswordBoxXpath)).sendKeys(ConfigurationReader.getProperty("password"));
    driver.findElement(By.xpath(loginButton)).click();
}

}
