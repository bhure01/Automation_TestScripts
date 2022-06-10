package com.bridgelabz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class CrossBrowserTest {
    public void signUpWithChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Create New Account")).click();
    }

    public void signInWithFirefoxBrowser() throws InterruptedException {
        // System.setProperty("webdriver.firefox.driver", "/home/ubuntu/WebDrivers/geckodriver");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("test@12345");
        driver.findElement(By.name("login")).click();
    }

    public void createAccountWithEdgeBrowser() throws InterruptedException {
        // System.setProperty("webdriver.edge.driver", "/home/ubuntu/WebDrivers/msedgedriver");
        WebDriverManager.firefoxdriver().setup();
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


    public static void main(String[] args) throws InterruptedException {
        CrossBrowserTest browser = new CrossBrowserTest();
        WebDriver driver = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Driver for: \n 1: Chrome Browser \n 2: Firefox Browser \n 3: Edge Browser \n 4: Safari Browser");
        System.out.println("Enter the choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // System.setProperty("webdriver.chrome.driver", "/home/ubuntu/WebDrivers/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Chrome Browser Launched");
                browser.signUpWithChromeBrowser();
                break;
            case 2:
                // System.setProperty("webdriver.firefox.driver", "/home/ubuntu/WebDrivers/geckodriver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("Firefox Browser Launched");
                browser.signInWithFirefoxBrowser();
                break;
            case 3:
                // System.setProperty("webdriver.edge.driver", "/home/ubuntu/WebDrivers/msedgedriver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("Edge Browser Launched");
                browser.createAccountWithEdgeBrowser();
                break;
            case 4:
                System.setProperty("webdriver.safari.driver", "/home/ubuntu/WebDrivers/safaridriver");
                driver = new SafariDriver();
                System.out.println("Safari Browser Launched");
                break;
        }
    }
}

