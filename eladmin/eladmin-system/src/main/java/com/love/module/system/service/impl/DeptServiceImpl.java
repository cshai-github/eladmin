package com.love.module.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.love.module.system.domain.Dept;
import com.love.module.system.repository.DeptRepository;
import com.love.module.system.service.DeptService;
import com.love.module.system.service.dto.DeptDto;
import com.love.module.system.service.dto.DeptQueryCriteria;
import com.love.module.system.service.mapstruct.DeptMapper;
import com.love.utils.QueryHelp;
import com.love.utils.SecurityUtils;
import com.love.utils.enums.DataScopeEnum;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName DeptServiceImpl
 * @description
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
//@CacheConfig:抽取类中的所有@CachePut@Cacheable@CacheEvict的公共配置
@CacheConfig(cacheNames = "dept")
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;
    private final DeptMapper deptMapper;

    @Override
    public List<DeptDto> queryAll(DeptQueryCriteria criteria, Boolean isQuery) throws Exception {

        Sort sort = Sort.by(Sort.Direction.ASC, "deptSort");
        String dataScopeType = SecurityUtils.getDataScopeType();
        if (isQuery) {
            if (dataScopeType.equals(DataScopeEnum.ALL.getValue())) {
                criteria.setPidIsNull(true);
            }
            List<Field> fields = QueryHelp.getAllFields(criteria.getClass(), new ArrayList<>());
            List<String> fieldName = new ArrayList<String>() {{
                add("pidIsNull");
                add("enabled");
            }};

            for (Field field : fields) {
                //设置对象的访问权限，保证对private的属性的访问
                field.setAccessible(true);
                Object val = field.get(criteria);
                if (fieldName.contains(field.getName())) {
                    continue;
                }
                if (ObjectUtil.isNotNull(val)) {
                    criteria.setPidIsNull(null);
                    break;
                }
            }

        }
        List<DeptDto> list = deptMapper.toDtp(
                deptRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), sort));

        //如果为空，就代表为自定义权限或者本级权限，就需要去重，不理解可以注释掉，看查询结果
        if (StringUtils.isBlank(dataScopeType)) {
            return deduplication(list);
        }
        return list;
    }

    @Override
    public DeptDto findById(Long id) {
        return null;
    }

    @Override
    public void create(Dept resources) {

    }

    @Override
    public void update(Dept resources) {

    }

    @Override
    public void delete(Set<DeptDto> deptDtos) {

    }

    @Override
    public List<Dept> findByPid(long pid) {
        return null;
    }

    @Override
    public Set<Dept> findByRoleId(Long id) {
        return null;
    }

    @Override
    public void download(List<DeptDto> queryAll, HttpServletResponse response) throws IOException {

    }

    @Override
    public Set<DeptDto> getDeleteDepts(List<Dept> deptList, Set<DeptDto> deptDtos) {
        return null;
    }

    @Override
    public List<DeptDto> getSuperior(DeptDto deptDto, List<Dept> depts) {
        return null;
    }

    @Override
    public Object buildTree(List<DeptDto> deptDtos) {
        return null;
    }

    @Override
    public List<Long> getDeptChildren(Long deptId, List<Dept> deptList) {
        return null;
    }

    @Override
    public void verification(Set<DeptDto> deptDtos) {

    }

    private List<DeptDto> deduplication(List<DeptDto> list) {
        List<DeptDto> deptDtos = new ArrayList<>();
        for (DeptDto deptDto : list) {
            boolean flag = true;
            for (DeptDto dto : list) {
                if (dto.getId().equals(deptDto.getPid())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                deptDtos.add(deptDto);
            }
        }
        return deptDtos;
    }
}
