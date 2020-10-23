package com.love.module.system.service;

import com.love.module.system.domain.DictDetail;
import com.love.module.system.service.dto.DictDetailDto;
import com.love.module.system.service.dto.DictDetailQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DictDetailService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DictDetailService {

    /**
     * @describe 创建
     * @param resources /
     * @return void
     */
    void create(DictDetail resources);

    /**
     * @describe 编辑
     * @param resources /
     */
    void update(DictDetail resources);

    /**
     * @describe 删除
     * @param id /
     */
    void delete(Long id);

    /**
     * @describe 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(DictDetailQueryCriteria criteria, Pageable pageable);

    /**
     * @describe 根据字典名称获取字典详情
     * @param name 字典名称
     * @return /
     */
    List<DictDetailDto> getDictByName(String name);
}
