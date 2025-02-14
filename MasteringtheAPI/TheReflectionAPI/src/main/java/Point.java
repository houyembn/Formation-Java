import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;

public record Point(int x, int y) {
    public Point() {
        this(0, 0);
    }
    public static void main(String[] args){
        //printing if the class is record or not
        Class<?> c1 = String.class;
        Class<?> c2 = Point.class;
        System.out.println("Is " + c1.getSimpleName() + " a record class? " + c1.isRecord());
        System.out.println("Is " + c2.getSimpleName() + " a record class?  " + c2.isRecord());



        Class<?> c = Point.class;
        //getDeclaringRecord()	Returns the class that declares this component
        RecordComponent[] components = c.getRecordComponents();
        Class<?> declaring = components[0].getDeclaringRecord();
        System.out.println("Declaring record: " + declaring);
        //getName()	Returns the name of this component.
        String name = components[0].getName();
        System.out.println("name = " + name);
        //getAccessor()	Returns the method that models the accessor of this component
        Method accessor = components[0].getAccessor();
        System.out.println("accessor = " + accessor);
        //getType()	Returns the type of this component, as a Class object.
        Class<?> type = components[0].getType();
        System.out.println("type = " + type);
        //getGenericType()	Returns the generic type of this component, as a Type object.
        Type genericType = components[0].getGenericType();
        System.out.println("genericType = " + genericType);

        String genericSignature = components[0].getGenericSignature();
        System.out.println("genericSignature = " + genericSignature);



        //we have reference on the Field of records using the Class.getDeclaredFields() method.
        Class<?> e = Point.class;
        Field[] fields = e.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }






    }
}

