package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CreateAccount {
    @Test
    public void signUpFacebook() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("demo");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("account");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("demo123@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("demo123@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("da123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("15");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("June");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1990");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void signUpFB() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        List<WebElement> gender = driver.findElements(By.name("sex"));
        // 1st index to select male gender
        gender.get(1).click();
        // 0th index to select female gender
        // gender.get(0).click();
        // 2nd index to select custom gender
        // gender.get(1).click();
    }
}
