package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PakingServiceTest {
    ParkingSpace parkingSpace = new ParkingSpace();
    @Test
    void scan() {
        Car car;
        assertThat(parkingSpace.scan(new Car("12가 1234", LocalTime.now())));


    }

    @Test
    void parking() {
        Car car = new Car("12가 1234");
        assertThat(parkingSpace.parking(car)).isNotNull();
    }
}