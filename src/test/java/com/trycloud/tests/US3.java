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
import java.io.File;
import java.util.List;

public class US3 extends TestBase {


    @Test
    public void TC5_uploadAFile() throws AWTException {

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();

        WebElement uploadFile = driver.findElement(By.cssSelector("label[for='file_upload_start']"));
        BrowserUtils.sleep(5);
        uploadFile.click();


//        StringSelection ss = new StringSelection("/Users/guestaccount/Desktop/CSS-Selectors-Cheat-Sheet.pdf");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//
//        //imitate mouse events like ENTER, CTRL+C, CTRL+V
//        Robot robot = new Robot();
//        robot.delay(250);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(90);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        BrowserUtils.sleep(3);

        //File Need to be imported

        File file = new File("/Users/guestaccount/Desktop/XPath+Cheat+Sheet.pdf");

        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

//Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();

// Cmd + Tab is needed since it launches a Java app and the browser looses focus

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_TAB);

        robot.delay(500);

//Open Goto window

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_G);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(500);

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(500);

        BrowserUtils.sleep(2);

        driver.navigate().refresh();

        List<WebElement> filesAndFolders = driver.findElements(By.xpath(mainPage.mainPageFilesAndFolders));

        for (WebElement eachElement : filesAndFolders) {
            System.out.println(eachElement.getText());
        }
    }



    @Test
    public void TC6_Create_Verify_Folder() {
        Faker faker = new Faker();

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.filesXpath)).click();
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();
        driver.findElement(By.xpath(mainPage.addFolderButtonXpath)).click();
        String name = faker.name().firstName();
        driver.findElement(By.xpath(mainPage.newFolderNameXpath)).sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(3);
        driver.navigate().refresh();//refresh page to add the new folder to the list
        driver.findElement(By.xpath(mainPage.plusButtonXpath)).click();


        boolean folderFlag = true;
        List<WebElement> folders = driver.findElements(By.xpath(mainPage.foldersListXpath));
        for (WebElement each : folders) {
            System.out.println(each.getText());
            if (each.getText().equals(name)) {
                folderFlag = false;
                break;
            }
        }

         Assert.assertFalse(folderFlag);
    }
}

