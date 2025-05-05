package com.example.concurrentpayment.support.base;

import java.util.List;

public interface BaseMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntityList(List<D> dtoList);
    List<D> toDtoList(List<E> entityList);
}
