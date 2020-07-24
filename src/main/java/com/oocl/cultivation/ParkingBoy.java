package com.oocl.cultivation;

public class ParkingBoy {
    Parkinglot parkinglot;

    public ParkingBoy() {
        this.parkinglot = new Parkinglot();
    }

    public Ticket park(Car car) {
        parkinglot.getCars().add(car);
        return new Ticket(car.getId());
    }

    public Car fetch(Ticket ticket) {
        return parkinglot.getCars().stream().filter(car -> car.getId()==ticket.getId()).findAny().orElse(null);
    }

}
