package com.love.config.thread;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AsyncTaskProperties
 * @Description 线程池配置属性类(https://juejin.cn/post/6844903584857849870)
 * @Author ocean
 * @CreateDate 2021/3/5
 * @Version 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "task.pool")
public class AsyncTaskProperties {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;
}
