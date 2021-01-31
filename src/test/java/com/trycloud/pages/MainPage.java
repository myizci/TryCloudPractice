package com.trycloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    public String photosXpath = "(//a[@href='/index.php/apps/photos/'])[1]";
    public String activityXpath = "(//a[@href='/index.php/apps/activity/'])[1]";
    public String talkXpath = "(//a[@href='http://qa.trycloud.net/index.php/apps/spreed/'])[1]";
    public String contactsXpath = "(//a[@href='/index.php/apps/contacts/'])[1]";
    public String calendarXpath = "(//a[@href='/index.php/apps/calendar/'])[1]";
    public String notesXpath = "(//a[@href='/index.php/apps/notes/'])[1]";


    public String expectedFilesTitle = "Files - Trycloud - QA";
    public String expectedPhotosTitle ="Galleries - Trycloud - QA";
    public String exppectedActivityTitle = "Activity - Trycloud - QA";
    public String expectedTalkTitle="Talk - Trycloud - QA";
    public String expectedContactsTitle="Contacts - Trycloud - QA";
    public String expectedCalendarTitle="Calendar - Trycloud - QA";
    public String expectedNotesTitle= "Notes - Trycloud - QA";

   //public  WebElement actualModuleName  = driver.findElement(By.xpath("//a[contains(.,'All files')]"));


}
