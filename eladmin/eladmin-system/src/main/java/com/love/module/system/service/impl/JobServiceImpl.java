package com.love.module.system.service.impl;

import com.love.exception.BadRequestException;
import com.love.exception.EntityExistException;
import com.love.module.system.domain.Job;
import com.love.module.system.repository.JobRepository;
import com.love.module.system.repository.UserRepository;
import com.love.module.system.service.JobService;
import com.love.module.system.service.dto.JobDto;
import com.love.module.system.service.dto.JobQueryCriteria;
import com.love.module.system.service.mapstruct.JobMapper;
import com.love.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName JobServiceImpl
 * @description
 * @author ocean
 * @createDate 2020/10/29
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "job")
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final RedisUtil redisUtil;
    private final UserRepository userRepository;

    @Override
    public JobDto findById(Long id) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Job resources) {
        Job job = jobRepository.findByName(resources.getName());
        if (job != null) {
            throw new EntityExistException(Job.class, "name", resources.getName());
        }
        jobRepository.save(resources);
    }

    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(Job resources) {
        Job job = jobRepository.findById(resources.getId()).orElseGet(Job::new);
        Job old = jobRepository.findByName(resources.getName());
        if (old != null && !old.getId().equals(resources.getId())) {
            throw new EntityExistException(Job.class, "name", resources.getName());
        }
        ValidationUtil.isNull(job.getId(), "Job", "id", resources.getId());
        jobRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        jobRepository.deleteAllByIdIn(ids);
        //删除缓存
        redisUtil.delByKeys("job::id:", ids);
    }

    @Override
    public Map<String, Object> queryAll(JobQueryCriteria criteria, Pageable pageable) {
        Page<Job> page = jobRepository
                .findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(jobMapper::toDto).getContent(), page.getTotalElements());
    }

    @Override
    public List<JobDto> queryAll(JobQueryCriteria criteria) {
        List<Job> list = jobRepository
                .findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
        return jobMapper.toDto(list);
    }

    @Override
    public void download(List<JobDto> jobDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobDto jobDTO : jobDtos) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("岗位名称", jobDTO.getName());
            map.put("岗位状态", jobDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", jobDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public void verification(Set<Long> ids) {
        if (userRepository.countByJobs(ids) > 0) {
            throw new BadRequestException("所选的岗位中存在用户关联，请解除关联再试！");
        }
    }
}
