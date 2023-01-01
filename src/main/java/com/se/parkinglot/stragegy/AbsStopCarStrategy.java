package com.se.parkinglot.stragegy;

import com.se.parkinglot.manager.ItfParkingLotManager;
/**
 * @author songwenbin
 * @date 2023/1/1
 */
public abstract class AbsStopCarStrategy implements IStopCarStrategy {
    private ItfParkingLotManager parkingLotManager;
    public AbsStopCarStrategy(){
    }

    public ItfParkingLotManager getParkingLotManager() {
        return parkingLotManager;
    }

    public void setParkingLotManager(ItfParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }
}
