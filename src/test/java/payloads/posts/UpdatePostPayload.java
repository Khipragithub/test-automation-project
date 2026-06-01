package payloads.posts;

public class UpdatePostPayload {

    public static String updatePostBody() {

        return "{\n" +
                "\"id\": 1,\n" +
                "\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"userId\": 1\n" +
                "}";
    }
}