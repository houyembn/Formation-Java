import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatchesLooking {

    private static final String REGEX = "foo";
    private static final String INPUT =
            "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {

        // Initialize
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: "
                + REGEX);
        System.out.println("Current INPUT is: "
                + INPUT);

        System.out.println("lookingAt(): "
                + matcher.lookingAt());
        System.out.println("matches(): "
                + matcher.matches());
    }
}


/*
public boolean lookingAt(): Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
public boolean find(): Attempts to find the next subsequence of the input sequence that matches the pattern.
public boolean find(int start): Resets this matcher and then attempts to find the next subsequence of the input sequence that matches the pattern, starting at the specified index.
public boolean matches(): Attempts to match the entire region against the pattern.
 */
