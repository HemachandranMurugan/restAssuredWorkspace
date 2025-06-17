package ch3part1Assignments;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Qn3_verifyStatusCode301 {
	
		@Test
		public void verify() {
			Response res= given().redirects().follow(false).get("https://the-internet.herokuapp.com/status_codes/301");
		 
			System.out.println("Status Code --> "+res.getStatusCode());
			Assert.assertEquals(res.getStatusCode(), 301,"status code is not 301");
	}
}
