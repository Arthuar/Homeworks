package firstpart;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpStatusChecker {
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    public static String link = "https://http.cat/";
    public static String getStatusImage(int code)  {
        String result = link + code + ".jpg";
        Request request = new Request.Builder()
                .url(result)
                .build();
        try(Response response = HTTP_CLIENT.newCall(request).execute()) {
            if(response.code() == 404){
                System.out.println("Image for code : " + code + " don't exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        return result;
    }
}
