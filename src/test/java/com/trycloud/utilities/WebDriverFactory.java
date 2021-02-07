package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    //TASK: NEW METHOD CREATION
//   Method name: getDriver
//   Static method
//   Accepts string argument: browserType --> will determine what browser opens
//       -> if "chrome" opens chrome browser
//       -> if "firefox" opens firefox browser
//   return type: WebDriver

    public static WebDriver getDriver(String browserType) {
        browserType = browserType.toLowerCase();
        if (browserType.contains("chrome")) {

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.contains("edge")) {

            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

        }else if (browserType.contains("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {

            System.out.println("Enter a valid browser type. Drive = null!");
            return null;

        }
    }

}
