package com.love.module.system.repository;

import com.love.module.system.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * @ClassName DictRepository
 * @description 字典存储库
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor<Dict> {

    /**
     * @describe 删除
     * @param ids /
     * @return void
     */
    void deleteAllByIdIn(Set<Long> ids);

    /**
     * @describe 查询
     * @param ids /
     * @return java.util.List<com.love.module.system.domain.Dict>
     */
    List<Dict> findByIdIn(Set<Long> ids);
}
