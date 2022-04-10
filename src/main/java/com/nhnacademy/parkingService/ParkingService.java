package com.nhnacademy.parkingService;

public class ParkingService {
    private static final ParkingLot parkingLot = new ParkingLot();
    static Car carA;
    static Car carB;

    public static void main(String[] args) throws InterruptedException {

        carA = new Car("12카 1234", CarType.MIDSIZE);
        carB = new Car("12카 2345", CarType.LIGHT);

        Thread enter1 = new Enter(parkingLot, carA);
        Thread enter2 = new Enter(parkingLot, carB);

        parkingLot.initParkingLot();

        enter1.start();
        enter1.join();
        parkingLot.parking(carA);
        enter2.start();
        enter2.join();
        parkingLot.parking(carB);


        System.out.println("입차 완료");

        Thread exitParkingLot1 = new ExitParkingLot(parkingLot, carA);
        Thread exitParkingLot2 = new ExitParkingLot(parkingLot, carB);

        exitParkingLot1.start();
        exitParkingLot2.start();

    }

}
