package vehicle;

import strategy.DriveStrategy;

public  class Vehicle {
    private DriveStrategy ds;

    public Vehicle(DriveStrategy ds){
        this.ds = ds;
    }

    public void drive(){
        ds.drive();
    }

}
