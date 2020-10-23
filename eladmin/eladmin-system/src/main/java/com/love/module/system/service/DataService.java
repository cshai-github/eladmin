package com.love.module.system.service;

import com.love.module.system.service.dto.UserDto;

import java.util.List;

/**
 * @ClassName DataService
 * @description 数据权限服务类
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DataService {

    /**
     * @describe 获取数据权限
     * @param user
     * @return java.util.List<java.lang.Long>
     */
    List<Long> getDeptIds(UserDto user);
}
