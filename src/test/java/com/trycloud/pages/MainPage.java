package com.trycloud.pages;

import com.trycloud.tests.US3_TC8;

public class MainPage extends BasePage {

    public String filesXpath = "(//a[@href='/index.php/apps/files/'])[1]";
    public String photosXpath = "(//a[@href='/index.php/apps/photos/'])[1]"; ////a[@aria-label='Photos']
    public String activityXpath = "(//a[@href='/index.php/apps/activity/'])[1]";
    public String circlesXpath = "(//li[@data-id='circles']/a";
    public String talkXpath = "(//a[@href='http://qa2.trycloud.net/index.php/apps/spreed/'])[1]";
    public String contactsXpath = "(//a[@href='/index.php/apps/contacts/'])[1]";
    public String calendarXpath = "(//a[@href='/index.php/apps/calendar/'])[1]";
    public String calendarDatePickButton = "//div[@class='datepicker-button-section']//button[2]";
    public String deckXpath = "(//a[@href='/index.php/apps/deck/'])[1]";
    public String plusButtonXpath = "//*[@id='controls']/div[2]/a";
    public String addFileButtonXpath = "//label[@for='file_upload_start']";
    public String addFolderButtonXpath = "//span[.='New folder']";
    public String newFolderXpath = "//span[contains(.,'New folder')]";
    public String newFolderInputXpath = "//input[@id='view13-input-folder']";
    public String foldersListXpath = "//span[@class='innernametext']";
    public String newFolderNameXpath = "//input[@id='view13-input-folder']";

    //US3-tc3,4

    public String actionIcon2Xpath = "(//span[@class='icon icon-more'])[2]";
    public String actionIcon1Xpath = "(//a[@class='action action-menu permanent'])[1]";
    public String addToFavoriteXpath ="//a[@class='menuitem action action-favorite permanent']";
    public String removeFromFavoriteXpath ="//span[.='Remove from favorites']";
    public String favoriteSubModuleXpath = "Favorites";
    public String fileAddedToFavoriteXpath = "(//tbody)[3]/tr";
    public String RemoveFromFavoriteXpath = "//span[.='Remove from favorites']";

    // US7
    // magnifierIcon
    public String magnifierCssSelectorIcon = "svg.material-design-icon__svg";
    // search field:  input.unified-search__form-input
    public String inputSearchFormCssSelector = "input.unified-search__form-input";
    // found search items list:
    public String foundSearchItemsListCssSelector = "div.header-menu__content";

    public String expectedDashboardTitle = "Dashboard - Trycloud QA";
    public String expectedFilesTitle = "Files - Trycloud QA";
    public String expectedPhotosTitle = "Galleries - Trycloud QA";
    public String expectedActivityTitle = "Activity - Trycloud QA";
    public String expectedCirclesTitle = "Circle - Trycloud QA";
    public String expectedTalkTitle = "Talk - Trycloud QA";
    public String expectedContactsTitle = "Contacts - Trycloud QA";
    public String expectedCalendarTitle = " - Calendar - Trycloud QA";
    public String expectedDeckTitle = "Deck - Trycloud QA";
    public String mainPageFilesAndFolders = "//span[@class='innernametext']";


    //US3_7
    public String actionIconXpath = "(//a[@class='action action-menu permanent'])[2]";
    public String detailsXpath = "//span[.='Details']";
    public String commentFolderXpath = "//a[@id='commentsTabView']";
    public String commentBoxXpath = "(//div[@contenteditable='true'])[2]";
    public String submitButtonXpath = "//input[@class='submit icon-confirm has-tooltip']";
    public String folderAndFilesXpath = "//span[@class='innernametext']";

    //US3_7

    //US3_TC8

    public String actionnIconXpath = "(//span[@class='icon icon-more'])[2]";
    public String trashbinXpath = "//li[@data-id='trashbin']";
    public String deletedFilesXpath = "//a[@class='nav-icon-trashbin svg active']";
    public String deletedFileXpath = "(//a[.='Deleted files'])";

    //US3_TC9
    public String SettingsXpath = "//button[@class='settings-button']";





}
