package com.love.module.system.service.dto;

import com.love.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DictDto
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Getter
@Setter
public class DictDto extends BaseDTO implements Serializable {

    private Long id;

    private List<DictDetailDto> dictDetails;

    private String name;

    private String description;
}
