package com.bridgelabz.AlignmentTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HubSpotAlignmentTest {
    @Test
    public void alignmentTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.hubspot.com/login");

        WebElement usernameTB = driver.findElement(By.id("username"));

        int username_Xcordinates = usernameTB.getLocation().getX();
        System.out.println(username_Xcordinates);

        int username_width = usernameTB.getSize().getWidth();
        int username_height = usernameTB.getSize().getHeight();

        WebElement passwdTB = driver.findElement(By.id("password"));

        int password_Xcoordinates = passwdTB.getLocation().getX();
        System.out.println(password_Xcoordinates);

        int password_width = usernameTB.getSize().getWidth();
        int password_height = usernameTB.getSize().getHeight();

        if (username_Xcordinates == password_Xcoordinates && username_width == password_width && username_height == password_height) {
            System.out.println("Both the username and password text box fields are ALIGNED properly");
        } else {
            System.out.println("Both the username and password text box fields are NOT ALIGNED properly");
        }
        driver.close();
    }
}
