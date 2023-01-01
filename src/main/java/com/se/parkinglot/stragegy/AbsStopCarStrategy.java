package com.se.parkinglot.stragegy;

import com.se.parkinglot.manager.ItfParkingLotManager;

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
