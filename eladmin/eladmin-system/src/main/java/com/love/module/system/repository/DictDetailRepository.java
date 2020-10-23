package com.love.module.system.repository;

import com.love.module.system.domain.DictDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName DictDetailRepository
 * @description 字典详细存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DictDetailRepository extends JpaRepository<DictDetail, Long>, JpaSpecificationExecutor<DictDetail> {

    /**
     * @describe 根据字典名称查询
     * @param name /
     * @return java.util.List<com.love.module.system.domain.DictDetail>
     */
    List<DictDetail> findByDictName(String name);
}
