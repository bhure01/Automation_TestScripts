package com.bridgelabz.HandlingPopUpAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileDownloadPopUpTest {
    @Test
    public void fileDownloadPopUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/downloads/");
        
        driver.findElement(By.linkText("4.2.1")).click();
    }
}
