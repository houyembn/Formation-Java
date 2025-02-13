import java.util.List;
import java.util.stream.Collectors;

public class DebuggingStreams {
    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three", "four");
        List<String> result =
                strings.stream()
                        .peek(s -> System.out.println("Starting with = " + s))
                        .filter(s -> s.startsWith("t"))
                        .peek(s -> System.out.println("Filtered = " + s))
                        .map(String::toUpperCase)
                        .peek(s -> System.out.println("Mapped = " + s))
                        .collect(Collectors.toList());
        System.out.println("result = " + result);

    }
}
