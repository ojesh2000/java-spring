import factory.VehicleFactory;
import model.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = (new VehicleFactory()).getVehicle("BIKE");
        printVehicleDetails(vehicle);

    }

    private static void printVehicleDetails(Vehicle vehicle) {
        //if we don't use null object design pattern, we wil have to write a null check over here. This is shown below
//        if(vehicle == null){
//            return ;
//        }
        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    }
}