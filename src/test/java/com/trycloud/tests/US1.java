package com.trycloud.tests;


import com.trycloud.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1 extends TestBase {
    @Test
    public void TC1_verifyLogin(){

        //System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        //System.out.println("actualTitle = " + actualTitle);
    }

}
