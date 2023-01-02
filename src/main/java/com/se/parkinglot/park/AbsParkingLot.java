package com.se.parkinglot.park;

/**
 * @author songwenbin
 * @date 2023/1/1
 * 停车场抽象类
 */
public abstract class AbsParkingLot implements ItfParkingLot{
    //停车场名字
    private final String name;
    //停车场总容量
    private final int capacity;
    //已经停了多少车
    private int stoppedCarCount;

    public AbsParkingLot(String name,int capacity){
        this.capacity= capacity;
        this.name=name;
    }

    @Override
    public synchronized boolean inputCar(Car car) {
        if (capacity > stoppedCarCount){
            stoppedCarCount = stoppedCarCount +1;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public synchronized boolean outCar(Car car) {
        if (stoppedCarCount>0){
            stoppedCarCount = stoppedCarCount -1;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public synchronized boolean isNotFull() {
        return capacity > stoppedCarCount;
    }

    @Override
    public synchronized int getFreeSpaceCount() {
        return capacity-stoppedCarCount;
    }

    @Override
    public String getName() {
        return name;
    }
}
