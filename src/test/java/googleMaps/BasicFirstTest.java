package googleMaps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BasicFirstTest {

    public static void main(String[] args) {

        //given -> all the pre-requisites required for the request/API to be sent
        //when -> submit the API, send using the HTTP method , resource URL (path to API endpoint)
        //then -> Assert the response, validation , verification of the response from server

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        RestAssured.basePath="/maps/api/place";

        given().log().body().queryParam("key","qaclick123")
                .header("Accept", ContentType.JSON)
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -12.31231,\n" +
                        "    \"lng\": 53.122122\n" +
                        "  },\n" +
                        "  \"accuracy\": 60,\n" +
                        "  \"name\": \"TCS Bangalore\",\n" +
                        "  \"phone_number\": \"(+91) 121 111 1212\",\n" +
                        "  \"address\": \"8811, Whitefield Park , Phase 1\",\n" +
                        "  \"types\": [\n" +
                        "    \"Udupi Cafe\",\n" +
                        "    \"Tech Bar\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://tcs.com\",\n" +
                        "  \"language\": \"English-en\"\n" +
                        "}").
        when().post("/add/json").
        then().log().body().
                assertThat()
                .statusCode(200);

    }

}
