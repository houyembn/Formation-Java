import java.util.*;

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}
public class CollectionCode {

    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();

        strings.add("one");
        strings.add("two");

        if (strings.contains("one")) {
            System.out.println("one is here");
        }

        if (!strings.contains("three")) {
            System.out.println("three is not here");
        }

        User rebecca = new User("Rebecca");
        if (!strings.contains(rebecca)) {
            System.out.println("Rebecca is not here");
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> first = new ArrayList<>();
        first.add("one");
        first.add("two");

        Collection<String> second = new ArrayList<>();
        second.add("one");
        second.add("four");

        System.out.println("Is first contained in strings? " + strings.containsAll(first));
        System.out.println("Is second contained in strings? " + strings.containsAll(second));

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean hasChanged = strings.addAll(first);

        System.out.println("Has strings changed? " + hasChanged);
        System.out.println("strings = " + strings);

///////////////////////////////////////////////////////////////////////////////////////////////////////////


        Collection<String> toBeRemoved = new ArrayList<>();
        toBeRemoved.add("one");
        toBeRemoved.add("four");
        boolean hasChange = strings.removeAll(toBeRemoved);

        System.out.println("Has strings changed? " + hasChange);
        System.out.println("strings = " + strings);


///////////////////////////////////////////////////////////////////////////////////////////////////////////


        Collection<String> toBeRetained = new ArrayList<>();
        toBeRetained.add("one");
        toBeRetained.add("four");

        boolean hasChan = strings.retainAll(toBeRetained);

        System.out.println("Has strings changed? " + hasChan);
        System.out.println("strings = " + strings);


///////////////////////////////////////////////////////////////////////////////////////////////////////////


        strings.add("one");
        strings.add("two");
        if (!strings.isEmpty()) {
            System.out.println("Indeed strings is not empty!");
        }
        strings.clear();
        System.out.println("The number of elements in strings is " + strings.size());

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        Collection<String> string = List.of("one", "two");

        String[] zeroLengthTab = {};
        String[] result = string.toArray(zeroLengthTab);

        System.out.println("zeroLengthTab = " + Arrays.toString(zeroLengthTab));
        System.out.println("result = " + Arrays.toString(result));

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        Collection<String> strin = List.of("one", "two", "three", "four");
        for (Iterator<String> iterator = strin.iterator(); iterator.hasNext();) {
            String element = iterator.next();
            if (element.length() == 3) {
                System.out.println(element);
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////





    }
}


//https://dev.java/learn/api/collections-framework/
