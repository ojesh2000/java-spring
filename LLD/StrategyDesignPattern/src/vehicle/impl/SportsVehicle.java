package vehicle.impl;

import strategy.DriveStrategy;
import strategy.impl.SportsDriveStrategy;
import vehicle.Vehicle;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
