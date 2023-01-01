package com.se.parkinglot.stragegy;

import com.se.parkinglot.manager.ItfParkingLotManager;
import com.se.parkinglot.park.Car;

public interface IStopCarStrategy {

    void dispatch(Car car);

    void setParkingLotManager(ItfParkingLotManager parkingLotManager);
}
