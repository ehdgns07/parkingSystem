package com.nhnacademy.parkingService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExitParkingLot {
    int fee = 0;

    public int outOfParkingLot(Car car, ParkingSpace parkingSpace) {
        settlement(car);
        parkingSpace.getEachSpaceMap().remove(car.getCarNumberPlate());

        return fee;
    }

    public void settlement(Car car) {
        PricePolicy pricePolicy = new PricePolicy();
//        if ((ChronoUnit.MINUTES.between(car.getTime(), time)) < 30) {
//
//        }
    }
}
