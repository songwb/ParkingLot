package com.se.parkinglot.manager;

import com.se.parkinglot.park.Car;
import com.se.parkinglot.park.DefaultParkingLotImpl;
import com.se.parkinglot.park.ItfParkingLot;
import com.se.parkinglot.stragegy.StopCarStrategyType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songwenbin
 * @date 2023/1/1 21:18.00
 */
public class ParkingLotManagerTest {
    List<ItfParkingLot> managedParkingLotList;

    @Before
    public void prepareData(){
        managedParkingLotList= new ArrayList<>();
        ItfParkingLot parkingLotA= new DefaultParkingLotImpl("停车场A",2);
        ItfParkingLot parkingLotB= new DefaultParkingLotImpl("停车场B",10);
        managedParkingLotList.add(parkingLotA);
        managedParkingLotList.add(parkingLotB);
    }

    @Test
    public void testSequenceManager(){
        ItfParkingLot parkingLotA = managedParkingLotList.get(0);
        ItfParkingLot parkingLotB = managedParkingLotList.get(1);

        ItfParkingLotManager parkingLotManager = ParkingLotManagerBuilder
                .newInstance()
                .withStopCarStragety(StopCarStrategyType.SEQUENCE)
                .withManagedParkingLots(managedParkingLotList)
                .build();
        for (int i = 1;i<=2;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==0);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==10);

        for (int i = 3;i<=12;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==0);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==0);

        Car car = new Car(13);
        Assert.assertFalse(parkingLotManager.stop(car));
    }

    @Test
    public void testFreeMaxManager(){
        ItfParkingLot parkingLotA = managedParkingLotList.get(0);
        ItfParkingLot parkingLotB = managedParkingLotList.get(1);

        ItfParkingLotManager parkingLotManager = ParkingLotManagerBuilder
                .newInstance()
                .withStopCarStragety(StopCarStrategyType.FREE_MAX)
                .withManagedParkingLots(managedParkingLotList)
                .build();
        for (int i = 1;i<=2;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==2);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==8);

        for (int i = 3;i<=12;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==0);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==0);

        Car car = new Car(13);
        Assert.assertFalse(parkingLotManager.stop(car));
    }

    @Test
    public void testFreeMinManager(){
        ItfParkingLot parkingLotA = managedParkingLotList.get(0);
        ItfParkingLot parkingLotB = managedParkingLotList.get(1);

        ItfParkingLotManager parkingLotManager = ParkingLotManagerBuilder
                .newInstance()
                .withStopCarStragety(StopCarStrategyType.FREE_MIN)
                .withManagedParkingLots(managedParkingLotList)
                .build();
        for (int i = 1;i<=2;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==0);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==10);

        for (int i = 3;i<=12;i++){
            Car car = new Car(i);
            Assert.assertTrue(parkingLotManager.stop(car));
        }
        Assert.assertTrue(parkingLotA.getFreeSpaceCount()==0);
        Assert.assertTrue(parkingLotB.getFreeSpaceCount()==0);

        Car car = new Car(13);
        Assert.assertFalse(parkingLotManager.stop(car));
    }
}
