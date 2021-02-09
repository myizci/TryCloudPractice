package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.DeckPage;
import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US6 extends TestBase {



    @Test
    public void TC1_AccessToDeckModule() {

        //1.Login as a user
        MainPage mainPage = new MainPage();

        // 2.Click “Decks” module
        driver.findElement(By.xpath(mainPage.deckXpath)).click();

        // 3.Verify the page title/URL is Decks module’s title
        String actualDeckTitle = Driver.get().getTitle();
        String expectedDeckTitle = "Deck - Trycloud QA";



        Assert.assertEquals(mainPage.expectedDeckTitle, actualDeckTitle);
    }

    @Test
    public void TC2_AddingTextToBoard(){
        DeckPage deckPage = new DeckPage();
//      1.Login as a user
        MainPage mainPage = new MainPage();

//      2.Click Deck module
        driver.findElement(By.xpath(mainPage.deckXpath)).click();

//      3.Click “Upcoming cards” button

        driver.findElement(By.xpath(deckPage.toggleMenu)).click();
//        //a[@class='app-navigation-toggle']
//
//      4.Click “plus” button
        driver.findElement(By.xpath(deckPage.plusButton)).click();

//      5.Write a note
        Faker faker = new Faker();
        String folderName = faker.name().firstName();
        driver.findElement(By.xpath(deckPage.boardLocation)).sendKeys(folderName + Keys.ENTER);
        BrowserUtils.sleep(2);
        driver.navigate().refresh();
        BrowserUtils.sleep(2);

//      6.Verify the note is added on the note list

        List<WebElement> list = driver.findElements(By.xpath(deckPage.boardList));

        boolean folderFlag = true;
        for (WebElement each : list){
            System.out.println(each.getText());
            if (each.getText().equals(folderName)){
                folderFlag =false;
                System.out.println(each.getText()+ " folderName");
                break;
            }
        }


        Assert.assertFalse(folderFlag);




    }

}

