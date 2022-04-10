package com.nhnacademy.parkingService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewPricePolicy implements PricePolicyRepository{
    private static final long UNDERTHERTYMINUTE = 1000;
    private static final long AFTERTHERTYMINUTE = 500;
    private static final long AFTERONEDAY = 10000;

    public long settlement(Car car){
        long timeStamp = 0;
        long day = 1;
        long fee = 0;
        LocalDateTime time = LocalDateTime.now();

        if ((SubtractionMinutesAboutInAndOut(car, time)) < 30) {
            car.settlementMoney(UNDERTHERTYMINUTE);
            fee = UNDERTHERTYMINUTE;
        }
        if (SubtractionDaysAboutInAndOut(car, time) >= 1) {
            fee = AFTERONEDAY * timeStamp;
        } else {
            long overThirtyMinutes = getOverThirtyMinutes(car, time);
            fee = overThirtyMinutes;
        }
        fee = car.settlementMoney(fee);
        return fee;

    }

    private long getOverThirtyMinutes(Car car, LocalDateTime time) {
        return 1000 +
            (((SubtractionMinutesAboutInAndOut(car, time) - 30) / 10 + 1) * AFTERTHERTYMINUTE);
    }

    public long SubtractionMinutesAboutInAndOut(Car car, LocalDateTime time) {
        return ChronoUnit.MINUTES.between(car.getTime(), time);
    }

    public long SubtractionDaysAboutInAndOut(Car car, LocalDateTime time) {
        return ChronoUnit.DAYS.between(car.getTime(), time);
    }

}
