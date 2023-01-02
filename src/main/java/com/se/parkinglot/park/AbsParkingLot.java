package com.se.parkinglot.park;

/**
 * @author songwenbin
 * @date 2023/1/1
 * 停车场抽象类
 */
public abstract class AbsParkingLot implements ItfParkingLot{
    //停车场名字
    private String name;
    //停车场总容量
    private int capacity;
    //已经停了多少车
    private int stoppedCarCount;

    public AbsParkingLot(String name,int capacity){
        this.capacity= capacity;
        this.name=name;
    }

    @Override
    public boolean inputCar(Car car) {
        if (capacity > stoppedCarCount){
            stoppedCarCount = stoppedCarCount +1;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean outCar(Car car) {
        if (stoppedCarCount>0){
            stoppedCarCount = stoppedCarCount -1;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isNotFull() {
        return capacity > stoppedCarCount;
    }

    @Override
    public int getFreeSpaceCount() {
        return capacity-stoppedCarCount;
    }

    @Override
    public String getName() {
        return name;
    }
}
