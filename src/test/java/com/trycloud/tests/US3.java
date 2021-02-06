package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US3 extends TestBase {


    @Test
    public void TC5_UploadFileToHomePage() {


        MainPage mainPage = new MainPage();
driver.findElement(By.xpath(mainPage.filesXpath)).click();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        WebElement uploadFile = driver.findElement(By.xpath("//label[@for='file_upload_start']"));
        WebElement file = driver.findElement(By.xpath(mainPage.addFileButtonXpath));

        String path = "/Users/guestaccount/Desktop/Collections Framework Hierarchy (1).png";
       uploadFile.sendKeys(path);
    }
}
