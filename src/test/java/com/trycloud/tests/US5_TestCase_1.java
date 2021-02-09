//package com.trycloud.tests;
//
//import com.trycloud.pages.MainPage;
//import com.trycloud.tests.base.TestBase;
//import com.trycloud.utilities.BrowserUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
///*
//Story: As a user, I should be able to access to Contacts module.
//Test case #1 - verify users can access “to Talks” module.
//1. Login as a user.
//2. Click “Contacts” module.
//3. Verify the page tile is Contacts module’s tile.
//*/
//    //1. Login as a user: login is included in the TestBase.
//
//    public class US5 extends TestBase {
//
//        @Test
//        public void userCanAccessContactsModule() {
//
//            MainPage mainPage=new MainPage();
//
//    //2 - Click on Contact icon to navigate to Contacts module.
//    // 'Contacts' - locator in Main page Line 11: public String contactsXpath = "(//a[@href='/index.php/apps/contacts/'])[1]";4
//
//            driver.findElement(By.xpath(mainPage.contactsXpath)).click();
//
//
//            // searchable items: [Files, Photo, Activity, Talk, Contact, Calender, Note, User],
//        // all these items were added first on tryCloud
//        // any items added on tryCloud, can be added to the array below
//        // searchable_items_array=sarr
//        String[] sarr = {"Files", "Photos", "Activity", "Talk", "Contact", "Calendar", "Notes", "User"};
//
//        // 3. Search any existing file/folder/user name
//        for (int i = 0; i < sarr.length; i++) {
//            String searchItem = sarr[i];
//            //clear the field first
//            driver.findElement(By.cssSelector(mainPage.inputSearchFormCssSelector)).clear();
//            BrowserUtils.sleep(2);
//            // type in the search item
//            driver.findElement(By.cssSelector(mainPage.inputSearchFormCssSelector)).sendKeys(searchItem);
//            // wait until it finds the item
//            BrowserUtils.sleep(2);
//            // make a file out of what is found
//            ArrayList<WebElement> foundItems_WE_List = (ArrayList<WebElement>) driver.findElements(By.cssSelector(mainPage.foundSearchItemsListCssSelector));
//            // clean up the WE list for non search items
//            foundItems_WE_List.removeIf(p -> !(p.getText().contains(searchItem)));
//
//            ArrayList<String> foundItems = new ArrayList<>();
//            for (int j = 0; j < foundItems_WE_List.size(); j++) {
//                foundItems.add(foundItems_WE_List.get(j).getText());
//            }
//            //4. Verify the app displays the expected result option
//            System.out.println("For search item " + searchItem + ", it is found " + foundItems);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            Assert.assertFalse(foundItems.isEmpty());
//
//        }
//    }
//
//    }
//
//
//
//
////icon icon-add