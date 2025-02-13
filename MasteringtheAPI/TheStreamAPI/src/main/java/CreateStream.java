import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //the creation of an empty stream
        Stream<String> empty = Stream.empty();
        List<String> strings = empty.collect(Collectors.toList());
        System.out.println("strings = " + strings);


        //the use of() factory method in the Stream interface.
        Stream<Integer> intStream = Stream.of(1, 2, 3);
        List<Integer> ints = intStream.collect(Collectors.toList());
        System.out.println("ints = " + ints);


        //The use of  Arrays.stream()
        String[] stringArray = {"one", "two", "three"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        List<String> s = stringStream.collect(Collectors.toList());
        System.out.println("strings = " + s);


        //here in this method we have to put limit otherwise It really produces an infinite stream.
        Stream<String> generated = Stream.generate(() -> "+");
        List<String> str =
                generated
                        .limit(10L)
                        .collect(Collectors.toList());

        System.out.println("strings = " + str);


        //same result but with different method If we need an infinite stream with varying values, then you can use the iterate() pattern.
        Stream<String> iterated = Stream.iterate("+", l -> l + "+");
        iterated.limit(5L).forEach(System.out::println);

        Stream<String> iterat = Stream.iterate("+", m -> m.length() <= 5, m -> m + "+");
        iterat.forEach(System.out::println);


        //We can create a range of numbers with the previous pattern using range()
        String[] letters = {"A", "B", "C", "D"};
        List<String> listLetters =
                IntStream.range(0, 10)
                        .mapToObj(index -> letters[index % letters.length])
                        .collect(Collectors.toList());
        System.out.println("listLetters = " + listLetters);


        //we use the random to have 10 elemnts in the list from 1 to 5
        Random random = new Random(314L);
        List<Integer> randomInts =
                random.ints(10, 1, 5)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println("randomInts = " + randomInts);


        //here we tried a random boolean
        Random ran = new Random(314L);
        List<Boolean> booleans =
                ran.doubles(1_000, 0d, 1d)
                        .mapToObj(rand -> rand <= 0.8) // you can tune the probability here
                        .collect(Collectors.toList());

        long numberOfTrue =// Let us count the number of true in this list
                booleans.stream()
                        .filter(b -> b)
                        .count();
        System.out.println("numberOfTrue = " + numberOfTrue);


        //another exemple but with the probability of the letters
        Random ra = new Random(314L);
        List<String> let =
                ra.doubles(1_000, 0d, 1d)
                        .mapToObj(rand ->
                                rand < 0.5 ? "A" : // 50% of A
                                        rand < 0.8 ? "B" : // 30% of B
                                                rand < 0.9 ? "C" : // 10% of C
                                                        "D")  // 10% of D
                        .collect(Collectors.toList());

        Map<String, Long> map =
                let.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((letter, number) -> System.out.println(letter + " :: " + number));


        //separate the Characters
        String sentence = "Hello Duke";
        List<String> le =
                sentence.chars()
                        .mapToObj(Character::toString)
                        .collect(Collectors.toList());
        System.out.println("letters = " + le);


        //counting the number of warnings in a log file.
        Path log = Path.of("/tmp/debug.log"); // adjust to fit your installation
        try (Stream<String> lines = Files.lines(log)) {

            long warnings =
                    lines.filter(line -> line.contains("WARNING"))
                            .count();
            System.out.println("Number of warnings = " + warnings);

        } catch (IOException e) {
            // do something with the exception
        }


        //Here we split the sentence and put the words in a list
        String sentenc = "For there is good news yet to hear and fine things to be seen";
        Pattern pattern = Pattern.compile(" ");
        Stream<String> stream = pattern.splitAsStream(sentenc);
        List<String> words = stream.collect(Collectors.toList());
        System.out.println("words = " + words);


        //we use the builder Once the builder has been used to create the stream, you cannot add more elements to it, nor you can use it again to build another stream. You will get an IllegalStateException if you do that.
        Stream.Builder<String> builder = Stream.<String>builder();
        builder.add("one")
                .add("two")
                .add("three")
                .add("four");
        Stream<String> streams = builder.build();
        List<String> list = streams.collect(Collectors.toList());
        System.out.println("list = " + list);


//Creating a Stream on an HTTP Source

        // The URI of the file
        URI uri = URI.create("https://www.gutenberg.org/files/98/98-0.txt");

        // The code to open create an HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        // The sending of the request
        try {
            HttpResponse<Stream<String>> response = client.send(request, HttpResponse.BodyHandlers.ofLines());
            List<String> lines;
            try (Stream<String> k = response.body()) {
                lines = k
                        .dropWhile(line -> !line.equals("A TALE OF TWO CITIES"))
                        .takeWhile(line -> !line.equals("*** END OF THE PROJECT GUTENBERG EBOOK A TALE OF TWO CITIES ***"))
                        .collect(Collectors.toList());
            }
            System.out.println("# lines = " + lines.size());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
