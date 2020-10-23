package com.love.module.system.repository;

import com.love.module.system.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
 * @ClassName JobRepository
 * @description 工作存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    /**
     * @describe 根据名称查询
     * @param name 名称
     * @return com.love.module.system.domain.Job
     */
    Job findByName(String name);

    /**
     * @describe 根据Id删除
     * @param ids /
     * @return void
     */
    void deleteAllByIdIn(Set<Long> ids);
}
