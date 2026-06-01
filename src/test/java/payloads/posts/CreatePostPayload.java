package payloads.posts;

public class CreatePostPayload {

    public static String createPostBody() {

        return "{\n" +
                "\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"userId\": 1\n" +
                "}";
    }
}