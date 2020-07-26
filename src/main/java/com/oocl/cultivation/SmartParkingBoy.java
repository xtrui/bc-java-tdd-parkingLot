package com.oocl.cultivation;

import java.util.Set;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(Set<ParkingLot> parkingLots, ParkingLot parkingLot) {
        super(parkingLots, parkingLot);
    }

    @Override
    public ParkingLot getParkingLot() {
        int maxEmptyPositionQuantity = Integer.MIN_VALUE;
        int emptyPositionQuantity;

        for (ParkingLot parkingLot : parkingLots) {
            emptyPositionQuantity = parkingLot.getEmptyPositionQuantity();
            if (emptyPositionQuantity > maxEmptyPositionQuantity) {
                maxEmptyPositionQuantity = emptyPositionQuantity;
                setParkingLot(parkingLot);
            }
        }
        return parkingLot;
    }
}
