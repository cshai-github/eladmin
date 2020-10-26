package com.love.module.system.service.mapstruct;

import com.love.base.BaseMapper;
import com.love.module.system.domain.Dept;
import com.love.module.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName DeptMapper
 * @description
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {
}
