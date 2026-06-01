package api.posts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.APIBaseClass;
import baseclass.BaseClass;
import io.restassured.response.Response;
import reports.ExtentTestManager;
import utils.ConfigReader;

public class GetPostsAPI extends APIBaseClass {

    @Test
    public void getPosts() {

        ExtentTestManager.getTest().info("Executing GET Posts API");

        // Send GET Request
        Response response =

        given()

        .when()
            .get(ConfigReader.getConfigValue("baseURI") + "/posts");

        // Log Response
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());

        // Validate Status Code
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
        // Extent Report Logging
        ExtentTestManager.getTest().info("Response Body:<pre>" +response.getBody().asPrettyString() + "</pre>");
        ExtentTestManager.getTest().pass("Status code validated successfully : " + actualStatusCode);
        System.out.println("GET API executed successfully");
    }
}