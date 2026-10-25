package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import com.qa.api.models.Product;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProductDeserializationTest extends BaseTest {

    @Test
    public void getProductAndDeserializeToPojoTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/1")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        Product product = response.as(Product.class);

        assertEquals(product.getId(), 1);
        assertNotNull(product.getTitle());
        assertEquals(product.getPrice(), 9.99);

        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Title: " + product.getTitle());
        System.out.println("Product Price: " + product.getPrice());
    }
}