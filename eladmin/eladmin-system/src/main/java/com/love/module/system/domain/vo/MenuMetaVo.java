package com.love.module.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName MenuMetaVo
 * @description
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class MenuMetaVo implements Serializable {

    private String title;

    private String icon;

    private Boolean noCache;
}
