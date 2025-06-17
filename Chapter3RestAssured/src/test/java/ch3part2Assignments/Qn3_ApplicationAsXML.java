package ch3part2Assignments;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Qn3_ApplicationAsXML {
	@Test
	public void retrieve() {
		Response res = given()
						.contentType("application/xml")
						.accept("application/xml")
						.get("https://restful-booker.herokuapp.com/booking/119");
		
		res.prettyPrint();
	}
}
