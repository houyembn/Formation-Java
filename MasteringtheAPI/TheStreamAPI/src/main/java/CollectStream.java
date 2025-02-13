import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectStream {
    public static void main(String[] args) {
        //print a list of 10 numbers
        List<Integer> numbers =
                IntStream.range(0, 10)  //numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                        .boxed() //Converts the IntStream of primitive int values into a Stream<Integer>
                        .collect(Collectors.toList());
        System.out.println("numbers = " + numbers);

        //the half of 10 numbers
        Set<Integer> evenNumbers =
                IntStream.range(0, 10)
                        .map(number -> number / 2)
                        .boxed()
                        .collect(Collectors.toSet());
        System.out.println("evenNumbers = " + evenNumbers);


        //LinkedList used to collect the elements of the stream.
        LinkedList<Integer> linkedList =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("linked listS = " + linkedList);


        //Counting with a Collector
        Collection<String> strings = List.of("one", "two", "three");

        long count = strings.stream().count();
        long countWithACollector = strings.stream().collect(Collectors.counting());

        System.out.println("count = " + count);
        System.out.println("countWithACollector = " + countWithACollector);


        //Collecting in a String of Characters
        String joined =
                IntStream.range(0, 10)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining());

        System.out.println("joined = " + joined);


        //putting a separator
        String joine =
                IntStream.range(0, 10)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

        System.out.println("joined = " + joine);


        //Finding the words with 4 letters
        Collection<String> strin =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve");

        Map<Boolean, List<String>> map =
                strin.stream()
                        .collect(Collectors.partitioningBy(s -> s.length() > 4));

        map.forEach((key, value) -> System.out.println(key + " :: " + value));



        //Using groupingBy
        Collection<String> st =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve");

        Map<Integer, String> maps =
                st.stream()
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        Collectors.joining(", ")));
        maps.forEach((key, value) -> System.out.println(key + " :: " + value));



        //the values are concatenated together with a separator.
        Collection<String> var =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve");

        Map<Integer, String> mapss =
                var.stream()
                        .collect(
                                Collectors.toMap(
                                        element -> element.length(),
                                        element -> element,
                                        (element1, element2) -> element1 + ", " + element2));

        mapss.forEach((key, value) -> System.out.println(key + " :: " + value));


        //print the list of 10 elements using IntStream in a instance of List<Integer>
        Supplier<List<Integer>> supplier                  = ArrayList::new;
        ObjIntConsumer<List<Integer>> accumulator         = Collection::add;
        BiConsumer<List<Integer>, List<Integer>> combiner = Collection::addAll;

        List<Integer> collect =
                IntStream.range(0, 10)
                        .collect(supplier, accumulator, combiner );

        System.out.println("collect = " + collect);



        //same but using StringBuffer
        Supplier<StringBuffer> suppliers                = StringBuffer::new;
        ObjIntConsumer<StringBuffer> accumulators        = StringBuffer::append;
        BiConsumer<StringBuffer, StringBuffer> combiners = StringBuffer::append;

        StringBuffer collects =
                IntStream.range(0, 10)
                        .collect(suppliers, accumulators, combiners);

        System.out.println("collect = " + collects);






    }
}
