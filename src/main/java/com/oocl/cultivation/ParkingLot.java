package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLot {
    private int id;
    private List<Car> cars;
    private int capacity;

    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.cars = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    ParkingLot() {
        this.cars = new ArrayList<>(10);
        this.capacity = 10;
    }

    public ParkingLot(int id) {
        this.id = id;
        this.cars = new ArrayList<>(10);
        this.capacity = 10;
    }

    public int getEmptyPositionQuantity() {
        return capacity - cars.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    boolean isFull() {
        return cars.size() >= capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParkingLot)) {
            return false;
        }
        ParkingLot that = (ParkingLot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
