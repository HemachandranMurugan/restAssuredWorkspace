package chapter8;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Qn_2_EnsureJSONSchemadataTypesNotMatchingjsonPlaceholder {

    @Test
    public void validateJsonSchema() {
        RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response responseBody = given().get("/posts/2");

        try {
            responseBody.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Qn_2_jsonSchema.json"));

            // If no exception, schema matched (unexpected)
            Assert.fail("Expected schema mismatch, but schema matched");
        } catch (AssertionError e) {
            System.out.println("Schema mismatch detected as expected.");
            System.out.println("Error: " + e.getMessage());
            Assert.assertTrue(e.getMessage().toLowerCase().contains("type"),"Mismatch should be due to type error.");

        }
    }
}
