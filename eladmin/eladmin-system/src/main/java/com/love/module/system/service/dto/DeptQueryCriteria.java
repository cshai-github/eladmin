package com.love.module.system.service.dto;

import com.love.annotation.DataPermission;
import com.love.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName DeptQueryCriteria
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
@DataPermission(fieldName = "id")
public class DeptQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query
    private Long pid;

    @Query(type = Query.Type.IS_NULL, propName = "pid")
    private Boolean pidIsNull;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
