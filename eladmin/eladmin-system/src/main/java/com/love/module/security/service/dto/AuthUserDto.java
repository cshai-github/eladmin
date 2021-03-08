package com.love.module.security.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName AuthUserDto
 * @Description
 * @Author ocean
 * @CreateDate 2021/3/8
 * @Version 1.0.0
 */
@Getter
@Setter
public class AuthUserDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
}
