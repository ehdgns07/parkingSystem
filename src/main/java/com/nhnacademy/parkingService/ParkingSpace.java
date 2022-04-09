package com.nhnacademy.parkingService;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpace implements ParkingspaceRepository {
    Map<String, Car> source = new HashMap<>();
    List<String> numberPlate = new ArrayList<>();

    @Override
    public Car scan(Car car) {
        numberPlate.add(car.getCarNumberPlate());
        LocalTime localTime = LocalTime.now();
        return car;
    }

    public Map<String, Car> parking(Car car){
        source.put(car.getCarNumberPlate(), car);
        return source;
    }



}
