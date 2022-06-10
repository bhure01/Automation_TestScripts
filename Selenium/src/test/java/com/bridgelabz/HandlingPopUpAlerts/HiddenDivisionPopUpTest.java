package com.bridgelabz.HandlingPopUpAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HiddenDivisionPopUpTest {

    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-geolocation");
        //options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void facebookHiddenDivisionPop_upTest() throws InterruptedException {
        driver.get("http://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("bhurend579@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("--------");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Dattatri Bhure')]")).click();
    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
