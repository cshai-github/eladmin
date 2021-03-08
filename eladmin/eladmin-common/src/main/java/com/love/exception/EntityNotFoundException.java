package com.love.exception;

import org.springframework.util.StringUtils;

/**
 * @ClassName EntityNotFoundException
 * @Description
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
 */
public class EntityNotFoundException extends RuntimeException  {
    public EntityNotFoundException(Class clazz, String field, String val) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), field, val));
    }

    private static String generateMessage(String entity, String field, String val) {
        return StringUtils.capitalize(entity)
                + " with " + field + " "+ val + " does not exist";
    }
}
