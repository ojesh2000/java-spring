package factory;

import model.Vehicle;
import model.impl.Car;
import model.impl.NullVehicle;

public class VehicleFactory {

    public Vehicle getVehicle(String name){
        if("CAR".equals(name)){
            return new Car();
        }
        //instead of returning null, we return NullObject
        return new NullVehicle();
    }
}
