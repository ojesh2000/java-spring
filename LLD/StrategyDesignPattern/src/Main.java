import strategy.impl.SportsDriveStrategy;
import vehicle.Vehicle;
import vehicle.impl.GoodsVehicle;
import vehicle.impl.SportsVehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle v = new GoodsVehicle();
        Vehicle v2 = new SportsVehicle();
        v.drive();
        v2.drive();
    }
}