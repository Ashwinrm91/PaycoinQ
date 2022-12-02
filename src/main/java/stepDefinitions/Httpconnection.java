package stepDefinitions;

import io.restassured.response.Response;
import utils.TestUtils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

public class Httpconnection {

	public static Response post() throws IOException {

		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.auth().basic("admin", "password123").body(prop.getProperty("Post")).when()
				.post(prop.getProperty("URL")).then().statusCode(200).extract().response();
		System.out.println("StatusCode" + resp.getStatusCode());
		return resp;

	}

	public static Response get(String BookingID) throws IOException {

		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.auth().basic("admin", "password123").body("").when().get(prop.getProperty("URL") + BookingID).then()
				.statusCode(200).extract().response();
		System.out.println("StatusCode" + resp.getStatusCode());
		return resp;

	}
	
	

	public static Response getall() throws IOException {

		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.auth().basic("admin", "password123").body("").when().get(prop.getProperty("URL")).then()
				.statusCode(200).extract().response();
		System.out.println("StatusCode" + resp.getStatusCode());
		return resp;

	}

	public static Response patch(String BookingID) throws IOException {

		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").auth().basic("admin", "password123")
				.body(prop.getProperty("Patch")).when().patch(prop.getProperty("URL") + BookingID).then()
				.statusCode(200).extract().response();
		System.out.println("StatusCode" + resp.getStatusCode());
		return resp;

	}

	public static Response delete(String BookingID) throws IOException {

		Properties prop = TestUtils.readPropertiesFile("Booking_Details.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Accept", "application/json")
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").auth().basic("admin", "password123")
				.body(prop.getProperty("Patch")).when().delete(prop.getProperty("URL") + BookingID).then()
				.statusCode(201).extract().response();
		System.out.println("StatusCode" + resp.getStatusCode());
		return resp;

	}

	}