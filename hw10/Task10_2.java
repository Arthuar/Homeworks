package main.java.homeWork10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Task10_2 {
    static class User{
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }

    public static final String readFrom = "src/main/java/homeWork10/file2.txt";
    public static final String writeTo = "src/main/java/homeWork10/user.json";

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(readFrom);
        FileOutputStream fos = new FileOutputStream(writeTo);
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(fis);
        String tittle = scanner.nextLine();
        while (scanner.hasNextLine()){
            String [] arr = scanner.nextLine().split(" ");
            users.add(new User (arr[0], arr[1]));
        }
        fis.close();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        fos.write(json.getBytes());
        fos.close();
    }
}

