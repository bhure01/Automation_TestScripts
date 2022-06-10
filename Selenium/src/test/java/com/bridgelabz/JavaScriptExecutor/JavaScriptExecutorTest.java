package com.bridgelabz.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
//    @Test(enabled = false)
    public void enterText_intoDisabledTextBox() throws InterruptedException {
        driver.get("/home/ubuntu/Automation_TestScripts/Selenium/src/main/resources/JavaScriptExecutor/disabledTextField.html");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        jsExecutor.executeScript("document.getElementById('t1').value=''");
        Thread.sleep(2000);
        jsExecutor.executeScript("document.getElementById('t1').value='re written text in text field 1'");
        Thread.sleep(2000);
        // clear the value in second text box using javascript
        jsExecutor.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(2000);
        jsExecutor.executeScript("document.getElementById('t2').value='text field 2'");
       /* change the second text box to button type using Javascript
          jsExecutor.executeScript("document.getElementById('t2').type='button'"); */
        Thread.sleep(4000);
        driver.close();

    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
