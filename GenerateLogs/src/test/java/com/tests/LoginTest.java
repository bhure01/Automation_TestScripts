package com.tests;

import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/home/ubuntu/WebDrivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://classic.freecrm.com/");
    }

    @Test(priority = 1)
    public void freeCRMTitleTest() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
    }
    @Test
    public void freeCRMLogoTest() {
        boolean logo = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']")).isDisplayed();
        Assert.assertTrue(logo);
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}

