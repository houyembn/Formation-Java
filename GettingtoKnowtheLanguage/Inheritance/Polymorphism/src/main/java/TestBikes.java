//This class demonstrates polymorphism by creating instances of Bicycle, MountainBike, and RoadBike and calling the printDescription method on each, showing different behavior for each type of bike.
public class TestBikes {
    public static void main(String[] args){
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, 10);
        bike03 = new RoadBike(40, 20, 8, 23);

        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
    }
}
