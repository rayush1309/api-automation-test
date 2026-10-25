package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductPatchClientTest extends BaseTest {

    @Test
    public void updateProductTitleUsingClientTest() {

        ProductApiClient client = new ProductApiClient();

        String requestBody = """
                {
                    "title": "Updated Through API Client"
                }
                """;

        Response response = client.updateProductUsingPatch(1, requestBody);

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("title"), "Updated Through API Client");

    }
}