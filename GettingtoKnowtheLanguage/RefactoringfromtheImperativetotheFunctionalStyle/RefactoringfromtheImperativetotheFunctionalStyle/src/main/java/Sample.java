//Sample.java : reading a file (Sample.java) line by line and counts how many lines contain a specific word (public).
import java.nio.file.*;

public class Sample {
    public static void main(String[] args) {
        try {
            final var filePath = "./Sample.java";
            final var wordOfInterest = "public";

            try (var reader = Files.newBufferedReader(Path.of(filePath))) {
                String line = "";
                long count = 0;

                while((line = reader.readLine()) != null) {
                    if(line.contains(wordOfInterest)) {
                        count++;
                    }
                }

                System.out.println(String.format("Found %d lines with the word %s", count, wordOfInterest));
            }
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}

