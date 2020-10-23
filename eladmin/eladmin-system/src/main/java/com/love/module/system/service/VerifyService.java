package com.love.module.system.service;

import com.love.domain.vo.EmailVo;

/**
 * @ClassName VerifyService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface VerifyService {

    /**
     * @describe 发送验证码
     * @param email /
	 * @param key /
     * @return EmailVo
     */
    EmailVo sendEmail(String email, String key);


    /**
     * @describe 验证
     * @param code /
     * @param key /
     */
    void validated(String key, String code);
}
