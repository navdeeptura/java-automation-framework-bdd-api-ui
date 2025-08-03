package RestAssured.RestTests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetBooksTest {
	
	static final String API_PATH = "https://restful-booker.herokuapp.com/booking";
	
	
	@Test(enabled = false)
	public void getBooking() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(API_PATH)
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void validateResponse() {
		
		Response response = 
		given()
			.accept(ContentType.JSON)
		.when()
			.get(API_PATH)
		.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8")
			.extract().response();
		
		Assert.assertTrue(response.getBody().asString().contains("bookingid"));
		
	}
	

}
