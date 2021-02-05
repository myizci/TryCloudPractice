package com.trycloud.tests;

import com.trycloud.pages.MainPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class US7 extends TestBase {

    //1. Login as a user: login is included in the TestBase.

    @Test
    public void test_UsersCanSearch() {
        //2. Click on magnifier icon on the right top
        //magnifier:   //*[@aria-controls='header-menu-unified-search']
        MainPage mainPage=new MainPage();
        driver.findElement(By.cssSelector(mainPage.magnifierCssSelectorIcon)).click();

        // searchable items: [ Dashboard, File, Photo, Activity, Talk, Mail, Contacts,  Circles, Calendar, Deck],
        // all these items were added first on tryCloud!
        // any items added on tryCloud, can be added to the array below
        // searchable_items_array=sarr
        String[] sarr={"Dashboard", "File", "Photo", "Activity", "Talk", "Mail", "Contacts",  "Circles", "Calendar", "Deck"};

        // 3. Search any existing file/folder/user name
        for (int i = 0; i < sarr.length; i++) {
            String searchItem=sarr[i];
            //clear the field first
            driver.findElement(By.cssSelector(mainPage.inputSearchFormCssSelector)).clear();
            BrowserUtils.sleep(2);
            // type in the search item
            driver.findElement(By.cssSelector(mainPage.inputSearchFormCssSelector)).sendKeys(searchItem);
            // wait until it finds the item
            BrowserUtils.sleep(2);
            // make a file out of what is found

            /*
            // check out this option: it is simpler than having all the searchValues in a list.
            String searchValue = ConfigurationReader.getProperty("searchItem");
                searchBox.sendKeys(searchItem + Keys.ENTER);
                //Assert title contains the value
                //actual --> actual page, browser
                String actualTitle = Driver.getDriver().getTitle();
                //expected --> comes from documentation
                String expectedInTitle = searchValue;
                BrowserUtils.sleep(8 );
                Assert.assertTrue(actualTitle.contains(expectedInTitle));

             */


            ArrayList<WebElement> foundItems_WE_List= (ArrayList<WebElement>) driver.findElements(By.cssSelector(mainPage.foundSearchItemsListCssSelector));
            // clean up the WE list for non search items
            foundItems_WE_List.removeIf(p->!(p.getText().contains(searchItem)));

            ArrayList<String> foundItems= new ArrayList<>();
            for (int j = 0; j <foundItems_WE_List.size() ; j++) {
                foundItems.add(foundItems_WE_List.get(j).getText());
                }
            //4. Verify the app displays the expected result option
            System.out.println("For search item " +searchItem + ", it is found " + foundItems);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertFalse(foundItems.isEmpty());

        }


    }

}

/*
7. Story: As a user, I should be able to access search any item/ users from the homepage.
    Test case #1 - Verify users can search any files/folder/users from the search box.
        1. Login as a user
        2. Click magnifier icon on the right top
        3. Search any existing file/folder/user name
        4. Verify the app displays the expected result option
 */