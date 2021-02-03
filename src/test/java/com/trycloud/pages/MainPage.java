package com.trycloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainPage extends BasePage{

    public String dashboardXpath = "(//*[@class='app-icon'])[1]";
    public String filesXpath = "(//*[@class='app-icon'])[2]";
    public String photosXpath = "(//a[@href='/index.php/apps/photos/'])[1]"; //also:  (//*[@class='app-icon'])[3]
    public String activityXpath = "(//a[@href='/index.php/apps/activity/'])[1]"; //also:  (//*[@class='app-icon'])[4]
    public String talkXpath = "(//a[@href='/index.php/apps/talks/'])[1]";  //also:  (//*[@class='app-icon'])[5]
    public String contactsXpath = "(//a[@href='/index.php/apps/contacts/'])[1]"; //also:  (//*[@class='app-icon'])[6]
    public String circlesXpath ="(//a[@href='/index.php/apps/circles/'])[1]";  //also:  (//*[@class='app-icon'])[7]
    public String calendarXpath = "(//a[@href='/index.php/apps/calendar/'])[1]";  //also:  (//*[@class='app-icon'])[8]
    //public String calendarDatePickButton = "//div[@class='datepicker-button-section']//button[2]";
    public String deckXpath = "(//a[@href='/index.php/apps/deck/'])[1]";  //also:  (//*[@class='app-icon'])[9]
    // US7
    // magnifierIcon
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
    public String expectedCalendarTitle=monthYear+" - Calendar - Trycloud QA";
    public String expectedDeckTitle= "Deck - Trycloud QA";

   //public  WebElement actualModuleName  = driver.findElement(By.xpath("//a[contains(.,'All files')]"));


}
