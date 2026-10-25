package com.qa.api.tests;

import com.qa.api.config.ConfigManager;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConfigManagerTest extends BaseTest {

    @Test
    public void verifySelectedEnvironmentTest() {

        String expectedEnvironment = System.getProperty("env", "qa").trim().toLowerCase();

        String actualEnvironment = ConfigManager.getEnvironment();

        assertEquals(actualEnvironment, expectedEnvironment);
    }
    @Test
    public void verifyBaseUrlTest() {
        String actualBaseUrl = ConfigManager.getBaseUrl();

        assertEquals(actualBaseUrl, "https://dummyjson.com");
    }
}