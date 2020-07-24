package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot {
    List<Car> cars;

    public Parkinglot() {
        this.cars = new ArrayList<Car>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
