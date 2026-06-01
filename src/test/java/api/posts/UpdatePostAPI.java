package api.posts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.APIBaseClass;
import io.restassured.response.Response;
import payloads.posts.UpdatePostPayload;
import reports.ExtentTestManager;
import utils.APIUtils;
import utils.ConfigReader;

public class UpdatePostAPI extends APIBaseClass {

    @Test
    public void updatePost() {

        Response response =

        given()

            .header("Content-Type", "application/json")

            .body(UpdatePostPayload.updatePostBody())

        .when()

            .put(ConfigReader.getConfigValue("baseURI") + "/posts/1");

        // Response logging
        System.out.println(response.getBody().asPrettyString());

        // Status validation
        Assert.assertEquals(response.getStatusCode(), 200);

        // Field validation
        Assert.assertEquals(
                APIUtils.getStringValue(response, "title"),
                "foo");

        Assert.assertEquals(
                APIUtils.getStringValue(response, "body"),
                "bar");

        Assert.assertEquals(
                APIUtils.getIntValue(response, "id"),
                1);

        ExtentTestManager.getTest()
                .info("<pre>" +
                        response.getBody().asPrettyString() +
                        "</pre>");

        ExtentTestManager.getTest()
                .pass("PUT API validated successfully");
    }
}