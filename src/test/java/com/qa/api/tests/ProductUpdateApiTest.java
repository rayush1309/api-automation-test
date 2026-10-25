package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProductUpdateApiTest extends BaseTest {

    @Test
    public void updateProductTitleUsingPatchTest() {

        String requestBody = """
                {
                    "title": "Updated API Automation Product"
                }
                """;

        Response response =
                given()
                        .spec(RequestSpecFactory.getJsonRequestSpecification())
                        .body(requestBody)
                        .when()
                        .patch("/products/1")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        assertEquals(
                response.jsonPath().getString("title"),
                "Updated API Automation Product"
        );

        assertNotNull(response.jsonPath().get("id"));
    }
}