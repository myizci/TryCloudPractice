package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.pages.TalkPage;
import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US4 extends TestBase {

    @Test //2. Click Talks module TalkModule locator:
    public void TC1_AccessTalkModule() {

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.talkXpath)).click();

        //3. Verify the page tile is Talks module’s tile
        String TalkTitle = driver.getTitle();
        Assert.assertEquals("Talk - Trycloud QA", TalkTitle);
    }

   // Test case #2 - verify users can send message


    @Test
    public void TC2_UsersSendMsg() {

        MainPage mainPage = new MainPage();
        driver.findElement(By.xpath(mainPage.talkXpath)).click();//2. Click Talks module TalkModule locator:

        //3.Search a user from search box on the left

        TalkPage talkPage = new TalkPage();
        driver.findElement(By.xpath(talkPage.userSearchBox)).sendKeys("e");
        List<WebElement> list = driver.findElements(By.xpath(talkPage.userContactList));
        for (WebElement each : list) {
            if (each.getText().contains("Employee1")) {
                System.out.println(each);
                each.click();
                break;
            }
        }

        // 4.Write a message
        WebElement messageBox = driver.findElement(By.xpath(talkPage.msgBox));
        messageBox.sendKeys("miyagi do");
        driver.findElement(By.xpath(talkPage.sendMsgButton)).click(); //  5.Click submit button

        List<WebElement> listOfMsg = driver.findElements(By.xpath(talkPage.msgList));
        boolean msgFlag = false;
        for (WebElement each : listOfMsg) {

            if (each.getText().contains("miyagi do")) {
                msgFlag = true;
                break;
            }
        }

        Assert.assertTrue(msgFlag);  //6.Verify the message is displayed on the conversation log
    }



}
