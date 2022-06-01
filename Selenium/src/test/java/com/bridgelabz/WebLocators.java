package com.bridgelabz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebLocators {
    @Test
    public void webLocatorsDemoTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        // Enter the URL of your own created sample web page
        // driver.get("/home/ubuntu/UN.html");

        WebElement usernameTB = driver.findElement(By.id("email"));
        usernameTB.sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        usernameTB.clear();
        usernameTB.sendKeys("dattatribhure@gmail.com");
        Thread.sleep(2000);

        WebElement passwordTB = driver.findElement(By.id("pass"));
        passwordTB.sendKeys("demo12345");
        Thread.sleep(2000);
        passwordTB.clear();
        passwordTB.sendKeys("dattatribhure@456123");
        Thread.sleep(2000);

        //driver.findElement(By.linkText("login to facebook")).click();
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
