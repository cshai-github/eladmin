package com.love.module.system.service.mapstruct;

import com.love.base.BaseMapper;
import com.love.module.system.domain.Role;
import com.love.module.system.service.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName RoleMapper
 * @Description
 * @Author ocean
 * @CreateDate 2020/11/10
 * @Version 1.0.0
 */
@Mapper(componentModel = "spring",uses = {MenuMapper.class,DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {
}
