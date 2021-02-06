package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class US3 extends TestBase {


    @Test
    public void TC5_UploadFileToHomePage() {


        MainPage mainPage = new MainPage();
driver.findElement(By.xpath(mainPage.filesXpath)).click();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        WebElement uploadFile = driver.findElement(By.xpath(mainPage.addFileButtonXpath));
        WebElement file = driver.findElement(By.xpath(mainPage.addFileButtonXpath));

        String path = "\u202AC:\\Users\\gisa_\\Desktop\\Screenshot 2020-12-29 204944.png";
       uploadFile.sendKeys(path);
    }


    @Test
    public void TC6_Create_Verify_Folder() {
        Faker faker = new Faker();

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();
        driver.findElement(By.xpath(mainPage.addFolderButtonXpath)).click();
        String name = faker.name().firstName();
        driver.findElement(By.xpath(mainPage.newFolderNameXpath)).sendKeys(name+ Keys.ENTER);
        BrowserUtils.sleep(3);
        driver.navigate().refresh();//refresh page to add thenew folder to the list
        boolean folderFlag=true;
        List<WebElement> folders=  driver.findElements(By.xpath(mainPage.foldersListXpath));
       for(WebElement each:folders){
           System.out.println(each.getText());
           if(each.getText().equals(name)){
               folderFlag=false;
               break;
           }
       }

      //  Assert.assertFalse(folderFlag);
    }
}

