package com.nhnacademy.parkingService;

public class ParkingService {
    private final ParkingspaceRepository parkingSpace = new ParkingSpace();

    public void scan(Car car) { parkingSpace.scan(car); }

    public Car parking(String numberplate, CarType carType) {

    return null;
    }
}
