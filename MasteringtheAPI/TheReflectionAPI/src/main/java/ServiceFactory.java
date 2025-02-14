import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ServiceFactory {
    //The ServiceFactory class dynamically invokes a method on a service class, optionally intercepting the call with a specified interceptor if the method is annotated with @Intercept.
    public static void main(String[] args) {

        String interceptedOutput =
                ServiceFactory.invoke(SomeInterceptedService.class, "message", "Hello");
        System.out.println("Intercepted output = " + interceptedOutput);

        String nonInterceptedOutput =
                ServiceFactory.invoke(SomeNonInterceptedService.class, "message", "Hello");
        System.out.println("Non intercepted output = " + nonInterceptedOutput);
    }

    public static <T, R> R invoke(
            Class<? extends T> serviceClass, String methodName, Object... arguments) {
        try {
            // Getting an instance of the service
            T service = serviceClass.getConstructor().newInstance();

            // Locating the service method
            Class<?>[] parameterClasses =
                    Arrays.stream(arguments).map(Object::getClass).toArray(Class<?>[]::new);
            Method method = serviceClass.getDeclaredMethod(methodName, parameterClasses);

            // locating the Intercept annotation
            if (method.isAnnotationPresent(Interceptor.Intercept.class)) {
                Interceptor.Intercept intercept = method.getDeclaredAnnotation(Interceptor.Intercept.class);
                Class<? extends Interceptor<T, R>> interceptorClass =
                        (Class<? extends Interceptor<T, R>>) intercept.value();

                // creating an instance of the interceptor
                Interceptor<T, R> interceptor = interceptorClass.getConstructor().newInstance();

                // intercepting the service method
                R returnedObject = interceptor.intercept(service, method, arguments);
                return returnedObject;
            } else {
                // invoking the service method
                R returnedObject = (R) method.invoke(service, arguments);
                return returnedObject;
            }
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
