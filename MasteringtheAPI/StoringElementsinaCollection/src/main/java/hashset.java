import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashset {
    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six");
        Set<String> set = new HashSet<>();  //A HashSet is a collection that implements the Set interface and is backed by a hash table.
        set.addAll(strings);
        set.forEach(System.out::println);

    }
}
