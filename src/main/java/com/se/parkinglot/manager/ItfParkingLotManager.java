package com.se.parkinglot.manager;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;

import java.util.List;
import java.util.Map;

/**
 * 停车场管理员
 */
public interface ItfParkingLotManager {

    void stop(Car car);

    void leave(Car car);

    Map<Integer, List<ItfParkingLot>> getManagedParkingLotsByFreeSpaces();

    List<ItfParkingLot> getManagedParkingLots();
}
