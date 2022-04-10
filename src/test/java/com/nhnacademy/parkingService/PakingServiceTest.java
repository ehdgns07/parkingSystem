package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PakingServiceTest {
    ParkingLot parkingLot = new ParkingLot();


    @DisplayName("주차장으로 진입")
    @Test
    void parking() {
        Car car = new Car("12가 1234");
        parkingLot.initParkingLot();
        assertThat(parkingLot.parking(car)).isNotNull();
    }

@DisplayName("주차 공간에 주차")
    @Test
    void parkingInParkingSpace() {
        Car car = new Car("12가 1234");
        ParkingSpace parkingspace = new ParkingSpace();

        assertThat(parkingspace.park(car)).isNotNull();
        parkingspace.park(car);
        assertThat(parkingspace.getEachSpaceMap().get(car.getCarNumberPlate()).getCarNumberPlate()).isEqualTo(car.getCarNumberPlate());
        parkingspace.park(car);
        parkingspace.park(car);
        assertThat(parkingspace.park(car)).isFalse();

    }
}