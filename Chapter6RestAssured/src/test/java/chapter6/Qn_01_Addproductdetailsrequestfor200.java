package chapter6;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Qn_01_Addproductdetailsrequestfor200 {
	
	@Test
	public void addproducts() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		Response response=RestAssured.given()
					.contentType(ContentType.JSON)
					.body(new File("src/test/resources/Qn_01.json"))
					.expect()
					.statusCode(200)
					.when()
					.post("https://api.restful-api.dev/objects");
		
		response.prettyPrint();	
		

	}

}
