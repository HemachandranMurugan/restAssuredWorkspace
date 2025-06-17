package ch3part2Assignments;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Qn2_RetrieveApiResponseJSON {
	
	@Test
	public void retrieve() {
		Response res = given().get("https://restful-booker.herokuapp.com/booking");
		
		//JsonPath jsonPath = res.jsonPath();
		
		//jsonPath.prettyPrint();
		
		res.prettyPrint();

	}

}
