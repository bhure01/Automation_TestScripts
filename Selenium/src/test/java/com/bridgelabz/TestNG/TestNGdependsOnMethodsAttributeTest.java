package com.bridgelabz.TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGdependsOnMethodsAttributeTest {

    @Test(dependsOnMethods = "def")
    public void abc() {
        System.out.println("abc");
    }
    @Test
    public void def() {
        System.out.println("def");
        Assert.assertEquals(200,201);
    }
    @Test
    public void xyz() {
        System.out.println("xyz");
    }

    @BeforeMethod
    public void beforeMethod() {
    }
    @AfterMethod
    public void afterMethod() {
    }
    @BeforeClass
    public void beforeClass() {
    }
    @AfterClass
    public void afterClass() {
    }
    @BeforeTest
    public void beforeTest() {
    }
    @AfterTest
    public void afterTest() {
    }
    @BeforeSuite
    public void beforeSuite() {
    }
    @AfterSuite
    public void afterSuite() {
    }

}
