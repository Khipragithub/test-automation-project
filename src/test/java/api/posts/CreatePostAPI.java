package api.posts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.APIBaseClass;
import io.restassured.response.Response;
import payloads.posts.CreatePostPayload;
import reports.ExtentTestManager;
import utils.APIUtils;
import utils.ConfigReader;

public class CreatePostAPI extends APIBaseClass {

    @Test
    public void createPost() {

        //ExtentTestManager.getTest().info("Executing Create Post API");

        Response response =

        given()

            .header("Content-Type", "application/json")

            .body(CreatePostPayload.createPostBody())

        .when()

            .post(ConfigReader.getConfigValue("baseURI") + "/posts");

        // Print response
        System.out.println(response.getBody().asPrettyString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);

        // Log response in report
        //ExtentTestManager.getTest().info("<pre>" + response.getBody().asPrettyString() +"</pre>");
        //ExtentTestManager.getTest().pass("POST API validated successfully");
        
        // Extract postId using utility
        int postId = APIUtils.getIntValue(response, "id");
        System.out.println("Created Post ID : " + postId);

    }
}