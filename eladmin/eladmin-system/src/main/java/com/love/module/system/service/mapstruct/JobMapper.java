package com.love.module.system.service.mapstruct;

import com.love.base.BaseMapper;
import com.love.module.system.domain.Job;
import com.love.module.system.service.dto.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName JobMapper
 * @description
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Mapper(componentModel = "spring", uses = {DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {
}
