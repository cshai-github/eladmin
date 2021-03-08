package com.love.module.security.config;

import com.love.module.security.config.bean.LoginProperties;
import com.love.module.security.config.bean.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConfigBeanConfiguration
 * @Description 配置文件转换Pojo类的 统一配置 类
 * @Author ocean
 * @CreateDate 2021/3/5
 * @Version 1.0.0
 */
@Configuration
public class ConfigBeanConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "login", ignoreUnknownFields = true)
    public LoginProperties loginProperties() {
        return new LoginProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt",ignoreUnknownFields = true)
    public SecurityProperties securityProperties() {
        return new SecurityProperties();
    }
}
