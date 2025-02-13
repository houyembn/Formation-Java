//affichage de length de contenu de la liste

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCode {
    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three", "four");
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("lengths = " + lengths);



//affichage de SummaryStatistics de la liste
        List<String> strin = List.of("one", "two", "three", "four");
        IntSummaryStatistics stats = strin.stream()
                .mapToInt(String::length)   // String::length can be of both types: Function<String, Integer> and ToIntFunction<String>.
                .summaryStatistics();
        System.out.println("stats = " + stats);



//compter le nombre des mots qui a comme length == 3
        List<String> s = List.of("one", "two", "three", "four");
        long count = s.stream()
                .map(String::length)
                .filter(length -> length == 3)
                .count();
        System.out.println("count = " + count);








    }

}
