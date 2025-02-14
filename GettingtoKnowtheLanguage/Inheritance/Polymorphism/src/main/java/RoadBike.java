//This class demonstrates inheritance by extending the Bicycle class, adding a new property (tireWidth), and modifying the printDescription method to include the new property.
public class RoadBike extends Bicycle{
    //
    private int tireWidth;

    public RoadBike(int startCadence,
                    int startSpeed,
                    int startGear,
                    int newTireWidth){
        super(startCadence,
                startSpeed,
                startGear);
        this.setTireWidth(newTireWidth);
    }

    public int getTireWidth(){
        return this.tireWidth;
    }

    public void setTireWidth(int newTireWidth){
        this.tireWidth = newTireWidth;
    }

    public void printDescription(){
        super.printDescription();
        System.out.println("The RoadBike" + " has " + getTireWidth() +
                " MM tires.");
    }
}

