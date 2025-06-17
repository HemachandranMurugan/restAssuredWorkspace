package chapter8;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Qn_9_StoreDetailsINTO_JsonFile_UgandaUniversity{
	@Test
	public void verify() {
        RestAssured.baseURI = "http://universities.hipolabs.com";

        Response response = RestAssured.given()
                .queryParam("country", "uganda")
                .get("/search");
        
        List<String> UgandaDetails = response.jsonPath().getList("$");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        try {
        	File jsonFile = new File("src/main/resources/Qn_9_Uganda_Response.json");
        	mapper.writeValue(jsonFile, UgandaDetails);
        
        }catch(Exception e) {
        	System.out.println(e);
        }

    }
}