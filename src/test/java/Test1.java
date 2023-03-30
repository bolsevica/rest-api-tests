import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test1 {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8083";
    }
    @Test
    public void test1(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/")
                .then()
                .extract().response();


        Assertions.assertEquals(200, response.statusCode());

    }
}
