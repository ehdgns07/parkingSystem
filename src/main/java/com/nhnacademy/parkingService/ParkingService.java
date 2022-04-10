package com.nhnacademy.parkingService;

public class ParkingService {
    private static final ParkingLot parkingLot = new ParkingLot();

    public static void main(String[] args) {

        Car carA = new Car("12카 1234");
        Car carB = new Car("12카 2345");

        Thread enter1 = new Enter(parkingLot, carA);
        Thread enter2 = new Enter(parkingLot, carB);

        parkingLot.initParkingLot();

        enter1.start();
        enter2.start();

        parkingLot.parking(carA);
        parkingLot.parking(carB);
        System.out.println("입차 완료");

        Thread exitParkingLot1 = new ExitParkingLot(parkingLot, carA);
        Thread exitParkingLot2 = new ExitParkingLot(parkingLot, carB);

        exitParkingLot1.start();
        exitParkingLot2.start();

    }

}
