
package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProductSchemaValidationTest extends BaseTest {

    @Test
    public void validateProductResponseSchemaTest() {

        given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "schemas/product-schema.json"
                ));
    }
}
