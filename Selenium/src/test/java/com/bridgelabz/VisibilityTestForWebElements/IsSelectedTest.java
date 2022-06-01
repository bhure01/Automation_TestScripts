package com.bridgelabz.VisibilityTestForWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IsSelectedTest {

    @Test
    public void isSelectedTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

        //driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        // isSelected() method is applicable only for checkbox, radio button and drop downs
        // 1. isSelected() method for drop downs
        // boolean b1 = driver.findElement(By.xpath("//select[@name='birthday_day']")).isSelected();
        boolean b1 = driver.findElement(By.name("birthday_day")).isSelected();
        System.out.println("isSelected; " + b1);
        driver.findElement(By.name("birthday_day")).click();
        Thread.sleep(2000);

        boolean b2 = driver.findElement(By.name("birthday_month")).isSelected();
        System.out.println(b2);
        driver.findElement(By.name("birthday_month")).click();
        Thread.sleep(2000);


        boolean b3 = driver.findElement(By.name("birthday_year")).isSelected();
        System.out.println(b3);
        driver.findElement(By.name("birthday_year")).click();
        Thread.sleep(2000);

        // 2.1 -> isSelected() method for Radio buttons
        List<WebElement> gender = driver.findElements(By.name("sex"));
        boolean b4 = gender.get(0).isSelected();
        System.out.println(b4);      // false
        gender.get(0).click();       //true
//        System.out.println("Checkbox is selected for female:" );
        Thread.sleep(2000);

        boolean b5 = gender.get(1).isSelected();
        System.out.println(b5);
        gender.get(1).click();
        Thread.sleep(2000);

        /*boolean b6 = gender.get(2).isSelected();
        System.out.println(b6);*/
        gender.get(2).click();
        System.out.println("isSelected: " + gender.get(2).isSelected());
    }

    // 2.2-> isSelected() method for Radio buttons
    @Test
    public void isSelectedTest_RadioButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/radio.html");

        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radio3 = driver.findElement(By.id("vfb-7-3"));

        radio1.click();
        System.out.println("Radio Button Option 1 Selected");
        Thread.sleep(1000);

        radio2.click();
        System.out.println("Radio Button 1 is de-selected and Radio Button 2 is selected");
        Thread.sleep(1000);
    }

    // 3 isSelected() method for checkbox
    @Test
    public void isSelectedTest_CheckBox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/radio.html");
        // https://www.guru99.com/checkbox-and-radio-button-webdriver.html

        WebElement option1 = driver.findElement(By.id("vfb-6-0"));
        option1.click();
        Thread.sleep(1000);

        WebElement option2 = driver.findElement(By.id("vfb-6-1"));
        option2.click();
        Thread.sleep(1000);

        WebElement option3 = driver.findElement(By.id("vfb-6-2"));
        option3.click();
        Thread.sleep(1000);

        if (option1.isSelected()) {
            System.out.println("Checkbox1 is Toggled on");
        } else {
            System.out.println("Checkbox1 is Toggled off");
        }

        option1.click();  // checkbox 1 is Toggled off now
        //option2.click();
        //option3.click();

        if (!option1.isSelected()) {
            System.out.println("Checkbox1 is Toggled off");
        }

        //Selecting Checkbox and using isSelected Method
        driver.get("http://demo.guru99.com/test/facebook.html");
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
        for (int i=0; i<2; i++) {
            chkFBPersist.click ();
            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());
        }
        Thread.sleep(2000);
        driver.close();
    }
}
