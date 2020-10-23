package com.love.module.system.service.dto;

import com.love.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName DictDetailDto
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Getter
@Setter
public class DictDetailDto extends BaseDTO implements Serializable {

    private Long id;

    private DictSmallDto dict;

    private String label;

    private String value;

    private Integer dictSort;
}
