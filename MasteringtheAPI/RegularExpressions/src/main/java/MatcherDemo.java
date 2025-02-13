import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatcherDemo {

    private static final String REGEX =
            "\\bdog\\b";
    private static final String INPUT =
            "dog dog dog doggie dogg";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        //  get a matcher object
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while(m.find()) {
            count++;
            System.out.println("Match number "
                    + count);
            System.out.println("start(): "
                    + m.start());
            System.out.println("end(): "
                    + m.end());
        }
    }
}

/*public int start(): Returns the start index of the previous match.
public int start(int group): Returns the start index of the subsequence captured by the given group during the previous match operation.
public int end(): Returns the offset after the last character matched.
public int end(int group): Returns the offset after the last character of the subsequence captured by the given group during the previous match operation.


 */
