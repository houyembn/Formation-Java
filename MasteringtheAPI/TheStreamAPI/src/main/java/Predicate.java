import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Predicate {
    public static void main(String[] args) {
        //collecting a list of strings into a List, Set, and a Map grouping by string length with counts.
        Collection<String> strings =
                List.of("two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve");

        Collector<String, ?, List<String>> listCollector = Collectors.toList();
        List<String> list = strings.stream().collect(listCollector);
        System.out.println("Size of list = " + list.size());

        Collector<String, ?, Set<String>> setCollector = Collectors.toSet();
        Set<String> set = strings.stream().collect(setCollector);
        System.out.println("Size of set = " + set.size());

        Collector<String, ?, Map<Integer, Long>> groupingBy =
                Collectors.groupingBy(String::length, Collectors.counting());
        Map<Integer, Long> map = strings.stream().collect(groupingBy);
        System.out.println("Size of map = " + map.size());
    }











}
