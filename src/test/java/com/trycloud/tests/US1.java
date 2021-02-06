package com.trycloud.tests;


import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;





public class US1 extends TestBase {

    @Test
    public void TC1_verifyLogin(){
        MainPage mainPage = new MainPage();
        //System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard - Trycloud - QA";
        Assert.assertTrue(mainPage.expectedDashboardTitle.equals(expectedTitle));
    }




}
