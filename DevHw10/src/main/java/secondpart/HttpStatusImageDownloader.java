package secondpart;

import firstpart.HttpStatusChecker;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpStatusImageDownloader {
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    public static void downloadStatusImage(int code) throws IOException {
        String link = HttpStatusChecker.getStatusImage(code);
        String path = "images/status-" + code + ".jpg";

        Request request = new Request.Builder()
                .url(link)
                .build();

        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                saveImage(response.body(), path);
                System.out.println("file is downloaded:" + path);

            } else {
                System.out.println("download is failed");
            }
        }
    }

    private static void saveImage(ResponseBody responseBody, String path) throws IOException {
        try {
            try (InputStream inputStream = responseBody.byteStream();
                 OutputStream outputStream = new FileOutputStream(path)) {
                byte[] buffer = new byte[1024];
                int readBytes;
                while ((readBytes = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.flush();
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
