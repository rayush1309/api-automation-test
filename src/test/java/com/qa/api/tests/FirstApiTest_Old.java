
package com.qa.api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import com.qa.api.config.ConfigManager;

public class FirstApiTest_Old {

    @Test
    public void getProductByIdTest() {

        Response response =
                given()
                        .baseUri(ConfigManager.getBaseUrl())
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .response();

        // Validate HTTP status code
        assertEquals(response.statusCode(), 200);

        // Validate response data
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertNotNull(response.jsonPath().getString("title"));

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Product ID: " + response.jsonPath().getInt("id"));
        System.out.println("Product Title: " + response.jsonPath().getString("title"));


    }
}
