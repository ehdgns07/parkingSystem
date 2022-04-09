package com.nhnacademy.parkingService;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpace {
    Map<Integer, String> spaceNumber = new HashMap<>();
    private int index = 0;

    public boolean park(Car car) {
        if(index < 4) {
            spaceNumber.put(index, car.getCarNumberPlate());
            index++;
            return true;
        }
        return false;
    }
}
