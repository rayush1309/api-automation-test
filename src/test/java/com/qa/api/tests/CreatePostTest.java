package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreatePostTest extends BaseTest{

    @Test
    public void createPostTest() {

        String requestBody = """
                {
                    "title": "API Automation",
                    "userId": 1
                }
                """;

        Response response =
                given()
                        .spec(RequestSpecFactory.getJsonRequestSpecification())
                        .body(requestBody)
                        .when()
                        .post("/posts/add")
                        .then()
                        .extract()
                        .response();

        assertEquals(response.statusCode(), 201);
        assertNotNull(response.jsonPath().getString("title"));
        assertEquals(response.jsonPath().getInt("userId"), 1);
    }
}