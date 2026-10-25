package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductPutClientTest extends BaseTest {

    @Test
    public void updateProductUsingPutTest() {

        ProductApiClient client = new ProductApiClient();

        String requestBody = """
                {
                    "title": "Complete Product Update",
                    "price": 149.99,
                    "description": "Updated using PUT"
                }
                """;

        Response response = client.updateProductUsingPut(1, requestBody);

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("title"), "Complete Product Update");
        assertEquals(response.jsonPath().getDouble("price"), 149.99);
    }
}