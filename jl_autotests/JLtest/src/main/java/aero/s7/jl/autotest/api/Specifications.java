package aero.s7.jl.autotest.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    public static RequestSpecification requestSpecification(String url, String token) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setConfig(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Authorization")))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();
    }

    public static void setupRequestSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }
}
