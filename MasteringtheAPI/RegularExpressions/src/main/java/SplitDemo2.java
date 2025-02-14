import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SplitDemo2 {
    //split the input REGEX = "\d"
    private static final String REGEX = "\\d";  //  \d matches any digit (0-9).
    private static final String INPUT =
            "one9two4three7four1five";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
        for(String s : items) {
            System.out.println(s);
        }
    }
}

