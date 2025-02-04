package model;

import java.util.ArrayList;
import java.util.List;
import inventory.VehicleInventoryManagement;


public class Store {
    int storeId;
    public VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservationList = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return inventoryManagement.getVehicles(vehicleType);
    }

}
