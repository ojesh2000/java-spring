package strategy.impl;

import strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving normally");
    }
}
