public class Main {

    public static void main(String... args) {
        Circle circle = new Circle(1.0d);
        Square square = new Square(1.0d);
        System.out.println("Circle: " + circle.surface());
        System.out.println("Square: " + square.surface());
    }
}

