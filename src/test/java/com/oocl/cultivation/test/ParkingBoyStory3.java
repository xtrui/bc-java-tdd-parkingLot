package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyStory3 {
    @Test
    void should_return_2_when_getParkingLot_given_11_cars() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingBoy.setParkingLot(parkingLot);
        parkingBoy.setParkingLot(parkingLot2);
        Car car = new Car(11, "car1");
        // when
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(i, "car" + i));
        }
        parkingBoy.getParkingLot().setCars(cars);
        parkingBoy.park(car);
        ParkingLot currentParkingLot = parkingBoy.getParkingLot();
        // then

    }
}
