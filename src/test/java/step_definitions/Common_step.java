package step_definitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.thomas.config.Settings;
import com.thomas.utilities.CucumberUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Thomas on 02/08/2017.
 */
public class Common_step implements En {
    Response apiResponse = null;

    public Common_step() {
        /* -----------------------------------------------------
        Setters
        ----------------------------------------------------- */

        Given("^user connects to the \"([^\"]*)\"$", (String url) -> {
            // GET request
            apiResponse = RestAssured
                .when()
                    .get(url);
        });

        Given("^user connects to \"([^\"]*)\" using with body \"([^\"]*)\"$", (String url, String jsonBody) -> {
            // POST request
            jsonBody = jsonBody.replaceAll("'", "\"");
            apiResponse = RestAssured
                .given()
                    .body(jsonBody)
                .when()
                    .contentType(ContentType.JSON)
                    .post(url);
        });

        /* -----------------------------------------------------
        For testing purpose
        ----------------------------------------------------- */

        Then("^print the response body$", () -> {
            System.out.println("REST response:"+ apiResponse.asString());
        });
        Then("^print the response HTTP status code$", () -> {
            System.out.println("HTTP status code:"+ apiResponse.getStatusCode() );
        });
        Then("^print the response headers$", () -> {
            System.out.println("Response headers:");
            System.out.println(apiResponse.getHeaders());
        });
        Then("^check the HTTP status \"([^\"]*)\"$", (String httpStatus) -> {
            Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(httpStatus));
        });
    }
}
