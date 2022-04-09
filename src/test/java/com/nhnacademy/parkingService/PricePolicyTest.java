package com.nhnacademy.parkingService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PricePolicyTest {
    Car car1;
    Car car2;
    Car car3;
    Car car4;
    ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        parkingSpace = new ParkingSpace();
        car1 = new Car("12가 1234");
        car2 = new Car("12가 1235");
        car3 = new Car("12가 1236");
        car4 = new Car("12가 1237");

        car1.scanningTimeOfParking();
        car2.scanningTimeOfParking();
        car3.scanningTimeOfParking();
        car4.scanningTimeOfParking();

        parkingSpace.park(car1);
        parkingSpace.park(car2);
        parkingSpace.park(car3);
        parkingSpace.park(car4);

    }
@DisplayName("1번째 가격정책 적용 부분")
    @Test
    void settlement() {
//       LocalDateTime time = LocalDateTime.of(2022,4,9,18,,0,0);
        LocalDateTime time = ChronoUnit.MINUTES.addTo(car1.getTime(), 29);
        assertThat(ChronoUnit.MINUTES.between(car1.getTime(), time)).isEqualTo(29);
        long timeStamp = ChronoUnit.MINUTES.between(car1.getTime(), time);

        if (timeStamp < 30) {
            assertThat(car1.settlementMoney(1000)).isEqualTo(99000);
        }

        time = ChronoUnit.MINUTES.addTo(car1.getTime(), 31);
        timeStamp = ChronoUnit.MINUTES.between(car1.getTime(), time);

        long overThirtyMinutes = 1000 + (((timeStamp - 30) / 10 + 1) * 500);
        assertThat(car1.settlementMoney(overThirtyMinutes)).isEqualTo(97500);

        time = LocalDateTime.of(2022, 4, 10, 18, 0, 0, 0);
        timeStamp = ChronoUnit.DAYS.between(car1.getTime(), time);

        long day = 1;
        if (timeStamp >= day) {
            assertThat(car1.settlementMoney(10000 * timeStamp)).isEqualTo(87500);
        }
    }
}