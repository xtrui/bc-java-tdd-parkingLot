package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyStory4 {
    @Test
    void should_return_parkingLot_which_has_most_empty_positions_when_getParkingLot() {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Car car = new Car(1, "car1");
        parkingLot1.getCars().add(car);
        // when
        ParkingLot currentParkingLot = smartParkingBoy.getParkingLot();
        // then
        assertEquals(2, currentParkingLot.getId());
    }
}
