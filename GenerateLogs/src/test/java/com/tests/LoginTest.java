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

    // if we want to generate our own logs, define Logger
    Logger log = Logger.getLogger(LoginTest.class);

    @BeforeMethod
    public void setUp() {
        log.info("****************  Starting test cases execution  *****************");

        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        driver = new ChromeDriver();

        log.info("Launching the Chrome Browser");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://classic.freecrm.com/");

        //to generate own logs
        log.info("Entering URL of Application");
        // to print warning logs
        log.warn("Hey this is just a warning message");
        // to print errors or fatal
        log.fatal("Hey this is just a fatal error message");
        // to print debug
        log.debug("this is a debug message");
    }

    @Test(priority = 1)
    public void freeCRMTitleTest() {
        log.info("**************** starting test case *****************");
        log.info("**************** FreeCRMTitleTest *******************");

        String title = driver.getTitle();
        System.out.println(title);
        log.info("Login page title is ----->" + title);
        Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");

        log.info("**************** ending test case*****************");
        log.info("**************** FreeCRMTitleTest *******************");
    }

    @Test
    public void freeCRMLogoTest() {
        log.info("**************** starting test case *****************");
        log.info("**************** FreeCRMTitleTest *******************");

        boolean logo = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']")).isDisplayed();
        Assert.assertTrue(logo);

        log.info("**************** ending test case *****************");
        log.info("**************** FreeCRMTitleTest *******************");

        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();

        log.info("**************** Browser is closed *****************");

    }
}


