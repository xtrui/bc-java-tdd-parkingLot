package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    @Override
    public ParkingLot getParkingLot() {
        int maxEmptyPosition = Integer.MIN_VALUE;
        int emptyPosition;

        for (ParkingLot parkingLot : parkingLots) {
            emptyPosition = parkingLot.getCars().size();
            if (emptyPosition > maxEmptyPosition) {
                maxEmptyPosition = emptyPosition;
                setParkingLot(parkingLot);
            }
        }
        return parkingLot;
    }
}
