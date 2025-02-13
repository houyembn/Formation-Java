//we need a list from 3 to 7
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkip {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> result =
                ints.stream()
                        .skip(2)
                        .limit(5)  // limit(3) selects the first 5 elements of that stream, thus 3, 4, 5, 6, 7.
                        .collect(Collectors.toList());

        System.out.println("result = " + result);

    }
}
