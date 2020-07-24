package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Car> cars;

    public ParkingLot() {
        this.cars = new ArrayList<Car>(10);
    }

    public List<Car> getCars() {
        return cars;
    }
    public boolean isFull(){
//        return cars.size()>=10;
        return true;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
