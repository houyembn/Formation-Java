import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public interface Interceptor<T, R> {
    R intercept(T interceptedObject, Method method, Object... arguments);

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Intercept {
        Class<? extends Interceptor<?, ?>> value();
    }

}

