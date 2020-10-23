package com.love.module.system.service;

import com.love.module.system.domain.Job;
import com.love.module.system.service.dto.JobDto;
import com.love.module.system.service.dto.JobQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JobService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface JobService {

    /**
     * @describe 根据ID查询
     * @param id /
     * @return com.love.module.system.service.dto.JobDto
     */
    JobDto findById(Long id);

    /**
     * @describe 创建
     * @param resources /
     * @return void
     */
    void create(Job resources);

    /**
     * @describe 编辑
     * @param resources /
     */
    void update(Job resources);

    /**
     * @describe 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * @describe 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(JobQueryCriteria criteria, Pageable pageable);

    /**
     * @describe 查询全部数据
     * @param criteria /
     * @return /
     */
    List<JobDto> queryAll(JobQueryCriteria criteria);

    /**
     * @describe 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<JobDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * @describe 验证是否被用户关联
     * @param ids /
     */
    void verification(Set<Long> ids);
}
