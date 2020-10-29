package com.love.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName EntityExistException
 * @description
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
public class EntityExistException extends RuntimeException {

    public EntityExistException(Class clazz, String field, String val) {
        super(EntityExistException.generateMessage(clazz.getSimpleName(), field, val));
    }

    private static String generateMessage(String simpleName, String field, String val) {
        return StringUtils.capitalize(simpleName) + " with " + field + " " + val + " existed";
    }
}
