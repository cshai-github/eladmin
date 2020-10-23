package com.love.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * @ClassName BaseEntity
 * @description 通用字段， is_del 根据需求自行添加
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
//基于代码复用和模型分离的思想，在项目开发中使用JPA的@MappedSuperclass注解将实体类的多个属性分别封装到不同的非实体类中
@MappedSuperclass
//对实体属性变化的跟踪，它提供了保存前，保存后，更新前，更新后，删除前，删除后等状态，就像是拦截器一样，你可以在拦截方法里重写你的个性化逻辑。
@EntityListeners(AuditingEntityListener.class)//
public class BaseEntity implements Serializable {

    @CreatedBy
    @Column(name = "create_by", updatable = false)
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createBy;

    @LastModifiedBy
    @Column(name = "update_by")
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updateTime;

    /* 分组校验 */
    public @interface Create {
    }

    /* 分组校验 */
    public @interface Update {
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName(), f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
