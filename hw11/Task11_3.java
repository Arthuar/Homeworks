package homeWork11;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task11_3 {
    public static void main(String[] args) {
        String [] arr = {"1, 2, 0", "4, 5"};
        String result = Arrays.stream(arr)
                .map(num -> Arrays.asList(num.split(", ")))
                .flatMap(list -> list.stream())
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("result = " + '"'  + result + '"');
                
    }
}
