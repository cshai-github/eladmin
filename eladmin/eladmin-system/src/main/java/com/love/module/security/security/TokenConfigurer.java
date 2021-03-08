package com.love.module.security.security;

import com.love.module.security.config.bean.SecurityProperties;
import com.love.module.security.service.OnlineUserService;
import com.love.module.security.service.UserCacheClean;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassName TokenConfigurer
 * @Description
 * @Author ocean
 * @CreateDate 2021/3/8
 * @Version 1.0.0
 */
@RequiredArgsConstructor
public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;
    private final UserCacheClean userCacheClean;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        TokenFilter tokenFilter = new TokenFilter(tokenProvider, properties, onlineUserService, userCacheClean);
        builder.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
