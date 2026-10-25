
package com.qa.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        String environment = System.getProperty("env", "qa")
                .trim()
                .toLowerCase();

        if (!environment.equals("qa")
                && !environment.equals("stage")) {
            throw new IllegalArgumentException(
                    "Unsupported environment: " + environment
                            + ". Supported environments: qa, stage");
        }

        String configFile = "config-" + environment + ".properties";

        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream(configFile)) {

            if (input == null) {
                throw new IllegalStateException(
                        configFile + " not found in test resources");
            }

            PROPERTIES.load(input);

        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConfigManager() {
        // Prevent object creation
    }

    public static String getBaseUrl() {
        String baseUrl = PROPERTIES.getProperty("base.url");

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalStateException(
                    "Missing required property: base.url");
        }

        return baseUrl.trim();
    }

    public static String getEnvironment() {
        return System.getProperty("env", "qa")
                .trim()
                .toLowerCase();
    }
}
