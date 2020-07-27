package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingManagerTest {
    @Test
    void should_return_ticket_when_specify_parkingBoy_toPark() {
        // given
        LinkedHashSet<ParkingLot> parkingLots = new LinkedHashSet<>();
        ParkingLot parkingLot = new ParkingLot('1', 2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, parkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, parkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots, parkingLot);
        ParkingManger parkingManger = new ParkingManger(parkingLots, parkingLot);
        // when
        parkingManger.addParkingBoy(smartParkingBoy);
        parkingManger.addParkingBoy(superSmartParkingBoy);
        Car car = new Car(1, "car1");
        Ticket ticket = parkingManger.specifyParkingBoyToPark(ParkingBoy.class, car);
        // then
        assertTrue(parkingManger.addParkingBoy(parkingBoy).contains(parkingBoy));
        assertNotNull(ticket);
    }
}
