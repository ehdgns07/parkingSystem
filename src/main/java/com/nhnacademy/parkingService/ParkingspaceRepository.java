package com.nhnacademy.parkingService;

import java.util.Map;

public interface ParkingspaceRepository {

    Car scan(Car car);

    Car parking(Car car);

    }
