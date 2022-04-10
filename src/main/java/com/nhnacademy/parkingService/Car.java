package com.nhnacademy.parkingService;

import java.time.LocalDateTime;
import java.util.Objects;

public class Car {

    private String numberPlate;
    private CarType carType;

    private long money = 0;
    ParkingService parkingService = new ParkingService();
    private LocalDateTime time;

    public Car(String numberPlate, CarType carType) {
        this.numberPlate = numberPlate;
        this.money = 100000;
        this.carType = carType;
    }

    public void scanningTimeOfParking() {
        this.time = LocalDateTime.now();
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

//    @Override
//    public int hashCode() {
//        return Objects.hash(numberPlate, carType);
//    }
//
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


    public String getCarNumberPlate() {
        return numberPlate;
    }

    public int getHour() {
        return time.getHour();
    }

    public int getMinute() {
        return time.getMinute();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public long settlementMoney(long price) {
        if ((money - price) < 0) {
            throw new MoneyUnderBoundException("Not enough money");
        }

        this.money -= price;
        System.out.println(getCarNumberPlate()+ " 요금은 :" + price);

        return this.money;
    }

    public long getMoney() {
        return money;
    }

    public CarType getCarType() {
        return carType;
    }
}