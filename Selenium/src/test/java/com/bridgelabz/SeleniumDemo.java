package com.bridgelabz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {
    @Test
    public void seleniumDemoWithChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        // Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        // driver.findElement(By.id("email")).clear();
        // Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("test@12345");

        System.out.println("Title of page: " + driver.getTitle());
        System.out.println("URL of current page: " + driver.getCurrentUrl());
        // driver.close();
        driver.findElement(By.name("login")).click();
        // driver.findElement(By.name("login'")).submit();
        // driver.findElement(By.name("u_O_d_XD")).click();
    }

    @Test
    public void seleniumWithChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("bhurend579@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("****************");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void seleniumWithFirefoxBrowser() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("bhurend579@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("****************");
        driver.findElement(By.name("login")).click();
    }
}
