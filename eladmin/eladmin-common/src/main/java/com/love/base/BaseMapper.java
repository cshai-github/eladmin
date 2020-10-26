package com.love.base;

import java.util.List;

/**
 * @ClassName BaseMapper
 * @description
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
public interface BaseMapper<D, E> {

    /**
     * @describe DTO转Entity
     * @param dto /
     * @return E
     */
    E toEntity(D dto);

    /**
     * @describe Entity转DTO
     * @param entity /
     * @return D
     */
    D toDto(E entity);

    /**
     * @describe DTO集合转Entity集合
     * @param dtoList /
     * @return java.util.List<E>
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * @describe Entity集合转DTO集合
     * @param entityList /
     * @return java.util.List<D>
     */
    List<D> toDtp(List<E> entityList);
}
