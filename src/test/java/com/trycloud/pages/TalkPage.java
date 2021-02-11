package com.trycloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TalkPage extends BasePage {
    public String userSearchBox = "(//a[@href='/index.php/apps/photos/'])[1]";
    public String userContactList = "//ul[@class='app-navigation__list']//span[@class='acli__content__line-one__title']";
    public String msgBox = "//div[@placeholder='Write message, @ to mention someone …']";
    public String sendMsgButton = "//button[@type='submit']";
    public String msgList = "//div[@class='rich-text--wrapper']";
}

