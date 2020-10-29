package com.love.module.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName MenuVo
 * @description 构建前端路由时用到
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Data
// null、集合数组等没有内容、空字符串等，都不会被序列化
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVo implements Serializable {

    private String name;

    private String path;

    private Boolean hidden;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo meta;

    private List<MenuVo> children;
}
