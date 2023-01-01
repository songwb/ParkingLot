package com.se.parkinglot.stragegy;

import com.se.parkinglot.manager.ItfParkingLotManager;
import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;

import java.util.Optional;

/**
 * @author songwenbin
 * @date 2023/1/1
 */
public interface ItfStopCarStrategy {

    Optional<ItfParkingLot> dispatch();

    void setParkingLotManager(ItfParkingLotManager parkingLotManager);
}
