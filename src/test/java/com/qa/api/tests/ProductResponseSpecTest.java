package com.qa.api.tests;
import com.qa.api.config.RequestSpecFactory;
import com.qa.api.config.ResponseSpecFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

public class ProductResponseSpecTest {

    @Test
    public void shouldValidateProductResponseUsingReusableSpec() {

        given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .when()
                .get("/products/1")
                .then()
                .spec(ResponseSpecFactory.getJsonResponseSpecification())
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", not(emptyOrNullString()));
    }
}
