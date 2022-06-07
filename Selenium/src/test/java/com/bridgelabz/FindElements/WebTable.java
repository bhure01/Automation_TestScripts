package com.bridgelabz.FindElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {
    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void calculateTotalNumberOfTableRows() throws InterruptedException {
        driver.get("file:///home/ubuntu/Automation_TestScripts/Selenium/src/main/resources/WebTable/WebTable.html");
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("Total number of rows present in the table are : " +totalRows);
    }
    @Test
    public void calculateTotalNumberOfTableColumns() {
        driver.get("file:///home/ubuntu/Automation_TestScripts/Selenium/src/main/resources/WebTable/WebTable.html");
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("Total number of columns present in the table are : " +totalColumns);
    }
    @Test
    public void calculateTotalNumberOfCells() {
        driver.get("file:///home/ubuntu/Automation_TestScripts/Selenium/src/main/resources/WebTable/WebTable.html");
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is :" + totalCells);
    }
    @Test
    public void printOnlyNumericNumbers() throws InterruptedException {
        driver.get("file:///home/ubuntu/Automation_TestScripts/Selenium/src/main/resources/WebTable/WebTable.html");
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int countNumberValue = 0;
        int sum=0;
        for (WebElement cell : allCells) {
            String cellValue = cell.getText();
            try{
                int number = Integer.parseInt(cellValue);
                System.out.print("," +number);
                countNumberValue++;
                sum = sum+number;
            }catch (Exception e) {
            }
        }

        System.out.println("Total count of numeric values is :"+countNumberValue);
        System.out.println("Total sum of all the numeric values is :"+sum);
        Thread.sleep(2000);
        driver.close();
    }
    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

