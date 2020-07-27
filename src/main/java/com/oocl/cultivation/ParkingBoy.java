package com.oocl.cultivation;

import java.util.Set;

public class ParkingBoy {
    final Set<ParkingLot> parkingLots;
    ParkingLot parkingLot;
    private String errMessage;

    public ParkingBoy(Set<ParkingLot> parkingLots, ParkingLot parkingLot) {
        this.parkingLots = parkingLots;
        this.parkingLot = parkingLot;
        parkingLots.add(parkingLot);
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
                this.parkingLot = parkingLot;
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
        errMessage = null;
        return new Ticket(car.getId());
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            errMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car2 = ticket.isValid() ? parkingLot.getCars().stream().filter(car -> car.getId() == ticket.getId()).findAny().orElse(null) : null;
        if (car2!=null){
            parkingLots.stream().filter(parkingLot ->parkingLot.getCars().contains(car2)).findFirst().get().getCars().remove(car2);
        }
        ticket.setValid();
        errMessage = "Unrecognized parking ticket.";
        return car2;
    }

    private boolean isAllParkingLotFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return false;
            }
        }
        return true;
    }

}
