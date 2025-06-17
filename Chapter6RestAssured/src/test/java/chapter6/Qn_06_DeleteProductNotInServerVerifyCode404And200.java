package chapter6;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_06_DeleteProductNotInServerVerifyCode404And200 {
	@Test
	public void deleteproduct() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		Response response=RestAssured.given()
					.expect()
					.statusCode(200)
					.when()
					.delete("https://api.restful-api.dev/objects/ff808181932badb60196c3dcea3377c6");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}
	@Test
	public void deletetheproductagain() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		Response response=RestAssured.given()
				.expect()
				.statusCode(404)
				.when()
				.delete("https://api.restful-api.dev/objects/ff808181932badb60196c3dcea3377c6");
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}

}
