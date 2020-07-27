package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParkingManger extends ParkingBoy {
    private final List<ParkingBoy> parkingBoys;

    public ParkingManger(Set<ParkingLot> parkingLots, ParkingLot parkingLot) {
        super(parkingLots, parkingLot);
        parkingBoys = new ArrayList<>();
    }

    public List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        return parkingBoys;
    }

    public Ticket specifyParkingBoyToPark(Class<ParkingBoy> parkingBoyClass, Car car) {

        return null;
    }
}
