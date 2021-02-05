package com.trycloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainPage extends BasePage{

    public String dashboardXpath = "(//*[@class='app-icon'])[1]"; //also:   (//a[@href='/index.php/apps/dashboard/'])[1]
    public String filesXpath = "(//*[@class='app-icon'])[2]";  //also:   (//a[@href='/index.php/apps/files/'])[1]
    public String photosXpath = "(//*[@class='app-icon'])[3]"; //also:   (//a[@href='/index.php/apps/photos/'])[1]
    public String activityXpath = "(//*[@class='app-icon'])[4]"; //also:  (//a[@href='/index.php/apps/activity/'])[1]
    public String talkXpath = "(//*[@class='app-icon'])[5]";  //also:  (//a[@href='/index.php/apps/talks/'])[1]
    public String contactsXpath = "(//*[@class='app-icon'])[7]"; //also:  (//a[@href='/index.php/apps/contacts/'])[1]
    public String circlesXpath ="(//*[@class='app-icon'])[8]"; // also:  (//a[@href='/index.php/apps/circles/'])[1]
    public String calendarXpath = "(//*[@class='app-icon'])[9]";  //also:  (//a[@href='/index.php/apps/calendar/'])[1]
    public String deckXpath = "(//*[@class='app-icon'])[10]";  //also:  (//a[@href='/index.php/apps/deck/'])[1]
    // US7_Ghalip
    // magnifierIcon
 //  svg.material-design-icon__svg
    public String magnifierCssSelectorIcon="svg.material-design-icon__svg";
    // search field:  input.unified-search__form-input
    public String inputSearchFormCssSelector="input.unified-search__form-input";
    // found search items list:
    public String foundSearchItemsListCssSelector="div.header-menu__content";

    // needed for Calender
    LocalDate today = LocalDate.now();
    String monthYear = today.format(DateTimeFormatter.ofPattern("MMMM YYYY"));

    public String expectedDashboardTitle = "Dashboard - Trycloud QA";
    public String expectedFilesTitle = "Files - Trycloud QA";
    public String expectedPhotosTitle ="Photos - Trycloud QA";
    public String expectedActivityTitle = "Activity - Trycloud QA";
    public String expectedTalkTitle="Talk - Trycloud QA";
    public String expectedContactsTitle="Contacts - Trycloud QA";
    public String expectedCirclesTitle="Circles - Trycloud QA";
    public String expectedCalendarTitle="February 2021 - Calendar - Trycloud QA";
    public String expectedDeckTitle= "Deck - Trycloud QA";

   //public  WebElement actualModuleName  = driver.findElement(By.xpath("//a[contains(.,'All files')]"));


}
