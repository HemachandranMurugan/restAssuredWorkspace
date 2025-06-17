package ch3part1Assignments;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthJavaClass {
	@Test
	public void verify() {
		
		Response res= given().get("https://the-internet.herokuapp.com/status_codes/200");
		 
		System.out.println("Status Code --> "+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200,"status code is not 200");
		
	}

}
