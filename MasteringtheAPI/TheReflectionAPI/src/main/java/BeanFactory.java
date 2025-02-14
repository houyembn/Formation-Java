import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum BeanFactory {
    //The getInstanceOf method in the BeanFactory enum is responsible for creating and returning an instance of a specified class (beanClass) using a constructor that matches the provided arguments.
    INSTANCE;
    public <T> T getInstanceOf(Class<T> beanClass, Object... arguments) {
        try {
            // Creating the array of the parameters types
            Class<?>[] argumentsClasses =
                    Arrays.stream(arguments).map(Object::getClass).toArray(Class<?>[]::new);

            // Locating the corresponding constructor
            Constructor<T> beanConstructor = beanClass.getConstructor(argumentsClasses);

            // creating the bean
            T bean = beanConstructor.newInstance(arguments);
            return bean;
        } catch (NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T instantiateBeanClass(Class<T> beanClass, Object[] arguments)
            throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
        Class<?>[] argumentsClasses =
                Arrays.stream(arguments).map(Object::getClass).toArray(Class<?>[]::new);
        Constructor<T> beanConstructor = beanClass.getConstructor(argumentsClasses);
        T bean = beanConstructor.newInstance(arguments);
        return bean;
    }
}

