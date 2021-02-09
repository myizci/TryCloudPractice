package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.List;

public class US3_TC8 extends TestBase {
    @Test
    public void test_DeleteAFile(){

        //1.Login as a user
        // Login as a user: login is included in the TestBase.
        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        BrowserUtils.sleep(2);

        //2.Click action-icon from any file on the page
        //ActionIcon locator in Main page Line 66 public String //actionIconXpath = "(//span[@class='icon icon-more'])[2]";
        driver.findElement(By.xpath(mainPage.actionIconXpath)).click();
        BrowserUtils.sleep(2);

        //3.Choose “delete files” option
        //Deleted page Locator in Main page line 67     public String //trashbinXpath = "//li[@data-id='trashbin']";
         driver.findElement(By.xpath(mainPage.trashbinXpath)).click();
        BrowserUtils.sleep(2);


        //4.Click deleted files on the left bottom corner
        //Deleted page Locator in Main page line 68 public  String //deletedFilesXpath = "//a[@class='nav-icon-trashbin svg active']";
        driver.findElement(By.xpath(mainPage.deletedFilesXpath)).click();
        BrowserUtils.sleep(2);

        //5.Verify the deleted file is displayed no the page.

        WebElement deletedFile = driver.findElement(By.xpath("(//a[.='Deleted files'])"));
        Assert.assertTrue(deletedFile.isDisplayed());

        driver.close();

        }












    }







