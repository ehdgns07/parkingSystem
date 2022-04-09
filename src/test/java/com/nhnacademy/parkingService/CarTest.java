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

}