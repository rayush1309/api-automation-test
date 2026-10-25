package com.qa.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {


    private RequestSpecFactory() {
        // Prevent object creation
    }

    public static RequestSpecification getRequestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUrl())
                .setAccept("application/json")
                .build();
    }

    public static RequestSpecification getJsonRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUrl())
                .setAccept("application/json")
                .setContentType("application/json")
                .build();
    }


}



/*
RequestSpecBuilder: request configuration banane mein help karta hai.



setBaseUri(...): ConfigManager se base URL leta hai.



setAccept(...): server se JSON response expect karta hai.



build(): configuration ko RequestSpecification object mein convert karta hai.



static: bina RequestSpecFactory ka object banaye method call kar sakte ho.
 */
