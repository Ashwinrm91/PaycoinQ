package stepDefinitions;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.TestUtils;

public class ApiMethods {
		
	// Post API Call
	@Given("^Creating users using details$")
	public void createUser() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh")
				.body("{\r\n"
						+ "  \"email\": \"Ashwin@api.com\",\r\n"
						+ "  \"id\": \"user-02\",\r\n"
						+ "  \"password\": \"Password1\",\r\n"
						+ "      \"profile\": {},\r\n"
						+ "  \"username\": \"Mytestuser\"\r\n"
						+ "}")
				.when().post(prop.getProperty("URL") + "Create").then().statusCode(200).extract().response();
		System.out.println(resp.getStatusCode());
		System.out.println("response: " + resp.getBody().asString());
	}


	@Given("^User updates the username and email$")
	public void updatesUser() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
		final Response resp = given().headers("Content-Type", "application/json").headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh")
				.body("{\r\n"
						+ "  \"email\": \"Ashwin1234@example.com\",\r\n"
						+ "  \"id\": \"user-02\",\r\n"
						+ "  \"username\": \"Ashw\"\r\n"
						+ "}")
				.when().post(prop.getProperty("URL") + "Update").then().statusCode(200).extract().response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		
	}


	@Given("^Displaying the list of users$")
	public void listUsers() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
			final Response resp = given()
					.headers("Content-Type", "application/json").headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh").body("{\r\n"
							+ "    \"offset\": 0,\r\n"
							+ "    \"limit\": 100\r\n"
							+ "}").when()
					.post(prop.getProperty("URL") + "List").then().statusCode(200).extract()
					.response();
			System.out.println("Response Body :" + resp.getBody().asString());
			System.out.println("StatusCode :" + resp.getStatusCode());
		
	}
	
	@Given("^User trying to create same user$")
	public void samUserNegativescneario() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
		final Response resp = given().headers("Content-Type", "application/json")
				.headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh")
				.body("{\r\n"
						+ "  \"email\": \"Ashwin@example.com\",\r\n"
						+ "  \"id\": \"user-02\",\r\n"
						+ "  \"password\": \"Password1\",\r\n"
						+ "      \"profile\": {},\r\n"
						+ "  \"username\": \"Ashwin\"\r\n"
						+ "}").when().post(prop.getProperty("URL") + "Create").then().statusCode(400).extract()
				.response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		Assert.assertEquals("Getting the same user error message", "account already exists", myMap.get("detail"));
		}
	
	@Given("^Creating the user with password less than 8 letters$")
	public void negativeScenario2() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
		final Response resp = given().headers("Content-Type", "application/json")
				.headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh")
				.body("{\r\n"
						+ "  \"email\": \"Ashw@example.com\",\r\n"
						+ "  \"id\": \"user-02\",\r\n"
						+ "  \"password\": \"\",\r\n"
						+ "      \"profile\": {},\r\n"
						+ "  \"username\": \"Ashwin\"\r\n"
						+ "}").when().post(prop.getProperty("URL") + "Create").then().statusCode(500).extract()
				.response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> myMap = new Gson().fromJson(resp.getBody().asString(), type);
		Assert.assertEquals("Getting the same user error message", "Password is less than 8 characters", myMap.get("detail"));
		}
	

	@Given("^Deletion of user$")
	public void deleteUser() throws IOException {
		Properties prop = TestUtils.readPropertiesFile("M3o.properties");
		final Response resp = given().headers("Content-Type", "application/json")
				.headers("Authorization", "Bearer ZjI3OGY2NzMtNThkMy00M2I0LTk5OTYtN2UzMTk3MzM0NDdh")
				.body("{\r\n"
						+ "  \"id\":\"user-02\"\r\n"
						+ "}").when().post(prop.getProperty("URL") + "Delete").then().statusCode(200).extract()
				.response();
		System.out.println("Response Body :" + resp.getBody().asString());
		System.out.println("StatusCode :" + resp.getStatusCode());
	}

}