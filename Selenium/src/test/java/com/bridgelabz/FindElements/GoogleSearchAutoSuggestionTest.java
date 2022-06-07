package com.bridgelabz.FindElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchAutoSuggestionTest {
    @Test
    public void autoSuggestionTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("selenium");
        Thread.sleep(2000);

        List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        int count = allOptions.size();
        System.out.println("Number of Auto suggestion values found in the  dropdown are : " + count);
        String expectedValue = "selenium download";

        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(" " + text);
            if (text.equalsIgnoreCase(expectedValue)) {
                option.click();
                break;
            }
        }
    }
}
