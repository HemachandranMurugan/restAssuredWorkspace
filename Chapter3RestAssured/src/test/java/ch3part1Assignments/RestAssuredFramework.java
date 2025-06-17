package ch3part1Assignments;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;


public class RestAssuredFramework {
	@Test
	public void verify() {
		
        RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		Response res = given().auth().basic("postman","password").get("https://postman-echo.com/basic-auth");
		
		// Verify the status code is 200
		System.out.println("Status code --> " + res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200, "Status code is not 200");
		
		// Verify the response
		System.out.println("Response --> " + res.asString());
		Assert.assertTrue(res.getBody().asString().contains("\"authenticated\": true"), "Response does not contain expected value");
	}
}