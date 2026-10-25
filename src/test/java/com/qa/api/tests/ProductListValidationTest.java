package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ProductListValidationTest extends BaseTest {

    @Test
    public void validateProductListTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Extract all product titles
        List<String> titles =
                response.jsonPath().getList("products.title");

        // Validate the list
        assertNotNull(titles);
        assertFalse(titles.isEmpty());

        // Validate first product title
        assertNotNull(titles.get(0));
        assertFalse(titles.get(0).isBlank());

        // Validate total products returned
        int total = response.jsonPath().getInt("total");
        assertTrue(total > 0);

        System.out.println("Total products: " + total);
        System.out.println("First product: " + titles.get(0));
        System.out.println("All product titles: " + titles);
    }
}