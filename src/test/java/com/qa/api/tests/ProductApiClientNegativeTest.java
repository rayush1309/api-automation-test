package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductApiClientNegativeTest extends BaseTest {

    @Test
    public void validateNonExistingProductTest() {

        ProductApiClient client = new ProductApiClient();

        Response response = client.getProductById(99999);

        assertEquals(response.statusCode(), 404);
    }
}