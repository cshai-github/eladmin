package com.love.module.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName RoleSmallDto
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
public class RoleSmallDto implements Serializable {
    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
