package com.se.parkinglot.manager;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;

import java.util.List;
import java.util.Map;

/**
 * @author songwenbin
 * @date 2023/1/1
 */
public interface ItfParkingLotManager {

    void stop(Car car);

    void leave(Car car);

    Map<Integer, List<ItfParkingLot>> getManagedParkingLotsByFreeSpaces();

    List<ItfParkingLot> getManagedParkingLots();
}
