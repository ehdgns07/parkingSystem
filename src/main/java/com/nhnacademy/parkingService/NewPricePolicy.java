package com.nhnacademy.parkingService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewPricePolicy implements PricePolicyRepository {
    private static final long UNDERONEHOUR = 1000;
    private static final long AFTERONEHOUR = 500;
    private static final long AFTERONEDAY = 15000;

    @Override
    public long settlement(Car car) {
        long timeStamp = 0;
        long fee = 0;
        long remainMoney = 0;

//        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.of(2022, 4, 11, 21, 0, 0, 0);

        if ((SubtractionMinutesAboutInAndOut(car, time)) < 60) {
            car.settlementMoney(UNDERONEHOUR);
            fee = UNDERONEHOUR;
        }
        if (SubtractionDaysAboutInAndOut(car, time) >= 24) {
            long days = SubtractionDaysAboutInAndOut(car, time) / 24;
            fee = AFTERONEDAY * days;
            timeStamp = SubtractionMinutesAboutInAndOut(car, time) - days * 24 * 60;
            fee += AfterDayAndGetOverEveryTenMinutes(timeStamp);
        } else {
            fee = getOverOneHour(car, time);
        }
        if (car.getCarType() == CarType.LIGHT) {
            fee /= 2;
        }
        remainMoney = car.settlementMoney(fee);
        return remainMoney;

    }

    private long AfterDayAndGetOverEveryTenMinutes(long timeStamp) {
        return 1000 +
            (((timeStamp - 60) / 10 + 1) * AFTERONEHOUR);
    }

    private long getOverOneHour(Car car, LocalDateTime time) {
        return 1000 +
            (((SubtractionMinutesAboutInAndOut(car, time) - 60) / 10 + 1) * AFTERONEHOUR);
    }

    public long SubtractionMinutesAboutInAndOut(Car car, LocalDateTime time) {
        return ChronoUnit.MINUTES.between(car.getTime(), time);
    }

    public long SubtractionDaysAboutInAndOut(Car car, LocalDateTime time) {
        return ChronoUnit.HOURS.between(car.getTime(), time);
    }


}

