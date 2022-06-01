package com.bridgelabz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumWaitsTest {
    @Test
    public void implicitWaitTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.irctc.co.in/nget/");
        // driver.get("https://www.facebook.com/");
    }

    @Test
    public void explicitWaitTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create New Account")).click();

        //WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        firstName.sendKeys("Datta");
    }

    @Test
    public void fluentWaitTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.findElement(By.xpath("//a[@class='_42ft _4fy0 _6lt1 _4jy6 _4jy2 selected _51sy']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_42ft _4fy0 _6lt1 _4jy6 _4jy2 selected _51sy']")));
        driver.findElement(By.xpath("//input[@placeholder='firstname']")).sendKeys("demoname");
    }
}
