package RestAssured.ReqRes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsers {

    String apiKey;
    String endpoint;

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in";
        this.apiKey = "reqres-free-v1";
        this.endpoint = "/api/users";
    }

    @Test (enabled = false)
    public void getUsers(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
        .when()
                .get("api/users")
        .then()
                .assertThat()
                .statusCode(200)
                .log().headers()
                .log().body();
    }

    @Test
    public void testWithAPIKey(){
        given()
            .accept("application/json")
            .header("x-api-key", this.apiKey)
        .when()
            .get(this.endpoint)
        .then()
            .statusCode(200)
                .body("page", equalTo(1))
                .body("data", hasSize(6))
                .body("total_pages", is(2))
                .log().body();
    }

    @Test
    public void getTotalPages(){

        int total = given()
                .accept("application/json")
                .header("x-api-key", this.apiKey)
        .when()
                .get(this.endpoint)
                .jsonPath().getInt("total");

        System.out.println("total: " + total);
    }
}
