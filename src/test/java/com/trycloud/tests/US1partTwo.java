package com.trycloud.tests;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.LoginPageOnly;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1partTwo {
WebDriver driver;



    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();

    }


    @Test
    public void TC2_negativeLogin(){
        LoginPageOnly loginNot = new LoginPageOnly();
        loginNot.login();
        BrowserUtils.sleep(5);
        String wrongPasswordMessage = driver.findElement(By.xpath("//p[contains(.,'Wrong username or password.')]")).getText();
        System.out.println(wrongPasswordMessage);
        String actualErrorMessage = wrongPasswordMessage;
       String expectedErrorMessage = "Wrong username or password.";

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }
}
