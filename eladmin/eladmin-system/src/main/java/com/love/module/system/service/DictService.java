package com.love.module.system.service;

import com.love.module.system.domain.Dict;
import com.love.module.system.service.dto.DictDto;
import com.love.module.system.service.dto.DictQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName DictService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DictService {

    /**
     * @describe 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(DictQueryCriteria criteria, Pageable pageable);

    /**
     * @describe 查询全部数据
     * @param dict /
     * @return /
     */
    List<DictDto> queryAll(DictQueryCriteria dict);

    /**
     * @describe 创建
     * @param resources /
     * @return /
     */
    void create(Dict resources);

    /**
     * @describe 编辑
     * @param resources /
     */
    void update(Dict resources);

    /**
     * @describe 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * @describe 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<DictDto> queryAll, HttpServletResponse response) throws IOException;
}
