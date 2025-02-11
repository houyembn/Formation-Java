import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCode {

    public static void main(String[] args) {
       Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        map.replaceAll((key, value) -> value.toUpperCase());
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

///////////////////////////////////////////////////////////////////////////////////////////

     /*   List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word: strings) {
            int length = word.length();
            if (!map.containsKey(length)) {
                map.put(length, new ArrayList<>());
            }
            map.get(length).add(word);
        }*/

        map.forEach((key, value) -> System.out.println(key + " :: " + value));


    }
}
