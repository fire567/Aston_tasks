import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTests {

    RequestSpecification requestSpec = given().contentType(ContentType.JSON).baseUri("https://postman-echo.com");

    @Test
    public void getRequestTest(){
        requestSpec.when().
                pathParam("foo1", "bar1").
                pathParam("foo2",  "bar2").
                get("/get?foo1={foo1}&foo2={foo2}").then().log().
                body().statusCode(HttpStatus.SC_OK).and().
                body("args.foo1", equalTo("bar1")).and().
                body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postTextRequestTest(){
        String payload = "payload";
        requestSpec.when().
                body(payload).
                post("/post").
                then().log().body().statusCode(HttpStatus.SC_OK).
                body("data", equalTo(payload));
    }



    @Test
    public void postFormRequestTest(){
        Map<String,String> payload = new HashMap<>();
        payload.put("name", "Misha");
        payload.put("age", "27");

        requestSpec.when().
                and().body(payload).
                post("/post").
                then().log().body().statusCode(HttpStatus.SC_OK).
                body("data.name", equalTo(payload.get("name"))).
                body("data.age", equalTo(payload.get("age")));
    }

    @Test
    public void putRequestTest(){
        requestSpec.when().
                pathParam("foo1", "bar1").
                put("/put?foo1={foo1}").
                then().log().body().statusCode(HttpStatus.SC_OK).and().
                body("args.foo1", equalTo("bar1")).and();
    }

    @Test
    public void patchRequestTest(){
        requestSpec.when().
                pathParam("foo1", "bar1").
                patch("/patch?foo1={foo1}").
                then().log().body().statusCode(HttpStatus.SC_OK).and().
                body("args.foo1", equalTo("bar1")).and();
    }

    @Test
    public void deleteRequestTest(){
        requestSpec.when().
                pathParam("foo1", "bar1").
                delete("/delete?foo1={foo1}").
                then().log().body().statusCode(HttpStatus.SC_OK).and().
                body("args.foo1", equalTo("bar1")).and();
    }
}
