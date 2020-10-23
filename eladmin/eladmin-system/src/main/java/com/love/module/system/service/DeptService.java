package com.love.module.system.service;

import com.love.module.system.domain.Dept;
import com.love.module.system.service.dto.DeptDto;
import com.love.module.system.service.dto.DeptQueryCriteria;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @ClassName DeptService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DeptService {

    /**
     * @describe 查询所有数据
     * @param criteria 条件
	 * @param isQuery /
     * @return java.util.List<DeptDto>
     */
    List<DeptDto> queryAll(DeptQueryCriteria criteria, Boolean isQuery) throws Exception;

    /**
     * @describe 根据ID查询
     * @param id /
     * @return /
     */
    DeptDto findById(Long id);

    /**
     * @describe 创建
     * @param resources /
     */
    void create(Dept resources);

    /**
     * @describe 编辑
     * @param resources /
     */
    void update(Dept resources);

    /**
     * @describe 删除
     * @param deptDtos /
     *
     */
    void delete(Set<DeptDto> deptDtos);

    /**
     * @describe 根据PID查询
     * @param pid /
     * @return /
     */
    List<Dept> findByPid(long pid);

    /**
     * @describe 根据角色ID查询
     * @param id /
     * @return /
     */
    Set<Dept> findByRoleId(Long id);

    /**
     * @describe 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<DeptDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * @describe 获取待删除的部门
     * @param deptList /
     * @param deptDtos /
     * @return /
     */
    Set<DeptDto> getDeleteDepts(List<Dept> deptList, Set<DeptDto> deptDtos);

    /**
     * @describe 根据ID获取同级与上级数据
     * @param deptDto /
     * @param depts /
     * @return /
     */
    List<DeptDto> getSuperior(DeptDto deptDto, List<Dept> depts);

    /**
     * @describe 构建树形数据
     * @param deptDtos /
     * @return /
     */
    Object buildTree(List<DeptDto> deptDtos);

    /**
     * @describe 获取
     * @param deptId
     * @param deptList
     * @return
     */
    List<Long> getDeptChildren(Long deptId, List<Dept> deptList);

    /**
     * @describe 验证是否被角色或用户关联
     * @param deptDtos /
     */
    void verification(Set<DeptDto> deptDtos);
}
