package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private ParkingService service;
    private ParkingspaceRepository parkingSpace;
    private Car car;

    @BeforeEach
    void setUp() {
        parkingSpace = mock(ParkingspaceRepository.class);
        //service = new PakingService(repository);
    }

    @Test
    void carComesIn() {
   String numberplate = "김해11가1234";
   Car car = new Car(numberplate);
   when(parkingSpace.scan(car)).thenReturn(car);

    Car newCar = parkingSpace.scan(car);

    assertThat(newCar).isEqualTo(car);
    }
}