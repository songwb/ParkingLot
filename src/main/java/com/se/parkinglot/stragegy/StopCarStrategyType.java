package com.se.parkinglot.stragegy;
/**
 * @author songwenbin
 * @date 2023/1/1
 */
public enum StopCarStrategyType {
    SEQUENCE,//先停满一个停车场，再停到另一个停车场
    FREE_MAX,
    FREE_MIN
}
