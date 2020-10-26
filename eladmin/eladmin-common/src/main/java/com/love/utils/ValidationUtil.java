package com.love.utils;

import cn.hutool.core.util.ObjectUtil;
import com.love.exception.BadRequestException;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

/**
 * @ClassName ValidationUtil
 * @description 验证工具
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
public class ValidationUtil {

    /**
     * @describe 验证空
     * @param obj /
     * @param entity /
     * @param parameter /
     * @param value /
     * @return void
     */
    public static void isNull(Object obj, String entity, String parameter, Object value) {
        if (ObjectUtil.isNull(obj)) {
            String msg = entity + " 不存在: " + parameter + " is " + value;
            throw new BadRequestException(msg);
        }
    }

    /**
     * @describe 验证是否为邮箱
     * @param email 邮箱
     * @return boolean
     */
    public static boolean isEmail(String email) {
        return new EmailValidator().isValid(email, null);
    }
}
