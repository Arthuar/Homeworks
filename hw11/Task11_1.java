package homeWork11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task11_1 {
    public static void main(String[] args) {
        Map<Integer,String> names = new HashMap<>();
        names.put(1,"Ivan");
        names.put(2, "Stepan");
        names.put(3, "Petro");
        names.put(4, "Andrij");
        names.put(5, "Mykola");
        names.put(6, "Roman");
        names.put(7, "Bogdan");
        String result = newNames(names);
        System.out.println("result = " + result);
    }

    public static String newNames(Map<Integer, String> names){
        return IntStream.range(0,names.size()+1)
                .filter(Integer -> Integer%2 !=0)
                .mapToObj(Integer -> Integer + ". " + names.get(Integer) )
                .collect(Collectors.joining(", "));
    }
}
