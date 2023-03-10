package com.se.parkinglot.manager;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;
import com.se.parkinglot.stragegy.ItfStopCarStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author songwenbin
 * @date 2023/1/1
 */
public abstract class AbsParkingLotManager implements ItfParkingLotManager{
    //管理的停车场列表
    private List<ItfParkingLot> managedParkingLots;
    private ItfStopCarStrategy stopCarStrategy;

    public AbsParkingLotManager(List<ItfParkingLot> managedParkingLots, ItfStopCarStrategy stopCarStrategy){
        this.managedParkingLots = managedParkingLots;
        this.stopCarStrategy = stopCarStrategy;
    }

    /**
     * @return 返回未停满的停车场Map
     */
    public Map<Integer, List<ItfParkingLot>> getManagedParkingLotsByFreeSpaces() {
        return managedParkingLots.stream().filter(ItfParkingLot::isNotFull).collect(Collectors.groupingBy(ItfParkingLot::getFreeSpaceCount));
    }

    public List<ItfParkingLot> getManagedParkingLots() {
        return managedParkingLots;
    }

    @Override
    public void leave(Car car) {
        for (ItfParkingLot parkingLot : managedParkingLots){
            if (parkingLot.isNotFull()){
                parkingLot.outCar(car);
            }
        }
    }

    @Override
    public boolean stop(Car car) {
        stopBefore(car);
        Optional<ItfParkingLot> parkingLotOptional = stopCarStrategy.dispatch();
        if (parkingLotOptional.isPresent()){
            ItfParkingLot parkingLot = parkingLotOptional.get();
            parkingLot.inputCar(car);
        }
        return stopAfter(car,parkingLotOptional);
    }

    protected abstract void stopBefore(Car car);

    protected abstract boolean stopAfter(Car car,Optional<ItfParkingLot> parkingLotOptional);

}
