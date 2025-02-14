import java.util.Objects;

public record Message(String message) {

    public Message {
        Objects.requireNonNull(message);
    }
    public static void main(String[] args){

        /*BeanFactory beanFactory = BeanFactory.INSTANCE;

            Message message1 = beanFactory.getInstanceOf(Message.class, "Hello");
            System.out.println("Message 1 = " + message1);

            Message message2 = beanFactory.getInstanceOf(Message.class, "world");
            System.out.println("Message 2 = " + message2);*/


            BeanFactory beanFactory = BeanFactory.INSTANCE;

            Message message = beanFactory.getInstanceOf(Message.class, "Hello");
            System.out.println("Message = " + message);

            DBService dbService1 = beanFactory.getInstanceOf(DBService.class);
            DBService dbService2 = beanFactory.getInstanceOf(DBService.class);
            System.out.println("Instances of DBService are the same? " + (dbService1 == dbService2));



    }

}

