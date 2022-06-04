package com.bridgelabz.KeyBoardOperations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsClassTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void mouseHoverTest() throws InterruptedException {
        driver.get("https://www.istqb.in");
        Actions actions = new Actions(driver);
        WebElement foundation = driver.findElement(By.xpath(("//a[contains(text(),'Foundation')]")));
        actions.moveToElement(foundation).perform();
        Thread.sleep(2000);

        actions.moveToElement(foundation).perform();
        Thread.sleep(2000);
        WebElement enrollment = driver.findElement(By.xpath("(//span[text()='ENROLLMENT'])[1]"));

        actions.moveToElement(enrollment).perform();
        Thread.sleep(3000);
        WebElement corporateEnrol = driver.findElement(By.xpath("//span[text()='CORPORATE ENROLLMENT']"));

        actions.moveToElement(corporateEnrol).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='ONLINE ENROLLMENT']")).click();
        driver.close();
    }

    @Test
    public void dragAndDropTest() {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")),
                driver.findElement(By.id("droppable"))).perform();

    }
    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://www.gmail.com");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("enter your username");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("enter ");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(1000);
        String xp = "(//b[contains(.,'Following Openings (for Bangalore)')])[2]";
        WebElement mail = driver.findElement(By.xpath(xp));
        System.out.println(mail.getText());//Creating an object of Actions class
        Actions actions = new Actions(driver);
        //using Actions class object and contextClick() method, right click on the mail item
        actions.contextClick(mail).perform();
        Thread.sleep(6000);
        //click on Archive to archive the mail
        driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
    }


    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
