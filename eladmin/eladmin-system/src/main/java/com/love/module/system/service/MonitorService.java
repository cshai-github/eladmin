package com.love.module.system.service;

import java.util.Map;

/**
 * @ClassName MonitorService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface MonitorService {

    /**
     * @describe 查询数据分页
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getServers();
}
