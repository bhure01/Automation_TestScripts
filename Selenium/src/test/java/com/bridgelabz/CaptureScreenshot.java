package com.bridgelabz;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    @Test
    public void captureScreenshot() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        try {
            // FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File("/home/ubuntu/Automation_TestScripts/Selenium/Screenshots/screenshot.png"));
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File("/home/ubuntu/Automation_TestScripts/Selenium/Screenshots/screenshot1_"+System.currentTimeMillis()+".png"));
        } catch (WebDriverException e) {

        } catch (IOException e) {

        }
        Thread.sleep(2000);
        driver.close();
    }
}
