import java.lang.reflect.Constructor;
import java.util.Arrays;

public enum Days {
    SATURDAY, SUNDAY;

// c.getEnumConstants() returns the same array as the one you get with Days.values().
    public static void main(String[] args) {
        Class<?> c = Days.class;
        System.out.println("class: " + c.getName());
        System.out.println("values: " + Arrays.toString(Days.values()));
        System.out.println("constants: " + Arrays.toString(c.getEnumConstants()));


//information about the constructor: Days enum has one constructor, which is private, and takes two parameters:
//a String, which is the name of a constant
//and an int, which is the index of this constant in the array
        Class<Days> a = Days.class;
        Constructor<?>[] constructors = a.getDeclaredConstructors();
        int length = constructors.length;
        System.out.println("# constructors = " + length);
        System.out.println("constructors[0]: " + constructors[0]);






    }
}

