package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParkingSpaceTest {
    ParkingSpace parkingSpace = new ParkingSpace();
    @Test
    void getEachSpaceMap() {
        Car car = new Car("12가 1234");
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