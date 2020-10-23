package com.love.module.system.repository;

import com.love.module.system.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @ClassName DeptRepository
 * @description 部门存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor<Dept> {

    /**
     * @describe 根据 PID 查询
     * @param id pid
     * @return java.util.List<com.love.module.system.domain.Dept>
     */
    List<Dept> findByPid(Long id);

    /**
     * @describe 获取顶级部门
     * @return java.util.List<com.love.module.system.domain.Dept>
     */
    List<Dept> findByPidIsNull();

    /**
     * @describe 根据角色ID查询
     * @param roleId 角色ID
     * @return java.util.Set<com.love.module.system.domain.Dept>
     */
    @Query(value = "select d.* from sys_dept d, sys_roles_depts r where "+
            "d.dept_id = r.dept_id and r.role_id = ?1", nativeQuery = true)
    Set<Dept> findByRoleId(Long roleId);

    /**
     * @describe 判断是否存在子节点
     * @param pid /
     * @return int
     */
    int countByPid(Long pid);

    /**
     * @describe 根据ID更新sub_count
     * @param count /
	 * @param id /
     * @return void
     */
    @Modifying
    @Query(value = " update sys_dept set sub_count = ?1 where dept_id = ?2 ",nativeQuery = true)
    void updateSubCntById(Integer count, Long id);
}
