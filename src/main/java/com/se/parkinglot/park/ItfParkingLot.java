package com.se.parkinglot.park;

/**
 * @author songwenbin
 * @date 2023/1/1
 * 停车场接口
 */
public interface ItfParkingLot {
    /**
     * 进车
     * @param car 车
     * @return
     */
    boolean inputCar(Car car);

    /**
     * 出车
     * @param car 车
     * @return
     */
    boolean outCar(Car car);

    /**
     * 停车场没有满
     * @return true：没有停满，false：停满
     */
    boolean isNotFull();

    /**
     * @return 返回空闲的停车位数量
     */
    int getFreeSpaceCount();

    /**
     *
     * @return 停车场名称
     */
    String getName();
}
