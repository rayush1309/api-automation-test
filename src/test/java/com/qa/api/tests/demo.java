package com.qa.api.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Setup");
    }

    @Test
    public void failedTest() {
        Assert.fail("Intentional failure");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Cleanup");
    }
}

/*
TestNG mein @AfterMethod har test method ke baad run hota hai,
chahe test pass ho ya fail. Iska use cleanup,
temporary resources release karne aur test ke baad logging ke liye kar sakte hain.
 */
