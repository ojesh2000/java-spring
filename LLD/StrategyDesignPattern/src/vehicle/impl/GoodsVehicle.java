package vehicle.impl;

import strategy.DriveStrategy;
import strategy.impl.NormalDriveStrategy;
import vehicle.Vehicle;

public class GoodsVehicle extends Vehicle {
    public DriveStrategy dsa = new NormalDriveStrategy();
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
