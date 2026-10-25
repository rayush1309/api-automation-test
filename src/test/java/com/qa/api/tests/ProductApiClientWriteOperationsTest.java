package com.qa.api.tests;

import com.qa.api.client.ProductApiClient;
import com.qa.api.models.Product;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class ProductApiClientWriteOperationsTest extends BaseTest {

    @Test
    public void shouldCreateProduct() {
        ProductApiClient client = new ProductApiClient();

        Product product = new Product();
        product.setTitle("Wireless Keyboard");
        product.setPrice(99.99);
        product.setDescription("Wireless keyboard with USB receiver");

        Response response = client.createProduct(product);

        assertEquals(response.statusCode(), 201,
                "Expected HTTP 201 when creating a product");
        assertNotNull(response.jsonPath().getString("id"),
                "Created product should contain an ID");
        assertEquals(response.jsonPath().getString("title"),
                "Wireless Keyboard",
                "Created product title should match the request");
    }

    @Test
    public void shouldDeleteProduct() {
        ProductApiClient client = new ProductApiClient();

        Response response = client.deleteProduct(1);

        assertEquals(response.statusCode(), 200,
                "Expected HTTP 200 when deleting a product");
        assertTrue(response.jsonPath().getBoolean("isDeleted"),
                "Response should indicate that the product was deleted");
    }
}
