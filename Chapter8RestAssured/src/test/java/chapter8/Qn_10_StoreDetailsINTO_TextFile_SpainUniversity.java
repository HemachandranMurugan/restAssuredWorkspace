  package chapter8;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Qn_10_StoreDetailsINTO_TextFile_SpainUniversity{
	@Test
	public void verify() {
        RestAssured.baseURI = "http://universities.hipolabs.com";

        Response response = RestAssured.given()
                .queryParam("country", "spain")
                .get("/search");
        
        List<String> UgandaDetails = response.jsonPath().getList("$");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        try {
        	File Response_textFile= new File("src/main/resources/Qn_9_Spain_Response.txt");
        	mapper.writeValue(Response_textFile, UgandaDetails);
        }catch(Exception e) {
        	System.out.println(e);
        }

    }
}