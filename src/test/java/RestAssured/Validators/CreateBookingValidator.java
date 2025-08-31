package RestAssured.Validators;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateBookingValidator {
	
	public static void validateSchema(Response response) {
		response
		.then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath(
					"schemas/create-booking-schema.json"));
	}
	
	
	public static void validateResponse(Response response) {
		
		response.then()
		.assertThat()
		.body("booking.firstname", equalTo("navdeep"))
		.body("booking.lastname", is("tu"))
		.body("booking.totalprice", greaterThan(999))
		.body("booking.totalprice", lessThan(1001))
		.body("booking.depositpaid", is(true))
		.body("booking.firstname", not(emptyOrNullString()))
		
		.body("booking.bookingdates.checkin", startsWith("2025"))
		.body("booking.bookingdates.checkin", equalTo("2025-07-15"))
		.body("booking.bookingdates.checkout", greaterThan("2025-07-15"));
		
	}

}
