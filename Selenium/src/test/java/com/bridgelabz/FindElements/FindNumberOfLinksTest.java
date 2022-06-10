package com.bridgelabz.FindElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindNumberOfLinksTest {
    WebDriver driver = null;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void findNumberOfLinksIn_Facebook_SignInPage() {
        driver.get("https://www.facebook.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int totalLinks = allLinks.size();
        System.out.println("Total number of links present on the Facebook SignIn page are : "+totalLinks);

        int visibleLinkCount = 0;
        int hiddenLinkCount = 0;

        for (WebElement link : allLinks) {
            if (link.isDisplayed()) {
                visibleLinkCount++;
                System.out.println(visibleLinkCount+ " --> " +link.getText());
            }else{
                hiddenLinkCount++;
            }
        }

        System.out.println("Total number of visible links are :" + visibleLinkCount);
        System.out.println("Total number of hidden links are :" + hiddenLinkCount);

        int sum = visibleLinkCount + hiddenLinkCount;
        System.out.println("Sum of Hidden and visible links is : " +sum);

        driver.close();
    }
    @Test
    public void findNumberOfLinksIn_Facebook_SignUpPage() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int totalLinks = allLinks.size();
        System.out.println("Total number of links present on the Facebook SignUp page are : "+totalLinks);

        int visibleLinkCount = 0;
        int hiddenLinkCount = 0;

        for (WebElement link : allLinks) {
            if (link.isDisplayed()) {
                visibleLinkCount++;
                System.out.println(visibleLinkCount+ " --> " +link.getText());
            }else{
                hiddenLinkCount++;
            }
        }

        System.out.println("Total number of visible links are :" + visibleLinkCount);
        System.out.println("Total number of hidden links are :" + hiddenLinkCount);

        int sum = visibleLinkCount + hiddenLinkCount;
        System.out.println("Sum of Hidden and visible links is : " +sum);

        driver.close();
    }
    @Test
    public void findNumberOfLinksIn_Facebook_HomePage() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("bhurend579@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("*********************");
        driver.findElement(By.name("login")).click();


        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int totalLinks = allLinks.size();
        System.out.println("Total number of links present on the Facebook HomePage are : "+totalLinks);

        int visibleLinkCount = 0;
        int hiddenLinkCount = 0;
           // iterate through all the links using foreach loop
        for (WebElement link : allLinks) {
            if (link.isDisplayed()) {
                visibleLinkCount++;
                System.out.println(visibleLinkCount+ " --> " +link.getText());
            }else{
                hiddenLinkCount++;
            }
        }

        System.out.println("Total number of visible links are :" + visibleLinkCount);
        System.out.println("Total number of hidden links are :" + hiddenLinkCount);

        int sum = visibleLinkCount + hiddenLinkCount;
        System.out.println("Sum of Hidden and visible links is : " +sum);

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
