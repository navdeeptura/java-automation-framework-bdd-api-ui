package RestAssured.RestTests;

import java.time.LocalDate;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import RestAssured.RestUtils.CreateBookingData;
import RestAssured.Validators.CreateBookingValidator;


public class PostApiRequestTest {
	
	@Test
	public void createBooking() {
		
		JsonObject jsonPayLoad = CreateBookingData.createBookingJson(
				"navdeep", "tu", 1000, true, "cricket", 
				LocalDate.parse("2025-07-15"), LocalDate.parse("2025-07-18"));
	
		
		Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.accept("application/json")
			.body(jsonPayLoad.toString())
			.baseUri("https://restful-booker.herokuapp.com/booking")
		.when()
			.post()
		.then()
			.assertThat()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		CreateBookingValidator.validateSchema(response);
		
		CreateBookingValidator.validateResponse(response);
	}

}
