package tmp_tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import json_objects.Employee;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Thomas on 12/21/2016.
 * Require to install:
 * - NodeJs
 * - json-server (npm install -g json-server)
 */

public class JsonServer {
    // ADD VALUES (if they don't exist)
    @Test(testName = "WIP", enabled = true, groups = {"test"})
    public void getHttpRequestPass() {
        System.out.println("XXX");

        // POST=INSERT by String
        /*
        String url = "http://localhost:3000/posts";
        String body = "{\"id\":\"1\", \"name\":\"name1\", \"salary\":\"10000\"}";
        Response response = RestAssured
            .given()
                .body(body)
            .when()
                .contentType(ContentType.JSON)
                .post(url);
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("response:"+ response.asString());
        */

        // POST=INSERT by object
        /*
        String url = "http://localhost:3000/posts";
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("name2");
        employee.setSalary(20000);
        Response response = RestAssured
            .given()
                .body(employee)
            .when()
                .contentType(ContentType.JSON)
                .post(url);
        Assert.assertEquals(response.getStatusCode(), 201); // created
        System.out.println("response:"+ response.asString());
        */

        // (AVOID) PUT=UPDATE by object. Required to have everything defined
        /*
        String url = "http://localhost:3000/posts/2";
        Employee employee = new Employee();
        employee.setId(3); // Does not change
        employee.setName("name3");
        employee.setSalary(30000);
        Response response = RestAssured
            .given()
                .body(employee)
            .when()
                .contentType(ContentType.JSON)
                .put(url);
        Assert.assertEquals(response.getStatusCode(), 200); // ok
        System.out.println("response:"+ response.asString());
        */

        // PATCH=UPDATE by string (BETTER THAN PUT)
        /*
        String url = "http://localhost:3000/posts/2";
        Employee employee = new Employee();
        employee.setSalary(120000);
        Response response = RestAssured
            .given()
                .body(employee)
            .when()
                .contentType(ContentType.JSON)
                .patch(url);
        Assert.assertEquals(response.getStatusCode(), 200); // ok
        System.out.println("response:"+ response.asString());
        */

        // DELETE
        /*
        String url = "http://localhost:3000/posts/2";
        Response response = RestAssured
            .when()
                .delete(url);
        Assert.assertEquals(response.getStatusCode(), 200); // ok
        System.out.println("response:"+ response.asString()); // return: {}
        */

        String url = "http://localhost:3000/posts/2";
        Employee employee = new Employee();
        employee.setId(2);
        employee.setSalary(222);
        Response response = RestAssured
                .given()
                .body(employee)
                .when()
                .contentType(ContentType.JSON)
                .patch(url);
        Assert.assertEquals(response.getStatusCode(), 200); // ok
        System.out.println("response:"+ response.asString());
    }

    // UPDATE VALUES (if they exist)
}
