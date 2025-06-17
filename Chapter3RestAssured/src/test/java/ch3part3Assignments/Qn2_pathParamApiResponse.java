package ch3part3Assignments;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn2_pathParamApiResponse {
	@Test
	public void verify() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		Response res= given()
						.pathParam("id", 5)
						.when()
						.get("https://jsonplaceholder.typicode.com/posts/{id}")
						.then()
						.extract().response();
		
		res.prettyPrint();
	}
	

}
