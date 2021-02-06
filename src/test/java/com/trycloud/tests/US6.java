package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class US6 extends TestBase {

    @Test
    public void TC6_Create_Folder() {

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();
driver.findElement(By.xpath(mainPage.newFolderXpath)).click();
        driver.findElement(By.xpath(mainPage.newFolderInputXpath)).sendKeys("Group4"+ Keys.ENTER);


    }
}
