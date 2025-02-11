import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyCode {
    public static void main(String[] args) {
        Key one = new Key("1");
        Key two = new Key("2");

        Set<Key> set = new HashSet<>();
        set.add(one);
        set.add(two);

        System.out.println("set = " + set);

// You should never mutate an object once it has been added to a Set!
        one.setKey("3");
        System.out.println("set.contains(one) = " + set.contains(one));
        boolean addedOne = set.add(one);
        System.out.println("addedOne = " + addedOne);
        System.out.println("set = " + set);






/////////////////////////////////////////////////////////////////////////////////////////


        List<Key> list = new ArrayList<>(set);
        Key key0 = list.get(0);
        Key key2 = list.get(2);

        System.out.println("key0 = " + key0);
        System.out.println("key2 = " + key2);
        System.out.println("key0 == key2 ? " + (key0 == key2));


    }

}
