package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import com.qa.api.models.Product;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProductSerializationTest extends BaseTest {

    @Test
    public void createProductUsingPojoTest() {

        // Create a Java object
        Product product = new Product();
        product.setTitle("API Automation Product");
        product.setPrice(99.99);

        // Send the POJO as the request body
        Response response =
                given()
                        .spec(RequestSpecFactory.getJsonRequestSpecification())
                        .body(product)
                        .when()
                        .post("/products/add")
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        // Validate the response
        assertEquals(
                response.jsonPath().getString("title"),
                "API Automation Product"
        );

        assertEquals(response.jsonPath().getDouble("price"), 99.99);

        assertNotNull(response.jsonPath().get("id"));

        System.out.println("Created Product: "
                + response.jsonPath().getString("title"));
        System.out.println("Product ID: "
                + response.jsonPath().getInt("id"));
    }
}