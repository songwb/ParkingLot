package com.se.parkinglot.stragegy;

import com.se.parkinglot.manager.ItfParkingLotManager;
import com.se.parkinglot.park.Car;
/**
 * @author songwenbin
 * @date 2023/1/1
 */
public interface ItfStopCarStrategy {

    void dispatch(Car car);

    void setParkingLotManager(ItfParkingLotManager parkingLotManager);
}
