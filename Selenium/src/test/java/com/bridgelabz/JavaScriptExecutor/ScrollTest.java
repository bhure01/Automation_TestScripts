package com.bridgelabz.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollTest {
    @Test
    public void scrollUpAndDownTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.morningstar.in/default.aspx");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Thread.sleep(2000);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //scroll down on the webpage
        for (int i = 1; i <= 5; i++) {
            jsExecutor.executeScript("window.scrollBy(0, 300)");
            Thread.sleep(2000);
        }

        Thread.sleep(3000);

        //scroll up(reverse direction) on the webpage
        for (int i = 1; i <= 5; i++) {                                     // (int i = 0; i < 5; i++)
            jsExecutor.executeScript("window.scrollBy(0, -300)");
            Thread.sleep(2000);
        }
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void scrollRightAndLeftTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.morningstar.in/default.aspx");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Thread.sleep(2000);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // scroll right on the webpage
        for (int i = 0; i < 5; i++) {
            jsExecutor.executeScript("window.scrollBy(50, 0)");
            Thread.sleep(2000);
        }
        Thread.sleep(3000);
        // scroll left(reverse direction) on the webpage
        for (int i = 0; i < 5; i++) {
            jsExecutor.executeScript("window.scrollBy(-50, 0)");
            Thread.sleep(2000);
        }
    }

    @Test
    public void scrollDownToSpecificElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/downloads/");

        //click on the close icon of the yellow color background pop up
        driver.findElement(By.id("close")).click();

        //find the Applitools element on the webpage
        WebElement element = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));

        // get the X-coordinate and store in a variable
        int x = element.getLocation().getX();             // get the Y-coordinate and store in a variable
        int y = element.getLocation().getY();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //Scroll to Applitools element’s x and y coordinate
        jsExecutor.executeScript("window.scrollBy("+x+", "+y+")");
        Thread.sleep(3000);
    }
}
