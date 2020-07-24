package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkinglot;

    public ParkingBoy() {
        this.parkinglot = new ParkingLot();
    }

    public ParkingLot getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(ParkingLot parkinglot) {
        this.parkinglot = parkinglot;
    }

    public Ticket park(Car car) {

        parkinglot.getCars().add(car);
        return new Ticket(car.getId());
    }

    public Car fetch(Ticket ticket) {
        Car car2 = ticket.isStatus()?parkinglot.getCars().stream().filter(car -> car.getId()==ticket.getId()).findAny().orElse(null):null;
        ticket.setStatus(false);
        return car2;
    }

}
