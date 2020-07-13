package com.geekbrains.georgy.lesson11;

import com.geekbrains.georgy.lesson11.annotation.AfterSuite;
import com.geekbrains.georgy.lesson11.annotation.BeforeSuite;
import com.geekbrains.georgy.lesson11.annotation.Test;


public class CustomTest {
    @Test(priority = 2)
    public static void voice(){
        System.out.println("priority 2");
    }

    @BeforeSuite
    void before() {
        System.out.println("Before test");
    }

    @Test(priority = 6)
    void test1() {
        System.out.println("priority 6");
    }

    @Test(priority = 10)
     void test2(){
        System.out.println("priority 10");
    }

    @AfterSuite
    void after(){
        System.out.println("After test");
    }

    @Test(priority = 5)
    void test3() {
        System.out.println("priority 5");
    }
}

