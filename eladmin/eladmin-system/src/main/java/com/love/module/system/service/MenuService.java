package com.love.module.system.service;

import com.love.module.system.domain.Menu;
import com.love.module.system.service.dto.MenuDto;
import com.love.module.system.service.dto.MenuQueryCriteria;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MenuService
 * @description
 * @author
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface MenuService {

    /**
     * @describe 查询全部数据
     * @param criteria 条件
     * @param isQuery /
     * @return java.util.List<com.love.module.system.service.dto.MenuDto>
     */
    List<MenuDto> queryAll(MenuQueryCriteria criteria, Boolean isQuery) throws Exception;

    /**
     * @describe 根据ID查询
     * @param id /
     * @return com.love.module.system.service.dto.MenuDto
     */
    MenuDto findById(long id);

    /**
     * @describe 创建
     * @param resources /
     * @return void
     */
    void create(Menu resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Menu resources);

    /**
     * @describe 获取所有子节点, 包含自身ID
     * @param menuList /
     * @param menuSet  /
     * @return java.util.Set<com.love.module.system.domain.Menu>
     */
    Set<Menu> getChildMenus(List<Menu> menuList, Set<Menu> menuSet);

    /**
     * @describe 构建菜单树
     * @param menuDtos 原始数据
     * @return java.util.List<com.love.module.system.service.dto.MenuDto>
     */
    List<MenuDto> buildTree(List<MenuDto> menuDtos);

    /**
     * @describe 构建菜单树
     * @param menuDtos /
     * @return java.lang.Object
     */
    Object buildMenus(List<MenuDto> menuDtos);

    /**
     * @describe 根据ID查询
     * @param id /
     * @return com.love.module.system.domain.Menu
     */
    Menu findOne(Long id);

    /**
     * @describe 删除
     * @param menuSet
     * @return void
     */
    void delete(Set<Menu> menuSet);

    /**
     * @describe 导出
     * @param queryAll 待导出的数据
     * @param response /
     * @return void
     */
    void download(List<MenuDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * @describe 懒加载菜单数据
     * @param pid /
     * @return java.util.List<com.love.module.system.service.dto.MenuDto>
     */
    List<MenuDto> getMenus(Long pid);

    /**
     * @describe 根据ID获取同级与上级数据
     * @param menuDto /
     * @param objects  /
     * @return java.util.List<com.love.module.system.service.dto.MenuDto>
     */
    List<MenuDto> getSuperior(MenuDto menuDto, List<Menu> objects);

    /**
     * @describe 根据当前用户获取菜单
     * @param currentUserId /
     * @return java.util.List<com.love.module.system.service.dto.MenuDto>
     */
    List<MenuDto> findByUser(Long currentUserId);
}
