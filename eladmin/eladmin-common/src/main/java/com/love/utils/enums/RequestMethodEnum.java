package com.love.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName RequestMethodEnum
 * @Description /
 * @website https://el-admin.vip
 * @Author ocean
 * @CreateDate 2021/3/8
 * @Version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum RequestMethodEnum {
    /**
     * 搜寻 @AnonymousGetMapping
     */
    GET("GET"),

    /**
     * 搜寻 @AnonymousPostMapping
     */
    POST("POST"),

    /**
     * 搜寻 @AnonymousPutMapping
     */
    PUT("PUT"),

    /**
     * 搜寻 @AnonymousPatchMapping
     */
    PATCH("PATCH"),

    /**
     * 搜寻 @AnonymousDeleteMapping
     */
    DELETE("DELETE"),

    /**
     * 否则就是所有 Request 接口都放行
     */
    ALL("All");

    /**
     * Request 类型
     */
    private final String type;

    public static RequestMethodEnum find(String type) {
        for (RequestMethodEnum value : RequestMethodEnum.values()) {
            if (type.equals(value.getType())) {
                return value;
            }
        }
        return ALL;
    }
}
