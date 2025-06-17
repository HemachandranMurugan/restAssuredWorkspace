package chapter8;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_11_PrintSecondAvailableUniversity_France {
	
	@Test
	public void printNumberOfUniversities() {
		
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		RestAssured.baseURI="http://universities.hipolabs.com";
		
		Response response = RestAssured.given()
								.queryParam("country", "France")
								.get("/search");
		
		//response.prettyPrint();
		
		List<String> University =  response.jsonPath().getList("name");
		
		if(University.size()>=2) {
			System.out.println("Second Available University in france --> "+ University.get(1));
			return;
		}
		
		System.out.println("Less than two universities found in France.");
	}

}
