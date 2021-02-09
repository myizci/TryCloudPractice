package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US3_TC3 extends TestBase {

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
        Driver.get().findElement(By.xpath("(//span[@class='icon icon-more'])[5]")).click();
        BrowserUtils.sleep(2);
        Driver.get().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']")).click();
        BrowserUtils.sleep(2);
        Driver.get().findElement(By.linkText("Favorites")).click();
        BrowserUtils.sleep(2);

        // list of favorites(rows): (//tbody)[3]/tr; a row in favorites: (//tbody)[3]/tr[1]
        //file added to favorite folder; WebElement
        WebElement fileAddedToFavoriteWE=Driver.get().findElement(By.xpath("(//tbody)[3]/tr"));
        //file added to favorite folder: String/Text
        String fileAddedToFavorite=fileAddedToFavoriteWE.getText();
        // what is added
        System.out.println("fileAddedToFavorite = " + fileAddedToFavorite);
        // isDisplay works only for WebElement, not for Text!
        Assert.assertTrue(fileAddedToFavoriteWE.isDisplayed());

    }
}
