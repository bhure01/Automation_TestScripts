package com.bridgelabz.HandlingPopUpAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ChildBrowserPopUpTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void childBrowserPopUp() throws InterruptedException {
        driver.get("https://www.naukri.com/");

        String parentWindowHandleID = driver.getWindowHandle();
        System.out.println("ID of parent window: " + parentWindowHandleID);

        driver.findElement(By.xpath("//h3[contains(text(),'Prepare for your next interview')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Learn more')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'View all companies')]")).click();

        Set<String> allCurrentWindowHandleID = driver.getWindowHandles();

        int count = allCurrentWindowHandleID.size();
        // System.out.println("Total Number of child browser windows opened : " + count);

        for (String windowHandle : allCurrentWindowHandleID) {
               driver.switchTo().window(parentWindowHandleID);

            if (windowHandle.equals(parentWindowHandleID)) {
                System.out.println("Main browser window with title  --> " + driver.getTitle() + "----> is closed");
                driver.close();
            }
            if (!windowHandle.equals(parentWindowHandleID)) {
                System.out.println("Total : " + count + " Number of child windows are currently opened with handle ID: " + allCurrentWindowHandleID);
            }
        }
    }

    @Test
    public void closeOnlyMainBrowser() {
        driver.get("https://www.naukri.com/");

        String parentWindowhandleId = driver.getWindowHandle();

        driver.findElement(By.xpath("//h3[contains(text(),'Prepare for your next interview')]")).click();

        Set<String> allCurrentWindowHandles = driver.getWindowHandles();

        int count = allCurrentWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : "+ count);
        for (String windowHandle : allCurrentWindowHandles) {
            driver.switchTo().window(windowHandle);
         /*compare the window id with the Parent browser window id, if both are equal, then
         only close the main browser window.*/
            if (windowHandle.equals(parentWindowhandleId)) {
                driver.close();
                System.out.println("Main Browser window with title --> " + driver.getTitle() + " --> is closed");
            }
        }
    }
    @Test
    public void closeOnlyAllChildWindow() {
        driver.get("https://www.naukri.com/");

        String parentWindowHandleId = driver.getWindowHandle();

        driver.findElement(By.xpath("//h3[contains(text(),'Prepare for your next interview')]")).click();

        Set<String> allChildWindowHandles = driver.getWindowHandles();

        int count = allChildWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : "+ count);

        for (String windowHandle : allChildWindowHandles) {
            driver.switchTo().window(windowHandle);                //switch to each browser window
            String title = driver.getTitle();
            /* compare the window id of all the browsers with the Parent browser window id, if it
            is not equal, then only close the child browser windows.*/
            if (!windowHandle.equals(parentWindowHandleId)) {
                driver.close();
                System.out.println("Child Browser window with title -->"+ title +" --> is closed");
            }
        }
    }
    @Test
    public void closeParticularWindow() {
        driver.get("https://www.naukri.com/");

        String expected_title = "Tech Mahindra";
        Set<String> allChildWindowHandles = driver.getWindowHandles();
        int count = allChildWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : "+ count);
        for (String windowHandle : allChildWindowHandles) {
            driver.switchTo().window(windowHandle);
            String actual_title = driver.getTitle();

            if (actual_title.contains(expected_title)) {          //Checking whether the actual title contains the specified expected title
                driver.close();
                System.out.println("Specified Browser window with title -->"+ actual_title +" --> is closed");
            }
        }
    }
    @Test
    public void handleTabs_using_getWindowHandles() {

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
