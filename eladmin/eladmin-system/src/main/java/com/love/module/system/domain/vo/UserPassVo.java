package com.love.module.system.domain.vo;

import lombok.Data;

/**
 * @ClassName UserPassVo
 * @description 修改密码的 Vo 类
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Data
public class UserPassVo {
    private String oldPass;

    private String newPass;
}
