package com.nhnacademy.parkingService;

import java.util.Map;

public class ParkingService {
    private final ParkingspaceRepository parkingSpace = new ParkingLot();

    public void scan(Car car) { parkingSpace.scan(car); }

    public Car parking(String numberplate, Car car) {

    return car;
    }
}
