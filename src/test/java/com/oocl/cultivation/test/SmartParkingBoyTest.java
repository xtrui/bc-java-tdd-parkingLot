package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartParkingBoyTest {
    @Test
    void should_return_parkingLot_which_has_most_empty_positions_when_getParkingLot() {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new LinkedHashSet<>(), new ParkingLot(0, 10));
        ParkingLot parkingLot1 = new ParkingLot(1, 10);
        Car car = new Car(1, "car1");
        parkingLot1.getCars().add(car);
        smartParkingBoy.setParkingLot(parkingLot1);
        // when
        ParkingLot currentParkingLot = smartParkingBoy.getParkingLot();
        // then
        assertEquals(0, currentParkingLot.getId());
    }
}
