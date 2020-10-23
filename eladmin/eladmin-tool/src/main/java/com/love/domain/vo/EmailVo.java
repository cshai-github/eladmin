package com.love.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName EmailVo
 * @description 发送邮件时，接收参数的类
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailVo {
    /** 收件人，支持多个收件人 */
    @NotEmpty
    private List<String> tos;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
