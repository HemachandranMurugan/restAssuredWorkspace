package chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_13_VerifyTheAGE {
	
	//Verify the age is "34" for the name="meelad"
	
	@Test
	public void verify() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		RestAssured.baseURI ="https://api.agify.io";
		
		Response response = RestAssured.given()
								.queryParam("name", "meelad")
								.get();
		
		 int Age = response.jsonPath().getInt("age");
		 
		 System.out.println("The age of Meelad --> " +Age);
		 
		 Assert.assertEquals(Age, 34,"The age for the name 'meelad' is not as expected.");
		 
		
	}

}
