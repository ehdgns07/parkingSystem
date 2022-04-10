package com.nhnacademy.parkingService;

public class ExitParkingLot extends Thread{
    ParkingLot parkingLot;
    Car car;
    long remainMoney = 0;

    ExitParkingLot(ParkingLot parkingLot, Car car){
        this.parkingLot = parkingLot;
        this.car = car;

    }

    public void run(){
        boolean isRemoveSuccess;

        isRemoveSuccess = parkingLot.WithdrawCar(car);
        if(isRemoveSuccess) {
            remainMoney = settlement(car);
        }

        System.out.println("남은돈은 : "  +  remainMoney);

    }

    public long settlement(Car car) {
        PricePolicy pricePolicy = new PricePolicy();
        remainMoney = pricePolicy.settlement(car);
        return remainMoney;
    }
}
