package chapter8;

import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Qn_3_PrintNumberUniversitiesUnitedStates {
    @Test
    public void getTotalUniversityCountWithLogging() {
    	RestAssured.baseURI = "http://universities.hipolabs.com";
        int offset = 0;
        int limit = 500;
        int totalCount = 0;
        while (true) {
            Response response = RestAssured.given()
                    .queryParam("country", "United States")
                    .queryParam("limit", limit)
                    .queryParam("offset", offset)
                    .get("/search");

	        List<String> universities = response.jsonPath().getList("name");
	        int count = universities.size();
	        totalCount += count;
            if (count < limit) {
                break;
            }
            offset += limit;
        }
        System.out.println("Total universities in United States: " + totalCount);
    }
}

/*public void printNumberOfUniversities() {

RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

RestAssured.baseURI="http://universities.hipolabs.com";

Response response = RestAssured.given()
						.queryParam("country", "United States")
						.get("/search");

//response.prettyPrint();

int numberOfUniversities = response.jsonPath().getList("$").size();
System.out.println("Number of universities in United States: " + numberOfUniversities);
}*/

