package com.nhnacademy.parkingService;

import java.util.ArrayList;
import java.util.List;

public class Enter extends Thread{
    ParkingLot parkingLot;
    Car car;
    List<String> numberPlate = new ArrayList<>();

    Enter(ParkingLot parkingLot, Car car){
        this.parkingLot = parkingLot;
        this.car = car;
    }

    public void run(){
        scan(car);
    }
    public Car scan(Car car) {
        numberPlate.add(car.getCarNumberPlate());
        car.scanningTimeOfParking();
        return car;
    }
}
