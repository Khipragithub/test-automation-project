package utils;

import io.restassured.response.Response;

public class APIUtils {

    public static int getIntValue(
            Response response,
            String jsonPath) {

        return response.jsonPath().getInt(jsonPath);
    }

    public static String getStringValue(
            Response response,
            String jsonPath) {

        return response.jsonPath().getString(jsonPath);
    }
}