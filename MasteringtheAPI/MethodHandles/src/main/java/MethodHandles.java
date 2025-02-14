import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethodHandles {
    /*-I learned that:
-Method handles are a low-level mechanism for method lookup and invocation.
-Method Handle Lookup:
1.Creating a Lookup Object:
MethodHandles.publicLookup() → Searches only for public methods.
MethodHandles.lookup() → Can access private and protected methods.

2.Defining Method Type (MethodType)
Specifies the return type and argument types.*/
MethodType methodType = MethodType.methodType(int.class, String.class);

/*3.Finding Methods & Constructors
Instance Method: lookup.findVirtual(Class, String, MethodType)
Static Method: lookup.findStatic(Class, String, MethodType)
Constructor: lookup.findConstructor(Class, MethodType)

-Invocation Methods:
invokeExact() – Requires exact match of argument types.
invoke() – More permissive, attempts type conversions.
invokeWithArguments() – Allows passing arguments as a list or array.

MethodType replaceMethodType = MethodType.methodType(String.class, char.class, char.class);
MethodHandle replaceMethodHandle = lookup.findVirtual(String.class, "replace", replaceMethodType);
String result = (String) replaceMethodHandle.invokeExact("dummy", 'd', 'm');


1.Accessing Fields:
-Use findGetter and findSetter for instance fields.
-Use findStaticGetter and findStaticSetter for static fields.
Example:
MethodHandle setter = lookup.findSetter(Example.class, "abc", String.class);
MethodHandle getter = lookup.findGetter(Example.class, "abc", String.class);
setter.invoke(example, "new value");
String result = (String) getter.invoke(example);

2.Working with Arrays:
-Use arrayConstructor to create arrays dynamically.
-Use arrayElementSetter and arrayElementGetter to modify or access elements.
-Use arrayLength to retrieve the array size.

3.Exception Handling:
-catchException: Wraps a method handle with an exception handler.
-tryFinally: Wraps a method handle inside a try-finally block.

4.Example of Exception Handling:
-catchException example:
MethodHandle wrapped = MethodHandles.catchException(methodHandle, IllegalArgumentException.class, handler);

-tryFinally example:
MethodHandle wrappedWithFinally = MethodHandles.tryFinally(methodHandle, cleanupMethod);


     -Method Handle Transformations
1. Type Transformation (asType)
-Adapts a method handle’s type to a new one.
-Converts arguments and return types dynamically.
Example:
/*
MethodHandle adapter = targetMethodHandle.asType(MethodType.methodType(String.class, String.class)); */
/*
-Can fail with WrongMethodTypeException if conversion is impossible.

2.Permute Arguments (permuteArguments)
-Reorders arguments before invoking a method handle.
Example:
MethodHandle reversedArguments = MethodHandles.permuteArguments(targetMethodHandle,
MethodType.methodType(void.class, boolean.class, long.class, String.class, int.class),


3. Insert Arguments (insertArguments)
Binds specific arguments in advance.
Example:
MethodHandle boundArguments = MethodHandles.insertArguments(targetMethodHandle, 1, "new", 3L);
boundArguments.invoke(1, true); // Outputs: "1new3true"


4. Filter Arguments (filterArguments)
Transforms specific arguments before passing them to the target method.
Example:
MethodHandle withFilters = MethodHandles.filterArguments(targetMethodHandle, 0, increment, null, null, negate);
withFilters.invoke(3, "abc", 5L, false); // Outputs: "4abc5true"

5. Fold Arguments (foldArguments)
Pre-processes arguments before invoking a method handle.
Example:
MethodHandle preProcessedArguments = MethodHandles.foldArguments(targetMethodHandle, 1, combinerMethodHandle);
preProcessedArguments.invokeExact(10000, 1, 2); // Outputs: "1 + 2 equals 3 and 10000 is ignored"

6. Filter Return Value (filterReturnValue)
Transforms a method's return value before passing it forward.
Example:
MethodHandle getSomeUppercaseString = MethodHandles.filterReturnValue(getSomeString, resultTransform);
System.out.println(getSomeUppercaseString.invoke()); // Outputs: "MUMMY"



        -Conversion between Reflection API and method handles:
-Convert Method to MethodHandle using unreflect():
Exemple:
Method method = Example.class.getMethod("test", String.class);
MethodHandles.Lookup lookup = MethodHandles.lookup();
MethodHandle methodHandle = lookup.unreflect(method);
String result = (String) methodHandle.invoke("something");

-Convert Field to MethodHandle for getters and setters:
Field field = Example.class.getField("magic");
MethodHandle setter = lookup.unreflectSetter(field);
MethodHandle getter = lookup.unreflectGetter(field);
setter.invoke("something");
String result = (String) getter.invoke(); // "something"


-Convert MethodHandle back to Method or Field using reflectAs():
Method method = MethodHandles.reflectAs(Method.class, methodHandle);
Field field = MethodHandles.reflectAs(Field.class, getter);
 */




}
