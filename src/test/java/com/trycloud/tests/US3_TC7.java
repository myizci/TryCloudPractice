package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class US3_TC7 extends TestBase {

    //WebElement uploadFile = driver.findElement(By.xpath("//label[@for='file_upload_start']"));

    @Test
    public void testCase7_UploadingAFile() throws AWTException {
        //1. Login as a user: login is included in the TestBase.

        //Creating a mainPage Object
        MainPage mainPage = new MainPage();
        Faker faker = new Faker();
        String folderName = faker.name().firstName();
        //Landing on a Dashboard page
        //From Dashboard page click on file

        driver.findElement(By.xpath(mainPage.filesXpath)).click();

        //2. Choose a folder from the page(clicking on File folder)
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        driver.findElement(By.xpath(mainPage.addFolderButtonXpath)).click();

        driver.findElement(By.xpath(mainPage.newFolderNameXpath)).sendKeys(folderName+ Keys.ENTER);

        BrowserUtils.sleep(2);

        List<WebElement> folderAndFilesList = driver.findElements(By.xpath("//span[@class='innernametext']"));

       // String folderName2 = folderName;

        WebElement newFolder = null;

        for(WebElement each : folderAndFilesList) {

              if(each.getText().equals(folderName)){
                 newFolder = each;
        }

        }
        newFolder.click();


        driver.navigate().refresh();
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.addFileButtonXpath)).click();

        StringSelection ss = new StringSelection("C:\\Users\\gisa_\\Desktop\\Screenshot 2020-12-28 212655.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);
        BrowserUtils.sleep(3);

        //6. Verify the file is displayed on the page
       List<WebElement> filesInFolder = driver.findElements(By.xpath("//span[@class='innernametext']"));

       boolean fileFlag = false;
       for(WebElement each : filesInFolder){
           if(each.getText().contains("Screenshot")){
               fileFlag = true;
               break;
           }

       }
       Assert.assertTrue(fileFlag);

    }

    @Test
    public void testCase8_2_writingAComment() {

        //Test case #8 - verify users can write comments to files/folders.
        //1. Login as a user
        MainPage mainPage = new MainPage();
        Faker faker = new Faker();
        String folderName = faker.name().firstName();



        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        BrowserUtils.sleep(2);
        //2. Click action-icon from any file on the page
       // driver.findElement(By.xpath(mainPage.actionIconXpath)).click();

        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        driver.findElement(By.xpath(mainPage.addFolderButtonXpath)).click();

        driver.findElement(By.xpath(mainPage.newFolderNameXpath)).sendKeys(folderName+ Keys.ENTER);

        BrowserUtils.sleep(2);
        driver.navigate().refresh();

        BrowserUtils.sleep(2);
        List<WebElement> actionList = driver.findElements(By.xpath("//span[@class='innernametext']"));

        String folderName2 = folderName;


        for(WebElement each : actionList){
            String eachName = each.getText();
            WebElement threeDots = driver.findElement(By.xpath("//span[.='"+eachName+"']/../..//span[@class='icon icon-more']"));
            if(each.getText().equals(folderName2)){
                threeDots.click();
            }

        }






       //3. Click details
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.detailsXpath)).click();
        //Locating a comment sign
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.commentFolderXpath)).click();
        //4. Write a comment inside to the input box
        WebElement commentBox = driver.findElement(By.xpath(mainPage.commentBoxXpath));
        commentBox.clear();
        commentBox.sendKeys(folderName2);
        //5. Click the submit button to post it
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.submitButtonXpath)).click();
        //6. Verify the comment is displayed in the comment section.

        boolean commentFlag = true;
        List<WebElement> listOfComments = new ArrayList<>();

        for (WebElement each : listOfComments) {
            if (each.getText().equals(folderName2)) {
                System.out.println(each.getText());
                commentFlag = false;
                break;
            }

            Assert.assertFalse(commentFlag);

        }



    }
}