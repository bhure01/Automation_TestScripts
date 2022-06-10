package com.bridgelabz.TestNG;

import org.testng.annotations.Test;

public class TestngGroupsAttributeTest {

    @Test(priority=1, groups={"user", "smoke"})
    public void createUser() {
        System.out.println("CreateUser");
    }
    @Test(priority=2, invocationCount=2, enabled=true, groups={"user"})
    public void editUser(){
            System.out.println("editUser");
    }
    @Test(priority=3, groups={"user"})
    public void deleteUser(){
            System.out.println("deleteUser");
    }
    @Test(priority=1, groups={"product", "smoke"})
    public void createProduct(){
            System.out.println("createProduct");
    }
    @Test(priority=2, invocationCount=1, enabled=true, groups={"product"})
    public void editProduct(){
            System.out.println("editProduct");
    }
    @Test(priority=3, groups={"product"})
    public void deleteProduct(){
            System.out.println("deleteProduct");}
}
