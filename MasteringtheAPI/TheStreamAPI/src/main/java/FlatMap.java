//remove yje whitespices or empty inputs
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };

        List<String> strings = List.of("1", " ", "2", "3 ", "", "3");
        List<Integer> ints =
                strings.stream()
                        .flatMap(flatParser)  // The function flatParser is a Function<String, Stream<Integer>>, meaning it takes a String as input and returns a Stream<Integer>.
                        .collect(Collectors.toList());
        System.out.println("ints = " + ints);


        ///////////here we used the mapMulti



        List<Integer> in =
                strings.stream()
                        .<Integer>mapMulti((string, consumer) -> {
                            try {
                                consumer.accept(Integer.parseInt(string));
                            } catch (NumberFormatException ignored) {
                            }
                        })
                        .collect(Collectors.toList());
        System.out.println("ints = " + in);


    }



    }
