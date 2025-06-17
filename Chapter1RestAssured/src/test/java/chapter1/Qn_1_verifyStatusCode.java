package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_1_verifyStatusCode {
	
	@Test
	public void verifyfor200() {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		RestAssured.baseURI ="https://api.coindesk.com/v1/bpi/currentprice.json";
		Response response = RestAssured.given().get();
		
		Assert.assertEquals(response.getStatusCode(), 200,"The status code is not 200");
		
		
	}
	
	@Test
	public void verifyfor404() {
		
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		RestAssured.baseURI ="https://api.coindesk.com/v1/bpi/currentprice.json";
		Response response = RestAssured.given().get();
		
		Assert.assertEquals(response.getStatusCode(),404,"The status code is not 404")
;		
	}

}
