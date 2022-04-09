package com.nhnacademy.parkingService;

public class ParkingService {
    private static final ParkingspaceRepository parkingLot = new ParkingLot();

    public static void main(String[] args) {
        Car car = new Car("12카 1234");
        parkingLot.scan(car);
        parkingLot.parking(car);
    }

    public Car parking(String numberplate, Car car) {
        parkingLot.parking(car);
    return car;
    }
}
