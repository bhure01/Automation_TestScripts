package com.bridgelabz.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void frameTest() throws InterruptedException {

        driver.get("file:///home/ubuntu/SeleniumAutomationTestScripts/Selenium/src/main/resources/Frames/page2.html");

        driver.findElement(By.id("t2")).sendKeys("T2 text field");

        driver.switchTo().frame("f1");
        Thread.sleep(2000);
        driver.findElement(By.id("t1")).sendKeys("T1 text field");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("f2");
        Thread.sleep(2000);
        driver.findElement(By.id("t3")).sendKeys("T3 text field");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("t2")).sendKeys("Re entered text");
    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void enterText_into_element_whichIsPresentInsideFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///home/ubuntu/SeleniumAutomationTestScripts/Selenium/src/main/resources/Frames/Page5.html");

        // 1. Using index of the frame - [ int value] [ index of frames starts with zero]
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        driver.findElement(By.id("t4")).sendKeys("a");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.id("t5")).sendKeys("a");
        Thread.sleep(1000);

        // 2. Using id attribute of the frame -string
        driver.switchTo().frame("f5");
        Thread.sleep(1000);
        driver.findElement(By.id("t4")).sendKeys("b");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.id("t5")).sendKeys("b");
        Thread.sleep(1000);

        // 3. Using name attribute of the frame -string
        driver.switchTo().frame("n5");
        Thread.sleep(1000);
        driver.findElement(By.id("t4")).sendKeys("c");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.id("t5")).sendKeys("c");
        Thread.sleep(1000);

        // 4. Using address of the frame -webelement
        WebElement element = driver.findElement(By.className("c5"));
        driver.switchTo().frame("f5");
        Thread.sleep(1000);
        driver.findElement(By.id("t4")).sendKeys("d");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.id("t5")).sendKeys("d");
        Thread.sleep(1000);
        driver.close();
    }
}
