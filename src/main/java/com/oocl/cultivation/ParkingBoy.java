package com.oocl.cultivation;

import java.util.LinkedHashSet;
import java.util.Set;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errMessage;
    private final Set<ParkingLot> parkingLots;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
        parkingLots = new LinkedHashSet<>();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public ParkingLot getParkingLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot;
            }
        }
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingLots.add(parkingLot);
    }

    public Ticket park(Car car) {

        if (car == null) {
            errMessage = "你没有给车!";
            return null;

        }
        if (isAllParkingLotFull()) {
            errMessage = "Not enough position.";
            return null;
        } else if (parkingLot.getCars().contains(car)) {
            errMessage = "这辆车已经在停车场了。";
            return null;
        }

        parkingLot.getCars().add(car);
        return new Ticket(car.getId());
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            errMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car2 = ticket.isStatus() ? parkingLot.getCars().stream().filter(car -> car.getId() == ticket.getId()).findAny().orElse(null) : null;
        ticket.setStatus(false);
        errMessage = "Unrecognized parking ticket.";
        return car2;
    }

    public boolean isAllParkingLotFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return false;
            }
        }
        return true;
    }

}
