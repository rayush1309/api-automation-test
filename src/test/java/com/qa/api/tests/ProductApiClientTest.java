
package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProductApiClientTest extends BaseTest {

    @Test
    public void validateProductUsingApiClientTest() {

        ProductApiClient productApiClient = new ProductApiClient();

        Response response = productApiClient.getProductById(1);

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertNotNull(response.jsonPath().getString("title"));
    }

    @Test
    public void validateProductListUsingApiClientTest() {

        ProductApiClient productApiClient = new ProductApiClient();

        Response response = productApiClient.getAllProducts();

        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getList("products"));
        System.out.println(response.jsonPath().getList("products"));
    }
}
