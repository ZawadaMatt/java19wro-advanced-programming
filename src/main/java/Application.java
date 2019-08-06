import HashSet.StringHashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Application {

    public static void main(String[] args) {
        Set<String> set = new StringHashSet();
        set.add("Ala");
        set.add("Alan");
        set.add("Jakub");
        set.add("Marek");
        System.out.println(set);
        set.clear();
        System.out.println(set);
        set.add("Monika");
        set.add("Monika2");

        System.out.println(set);
    }

    private static void experimentWithArrayList(int size) {
        List<Integer> numbers = IntStream.range(0, size)
                .boxed()
                .collect(toList());

        for (int i = size / 2; i < 1.5 * size; i++) {
            boolean contains = numbers.contains(i);
        }
    }

    private static void experimentWithArraySet(int size) {
        Set<Integer> numbers = IntStream.range(0, size)
                .boxed()
                .collect(toSet());

        for (int i = size / 2; i < 1.5 * size; i++) {
            boolean contains = numbers.contains(i);
        }
    }
}
