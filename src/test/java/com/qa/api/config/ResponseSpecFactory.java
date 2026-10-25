
package com.qa.api.config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpecFactory {

    private ResponseSpecFactory() {
        // Prevent object creation
    }

    public static ResponseSpecification getJsonResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();
    }
}
