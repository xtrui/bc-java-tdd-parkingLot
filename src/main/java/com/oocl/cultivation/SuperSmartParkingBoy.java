package com.oocl.cultivation;

import java.util.Set;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(Set<ParkingLot> parkingLots, ParkingLot parkingLot) {
        super(parkingLots, parkingLot);
    }

    @Override
    public ParkingLot getParkingLot() {
        double maxAvailablePositionRate = Double.MIN_VALUE;
        double availablePositionRate;

        for (ParkingLot parkingLot : parkingLots) {
            availablePositionRate = (parkingLot.getCapacity() - parkingLot.getCars().size()) / (double) parkingLot.getCapacity();
            if (availablePositionRate > maxAvailablePositionRate) {
                maxAvailablePositionRate = availablePositionRate;
                setParkingLot(parkingLot);
            }
        }
        return parkingLot;
    }
}
