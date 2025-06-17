package ch3part3Assignments;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn1_QueryParamApiResponse {
	@Test
	public void verify() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		Response res= given().queryParam("page", 2).queryParam("id",5).get("https://reqres.in/api/users");
		
		res.prettyPrint();
	}

}
