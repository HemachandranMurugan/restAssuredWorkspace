package chapter8;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Qn_7_UniversityNames_India{
	@Test
	public void verify() {
        RestAssured.baseURI = "http://universities.hipolabs.com";

        Response response = RestAssured.given()
                .queryParam("country", "India")
                .get("/search");

        List<String> universityNames = response.jsonPath().getList("name");
        
        System.out.println(universityNames.size());
        System.out.println();
        
        System.out.println("University names in India:");
        int i=1;
        for (String name : universityNames) {
            System.out.println(i +"-->"+ name);
            i++;
        }
    }
	
}