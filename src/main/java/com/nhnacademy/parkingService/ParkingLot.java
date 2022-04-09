package com.nhnacademy.parkingService;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot implements ParkingspaceRepository {
    Map<String, Car> source = new HashMap<>();
    List<String> numberPlate = new ArrayList<>();
    List<ParkingSpace> ParkingSpace = new ArrayList<>();

    public void initParkingLot(){
        for (int i = 0; i <4 ; i++) {
            ParkingSpace.add(new ParkingSpace());
        }
    }

    @Override
    public Car scan(Car car) {
        numberPlate.add(car.getCarNumberPlate());
        return car;
    }

    public Car parking(Car car){
        source.put(car.getCarNumberPlate(), car);
        return car;
    }

    public void outOfParkingLot(Car car){

    }
}
