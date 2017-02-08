package step_definitions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.thomas.config.Settings;
import com.thomas.utilities.CucumberUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import cucumber.api.java8.StepdefBody;
import json_objects.Employee;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Thomas on 02/04/2017.
 */
public class Jsonserver_step implements En {
    Response apiResponse = null;
    String json_path = "";

    public Jsonserver_step() {
        Response response;
        Employee employee = new Employee();

        /* -----------------------------------------------------
        Setters
        ----------------------------------------------------- */

        Given("^user sets the Employee variables:$", (DataTable table) -> {
            CucumberUtil.set(table);
            Map<String, String> data = CucumberUtil.get();
            String id = data.get("ID");
            String name = data.get("name");
            String salary = data.get("salary");

            if (id.length() > 0) {
                employee.setId(id);
            }
            if (name.length() > 0) {
                employee.setName(name);
            }
            if (salary.length() > 0) {
                employee.setSalary(salary);
            }
        });

        When("^user inserts to the JSON REST server$", () -> {
            // POST = INSERT by object
            final String api_url = Settings.api_url_jsonserver;

            apiResponse = RestAssured
                .given()
                    .body(employee)
                .when()
                    .contentType(ContentType.JSON)
                    .post(api_url);
            // System.out.println("response:"+ apiResponse.asString());
        });

        When("^user updates to the JSON REST server on position \"([^\"]*)\"$", (String position) -> {
            // UPDATE = update requires to fully set Employee
            final String api_url = Settings.api_url_jsonserver + "/" + position;

            apiResponse = RestAssured
                .given()
                    .body(employee)
                .when()
                    .contentType(ContentType.JSON)
                    .put(api_url);
            // System.out.println("response:"+ apiResponse.asString());
        });

        Given("^user patches to the JSON REST server on position \"([^\"]*)\" using \"([^\"]*)\"$", (String position, String data) -> {
            // PATCHES = update Employee partially
            final String api_url = Settings.api_url_jsonserver + "/" + position;
            data = data.replaceAll("'", "\"");
            apiResponse = RestAssured
                .given()
                    .body(data)
                .when()
                    .contentType(ContentType.JSON)
                    .patch(api_url);
            // System.out.println("response:"+ apiResponse.asString());
        });

        Given("^user deletes data \"([^\"]*)\" to the JSON REST server$", (String position) -> {
            // DELETE by url
            final String api_url = Settings.api_url_jsonserver + "/" + position;

            apiResponse = RestAssured
                .when()
                    .delete(api_url);
        });

        /* -----------------------------------------------------
        For testing purpose
        ----------------------------------------------------- */

        Then("^check for HTTP status \"([^\"]*)\"$", (String statusCode) -> {
            Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(statusCode));
        });
    }
}
