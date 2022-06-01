package com.bridgelabz.KeyBoardOperations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClassTest {
    @Test
    public void keyboardOperations() throws InterruptedException {
        /*WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // move the mouse by X and Y coordinates
        robot.mouseMove(300,500);
        Thread.sleep(5000);
        // Press the keys in an order Control+Shift+N
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_N);
        Thread.sleep(100);
        // Release the keys in reverse order
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);
        robot.mouseMove(300,500);

        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_I);
        Thread.sleep(100);

        robot.keyRelease(KeyEvent.VK_I);
        Thread.sleep(100);

        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(100);

        robot.keyRelease(KeyEvent.VK_C);
        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
    }
}
