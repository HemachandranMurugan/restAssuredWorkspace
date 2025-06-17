package chapter8;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_4_PrintNumberUniversitiesIndia {
	
	@Test
	public void printNumberOfUniversities() {
		
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		RestAssured.baseURI="http://universities.hipolabs.com";
		
		Response response = RestAssured.given()
								.queryParam("country", "India")
								.get("/search");
		
		//response.prettyPrint();
		
		int numberOfUniversities = response.jsonPath().getList("$").size();
		
		System.out.println("Number of universities in India: " + numberOfUniversities);

		
	}

}
