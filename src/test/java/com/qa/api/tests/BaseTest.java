package com.qa.api.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Starting API test...");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("API test completed.");
    }
}