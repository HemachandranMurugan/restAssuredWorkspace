package ch3part3Assignments;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn3_ApiResponseBaseURI {
	@Test
	public void verify() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		Response res= given()
						.pathParam("id", 5)
						.when()
						.get("/posts/{id}")
						.then()
						.extract().response();
		
		res.prettyPrint();
	}
}