package com.love.utils;

/**
 * @ClassName CallBack
 * @description 针对某些初始化方法，在SpringContextHolder 初始化前时，提交一个提交回调任务。
 * 在SpringContextHolder 初始化后，进行回调使用
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface CallBack {

    /**
     * 回调执行方法
     */
    void executor();

    /**
     * 本回调任务名称
     * @return /
     */
    default String getCallBackName() {
        return Thread.currentThread().getId() + ":" + this.getClass().getName();
    }
}
