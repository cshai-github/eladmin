package com.love.module.system.repository;

import com.love.module.system.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MenuRepository
 * @description 菜单存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

    /**
     * @describe 根据菜单标题查询
     * @param title 菜单标题
     * @return com.love.module.system.domain.Menu
     */
    Menu findByTitle(String title);

    /**
     * @describe 根据组件名称查询
     * @param name 组件名称
     * @return com.love.module.system.domain.Menu
     */
    Menu findByComponentName(String name);

    /**
     * @describe 根据菜单的 PID 查询
     * @param pid /
     * @return java.util.List<com.love.module.system.domain.Menu>
     */
    List<Menu> findByPid(long pid);

    /**
     * @describe 查询顶级菜单
     * @param  /
     * @return java.util.List<com.love.module.system.domain.Menu>
     */
    List<Menu> findByPidIsNull();

    /**
     * @describe 根据角色ID与菜单类型查询菜单
     * @param roleIds roleIDs
     * @param type 类型
     * @return java.util.LinkedHashSet<com.love.module.system.domain.Menu>
     */
    @Query(value = "SELECT m.* FROM sys_menu m, sys_roles_menus r WHERE " +
            "m.menu_id = r.menu_id AND r.role_id IN ?1 AND type != ?2 order by m.menu_sort asc", nativeQuery = true)
    LinkedHashSet<Menu> findByRoleIdsAndTypeNot(Set<Long> roleIds, int type);

    /**
     * @describe 获取节点数量
     * @param id /
     * @return int
     */
    int countByPid(Long id);

    /**
     * @describe 更新节点数目
     * @param count /
     * @param menuId /
     * @return void
     */
    @Modifying
    @Query(value = "update sys_menu set sub_count = ?1 where menu_id = ?2 ", nativeQuery = true)
    void updateSubCntById(int count, Long menuId);
}
