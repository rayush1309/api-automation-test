package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProductJsonPathValidationTest extends BaseTest {

    @Test
    public void validateProductUsingJsonPathTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/1")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        int productId = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        double price = response.jsonPath().getDouble("price");

        assertEquals(productId, 1);
        assertNotNull(title);
        assertEquals(price, 9.99);

        System.out.println("Product ID: " + productId);
        System.out.println("Product Title: " + title);
        System.out.println("Product Price: " + price);
    }
}