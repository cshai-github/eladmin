package com.love.repository;

import com.love.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName EmailRepository
 * @Description
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
 */
public interface EmailRepository extends JpaRepository<EmailConfig, Long> {
}
