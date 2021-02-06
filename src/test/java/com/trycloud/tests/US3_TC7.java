package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US3_TC7 extends TestBase {

    //WebElement uploadFile = driver.findElement(By.xpath("//label[@for='file_upload_start']"));

    @Test
    public void test_UploadingAFile() {
        //1. Login as a user: login is included in the TestBase.

        //Creating a mainPage Object
        MainPage mainPage = new MainPage();
        //Landing on a Dashboard page
        //From Dashboard page click on file

        driver.findElement(By.xpath(mainPage.filesXpath)).click();

        //2. Choose a folder from the page(clicking on File folder)
        BrowserUtils.sleep(4);
        //this is a table, so this should be correct xpath. Try with team again(1/2)
        driver.findElement(By.xpath("(//span[.='Petra'])[3]")).click();

        //3. Click the “+” icon on top
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        //4. Click “upload file”
        WebElement uploadingButton = driver.findElement(By.xpath(mainPage.addFileButtonXpath));

        //Creating a path of the file
        String path = "\"C:\\Users\\gisa_\\Desktop\\Screenshot 2020-12-28 212655.png\"";
        //5. Upload a file
        BrowserUtils.sleep(2);
        uploadingButton.sendKeys(path);

//        BrowserUtils.sleep(2);
//        uploadingButton.click();
//
//        //6. Verify the file is displayed on the page
//        //(Pre-condition: there should be at least 1 folder is created on the filers page)
//        //Test case #7 - verify users can upload a file inside a folder
    }

    @Test
    public void test_writingAComment() {

        //Test case #8 - verify users can write comments to files/folders.
        //1. Login as a user
        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        BrowserUtils.sleep(2);
        //2. Click action-icon from any file on the page
        driver.findElement(By.xpath(mainPage.actionIconXpath)).click();
        //3. Click details
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.detailsXpath)).click();
        //Locating a comment sign
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.commentFolderXpath)).click();
        //4. Write a comment inside to the input box
        WebElement commentBox = driver.findElement(By.xpath(mainPage.commentBoxXpath));
        commentBox.clear();
        commentBox.sendKeys("Excellent job!");
        //5. Click the submit button to post it
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath(mainPage.submitButtonXpath)).click();
        //6. Verify the comment is displayed in the comment section.

        boolean commentFlag = true;
        List<WebElement> listOfComments = new ArrayList<>();

        for (WebElement each : listOfComments) {
            if (each.getText().equals("Excellent job!")) {
                System.out.println(each.getText());
                commentFlag = false;
                break;
            }
            if (commentFlag) {
                System.out.println("Test failed!");
            }

        }
    }
}