package com.test.yourself.authentification.mapper;

public interface Mapper<E,D> {
    D toDto(E entity);
    E toEntity(D dto);
}
