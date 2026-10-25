package com.qa.api.tests;

import com.qa.api.utils.ApiLogger;
import org.testng.annotations.Test;

public class ApiLoggerTest extends BaseTest {

    @Test
    public void verifyLoggingTest() {
        ApiLogger.info("Starting API test");
        ApiLogger.error("Example error log for practice");
    }
}