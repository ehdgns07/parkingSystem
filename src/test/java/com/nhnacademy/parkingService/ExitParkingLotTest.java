package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ExitParkingLotTest {
    Car car1;
    Car car2;
    Car car3;
    Car car4;
    ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        parkingSpace = new ParkingSpace();
        car1 = new Car("12가 1234");
        car2 = new Car("12가 1235");
        car3 = new Car("12가 1236");
        car4 = new Car("12가 1237");

        car1.scanningTimeOfParking();
        car2.scanningTimeOfParking();
        car3.scanningTimeOfParking();
        car4.scanningTimeOfParking();

        parkingSpace.park(car1);
        parkingSpace.park(car2);
        parkingSpace.park(car3);
        parkingSpace.park(car4);

    }
    @DisplayName("출차하고 주차 목록맵에서 car를 지우는 테스트")
    @Test
    void outOfParkingLot() {

        parkingSpace.getEachSpaceMap().remove(car1.getCarNumberPlate());

        assertThat(parkingSpace.getEachSpaceMap().size()).isEqualTo(3);



    }




    }
