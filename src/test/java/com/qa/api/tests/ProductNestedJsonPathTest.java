package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ProductNestedJsonPathTest extends BaseTest {

    @Test
    public void validateNestedFieldsAndArrayTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/1")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Validate a nested JSON field
        double width =
                response.jsonPath().getDouble("dimensions.width");

        assertTrue(width > 0);

        // Validate an array
        List<String> tags =
                response.jsonPath().getList("tags");

        assertNotNull(tags);
        assertFalse(tags.isEmpty());

        // Validate the first array element
        String firstTag =
                response.jsonPath().getString("tags[0]");

        assertNotNull(firstTag);

        System.out.println("Product width: " + width);
        System.out.println("Product tags: " + tags);
        System.out.println("First tag: " + firstTag);
    }
}