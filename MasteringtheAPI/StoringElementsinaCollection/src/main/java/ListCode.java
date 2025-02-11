import java.util.*;

public class ListCode {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5"));
        System.out.println(str);
        str.subList(2, 5).clear();
        System.out.println(str);
    }




}
