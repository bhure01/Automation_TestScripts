package com.bridgelabz.HandlingPopUpAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadPopUpTest {

    @Test
    public void fileUploadPopUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[2]")).
                sendKeys("/home/ubuntu/db.json");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-success btn-xs']")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
