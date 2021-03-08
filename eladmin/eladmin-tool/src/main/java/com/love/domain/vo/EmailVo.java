package com.love.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName EmailVo
 * @Description 发送邮件时，接收参数的类
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
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
