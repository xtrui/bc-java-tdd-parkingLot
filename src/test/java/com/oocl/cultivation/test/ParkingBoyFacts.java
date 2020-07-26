package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {

    @Test
    void should_return_ticket_when_parking_given_car() {
        //given
        Car car = new Car(1, "car");
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedHashSet<>(), new ParkingLot(1, 10));
        //when
        Ticket ticket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(ticket);
        //then
        assertNotNull(ticket);
        assertNotNull(car1);
    }


    @Test
    void should_return_right_car_when_park_given_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedHashSet<>(), new ParkingLot(1, 10));
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
    void should_return_null_when_fetch_given_null_or_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedHashSet<>(), new ParkingLot(1, 10));
        //when
        Ticket ticket = new Ticket();
        Car car = parkingBoy.fetch(null);
        Car car2 = parkingBoy.fetch(ticket);
        //then
        assertNull(car);
        assertNull(car2);
    }

    @Test
    void should_return_false_when_fetch_given_used_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedHashSet<>(), new ParkingLot(1, 10));
        Car car = new Car(1, "car1");
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);
        Car car2 = parkingBoy.fetch(ticket);
        //then
        assertNull(car2);
    }

    @Test
    void should_return_null_when_park_parkingLot_is_full() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedHashSet<>(), new ParkingLot(1, 10));
        List<Car> cars = new ArrayList<>();
        Car car = new Car(11, "cars");
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(i, "car" + i));
        }
        parkingBoy.getParkingLot().setCars(cars);
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        assertNull(ticket);
    }
}
