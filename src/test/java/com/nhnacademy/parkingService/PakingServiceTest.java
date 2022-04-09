package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class PakingServiceTest {
    ParkingLot parkingSpace = new ParkingLot();
    @Test
    void scan() {
        Car car;
        assertThat(parkingSpace.scan(new Car("12가 1234", LocalTime.now())));


    }

    @Test
    void initParkingLot(){


    }
    @Test
    void parking() {
        Car car = new Car("12가 1234",LocalTime.now());
        assertThat(parkingSpace.parking(car)).isNotNull();
    }

    @Test
    void parkingInParkingSpace() {
        Car car = new Car("12가 1234",LocalTime.now());
        ParkingSpace parkingspace = new ParkingSpace();

        assertThat(parkingspace.park(car)).isNotNull();
        parkingspace.park(car);
        assertThat(parkingspace.spaceNumber.get(0)).isEqualTo(car.getCarNumberPlate());
        parkingspace.park(car);
        parkingspace.park(car);
        assertThat(parkingspace.park(car)).isFalse();

    }
}