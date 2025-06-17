package chapter8;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Qn_6_UniversityNames_United_States {
    @Test
    public void getTotalUniversityCountWithLogging() {
        RestAssured.baseURI = "http://universities.hipolabs.com";
        int offset = 0;
        int limit = 500;
        int totalCount = 0;
        int i = 1;
        List<String> universities = new ArrayList<>();

        while (true) {
            Response response = RestAssured.given()
                    .queryParam("country", "United States")
                    .queryParam("limit", limit)
                    .queryParam("offset", offset)
                    .get("/search");

            List<String> currentBatch = response.jsonPath().getList("name");
            int count = currentBatch.size();
            universities.addAll(currentBatch);
            totalCount += count;

            if (count < limit) {
                break;
            }
            offset += limit;
        }

        System.out.println("Total universities in United States: " + totalCount);
        System.out.println();
        System.out.println("University names in United States:");

        for (String name : universities) {
            System.out.println(i + " --> " + name);
            i++;
        }
    }
}
