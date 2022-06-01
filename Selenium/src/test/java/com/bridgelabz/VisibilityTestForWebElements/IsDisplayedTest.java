package com.bridgelabz.VisibilityTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IsDisplayedTest {
    @Test
    public void isDisplayedTestFaceBookSignIn() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");

        // isDisplayed() method is applicable for all the web elements
        boolean b1 = driver.findElement(By.id("email")).isDisplayed();
        System.out.println("Email Text field is Displayed: " + b1);

       //boolean b2 = driver.findElement(By.id("pass")).isDisplayed();
       //System.out.println("Password Text field is Displayed: " + b2);
        WebElement passwd = driver.findElement(By.id("pass"));
        if (passwd.isEnabled()) {
            System.out.println("Password text field is displayed");
        }else {
            System.out.println("Password text field is NOT displayed");
        }

        WebElement we = driver.findElement(By.name("login"));
        boolean b3 = we.isDisplayed();
        System.out.println("Login Button is Displayed: " +b3);
           /* boolean b3 = driver.findElement(By.name("login")).isDisplayed();
            System.out.println("Login Button is Displayed: " + b3);*/

        boolean b4 = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).isDisplayed();
        System.out.println("Create New Account Button is Displayed: " + b4);
    }

    @Test
    public void isDisplayedTestHubSpotCRMSignUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://app.hubspot.com/signup-hubspot/crm");

        boolean b1 = driver.findElement(By.name("FIRST_NAME")).isDisplayed();
        System.out.println("First name text field is Displayed: " + b1);

        boolean b2 = driver.findElement(By.name("LAST_NAME")).isDisplayed();
        System.out.println("Last name text field is Displayed: " + b2);

        boolean b3 = driver.findElement(By.name("EMAIL")).isDisplayed();
        System.out.println("EmailID text field is Displayed: " + b3);

          /*boolean b4 = driver.findElement(By.xpath("//input[@class='UIIcon__IconContent-bwvgja-0 kMBlts']")).isDisplayed();
         System.out.println("Next button is Displayed: " + b4);*/
    }
}
