import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTest {

    @Test
    public void getRequestTest() {

        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get");

        assertEquals(200, response.statusCode());

        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));
    }

    @Test
    public void postRawTextTest() {

        String body = "{\"test\":\"value\"}";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .when()
                .post("https://postman-echo.com/post");

        assertEquals(200, response.statusCode());

        assertEquals(body.trim(), response.jsonPath().getString("data"));
    }

    @Test
    public void postFormDataTest() {

        Response response = given()
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

        assertEquals(200, response.statusCode());

        assertEquals("bar1", response.jsonPath().getString("form.foo1"));
        assertEquals("bar2", response.jsonPath().getString("form.foo2"));
    }

    @Test
    public void putRequestTest() {

        String body = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .when()
                .put("https://postman-echo.com/put");

        assertEquals(200, response.statusCode());

        assertEquals(body, response.jsonPath().getString("data"));
    }

    @Test
    public void patchRequestTest() {

        String body = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .when()
                .patch("https://postman-echo.com/patch");

        assertEquals(200, response.statusCode());

        assertEquals(body, response.jsonPath().getString("data"));
    }

    @Test
    public void deleteRequestTest() {

        String body = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .when()
                .delete("https://postman-echo.com/delete");

        assertEquals(200, response.statusCode());

        assertEquals(body, response.jsonPath().getString("data"));
    }
}
