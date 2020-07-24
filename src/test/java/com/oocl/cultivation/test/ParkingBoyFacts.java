package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_given_car() {
        //given
        Car car = new Car();
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
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertNotNull(car);
    }

    @Test
    void should_return_tickets_when_park_given_cars() {
        //given
        List<Car> cars = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        List<Ticket> tickets = parkingBoy.park(cars);
        //then
        assertEquals(tickets.size(),cars.size());
    }
}
