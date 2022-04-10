package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnterTest {
    ParkingLot parkingLot = new ParkingLot();
    Car car = new Car("12가 1234");
    Enter enter = new Enter(parkingLot, car);
    @Test
    void run() {
    }

    @DisplayName("차번호를 스캔하고 시간을 기록")
    @Test
    void scan() {
        assertThat(enter.scan(car));
    }
}