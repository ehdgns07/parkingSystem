package com.nhnacademy.parkingService;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot implements ParkingspaceRepository {
    Map<String, Car> source = new HashMap<>();
    List<String> numberPlate = new ArrayList<>();
    List<ParkingSpace> parkingSpace = new ArrayList<>();
    ExitParkingLot exitParkingLot = new ExitParkingLot();

    public void initParkingLot(){
        for (int i = 0; i <4 ; i++) {
            parkingSpace.add(new ParkingSpace());
        }
    }

    @Override
    public Car scan(Car car) {
        numberPlate.add(car.getCarNumberPlate());
        car.scanningTimeOfParking();
        return car;
    }

    public Car parking(Car car){
        source.put(car.getCarNumberPlate(), car);
        for (int index = 0; index < 4; index++) {
            parkingSpace.get(index).park(car);
        }

        return car;
    }

    public void outOfParkingLot(Car car){
//        exitParkingLot.outOfParkingLot(car,parkingSpace);
    }
}
