package com.love.annotation;

import java.lang.annotation.*;

/**
 * @ClassName AnonymousAccess
 * @description 用于标记匿名访问方法
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Inherited
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {
}
