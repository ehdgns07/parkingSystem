package com.nhnacademy.parkingService;

public class ExitParkingLot extends Thread {
    ParkingLot parkingLot;
    Car car;
    long remainMoney = 0;

    ExitParkingLot(ParkingLot parkingLot, Car car) {
        this.parkingLot = parkingLot;
        this.car = car;

    }

    public void run() {
        boolean isRemoveSuccess;

        isRemoveSuccess = parkingLot.WithdrawCar(car);
        if (isRemoveSuccess) {
            remainMoney = settlement(car);
        }

        System.out.println(car.getCarNumberPlate() + " 남은돈은 : " + remainMoney);

    }

    public long settlement(Car car) {
//        1번 정책 적용부분
//        PricePolicy pricePolicy = new PricePolicy();
//        remainMoney = pricePolicy.settlement(car);

//        2번 정책 적용 부분
        NewPricePolicy newPricePolicy = new NewPricePolicy();
        remainMoney = newPricePolicy.settlement(car);

        return remainMoney;
    }
}
