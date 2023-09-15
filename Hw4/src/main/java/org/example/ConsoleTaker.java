package org.example;

import java.util.Scanner;

public class ConsoleTaker {
    Scanner scanner = new Scanner(System.in);
    public String input;
    String[] result;

    public  void fromConsole() {
        while (scanner.hasNext()) {
            transform();
        }
        scanner.close();
    }
    public String transform(){
        input = scanner.nextLine();
        result = input.split("");
        toUpper(result);
        toLower(result);
        input = String.join("", result);
        return input;
    }

    public void toUpper(String[] result) {
        for (int i = 0; i < result.length; i += 2) {
            result[i] = result[i].toUpperCase();
        }
    }

    public void toLower(String[] result) {
        for (int i = 1; i < result.length; i += 2) {
            result[i] = result[i].toLowerCase();
        }
    }
}
