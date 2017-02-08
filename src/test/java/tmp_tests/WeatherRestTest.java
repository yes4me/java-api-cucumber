package tmp_tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Thomas on 12/21/2016.
 * Run testng.xml. This will execute all tests in a specific group
 */

public class WeatherRestTest {
    @Parameters({"WEATHER_API_KEY", "CITY_NAME"})
    @Test(testName = "HttpStatusPass", description = "Check the HTTP request for weather API", enabled = true, groups = {"weather"})
    public void getHttpRequestPass(String API_KEY, String cityName) {
        final int expectedStatus = 200;

        // SOLUTION#1: Using String parameters
        /*
        final String API_CALL = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&APPID=" + API_KEY;
        Response response = RestAssured.when().get(API_CALL);
        Assert.assertEquals(response.getStatusCode(), expectedStatus);
        */

        // SOLUTION#2: Using response parameters
        /*
        final String API_CALL = "http://api.openweathermap.org/data/2.5/weather";
        Response response = RestAssured
            .given()
                .param("q", cityName)
                .param("APPID", API_KEY)
            .when()
                .get(API_CALL);
        Assert.assertEquals(response.getStatusCode(), expectedStatus);
        System.out.println(response.asString());    // This is NOT .toString()
        */

        // SOLUTION#3: Using ONLY response
        final String API_CALL = "http://api.openweathermap.org/data/2.5/weather";
        RestAssured
            .given()
                .param("q", cityName)
                .param("APPID", API_KEY)
            .when()
                .get(API_CALL)
            .then()
                .assertThat().statusCode(expectedStatus);
    }

    @Parameters({"WEATHER_API_KEY", "CITY_NAME"})
    @Test(testName = "HttpStatusPass", description = "Get the weather description", enabled = true, groups = {"test"})
    public void getWeatherDescription(String API_KEY, String cityName) {
        final String API_CALL = "http://api.openweathermap.org/data/2.5/weather";
        String weatherDescription = RestAssured
            .given()
                .param("q", cityName)
                .param("APPID", API_KEY)
            .when()
                .get(API_CALL)
            .then()
                .contentType(ContentType.JSON)
                .extract()
                .path("weather[0].description");
        System.out.println("weatherDescription=" + weatherDescription + "##");

        Long time = RestAssured
            .given()
                .param("q", cityName)
                .param("APPID", API_KEY)
            .when()
                .get(API_CALL)
            .then()
                .contentType(ContentType.JSON)
                .extract()
                .time();
        System.out.println("time=" + time + "##");
    }
}
