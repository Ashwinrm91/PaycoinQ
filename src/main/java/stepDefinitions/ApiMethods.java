package stepDefinitions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import io.restassured.response.Response;
import junit.framework.Assert;
import utils.TestUtils;

public class ApiMethods {

	public static String bookingID;

	@SuppressWarnings("deprecation")
	@Given("^Creating booking using user details$")
	public String createUser() throws IOException {

		Response resp = Httpconnection.post();
		Type type = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		String bookingid = myMap.get("bookingid").toString();
		bookingID = String.valueOf(bookingid).replace(".0", "");
		String details = myMap.get("booking").toString();
		JsonObject convertedObject = new Gson().fromJson(details, JsonObject.class);
		String bookingdates = convertedObject.get("bookingdates").toString();
		JsonObject date = new Gson().fromJson(bookingdates, JsonObject.class);
		System.out.println("response: " + resp.getBody().asString());
		Assert.assertEquals("Firstname of the user", "Ashwin",
				convertedObject.get("firstname").toString().replace("\"", ""));
		Assert.assertEquals("lastname of the user", "RM", convertedObject.get("lastname").toString().replace("\"", ""));
		Assert.assertEquals("Checkin date", "2018-01-01", date.get("checkin").toString().replace("\"", ""));
		return bookingID;
	}

	@Given("^User get the created details$")
	public void get_Particular_User_With_Bookingid() throws IOException {

		Response resp = Httpconnection.get(bookingID);
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
	}

	@Given("^User gets the all the booking Ids$")
	public void gets_all_User() throws IOException {
		Response resp = Httpconnection.getall();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());

	}

	@SuppressWarnings("deprecation")
	@Then("^I am getting the booking IDs with firstname \"([^\"]*)\" and the secondname \"([^\"]*)\"$")
	public void filtering_the_user(String Firstname, String Lastname) throws IOException {
		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.auth().basic("admin", "password123").body("").when()
				.get(prop.getProperty("URL") + "?firstname=" + Firstname + "&lastname=" + Lastname).then()
				.statusCode(200).extract().response();
		String response = resp.getBody().print();
		Gson gson = new Gson();
		List<Map> bookingList = gson.fromJson(response, List.class);
		System.out.println(bookingList.get(0));
		Map bookingMap = bookingList.get(0);
		String bookingid = bookingMap.get("bookingid").toString();
		String respid = String.valueOf(bookingid).replace(".0", "");

		System.out.println(bookingMap.get("bookingid").toString());
		Assert.assertEquals("Getting the Order ID", bookingID, respid);

	}

	@Given("^User updates the booking details with partial information with firstname and Lastname$")
	public void partially_updates_the_User_data() throws IOException {

		Response resp = Httpconnection.patch(bookingID);
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());

	}

	@Given("^user deletes the content using bookingID$")
	public void deleting_the_User_data() throws IOException {
		Response resp = Httpconnection.delete(bookingID);
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());

	}

}