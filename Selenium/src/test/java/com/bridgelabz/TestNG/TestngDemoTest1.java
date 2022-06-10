package com.bridgelabz.TestNG;

import org.testng.annotations.*;

public class TestngDemoTest1 {

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {

        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass() {

        System.out.println("beforeClass");
    }
    @AfterClass
    public void afterClass() {

        System.out.println("afterClass");
    }@BeforeTest
    public void beforeTest() {

        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest() {

        System.out.println("afterTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }
    @Test
    public void abc() {
        System.out.println("abc");
    }
    @Test
    public void def() {
        System.out.println("def");
    }
    @Test
    public void xyz() {
        System.out.println("xyz");
    }
}

