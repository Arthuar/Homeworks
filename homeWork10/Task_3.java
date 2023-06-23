package homeWork10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Task_3 {

    private static final String readFrom = "src/main/java/homeWork10/words.txt";
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(readFrom);
        Scanner scanner = new Scanner(fis);
        Map<String, Integer> result = new HashMap<>();
        while (scanner.hasNext()){
            String s = scanner.next();
            if(!result.containsKey(s)){
                result.put(s,1);
            } else {
                result.put(s,result.get(s) + 1);
            }
        }
        System.out.println("result = " + result);

        Comparator <String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return  result.get(o1) < result.get(o2) ? 1 : -1;
            }
        };
        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(result);
        Set<String> keySet = treeMap.keySet();
        for(String s : keySet){;
            System.out.println(s + " " + result.get(s));
        }
        System.out.println("result = " + treeMap);
    }

}
