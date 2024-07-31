package com.suncorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testPostRawText {
    @Test
    public void testPostRawTextMethod() {
        given()
            .baseUri("https://postman-echo.com")
            .when()
            .contentType(ContentType.TEXT)
            .body("{\n    \"test\": \"value\"\n}")
            .post("/post")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
            .body("files", anEmptyMap())
            .body("form", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", instanceOf(String.class))
                .body("headers.content-length", instanceOf(String.class))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", instanceOf(String.class))
                .body("headers.x-amzn-trace-id", instanceOf(String.class))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.user-agent", instanceOf(String.class))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue()) // при ппытке hasKey("postman-token") выдаёт ошибку.
                .body("headers.accept-encoding", instanceOf(String.class))
                .body("headers.cookie", nullValue())
            .body("json", nullValue())
            .body("url", equalTo("https://postman-echo.com/post"));
    }
}
