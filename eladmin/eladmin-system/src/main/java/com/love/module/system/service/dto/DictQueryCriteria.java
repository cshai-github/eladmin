package com.love.module.system.service.dto;

import com.love.annotation.Query;
import lombok.Data;

/**
 * @ClassName DictQueryCriteria
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;
}
