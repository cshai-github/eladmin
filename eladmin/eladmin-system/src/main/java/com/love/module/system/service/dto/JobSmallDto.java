package com.love.module.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName JobSmallDto
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
public class JobSmallDto implements Serializable {

    private Long id;

    private String name;
}
