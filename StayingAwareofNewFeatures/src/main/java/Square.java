public final class Square implements Shape {

    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double surface() {
        return width*width;
    }
}
