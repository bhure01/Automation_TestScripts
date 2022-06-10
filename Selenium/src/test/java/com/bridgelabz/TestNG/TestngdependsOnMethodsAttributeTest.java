package com.bridgelabz.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngdependsOnMethodsAttributeTest {
    @Test(priority=1)
    public void createUser(){
        System.out.println("createUser");
        Assert.fail();
    }
    @Test(priority=3, dependsOnMethods="createUser")
    public void deleteUser(){
        System.out.println("deleteUser");
    }
}
