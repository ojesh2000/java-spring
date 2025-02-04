import model.Location;
import model.Store;
import model.User;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    //Based on Location we can fetch stores near to it
    public List<Store> getStore(Location location){
        return null;
    }

    //addUsers and removeUsers
    //addStore and removeStore
}
