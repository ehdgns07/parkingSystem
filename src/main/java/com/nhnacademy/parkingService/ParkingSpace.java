package com.nhnacademy.parkingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpace {
    private Map<String, Car> eachSpaceMap = new HashMap<>();

    private int index = 0;

    public boolean park(Car car) {
        if(index < 4) {
            eachSpaceMap.put(car.getCarNumberPlate(), car);
            index++;
            return true;
        }

        return false;
    }
    public Map<String, Car> getEachSpaceMap() {
        return eachSpaceMap;
    }


}
