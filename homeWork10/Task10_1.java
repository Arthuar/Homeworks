package main.java.homeWork10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task10_1 {
    private static final String result = "src/homeWork10/file1.txt";
    public static void main(String[] args) throws IOException {

            FileInputStream fis = new FileInputStream(result);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                if(s.matches("(\\d{3}-\\d{3}-\\d{4})||(\\(\\d{3}\\) \\d{3}-\\d{4})")) {
                    System.out.println("s = " + s);
                }
            }
            fis.close();
        }
    }