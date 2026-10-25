
package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SafeApiLoggingTest extends BaseTest {

    @Test
    public void logRequestAndResponseSafelyTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .log().method()
                        .log().uri()
                        .when()
                        .get("/products/1")
                        .then()
                        .log().ifValidationFails()
                        .statusCode(200)
                        .extract()
                        .response();

        assertEquals(response.jsonPath().getInt("id"), 1);
    }
}
