package com.qa.api.tests;

import com.qa.api.config.RequestSpecFactory;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ProductDataProviderTest  extends BaseTest{

    @DataProvider(name = "productIds")
    public Object[][] productIds(){
        return new Object[][]{
                {1, 200},
                {2, 200},
                {3, 200}
        };

    }
    @Test(dataProvider = "productIds")
    public void validateProductByIdTest(int productId, int expectedStatusCode) {

        Response response =
                given()
                        .spec(RequestSpecFactory.getRequestSpecification())
                        .when()
                        .get("/products/" + productId)
                        .then()
                        .extract()
                        .response();

        assertEquals(response.statusCode(), expectedStatusCode);

        assertEquals(response.jsonPath().getInt("id"), productId);

        System.out.println("Validated product ID: " + productId);
    }


}
