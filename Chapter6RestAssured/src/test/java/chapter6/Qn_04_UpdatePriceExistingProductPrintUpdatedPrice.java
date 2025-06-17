package chapter6;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Qn_04_UpdatePriceExistingProductPrintUpdatedPrice {
  @Test
  public void testPutRequest() {
	
	RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
    // Set base URI
    RestAssured.baseURI = "https://api.restful-api.dev";

    // Send PUT request
    Response response = RestAssured.given()
                          .contentType("application/json")
                          .body(new File("src/test/resources/Qn_04.json"))
                          .put("/objects/ff808181932badb60196aae958714f25");

    // Verify the status code
    Assert.assertEquals(response.getStatusCode(), 200);

    // Print the response
    System.out.print(response.asPrettyString());
  }
}
