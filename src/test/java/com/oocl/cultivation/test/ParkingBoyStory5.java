package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyStory5 {
    @Test
    void should_return_parkingLot_which_has_larger_available_position_rate_when_getParkingLot() {
        // given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(1, 12);
        ParkingLot parkingLot2 = new ParkingLot(2, 10);
        Car car = new Car(1, "car1");
        parkingLot1.getCars().add(car);
        parkingLot2.getCars().add(car);
        superSmartParkingBoy.setParkingLot(parkingLot1);
        superSmartParkingBoy.setParkingLot(parkingLot2);
        // when
        ParkingLot currentParkingLot = superSmartParkingBoy.getParkingLot();
        // then
        assertEquals(1, currentParkingLot.getId());
    }
}
