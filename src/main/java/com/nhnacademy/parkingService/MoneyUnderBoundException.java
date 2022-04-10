package com.nhnacademy.parkingService;

public class MoneyUnderBoundException extends RuntimeException {
    public MoneyUnderBoundException(String message) {
        super(message);
    }
}
