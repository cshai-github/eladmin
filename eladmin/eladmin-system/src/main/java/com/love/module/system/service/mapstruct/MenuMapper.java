package com.love.module.system.service.mapstruct;

import com.love.base.BaseMapper;
import com.love.module.system.domain.Menu;
import com.love.module.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName MenuMapper
 * @description
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {
}
