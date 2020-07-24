package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> cars;

    ParkingLot() {
        this.cars = new ArrayList<>(10);
    }

    List<Car> getCars() {
        return cars;
    }
    boolean isFull(){
        return cars.size()>=10;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
