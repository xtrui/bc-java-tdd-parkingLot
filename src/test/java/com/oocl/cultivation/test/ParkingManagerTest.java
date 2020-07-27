package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

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
        parkingManger.addParkingBoy(smartParkingBoy);
        parkingManger.addParkingBoy(superSmartParkingBoy);
        Car car = new Car(1, "car1");
        // when
        Ticket ticket = parkingManger.specifyParkingBoyToPark(SmartParkingBoy.class, car);
        // then
        assertTrue(parkingManger.addParkingBoy(parkingBoy).contains(parkingBoy));
        assertNotNull(ticket);
    }

    @Test
    void should_return_corresponding_message_when_specifyParkingBoyToPark_fail() {
        // given
        LinkedHashSet<ParkingLot> parkingLots = new LinkedHashSet<>();
        ParkingLot parkingLot = new ParkingLot('1', 2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, parkingLot);
        ParkingManger parkingManger = new ParkingManger(parkingLots, parkingLot);
        parkingManger.addParkingBoy(parkingBoy);
        Car car = new Car(1, "car1");
        Car car2 = new Car(2, "car2");
        Car car3 = new Car(3, "car3");
        // when

        parkingManger.specifyParkingBoyToPark(ParkingBoy.class, car);
        Ticket ticket = parkingManger.specifyParkingBoyToPark(ParkingBoy.class, car);
        String errMessage = parkingBoy.getErrMessage();
        parkingManger.specifyParkingBoyToPark(ParkingBoy.class, null);
        String errMessage2 = parkingBoy.getErrMessage();
        parkingManger.specifyParkingBoyToPark(ParkingBoy.class, car2);
        parkingManger.specifyParkingBoyToPark(ParkingBoy.class, car3);
        String errMessage3 = parkingBoy.getErrMessage();

        // then
        assertNull(ticket);
        assertEquals("这辆车已经在停车场了。", errMessage);
        assertEquals("你没有给车!", errMessage2);
        assertEquals("Not enough position.", errMessage3);

    }
}
