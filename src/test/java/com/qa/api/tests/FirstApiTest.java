package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

public class FirstApiTest extends BaseTest {

    @Test
    public void getProductByIdTest() {
        Response response =
                given().spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .response();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertNotNull(response.jsonPath().getString("title"));




    }
}
