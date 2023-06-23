package homeWork11;

import java.util.List;
import java.util.stream.Collectors;

public class Task11_2 {

    public static void main(String[] args) {
        List<Name> names = List.of(
                new Name("Ivan"),
                new Name("Stepan"),
                new Name("Petro"),
                new Name("Andrij"),
                new Name("Mykola"),
                new Name("Roman"),
                new Name("Zenuk")
        );
        String result = sortNames(names);
        System.out.println("result = " + result);

    }

    public static String sortNames(List<Name> names){
        return names.stream()
                .map((nm) -> nm.getName().toUpperCase())
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.joining(", "));
    }
}
class Name{
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
