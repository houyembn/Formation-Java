import java.lang.reflect.Field;

public class Array {
    public static void main(String[] args) throws NoSuchFieldException {

        //with  Class.isArray() we can get the exact type of the internal array
        Class<?> c = String.class;
        Field field = c.getDeclaredField("value");

        Class<?> fieldType = field.getType();
        boolean isArray = fieldType.isArray();
        System.out.println("isArray = " + isArray);

        Class<?> elementType = fieldType.getComponentType();
        System.out.println("elementType = " + elementType);





        /*
        int length = 10;

Object o = Array.newInstance(int.class, 10);
boolean isArray = o.getClass().isArray();
System.out.println("isArray = " + isArray);
Class<?> componentType = o.getClass().getComponentType();
System.out.println("componentType = " + componentType);
int reflectiveLength = Array.getLength(o);
System.out.println("reflectiveLength = " + reflectiveLength);

for (int i = 0; i < reflectiveLength; i++) {
    Array.set(o, i, 2*i);
}
System.out.println(Arrays.toString((int[])o));


-Array.newInstance(int.class, 10): creates a new instance of an array of 10 int.
-o.getClass().isArray(): check if the corresponding class is an array class.
-o.getClass().getComponentType(): returns the type of the components of this array. In this case, it is int.
-Array.getLength(o): returns the length of this array.
-Array.set(o, i, 2*i): reflectively set the i th element of the array o to the value 2*i. You can also reflectively read the i th element of the array o with the Array.get(o, i) method call.
         */

    }
}
