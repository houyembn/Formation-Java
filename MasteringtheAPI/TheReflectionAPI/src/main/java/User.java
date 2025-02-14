import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User[" + "name=" + name + "]";
    }

    //here are the methods of User
    public static void main(String[] args) {
        Class<?> c = User.class;
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        //printing the 19 constructors i have in this class
        Class<?> f = String.class;
        Constructor<?>[] constructors = f.getDeclaredConstructors();
        System.out.println("# constructors = " + constructors.length);
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }


        //the parameters of my constructor
        Class<?> a = ArrayList.class;
        Constructor<?>[] constructorss = a.getConstructors();
        for (Constructor<?> constructor : constructorss) {
            System.out.println("constructor with " + constructor.getParameterCount() + " parameter");
            for (Class<?> type : constructor.getParameterTypes()) {
                System.out.println("   " + type.getName());
            }
        }

        //with Constructor.getGenericParameterTypes()  and Type.getTypeName() it returns an array of Type,
        Class<?> z = ArrayList.class;
        Constructor<?>[] construct = z.getConstructors();
        for (Constructor<?> constructor : construct) {
            System.out.println("constructor with " + constructor.getParameterCount() + " parameter");
            for (Type type : constructor.getGenericParameterTypes()) {
                System.out.println("   " + type.getTypeName());
            }
        }







/*
        1.Obtaining the Return Type of a Method:
-The Method.getReturnType() method gives the raw type (e.g., java.lang.Object) returned by a method.
-The Method.getGenericReturnType() method returns a Type object, which provides information about the generic type (e.g., E for a parameterized List).
Example: For List.get(int) method, getReturnType() will return java.lang.Object, while getGenericReturnType() will return E.

        2.Obtaining Method Parameters:
-Method.getParameters() gives access to the method's formal parameters (if they have been compiled with the -parameters option in javac).
-By default, class files do not store parameter names to reduce the size of .class files. If you need them, compile with the -parameters option.

       3.Obtaining Method Exceptions:
The Method.getExceptionTypes() and Method.getGenericExceptionTypes() methods provide information about the exceptions declared to be thrown by the method.
These methods return an array of Class or Type objects, respectively, and can be used to determine the exceptions a method may throw (e.g., InstantiationException, IllegalAccessException).

*/
    }

}

