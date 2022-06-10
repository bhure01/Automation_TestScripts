package com.bridgelabz.AlignmentTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DimensionsCheckFB {
    @Test
    public void getLocationOfWebElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement unTB = driver.findElement(By.id("email"));
        int username_Ycoordinates = unTB.getLocation().getY();
        System.out.println("Username TextBox : Y Coordinates = " + username_Ycoordinates);

        WebElement passwdTB = driver.findElement(By.id("pass"));
        int password_Ycoordinates = unTB.getLocation().getY();
        System.out.println("Password TextBox: Y Coordinates = " + password_Ycoordinates);

        if (username_Ycoordinates == password_Ycoordinates) {
            System.out.println("Both Username and Password text boxes are aligned in same row");
        } else {
            System.out.println("Both Username and Password text boxes are NOT aligned in same row");
        }

        System.out.println("------------------------------------");

        int username_Xcordinates = driver.findElement(By.id("email")).getLocation().getX();
        System.out.println("Username TextBox: X Coordinates = " + username_Xcordinates);

        int password_Xcoordinates = driver.findElement(By.id("pass")).getLocation().getX();
        System.out.println("Password TextBox: X Coordinates = " + password_Xcoordinates);

        if (username_Xcordinates == password_Xcoordinates) {
            System.out.println("Both username and password text boxes are aligned properly ");
        } else {
            System.out.println("Both Username and Password text boxes are NOT aligned in same row");
        }
        driver.close();
    }

    @Test
    public void getSizeOfWebElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement usernameTB = driver.findElement(By.id("email"));
        int username_width = usernameTB.getSize().getWidth();
        System.out.println("Username TextBox: WIDTH = " + username_width);
        int username_height = usernameTB.getSize().getHeight();
        System.out.println("Username TextBox: HEIGHT = " + username_height);

        WebElement passwdTB = driver.findElement(By.id("pass"));
        int password_width = passwdTB.getSize().getWidth();
        System.out.println("Password TextBox: WIDTH = " + password_width);
        int password_height = passwdTB.getSize().getHeight();
        System.out.println("Password TextBox: HEIGHT = " + password_height);

        System.out.println("---------------------------");

        if (username_width == password_width && username_height == password_height) {
            System.out.println("Both Username and Password text boxes are aligned are aligned properly");
        } else {
            System.out.println("Both Username and Password text boxes are NOT aligned properly");
        }
        driver.close();
    }

    @Test
    public void checkAlignmentOfWebElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement usernameTB = driver.findElement(By.id("email"));

        int username_Xcordinates = usernameTB.getLocation().getX();
        System.out.println(username_Xcordinates);

        int username_width = usernameTB.getSize().getWidth();
        int username_height = usernameTB.getSize().getHeight();

        WebElement passwdTB = driver.findElement(By.id("pass"));

        int password_Xcoordinates = passwdTB.getLocation().getX();
        System.out.println(password_Xcoordinates);

        int password_width = usernameTB.getSize().getWidth();
        int password_height = usernameTB.getSize().getHeight();

        if (username_Xcordinates == password_Xcoordinates && username_width == password_width && username_height == password_height) {
            System.out.println("Both the username and password text box fields are ALIGNED properly");
        }else{
            System.out.println("Both the username and password text box fields are NOT ALIGNED properly");
        }
    }
}
