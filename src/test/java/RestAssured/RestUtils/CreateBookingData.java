package RestAssured.RestUtils;

import java.time.LocalDate;

import com.google.gson.JsonObject;

public class CreateBookingData {
	
	public static JsonObject createBookingJson( 
			String firstName, String lastName, 
			Integer totalPrice, boolean depositPaid,
			String additionalNeeds, LocalDate checkIn,
			LocalDate checkOut) {
		
		JsonObject bookingDates = new JsonObject();
		bookingDates.addProperty("checkin", checkIn.toString());
		bookingDates.addProperty("checkout", checkOut.toString());
		
		JsonObject jsonPayLoad = new JsonObject();
		
		jsonPayLoad.addProperty("firstname", firstName);
		jsonPayLoad.addProperty("lastname", lastName);
		jsonPayLoad.addProperty("totalprice", totalPrice);
		jsonPayLoad.addProperty("depositpaid", depositPaid);
		jsonPayLoad.addProperty("additionalneeds", additionalNeeds);
		jsonPayLoad.add("bookingdates", bookingDates);
		
		return jsonPayLoad;	
	}
}
