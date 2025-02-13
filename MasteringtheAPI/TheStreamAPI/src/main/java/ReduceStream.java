import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class ReduceStream {
    public static void main(String[] args) {

        //The sum of the list  here we started from the left doing the sum
        List<Integer> ints = List.of(3, 6, 2, 1);
        int sum = ints.get(0); // ints.get(0) retrieves the first element (3).
        for (int index = 1; index < ints.size(); index++) {
            sum += ints.get(index);
        }
        System.out.println("sum = " + sum);


        //the SUM operator with a binary operator to achieve the same result.
        List<Integer> in = List.of(3, 6, 2, 1);
        BinaryOperator<Integer> sums = (a, b) -> a + b;

        int result = in.get(0);
        for (int index = 1; index < in.size(); index++) {
            result = sums.apply(result, in.get(index));
        }
        System.out.println("sum = " + result);


        //We used the identity = 0
        List<Integer> intss = List.of(3, 6, 2, 1);
        BinaryOperator<Integer> sumss = (a, b) -> a + b;
        int identity = 0;

        int results = identity;
        for (int i: intss) {
            results = sumss.apply(results, i);
        }

        System.out.println("sum = " + results);


       //Using the count method
        Collection<String> strings =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        long count =
                strings.stream()
                        .filter(s -> s.length() == 3)
                        .count();
        System.out.println("count = " + count);

        //Using the foreach() method : counting the words that it is composed by 3 letters and then print them
        Stream<String> strin = Stream.of("one", "two", "three", "four");
        strin.filter(s -> s.length() == 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Same but putting rhem in a list
        Stream<String> stringss = Stream.of("one", "two", "three", "four");
        List<String> resultss = new ArrayList<>();

        stringss.filter(s -> s.length() == 3)
                .map(String::toUpperCase)
                .forEach(resultss::add);

        System.out.println("result = " + resultss);



        //Print the longest word using max
        Stream<String> var = Stream.of("one", "two", "three", "four");
        String longest =
                var.max(Comparator.comparing(String::length))
                        .orElseThrow();
        System.out.println("longest = " + longest);

        //Print onlt the first word with 3 letters
        Collection<String> vars=
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        String first =
                vars.stream()
                        // .unordered()
                        // .parallel()
                        .filter(s -> s.length() == 3)
                        .findFirst()
                        .orElseThrow();

        System.out.println("first = " + first);



        Collection<String> varss =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        boolean noBlank  =
                varss.stream()
                        .allMatch(Predicate.not(String::isBlank));
        boolean oneGT3   =
                varss.stream()
                        .anyMatch(s -> s.length() == 3);
        boolean allLT10  =
                varss.stream()
                        .noneMatch(s -> s.length() > 10);

        System.out.println("noBlank = " + noBlank);
        System.out.println("oneGT3  = " + oneGT3);
        System.out.println("allLT10 = " + allLT10);








    }
}
