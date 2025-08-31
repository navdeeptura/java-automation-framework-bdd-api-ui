package RestAssured.ReqRes;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.security.SecureRandom;
import java.time.format.ResolverStyle;
import java.util.HashMap;

public class createTestData {

    RequestSpecification requestSpec;


    @BeforeClass
    void setUp(){
        baseURI = "https://reqres.in/api/custom-endpoints";

        requestSpec = given()
                .header("x-api-key", "reqres-free-v1")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    // using HashMap
    @Test (enabled = false)
    void createUsingHashMap(){

        HashMap data = new HashMap();

        HashMap response_data = new HashMap();
        HashMap headers = new HashMap();

        data.put("name", "string");
        data.put("path", "string");
        data.put("method", "GET");
        data.put("status_code", 200);
        data.put("response_data", response_data);
        data.put("headers", headers);

        given()
                .spec(requestSpec)
                .body(data)
        .when()
                .post()
        .then().statusCode(201);
    }

    //using JSONObject
    @Test (enabled = false)
    void testUsingJsonObject(){

        JSONObject data = new JSONObject();
        JSONObject response_data = new JSONObject();
        JSONObject headers = new JSONObject();

        data.put("name", "string");
        data.put("path", "string");
        data.put("method", "GET");
        data.put("status_code", 200);
        data.put("response_data", response_data);
        data.put("headers", headers);

        given()
                .spec(requestSpec)
                .body(data.toString())
        .when()
                .post()
        .then().statusCode(201);
    }


    @Test (enabled = true)
    void testUsingPOJO(){

        POJO_PostRequest data = new POJO_PostRequest();

        data.setMethod("GET");
        data.setPath("string");
        data.setName("string");
        data.setStatus_code(200);


        String createdAt = given()
                .spec(requestSpec)
                    .body(data)
                .when()
                    .post()
                .then().statusCode(201)
                .extract()
                .jsonPath().getString("createdAt");

        System.out.println(createdAt);
    }
}
