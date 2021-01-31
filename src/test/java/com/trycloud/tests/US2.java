package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US2 extends TestBase {

    @Test
    public void TC1_reachAllModules() {
        //BrowserUtils.sleep(30);

        MainPage mainPage = new MainPage();

        Assert.assertTrue(driver.getTitle().equals(mainPage.expectedFilesTitle));

       BrowserUtils.sleep(3);
       driver.findElement(By.xpath(mainPage.photosXpath)).click();
       Assert.assertFalse(driver.getTitle().equals(mainPage.expectedPhotosTitle), "Photos page access failed");
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath(mainPage.activityXpath)).click();
        Assert.assertTrue(driver.getTitle().equals(mainPage.expectedActivityTitle), "Activity page access failed");

        BrowserUtils.sleep(3);
        driver.findElement(By.xpath(mainPage.talkXpath)).click();
        Assert.assertTrue(driver.getTitle().equals(mainPage.expectedTalkTitle), "Talk page access failed");
        BrowserUtils.sleep(3);

        driver.findElement(By.xpath(mainPage.contactsXpath)).click();
        Assert.assertTrue(driver.getTitle().equals(mainPage.expectedContactsTitle), "Contacts page access failed");
        driver.findElement(By.xpath(mainPage.calendarXpath)).click();


        String currentDate = driver.findElement(By.xpath("//div[@class='datepicker-button-section']//button[2]")).getText();
        Assert.assertTrue(driver.getTitle().equals(currentDate+mainPage.expectedCalendarTitle), "Calendar page access failed");
        BrowserUtils.sleep(5);


        driver.findElement(By.xpath(mainPage.notesXpath)).click();
        Assert.assertTrue(driver.getTitle().equals(mainPage.expectedNotesTitle), "Notes page access failed");


//        System.out.println(driver.getTitle());
//        System.out.println(driver.findElement(By.xpath("//div[@class='datepicker-button-section']//button[2]")).getText());
    }


}
