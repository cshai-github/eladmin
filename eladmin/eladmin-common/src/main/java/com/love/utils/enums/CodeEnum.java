package com.love.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName CodeEnum
 * @Description 验证码业务场景对应的 Redis 中的 key
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {
    /* 通过手机号码重置邮箱 */
    PHONE_RESET_EMAIL_CODE("phone_reset_email_code_", "通过手机号码重置邮箱"),

    /* 通过旧邮箱重置邮箱 */
    EMAIL_RESET_EMAIL_CODE("email_reset_email_code_", "通过旧邮箱重置邮箱"),

    /* 通过手机号码重置密码 */
    PHONE_RESET_PWD_CODE("phone_reset_pwd_code_", "通过手机号码重置密码"),

    /* 通过邮箱重置密码 */
    EMAIL_RESET_PWD_CODE("email_reset_pwd_code_", "通过邮箱重置密码");

    private final String key;
    private final String description;
}
