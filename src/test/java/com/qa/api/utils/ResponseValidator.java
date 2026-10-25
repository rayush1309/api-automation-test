
package com.qa.api.utils;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;

public final class ResponseValidator {

    private ResponseValidator() {
        // Prevent object creation
    }

    public static void validateStatusCode(Response response, int expectedStatusCode) {

        assertEquals(response.statusCode(), expectedStatusCode, "Unexpected API status code");
    }

    public static void validateStringFieldNotEmpty(Response response, String jsonPath) {

        String value = response.jsonPath().getString(jsonPath);

        assertNotNull(value, "Field should not be null: " + jsonPath);
        assertFalse(value.isBlank(), "Field should not be blank: " + jsonPath);
    }
}
