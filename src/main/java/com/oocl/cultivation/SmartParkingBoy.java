package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    @Override
    public ParkingLot getParkingLot() {
        int minCarQuantity = Integer.MAX_VALUE;

        for (ParkingLot parkingLot : parkingLots) {
            minCarQuantity = Math.min(parkingLot.getCars().size(), minCarQuantity);
            setParkingLot(parkingLot);
        }
        return parkingLot;
    }
}
