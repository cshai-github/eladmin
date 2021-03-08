package com.love.module.system.service.impl;

import com.love.module.system.domain.Dept;
import com.love.module.system.service.DataService;
import com.love.module.system.service.DeptService;
import com.love.module.system.service.RoleService;
import com.love.module.system.service.dto.RoleSmallDto;
import com.love.module.system.service.dto.UserDto;
import com.love.utils.enums.DataScopeEnum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName DataServiceImpl
 * @Description 数据权限服务实现
 * @Author ocean
 * @CreateDate 2021/3/1
 * @Version 1.0.0
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "data")
public class DataServiceImpl implements DataService {
    private final RoleService roleService;
    private final DeptService deptService;

    /**
     * @description 用户角色改变时需清理缓存
     * @param user /
     * @return {@link List< Long>}
     */
    @Override
    public List<Long> getDeptIds(UserDto user) {
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<RoleSmallDto> roleSet = roleService.findByUsersId(user.getId());
        // 获取对应的部门ID
        for (RoleSmallDto role : roleSet) {
            DataScopeEnum dataScopeEnum = DataScopeEnum.find(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)) {
                case THIS_LEVEL:
                    deptIds.add(user.getDept().getId());
                    break;
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds, role));
                    break;
                default:
                    return new ArrayList<>(deptIds);
            }
        }
        return new ArrayList<>(deptIds);
    }

    /**
     * @description 获取自定义的数据权限
     * @param deptIds 部门ID
     * @param role 角色
     * @return {@link Set< Long>}
     */
    public Set<Long> getCustomize(Set<Long> deptIds, RoleSmallDto role) {
        Set<Dept> depts = deptService.findByRoleId(role.getId());
        for (Dept dept : depts) {
            deptIds.add(dept.getId());
            List<Dept> deptChildren = deptService.findByPid(dept.getId());
            if (deptChildren != null && deptChildren.size() != 0) {
                deptIds.addAll(deptService.getDeptChildren(dept.getId(), deptChildren));
            }
        }
        return deptIds;
    }
}
