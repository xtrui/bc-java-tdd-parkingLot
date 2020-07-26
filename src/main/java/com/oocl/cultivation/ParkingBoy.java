package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errMessage;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        if (car == null) {
            errMessage = "你没有给车!";
            return null;

        }
        if (parkingLot.isFull()) {
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
        if (ticket==null){
            errMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car2 = ticket.isStatus() ? parkingLot.getCars().stream().filter(car -> car.getId() == ticket.getId()).findAny().orElse(null) : null;
        ticket.setStatus(false);
        errMessage = "Unrecognized parking ticket.";
        return car2;
    }

}
