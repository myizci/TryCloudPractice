package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3_TC3_4 extends TestBase {     // Gulistan

    //Test case #3 - verify users can add a file to favorites.
    //1.Login as a user
    //2.Click action-icon from any file on the page
    //3.Choose “Add to Favorites” option
    //4.Click “Favorites” sub-module on the lest side
    //5.Verify the chosen file is listed on the table
    //(Pre-condition: there should be at least 1 file is uploaded)

            @Test
           public void TC3_addToFavorites() {

            MainPage mainPage = new MainPage();
            Driver.get().findElement(By.xpath(mainPage.filesXpath)).click();
            BrowserUtils.sleep(2);
            Driver.get().findElement(By.xpath(mainPage.actionIcon2Xpath)).click();
            BrowserUtils.sleep(2);
            Driver.get().findElement(By.xpath(mainPage.addToFavoriteXpath)).click();
            BrowserUtils.sleep(2);
            Driver.get().findElement(By.linkText(mainPage.favoriteSubModuleXpath)).click();
            BrowserUtils.sleep(2);

            // list of favorites(rows): (//tbody)[3]/tr; a row in favorites: (//tbody)[3]/tr[1]
            //file added to favorite folder; WebElement
           WebElement fileAddedToFavoriteWE=Driver.get().findElement(By.xpath(mainPage.fileAddedToFavoriteXpath));
            //file added to favorite folder: String/Text
           String fileAddedToFavorite=fileAddedToFavoriteWE.getText();
            // what is added to favorite
           System.out.println("fileAddedToFavorite = " + fileAddedToFavorite);
            Assert.assertTrue(fileAddedToFavoriteWE.isDisplayed());

        }


    //Test case #4 - verify users can remove a file from favorites.
    //1.Login as a user
    //2.Click action-icon from any file on the page
    //3.Click “Remove from Favorites” option
    //4.Verify that the file is removed from Favorites sub-module’s table.
    //(Pre-condition: there should be at least 1 file is added to favorites table)

        @Test
        public void TC4_removeFromFavorites(){

            MainPage mainPage = new MainPage();
            Driver.get().findElement(By.xpath(mainPage.filesXpath)).click();
            Driver.get().findElement(By.xpath(mainPage.actionIcon1Xpath)).click();
            BrowserUtils.sleep(2);
            Driver.get().findElement(By.xpath(mainPage.removeFromFavoriteXpath)).click();
            Driver.get().findElement(By.linkText(mainPage.favoriteSubModuleXpath)).click();
            BrowserUtils.sleep(2);

           try {
               Driver.get().findElement(By.xpath(mainPage.fileAddedToFavoriteXpath));
               System.out.println("file exist");
           }
           catch (NoSuchElementException e){
               System.out.println("File is been removed");
           }

        }

}
