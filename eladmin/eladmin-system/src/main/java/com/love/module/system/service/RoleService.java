package com.love.module.system.service;

import com.love.module.system.domain.Role;
import com.love.module.system.service.dto.RoleDto;
import com.love.module.system.service.dto.RoleQueryCriteria;
import com.love.module.system.service.dto.RoleSmallDto;
import com.love.module.system.service.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface RoleService {

    /**
     * @describe 查询全部数据
     * @return java.util.List<com.love.module.system.service.dto.RoleDto>
     */
    List<RoleDto> queryAll();

    /**
     * @describe 根据ID查询
     * @param id /
     * @return com.love.module.system.service.dto.RoleDto
     */
    RoleDto findById(long id);

    /**
     * @describe 创建
     * @param resources /
     * @return void
     */
    void create(Role resources);

    /**
     * @describe 编辑
     * @param resources /
     * @return void
     */
    void update(Role resources);

    /**
     * @describe 删除
     * @param ids /
     * @return void
     */
    void delete(Set<Long> ids);

    /**
     * @describe 根据用户ID查询
     * @param id 用户ID
     * @return java.util.List<com.love.module.system.service.dto.RoleSmallDto>
     */
    List<RoleSmallDto> findByUsersId(Long id);

    /**
     * @describe 根据角色查询角色级别
     * @param roles /
     * @return java.lang.Integer
     */
    Integer findByRoles(Set<Role> roles);

    /**
     * @describe 修改绑定的菜单
     * @param resources /
     * @param roleDTO /
     * @return void
     */
    void updateMenu(Role resources, RoleDto roleDTO);

    /**
     * @describe 解绑菜单
     * @param id /
     * @return void
     */
    void untiedMenu(Long id);

    /**
     * 待条件分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    /**
     * @describe 带条件分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return java.lang.Object
     */
    Object queryAll(RoleQueryCriteria criteria, Pageable pageable);

    /**
     * @describe 查询全部
     * @param criteria 条件
     * @return java.util.List<com.love.module.system.service.dto.RoleDto>
     */
    List<RoleDto> queryAll(RoleQueryCriteria criteria);

    /**
     * @describe 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @return void
     */
    void download(List<RoleDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * @describe 获取用户权限信息
     * @param user 用户信息
     * @return java.util.List<org.springframework.security.core.GrantedAuthority>
     */
    List<GrantedAuthority> mapToGrantedAuthorities(UserDto user);

    /**
     * @describe 验证是否被用户关联
     * @param ids /
     * @return void
     */
    void verification(Set<Long> ids);

    /**
     * @describe 根据菜单Id查询
     * @param menuIds /
     * @return java.util.List<com.love.module.system.domain.Role>
     */
    List<Role> findInMenuId(List<Long> menuIds);
}
