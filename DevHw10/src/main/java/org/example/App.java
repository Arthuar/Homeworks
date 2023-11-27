package org.example;


import firstpart.HttpStatusChecker;
import secondpart.HttpStatusImageDownloader;
import thirdpart.HttpImageStatusCli;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        new HttpStatusChecker().getStatusImage(204);
//        new HttpStatusImageDownloader().downloadStatusImage(200);
        new HttpImageStatusCli().askStatus();
    }
}
