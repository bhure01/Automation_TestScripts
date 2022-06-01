package com.bridgelabz.VisibilityTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IsEnabledTest {
    @Test
    public void isEnabledTestFaceBookSignIn() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");

        // isEnabled() method is applicable for all the web elements

        // boolean b1 = driver.findElement(By.id("email")).isEnabled();
        // System.out.println("Email Text field is Enabled: " + b1);

        WebElement userName = driver.findElement(By.id("email"));
        if (userName.isEnabled()) {
            System.out.println("Email-Username text box is enabled");
        }else {
            System.out.println("Email-Username text box is disabled");
        }

        boolean b2 = driver.findElement(By.id("pass")).isEnabled();
        System.out.println("Password Text field is Enabled: " + b2);

        boolean b3 = driver.findElement(By.name("login")).isEnabled();
        System.out.println("Login Button is Enabled: " + b3);

        boolean b4 = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).isEnabled();
        System.out.println("Create New Account Button is Enabled: " + b4);


    }


    @Test
    public void isEnabledTestHubSpotCRMSignUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://app.hubspot.com/signup-hubspot/crm");

        boolean b1 = driver.findElement(By.name("FIRST_NAME")).isEnabled();
        System.out.println("First name text field is Enabled: " + b1);

        // boolean b2 = driver.findElement(By.name("LAST_NAME")).isEnabled();
        // System.out.println("Last name text field is Enabled: " + b2);

        WebElement lastName = driver.findElement(By.name("LAST_NAME"));
        if (lastName.isEnabled()) {
            System.out.println("Last Name text box is enabled");
        }else {
            System.out.println("Last Name box is disabled");
        }

        boolean b3 = driver.findElement(By.name("EMAIL")).isEnabled();
        System.out.println("EmailID text field is Enabled: " + b3);

        /*boolean b4 = driver.findElement(By.xpath("//input[@class='UIIcon__IconContent-bwvgja-0 kMBlts']")).isEnabled();
        System.out.println("Next Button is Enabled: " + b4);*/
    }
}
