package com.love.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.love.exception.BadRequestException;
import com.love.utils.enums.DataScopeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @ClassName SecurityUtils
 * @description 获取当前登录的用户
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
@Slf4j
public class SecurityUtils {

    /**
     * @describe 获取当前登录的用户
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    public static UserDetails getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "当前登录状态过期");
        }
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserDetailsService userDetailsService = SpringContextHolder.getBean(UserDetailsService.class);
            return userDetailsService.loadUserByUsername(userDetails.getUsername());
        }
        throw new BadRequestException(HttpStatus.UNAUTHORIZED, "找不到当前登录的信息");
    }

    /**
     * @describe 获取系统用户名称
     * @return java.lang.String 系统用户名称
     */
    public static String getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "当前登录状态过期");
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    /**
     * @describe 获取系统用户ID
     * @return java.lang.Long
     */
    public static Long getCurrentUserId() {
        UserDetails currentUser = getCurrentUser();
        return new JSONObject(new JSONObject(currentUser).get("user")).get("id", Long.class);
    }

    /**
     * @describe 获取当前用户的数据权限
     * @return java.util.List<java.lang.Long>
     */
    public static List<Long> getCurrentUserDataScope() {
        UserDetails currentUser = getCurrentUser();
        JSONArray dataScopes = JSONUtil.parseArray(new JSONObject(currentUser).get("dataScopes"));
        return JSONUtil.toList(dataScopes, Long.class);
    }

    /**
     * @describe 获取数据权限级别
     * @return java.lang.String
     */
    public static String getDataScopeType() {
        List<Long> currentUserDataScope = getCurrentUserDataScope();
        if (currentUserDataScope.size() != 0) {
            return "";
        }
        return DataScopeEnum.ALL.getValue();
    }
}
