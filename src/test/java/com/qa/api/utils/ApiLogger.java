
package com.qa.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApiLogger {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApiLogger.class);

    private ApiLogger() {
        // Prevent object creation
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }
}
