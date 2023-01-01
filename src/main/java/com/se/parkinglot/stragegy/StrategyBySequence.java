package com.se.parkinglot.stragegy;

import com.se.parkinglot.park.ItfParkingLot;

import java.util.List;
import java.util.Optional;

/**
 * @author songwenbin
 * @date 2023/1/1
 * 先停满一个停车场，再停到另一个停车场
 */
public class StrategyBySequence extends AbsStopCarStrategy {

    public StrategyBySequence() {
    }

    @Override
    public Optional<ItfParkingLot> dispatch() {
        List<ItfParkingLot> managedParkingLotList = super.getParkingLotManager().getManagedParkingLots();
        for (ItfParkingLot parkingLot : managedParkingLotList){
            if (parkingLot.isNotFull()){
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }

}
