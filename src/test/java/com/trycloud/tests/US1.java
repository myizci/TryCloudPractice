package com.trycloud.tests;


import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;





public class US1 extends TestBase {

    @Test
    public void TC1_verifyLogin(){
        BrowserUtils.sleep(2);
        MainPage mainPage = new MainPage();

        String actualTitle = driver.getTitle();

        Assert.assertTrue(mainPage.expectedDashboardTitle.equals(actualTitle));
    }




}
