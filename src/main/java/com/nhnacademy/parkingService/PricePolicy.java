package com.nhnacademy.parkingService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PricePolicy implements PricePolicyRepository {
    private static final long UNDERTHERTYMINUTE = 1000;
    private static final long AFTERTHERTYMINUTE = 500;
    private static final long AFTERONEDAY = 10000;

    @Override
    public void settlement(Car car) {
        long timeStamp = 0;
        long day = 1;
        LocalDateTime time = LocalDateTime.now();
        if ((SubtractionMinutesAboutInAndOut(car, time)) < 30) {
            car.settlementMoney(UNDERTHERTYMINUTE);
        }
        if(SubtractionDaysAboutInAndOut(car,time) >=1){
            car.settlementMoney(10000 * timeStamp);
        }else{
            long overThirtyMinutes = 1000 + (((SubtractionMinutesAboutInAndOut(car, time) - 30) / 10 + 1) * 500);
            car.settlementMoney(overThirtyMinutes);
        }
    }
    public long SubtractionMinutesAboutInAndOut(Car car, LocalDateTime time){
        return ChronoUnit.MINUTES.between(car.getTime(), time);
    }

    public long SubtractionDaysAboutInAndOut(Car car, LocalDateTime time){
        return ChronoUnit.DAYS.between(car.getTime(), time);
    }


}

