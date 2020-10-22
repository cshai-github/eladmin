package com.love.base;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * @ClassName BaseDTO
 * @description Data Transfer Object
 * @author ocean
 * @createDate 2020/10/22
 * @version 1.0.0
 */
@Getter
@Setter
public class BaseDTO implements Serializable {

    private String createBy;

    private String updatedBy;

    private Timestamp createTime;

    private Timestamp updateTime;

    @Override
    public String toString() {
        /*系统中一般都要打印日志的，因为所有实体的toString()方
         都用的是简单的"+"，因为每"＋" 一个就会 new 一个 String 对象，
         这样如果系统内存小的话会暴内存（前提系统实体比较多）。
         使用ToStringBuilder就可以避免暴内存这种问题的。*/
        ToStringBuilder builder = new ToStringBuilder(this);

        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                //f.get(this): 取得当前对象的f属性的值。
                builder.append(f.getName(), f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
