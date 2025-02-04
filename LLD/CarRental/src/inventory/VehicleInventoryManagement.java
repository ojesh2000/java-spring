package inventory;

import model.Vehicle;
import model.VehicleType;

import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;


    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        //return vehicles based on vehicleType
        return null;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
