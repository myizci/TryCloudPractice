package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3_TC9 extends TestBase {

    @Test
    public void test_ChangeAppSettings() {

        //1.Login as a user
        // Login as a user: login is included in the TestBase.
        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        BrowserUtils.sleep(2);

        // 2.Click Settings on the left bottom corner
        // 'Settings' - locator in Main page Line 72: public String SettingsXpath = "//button[@class='settings-button opened']";
        driver.findElement(By.xpath(mainPage.SettingsXpath)).click();
        BrowserUtils.sleep(3);

        //3.Verify user can click any buttons.
        WebElement showHiddenFiles = driver.findElement(By.xpath("//label[@for='showhiddenfilesToggle']"));
        showHiddenFiles.click();

        BrowserUtils.sleep(2);

        if (showHiddenFiles.isEnabled()) {
            Assert.assertTrue(showHiddenFiles.isDisplayed());
        } else {
            Assert.assertTrue(!showHiddenFiles.isDisplayed());
        }


    }
}

