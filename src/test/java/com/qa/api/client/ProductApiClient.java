
package com.qa.api.client;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductApiClient {

    public Response getProductById(int productId) {
        return given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .when()
                .get("/products/" + productId)
                .then()
                .extract()
                .response();
    }

    public Response getAllProducts() {
        return given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .when()
                .get("/products")
                .then()
                .extract()
                .response();
    }
    public Response updateProductUsingPatch(int productId, Object requestBody) {

        return given()
                .spec(RequestSpecFactory.getJsonRequestSpecification())
                .body(requestBody)
                .when()
                .patch("/products/" + productId)
                .then()
                .extract()
                .response();
    }
    public Response updateProductUsingPut(int productId, Object requestBody) {

        return given()
                .spec(RequestSpecFactory.getJsonRequestSpecification())
                .body(requestBody)
                .when()
                .put("/products/" + productId)
                .then()
                .extract()
                .response();
    }
}
