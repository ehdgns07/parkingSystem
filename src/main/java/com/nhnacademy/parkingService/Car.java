package com.nhnacademy.parkingService;

import static com.nhnacademy.parkingService.CarType.LARGE;
import static com.nhnacademy.parkingService.CarType.LIGHT;
import static com.nhnacademy.parkingService.CarType.MEDIUM;
import static com.nhnacademy.parkingService.CarType.SMALL;

import java.time.LocalTime;
import java.util.Objects;

public class Car {

    private String numberPlate;
    private CarType carType;
    private ParkingspaceRepository parkingSpace;
    ParkingService parkingService = new ParkingService();
    LocalTime time;

    public Car(String numberPlate, LocalTime time) {
        this.numberPlate = numberPlate;
        this.time = time;
//        this.carType = carType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(numberPlate, car.numberPlate) && carType == car.carType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPlate, carType);
    }

//    public static Car large(String numberPlate) {
//        return new Car(numberPlate, LARGE); }
//
//    public static Car medium(String numberPlate) {
//        return new Car(numberPlate, MEDIUM); }
//
//    public static Car small(String numberPlate) {
//        return new Car(numberPlate, SMALL); }
//
//    public static Car light(String numberPlate) {
//        return new Car(numberPlate, LIGHT); }
//
//    public void CarComesIn() {
//        parkingService.scan(new Car("김해12가1234", MEDIUM));
//    }
//

    public String getCarNumberPlate() {
        return numberPlate;
    }
}
