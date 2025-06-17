package chapter6;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Qn_05_UpdateOnlyNameExistingProduct {
	@Test
	public void productupdate() {
		
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
	    RestAssured.baseURI = "https://api.restful-api.dev";
		
		String jsonbody ="{\r\n"
				+ "    \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "    \"data\": {\r\n"
				+ "       \"year\": 2019,\r\n"
				+ "       \"price\": 1849.99,\r\n"
				+ "       \"CPU model\": \"Intel Core i9\",\r\n"
				+ "       \"Hard disk size\": \"1 TB\"\r\n"
				+ "    }\r\n"
				+ " }";
	    
	    //add a product
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jsonbody)
				.expect()
				.statusCode(200)
				.when()
				.post("/objects");
		response.getBody().asPrettyString();
		response.prettyPrint();
		
		String id = response.jsonPath().getString("id");

	    // Send patch request
		String patchJsonBody="{\r\n"
				+ "    \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\r\n"
				+ " }";
	    Response patchresponse = RestAssured.given()
	                          .contentType("application/json")
	                          .pathParam("id", id)
	                          .body(patchJsonBody)
	                          .patch("/objects/{id}");

	    // Verify the status code
	    Assert.assertEquals(patchresponse.getStatusCode(), 200);
	    
		response.prettyPrint();
	}
}
