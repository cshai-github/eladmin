package com.love.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName CodeBiEnum
 * @Description 验证码业务场景
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CodeBiEnum {
    /* 旧邮箱修改邮箱 */
    ONE(1, "旧邮箱修改邮箱"),

    /* 通过邮箱修改密码 */
    TWO(2, "通过邮箱修改密码");
    private final Integer code;
    private final String description;

    public static CodeBiEnum find(Integer code) {
        for (CodeBiEnum value : CodeBiEnum.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        return null;
    }
}
