package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class CarTest {
    private ParkingService service;
    private ParkingspaceRepository parkingSpace;
    private Car car;

    @BeforeEach
    void setUp() {
        parkingSpace = mock(ParkingspaceRepository.class);
    }

    @DisplayName("돈이 모자랄때 출차가 금지되는 테스트")
    @Test
    void settlement(){
        long money = 0;
        long fee = 150000;
        Car car = new Car("12가 1234");

        if(money<0){
            assertThatThrownBy(()->car.settlementMoney(fee))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Not enough");
        }


    }
}