package com.love.module.system.service.mapstruct;

import com.love.base.BaseMapper;
import com.love.module.system.domain.User;
import com.love.module.system.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName UserMapper
 * @Description
 * @Author ocean
 * @CreateDate 2020/12/26
 * @Version 1.0.0
 */
@Mapper(componentModel = "spring", uses = {RoleMapper.class,DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, User> {
}
