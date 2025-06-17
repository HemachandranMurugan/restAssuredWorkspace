package ch3part2Assignments;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Qn4_ApiResponseWithParam {
	
	@Test
	public void verify() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		Response res= given().queryParam("page", 2).get("https://reqres.in/api/users");
		
		res.prettyPrint();
	}

}
