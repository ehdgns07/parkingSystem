package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PakingServiceTest {
    ParkingLot parkingSpace = new ParkingLot();
    @DisplayName("차번호를 스캔하고 시간을 기록")
    @Test
    void scan() {
        Car car;
        assertThat(parkingSpace.scan(new Car("12가 1234")));


    }
    @DisplayName("주차장으로 진입")
    @Test
    void parking() {
        Car car = new Car("12가 1234");
        assertThat(parkingSpace.parking(car)).isNotNull();
    }

@DisplayName("주차 공간에 주차")
    @Test
    void parkingInParkingSpace() {
        Car car = new Car("12가 1234");
        ParkingSpace parkingspace = new ParkingSpace();

        assertThat(parkingspace.park(car)).isNotNull();
        parkingspace.park(car);
        assertThat(parkingspace.getEachSpaceMap().get(0)).isEqualTo(car.getCarNumberPlate());
        parkingspace.park(car);
        parkingspace.park(car);
        assertThat(parkingspace.park(car)).isFalse();

    }
}