package com.bridgelabz.HandlingPopUpAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptPopUpTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void javaScriptPopUpTest() throws InterruptedException {
        driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");

        driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        System.out.println("Alert Text-Message displayed before entering name: " + alert.getText());
        Thread.sleep(2000);

        alert.sendKeys("Datta");
        Thread.sleep(2000);

        alert.accept();
        Thread.sleep(2000);

        System.out.println("Message displayed after entering name: " + alert.getText());

        alert.dismiss();
    }
    @Test
    public void javascriptPopUpAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. Alert popup  --> alert window with OK button
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        // 2. confirmation popup --> alert window with OK & Cancel button
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Thread.sleep(1000);
            //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        // 3. prompt popup --> alert window with input text and print the message displayed
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Message displayed on pop up alert window: " +alert.getText());
        Thread.sleep(2000);

        alert.sendKeys("hi");
        Thread.sleep(1000);
        alert.accept();
    }
    @Test
    public void ksrtcBusBooking() {
        driver.get("http://www.ksrtc.in/oprs-web/");
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
        Alert alert = driver.switchTo().alert();
        //alert.accept();
        //alert.dismiss();
        driver.quit();
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
