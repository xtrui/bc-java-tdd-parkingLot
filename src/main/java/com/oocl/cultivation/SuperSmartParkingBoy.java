package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy() {
        super();
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
