package com.se.parkinglot.manager;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;
import com.se.parkinglot.stragegy.ItfStopCarStrategy;

import java.util.List;
import java.util.Optional;

/**
 * @author songwenbin
 * @date 2023/1/1 21:58.37
 */
public class DefaultParkingLotManager extends AbsParkingLotManager{

    public DefaultParkingLotManager(List<ItfParkingLot> managedParkingLots, ItfStopCarStrategy stopCarStrategy) {
        super(managedParkingLots, stopCarStrategy);
    }

    @Override
    protected void stopBefore(Car car) {
        System.out.println(car.getName()+"准备停车");
    }

    @Override
    protected boolean stopAfter(Car car, Optional<ItfParkingLot> parkingLotOptional) {
        if (parkingLotOptional.isPresent()){
            System.out.println(car.getName()+"进入"+parkingLotOptional.get().getName());
            return true;
        }else{
            System.out.println(car.getName()+"停车失败，停车场都没有空位");
            return false;
        }
    }
}
