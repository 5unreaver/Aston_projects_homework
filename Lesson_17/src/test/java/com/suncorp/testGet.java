package com.suncorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class testGet {
    @Test
    public void testGetMethod() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .contentType(ContentType.JSON)
                .get("/get")
                .then().log().body() // Логируем и выводим в консоль тело ответа
                .assertThat()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", instanceOf(String.class))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-amzn-trace-id", instanceOf(String.class))
                .body("headers.user-agent", instanceOf(String.class))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", instanceOf(String.class))
                .body("url", equalTo("https://postman-echo.com/get"));
    }
}
