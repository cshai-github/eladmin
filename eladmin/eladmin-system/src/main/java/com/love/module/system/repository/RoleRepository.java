package com.love.module.system.repository;

import com.love.module.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleRepository
 * @description 角色存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    /**
     * @describe 根据名称查询
     * @param name /
     * @return com.love.module.system.domain.Role
     */
    Role findByName(String name);

    /**
     * @describe 删除多个角色
     * @param ids /
     * @return void
     */
    void deleteAllByIdIn(Set<Long> ids);

    /**
     * @describe 根据用户ID查询
     * @param id 用户ID
     * @return java.util.Set<com.love.module.system.domain.Role>
     */
    @Query(value = "SELECT r.* FROM sys_role r, sys_users_roles u WHERE " +
            "r.role_id = u.role_id AND u.user_id = ?1", nativeQuery = true)
    Set<Role> findByUserId(Long id);

    /**
     * @describe 解绑角色菜单
     * @param id 菜单ID
     * @return void
     */
    @Modifying
    @Query(value = "delete from sys_roles_menus where menu_id = ?1", nativeQuery = true)
    void untiedMenu(Long id);

    /**
     * @describe 根据部门查询
     * @param deptIds /
     * @return int
     */
    @Query(value = "select count(1) from sys_role r, sys_roles_depts d where " +
            "r.role_id = d.role_id and d.dept_id in ?1", nativeQuery = true)
    int countByDepts(Set<Long> deptIds);

    /**
     * @describe 根据菜单Id查询
     * @param menuIds /
     * @return java.util.List<com.love.module.system.domain.Role>
     */
    @Query(value = "SELECT r.* FROM sys_role r, sys_roles_menus m WHERE " +
            "r.role_id = m.role_id AND m.menu_id in ?1", nativeQuery = true)
    List<Role> findInMenuId(List<Long> menuIds);
}
