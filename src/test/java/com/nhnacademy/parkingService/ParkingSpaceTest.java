package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParkingSpaceTest {
    ParkingSpace parkingSpace = new ParkingSpace();
    @DisplayName("주차 공간에서 출차 시키는 테스트")
    @Test
    void getEachSpaceMap() {
        Car car = new Car("12가 1234", CarType.MIDSIZE);
        parkingSpace.park(car);
        for (int index = 0; index < 4; index++) {
            if(car.getCarNumberPlate() == parkedCar(car.getCarNumberPlate())) {
                assertThat(
                    parkingSpace.getEachSpaceMap().remove(car.getCarNumberPlate())).isEqualTo(car);
                break;
            }
        }

    }

    String parkedCar(String carnumber){
        parkingSpace.getEachSpaceMap().get(carnumber);
        return parkingSpace.getEachSpaceMap().get(carnumber).getCarNumberPlate();
    }
}