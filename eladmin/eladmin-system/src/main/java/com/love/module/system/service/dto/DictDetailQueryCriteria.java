package com.love.module.system.service.dto;

import com.love.annotation.Query;
import lombok.Data;

/**
 * @ClassName DictDetailQueryCriteria
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name", joinName = "dict")
    private String dictName;
}
