package chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//Verify the United States Population is "318558162" in the year of 2016
public class Qn_12_Verify_UnitedStates_Population_in_2016 {
    @Test
    public void verifyUSPopulationIn2016() {
        RestAssured.baseURI = "https://datausa.io/api/data";

        Response response = RestAssured.given()
                .queryParam("drilldowns", "Nation")
                .queryParam("measures", "Population")
                .get();

        // Extract the population for the year 2016
        int population2016 = response.jsonPath().getInt("data.find { it.Year == '2016' }.Population");
       
        System.out.println("Extracted Population for 2016: " + population2016);

        // Verify the population
        Assert.assertEquals(population2016, 318558162, "The population of the United States in 2016 is not as expected.");
    }
}
