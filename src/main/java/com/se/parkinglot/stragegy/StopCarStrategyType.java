package com.se.parkinglot.stragegy;
/**
 * @author songwenbin
 * @date 2023/1/1
 * 停车策略类型
 */
public enum StopCarStrategyType {
    SEQUENCE,//先停满一个停车场，再停到另一个停车场
    FREE_MAX,//把车停到空位最多的停车场
    FREE_MIN//把车停到空位最少的停车场
}
