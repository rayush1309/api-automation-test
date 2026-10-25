package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ProductNegativeDataProviderTest extends BaseTest {

    @DataProvider(name = "productScenarios")
    public Object[][] productScenarios() {
        return new Object[][]{
                {1, 200},
                {2, 200},
                {99999, 404}
        };
    }

    @Test(dataProvider = "productScenarios")
    public void validateProductScenariosTest(
            int productId, int expectedStatusCode) {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/" + productId)
                        .then()
                        .extract()
                        .response();

        assertEquals(response.statusCode(), expectedStatusCode, "Unexpected status for product ID: " + productId);

        if (expectedStatusCode == 200) {
            assertEquals(response.jsonPath().getInt("id"), productId);
        }

        System.out.println("Product ID: " + productId + " | Status: " + response.statusCode());
    }
}