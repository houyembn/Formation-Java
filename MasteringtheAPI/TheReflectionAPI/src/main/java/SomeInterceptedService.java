public class SomeInterceptedService {

    @Interceptor.Intercept(MessageInterceptor.class)
    public String message(String input) {
        return input.toUpperCase();
    }



}
