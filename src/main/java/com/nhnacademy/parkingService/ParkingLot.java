package com.nhnacademy.parkingService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<String, Car> source = new HashMap<>();
    List<ParkingSpace> parkingSpace = new ArrayList<>();
    

    public void initParkingLot(){
        for (int i = 0; i <4 ; i++) {
            parkingSpace.add(new ParkingSpace());
        }
    }

    public Car parking(Car car){
        boolean isSuccessParking = false;
        source.put(car.getCarNumberPlate(), car);

        for (int index = 0; index < 4; index++) {
            if(isSuccessParking == false) {
                isSuccessParking = parkingSpace.get(index).park(car);
            }
            if(isSuccessParking == true)
                break;
        }
        return car;
    }

    public boolean WithdrawCar(Car car){
        boolean isRemoveSuccess = false;
        for (int index = 0; index < 4; index++) {
            isRemoveSuccess = parkingSpace.get(index).removeCar(car);
        }
        return isRemoveSuccess;

    }
}
