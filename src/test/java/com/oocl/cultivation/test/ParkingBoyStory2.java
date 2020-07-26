package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyStory2 {
    @Test
    void should_return_appropriate_errMessage_when_park_err_and_getErrMessage() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car(1, "car1");

        // when
        Ticket ticket = parkingBoy.park(car);
        ticket = parkingBoy.park(car);
        String errMessage = parkingBoy.getErrMessage();
        parkingBoy.park(null);
        String errMessage2 = parkingBoy.getErrMessage();
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(i, "car" + i));
        }
        parkingBoy.getParkingLot().setCars(cars);
        parkingBoy.park(car);
        String errMessage3 = parkingBoy.getErrMessage();
        // then
        assertEquals(errMessage, "这辆车已经在停车场了。");
        assertEquals(errMessage2, "你没有给车!");
        assertEquals(errMessage3, "停车场已满!");

    }

    @Test
    void should_return_appropriate_errMessage_when_fetch_given_err_ticket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(11);

        // when
        parkingBoy.fetch(ticket);
        String errMessage = parkingBoy.getErrMessage();
        parkingBoy.fetch(null);
        String errMessage2 = parkingBoy.getErrMessage();

        //then
        assertEquals(errMessage, "Unrecognized parking ticket.");
        assertEquals(errMessage2, "Unrecognized parking ticket.");

    }

}
