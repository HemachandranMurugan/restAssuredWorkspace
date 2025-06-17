package chapter8;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class Qn_1_EnsureJSONSchemadataTypesMatchingjsonPlaceholderAPIRequest {

    @Test
    public void validateJsonSchema() {
    	RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        
        Response responseBody = given().get("/posts/2");
        
        responseBody.then()
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Qn_1_jsonSchema.json")); 
        responseBody.prettyPrint();
      
    }
}
