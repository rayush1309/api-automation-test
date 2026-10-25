
package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import com.qa.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductReusableValidationTest extends BaseTest {

    @Test
    public void validateProductUsingReusableMethodsTest() {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .response();

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateStringFieldNotEmpty(response, "title");
    }
}
