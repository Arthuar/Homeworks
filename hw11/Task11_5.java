package homeWork11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task11_5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> iFirst = first.iterator();
        Iterator<T> iSecond = second.iterator();
        List<T> result = new ArrayList<>();
        while (iFirst.hasNext() && iSecond.hasNext()){
            result.add(iFirst.next());
            result.add(iSecond.next());
        }
        return result.stream();
    }
    public static void main(String[] args) {
        Stream<String> st1 = Stream.of("A","B","C", "D", "E");
        Stream<String> st2 = Stream.of("a", "b", "c", "d");
        zip(st1, st2)
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}
