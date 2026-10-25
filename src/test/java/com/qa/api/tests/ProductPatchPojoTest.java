package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import com.qa.api.models.Product;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductPatchPojoTest extends BaseTest {

    @Test
    public void updateProductUsingPojoTest() {

        Product product = new Product();
        product.setTitle("Updated Using Product POJO");
        product.setPrice(149.99);

        ProductApiClient client = new ProductApiClient();

        Response response = client.updateProductUsingPatch(1, product);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Response body: " + response.asPrettyString());

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("title"), "Updated Using Product POJO");
        assertEquals(response.jsonPath().getDouble("price"), 149.99
        );
    }
}