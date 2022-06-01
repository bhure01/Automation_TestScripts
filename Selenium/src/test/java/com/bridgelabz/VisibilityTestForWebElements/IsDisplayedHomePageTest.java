package com.bridgelabz.VisibilityTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IsDisplayedHomePageTest {

    // 1. Test to check whether home page is displayed or not using title of the page
    @Test
    public void isDisplayedHomePage_UsingTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("demo@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("demo123");

        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        System.out.println("Title of page: " + driver.getTitle());
        System.out.println("URL of current page: " + driver.getCurrentUrl());

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        //If actual title contains "Facebook" text then home page is displayed.
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }

        /*if (actualTitle == expectedTitle) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }*/

        Thread.sleep(3000);
        driver.close();
    }

    // 2. Test to check whether home page is displayed or not using url of the page
    @Test
    public void isDisplayedHomePage_UsingURL() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("demo@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("demo123");

        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        System.out.println("Title of page: " + driver.getTitle());
        System.out.println("URL of current page: " + driver.getCurrentUrl());

        String expectedUrl = "facebook.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }
    }

    // 3. Test to check whether home page is displayed or not using any UNIQUE element on the page
    @Test
    public void isDisplayedHomePage_UsingUniqueElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("demo@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("demo123");

        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.name("login"));
        if (loginButton.isDisplayed()) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }
    }
}
