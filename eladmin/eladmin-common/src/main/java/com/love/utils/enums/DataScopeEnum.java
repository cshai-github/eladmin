package com.love.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName DataScopeEnum
 * @description 数据权限枚举
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DataScopeEnum {

    ALL("全部", "全部的数据权限"),
    THIS_LEVEL("本级", "自己部门的数据权限"),
    CUSTOMIZE("自定义", "自定义的数据权限");

    private final String value;
    private final String description;

    public static DataScopeEnum find(String val) {
        for (DataScopeEnum dataScopeEnum : DataScopeEnum.values()) {
            if (val.equals(dataScopeEnum.getValue())) {
                return dataScopeEnum;
            }
        }
        return null;
    }
}
