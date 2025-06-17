package ch3part2Assignments;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Qn1_verifyStatusCode500 {
	@Test
	public void verify() {
		Response res= given().get("https://the-internet.herokuapp.com/status_codes/500");
	 
		System.out.println("Status Code --> "+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 500,"status code is not 500");
		
	}
}
