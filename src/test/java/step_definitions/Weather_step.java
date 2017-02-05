package step_definitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.thomas.config.Settings;
import com.thomas.utilities.CucumberUtil;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Thomas on 02/04/2017.
 */
public class Weather_step implements En {
    Response api_response = null;
    String json_path = "";

    public Weather_step() {
        /* -----------------------------------------------------
        Setters
        ----------------------------------------------------- */

        Given("^user connects to the weather API using the parameters:$", (DataTable table) -> {
            final String api_url = Settings.api_url_weather;
            final String api_key = Settings.api_key_weather;
            String api_parameters = "";

            CucumberUtil.set(table);
            Map<String, String> data = CucumberUtil.get();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                api_parameters += "&" + key + "=" + value;
            }
            api_parameters = api_parameters.replaceAll("\\[API_KEY\\]", api_key);
            api_parameters = api_parameters.substring(1);

            String url = api_url + "?" + api_parameters;
            // System.out.println("url=" + url);
            api_response = RestAssured.when().get(url);
        });

        And("^user use the following JSON path: \"([^\"]*)\"$", (String path) -> {
            json_path = path;
        });

        /* -----------------------------------------------------
        For testing purpose
        ----------------------------------------------------- */

        Then("^check for HTTP status \"([^\"]*)\"$", (String statusCode) -> {
            Assert.assertEquals(api_response.getStatusCode(), Integer.parseInt(statusCode));
        });

        Then("^check for output \"([^\"]*)\"$", (String expectedOutput) -> {
            String weatherData = api_response
                .then()
                    .contentType(ContentType.JSON)
                    .extract()
                    .path(json_path).toString();
            Assert.assertEquals(weatherData, expectedOutput);
        });
    }
}
