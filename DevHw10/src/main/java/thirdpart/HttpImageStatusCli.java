package thirdpart;

import secondpart.HttpStatusImageDownloader;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter status code");
        String input = scanner.next();
        try {
            int stCode = Integer.parseInt(input);
            HttpStatusImageDownloader.downloadStatusImage(stCode);
        } catch (IOException e) {
            System.out.println("There is not image for HTTP status" + input + "Please enter valid number");
            ;
        }
    }
}
