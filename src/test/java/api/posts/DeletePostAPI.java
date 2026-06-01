package api.posts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.APIBaseClass;
import io.restassured.response.Response;
import reports.ExtentTestManager;
import utils.ConfigReader;

public class DeletePostAPI extends APIBaseClass {

    @Test
    public void deletePost() {

        ExtentTestManager.getTest().info("Executing DELETE Post API");

        Response response =

        given()

        .when()

            .delete(ConfigReader.getConfigValue("baseURI") + "/posts/1");

        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());

        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, 200);

        ExtentTestManager.getTest()
                .info("Response Body:<pre>"
                        + response.getBody().asPrettyString()
                        + "</pre>");

        ExtentTestManager.getTest()
                .pass("Status code validated successfully : "
                        + actualStatusCode);

        System.out.println("DELETE API executed successfully");
    }
}