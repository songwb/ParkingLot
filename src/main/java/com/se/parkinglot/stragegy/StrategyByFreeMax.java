package com.se.parkinglot.stragegy;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.ItfParkingLot;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author songwenbin
 * @date 2023/1/1
 * 把车停到空位最多的停车场
 */
public class StrategyByFreeMax extends AbsStopCarStrategy {

    public StrategyByFreeMax() {
    }

    @Override
    public void dispatch(Car car) {
        Map<Integer, List<ItfParkingLot>> managedParkingLotMap = super.getParkingLotManager().getManagedParkingLotsByFreeSpaces();
        Optional<Integer> freeSpacesOptional = managedParkingLotMap.keySet().stream().max(Integer::compareTo);
        if (freeSpacesOptional.isPresent()) {
            List<ItfParkingLot> parkingLotList = managedParkingLotMap.get(freeSpacesOptional.get());
            if (CollectionUtils.isEmpty(parkingLotList)) {
                return;
            }
            parkingLotList.get(0).inputCar(car);
        }
    }
}
