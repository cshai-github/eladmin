package com.love.module.security.service;

import com.love.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserCacheClean
 * @Description 用于清理 用户登录信息缓存，为防止Spring循环依赖与安全考虑 ，单独构成工具类
 * @Author ocean
 * @CreateDate 2020/11/10
 * @Version 1.0.0
 */
@Component
public class UserCacheClean {

    /**
     * @description 清理特定用户缓存信息
     * ,用户信息变更时
     * @param username /
     */
    public void cleanUserCache(String username) {
        if (StringUtils.isNotEmpty(username)) {
            UserDetailsServiceImpl.userDtoCache.remove(username);
        }
    }

    /**
     * @description 清理所有用户的缓存信息
     * ,如发生角色授权信息变化，可以简便的全部失效缓存
     */
    public void cleanAll() {
        UserDetailsServiceImpl.userDtoCache.clear();
    }
}
