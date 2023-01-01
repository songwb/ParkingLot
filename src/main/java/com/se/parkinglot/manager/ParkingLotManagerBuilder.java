package com.se.parkinglot.manager;

import com.se.parkinglot.park.ItfParkingLot;
import com.se.parkinglot.stragegy.ItfStopCarStrategy;
import com.se.parkinglot.stragegy.StrategyByFreeMax;
import com.se.parkinglot.stragegy.StrategyByFreeMin;
import com.se.parkinglot.stragegy.StrategyBySequence;
import com.se.parkinglot.stragegy.StopCarStrategyType;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author songwenbin
 * @date 2023/1/1
 */
public final class ParkingLotManagerBuilder {

    List<ItfParkingLot> managedParkingLotList;

    ItfStopCarStrategy stopCarStragegy;

    public static ParkingLotManagerBuilder newInstance(){
        return new ParkingLotManagerBuilder();
    }

    public ParkingLotManagerBuilder withManagedParkingLots(List<ItfParkingLot> managedParkingLotList){
        this.managedParkingLotList = managedParkingLotList;
        return this;
    }

    public ParkingLotManagerBuilder withStopCarStragety(StopCarStrategyType stopCarStragety){
        if (stopCarStragety == StopCarStrategyType.FREE_MAX){
            this.stopCarStragegy = new StrategyByFreeMax();
        }else if (stopCarStragety == StopCarStrategyType.FREE_MIN){
            this.stopCarStragegy = new StrategyByFreeMin();
        }else if (stopCarStragety == StopCarStrategyType.SEQUENCE){
            this.stopCarStragegy = new StrategyBySequence();
        }else {
            throw new RuntimeException("not support stop car strategy type");
        }
        return this;
    }


    public ItfParkingLotManager build(){
        if (CollectionUtils.isEmpty(this.managedParkingLotList)){
            throw new RuntimeException("init parkingLotManager error. managedParkingLotList is null");
        }
        if (stopCarStragegy == null){
            throw new RuntimeException("init parkingLotManager error. stopCarStragegy is null");
        }
        ItfParkingLotManager parkingLotManager = new DefaultParkingLotManager(this.managedParkingLotList,this.stopCarStragegy);
        this.stopCarStragegy.setParkingLotManager(parkingLotManager);
        return parkingLotManager;
    }
}
