package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_given_car() {
        //given
        Car car = new Car(1, "car");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket() {
        //given
//        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(1);
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertNotNull(car);
    }

    @Test
    void should_return_ringt_car_when_park_given_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car(1, "car1");
        Car car2 = new Car(2, "car2");
        //when
        Ticket ticket = parkingBoy.park(car);
        Ticket ticket2 = parkingBoy.park(car2);

        //then
        assertNotNull(ticket);
        assertNotNull(ticket2);
        assertEquals(car, parkingBoy.fetch(ticket));
        assertEquals(car2, parkingBoy.fetch(ticket2));
    }

    @Test
    void should_return_null_when_fecth_given_null_or_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = new Ticket();
        Car car = parkingBoy.fetch(null);
        Car car2 = parkingBoy.fetch(ticket);
        //then
        assertNull(car);
        assertNull(car2);
    }
}
