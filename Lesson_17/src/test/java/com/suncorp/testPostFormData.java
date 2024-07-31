package com.suncorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testPostFormData {
    @Test
    public void testPostFormDataMethod() {
        given()
            .baseUri("https://postman-echo.com")
            .contentType(ContentType.URLENC.withCharset("UTF-8"))
            .formParam("foo1", "bar1")
            .and().formParam("foo2", "bar2")
            .post("/post")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo(""))
            .body("form.foo1", equalTo("bar1"))
            .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", instanceOf(String.class))
                .body("headers.content-length", instanceOf(String.class))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", instanceOf(String.class))
                .body("headers.x-amzn-trace-id", instanceOf(String.class))
                .body("headers.user-agent", instanceOf(String.class))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", instanceOf(String.class))
                .body("headers.content-type", containsString("application/x-www-form-urlencoded"))
                .body("headers.cookie", nullValue())
            .body("json", hasKey("foo1"))
            .body("json.foo1", equalTo("bar1"))
            .body("json", hasKey("foo2"))
            .body("json.foo2", equalTo("bar2"))
            .body("url", equalTo("https://postman-echo.com/post"));
    }
}
