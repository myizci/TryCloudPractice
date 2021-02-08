package com.trycloud.tests.base;


import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.get(); //call static method
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();
        LoginPage loginpage = new LoginPage();
        loginpage.login(); // call instance method
       // driver.get(ConfigurationReader.getProperty("url2"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(5);
       // driver.close();
    }
}
